/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataDados.Dados.Action;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import DataDados.Dados;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jhonatan Santos
 */
public class ServidorSocket extends javax.swing.JFrame {

    private static ServerSocket serverSocket;
    private static Socket socket;
    private static ServidorSocket servidorSocket = null;
    private ObjectOutputStream output;
    Thread servidor = new Thread();
    private Map<String, ObjectOutputStream> mapOnlines = new HashMap<String, ObjectOutputStream>();

    public static ServidorSocket get() {
        if (servidorSocket == null) {
            servidorSocket = new ServidorSocket();
        }
        return servidorSocket;
    }

    public void iniciar() {
        servidor = new Thread(new iniciarServidor());
        servidor.start();

    }

    public void parar() {

    }

    private class iniciarServidor implements Runnable {

        @Override
        public void run() {
            try {
                serverSocket = new ServerSocket(5000);
                System.out.println("Servidor Iniciado com sucesso!");
                while (true) {
                    socket = serverSocket.accept();
                    System.out.println("Servidor aceitou uma conexão!");
                    new Thread(new ListenerSocket(socket)).start();
                }

            } catch (IOException ex) {
                Logger.getLogger(ServidorSocket.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private class ListenerSocket implements Runnable {

        private ObjectOutputStream output;
        private ObjectInputStream input;

        public ListenerSocket(Socket socket) {

            try {
                this.output = new ObjectOutputStream(socket.getOutputStream());
                this.input = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {

            }
        }

        @Override
        public void run() {
            Dados cliente = null;
            try {
                while ((cliente = (Dados) input.readObject()) != null) {
                    Action action = cliente.getAction();

                    if (action.equals(Action.CONECTAR)) {
                        mapOnlines.put(cliente.getNome(), output);
                        getConectar(cliente, output);
                    } else if (action.equals(Action.SSTART)) {
                        getStart(cliente);
                    } else if (action.equals(Action.SJOGO)) {
                        getSjogo(cliente);
                    } else if (action.equals(Action.DESCONECTAR)) {

                    }
                }
            } catch (IOException ex) {

            } catch (ClassNotFoundException ex) {

            }

        }

    }

    public void getConectar(Dados cliente, ObjectOutputStream output) {
        System.out.println("Chegou os Dados!");
        Dados jogador = new Dados();
        int id = Jogo.getJogo().adicionarJogador(cliente.getNome());
        Jogo.getJogo().getListJogadores().get(id).setId(id);
        jogador.setId(id);
        jogador.setAction(Action.CONECTAR);
        jogador.setQtdLinhas(Jogo.getJogo().getQtdLinhas());
        jogador.setQtdColunas(Jogo.getJogo().getQtdColunas());
        jogador.setQtdPosicoes(Jogo.getJogo().getQtdPosicoes());
        jogador.setsJogo(Jogo.getJogo().getListJogadores().get(id).getStatusJogo());
        jogador.setnCruzados(Jogo.getJogo().getListNavios().get(0).retornaNavio());
        jogador.setnDestroyers(Jogo.getJogo().getListNavios().get(1).retornaNavio());
        jogador.setnPortas(Jogo.getJogo().getListNavios().get(2).retornaNavio());
        setConectar(jogador, output);
        setAtualizarJogadores();
    }

    public void getStart(Dados jogadores) {
        int aux = 0;
        Jogo.getJogo().getListJogadores().get(jogadores.getId()).setStart(jogadores.getsStart());
        for (int i = 0; i < Jogo.getJogo().getListJogadores().size(); i++) {
            if (Jogo.getJogo().getListJogadores().get(i).getStart() == true) {
                aux++;
                if (aux == Jogo.getJogo().getListJogadores().size()) {
                    setStart();
                    setSjogo();
                    break;
                }
            }
        }
        setAtualizarJogadores();

    }

    public void getSjogo(Dados jogador) {
        Jogo.getJogo().getStatusJogo(jogador.getId());
        Jogo.getJogo().setPosicoesPreenchidas(String.valueOf(jogador.getPosicaoTiro()));
        setAtualizarJogo();
        setSjogo();
    }

    public void setConectar(Dados jogador, ObjectOutputStream output) {
        try {
            output.writeObject(jogador);
        } catch (IOException ex) {
            Logger.getLogger(ServidorSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setStart() {
        Dados jogadores = new Dados();
        jogadores.setAction(Action.INICIAR_JOGO);
        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet()) {
            if (!kv.getKey().equals(jogadores.getNome())) {
                try {
                    kv.getValue().writeObject(jogadores);
                } catch (IOException ex) {
                    Logger.getLogger(ServidorSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void setSjogo() {
        Dados jogadores = new Dados();
        jogadores.setAction(Action.SJOGO);
        jogadores.setsJogo(true);
        for (int i = 0; i < Jogo.getJogo().getListJogadores().size(); i++) {
            if (Jogo.getJogo().getListJogadores().get(i).getStatusJogo()) {
                jogadores.setNome(Jogo.getJogo().getListJogadores().get(i).getNome());
                break;
            }
        }
        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet()) {
            if (kv.getKey().equals(jogadores.getNome())) {
                try {
                    kv.getValue().writeObject(jogadores);
                } catch (IOException ex) {
                    Logger.getLogger(ServidorSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void setAtualizarJogadores() {
        Dados jogadores = new Dados();
        for (int i = 0; i < Jogo.getJogo().getListJogadores().size(); i++) {
            jogadores.setListJogadores(Jogo.getJogo().getListJogadores().get(i).getNome());
            if (Jogo.getJogo().getListJogadores().get(i).getStart()) {
                jogadores.setStatusJogadores("  [ Pronto ]");
            } else {
                jogadores.setStatusJogadores("  [Preparando]");
            }
        }
        jogadores.setAction(Action.ATUALIZAR_JOGADORES);

        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet()) {
            if (!kv.getKey().equals(jogadores.getNome())) {
                try {
                    kv.getValue().writeObject(jogadores);
                } catch (IOException ex) {
                    Logger.getLogger(ServidorSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void setAtualizarJogo() {
        Dados jogadorAtualizar = new Dados();
        jogadorAtualizar.setAction(Action.ATUALIZAR_JOGO);
        for (int i = 0; i < Jogo.getJogo().getPosicoesPreenchidas().size(); i++) {
            jogadorAtualizar.setPosicoes(Jogo.getJogo().getPosicoesPreenchidas().get(i) + ";");
        }
        jogadorAtualizar.setPosicoesPreenchidas(Jogo.getJogo().getPosicoesPreenchidas());
        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet()) {
            if (!kv.getKey().equals(jogadorAtualizar.getNome())) {
                try {
                    kv.getValue().writeObject(jogadorAtualizar);
                } catch (IOException ex) {
                    Logger.getLogger(ServidorSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void getDesconectar(Dados cliente) {

    }

    public void setDesconectar() {

    }

}
