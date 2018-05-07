package MaquinaVirtual;

import Server.Jogo;
import Server.ServidorSocket;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonatan Santos
 */
public class Maquina {

    Random random = new Random();

    public void atirar() {
        while (true) {
            int aux = random.nextInt(Jogo.getJogo().getQtdPosicoes());
            if (!Jogo.getJogo().getListJogadores().get(0).getTiros().contains(aux)) {
                if (!Jogo.getJogo().getListJogadores().get(1).getTiros().contains(aux)) {
                    if (Jogo.getJogo().getListNavios().get(0).retornaNavio().contains(aux)) {
                        Jogo.getJogo().getListNavios().get(0).removeNavio(aux);
                        Jogo.getJogo().getListJogadores().get(0).setPontos(10);
                        Jogo.getJogo().getListJogadores().get(0).setQtdAcertos(1);
                        Jogo.getJogo().getListJogadores().get(0).setTiros(aux);
                        break;
                    } else if (Jogo.getJogo().getListNavios().get(1).retornaNavio().contains(aux)) {
                        Jogo.getJogo().getListNavios().get(1).removeNavio(aux);
                        Jogo.getJogo().getListJogadores().get(0).setPontos(5);
                        Jogo.getJogo().getListJogadores().get(0).setQtdAcertos(1);
                        Jogo.getJogo().getListJogadores().get(0).setTiros(aux);
                        break;
                    } else if (Jogo.getJogo().getListNavios().get(2).retornaNavio().contains(aux)) {
                        Jogo.getJogo().getListNavios().get(2).removeNavio(aux);
                        Jogo.getJogo().getListJogadores().get(0).setPontos(10);
                        Jogo.getJogo().getListJogadores().get(0).setQtdAcertos(1);
                        Jogo.getJogo().getListJogadores().get(0).setTiros(aux);
                        break;
                    } else {
                        Jogo.getJogo().getListJogadores().get(0).setTiros(aux);
                        Jogo.getJogo().getListJogadores().get(0).setQtdErros(1);
                        break;
                    }
                }
            }
        }
    }
}
