
package br.projetotcc.classe;

import java.sql.ResultSet;
import javax.swing.JTable;

/**
 *
 * @author DOUGLAS
 */
public class ClasseFormaPagamento {
   
    private int id_forma_pagamento;
    private int intervalo;
    private String ds_forma;
    private static String entrada;
        private ResultSet retorno;
    private int[] array_cidade;
    private JTable tabela;


    public int getId_forma_pagamento() {
        return id_forma_pagamento;
    }

    public void setId_forma_pagamento(int id_forma_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

    public String getDs_forma() {
        return ds_forma;
    }

    public void setDs_forma(String ds_forma) {
        this.ds_forma = ds_forma;
    }


    public ResultSet getRetorno() {
        return retorno;
    }

    public void setRetorno(ResultSet retorno) {
        this.retorno = retorno;
    }

    public int[] getArray_cidade() {
        return array_cidade;
    }

    public void setArray_cidade(int[] array_cidade) {
        this.array_cidade = array_cidade;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

    public static String getEntrada() {
        return entrada;
    }

    public static void setEntrada(String entrada) {
        ClasseFormaPagamento.entrada = entrada;
    }
    
    
    
}
