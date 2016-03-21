package br.projetotcc.dao;

import br.projetotcc.classe.ClassePessoa;
import br.projetotcc.classe.ClassePessoaFisica;
import br.projetotcc.classe.ClasseFuncionario;
import br.projetotcc.classe.ClasseFuncao;
import br.projetotcc.classe.ClasseEndereco;
import br.projetotcc.classe.ClasseTelefone;
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

    public void incluir(ClasseFuncionario funcionario, ClasseTelefone telefone, ClasseEndereco endereco) {
        ultima = new UltimaSequencia();
        int sequencia = (Integer) (ultima.ultimasequencia("cad_pessoa", "cd_pessoa"));

        /*
         Inserindo os dados na tabela de pessoa com os atributos da clssepessoa.
         */
        String sqlpessoa = " insert into cad_pessoa values( "
                + sequencia + " ,' "
                + funcionario.getNm_pessoa() + "','"
                + funcionario.getDt_cadastro() + "','"
                + funcionario.getTipo_pessoa() + "','"
                + funcionario.getSituacao() + "')";
        funcionario.setId_pessoa(sequencia);

        /*
         Inserindo os dados na tabela de pessoa_fisica
         */
        String sqlpessoafisica = " insert into cad_pessoa_fisica values( "
                + sequencia + " , "
                + funcionario.getRg() + ","
                + funcionario.getCpf() + ",'"
                + funcionario.getSexo() + "','"
                + funcionario.getDt_nascimento() + "','"
                + funcionario.getEstado_civil() + "')";
        funcionario.setId_pessoa_fisica(sequencia);

        /*
         Inserindo os dados na tabela de funcionário
         */
        String sqlfuncionario = " insert into cad_funcionario values( "
                + sequencia + " , "
                + funcionario.getId_funcao() + ",'"
                + funcionario.getDt_demissao() + "',"
                + funcionario.getSalario() + ",'"
                + funcionario.getProblemas_saude() + "','"
                + funcionario.getDt_admissao() + "')";
        funcionario.setId_pessoa_fisica(sequencia);

        //incluir endereço
        ultima = new UltimaSequencia();
        int sequenciaendereco = (Integer) (ultima.ultimasequencia("cad_endereco", "sequencia"));

        String sqlendereco = " insert into cad_endereco values( "
                + sequenciaendereco + " , "
                + sequencia + " , "
                + endereco.getCd_cidade() + ",'"
                + endereco.getRua() + "',"
                + endereco.getNumero() + ",'"
                + endereco.getBairro() + "','"
                + endereco.getComplemento() + "')";
        endereco.setCd_pessoa(sequencia);

        // incluir telefone
        ultima = new UltimaSequencia();
        int sequenciatelefone = (Integer) (ultima.ultimasequencia("cad_telefone", "seequencia"));

        String sqltelefone = " insert into cad_telefone values( "
                + sequenciatelefone + ","
                + sequencia + " , "
                + telefone.getTipo_telefone() + ","
                + telefone.getNumero_telefone() + ",";

        telefone.setCd_pessoa(sequencia);

        conecta_postgre.incluirSQL(sqlpessoa);
        conecta_postgre.incluirSQL(sqlpessoafisica);
        conecta_postgre.incluirSQL(sqlfuncionario);

    }

    public void alterar(ClassePessoa pessoa, ClassePessoaFisica pessoafisica, ClasseFuncionario funcionario,
            ClasseEndereco endereco, ClasseTelefone telefone) {
//alterar pessoa
        String sqlpessoa = ("update cad_pssoa set ds_pessoa,in_situacao,e_mail  = '" + pessoa.getNm_pessoa()
                + "','" + pessoa.getSituacao() + "','" + pessoa.getE_mail() + "' where cd_pessoa = "
                + pessoa.getId_pessoa());

        //alterar pessoa fisica
        String sqlpessoa_fisica = ("update cad_pessoa_fisica set rg,cpf,sexo,dt_nascimento,estado_civil  = "
                + pessoafisica.getRg() + "," + pessoafisica.getCpf() + ",'" + pessoafisica.getSexo() + "','"
                + pessoafisica.getDt_nascimento() + "'," + pessoafisica.getEstado_civil() + "' where cd_pessoa = "
                + pessoafisica.getId_pessoa());

        //alterar tabela de funcionario
        String sqlfuncionario = ("update cad_funcionario set cd_funcao,dt_demissao,salario,problema_saude,dt_admissao = "
                + funcionario.getId_funcao() + ",'" + funcionario.getDt_demissao() + "'," + funcionario.getSalario() + ",'"
                + funcionario.getProblemas_saude() + "','" + funcionario.getDt_admissao() + "' where cd_pessoa = "
                + funcionario.getId_pessoa());

        //alterar tabela de endereco
        String sqlendereco = ("update cad_endereco set cd_cidade,rua,numero,bairro,complemento = "
                + endereco.getCd_cidade() + ",'" + endereco.getRua() + "'," + endereco.getNumero() + ",'"
                + endereco.getBairro() + "','" + endereco.getComplemento() + "' where cd_pessoa = "
                + endereco.getCd_pessoa());

        //alterar tabela de telefone
        String sqltelefone = ("update cad_telefone set cd_tipo_telefone,nr_telefone = "
                + telefone.getTipo_telefone() + "," + telefone.getNumero_telefone() + "' where cd_pessoa = "
                + telefone.getCd_pessoa());

        conecta_postgre.atualizarSQL(sqlpessoa);
        conecta_postgre.atualizarSQL(sqlpessoa_fisica);
        conecta_postgre.atualizarSQL(sqlendereco);
        conecta_postgre.atualizarSQL(sqltelefone);

    }

    public void excluir(ClasseFuncionario funcionario,
            ClasseEndereco endereco, ClasseTelefone telefone) {

        String sqlendereco = ("delete from cad_endereco where cd_pessoa = " + endereco.getCd_pessoa());
        String sqltelefone = ("delete from cad_telefone where cd_pessoa = " + telefone.getCd_pessoa());
        String sqlfuncionario = ("delete from cad_funcionario where cd_pessoa = " + funcionario.getId_pessoa());
        String sqlpessoafisica = ("delete from cad_pessoa_fisica where cd_pessoa = " + funcionario.getId_pessoa());
        String sqlpessoa = ("delete from cad_pessoa where cd_pessoa = " + funcionario.getId_pessoa());

        conecta_postgre.excluirSQL(sqlendereco);
        conecta_postgre.excluirSQL(sqltelefone);
        conecta_postgre.excluirSQL(sqlfuncionario);
        conecta_postgre.excluirSQL(sqlpessoafisica);
        conecta_postgre.excluirSQL(sqlpessoa);

    }

    public void retornardados(ClasseFuncionario funcionario, ClasseEndereco endereco, ClasseTelefone telefone) {

        //retorna dados pessoa
        String sqlpessoa = "select cd_pessoa,ds_pessoa, dt_cadastro, tp_pessoa, in_situacao, e_mail  from cad_pessoa "
                + "where cd_pessoa = " + funcionario.getId_funcao();
        conecta_postgre.executeSQL(sqlpessoa);

        try {

            conecta_postgre.resultset.first();
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cd_pessoa"));
            funcionario.setNm_pessoa(conecta_postgre.resultset.getString("ds_pessoa"));
            funcionario.setDt_cadastro(conecta_postgre.resultset.getString("dt_cadastro"));
            funcionario.setTipo_pessoa(conecta_postgre.resultset.getString("tp_pessoa"));
            funcionario.setSituacao(conecta_postgre.resultset.getString("in_situacao"));
            funcionario.setTipo_pessoa(conecta_postgre.resultset.getString("e_mail"));

        } catch (SQLException ex) {

        }

        //retorna dados pessoa fisica
        String sqlpessoafisica = "select cd_pessoa,rg, cpf, sexo, dt_nascimento, estado_civil  from cad_pessoa_fisica "
                + "where cd_pessoa = " + funcionario.getId_pessoa();
        conecta_postgre.executeSQL(sqlpessoafisica);

        try {

            conecta_postgre.resultset.first();
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cd_pessoa"));
            funcionario.setNm_pessoa(conecta_postgre.resultset.getString("rg"));
            funcionario.setDt_cadastro(conecta_postgre.resultset.getString("cpf"));
            funcionario.setTipo_pessoa(conecta_postgre.resultset.getString("sexo"));
            funcionario.setSituacao(conecta_postgre.resultset.getString("dt_nascimento"));
            funcionario.setTipo_pessoa(conecta_postgre.resultset.getString("estado_civil"));

        } catch (SQLException ex) {

        }

        //retorna dados funcionário
        String sqlfuncionario = "select cd_pessoa,cd_funcao, dt_demissao, salario, problemas_saude, dt_admissao  from cad_funcionario "
                + "where cd_pessoa = " + funcionario.getId_pessoa();
        conecta_postgre.executeSQL(sqlpessoafisica);

        try {

            conecta_postgre.resultset.first();
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cd_pessoa"));
            funcionario.setId_funcao(conecta_postgre.resultset.getInt("cd_funcao"));
            funcionario.setNm_pessoa(conecta_postgre.resultset.getString("dt_demissao"));
            funcionario.setDt_cadastro(conecta_postgre.resultset.getString("salario"));
            funcionario.setTipo_pessoa(conecta_postgre.resultset.getString("problemas_saude"));
            funcionario.setSituacao(conecta_postgre.resultset.getString("dt_admissao"));

        } catch (SQLException ex) {

        }

        //retorna dados endereço
        String sqlendereco = "select sequencida, cd_pessoa, cd_cidade, rua, numero, bairro, complemento  from cad_funcionario "
                + "where cd_pessoa = " + funcionario.getId_pessoa();
        conecta_postgre.executeSQL(sqlpessoafisica);

        try {

            conecta_postgre.resultset.first();
            endereco.setSequencia(conecta_postgre.resultset.getInt("sequencida"));
            endereco.setCd_pessoa(conecta_postgre.resultset.getInt("cd_pessoa"));
            endereco.setCd_cidade(conecta_postgre.resultset.getInt("cd_cidade"));
            endereco.setRua(conecta_postgre.resultset.getString("rua"));
            endereco.setNumero(conecta_postgre.resultset.getString("numero"));
            endereco.setBairro(conecta_postgre.resultset.getString("bairro"));
            endereco.setComplemento(conecta_postgre.resultset.getString("complemento"));

        } catch (SQLException ex) {

        }

        //retorna dados telefone
        String sqltelefone = "select sequencida, cd_pessoa, cd_tipo_telefone, nr_telefone from cad_telefone "
                + "where cd_pessoa = " + funcionario.getId_pessoa();
        conecta_postgre.executeSQL(sqlpessoafisica);

        try {

            conecta_postgre.resultset.first();
            telefone.setSequencia(conecta_postgre.resultset.getInt("sequencida"));
            telefone.setCd_pessoa(conecta_postgre.resultset.getInt("cd_pessoa"));
            telefone.setTipo_telefone(conecta_postgre.resultset.getInt("cd_tipo_telefone"));
            telefone.setNumero_telefone(conecta_postgre.resultset.getString("nr_telefone"));

        } catch (SQLException ex) {

        }
    }

    public void consultargeral(ClasseFuncionario funcionario) {
        conecta_postgre.executeSQL("select cad_pessoa.cd_pessoa,ds_pessoa, dt_cadastro, tp_pessoa, in_situacao, rg,cpf,sexo, dt_nascimento,estado_civil,salario,\n"
                + "problema_saude,cd_cidade,rua, numero, bairro, complemento,cd_tipo_telefone,nr_telefone from cad_pessoa\n"
                + "inner join cad_pessoa_fisica on cad_pessoa.cd_pessoa = cad_pessoa_fisica.cd_pessoa\n"
                + "inner join cad_funcionario on cad_pessoa.cd_pessoa = cad_funcionario.cd_pessoa\n"
                + "inner join cad_endereco on cad_pessoa.cd_pessoa = cad_endereco.cd_pessoa\n"
                + "inner join cad_telefone on cad_pessoa.cd_pessoa = cad_telefone.cd_pessoa");
        funcionario.setRetorno(conecta_postgre.resultset);
    }

    public void consultacodigo(ClasseFuncionario funcionario) {
        conecta_postgre.executeSQL("select cad_pessoa.cd_pessoa,ds_pessoa, dt_cadastro, tp_pessoa, in_situacao, rg,cpf,sexo, dt_nascimento,estado_civil,salario,\n"
                + "problema_saude,cd_cidade,rua, numero, bairro, complemento,cd_tipo_telefone,nr_telefone from cad_pessoa\n"
                + "inner join cad_pessoa_fisica on cad_pessoa.cd_pessoa = cad_pessoa_fisica.cd_pessoa\n"
                + "inner join cad_funcionario on cad_pessoa.cd_pessoa = cad_funcionario.cd_pessoa\n"
                + "inner join cad_endereco on cad_pessoa.cd_pessoa = cad_endereco.cd_pessoa\n"
                + "inner join cad_telefone on cad_pessoa.cd_pessoa = cad_telefone.cd_pessoa where cad_pessoa.cd_pessoa = " + funcionario.getId_pessoa());
        funcionario.setRetorno(conecta_postgre.resultset);

    }

    public void consultadescricao(ClasseFuncionario funcionario) {
        conecta_postgre.executeSQL("select cad_pessoa.cd_pessoa,ds_pessoa, dt_cadastro, tp_pessoa, in_situacao, rg,cpf,sexo, dt_nascimento,estado_civil,salario,\n"
                + "problema_saude,cd_cidade,rua, numero, bairro, complemento,cd_tipo_telefone,nr_telefone from cad_pessoa\n"
                + "inner join cad_pessoa_fisica on cad_pessoa.cd_pessoa = cad_pessoa_fisica.cd_pessoa\n"
                + "inner join cad_funcionario on cad_pessoa.cd_pessoa = cad_funcionario.cd_pessoa\n"
                + "inner join cad_endereco on cad_pessoa.cd_pessoa = cad_endereco.cd_pessoa\n"
                + "inner join cad_telefone on cad_pessoa.cd_pessoa = cad_telefone.cd_pessoa where cad_pessoa.ds_pessoa like '%" + funcionario.getNm_pessoa()+ "%'");
        funcionario.setRetorno(conecta_postgre.resultset);

    }

     public void consultaCpf(ClasseFuncionario funcionario) {
     conecta_postgre.executeSQL("select cad_pessoa.cd_pessoa,ds_pessoa, dt_cadastro, tp_pessoa, in_situacao, rg,cpf,sexo, dt_nascimento,estado_civil,salario,\n"
                + "problema_saude,cd_cidade,rua, numero, bairro, complemento,cd_tipo_telefone,nr_telefone from cad_pessoa\n"
                + "inner join cad_pessoa_fisica on cad_pessoa.cd_pessoa = cad_pessoa_fisica.cd_pessoa\n"
                + "inner join cad_funcionario on cad_pessoa.cd_pessoa = cad_funcionario.cd_pessoa\n"
                + "inner join cad_endereco on cad_pessoa.cd_pessoa = cad_endereco.cd_pessoa\n"
                + "inner join cad_telefone on cad_pessoa.cd_pessoa = cad_telefone.cd_pessoa where cad_pessoa_fisica.cpf like '%" + funcionario.getNm_pessoa()+ "%'");
        funcionario.setRetorno(conecta_postgre.resultset);

     }
    
          public void consultaRg(ClasseFuncionario funcionario) {
     conecta_postgre.executeSQL("select cad_pessoa.cd_pessoa,ds_pessoa, dt_cadastro, tp_pessoa, in_situacao, rg,cpf,sexo, dt_nascimento,estado_civil,salario,\n"
                + "problema_saude,cd_cidade,rua, numero, bairro, complemento,cd_tipo_telefone,nr_telefone from cad_pessoa\n"
                + "inner join cad_pessoa_fisica on cad_pessoa.cd_pessoa = cad_pessoa_fisica.cd_pessoa\n"
                + "inner join cad_funcionario on cad_pessoa.cd_pessoa = cad_funcionario.cd_pessoa\n"
                + "inner join cad_endereco on cad_pessoa.cd_pessoa = cad_endereco.cd_pessoa\n"
                + "inner join cad_telefone on cad_pessoa.cd_pessoa = cad_telefone.cd_pessoa where cad_pessoa_fisica.rg like '%" + funcionario.getNm_pessoa()+ "%'");
        funcionario.setRetorno(conecta_postgre.resultset);

     }
}
