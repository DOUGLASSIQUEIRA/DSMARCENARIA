/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetotcc.dao;

import br.projetotcc.classe.ClasseUnidadeMedida;
import br.projetotcc.conexao.ConexaoPostgre;
import br.projetotcc.validacoes.UltimaSequencia;
import java.sql.SQLException;

/**
 *
 * @author DOUGLAS
 */
public class DaoUnidadeMedida {
    
     ConexaoPostgre conecta_postgre;
    UltimaSequencia ultima;

    public DaoUnidadeMedida() {
        conecta_postgre = new ConexaoPostgre();

    }

    public void incluir(ClasseUnidadeMedida unmedida) {
        ultima = new UltimaSequencia();
        int sequencia = (Integer) (ultima.ultimasequencia("unidade_medida", "id_unidade_medida"));
        String sql = " insert into unidade_medida values( "
                + sequencia + " ,' "
                + unmedida.getDs_unidade_medida()+ "')";
                
        unmedida.setId_unidade_medida(sequencia);
        conecta_postgre.incluirSQL(sql);
        
    }

    public void alterar(ClasseUnidadeMedida unmedida) {

        String sql = ("update unidade_medida set ds_unidade_medida = '" + unmedida.getDs_unidade_medida()+ "' where id_unidade_medida = "
                + unmedida.getId_unidade_medida());

        conecta_postgre.atualizarSQL(sql);

    }

    public void excluir(ClasseUnidadeMedida unmedida) {

        String sql = ("delete from unidade_medida where id_unidade_medida = " + unmedida.getId_unidade_medida());
        conecta_postgre.excluirSQL(sql);

    }

    public void retornardados(ClasseUnidadeMedida unmedida) {
        String sql = "select id_unidade_medida,ds_unidade_medida from unidade_medida "
                + "where id_unidade_medida = " + unmedida.getId_unidade_medida();
        conecta_postgre.executeSQL(sql);

        try {

            conecta_postgre.resultset.first();
            unmedida.setId_unidade_medida(conecta_postgre.resultset.getInt("id_unidade_medida"));
            unmedida.setDs_unidade_medida(conecta_postgre.resultset.getString("ds_unidade_medida"));
           
        } catch (SQLException ex) {

        }
    }

    public void consultargeral(ClasseUnidadeMedida unmedida) {
        conecta_postgre.executeSQL("select * from unidade_medida");
        unmedida.setRetorno(conecta_postgre.resultset);
    }

    public void consultacodigo(ClasseUnidadeMedida unmedida) {
        conecta_postgre.executeSQL("select * from unidade_medida where id_unidade_medida = " + unmedida.getId_unidade_medida());
        unmedida.setRetorno(conecta_postgre.resultset);

    }

    public void consultadescricao(ClasseUnidadeMedida unmedida) {
        conecta_postgre.executeSQL("select * from unidade_medida where ds_unidade_medida like '%" + unmedida.getDs_unidade_medida()+ "%'");
        unmedida.setRetorno(conecta_postgre.resultset);    

    }

    
}
