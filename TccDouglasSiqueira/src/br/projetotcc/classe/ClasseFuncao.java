
package br.projetotcc.classe;

import java.sql.ResultSet;
import javax.swing.JTable;

/**
 *
 * @author DOUGLAS
 */
public class ClasseFuncao {
    private int id_funcao;
    private String ds_funcao;
    private ResultSet retorno;
    private int[] array_funcao;
    private JTable tabela; 

    public int getId_funcao() {
        return id_funcao;
    }

    public void setId_funcao(int id_funcao) {
        this.id_funcao = id_funcao;
    }

    public String getDs_funcao() {
        return ds_funcao;
    }

    public void setDs_funcao(String ds_funcao) {
        this.ds_funcao = ds_funcao;
    }

    public ResultSet getRetorno() {
        return retorno;
    }

    public void setRetorno(ResultSet retorno) {
        this.retorno = retorno;
    }

    public int[] getArray_funcao() {
        return array_funcao;
    }

    public void setArray_funcao(int[] array_funcao) {
        this.array_funcao = array_funcao;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }
    
    
}
