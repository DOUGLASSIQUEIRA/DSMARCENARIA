/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.projetotcc.interfaces;

/**
 *
 * @author Douglas Siqueira
 */

import br.projetotcc.classe.ClasseTipoFornecedor;
import br.projetotcc.dao.DaoFormaPagamento;
import br.projetotcc.dao.DaoTipoFornecedor;
import br.projetotcc.validacoes.Rotinas;
import javax.swing.JOptionPane;
import br.projetotcc.validacoes.ValidaBotoes;
import br.projetotcc.validacoes.LimparCampos;
import br.projetotcc.validacoes.ValidaCamposObrigatorios;
import br.projetotcc.validacoes.PreencherJtableGenerica;

public class FCadTipoFornecedor extends javax.swing.JFrame {
    
    ClasseTipoFornecedor classetipofornecedor = new ClasseTipoFornecedor();
    DaoTipoFornecedor dao = new DaoTipoFornecedor();
    ValidaBotoes estado = new ValidaBotoes();
    LimparCampos limparcampos = new LimparCampos();
    ValidaCamposObrigatorios validacampos = new ValidaCamposObrigatorios();
    PreencherJtableGenerica preencher = new PreencherJtableGenerica();
    int situacao = Rotinas.Padrao;
    /**
     * Creates new form 
     */
    public FCadTipoFornecedor() {
        initComponents();
        preencher.FormatarJtable(jTConsulta, new int[]{100, 450});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTPrincipal = new javax.swing.JTabbedPane();
        jPCadastro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTfcodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTfdescricao = new javax.swing.JTextField();
        jPbotoes = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPConsulta = new javax.swing.JPanel();
        jCbpesquisa = new javax.swing.JComboBox();
        jTfPesquisa = new javax.swing.JTextField();
        jBpesquisa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTConsulta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRO DE TIPO DE FORNECEDOR");

        jLabel1.setText("Código ");

        jTfcodigo.setEnabled(false);
        jTfcodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTfcodigoFocusLost(evt);
            }
        });

        jLabel2.setText("Tipo de Fornecedor");

        jPbotoes.setBackground(new java.awt.Color(204, 204, 204));

        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Gravar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPbotoesLayout = new javax.swing.GroupLayout(jPbotoes);
        jPbotoes.setLayout(jPbotoesLayout);
        jPbotoesLayout.setHorizontalGroup(
            jPbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPbotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPbotoesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5});

        jPbotoesLayout.setVerticalGroup(
            jPbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPbotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPbotoesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5});

        javax.swing.GroupLayout jPCadastroLayout = new javax.swing.GroupLayout(jPCadastro);
        jPCadastro.setLayout(jPCadastroLayout);
        jPCadastroLayout.setHorizontalGroup(
            jPCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPbotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTfcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTfdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCadastroLayout.setVerticalGroup(
            jPCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTfcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTfdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPbotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTPrincipal.addTab("Cadastro", jPCadastro);

        jCbpesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Geral", "Código", "Função" }));

        jBpesquisa.setText("Pesquisar");
        jBpesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBpesquisaActionPerformed(evt);
            }
        });

        jTConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo de fornecedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTConsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTConsulta);

        javax.swing.GroupLayout jPConsultaLayout = new javax.swing.GroupLayout(jPConsulta);
        jPConsulta.setLayout(jPConsultaLayout);
        jPConsultaLayout.setHorizontalGroup(
            jPConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPConsultaLayout.createSequentialGroup()
                        .addComponent(jCbpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jBpesquisa)))
                .addContainerGap())
        );
        jPConsultaLayout.setVerticalGroup(
            jPConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBpesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTPrincipal.addTab("Consulta", jPConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(534, 270));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTfdescricao.grabFocus();
        situacao = Rotinas.Incluir;
        estado.ValidaEstado(jPbotoes, situacao);
        limparcampos.LimparCampos(jPCadastro);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTfcodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTfcodigoFocusLost
        if (!jTfcodigo.getText().equals("")) {
            getcomp();
            dao.retornardados(classetipofornecedor);
            setcomp();
        }
    }//GEN-LAST:event_jTfcodigoFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         situacao = Rotinas.Alterar;
        // TODO add your handling code here:
        estado.ValidaEstado(jPbotoes, situacao);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         if (JOptionPane.showConfirmDialog(null, "Confirmar a Exclusão do Registro") == 0) {
            //classe.setCdcor(Integer.parseInt(jTfcodigo.getText()));
            dao.excluir(classetipofornecedor);
            limparcampos.LimparCampos(jPCadastro);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        situacao = Rotinas.Padrao;
        // TODO add your handling code here:
        estado.ValidaEstado(jPbotoes, situacao);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         if (validacampos.retorno != 1) {
            // TODO add your handling code here:
            if (jTfdescricao.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Informe o Tipo de fornecedor");
                jTfdescricao.grabFocus();
                return;

            } else {
                getcomp();
                if (situacao == Rotinas.Incluir) {
                    dao.incluir(classetipofornecedor);
                    jTfcodigo.setText(Integer.toString(classetipofornecedor.getId_tipo_fornecedor()));
                } else if (situacao == Rotinas.Alterar) {
                    dao.alterar(classetipofornecedor);
                }
            }
        }
        estado.ValidaEstado(jPbotoes, Rotinas.Padrao);
        situacao = Rotinas.Padrao;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jBpesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBpesquisaActionPerformed
        switch (jCbpesquisa.getSelectedIndex()) {
            case 0:
                dao.consultargeral(classetipofornecedor);
                break;
            case 1:
                classetipofornecedor.setId_tipo_fornecedor(Integer.parseInt(jTfPesquisa.getText()));
                dao.consultacodigo(classetipofornecedor);
                break;
            case 2:
                classetipofornecedor.setDs_tipo_fornecedpr(jTfPesquisa.getText());
                dao.consultadescricao(classetipofornecedor);
                break;
        }
        preencher.PreencherJtabelaGenerico(jTConsulta, new String[]{"cd_tipo_fornecedor", "ds_tipo_fornecedor"}, classetipofornecedor.getRetorno());
    }//GEN-LAST:event_jBpesquisaActionPerformed

    private void jTConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTConsultaMouseClicked
       if (evt.getClickCount() == 2) {
            int linha = jTConsulta.getSelectedRow();
            String codigo = (String) jTConsulta.getValueAt(linha, 0);

            classetipofornecedor.setId_tipo_fornecedor(Integer.parseInt(codigo));
            dao.retornardados(classetipofornecedor);
            setcomp();

            jTPrincipal.setSelectedIndex(0);
       }
    }//GEN-LAST:event_jTConsultaMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FCadTipoFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FCadTipoFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FCadTipoFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FCadTipoFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FCadTipoFornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBpesquisa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jCbpesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPCadastro;
    private javax.swing.JPanel jPConsulta;
    private javax.swing.JPanel jPbotoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTConsulta;
    private javax.swing.JTabbedPane jTPrincipal;
    private javax.swing.JTextField jTfPesquisa;
    private javax.swing.JTextField jTfcodigo;
    private javax.swing.JTextField jTfdescricao;
    // End of variables declaration//GEN-END:variables
 public ClasseTipoFornecedor getcomp() {
        if (situacao == Rotinas.Alterar) {
            classetipofornecedor.setId_tipo_fornecedor(Integer.parseInt(jTfcodigo.getText()));
        }
        classetipofornecedor.setDs_tipo_fornecedpr(jTfdescricao.getText());
        return classetipofornecedor;

    }

    public void setcomp() {
        jTfcodigo.setText(Integer.toString(classetipofornecedor.getId_tipo_fornecedor()));
        jTfdescricao.setText(classetipofornecedor.getDs_tipo_fornecedpr());
    }

}