/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.navio;

import java.util.ArrayList;

/**
 *
 * @author diogo
 */
public interface Navio {

    public void adicionarNavio(int posicao);
    public ArrayList<Integer> retornaNavio();
    public void setQtdNavio(int qtd);
    public int getQtdNavio();
    public String descricao();
    public int pontoNavio();
    public int removeNavio(int posicao);

}
