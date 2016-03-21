
package br.projetotcc.classe;

import java.sql.ResultSet;
import javax.swing.JTable;

/**
 *
 * @author DOUGLAS
 */
public class ClasseTipoFornecedor {
    private int id_tipo_fornecedor;
    private String ds_tipo_fornecedor;
    private ResultSet retorno;
    private int[] array_tipo_fornecedor;
    private JTable tabela;

    public int getId_tipo_fornecedor() {
        return id_tipo_fornecedor;
    }

    public void setId_tipo_fornecedor(int id_tipo_fornecedor) {
        this.id_tipo_fornecedor = id_tipo_fornecedor;
    }

    public String getDs_tipo_fornecedpr() {
        return ds_tipo_fornecedor;
    }

    public void setDs_tipo_fornecedpr(String ds_tipo_fornecedpr) {
        this.ds_tipo_fornecedor = ds_tipo_fornecedpr;
    }

    public ResultSet getRetorno() {
        return retorno;
    }

    public void setRetorno(ResultSet retorno) {
        this.retorno = retorno;
    }

    public int[] getArray_tipo_fornecedor() {
        return array_tipo_fornecedor;
    }

    public void setArray_tipo_fornecedor(int[] array_tipo_fornecedor) {
        this.array_tipo_fornecedor = array_tipo_fornecedor;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }
    
    

}
