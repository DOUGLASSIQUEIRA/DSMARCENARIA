
package br.projetotcc.classe;

import java.sql.ResultSet;
import javax.swing.JTable;

/**
 *
 * @author DOUGLAS
 */
public class ClasseTipoProduto {

    private int id_tipo_produto;
    private String ds_tipo_produto;
    private ResultSet retorno;
    private int[] array_tipo_produto;
    private JTable tabela;

    public int getId_tipo_produto() {
        return id_tipo_produto;
    }

    public void setId_tipo_produto(int id_tipo_produto) {
        this.id_tipo_produto = id_tipo_produto;
    }

    public String getDs_tipo_produto() {
        return ds_tipo_produto;
    }

    public void setDs_tipo_produto(String ds_tipo_produto) {
        this.ds_tipo_produto = ds_tipo_produto;
    }

    public ResultSet getRetorno() {
        return retorno;
    }

    public void setRetorno(ResultSet retorno) {
        this.retorno = retorno;
    }

    public int[] getArray_tipo_produto() {
        return array_tipo_produto;
    }

    public void setArray_tipo_produto(int[] array_tipo_produto) {
        this.array_tipo_produto = array_tipo_produto;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

    
    
}
