/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetotcc.dao;

import br.projetotcc.classe.ClasseTipoProduto;
import br.projetotcc.conexao.ConexaoPostgre;
import br.projetotcc.validacoes.UltimaSequencia;
import java.sql.SQLException;

/**
 *
 * @author DOUGLAS
 */
public class DaoTipoProduto {
     ConexaoPostgre conecta_postgre;
    UltimaSequencia ultima;

    public DaoTipoProduto() {
        conecta_postgre = new ConexaoPostgre();

    }

    public void incluir(ClasseTipoProduto tipoproduto) {
        ultima = new UltimaSequencia();
        int sequencia = (Integer) (ultima.ultimasequencia("cad_tipo_produto", "cd_tipo_produto"));
        String sql = " insert into cad_tipo_produto values( "
                + sequencia + " ,' "
                + tipoproduto.getDs_tipo_produto()+ "')";
                
        tipoproduto.setId_tipo_produto(sequencia);
        conecta_postgre.incluirSQL(sql);
        
    }

    public void alterar(ClasseTipoProduto tipoproduto) {

        String sql = ("update cad_tipo_produto set ds_tipo_produto = '" + tipoproduto.getDs_tipo_produto()+ "'where cd_tipo_produto = "
                + tipoproduto.getId_tipo_produto());

        conecta_postgre.atualizarSQL(sql);

    }

    public void excluir(ClasseTipoProduto tipoproduto) {

        String sql = ("delete from cad_tipo_produto where cd_tipo_produto = " + tipoproduto.getId_tipo_produto());
        conecta_postgre.excluirSQL(sql);

    }

    public void retornardados(ClasseTipoProduto tipoproduto) {
        String sql = "select cd_tipo_produto,ds_tipo_produto from cad_tipo_produto "
                + "where cd_tipo_produto = " + tipoproduto.getId_tipo_produto();
        conecta_postgre.executeSQL(sql);

        try {

            conecta_postgre.resultset.first();
            tipoproduto.setId_tipo_produto(conecta_postgre.resultset.getInt("cd_tipo_produto"));
            tipoproduto.setDs_tipo_produto(conecta_postgre.resultset.getString("ds_tipo_produto"));


        } catch (SQLException ex) {

        }
    }

    public void consultargeral(ClasseTipoProduto tipoproduto) {
        conecta_postgre.executeSQL("select * from cad_tipo_produto");
        tipoproduto.setRetorno(conecta_postgre.resultset);
    }

    public void consultacodigo(ClasseTipoProduto tipoproduto) {
        conecta_postgre.executeSQL("select * from cad_tipo_produto where cd_tipo_produto = " + tipoproduto.getId_tipo_produto());
        tipoproduto.setRetorno(conecta_postgre.resultset);

    }

    public void consultadescricao(ClasseTipoProduto tipoproduto) {
        conecta_postgre.executeSQL("select * from cad_tipo_produto where ds_tipo_produto like '%" + tipoproduto.getDs_tipo_produto()+ "%'");
        tipoproduto.setRetorno(conecta_postgre.resultset);
        
        

    }

}
