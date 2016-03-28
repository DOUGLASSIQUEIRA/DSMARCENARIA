/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetotcc.interfaces;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author DOUGLAS
 */
public class teste {
    
//     Connection c;
//    final Logger logger;
//
//    public ClasseCidade() throws Exception {
//        this.c = (Connection) ConexaoMysql.getConn().conn;
//        logger = Logger.getLogger("br.sistemas.sgc.control");
//    }
//
//    public int RetornaCodigo(String cidade) {
//        int cod = 0;
//        String sql = "SELECT `cd_cidade` "
//                + "FROM `cad_cidade` "
//                + "WHERE `ds_cidade` = '" + cidade + "'";
//        try {
//            PreparedStatement pStm = (PreparedStatement) c.prepareStatement(sql);
//            ResultSet rs = pStm.executeQuery();
//            if (rs.next()) {
//                cod = (rs.getInt("cd_cidade"));
//            }
//        } catch (Exception ex) {
//            logger.warning(String.valueOf(ex));
//        }
//        return cod;
//    }
//
//    public boolean Recuperar(Cidade cidade) {
//        cidade.setErro("");
//        try {
//            String SQL = "SELECT `cd_cidade`,`ds_sigla`, "
//                    + "`ds_cidade`,`ds_observacao` "
//                    + "FROM `cad_cidade` "
//                    + "where cd_cidade = ?";
//            PreparedStatement pStm = (PreparedStatement) c.prepareStatement(SQL);
//            pStm.setInt(1, cidade.getCd_cidade());
//            ResultSet rs = pStm.executeQuery();
//            if (rs.next()) {
//                cidade.setCd_cidade(rs.getInt("cd_cidade"));
//                cidade.setDs_cidade(rs.getString("ds_cidade"));
//                cidade.setObservacao(rs.getString("ds_observacao"));
//                cidade.getUf().setSigla(rs.getString("ds_sigla"));
//                ClasseUf classeUf = null;
//                try {
//                    classeUf = new ClasseUf();
//                } catch (Exception e) {
//                    logger.warning((Supplier<String>) e);
//                }
//                classeUf.Recuperar(cidade.getUf());
//                return true;
//            } else {
//                cidade.setErro("Código da Cidade Não Cadastrada");
//                return false;
//            }
//        } catch (SQLException ex) {
//            logger.warning(String.valueOf(ex));
//            cidade.setErro("Erro no SQL");
//            return false;
//        }
//    }
//
//    public void add(Cidade cidade) {
//        cidade.setErro("");
//        String SQL = "INSERT INTO `cad_cidade`"
//                + "(`cd_cidade`, `ds_sigla`, "
//                + "`ds_cidade`, `ds_observacao`)"
//                + " VALUES (?, ?, ?, ?)";
//        try (PreparedStatement pStm = (PreparedStatement) c.prepareStatement(SQL)) {
//            UltimaSequencia us = new UltimaSequencia("cd_cidade", "cad_cidade");
//            pStm.setString(1, us.getUlt());
//            pStm.setString(2, cidade.getUf().getSigla().toUpperCase());
//            pStm.setString(3, cidade.getDs_cidade().toUpperCase());
//            pStm.setString(4, cidade.getObservacao());
//            cidade.setCd_cidade(Integer.parseInt(us.getUlt()));
//            pStm.execute();
//
//        } catch (SQLException ex) {
//            cidade.setErro("ERRO: " + ex.getMessage());
//            logger.warning(String.valueOf(ex));
//        }
//    }
//
//    public void del(Cidade cidade) {
//        String SQL = "DELETE FROM `cad_cidade` WHERE cd_cidade = ?";
//        try (PreparedStatement pStm = (PreparedStatement) c.prepareStatement(SQL)) {
//            pStm.setInt(1, cidade.getCd_cidade());
//            pStm.execute();
//
//        } catch (Exception ex) {
//            cidade.setErro("ERRO: " + ex.getMessage());
//            logger.warning(String.valueOf(ex));
//        }
//    }
//
//    public void alt(Cidade cidade) {
//        String SQL = "UPDATE `cad_cidade` SET `ds_sigla` = ?, "
//                + "`ds_cidade` = ?, `ds_observacao` = ? "
//                + "WHERE cd_cidade = ?";
//        try (PreparedStatement pStm = (PreparedStatement) c.prepareStatement(SQL)) {
//            pStm.setString(1, cidade.getUf().getSigla().toUpperCase());
//            pStm.setString(2, cidade.getDs_cidade().toUpperCase());
//            pStm.setString(3, cidade.getObservacao().toUpperCase());
//            pStm.setInt(4, cidade.getCd_cidade());
//            pStm.execute();
//
//        } catch (Exception ex) {
//            cidade.setErro("ERRO: " + ex.getMessage());
//            logger.warning(String.valueOf(ex));
//        }
//    }
//
//    public void RetornaDescricao(Cidade cidade) {
//        UF uf = new UF();
//        ClasseUf classeUf = null;
//        try {
//            classeUf = new ClasseUf();
//        } catch (Exception e) {
//            logger.warning((Supplier<String>) e);
//        }
//        uf.setSigla(cidade.getUf().getSigla());
//        if (classeUf.Recuperar(uf)) {
//            cidade.setUf(uf);
//        } else {
//            cidade.setErro("Erro ao recuperar descrição");
//        }
//    }
//
//    public ResultSet listar(String a, int index) {
//        String where = "";
//        switch (index) {
//            case 0: {
//                where = "";
//                break;
//            }
//            case 1: {
//                where = " and cd.cd_cidade = " + a;
//                break;
//            }
//            case 2: {
//                where = " and cd.ds_cidade like '%" + a + "%'";
//                break;
//            }
//            case 3: {
//                where = " and uf.ds_estado like '%" + a + "%'";
//                break;
//            }
//            case 4: {
//                where = " and cd.`ds_observacao` like '%" + a + "%'";
//                break;
//            }
//        }
//
//        ResultSet rs = null;
//        try {
//            String SQL = "SELECT "
//                    + "cd.`cd_cidade`,"
//                    + "cd.`ds_cidade`,"
//                    + "uf.ds_estado, "
//                    + "cd.`ds_observacao` "
//                    + "FROM `cad_cidade` cd, cad_uf uf "
//                    + "where cd.ds_sigla = uf.ds_sigla" + where + " order by cd.cd_cidade asc";
//            PreparedStatement pStm = (PreparedStatement) c.prepareStatement(SQL);
//            rs = pStm.executeQuery();
//        } catch (Exception ex) {
//            logger.warning(String.valueOf(ex));
//        }
//        return rs;
//    }
//
//    public void RetornaComboPreenchida(JComboBox combo) {
//        ClasseUf classUf = null;
//        try {
//            classUf = new ClasseUf();
//        } catch (Exception e) {
//            logger.warning((Supplier<String>) e);
//        }
//        ResultSet rs;
//        rs = classUf.listarTodos();
//        try {
//            while (rs.next()) {
//                combo.addItem(rs.getString(1));
//            }
//        } catch (SQLException ex) {
//            combo.addItem("Cadastre uma UF");
//        }
//    }
}
