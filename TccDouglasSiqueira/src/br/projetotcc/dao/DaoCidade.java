/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetotcc.dao;

import br.projetotcc.classe.ClasseCidade;
import br.projetotcc.conexao.ConexaoPostgre;
import br.projetotcc.validacoes.UltimaSequencia;
import java.sql.SQLException;

/**
 *
 * @author DOUGLAS
 */
public class DaoCidade {
     ConexaoPostgre conecta_postgre;
    UltimaSequencia ultima;

    public DaoCidade() {
        conecta_postgre = new ConexaoPostgre();

    }

    public void incluir(ClasseCidade cidade) {
        ultima = new UltimaSequencia();
        int sequencia = (Integer) (ultima.ultimasequencia("cad_cidade", "cd_cidade"));
        String sql = " insert into cad_cidade values( "
                + sequencia + " ,' "
                + cidade.getNm_cidade()+ "','"
                + cidade.getUf()+"',"
                + cidade.getCep()+",'"
                + cidade.getPais()+"')";
                
        cidade.setId_cidade(sequencia);
        conecta_postgre.incluirSQL(sql);
        
    }

    public void alterar(ClasseCidade cidade) {

        String sql = ("update cad_cidade set ds_cidade,cep,pais = '" + cidade.getNm_cidade()+ cidade.getCep()+cidade.getPais()+ "'where cd_cidade = "
                + cidade.getId_cidade());

        conecta_postgre.atualizarSQL(sql);

    }

    public void excluir(ClasseCidade cidade) {

        String sql = ("delete from cad_cidade where cd_cidade = " + cidade.getId_cidade());
        conecta_postgre.excluirSQL(sql);

    }

    public void retornardados(ClasseCidade cidade) {
        String sql = "select cd_cidade,ds_cidade, cd_uf,cep,pais from cad_cidade "
                + "where cd_cidade = " + cidade.getId_cidade();
        conecta_postgre.executeSQL(sql);

        try {

            conecta_postgre.resultset.first();
            cidade.setId_cidade(conecta_postgre.resultset.getInt("cd_cidade"));
            cidade.setNm_cidade(conecta_postgre.resultset.getString("ds_cidade"));
            cidade.setCep(conecta_postgre.resultset.getInt("cep"));
            cidade.setUf(conecta_postgre.resultset.getString("cd_uf"));
            cidade.setPais(conecta_postgre.resultset.getString("pais"));


        } catch (SQLException ex) {

        }
    }

    public void consultargeral(ClasseCidade cidade) {
        conecta_postgre.executeSQL("select * from cad_cidade");
        cidade.setRetorno(conecta_postgre.resultset);
    }

    public void consultacodigo(ClasseCidade cidade) {
        conecta_postgre.executeSQL("select * from cad_cidade where cd_cidade = " + cidade.getId_cidade());
        cidade.setRetorno(conecta_postgre.resultset);

    }

    public void consultadescricao(ClasseCidade cidade) {
        conecta_postgre.executeSQL("select * from cad_cidade where ds_cidade like '%" + cidade.getNm_cidade()+ "%'");
        cidade.setRetorno(conecta_postgre.resultset);
    }
    
     public void consultauf(ClasseCidade cidade) {
        conecta_postgre.executeSQL("select * from cad_cidade where cd_uf like '%" + cidade.getUf()+ "%'");
        cidade.setRetorno(conecta_postgre.resultset);
    }

}
