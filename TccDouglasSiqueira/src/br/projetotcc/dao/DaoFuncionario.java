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
import javax.swing.JOptionPane;

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
        conecta_postgre.incluirSQL(sqlpessoa);

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
        conecta_postgre.incluirSQL(sqlpessoafisica);

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
        conecta_postgre.incluirSQL(sqlfuncionario);

        //incluir endereço
        ultima = new UltimaSequencia();
        int sequenciaendereco = (Integer) (ultima.ultimasequencia("cad_endereco", "sequencia"));

        String sqlendereco = " insert into cad_endereco values( "
                + sequenciaendereco + " , "
                + sequencia + " , "
                + endereco.getCd_cidade() + ",'"
                + endereco.getRua() + "','"
                + endereco.getNumero() + "','"
                + endereco.getBairro() + "','"
                + endereco.getComplemento() + "')";
        endereco.setCd_pessoa(sequencia);
        conecta_postgre.incluirSQL(sqlendereco);

        // incluir telefone
        ultima = new UltimaSequencia();
        int sequenciatelefone = (Integer) (ultima.ultimasequencia("cad_telefone", "sequencia"));

        String sqltelefone = " insert into cad_telefone values( "
                + sequenciatelefone + ","
                + sequencia + " , "
                + telefone.getTipo_telefone() + ","
                + telefone.getNumero_telefone() + ",";

        telefone.setCd_pessoa(sequencia);
        conecta_postgre.incluirSQL(sqltelefone);

    }

    public void alterar(ClasseFuncionario funcionario,
            ClasseEndereco endereco, ClasseTelefone telefone) {
//alterar pessoa
        String sqlpessoa = ("update cad_pssoa set ds_pessoa,in_situacao,e_mail  = '" + funcionario.getNm_pessoa()
                + "','" + funcionario.getSituacao() + "','" + funcionario.getE_mail() + "' where cd_pessoa = "
                + funcionario.getId_pessoa());
        conecta_postgre.atualizarSQL(sqlpessoa);

        //alterar pessoa fisica
        String sqlpessoa_fisica = ("update cad_pessoa_fisica set rg,cpf,sexo,dt_nascimento,estado_civil  = "
                + funcionario.getRg() + "," + funcionario.getCpf() + ",'" + funcionario.getSexo() + "','"
                + funcionario.getDt_nascimento() + "'," + funcionario.getEstado_civil() + "' where cd_pessoa = "
                + funcionario.getId_pessoa());
        conecta_postgre.atualizarSQL(sqlpessoa_fisica);

        //alterar tabela de funcionario
        String sqlfuncionario = ("update cad_funcionario set cd_funcao,dt_demissao,salario,problema_saude,dt_admissao = "
                + funcionario.getId_funcao() + ",'" + funcionario.getDt_demissao() + "'," + funcionario.getSalario() + ",'"
                + funcionario.getProblemas_saude() + "','" + funcionario.getDt_admissao() + "' where cd_pessoa = "
                + funcionario.getId_pessoa());
        conecta_postgre.atualizarSQL(sqlfuncionario);

        //alterar tabela de endereco
        String sqlendereco = ("update cad_endereco set cd_cidade,rua,numero,bairro,complemento = "
                + endereco.getCd_cidade() + ",'" + endereco.getRua() + "'," + endereco.getNumero() + ",'"
                + endereco.getBairro() + "','" + endereco.getComplemento() + "' where cd_pessoa = "
                + endereco.getCd_pessoa());
        conecta_postgre.atualizarSQL(sqlendereco);

        //alterar tabela de telefone
        String sqltelefone = ("update cad_telefone set cd_tipo_telefone,nr_telefone = "
                + telefone.getTipo_telefone() + "," + telefone.getNumero_telefone() + "' where cd_pessoa = "
                + telefone.getCd_pessoa());
        conecta_postgre.atualizarSQL(sqltelefone);

    }

    public void excluir(ClasseFuncionario funcionario,
            ClasseEndereco endereco, ClasseTelefone telefone) {

        String sqlendereco = ("delete from cad_endereco where cd_pessoa = " + endereco.getCd_pessoa());
        conecta_postgre.excluirSQL(sqlendereco);

        String sqltelefone = ("delete from cad_telefone where cd_pessoa = " + telefone.getCd_pessoa());
        conecta_postgre.excluirSQL(sqltelefone);

        String sqlfuncionario = ("delete from cad_funcionario where cd_pessoa = " + funcionario.getId_pessoa());
        conecta_postgre.excluirSQL(sqlfuncionario);

        String sqlpessoafisica = ("delete from cad_pessoa_fisica where cd_pessoa = " + funcionario.getId_pessoa());
        conecta_postgre.excluirSQL(sqlpessoafisica);

        String sqlpessoa = ("delete from cad_pessoa where cd_pessoa = " + funcionario.getId_pessoa());
        conecta_postgre.excluirSQL(sqlpessoa);

    }

    public void retornardados(ClasseFuncionario funcionario, ClasseEndereco endereco, ClasseTelefone telefone) {

        //retorna dados pessoa
        String sqlpessoa = "select cad_pessoa.cd_pessoa,\n"
                + "cad_pessoa.ds_pessoa,cad_pessoa.dt_cadastro,cad_pessoa.tp_pessoa,cad_pessoa.in_situacao,cad_pessoa.e_mail, \n"
                + "cad_pessoa_fisica.rg,cad_pessoa_fisica.cpf,cad_pessoa_fisica.sexo,cad_pessoa_fisica.dt_nascimento,cad_pessoa_fisica.estado_civil,\n"
                + "cad_funcao.ds_funcao,cad_funcionario.dt_demissao,cad_funcionario.salario,cad_funcionario.problema_saude,cad_funcionario.dt_admissao,\n"
                + "cad_cidade.ds_cidade,cad_endereco.rua, cad_endereco.numero, cad_endereco.bairro, cad_endereco.complemento,cad_tipo_telefone.ds_tipo_telefone,cad_telefone.nr_telefone from cad_pessoa\n"
                + "inner join cad_pessoa_fisica on cad_pessoa.cd_pessoa = cad_pessoa_fisica.cd_pessoa\n"
                + "inner join cad_funcionario on cad_pessoa.cd_pessoa = cad_funcionario.cd_pessoa\n"
                + "inner join cad_endereco on cad_pessoa.cd_pessoa = cad_endereco.cd_pessoa\n"
                + "inner join cad_telefone on cad_pessoa.cd_pessoa = cad_telefone.cd_pessoa\n"
                + "inner join cad_tipo_telefone on cad_telefone.cd_tipo_telefone = cad_tipo_telefone.cd_tipo_telefone\n"
                + "inner join cad_cidade on cad_endereco.cd_cidade = cad_cidade.cd_cidade\n"
                + "inner join cad_funcao on cad_funcionario.cd_funcao = cad_funcao.cd_funcao where cad_pessoa.cd_pessoa =" + funcionario.getId_funcao();
        conecta_postgre.executeSQL(sqlpessoa);

        try {

            conecta_postgre.resultset.first();
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cd_pessoa"));
            funcionario.setNm_pessoa(conecta_postgre.resultset.getString("ds_pessoa"));
            funcionario.setDt_cadastro(conecta_postgre.resultset.getString("cad_pessoa.dt_cadastro"));
            funcionario.setTipo_pessoa(conecta_postgre.resultset.getString("cad_pessoa.tp_pessoa"));
            funcionario.setSituacao(conecta_postgre.resultset.getString("cad_pessoa.in_situacao"));
            funcionario.setTipo_pessoa(conecta_postgre.resultset.getString("cad_pessoa_fisica.rg"));
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cad_pessoa_fisica.cpf"));
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cad_pessoa_fisica.sexo"));
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cad_pessoa_fisica.dt_nascimento"));
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cad_pessoa_fisica.estado_civil"));
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cad_funcao.ds_funcao"));
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cad_pessoa_funcionario.dt_demissao"));
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cad_pessoa_funcionario.salario"));
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cad_pessoa_funcionario.problemas_saude"));
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cad_pessoa_funcionario.dt_admissao"));
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cad_cidade.ds_cidade"));
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cad_endereco.rua"));
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cad_endereco.numero"));
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cad_endereco.bairro"));
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cad_endereco.complemento"));
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cad_tipo_telefone.ds_tipo_telefone"));
            funcionario.setId_pessoa(conecta_postgre.resultset.getInt("cad_telefone.nr_telefone"));

        } catch (SQLException ex) {

        }

    }

    public void consultargeral(ClasseFuncionario funcionario) {
        conecta_postgre.executeSQL("select cad_pessoa.cd_pessoa,\n"
                + "cad_pessoa.ds_pessoa,cad_pessoa.dt_cadastro,cad_pessoa.tp_pessoa,cad_pessoa.in_situacao,cad_pessoa.e_mail, \n"
                + "cad_pessoa_fisica.rg,cad_pessoa_fisica.cpf,cad_pessoa_fisica.sexo,cad_pessoa_fisica.dt_nascimento,cad_pessoa_fisica.estado_civil,\n"
                + "cad_funcao.ds_funcao,cad_funcionario.dt_demissao,cad_funcionario.salario,cad_funcionario.problema_saude,cad_funcionario.dt_admissao,\n"
                + "cad_cidade.ds_cidade,cad_endereco.rua, cad_endereco.numero, cad_endereco.bairro, cad_endereco.complemento,cad_tipo_telefone.ds_tipo_telefone,cad_telefone.nr_telefone from cad_pessoa\n"
                + "inner join cad_pessoa_fisica on cad_pessoa.cd_pessoa = cad_pessoa_fisica.cd_pessoa\n"
                + "inner join cad_funcionario on cad_pessoa.cd_pessoa = cad_funcionario.cd_pessoa\n"
                + "inner join cad_endereco on cad_pessoa.cd_pessoa = cad_endereco.cd_pessoa\n"
                + "inner join cad_telefone on cad_pessoa.cd_pessoa = cad_telefone.cd_pessoa\n"
                + "inner join cad_tipo_telefone on cad_telefone.cd_tipo_telefone = cad_tipo_telefone.cd_tipo_telefone\n"
                + "inner join cad_cidade on cad_endereco.cd_cidade = cad_cidade.cd_cidade\n"
                + "inner join cad_funcao on cad_funcionario.cd_funcao = cad_funcao.cd_funcao");
        funcionario.setRetorno(conecta_postgre.resultset);
    }

    public void consultacodigo(ClasseFuncionario funcionario) {
        conecta_postgre.executeSQL("select cad_pessoa.cd_pessoa,\n"
                + "cad_pessoa.ds_pessoa,cad_pessoa.dt_cadastro,cad_pessoa.tp_pessoa,cad_pessoa.in_situacao,cad_pessoa.e_mail, \n"
                + "cad_pessoa_fisica.rg,cad_pessoa_fisica.cpf,cad_pessoa_fisica.sexo,cad_pessoa_fisica.dt_nascimento,cad_pessoa_fisica.estado_civil,\n"
                + "cad_funcao.ds_funcao,cad_funcionario.dt_demissao,cad_funcionario.salario,cad_funcionario.problema_saude,cad_funcionario.dt_admissao,\n"
                + "cad_cidade.ds_cidade,cad_endereco.rua, cad_endereco.numero, cad_endereco.bairro, cad_endereco.complemento,cad_tipo_telefone.ds_tipo_telefone,cad_telefone.nr_telefone from cad_pessoa\n"
                + "inner join cad_pessoa_fisica on cad_pessoa.cd_pessoa = cad_pessoa_fisica.cd_pessoa\n"
                + "inner join cad_funcionario on cad_pessoa.cd_pessoa = cad_funcionario.cd_pessoa\n"
                + "inner join cad_endereco on cad_pessoa.cd_pessoa = cad_endereco.cd_pessoa\n"
                + "inner join cad_telefone on cad_pessoa.cd_pessoa = cad_telefone.cd_pessoa\n"
                + "inner join cad_tipo_telefone on cad_telefone.cd_tipo_telefone = cad_tipo_telefone.cd_tipo_telefone\n"
                + "inner join cad_cidade on cad_endereco.cd_cidade = cad_cidade.cd_cidade\n"
                + "inner join cad_funcao on cad_funcionario.cd_funcao = cad_funcao.cd_funcao where cad_pessoa.cd_pessoa = " + funcionario.getId_funcionario());
        funcionario.setRetorno(conecta_postgre.resultset);

    }

    public void consultadescricao(ClasseFuncionario funcionario) {
        conecta_postgre.executeSQL("select cad_pessoa.cd_pessoa,\n"
                + "cad_pessoa.ds_pessoa,cad_pessoa.dt_cadastro,cad_pessoa.tp_pessoa,cad_pessoa.in_situacao,cad_pessoa.e_mail, \n"
                + "cad_pessoa_fisica.rg,cad_pessoa_fisica.cpf,cad_pessoa_fisica.sexo,cad_pessoa_fisica.dt_nascimento,cad_pessoa_fisica.estado_civil,\n"
                + "cad_funcao.ds_funcao,cad_funcionario.dt_demissao,cad_funcionario.salario,cad_funcionario.problema_saude,cad_funcionario.dt_admissao,\n"
                + "cad_cidade.ds_cidade,cad_endereco.rua, cad_endereco.numero, cad_endereco.bairro, cad_endereco.complemento,cad_tipo_telefone.ds_tipo_telefone,cad_telefone.nr_telefone from cad_pessoa\n"
                + "inner join cad_pessoa_fisica on cad_pessoa.cd_pessoa = cad_pessoa_fisica.cd_pessoa\n"
                + "inner join cad_funcionario on cad_pessoa.cd_pessoa = cad_funcionario.cd_pessoa\n"
                + "inner join cad_endereco on cad_pessoa.cd_pessoa = cad_endereco.cd_pessoa\n"
                + "inner join cad_telefone on cad_pessoa.cd_pessoa = cad_telefone.cd_pessoa\n"
                + "inner join cad_tipo_telefone on cad_telefone.cd_tipo_telefone = cad_tipo_telefone.cd_tipo_telefone\n"
                + "inner join cad_cidade on cad_endereco.cd_cidade = cad_cidade.cd_cidade\n"
                + "inner join cad_funcao on cad_funcionario.cd_funcao = cad_funcao.cd_funcao where cad_pessoa.ds_pessoa like '%" + funcionario.getNm_pessoa() + "%'");
        funcionario.setRetorno(conecta_postgre.resultset);

    }

    public void consultaCpf(ClasseFuncionario funcionario) {
        conecta_postgre.executeSQL("select cad_pessoa.cd_pessoa,\n"
                + "cad_pessoa.ds_pessoa,cad_pessoa.dt_cadastro,cad_pessoa.tp_pessoa,cad_pessoa.in_situacao,cad_pessoa.e_mail, \n"
                + "cad_pessoa_fisica.rg,cad_pessoa_fisica.cpf,cad_pessoa_fisica.sexo,cad_pessoa_fisica.dt_nascimento,cad_pessoa_fisica.estado_civil,\n"
                + "cad_funcao.ds_funcao,cad_funcionario.dt_demissao,cad_funcionario.salario,cad_funcionario.problema_saude,cad_funcionario.dt_admissao,\n"
                + "cad_cidade.ds_cidade,cad_endereco.rua, cad_endereco.numero, cad_endereco.bairro, cad_endereco.complemento,cad_tipo_telefone.ds_tipo_telefone,cad_telefone.nr_telefone from cad_pessoa\n"
                + "inner join cad_pessoa_fisica on cad_pessoa.cd_pessoa = cad_pessoa_fisica.cd_pessoa\n"
                + "inner join cad_funcionario on cad_pessoa.cd_pessoa = cad_funcionario.cd_pessoa\n"
                + "inner join cad_endereco on cad_pessoa.cd_pessoa = cad_endereco.cd_pessoa\n"
                + "inner join cad_telefone on cad_pessoa.cd_pessoa = cad_telefone.cd_pessoa\n"
                + "inner join cad_tipo_telefone on cad_telefone.cd_tipo_telefone = cad_tipo_telefone.cd_tipo_telefone\n"
                + "inner join cad_cidade on cad_endereco.cd_cidade = cad_cidade.cd_cidade\n"
                + "inner join cad_funcao on cad_funcionario.cd_funcao = cad_funcao.cd_funcao where cad_pessoa_fisica.cpf like '%" + funcionario.getCpf()+ "%'");
        funcionario.setRetorno(conecta_postgre.resultset);

    }

    public void consultaRg(ClasseFuncionario funcionario) {
        conecta_postgre.executeSQL("select cad_pessoa.cd_pessoa,\n"
                + "cad_pessoa.ds_pessoa,cad_pessoa.dt_cadastro,cad_pessoa.tp_pessoa,cad_pessoa.in_situacao,cad_pessoa.e_mail, \n"
                + "cad_pessoa_fisica.rg,cad_pessoa_fisica.cpf,cad_pessoa_fisica.sexo,cad_pessoa_fisica.dt_nascimento,cad_pessoa_fisica.estado_civil,\n"
                + "cad_funcao.ds_funcao,cad_funcionario.dt_demissao,cad_funcionario.salario,cad_funcionario.problema_saude,cad_funcionario.dt_admissao,\n"
                + "cad_cidade.ds_cidade,cad_endereco.rua, cad_endereco.numero, cad_endereco.bairro, cad_endereco.complemento,cad_tipo_telefone.ds_tipo_telefone,cad_telefone.nr_telefone from cad_pessoa\n"
                + "inner join cad_pessoa_fisica on cad_pessoa.cd_pessoa = cad_pessoa_fisica.cd_pessoa\n"
                + "inner join cad_funcionario on cad_pessoa.cd_pessoa = cad_funcionario.cd_pessoa\n"
                + "inner join cad_endereco on cad_pessoa.cd_pessoa = cad_endereco.cd_pessoa\n"
                + "inner join cad_telefone on cad_pessoa.cd_pessoa = cad_telefone.cd_pessoa\n"
                + "inner join cad_tipo_telefone on cad_telefone.cd_tipo_telefone = cad_tipo_telefone.cd_tipo_telefone\n"
                + "inner join cad_cidade on cad_endereco.cd_cidade = cad_cidade.cd_cidade\n"
                + "inner join cad_funcao on cad_funcionario.cd_funcao = cad_funcao.cd_funcao where cad_pessoa_fisica.rg like '%" + funcionario.getRg()+ "%'");
        funcionario.setRetorno(conecta_postgre.resultset);

    }
}
