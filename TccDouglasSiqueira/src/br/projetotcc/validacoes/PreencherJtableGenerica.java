package br.projetotcc.validacoes;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SIKEIRA
 */
public class PreencherJtableGenerica {

    public void FormatarJtable(JTable tabela, int valores[]) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        if (modelo.getColumnCount() == valores.length) {
            for (int x = 0; x < valores.length; x++) {
                tabela.getColumnModel().getColumn(x).setPreferredWidth(valores[x]);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor verificar os Parametros Passados");
        }

    }

    public void PreencherJtabelaGenerico(JTable tabela, String campos[], ResultSet resultset) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        try {
            while (resultset.next()) {
                int len = campos.length;
                Object[] row = new Object[len];
                for (int i = 0; i < len; i++) {
                    row[i] = resultset.getString(campos[i]);

                }
                modelo.addRow(row);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar a Jtable" + erro);
        }
    }
}
