package br.projetotcc.conexao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SIKEIRA
 */
public class ConexaoPostgre {

    public static Connection ConexaoPostgre;
    public static Statement statement;
    public static ResultSet resultset;
    public ResultSetMetaData metaData;
    public int retorno = 0;

    public ConexaoPostgre() {
        conecta();
    }

    public static Connection conecta() {
        if (ConexaoPostgre != null) {
            return ConexaoPostgre;
        } else {
            try {
                Class.forName("org.postgresql.Driver");
                ConexaoPostgre = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "84191963");
                System.out.println("Conectado");
                JOptionPane.showMessageDialog(null, "Conectado com SUCESSO!");
                return ConexaoPostgre;
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Driver não localizado!");
                ex.printStackTrace();
                return null;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na conexão com a fonte de dados: " + ex);
                ex.printStackTrace();
                return null;
            }
        }
    }

    public void desconecta() {
        try {
            ConexaoPostgre.close();
            JOptionPane.showMessageDialog(null, "Desconectado");

        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar desconectar\n" + fecha);
        }
    }

    public void executeSQL(String sql) {
        try {
            statement = ConexaoPostgre.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
            retorno = 1;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o registro executar \n" + sqlex);
        }

        try {
            metaData = resultset.getMetaData();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    public void incluirSQL(String sql) {
        try {
            statement = ConexaoPostgre.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
            retorno = 1;
        } catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 00001) {
                JOptionPane.showMessageDialog(null, "Registro já cadastrado incluir");
            } else {
                System.out.println(sql);
            }
            retorno = 0;
        }

    }

    public void excluirSQL(String sql) {
        try {
            statement = ConexaoPostgre.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            retorno = 0;
            retorno = statement.executeUpdate(sql);

            if (retorno == 1) {
                JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
            }
        } catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 2292) {
                JOptionPane.showMessageDialog(null, "Registro nao Pode ser excluido");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível localizar o registro excluir\n" + sqlex);
            }
            retorno = 0;
        }

    }

    public void atualizarSQL(String sql) {
        try {
            statement = ConexaoPostgre.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            retorno = 0;
            retorno = statement.executeUpdate(sql);

            if (retorno == 1) {
                JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
            }
        } catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 2292) {
                JOptionPane.showMessageDialog(null, "Registro nao contém no cadastro");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível localizar o registro atualizar \n" + sqlex);
            }
            retorno = 0;
        }

    }

    public static void main(String[] args) {
        ConexaoPostgre co = new ConexaoPostgre();
    }

}
