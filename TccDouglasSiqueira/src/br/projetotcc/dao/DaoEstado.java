package br.projetotcc.dao;

import br.projetotcc.classe.ClasseUf;
import br.projetotcc.conexao.ConexaoPostgre;
import br.projetotcc.validacoes.UltimaSequencia;
import java.sql.SQLException;

/**
 *
 * @author DOUGLAS
 */
public class DaoEstado {

    ConexaoPostgre conecta_postgre;
    UltimaSequencia ultima;

    public DaoEstado() {
        conecta_postgre = new ConexaoPostgre();

    }

    public void incluir(ClasseUf estado) {
        String sql = " insert into uf values( '"
                + estado.getUf() + " ',' "
                + estado.getNm_estado() + "')";
        conecta_postgre.incluirSQL(sql);

    }

    public void alterar(ClasseUf estado) {

        String sql = ("update cidade set nm_cidade = '" + estado.getNm_estado() + "' where id_cidade = "
                + estado.getUf());

        conecta_postgre.atualizarSQL(sql);

    }

    public void excluir(ClasseUf estado) {

        String sql = ("delete from uf where id_uf = " + estado.getUf());
        conecta_postgre.excluirSQL(sql);

    }

    public void retornardados(ClasseUf estado) {
        String sql = "select id_uf, nm_uf from uf "
                + "where id_uf = " + estado.getUf();
        conecta_postgre.executeSQL(sql);

        try {

            conecta_postgre.resultset.first();
            estado.setUf(conecta_postgre.resultset.getString("id_uf"));
            estado.setNm_estado(conecta_postgre.resultset.getString("nm_uf"));

        } catch (SQLException ex) {

        }
    }

    public void consultargeral(ClasseUf estado) {
        conecta_postgre.executeSQL("select * from uf");
        estado.setRetorno(conecta_postgre.resultset);
    }

    public void consultacodigo(ClasseUf estado) {
        conecta_postgre.executeSQL("select * from uf where id_uf like '%" + estado.getUf() + "%'");
        estado.setRetorno(conecta_postgre.resultset);

    }

    public void consultadescricao(ClasseUf estado) {
        conecta_postgre.executeSQL("select * from uf where nm_uf like '%" + estado.getNm_estado() + "%'");
        estado.setRetorno(conecta_postgre.resultset);

    }
}
