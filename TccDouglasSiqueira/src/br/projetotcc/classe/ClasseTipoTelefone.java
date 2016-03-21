
package br.projetotcc.classe;

import java.sql.ResultSet;
import javax.swing.JTable;

/**
 *
 * @author DOUGLAS
 */
public class ClasseTipoTelefone {
   
     
    private int id_tipo_telefone;
    private String ds_tipo_telefone;
    private int[] array_tipo_telefone;
    private ResultSet Retorno;
    private JTable tabela;

    public int getId_tipo_telefone() {
        return id_tipo_telefone;
    }

    public void setId_tipo_telefone(int id_tipo_telefone) {
        this.id_tipo_telefone = id_tipo_telefone;
    }

    public String getDs_tipo_telefone() {
        return ds_tipo_telefone;
    }

    public void setDs_tipo_telefone(String ds_tipo_telefone) {
        this.ds_tipo_telefone = ds_tipo_telefone;
    }

    public int[] getArray_tipo_telefone() {
        return array_tipo_telefone;
    }

    public void setArray_tipo_telefone(int[] array_tipo_telefone) {
        this.array_tipo_telefone = array_tipo_telefone;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

    public ResultSet getRetorno() {
        return Retorno;
    }

    public void setRetorno(ResultSet setRetorno) {
        this.Retorno = setRetorno;
    }
    
    
    
    
}
