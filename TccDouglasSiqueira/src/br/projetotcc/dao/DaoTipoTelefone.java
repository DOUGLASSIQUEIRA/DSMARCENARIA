
package br.projetotcc.dao;

import br.projetotcc.classe.ClasseTipoTelefone;
import br.projetotcc.conexao.ConexaoPostgre;
import br.projetotcc.validacoes.UltimaSequencia;
import java.sql.SQLException;

/**
 *
 * @author DOUGLAS
 */
public class DaoTipoTelefone {
     ConexaoPostgre conecta_postgre;
    UltimaSequencia ultima;

    public DaoTipoTelefone() {
        conecta_postgre = new ConexaoPostgre();

    }

    public void incluir(ClasseTipoTelefone tipotelefone) {
        ultima = new UltimaSequencia();
        int sequencia = (Integer) (ultima.ultimasequencia("cad_tipo_telefone", "cd_tipo_telefone"));
        String sql = " insert into cad_tipo_telefone values( "
                + sequencia + " ,' "
                + tipotelefone.getDs_tipo_telefone()+ "')";
                
        tipotelefone.setId_tipo_telefone(sequencia);
        conecta_postgre.incluirSQL(sql);
        
    }

    public void alterar(ClasseTipoTelefone tipotelefone) {

        String sql = ("update cad_tipo_telefone set ds_tipo_telefone = '" + tipotelefone.getDs_tipo_telefone()+ "' where cd_tipo_telefone = "
                + tipotelefone.getId_tipo_telefone());

        conecta_postgre.atualizarSQL(sql);

    }

    public void excluir(ClasseTipoTelefone tipotelefone) {

        String sql = ("delete from cad_tipo_telefone where cd_tipo_telefone = " + tipotelefone.getId_tipo_telefone());
        conecta_postgre.excluirSQL(sql);

    }

    public void retornardados(ClasseTipoTelefone tipotelefone) {
        String sql = "select cd_tipo_telefone,ds_tipo_telefone from cad_tipo_telefone "
                + "where cd_tipo_telefone = " + tipotelefone.getId_tipo_telefone();
        conecta_postgre.executeSQL(sql);

        try {

            conecta_postgre.resultset.first();
            tipotelefone.setId_tipo_telefone(conecta_postgre.resultset.getInt("cd_tipo_telefone"));
            tipotelefone.setDs_tipo_telefone(conecta_postgre.resultset.getString("ds_tipo_telefone"));
           
        } catch (SQLException ex) {

        }
    }

    public void consultargeral(ClasseTipoTelefone tipotelefone) {
        conecta_postgre.executeSQL("select * from cad_tipo_telefone");
        tipotelefone.setRetorno(conecta_postgre.resultset);
    }

    public void consultacodigo(ClasseTipoTelefone tipotelefone) {
        conecta_postgre.executeSQL("select * from cad_tipo_telefone where cd_tipo_telefone = " + tipotelefone.getId_tipo_telefone());
        tipotelefone.setRetorno(conecta_postgre.resultset);

    }

    public void consultadescricao(ClasseTipoTelefone tipotelefone) {
        conecta_postgre.executeSQL("select * from cad_tipo_telefone where ds_tipo_telefone like '%" + tipotelefone.getDs_tipo_telefone()+ "%'");
        tipotelefone.setRetorno(conecta_postgre.resultset);    

    }


}
