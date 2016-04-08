
package br.projetotcc.dao;


import br.projetotcc.classe.ClasseFuncionario;
import br.projetotcc.conexao.ConexaoPostgre;
import br.projetotcc.validacoes.UltimaSequencia;


import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eli
 */
public class DaoMovFuncionarioEndereco {
   
    
     ConexaoPostgre conecta_postgre;
     UltimaSequencia ultima;
     
    
    public  DaoMovFuncionarioEndereco(){
        conecta_postgre = new ConexaoPostgre();
         
    }
    
   
    
    public void excluiitens(ClasseFuncionario classe) {
         DefaultTableModel tabela = (DefaultTableModel) classe.getTabela().getModel();
        
        int totlinha = classe.getTabela().getRowCount();
      
        Boolean sel = false;
        
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja remover as linhas selecionadas?",
                "Remover", JOptionPane.YES_OPTION);
       
        if (opcao == JOptionPane.YES_OPTION) {
            for (int i = totlinha - 1; i >= 0; i--){
            Boolean selecionado = (Boolean) classe.getTabela().getValueAt(i,0);
            if (selecionado == true) {
                sel = true;
                tabela.removeRow(i);
              
            }
        
        }
        if (!sel==true){
            JOptionPane.showMessageDialog(null," Nao ha selecionado");
        }
    }
    }
    
    public  void adicionaritens(ClasseFuncionario classe,String [] campos){
           double soma = 0;
     DefaultTableModel tabela = (DefaultTableModel) classe.getTabela().getModel();
       
//            
        int totlinha = classe.getTabela().getRowCount();
       
        int alterar = 0; //0 = inclusao, 1 = alteração
        int conta = 0;
        int linha = 0;
        
        for (int i = 0; i < totlinha; i++){
           String cd_item = (String) classe.getTabela().getValueAt(conta, 2);
           
              if (campos[0].equals(cd_item)){
                  int opcao_escolhida = JOptionPane.showConfirmDialog(null,"Produto ja cadastrado, "
                                           + "deseja "
                                           + " alterar quantidade e valor ","Ateração",JOptionPane.YES_NO_OPTION);
                    if (opcao_escolhida == JOptionPane.YES_OPTION){
                        alterar = 1;
                        linha = conta;
                        
                    }  else {
                        return;
                    }
                  
              }
              conta = conta + 1;
    
        
        }
        
        if (alterar == 0){
//               
              
            tabela.setNumRows(totlinha+1);
            tabela.setValueAt((false),totlinha,0);
            tabela.setValueAt(campos[0],totlinha,1);
             tabela.setValueAt(campos[1],totlinha,2);
              tabela.setValueAt(campos[2],totlinha,3);
              tabela.setValueAt(campos[3],totlinha,4);
             
               
        }else if (alterar == 1){
            //caso for alteração
            
          tabela.setValueAt(campos[2],totlinha,4);
               tabela.setValueAt(campos[3],totlinha,5);            
               
               //jTFValor_total_nf()
        }

        
    }
    
    public  void gravaritens(ClasseFuncionario  classe){
        DefaultTableModel tabela = (DefaultTableModel) classe.getTabela().getModel();
       
            
        int totlinha = classe.getTabela().getRowCount();
    
        for (int i = 0; i < totlinha; i++){
        
        
        String tipo = (String) tabela.getValueAt(i,4);
        String numero = (String) tabela.getValueAt(i,5);
        
        Double.parseDouble(tipo);
        Double.parseDouble(numero);
        tabela.setValueAt(classe.getId_funcionario(),i , 1);
        
        ultima = new UltimaSequencia();
        int sequenciatelefone = (Integer) (ultima.ultimasequencia("cad_telefone", "sequencia"));
         String sqlinsert = " INSERT INTO cad_telefone (sequencia,cd_pessoa,"
                 + " cd_tipo_telefone, nr_telefone ) VALUES (" 
                 + sequenciatelefone + ","                 
                 + classe.getId_funcionario()+ ","
                 + tipo + ","
                 + numero + ")";
         conecta_postgre.incluirSQL(sqlinsert);
        }    
    }
    
}
