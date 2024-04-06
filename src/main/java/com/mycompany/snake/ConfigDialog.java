/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author gmd
 */
public class ConfigDialog extends javax.swing.JDialog {

    /**
     * Creates new form ConfigDialog
     */
    public ConfigDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonOK = new javax.swing.JButton();
        characterSelector = new javax.swing.JComboBox<>();
        speedSelector = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SNAKE");
        setMinimumSize(new java.awt.Dimension(251, 127));

        jLabel1.setText("Character");

        jLabel2.setText("Speed");

        jButtonOK.setText("OK");
        jButtonOK.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        characterSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grass Snake", "Sand Worm", "Retro Snake" }));
        characterSelector.setMaximumSize(new java.awt.Dimension(136, 25));
        characterSelector.setMinimumSize(new java.awt.Dimension(136, 25));
        characterSelector.setPreferredSize(new java.awt.Dimension(136, 25));
        characterSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                characterSelectorActionPerformed(evt);
            }
        });

        speedSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Slow", "Normal", "Fast", "Blue Hedgehog" }));
        speedSelector.setMaximumSize(new java.awt.Dimension(136, 25));
        speedSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speedSelectorActionPerformed(evt);
            }
        });

        jButton1.setText("About");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("HTP");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(characterSelector, 0, 155, Short.MAX_VALUE)
                    .addComponent(speedSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jButtonOK))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(characterSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOK))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(speedSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void characterSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_characterSelectorActionPerformed
        JComboBox comboBox = (JComboBox) evt.getSource();
        String option = (String) comboBox.getSelectedItem();
        switch (option) {
            case "Grass Snake":
                ConfigData.setBackground1(new Color(118, 204, 86));
                ConfigData.setBackground2(new Color(94, 180, 68));
                ConfigData.setHeadColor(new Color(79, 111, 156));
                ConfigData.setBodyColor(new Color(79, 121, 181));
                ConfigData.setFoodColor(Color.red);
                ConfigData.setSpecialFoodColor(Color.yellow);
                break;
            case "Sand Worm":
                ConfigData.setBackground1(new Color(210, 170, 88));
                ConfigData.setBackground2(new Color(198, 166, 100));
                ConfigData.setHeadColor(new Color(156, 111, 79));
                ConfigData.setBodyColor(new Color(181, 121, 79));
                ConfigData.setFoodColor(Color.red);
                ConfigData.setSpecialFoodColor(Color.yellow);
                break;
            case "Retro Snake":
                ConfigData.setBackground1(Color.black);
                ConfigData.setBackground2(Color.black);
                ConfigData.setHeadColor(Color.yellow);
                ConfigData.setBodyColor(Color.green);
                ConfigData.setFoodColor(Color.red);
                ConfigData.setSpecialFoodColor(Color.yellow);
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_characterSelectorActionPerformed

    private void speedSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speedSelectorActionPerformed
        JComboBox comboBox = (JComboBox) evt.getSource();
        String option = (String) comboBox.getSelectedItem();
        switch (option) {
            case "Slow":
                ConfigData.getInstance().setDeltaTime(250);
                break;
            case "Normal":
                ConfigData.getInstance().setDeltaTime(200);
                break;
            case "Fast":
                ConfigData.getInstance().setDeltaTime(100);
                break;
            case "Blue Hedgehog":
                ConfigData.getInstance().setDeltaTime(50);
                ConfigData.setHeadColor(new Color(48,97,227));
                ConfigData.setBodyColor(new Color(38,247,253));
                ConfigData.setFoodColor(Color.yellow);
                ConfigData.setSpecialFoodColor(Color.red);
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_speedSelectorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame jFrame = new JFrame();
        AboutDialog aboutDialog = new AboutDialog(jFrame, true);
        aboutDialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFrame jFrame = new JFrame();
        HTPlayDialog hTPlayDialog = new HTPlayDialog(jFrame, true);
        hTPlayDialog.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfigDialog dialog = new ConfigDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> characterSelector;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> speedSelector;
    // End of variables declaration//GEN-END:variables
}
