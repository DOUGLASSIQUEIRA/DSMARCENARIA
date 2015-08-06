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
        int sequencia = (Integer) (ultima.ultimasequencia("cidade", "id_cidade"));
        String sql = " insert into cidade values( "
                + sequencia + " ,' "
                + cidade.getNm_cidade()+ "',"
                + cidade.getCep()+",'"
                + cidade.getPais()+"','"
                + cidade.getUf()+"')";
                
        cidade.setId_cidade(sequencia);
        conecta_postgre.incluirSQL(sql);
        
    }

    public void alterar(ClasseCidade cidade) {

        String sql = ("update autor set cidade = '" + cidade.getNm_cidade()+ "' where id_cidade = "
                + cidade.getId_cidade());

        conecta_postgre.atualizarSQL(sql);

    }

    public void excluir(ClasseCidade cidade) {

        String sql = ("delete from cidade where id_cidade = " + cidade.getId_cidade());
        conecta_postgre.excluirSQL(sql);

    }

    public void retornardados(ClasseCidade cidade) {
        String sql = "select id_cidade,nm_cidade, cep, pais, uf  from cidade "
                + "where id_cidade = " + cidade.getId_cidade();
        conecta_postgre.executeSQL(sql);

        try {

            conecta_postgre.resultset.first();
            cidade.setId_cidade(conecta_postgre.resultset.getInt("id_cidade"));
            cidade.setNm_cidade(conecta_postgre.resultset.getString("nm_cidade"));
            cidade.setCep(conecta_postgre.resultset.getInt("cep"));
            cidade.setPais(conecta_postgre.resultset.getString("pais"));
            cidade.setUf(conecta_postgre.resultset.getString("uf"));

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











}
