package br.projetotcc.classe;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.sql.ResultSet;
import javax.swing.JTable;

/**
 *
 * @author DOUGLAS
 */
public class ClasseCidade {

    private int id_cidade;
    private Integer cep;
    private String nm_cidade;
    private String pais;
    private String uf;
    private ResultSet retorno;
    private int[] array_cidade;
    private JTable tabela;

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getNm_cidade() {
        return nm_cidade;
    }

    public void setNm_cidade(String nm_cidade) {
        this.nm_cidade = nm_cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
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
    
    
    

}
