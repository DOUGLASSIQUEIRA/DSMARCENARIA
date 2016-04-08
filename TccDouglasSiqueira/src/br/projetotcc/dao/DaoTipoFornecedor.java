/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetotcc.dao;

import br.projetotcc.classe.ClasseTipoFornecedor;
import br.projetotcc.conexao.ConexaoPostgre;
import br.projetotcc.validacoes.UltimaSequencia;
import java.sql.SQLException;

/**
 *
 * @author DOUGLAS
 */
public class DaoTipoFornecedor {
     ConexaoPostgre conecta_postgre;
    UltimaSequencia ultima;

    public DaoTipoFornecedor() {
        conecta_postgre = new ConexaoPostgre();

    }

    public void incluir(ClasseTipoFornecedor tipofornecedor) {
        ultima = new UltimaSequencia();
        int sequencia = (Integer) (ultima.ultimasequencia("cad_tipo_fornecedor", "cd_tipo_fornecedor"));
        String sql = " insert into cad_tipo_fornecedor values( "
                + sequencia + " ,' "
                + tipofornecedor.getDs_tipo_fornecedpr()+ "')";
                
        tipofornecedor.setId_tipo_fornecedor(sequencia);
        conecta_postgre.incluirSQL(sql);
        
    }

    public void alterar(ClasseTipoFornecedor tipofornecedor) {

        String sql = ("update cad_tipo_fornecedor set ds_tipo_fornecedor = '" + tipofornecedor.getDs_tipo_fornecedpr()+ "'where cd_tipo_fornecedor = "
                + tipofornecedor.getId_tipo_fornecedor());

        conecta_postgre.atualizarSQL(sql);

    }

    public void excluir(ClasseTipoFornecedor tipofornecedor) {

        String sql = ("delete from cad_tipo_fornecedor where cd_tipo_fornecedor = " + tipofornecedor.getId_tipo_fornecedor());
        conecta_postgre.excluirSQL(sql);

    }

    public void retornardados(ClasseTipoFornecedor tipofornecedor) {
        String sql = "select cd_tipo_fornecedor,ds_tipo_fornecedor from cad_tipo_fornecedor "
                + "where cd_tipo_fornecedor = " + tipofornecedor.getId_tipo_fornecedor();
        conecta_postgre.executeSQL(sql);

        try {

            conecta_postgre.resultset.first();
            tipofornecedor.setId_tipo_fornecedor(conecta_postgre.resultset.getInt("cd_tipo_fornecedor"));
            tipofornecedor.setDs_tipo_fornecedpr(conecta_postgre.resultset.getString("ds_tipo_fornecedor"));


        } catch (SQLException ex) {

        }
    }

    public void consultargeral(ClasseTipoFornecedor tipofornecedor) {
        conecta_postgre.executeSQL("select * from cad_tipo_fornecedor");
        tipofornecedor.setRetorno(conecta_postgre.resultset);
    }

    public void consultacodigo(ClasseTipoFornecedor tipofornecedor) {
        conecta_postgre.executeSQL("select * from cad_tipo_fornecedor where cd_tipo_fornecedor = " + tipofornecedor.getId_tipo_fornecedor());
        tipofornecedor.setRetorno(conecta_postgre.resultset);

    }

    public void consultadescricao(ClasseTipoFornecedor tipofornecedor) {
        conecta_postgre.executeSQL("select * from cad_tipo_fornecedor where ds_tipo_fornecedor like '%" + tipofornecedor.getDs_tipo_fornecedpr()+ "%'");
        tipofornecedor.setRetorno(conecta_postgre.resultset);
        
        

    }

}
