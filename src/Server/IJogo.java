/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Server.jogador.Jogadores;
import Server.navio.Navio;
import java.util.ArrayList;

/**
 *
 * @author diogo
 */
public interface IJogo {
    public ArrayList<Jogadores> getListJogadores();
    public ArrayList<Navio> getListNavios();
    public int getQtdPosicoes();
    public void setQtdPosicoes(int qtdPosicoes);
    public void iniciarJogo(int tamanho)  throws Exception;
}
