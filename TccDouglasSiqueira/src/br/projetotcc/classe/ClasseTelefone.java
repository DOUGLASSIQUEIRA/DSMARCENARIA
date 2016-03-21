package br.projetotcc.classe;

import java.sql.ResultSet;
import javax.swing.JTable;

/**
 *
 * @author DOUGLAS
 */
public class ClasseTelefone {

    private int sequencia;
    private int cd_pessoa;
    private int tipo_telefone;
    private String numero_telefone;
    private ResultSet retorno;
    private int[] array_telefone;
    private JTable tabela;

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public int getCd_pessoa() {
        return cd_pessoa;
    }

    public void setCd_pessoa(int cd_pessoa) {
        this.cd_pessoa = cd_pessoa;
    }

    public int getTipo_telefone() {
        return tipo_telefone;
    }

    public void setTipo_telefone(int tipo_telefone) {
        this.tipo_telefone = tipo_telefone;
    }

    public String getNumero_telefone() {
        return numero_telefone;
    }

    public void setNumero_telefone(String numero_telefone) {
        this.numero_telefone = numero_telefone;
    }

    public ResultSet getRetorno() {
        return retorno;
    }

    public void setRetorno(ResultSet retorno) {
        this.retorno = retorno;
    }

    public int[] getArray_telefone() {
        return array_telefone;
    }

    public void setArray_telefone(int[] array_telefone) {
        this.array_telefone = array_telefone;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }
    
    
}
