
package br.projetotcc.classe;

import java.sql.ResultSet;
import javax.swing.JTable;

/**
 *
 * @author DOUGLAS
 */
public class ClassePessoaFisica extends ClassePessoa{
    private int id_pessoa_fisica;
    private int rg;
    private int cpf;
    private String sexo;
    private String dt_nascimento;
    private String estado_civil;
    private ResultSet retorno;
    private int[] array_pessoafisica;
    private JTable tabela;

    public int getId_pessoa_fisica() {
        return id_pessoa_fisica;
    }

    public void setId_pessoa_fisica(int id_pessoa_fisica) {
        this.id_pessoa_fisica = id_pessoa_fisica;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public int[] getArray_pessoafisica() {
        return array_pessoafisica;
    }

    public void setArray_pessoafisica(int[] array_pessoafisica) {
        this.array_pessoafisica = array_pessoafisica;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }
        
    
}
