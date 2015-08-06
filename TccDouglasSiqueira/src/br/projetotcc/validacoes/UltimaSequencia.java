package br.projetotcc.validacoes;

import br.projetotcc.conexao.ConexaoPostgre;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UltimaSequencia {

    ConexaoPostgre conexao_oracle;

    public UltimaSequencia() {
        conexao_oracle = new ConexaoPostgre();
    }
    

    public int ultimasequencia(String tabela, String atributo) {
        String sql = "select coalesce(max(" + atributo + "),0) + 1 as ultimo from " + tabela;
        conexao_oracle.executeSQL(sql);
        int retorno = 0;

        try {
            conexao_oracle.resultset.first();
            return conexao_oracle.resultset.getInt("ultimo");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Resultado nao encontrado");
            return 0;
        }
    }

}

