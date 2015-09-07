/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetotcc.classe;

import java.sql.ResultSet;
import javax.swing.JTable;

/**
 *
 * @author DOUGLAS
 */
public class ClasseUnidadeMedida {
    private int  id_unidade_medida;
    private String ds_unidade_medida;
    private ResultSet retorno;
    private int[] array_unidade_medida;
    private JTable tabela; 

    public int getId_unidade_medida() {
        return id_unidade_medida;
    }

    public void setId_unidade_medida(int id_unidade_medida) {
        this.id_unidade_medida = id_unidade_medida;
    }

    public String getDs_unidade_medida() {
        return ds_unidade_medida;
    }

    public void setDs_unidade_medida(String ds_unidade_medida) {
        this.ds_unidade_medida = ds_unidade_medida;
    }

    public ResultSet getRetorno() {
        return retorno;
    }

    public void setRetorno(ResultSet retorno) {
        this.retorno = retorno;
    }

    public int[] getArray_unidade_medida() {
        return array_unidade_medida;
    }

    public void setArray_unidade_medida(int[] array_unidade_medida) {
        this.array_unidade_medida = array_unidade_medida;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }
    
    
}
