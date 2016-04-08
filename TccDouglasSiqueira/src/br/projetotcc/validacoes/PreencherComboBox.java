/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetotcc.validacoes;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author DOUGLAS
 */
public class PreencherComboBox {
   public int[] PreencherCombo(JComboBox combo, String campo, ResultSet retorno, 
        String atributo_array){
        combo.removeAllItems();
        int cont = 0;
        try{
            retorno.last();
            int[] array = new int[retorno.getRow()];
            retorno.first();
             do {
                    if(cont==0)
                    combo.addItem("selecione item");
                    combo.addItem(retorno.getString(campo));
                    array[cont] = Integer.parseInt(retorno.getString (atributo_array));
                    
                cont++;
            }while (retorno.next());
            //cidade.setArray_cidade(array);
            return array;
        }catch (SQLException ex) {
           // JOptionPane.showMessageDialog(null, "DADOS NÃO ENCONTRADOS");
        }
        return null;
    }    
}
