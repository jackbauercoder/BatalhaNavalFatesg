/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.util.ArrayList;

/**
 *
 * @author Jhonatan Santos
 */
public class ClienteDados {

    //Informações do Jogo
    private ArrayList<String> listJogadores = new ArrayList<String>();
    private ArrayList<String> statusJogadores = new ArrayList<String>();
    private ArrayList<Integer> posicoesPreenchidas = new ArrayList<Integer>();
    private ArrayList<Integer> posicoesAtiradas = new ArrayList<Integer>();
    private ArrayList<Integer> nCruzados = new ArrayList<Integer>();
    private ArrayList<Integer> nDestroyers = new ArrayList<Integer>();
    private ArrayList<Integer> nPortas = new ArrayList<Integer>();
    //Informações do Jogador
    private int pontos, acertos, erros, id, posicaoTiro, qtdLinhas, qtdColunas, ip,posicoesTabuleiro;
    private Action action;
    private String nome,posicoes = "";
    private boolean sJogo, sStart;
    //Metodo Singleton
    private static ClienteDados clienteDados = null;

    //Metodo Singleton
    public static ClienteDados get() {
        if (clienteDados == null) {
            clienteDados = new ClienteDados();
        }
        return clienteDados;
    }

    public String getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(String posicoes) {
        this.posicoes = posicoes;
    }

    public ArrayList<String> getStatusJogadores() {
        return statusJogadores;
    }

    public void setStatusJogadores(ArrayList<String> statusJogadores) {
        this.statusJogadores = statusJogadores;
    }

    public ArrayList<Integer> getPosicoesAtiradas() {
        return posicoesAtiradas;
    }

    public void setPosicoesAtiradas(int posicao) {
        this.posicoesAtiradas.add(posicao);
    }

    public int getPosicoesTabuleiro() {
        return posicoesTabuleiro;
    }

    public void setPosicoesTabuleiro(int posicoesTabuleiro) {
        this.posicoesTabuleiro = posicoesTabuleiro;
    }

    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

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

    public ArrayList<String> getListJogadores() {
        return listJogadores;
    }

    public void setListJogadores(ArrayList<String> listJogadores) {
        this.listJogadores = listJogadores;
    }

    public ArrayList<Integer> getPosicoesPreenchidas() {
        return posicoesPreenchidas;
    }

    public void setPosicoesPreenchidas(int posicao) {
        this.posicoesPreenchidas.add(posicao);
    }

    
   

    public ArrayList<Integer> getnCruzados() {
        return nCruzados;
    }

    public void setnCruzados(ArrayList<Integer> nCruzados) {
        this.nCruzados = nCruzados;
    }

    public ArrayList<Integer> getnDestroyers() {
        return nDestroyers;
    }

    public void setnDestroyers(ArrayList<Integer> nDestroyers) {
        this.nDestroyers = nDestroyers;
    }

    public ArrayList<Integer> getnPortas() {
        return nPortas;
    }

    public void setnPortas(ArrayList<Integer> nPortas) {
        this.nPortas = nPortas;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos+= pontos;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos+= acertos;
    }

    public int getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros+= erros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosicaoTiro() {
        return posicaoTiro;
    }

    public void setPosicaoTiro(int posicaoTiro) {
        this.posicaoTiro = posicaoTiro;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getsJogo() {
        return sJogo;
    }

    public void setsJogo(boolean sJogo) {
        this.sJogo = sJogo;
    }

    public boolean getsStart() {
        return sStart;
    }

    public void setsStart(boolean sStart) {
        this.sStart = sStart;
    }

    public enum Action {
        CONECTAR, DESCONECTAR, SSTART, SJOGO, ATUALIZAR_JOGADORES, ATUALIZAR_JOGO
    }
}
