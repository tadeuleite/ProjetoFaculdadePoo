/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Deletar;

import classesBasicas.Comida;
import negocio.NegocioComida;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thade
 */
public class DeletarComida extends javax.swing.JFrame {

    /**
     * Creates new form DeletarComida
     */
    public DeletarComida() {
        initComponents();
        setLocationRelativeTo(null);
        /* 
        
         */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelSelecionar = new javax.swing.JLabel();
        jComboBoxComidas = new javax.swing.JComboBox<>();
        jButtonDeletar = new javax.swing.JButton();
        jTextFieldProcurar = new javax.swing.JTextField();
        jButtonListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Deletar Comida");

        jLabelTitulo.setText("Deletar Comida");

        jLabelSelecionar.setText("Escolha qual comida você deseja deletar do sistema");

        jComboBoxComidas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        jButtonDeletar.setText("Deletar");
        jButtonDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarActionPerformed(evt);
            }
        });

        jTextFieldProcurar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldProcurarKeyTyped(evt);
            }
        });

        jButtonListar.setText("Listar Todos");
        jButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelSelecionar)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxComidas, 0, 90, Short.MAX_VALUE)
                            .addComponent(jTextFieldProcurar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonDeletar)
                            .addComponent(jButtonListar)))
                    .addComponent(jLabelTitulo))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSelecionar)
                    .addComponent(jTextFieldProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxComidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonListar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarActionPerformed
        NegocioComida com = new NegocioComida();
        jComboBoxComidas.removeAllItems();
        try {
            ArrayList<Comida> c = com.listarComida();
            for (Comida c1 : c) {
                jComboBoxComidas.addItem(c1.getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonListarActionPerformed

    private void jButtonDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletarActionPerformed
        Comida comida = new Comida();
        NegocioComida com = new NegocioComida();

        try {
            if (jComboBoxComidas.getSelectedObjects().length == 0) {
                JOptionPane.showMessageDialog(null, "Digite uma comida válida");
            } else {

                comida.setNome(jComboBoxComidas.getSelectedItem().toString());
                ArrayList<Comida> c = com.ConsultarComidaLike(comida);

                for (Comida comi : c) {
                    comida.setCodigo(comi.getCodigo());
                }

                int escolha = JOptionPane.showConfirmDialog(null, "Deseja deletar o produto: " + comida.getNome() + "?");
                if (escolha == 0) {
                    com.removerComida(comida);
                    JOptionPane.showMessageDialog(null, "Produto deletado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Não deletado");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonDeletarActionPerformed

    private void jTextFieldProcurarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldProcurarKeyTyped
        Comida comida = new Comida();
        NegocioComida com = new NegocioComida();
        jComboBoxComidas.removeAllItems();

        try {
            comida.setNome(jTextFieldProcurar.getText());
            ArrayList<Comida> c1 = com.ConsultarComidaLike(comida);

            com.ConsultarComidaLike(comida);
            for (Comida c : c1) {
                jComboBoxComidas.addItem(c.getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jTextFieldProcurarKeyTyped

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
            java.util.logging.Logger.getLogger(DeletarComida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeletarComida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeletarComida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeletarComida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeletarComida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeletar;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JComboBox<String> jComboBoxComidas;
    private javax.swing.JLabel jLabelSelecionar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JTextField jTextFieldProcurar;
    // End of variables declaration//GEN-END:variables
}