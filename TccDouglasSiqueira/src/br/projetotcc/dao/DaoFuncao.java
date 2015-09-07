/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetotcc.dao;

import br.projetotcc.classe.ClasseFuncao;
import br.projetotcc.conexao.ConexaoPostgre;
import br.projetotcc.validacoes.UltimaSequencia;
import java.sql.SQLException;

/**
 *
 * @author DOUGLAS
 */
public class DaoFuncao {
     ConexaoPostgre conecta_postgre;
    UltimaSequencia ultima;

    public DaoFuncao() {
        conecta_postgre = new ConexaoPostgre();

    }

    public void incluir(ClasseFuncao funcao) {
        ultima = new UltimaSequencia();
        int sequencia = (Integer) (ultima.ultimasequencia("funcao", "id_funcao"));
        String sql = " insert into funcao values( "
                + sequencia + " ,' "
                + funcao.getDs_funcao()+ "')";
                
        funcao.setId_funcao(sequencia);
        conecta_postgre.incluirSQL(sql);
        
    }

    public void alterar(ClasseFuncao funcao) {

        String sql = ("update funcao set ds_funcao = '" + funcao.getDs_funcao()+ "' where id_funcao = "
                + funcao.getId_funcao());

        conecta_postgre.atualizarSQL(sql);

    }

    public void excluir(ClasseFuncao funcao) {

        String sql = ("delete from funcao where id_funcao = " + funcao.getId_funcao());
        conecta_postgre.excluirSQL(sql);

    }

    public void retornardados(ClasseFuncao funcao) {
        String sql = "select id_funcao,ds_funcao from funcao "
                + "where id_funcao = " + funcao.getId_funcao();
        conecta_postgre.executeSQL(sql);

        try {

            conecta_postgre.resultset.first();
            funcao.setId_funcao(conecta_postgre.resultset.getInt("id_funcao"));
            funcao.setDs_funcao(conecta_postgre.resultset.getString("ds_funcao"));
           
        } catch (SQLException ex) {

        }
    }

    public void consultargeral(ClasseFuncao funcao) {
        conecta_postgre.executeSQL("select * from funcao");
        funcao.setRetorno(conecta_postgre.resultset);
    }

    public void consultacodigo(ClasseFuncao funcao) {
        conecta_postgre.executeSQL("select * from funcao where id_funcao = " + funcao.getId_funcao());
        funcao.setRetorno(conecta_postgre.resultset);

    }

    public void consultadescricao(ClasseFuncao funcao) {
        conecta_postgre.executeSQL("select * from funcao where ds_funcao like '%" + funcao.getDs_funcao()+ "%'");
        funcao.setRetorno(conecta_postgre.resultset);    

    }


}
