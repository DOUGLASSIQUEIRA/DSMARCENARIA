/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetotcc.dao;

import br.projetotcc.classe.ClasseFormaPagamento;
import br.projetotcc.conexao.ConexaoPostgre;
import br.projetotcc.validacoes.UltimaSequencia;
import java.sql.SQLException;

/**
 *
 * @author DOUGLAS
 */
public class DaoFormaPagamento {
     ConexaoPostgre conecta_postgre;
    UltimaSequencia ultima;

    public DaoFormaPagamento() {
        conecta_postgre = new ConexaoPostgre();

    }

    public void incluir(ClasseFormaPagamento formapgto) {
        ultima = new UltimaSequencia();
        int sequencia = (Integer) (ultima.ultimasequencia("forma_pagamento", "id_forma_pagamento"));
        String sql = " insert into forma_pagamento values( "
                + sequencia + " ,' "
                + formapgto.getDs_forma()+ "',"
                + formapgto.getIntervalo()+",'"
                + formapgto.getEntrada()+"')";
                
        formapgto.setId_forma_pagamento(sequencia);
        conecta_postgre.incluirSQL(sql);
        
    }

    public void alterar(ClasseFormaPagamento formapgto) {

        String sql = ("update forma_pagamento set ds_forma_pagamento = '" + formapgto.getDs_forma()+ "'where id_forma_pagamento = "
                + formapgto.getId_forma_pagamento());

        conecta_postgre.atualizarSQL(sql);

    }

    public void excluir(ClasseFormaPagamento formapgto) {

        String sql = ("delete from forma_pagamento where id_forma_pagamento = " + formapgto.getId_forma_pagamento());
        conecta_postgre.excluirSQL(sql);

    }

    public void retornardados(ClasseFormaPagamento formapgto) {
        String sql = "select id_forma_pagamento,ds_forma_pagamento, intervalo, entrada from forma_pagamento "
                + "where id_forma_pagamento = " + formapgto.getId_forma_pagamento();
        conecta_postgre.executeSQL(sql);

        try {

            conecta_postgre.resultset.first();
            formapgto.setId_forma_pagamento(conecta_postgre.resultset.getInt("id_forma_pagamento"));
            formapgto.setDs_forma(conecta_postgre.resultset.getString("ds_forma_pagamento"));
            formapgto.setIntervalo(conecta_postgre.resultset.getInt("intervalo"));
            formapgto.setEntrada(conecta_postgre.resultset.getString("entrada"));

        } catch (SQLException ex) {

        }
    }

    public void consultargeral(ClasseFormaPagamento formapgto) {
        conecta_postgre.executeSQL("select * from forma_pagamento");
        formapgto.setRetorno(conecta_postgre.resultset);
    }

    public void consultacodigo(ClasseFormaPagamento formapgto) {
        conecta_postgre.executeSQL("select * from forma_pagamento where id_forma_pagamento = " + formapgto.getId_forma_pagamento());
        formapgto.setRetorno(conecta_postgre.resultset);

    }

    public void consultadescricao(ClasseFormaPagamento formapgto) {
        conecta_postgre.executeSQL("select * from forma_pagamento where ds_forma_pagamento like '%" + formapgto.getDs_forma()+ "%'");
        formapgto.setRetorno(conecta_postgre.resultset);
        
        

    }

}
