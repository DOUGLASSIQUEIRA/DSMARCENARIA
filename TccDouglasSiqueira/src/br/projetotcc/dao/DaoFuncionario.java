
package br.projetotcc.dao;

import br.projetotcc.classe.ClassePessoa;
import br.projetotcc.classe.ClassePessoaFisica;
import br.projetotcc.classe.ClasseFuncionario;
import br.projetotcc.conexao.ConexaoPostgre;
import br.projetotcc.validacoes.UltimaSequencia;
import java.sql.SQLException;

/**
 *
 * @author DOUGLAS
 */
public class DaoFuncionario {
    
     ConexaoPostgre conecta_postgre;
    UltimaSequencia ultima;

    public DaoFuncionario() {
        conecta_postgre = new ConexaoPostgre();

    }

    public void incluir(ClasseFuncionario funcionario) {
        ultima = new UltimaSequencia();
        int sequencia = (Integer) (ultima.ultimasequencia("pessoa", "id_pessoa"));
        
        /*
        Inserindo os dados na tabela de pessoa com os atributos da clssepessoa.
        */
        String sqlpessoa = " insert into pessoa values( "
                + sequencia + " ,' "
                + funcionario.getNm_pessoa()+ "','"
                + funcionario.getDt_cadastro()+"','"
                + funcionario.getTipo_pessoa()+"','"
                + funcionario.getSituacao()+"')";
                  funcionario.setId_pessoa(sequencia);
                
                   /*
        Inserindo os dados na tabela de pessoa_fisica
        */
        String sqlpessoafisica = " insert into pessoa_fisica values( "
                + sequencia + " , "
                + pessoafisica.getRg()+ ","
                + pessoafisica.getCpf()+",'"
                + pessoafisica.getSexo()+"','"
                + pessoafisica.getDt_nascimento()+"')";
                  pessoafisica.setId_pessoa_fisica(sequencia);  
         
             /*
        Inserindo os dados na tabela de funcionário
        */      
        String sqlfuncionario = " insert into funcionario values( "
                + sequencia + " , "
                + funcionario.getId_funcao()+ ",'"
                + funcionario.getDt_demissao()+"',"
                + funcionario.getSalario()+",'"
                + funcionario.getProblemas_saude()+"')";
                  funcionario.setId_pessoa_fisica(sequencia);  
                  
        conecta_postgre.incluirSQL(sqlpessoa);
        conecta_postgre.incluirSQL(sqlpessoafisica);
        conecta_postgre.incluirSQL(sqlfuncionario);
        
    }

    public void alterar(ClasseCidade cidade) {

        String sql = ("update cidade set nm_cidade = '" + cidade.getNm_cidade()+ "' where id_cidade = "
                + cidade.getId_cidade());

        conecta_postgre.atualizarSQL(sql);

    }

    public void excluir(ClasseFuncionario funcionario) {

        String sqlfun = ("delete from funcionario where id_pessoa = " + funcionario.getId_funcionario());
        String sqlpef = ("delete from pessoa_fisica where id_pessoa = " + funcionario.getId_pessoa_fisica());
        String sqlpe = ("delete from pessoa where id_pessoa = " + funcionario.getId_pessoa());
        conecta_postgre.excluirSQL(sqlfun);
        conecta_postgre.excluirSQL(sqlpef);
        conecta_postgre.excluirSQL(sqlpe);

    }

    public void retornardados(ClasseCidade cidade) {
        String sql = "select id_cidade,nm_cidade, cep, pais, id_uf  from cidade "
                + "where id_cidade = " + cidade.getId_cidade();
        conecta_postgre.executeSQL(sql);

        try {

            conecta_postgre.resultset.first();
            cidade.setId_cidade(conecta_postgre.resultset.getInt("id_cidade"));
            cidade.setNm_cidade(conecta_postgre.resultset.getString("nm_cidade"));
            cidade.setCep(conecta_postgre.resultset.getInt("cep"));
            cidade.setPais(conecta_postgre.resultset.getString("pais"));
            cidade.setUf(conecta_postgre.resultset.getString("id_uf"));

        } catch (SQLException ex) {

        }
    }

    public void consultargeral(ClasseCidade cidade) {
        conecta_postgre.executeSQL("select * from cidade");
        cidade.setRetorno(conecta_postgre.resultset);
    }

    public void consultacodigo(ClasseCidade cidade) {
        conecta_postgre.executeSQL("select * from cidade where id_cidade = " + cidade.getId_cidade());
        cidade.setRetorno(conecta_postgre.resultset);

    }

    public void consultadescricao(ClasseCidade cidade) {
        conecta_postgre.executeSQL("select * from cidade where nm_cidade like '%" + cidade.getNm_cidade()+ "%'");
        cidade.setRetorno(conecta_postgre.resultset);
        
        

    }


    public void consultaestado(ClasseCidade cidade) {
        conecta_postgre.executeSQL("select * from cidade where id_uf like '%" + cidade.getId_cidade()+ "%'");
        cidade.setRetorno(conecta_postgre.resultset);

    }
}
