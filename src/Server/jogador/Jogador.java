/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.jogador;

import java.util.ArrayList;

/**
 *
 * @author Jhonatan Santos
 */
public interface Jogador {
    
    public void setNome(String nome);
    public String getNome();
    public void setPontos(int pontos);
    public int getPontos();
    public void setQtdErros(int qtdErros);
    public int getQtdErros();
    public void setQtdAcertos(int qtdAcertos);
    public int getQtdAcertos();
    public boolean getStatusJogo();
    public void setStatusJogo(boolean status);
    public void setTiros(int tiro);
    public ArrayList<Integer> getTiros();
    public void setId(int id);
    public int getId();
    public boolean getStart();
    public void setStart(boolean status);
    
    
    
    
}
