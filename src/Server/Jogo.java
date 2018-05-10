/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import MaquinaVirtual.Maquina;
import Server.jogador.Jogadores;
import Server.navio.PortaAviao;
import Server.navio.Destroyer;
import Server.navio.Cruzador;
import java.util.ArrayList;
import java.util.Random;
import Server.navio.Navio;

/**
 *
 *
 * @author Jhonatan.Santos
 */
public class Jogo {

    Maquina jogador = new Maquina();
    private ArrayList<Jogadores> listJogadores = new ArrayList<Jogadores>();
    private ArrayList<Navio> listNavios = new ArrayList<Navio>();
    private ArrayList<String> posicoesPreenchidas = new ArrayList<String>();
    private boolean finaly = false;

    public boolean isFinaly() {
        return finaly;
    }

    public void setFinaly(boolean finaly) {
        this.finaly = finaly;
    }

   

    public ArrayList<String> getPosicoesPreenchidas() {
        return posicoesPreenchidas;
    }

    public void setPosicoesPreenchidas(String tiro) {
        this.posicoesPreenchidas.add(tiro);
        if (posicoesPreenchidas.size() >= getQtdPosicoes()) {
            setFinaly(true);
        }
    }
    private int qtdPosicoes = 0, qtdLinhas, qtdColunas;

    public int getQtdLinhas() {
        return qtdLinhas;
    }

    public void setQtdLinhas(int qtdLinhas) {
        this.qtdLinhas = qtdLinhas;
    }

    public int getQtdColunas() {
        return qtdColunas;
    }

    public void setQtdColunas(int qtdColunas) {
        this.qtdColunas = qtdColunas;
    }
    //Instância unica - controlador
    private static Jogo serverJogo = null;

    // Metodo estatico para obter instancia da classe
    public static Jogo getJogo() {
        if (serverJogo == null) {
            serverJogo = new Jogo();
        }
        return serverJogo;
    }

    public ArrayList<Jogadores> getListJogadores() {
        return listJogadores;
    }

    public ArrayList<Navio> getListNavios() {
        return listNavios;
    }

    public int getQtdPosicoes() {
        return qtdPosicoes;
    }

    public void setQtdPosicoes(int qtdPosicoes) {
        this.qtdPosicoes = qtdPosicoes;
    }

    public void iniciarJogo(int linhas, int colunas) throws Exception {
        if (linhas < 10 || colunas < 10 || linhas > 19 || colunas > 38) {
            throw new Exception("erro");
        }
        qtdLinhas = linhas;
        qtdColunas = colunas;
        qtdPosicoes = linhas * colunas;
        listNavios.add(new Cruzador());
        listNavios.add(new Destroyer());
        listNavios.add(new PortaAviao());

        listNavios.get(0).setQtdNavio((qtdPosicoes * 10) / 100);
        listNavios.get(1).setQtdNavio((qtdPosicoes * 20) / 100);
        listNavios.get(2).setQtdNavio((qtdPosicoes * 10) / 100);
        System.out.println("");
        Random random = new Random();

        //Random nos Navios Cruzados
        for (int i = 1; i <= listNavios.get(0).getQtdNavio(); i++) {
            while (true) {
                int x = random.nextInt(qtdPosicoes);
                if (listNavios.get(0).retornaNavio().contains(x)) {
                } else {
                    listNavios.get(0).adicionarNavio(x);
                    break;
                }
            }
        }
        //Random nos Navios Destroiers
        for (int l = 1; l <= listNavios.get(1).getQtdNavio(); l++) {
            while (true) {
                int x = random.nextInt(qtdPosicoes);
                if (listNavios.get(0).retornaNavio().contains(x) || listNavios.get(1).retornaNavio().contains(x)) {
                } else {
                    listNavios.get(1).adicionarNavio(x);
                    break;
                }
            }
        }
        //Random nos Navios Porta Avioes
        for (int y = 1; y <= listNavios.get(2).getQtdNavio(); y++) {
            while (true) {
                int x = random.nextInt(qtdPosicoes);
                if (listNavios.get(0).retornaNavio().contains(x) || listNavios.get(1).retornaNavio().contains(x) || listNavios.get(2).retornaNavio().contains(x)) {
                } else {
                    listNavios.get(2).adicionarNavio(x);
                    break;
                }
            }
        }
    }

    public int adicionarJogador(String nome) {
        if (listJogadores.size() == 0) {
            listJogadores.add(new Jogadores());
            listJogadores.get(listJogadores.size() - 1).setNome(nome);
            listJogadores.get(0).setStatusJogo(true);
        } else {
            listJogadores.add(new Jogadores());
            listJogadores.get(listJogadores.size() - 1).setNome(nome);
        }

        return listJogadores.size() - 1;
    }

    public void getStatusJogo(int id) {
        if (id == listJogadores.size() - 1) {
            listJogadores.get(id).setStatusJogo(false);
            listJogadores.get(0).setStatusJogo(true);
        } else {
            listJogadores.get(id).setStatusJogo(false);
            listJogadores.get(id + 1).setStatusJogo(true);
        }
    }

    public void maquinaVirtual(int x) {
        switch (x) {
            case 1:
                ;
                adicionarJogador("Maquina");
                Jogo.getJogo().listJogadores.get(0).setId(1);
                break;
            case 2:
                jogador.atirar();
                break;
            default:
                break;
        }

    }

}
