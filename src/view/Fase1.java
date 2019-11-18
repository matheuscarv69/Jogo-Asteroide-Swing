/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.media.jfxmedia.AudioClip;
import control.Metricas;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import model.Asteroides;
import model.Bullets;
import model.nave;
import threads.ThreadPrincipal;

/**
 *
 * @author mathe
 */
public class Fase1 extends javax.swing.JFrame {

    /**
     * Creates new form Fase1
     */
    nave nave;
    Bullets tiro;
    Asteroides ast;

    ThreadPrincipal thread;

    public Fase1() {
        initComponents();

        gerarNave();
        gerarAst();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFase1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelNumScore = new javax.swing.JLabel();
        jLabelLifes = new javax.swing.JLabel();
        jLabelNumLifes = new javax.swing.JLabel();
        jLabelSpeedFase = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asteroids");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/IconGame.png")).getImage());
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanelFase1.setBackground(new java.awt.Color(120, 65, 147));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Score: ");

        jLabelNumScore.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabelNumScore.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumScore.setText("0");

        jLabelLifes.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabelLifes.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLifes.setText("Lifes:");

        jLabelNumLifes.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabelNumLifes.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumLifes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNumLifes.setText("3");

        jLabelSpeedFase.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabelSpeedFase.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSpeedFase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSpeedFase.setText("Nível 1");

        javax.swing.GroupLayout jPanelFase1Layout = new javax.swing.GroupLayout(jPanelFase1);
        jPanelFase1.setLayout(jPanelFase1Layout);
        jPanelFase1Layout.setHorizontalGroup(
            jPanelFase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFase1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelLifes)
                .addGap(18, 18, 18)
                .addComponent(jLabelNumLifes)
                .addGap(112, 112, 112)
                .addComponent(jLabelSpeedFase, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNumScore, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanelFase1Layout.setVerticalGroup(
            jPanelFase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFase1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNumScore)
                    .addComponent(jLabelLifes)
                    .addComponent(jLabelNumLifes)
                    .addComponent(jLabelSpeedFase))
                .addContainerGap(372, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFase1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFase1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gerarNave() {
        nave = new nave(280, 330);
        jPanelFase1.add(nave);
    }

    private void gerarTiro() {
        int a = nave.getX() + 20;
        int b = nave.getY() - 13;

        tiro = new Bullets(a, b);
        jPanelFase1.add(tiro);

        // Fazer testes desses metodos
        //jPanelFase1.validate();
        //jPanelFase1.repaint();
        // Funcao de movimentacao do tiro 
        thread.getTiro(tiro);
    }

    private void gerarAst() {
        new Thread() {
            @Override
            public void run() {
                while (Metricas.inGame) {
                    Random random = new Random();
                    int low = -30;
                    int hight = 0;
                    int right = 540;
                    int left = -10;

                    int x = random.nextInt(right - left) + left;
                    int y = random.nextInt(hight - low) + low;

                    ast = new Asteroides(x, y);

                    jPanelFase1.add(ast);
                    // fazer teste com esses metodos
                    jPanelFase1.validate();
                    jPanelFase1.repaint();

                    // Funcao de movimentacao do asteroide
                    thread = new ThreadPrincipal(nave, ast, jPanelFase1, jLabelNumScore, jLabelNumLifes, jLabelSpeedFase);

                    // Aumenta a velocidade de geração dos asteroides
                    niveis();
                    
                    /*
                    if (Metricas.time == 1200) {
                        geraJoptionPane();
                        stop();
                    }
                    */
                    // Verifica se a qunatidade de vidas acabou
                    if (Metricas.lifes == 0) {
                        stop();
                    }

                    //System.out.println("time: " + Metricas.time);
                    try {
                        Thread.sleep(Metricas.time);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    jPanelFase1.updateUI();
                }
            }
        }.start();
    }

    public synchronized void niveis() {
        if (Metricas.score >= 70 && Metricas.score <= 150) {
            Metricas.time -= 30;
            System.out.println("time: " + Metricas.time);
            jLabelSpeedFase.setText("Nível 2");
        } else if (Metricas.score >= 300 && Metricas.score <= 450) {
            Metricas.time -= 60;
            //jLabelSpeedFase.setText(String.valueOf(Metricas.time));
            System.out.println("time: " + Metricas.time);
            jLabelSpeedFase.setText("Nível 3");
        } else if (Metricas.score >= 500 && Metricas.score <= 600) {
            Metricas.time -= 80;
            //jLabelSpeedFase.setText(String.valueOf(Metricas.time));
            System.out.println("time: " + Metricas.time);
            jLabelSpeedFase.setText("Nível 3");
        } else if (Metricas.score >= 670 && Metricas.score <= 750) {
            Metricas.time -= 10;
            System.out.println("time: " + Metricas.time);
            jLabelSpeedFase.setText("Nível 4");
        } else if (Metricas.score >= 800) {
            Metricas.time = 1200;
            System.out.println("time: " + Metricas.time);
            // Pensar numa forma de encerrar fase
            jLabelSpeedFase.setText("Escapou");
        }
    }

    public void geraJoptionPane() {
        Icon figura = new javax.swing.ImageIcon(getClass().getResource("/images/facepalm2.png"));
        JOptionPane.showMessageDialog(null, "Parabéns! Você terminou o beta, sua pontuação foi: " + Metricas.score, "Acabou :(", JOptionPane.PLAIN_MESSAGE, figura);

    }

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:

        // andar Esquerda 
        if (evt.getKeyChar() == 'a' || evt.getKeyChar() == 'A') {
            nave.andarEsquerda();
            nave.verEsquerda();

        }
        // andar Direita 
        if (evt.getKeyChar() == 'd' || evt.getKeyChar() == 'D') {
            nave.andarDireita();
            nave.verDireita();
        }
        // tiro
        if (evt.getKeyChar() == 'k' || evt.getKeyChar() == 'K') {
            gerarTiro();
        }
        // pause
        if (evt.getKeyChar() == 'p' || evt.getKeyChar() == 'P') {
            //Metricas.inGame = false;
            //thread.stop();
        }
        // retorna a execucao da thread
        if (evt.getKeyChar() == 'o' || evt.getKeyChar() == 'O') {
            // Metricas.inGame = true;
            // thread.resume();
        }


    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fase1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fase1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fase1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fase1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fase1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLifes;
    private javax.swing.JLabel jLabelNumLifes;
    private javax.swing.JLabel jLabelNumScore;
    private javax.swing.JLabel jLabelSpeedFase;
    private javax.swing.JPanel jPanelFase1;
    // End of variables declaration//GEN-END:variables

}
