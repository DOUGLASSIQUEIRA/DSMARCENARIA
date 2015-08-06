package br.projetotcc.validacoes;

import java.awt.Component;
import java.awt.Container;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import br.projetotcc.conexao.ConexaoPostgre;
import java.sql.ResultSetMetaData;

/**
 *
 * @author SIKEIRA
 */
public class ValidaCamposObrigatorios {

    ConexaoPostgre conecta_oracle = new ConexaoPostgre();
    public ResultSetMetaData metadata;
    public int retorno = 0;

    public void validacamposobrigatorio(Container container, String tabela) {
        conecta_oracle.executeSQL("select * from" + tabela + "where rownum = 1");
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                JTextField field = (JTextField) component;
                String nome = field.getName();
                String conteudo = field.getText();
                String text = field.getToolTipText();
                int chave = field.getColumns();
                try {
                    int numcols = conecta_oracle.metaData.getColumnCount();
                    for (int conta = 1; conta <= numcols; conta++) {
                        String colsname = conecta_oracle.metaData.getColumnName(conta);
                        int obrigatorio = conecta_oracle.metaData.isNullable(conta);
                        if (conteudo.equals("") && obrigatorio == 0) {
                            if (chave != 1) {
                                JOptionPane.showMessageDialog(null, "Campo " + text + " Obrigatório");
                                field.grabFocus();
                                retorno = 1;
                                return;
                            }
                        }
                    }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, erro);
                }
            }

        }

    }
}
