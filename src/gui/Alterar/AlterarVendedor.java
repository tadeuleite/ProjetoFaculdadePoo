package gui.Alterar;

import classesBasicas.Vendedor;
import negocio.NegocioVendedor;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AlterarVendedor extends javax.swing.JFrame {

    public AlterarVendedor() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldCpf = new javax.swing.JTextField();
        jButtonAlterar = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldProcurar = new javax.swing.JTextField();
        jButtonProcurar = new javax.swing.JButton();
        jComboBoxVendedores = new javax.swing.JComboBox<>();
        jButtonListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Vendedor");

        jLabelTitulo.setText("Alterar Vendedor");

        jLabelNome.setText("Nome");

        jLabelCpf.setText("Cpf");

        jTextFieldNome.setEnabled(false);

        jTextFieldCpf.setEnabled(false);

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setEnabled(false);
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jLabelCodigo.setText("Digite o nome do vendedor que você deseja alterar");

        jTextFieldProcurar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldProcurarKeyTyped(evt);
            }
        });

        jButtonProcurar.setText("Selecionar");
        jButtonProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProcurarActionPerformed(evt);
            }
        });

        jComboBoxVendedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        jButtonListar.setText("Listar todos");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCpf)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldCpf))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonProcurar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBoxVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonListar))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jButtonAlterar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(jTextFieldProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonProcurar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonListar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCpf)
                    .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAlterar)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProcurarActionPerformed
        Vendedor vendedor = new Vendedor();
        NegocioVendedor vend = new NegocioVendedor();

        try {
            if (jComboBoxVendedores.getSelectedObjects().length == 0) {
                JOptionPane.showMessageDialog(null, "Digite um vendedor válido");
            } else {
                vendedor.setNome(jComboBoxVendedores.getSelectedItem().toString());

                ArrayList<Vendedor> vendedores = vend.consultarVendedorLike(vendedor);

                for (Vendedor vende : vendedores) {
                    jTextFieldCpf.setText(vende.getCpf());
                    jTextFieldNome.setText(vende.getNome());
                }

                jTextFieldNome.setEnabled(true);
                jTextFieldCpf.setEnabled(true);
                jButtonAlterar.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonProcurarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        Vendedor vendedor = new Vendedor();
        NegocioVendedor vend = new NegocioVendedor();

        try {
            vendedor.setNome(jComboBoxVendedores.getSelectedItem().toString());

            ArrayList<Vendedor> v = vend.consultarVendedorLike(vendedor);

            for (Vendedor ven : v) {
                vendedor.setCodigo(ven.getCodigo());
            }

            vendedor.setCpf(jTextFieldCpf.getText());
            vendedor.setNome(jTextFieldNome.getText());

            int confirmar = JOptionPane.showConfirmDialog(null, "Deseja realmente mudar essas informações?");
            if (confirmar == 0) {
                vend.alterarVendedor(vendedor);
                JOptionPane.showMessageDialog(null, "Vendedor alterado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Vendedor não alterado");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jTextFieldProcurarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldProcurarKeyTyped
        Vendedor vendedor = new Vendedor();
        NegocioVendedor vend = new NegocioVendedor();
        jComboBoxVendedores.removeAllItems();

        try {
            vendedor.setNome(jTextFieldProcurar.getText());
            ArrayList<Vendedor> v = vend.consultarVendedorLike(vendedor);

            for (Vendedor ven : v) {
                jComboBoxVendedores.addItem(ven.getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jTextFieldProcurarKeyTyped

    private void jButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarActionPerformed
        NegocioVendedor vend = new NegocioVendedor();
        jComboBoxVendedores.removeAllItems();
        try {
            ArrayList<Vendedor> v = vend.listarVendedor();
            for (Vendedor ven : v) {
                jComboBoxVendedores.addItem(ven.getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonListarActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarVendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JButton jButtonProcurar;
    private javax.swing.JComboBox<String> jComboBoxVendedores;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldProcurar;
    // End of variables declaration//GEN-END:variables
}
