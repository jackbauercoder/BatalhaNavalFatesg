/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import DataDados.Dados;
import MaquinaVirtual.Maquina;
import Server.Jogo;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jhonatan Santos
 */
public class ClienteJogo_Tela extends javax.swing.JFrame implements ActionListener {
    
    JButton[] Botoes;

    //Metodo Singleton
    private static ClienteJogo_Tela clienteJogo_Tela = null;

    //Metodo Singleton
    public static ClienteJogo_Tela get() {
        if (clienteJogo_Tela == null) {
            clienteJogo_Tela = new ClienteJogo_Tela();
        }
        return clienteJogo_Tela;
    }
    
    public ClienteJogo_Tela() {
        
        initComponents();
        iniciarTabuleiro();
        setLocationRelativeTo(null);
        
    }

    //Criando Botoes no Tabuleiro
    public JButton[] criarBotoes() {
        return new JButton[ClienteDados.get().getPosicoesTabuleiro()];
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prin = new javax.swing.JPanel();
        painel = new javax.swing.JPanel();
        jLabelPontos = new javax.swing.JLabel();
        jLabelAcertos = new javax.swing.JLabel();
        jLabelErros = new javax.swing.JLabel();
        jPanelJogadores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListJogadores = new javax.swing.JList<>();
        grid = new javax.swing.JPanel();
        jLabelInformacoes = new javax.swing.JLabel();
        jPanelStatus = new javax.swing.JPanel();
        jLabelStatus = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Batalha Naval Senai");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        prin.setBackground(new java.awt.Color(255, 255, 255));
        prin.setPreferredSize(new java.awt.Dimension(629, 614));

        painel.setBackground(new java.awt.Color(255, 255, 255));
        painel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPontos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPontos.setForeground(new java.awt.Color(0, 0, 204));
        jLabelPontos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPontos.setText("0");
        jLabelPontos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 4), "Pontos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabelAcertos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelAcertos.setForeground(new java.awt.Color(0, 170, 23));
        jLabelAcertos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAcertos.setText("0");
        jLabelAcertos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 148, 37), 2), "Acertos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 10), new java.awt.Color(0, 188, 30))); // NOI18N

        jLabelErros.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelErros.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelErros.setText("0");
        jLabelErros.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2), "Erros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 10), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabelAcertos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(jLabelPontos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(jLabelErros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(68, 68, 68))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabelPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabelErros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAcertos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelJogadores.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Jogadores", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jListJogadores.setBackground(new java.awt.Color(204, 255, 255));
        jListJogadores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane1.setViewportView(jListJogadores);

        javax.swing.GroupLayout jPanelJogadoresLayout = new javax.swing.GroupLayout(jPanelJogadores);
        jPanelJogadores.setLayout(jPanelJogadoresLayout);
        jPanelJogadoresLayout.setHorizontalGroup(
            jPanelJogadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJogadoresLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
        );
        jPanelJogadoresLayout.setVerticalGroup(
            jPanelJogadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJogadoresLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 106, Short.MAX_VALUE))
        );

        grid.setBackground(new java.awt.Color(255, 255, 255));
        grid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout gridLayout = new javax.swing.GroupLayout(grid);
        grid.setLayout(gridLayout);
        gridLayout.setHorizontalGroup(
            gridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );
        gridLayout.setVerticalGroup(
            gridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jLabelInformacoes.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInformacoes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelInformacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInformacoes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Informações", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jPanelStatus.setBackground(new java.awt.Color(255, 153, 0));
        jPanelStatus.setLayout(null);

        jLabelStatus.setBackground(new java.awt.Color(255, 255, 255));
        jLabelStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatus.setText("Aguarde");
        jPanelStatus.add(jLabelStatus);
        jLabelStatus.setBounds(3, 3, 100, 70);

        javax.swing.GroupLayout prinLayout = new javax.swing.GroupLayout(prin);
        prin.setLayout(prinLayout);
        prinLayout.setHorizontalGroup(
            prinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prinLayout.createSequentialGroup()
                .addGroup(prinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelJogadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(prinLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))
                .addGroup(prinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(prinLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(prinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(prinLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(grid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        prinLayout.setVerticalGroup(
            prinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prinLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(prinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, prinLayout.createSequentialGroup()
                        .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabelInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(prinLayout.createSequentialGroup()
                        .addComponent(jPanelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGroup(prinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelJogadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(prinLayout.createSequentialGroup()
                        .addComponent(grid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prin, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(prin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened
    
    public void iniciarTabuleiro() {
        int auxLinha = 0, auxColuna = 0, tamanho = 0;
        if (ClienteDados.get().getQtdLinhas() <= 14 && ClienteDados.get().getQtdColunas() <= 29) {
            int calc = ((ClienteDados.get().getQtdLinhas() * 40) + 180);
            int calc2 = ((ClienteDados.get().getQtdColunas() * 40) + 190);
            tamanho = 40;
            auxLinha = calc;
            auxColuna = calc2;
        } else {
            int calc = ((ClienteDados.get().getQtdLinhas() * 30) + 180);
            int calc2 = ((ClienteDados.get().getQtdColunas() * 30) + 190);
            tamanho = 30;
            auxLinha = calc;
            auxColuna = calc2;
        }
        
        setSize(auxColuna, auxLinha);
        prin.setSize(auxColuna, auxLinha);
        grid.setLayout(new GridLayout(ClienteDados.get().getQtdLinhas(), ClienteDados.get().getQtdColunas(), 2, 2));
        Botoes = criarBotoes();
        for (int posicao = 0; posicao < ClienteDados.get().getPosicoesTabuleiro(); posicao++) {
            Botoes[posicao] = new JButton("");
            Botoes[posicao].setPreferredSize(new Dimension(tamanho, tamanho));
            Botoes[posicao].setIcon(new ImageIcon(ClienteJogo_Tela.class.getResource("/Imgs/mar.png")));
            Botoes[posicao].addActionListener(this);
            grid.add(Botoes[posicao]);
        }
        String[] listJogadores = new String[ClienteDados.get().getListJogadores().size()];
        for (int i = 0; i < ClienteDados.get().getListJogadores().size(); i++) {
            listJogadores[i] = ClienteDados.get().getListJogadores().get(i);
        }
        jListJogadores.setListData(listJogadores);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (ClienteDados.get().getsJogo()) {
            for (int posicao = 0; posicao < ClienteDados.get().getPosicoesTabuleiro(); posicao++) {
                if (e.getSource() == Botoes[posicao]) {
                    if (ClienteDados.get().getnCruzados().contains(posicao)) {
                        Botoes[posicao].setIcon(new ImageIcon(ClienteJogo_Tela.class.getResource("/Imgs/Cruzador.jpg")));
                        ClienteDados.get().setPontos(10);
                        ClienteDados.get().setAcertos(1);
                        ClienteDados.get().setPosicoesAtiradas(posicao);
                        ClienteDados.get().setPosicaoTiro(posicao);
                        setJogador();
                        atualizarStatusJogador(false);
                        jLabelInformacoes.setText("Parabéns você acertou um cruzador +10 pontos! :)");
                        
                    } else if (ClienteDados.get().getnDestroyers().contains(posicao)) {
                        Botoes[posicao].setIcon(new ImageIcon(ClienteJogo_Tela.class.getResource("/Imgs/Destroier.jpg")));
                        ClienteDados.get().setPontos(5);
                        ClienteDados.get().setAcertos(1);
                        ClienteDados.get().setPosicoesAtiradas(posicao);
                        ClienteDados.get().setPosicaoTiro(posicao);
                        setJogador();
                        atualizarStatusJogador(false);
                        jLabelInformacoes.setText("Parabéns você acertou um destroyer +5 pontos! :)");
                        
                    } else if (ClienteDados.get().getnPortas().contains(posicao)) { //Se posição contem navio Porta Avioes mostra...
                        Botoes[posicao].setIcon(new ImageIcon(ClienteJogo_Tela.class.getResource("/Imgs/Porta-Aviao.jpg")));
                        ClienteDados.get().setPontos(10);
                        ClienteDados.get().setAcertos(1);
                        ClienteDados.get().setPosicoesAtiradas(posicao);
                        ClienteDados.get().setPosicaoTiro(posicao);
                        setJogador();
                        atualizarStatusJogador(false);
                        jLabelInformacoes.setText("Parabéns você acertou um porta-avião +10 pontos! :)");
                        
                    } else {
                        Botoes[posicao].setIcon(new ImageIcon(ClienteJogo_Tela.class.getResource("/Imgs/explosao.jpg")));
                        ClienteDados.get().setErros(1);
                        ClienteDados.get().setPosicoesAtiradas(posicao);
                        ClienteDados.get().setPosicaoTiro(posicao);
                        setJogador();
                        atualizarStatusJogador(false);
                        jLabelInformacoes.setText("Que pena você erro o alvo! :(");
                    }
                }
            }
            jLabelPontos.setText(String.valueOf(ClienteDados.get().getPontos()));
            jLabelAcertos.setText(String.valueOf(ClienteDados.get().getAcertos()));
            jLabelErros.setText(String.valueOf(ClienteDados.get().getErros()));
        } else {
            jLabelInformacoes.setText("Aguarde sua vez de jogar! :(");
        }
    }
    
    public void atualizarTabuleiro() {
        for (int i = 0; i < ClienteDados.get().getPosicoesPreenchidas().size(); i++) {
            if (!ClienteDados.get().getPosicoesPreenchidas().contains(ClienteDados.get().getPosicoesAtiradas())) {
                Botoes[Integer.parseInt(ClienteDados.get().getPosicoesPreenchidas().get(i))].setIcon(new ImageIcon(ClienteJogo_Tela.class
                        .getResource("/Imgs/preenchido.jpg")));
            }
        }
    }
    
    public void atualizarStatusJogador(boolean x) {
        ClienteDados.get().setsJogo(x);
        if (x) {
            jLabelStatus.setText("Sua vez!");
            jPanelStatus.setBackground(Color.GREEN);
            
        } else {
            jLabelStatus.setText("Aguarde!");
            jPanelStatus.setBackground(Color.ORANGE);
        }
    }
    
    public void setJogador() {
        ClienteDados.get().setsJogo(false);
        Dados jogador = new Dados();
        jogador.setAction(Dados.Action.SJOGO);
        jogador.setPosicaoTiro(ClienteDados.get().getPosicaoTiro());
        jogador.setId(ClienteDados.get().getId());
        ClienteServidor.get().setAtualizarJogo(jogador);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel grid;
    private javax.swing.JLabel jLabelAcertos;
    private javax.swing.JLabel jLabelErros;
    private javax.swing.JLabel jLabelInformacoes;
    private javax.swing.JLabel jLabelPontos;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JList<String> jListJogadores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelJogadores;
    private javax.swing.JPanel jPanelStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painel;
    private javax.swing.JPanel prin;
    // End of variables declaration//GEN-END:variables
}
