
package br.projetotcc.classe;

import java.sql.ResultSet;
import javax.swing.JTable;

/**
 *
 * @author DOUGLAS
 */
public class ClasseFuncionario extends ClassePessoaFisica{
    
    private int id_funcionario;
    private int id_funcao;
    private String dt_demissao;
    private double salario;
    private String problemas_saude;
    private ResultSet retorno;
    private int[] array_funcionario;
    private JTable tabela;

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getId_funcao() {
        return id_funcao;
    }

    public void setId_funcao(int id_funcao) {
        this.id_funcao = id_funcao;
    }

    public String getDt_demissao() {
        return dt_demissao;
    }

    public void setDt_demissao(String dt_demissao) {
        this.dt_demissao = dt_demissao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getProblemas_saude() {
        return problemas_saude;
    }

    public void setProblemas_saude(String problemas_saude) {
        this.problemas_saude = problemas_saude;
    }

    public ResultSet getRetorno() {
        return retorno;
    }

    public void setRetorno(ResultSet retorno) {
        this.retorno = retorno;
    }

    public int[] getArray_funcionario() {
        return array_funcionario;
    }

    public void setArray_funcionario(int[] array_funcionario) {
        this.array_funcionario = array_funcionario;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }
    
    
 
}
