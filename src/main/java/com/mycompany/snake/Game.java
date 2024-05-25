/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import javax.swing.JDialog;

/**
 *
 * @author gmd
 */
public class Game extends javax.swing.JFrame {
    
    private ConfigDialog configDialog;
    
    public Game() {
        initComponents();
        setLocationRelativeTo(null);
        ConfigDialog configDialog = new ConfigDialog(this, true);
        configDialog.setVisible(true);
        jToolBar1.setBackground(Color.black);
        start();
        board1.requestFocus();
    }
    
    public void start(){
        board1.setTimerText(timerText1);
        timerText1.reset();
        board1.setScoreBoard(scoreBoard1);
        board1.initGame();
        board1.requestFocus();
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        scoreBoard1 = new com.mycompany.snake.ScoreBoard();
        jButtonReset = new javax.swing.JButton();
        timerText1 = new com.mycompany.snake.TimerText();
        board1 = new com.mycompany.snake.Board();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemConfiguration = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemHTPlay = new javax.swing.JMenuItem();
        jMenuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SNAKE");
        setBounds(new java.awt.Rectangle(0, 0, 450, 522));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(187, 187, 187));
        setMinimumSize(new java.awt.Dimension(450, 485));
        setResizable(false);

        jToolBar1.setBackground(new java.awt.Color(0, 0, 0));
        jToolBar1.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorderPainted(false);
        jToolBar1.setMinimumSize(new java.awt.Dimension(120, 34));
        jToolBar1.setName(""); // NOI18N
        jToolBar1.setPreferredSize(new java.awt.Dimension(120, 35));

        scoreBoard1.setBorder(null);
        scoreBoard1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        scoreBoard1.setText("Score: 0");
        scoreBoard1.setMinimumSize(new java.awt.Dimension(100, 30));
        scoreBoard1.setPreferredSize(new java.awt.Dimension(200, 30));
        jToolBar1.add(scoreBoard1);

        jButtonReset.setBackground(new java.awt.Color(0, 0, 0));
        jButtonReset.setBorder(null);
        jButtonReset.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonReset.setIconTextGap(0);
        jButtonReset.setMaximumSize(new java.awt.Dimension(25, 25));
        jButtonReset.setMinimumSize(new java.awt.Dimension(25, 25));
        jButtonReset.setPreferredSize(new java.awt.Dimension(25, 25));
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonReset);

        timerText1.setBorder(null);
        timerText1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        timerText1.setText("Time: 00:00");
        timerText1.setMinimumSize(new java.awt.Dimension(100, 30));
        timerText1.setPreferredSize(new java.awt.Dimension(200, 30));
        jToolBar1.add(timerText1);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(board1, java.awt.BorderLayout.CENTER);

        jMenu2.setText("Edit");

        jMenuItemConfiguration.setText("Configuration");
        jMenuItemConfiguration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConfigurationActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemConfiguration);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("About");

        jMenuItemHTPlay.setText("How to play");
        jMenuItemHTPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHTPlayActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemHTPlay);

        jMenuItemAbout.setText("Info");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemAbout);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        start();
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jMenuItemConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConfigurationActionPerformed
        ConfigDialog configDialog = new ConfigDialog(this, true);
        configDialog.setVisible(true);
        start();
    }//GEN-LAST:event_jMenuItemConfigurationActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
        AboutDialog aboutDialog = new AboutDialog(this, true);
        aboutDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemAboutActionPerformed

    private void jMenuItemHTPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHTPlayActionPerformed
        HTPlayDialog hTPlayDialog = new HTPlayDialog(this, true);
        hTPlayDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemHTPlayActionPerformed

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.snake.Board board1;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemConfiguration;
    private javax.swing.JMenuItem jMenuItemHTPlay;
    private javax.swing.JToolBar jToolBar1;
    private com.mycompany.snake.ScoreBoard scoreBoard1;
    private com.mycompany.snake.TimerText timerText1;
    // End of variables declaration//GEN-END:variables
}
