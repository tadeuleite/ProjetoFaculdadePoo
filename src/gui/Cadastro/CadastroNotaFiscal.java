/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Cadastro;

import classesBasicas.Cliente;
import metodos.ConvercaoDate;
import classesBasicas.NotaFiscal;
import classesBasicas.NotaFiscalProduto;
import classesBasicas.Produto;
import classesBasicas.Vendedor;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import negocio.NegocioNotaFiscal;
import negocio.NegocioProduto;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.NegocioCliente;
import negocio.NegocioVendedor;

/**
 *
 * @author thade
 */
public class CadastroNotaFiscal extends javax.swing.JFrame {

    private final ArrayList<NotaFiscalProduto> itens = new ArrayList<>();

    /**
     * Creates new form CadastroNotaFiscal
     */
    public CadastroNotaFiscal() {
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
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDataEmissao = new javax.swing.JTextField();
        jTextFieldCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldVendedor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jTextFieldPreco = new javax.swing.JTextField();
        jComboBoxProduto = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButtonIncluirProd = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableItens = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldCodigoProduto = new javax.swing.JTextField();
        jButtonListar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCodigoNota = new javax.swing.JTextField();
        jComboBoxClientes = new javax.swing.JComboBox<>();
        jComboBoxVendedores = new javax.swing.JComboBox<>();
        jButtonClientes = new javax.swing.JButton();
        jButtonVendedores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Nota Fiscal");

        jLabel1.setText("Cadastrar Nota Fiscal");

        jLabel2.setText("Data de Emissão");

        jLabel3.setText("Nome do Cliente");

        jTextFieldCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldClienteKeyTyped(evt);
            }
        });

        jLabel4.setText("Nome do Vendedor");

        jTextFieldVendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldVendedorKeyTyped(evt);
            }
        });

        jLabel5.setText("Quantidade");

        jLabel6.setText("Preco");

        jComboBoxProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        jLabel7.setText("Produto");

        jButtonIncluirProd.setText("Incluir na nota");
        jButtonIncluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirProdActionPerformed(evt);
            }
        });

        jButtonCadastrar.setText("Cadastrar nota");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jTableItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Quantidade", "Preco"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableItens.setEnabled(false);
        jScrollPane1.setViewportView(jTableItens);

        jLabel8.setText("Selecione o item desejado aqui");

        jTextFieldCodigoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCodigoProdutoKeyTyped(evt);
            }
        });

        jButtonListar.setText("Listar Produtos");
        jButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarActionPerformed(evt);
            }
        });

        jLabel9.setText("Codigo");

        jComboBoxClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        jComboBoxVendedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        jButtonClientes.setText("Listar Clientes");
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });

        jButtonVendedores.setText("Listar Vendedores");
        jButtonVendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVendedoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonIncluirProd))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonListar))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(240, 240, 240)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldCodigoNota, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxVendedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonVendedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(jButtonCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldCodigoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClientes))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVendedores))
                .addGap(32, 32, 32)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonListar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIncluirProd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        NotaFiscal notaFiscal = new NotaFiscal();
        NegocioNotaFiscal notaf = new NegocioNotaFiscal();
        NegocioCliente cli = new NegocioCliente();
        NegocioVendedor vend = new NegocioVendedor();
        DefaultTableModel modelo = new DefaultTableModel();

        try {
            notaFiscal.setCodigoNota(Integer.parseInt(jTextFieldCodigoNota.getText()));
            notaFiscal.setDataEmissao(ConvercaoDate.parseDate(jTextFieldDataEmissao.getText()));
            notaFiscal.getCliente().setNome(jComboBoxClientes.getSelectedItem().toString());
            notaFiscal.getVendedor().setNome(jComboBoxVendedores.getSelectedItem().toString());

            if (itens.isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Insira produtos para cadastrar a nota");
            } else {
                notaFiscal.setNotaProduto(itens);

                ArrayList<Cliente> c = cli.consultarClienteLike(notaFiscal.getCliente());
                ArrayList<Vendedor> v = vend.consultarVendedorLike(notaFiscal.getVendedor());

                for (Cliente cl : c) {
                    notaFiscal.getCliente().setCpf(cl.getCpf());
                }

                for (Vendedor ven : v) {
                    notaFiscal.getVendedor().setCodigo(ven.getCodigo());
                }

                notaf.cadastrarNotaFiscal(notaFiscal);

                JOptionPane.showMessageDialog(null, "Nota cadastrada com sucesso");

                itens.clear();
                modelo.setColumnIdentifiers(new Object[]{"Nome", "Quantidade", "Preco"});

                jTableItens.setModel(modelo);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Digite um código válido");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Digite uma data válida e no formato dd/MM/yyy");
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Preencha os campos de cliente e vendedor corretamente");
        } catch (MySQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "O código não pode se repetir");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }


    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonIncluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirProdActionPerformed
        NotaFiscalProduto notaProd = new NotaFiscalProduto();
        Produto produto = new Produto();
        NegocioProduto prod = new NegocioProduto();
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            modelo.setColumnIdentifiers(new Object[]{"Nome", "Quantidade", "Preco"});
            produto.setNome(jComboBoxProduto.getSelectedItem().toString());
            ArrayList<Produto> p = prod.consultarProdutoLike(produto);

            for (Produto prdt : p) {
                notaProd.getProduto().setCodigo(prdt.getCodigo());
            }

            notaProd.getNotaFiscal().setCodigoNota(Integer.parseInt(jTextFieldCodigoNota.getText()));
            notaProd.getProduto().setNome(jComboBoxProduto.getSelectedItem().toString());
            notaProd.setQuantidade(Integer.parseInt(jTextFieldQuantidade.getText()));
            notaProd.setPreco(Float.parseFloat(jTextFieldPreco.getText()));

            if (jComboBoxProduto.getSelectedItem().toString().equals("-")) {
                JOptionPane.showMessageDialog(null, "Selecione um produto para inserir");
            } else {
                itens.add(notaProd);
            }

            for (NotaFiscalProduto np : itens) {
                modelo.addRow(new Object[]{np.getProduto().getNome(), np.getQuantidade(), np.getPreco()});
            }

            jTableItens.setModel(modelo);
        } catch (NumberFormatException ex) {
            if (jTextFieldCodigoNota.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Digite o código da nota");
            } else {
                JOptionPane.showMessageDialog(null, "Digite as quantidades e preços válidos");
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Preencha os campo de produto corretamente");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonIncluirProdActionPerformed

    private void jTextFieldCodigoProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoProdutoKeyTyped
        Produto produto = new Produto();
        NegocioProduto prod = new NegocioProduto();
        jComboBoxProduto.removeAllItems();

        try {
            produto.setNome(jTextFieldCodigoProduto.getText());
            ArrayList<Produto> c1 = prod.consultarProdutoLike(produto);
            for (Produto c : c1) {

                jComboBoxProduto.addItem(c.getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jTextFieldCodigoProdutoKeyTyped

    private void jButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarActionPerformed
        NegocioProduto prod = new NegocioProduto();
        jComboBoxProduto.removeAllItems();

        try {
            ArrayList<Produto> p = prod.listarProdutos();
            for (Produto pro : p) {
                jComboBoxProduto.addItem(pro.getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonListarActionPerformed

    private void jTextFieldClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldClienteKeyTyped
        NotaFiscal notaFiscal = new NotaFiscal();
        NegocioCliente cli = new NegocioCliente();

        jComboBoxClientes.removeAllItems();

        try {
            notaFiscal.getCliente().setNome(jTextFieldCliente.getText());
            ArrayList<Cliente> c = cli.consultarClienteLike(notaFiscal.getCliente());

            for (Cliente clientes : c) {
                jComboBoxClientes.addItem(clientes.getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jTextFieldClienteKeyTyped

    private void jButtonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientesActionPerformed
        NegocioCliente cli = new NegocioCliente();
        jComboBoxClientes.removeAllItems();
        try {
            ArrayList<Cliente> c = cli.listarCliente();
            for (Cliente clientes : c) {
                jComboBoxClientes.addItem(clientes.getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonClientesActionPerformed

    private void jButtonVendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVendedoresActionPerformed
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
    }//GEN-LAST:event_jButtonVendedoresActionPerformed

    private void jTextFieldVendedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldVendedorKeyTyped
        NotaFiscal notaf = new NotaFiscal();
        NegocioVendedor vend = new NegocioVendedor();

        jComboBoxVendedores.removeAllItems();

        try {
            notaf.getVendedor().setNome(jTextFieldVendedor.getText());
            ArrayList<Vendedor> v = vend.consultarVendedorLike(notaf.getVendedor());

            for (Vendedor vendedores : v) {
                jComboBoxVendedores.addItem(vendedores.getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jTextFieldVendedorKeyTyped

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
            java.util.logging.Logger.getLogger(CadastroNotaFiscal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroNotaFiscal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroNotaFiscal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroNotaFiscal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroNotaFiscal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonIncluirProd;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JButton jButtonVendedores;
    private javax.swing.JComboBox<String> jComboBoxClientes;
    private javax.swing.JComboBox<String> jComboBoxProduto;
    private javax.swing.JComboBox<String> jComboBoxVendedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableItens;
    private javax.swing.JTextField jTextFieldCliente;
    private javax.swing.JTextField jTextFieldCodigoNota;
    private javax.swing.JTextField jTextFieldCodigoProduto;
    private javax.swing.JTextField jTextFieldDataEmissao;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldVendedor;
    // End of variables declaration//GEN-END:variables
}
