package br.projetotcc.validacoes;

import java.awt.Component;
import java.awt.Container;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author SIKEIRA
 */
public class ValidaBotoes {

//    public void ValidaEstado(Container container, int estado) {
//        Component components[] = container.getComponents();
//        for (Component component : components) {
//            if (component instanceof JButton) {
//                JButton field = (JButton) component;
//                String texto = field.getText();
//                if ((estado == Rotinas.Incluir) || (estado == Rotinas.Alterar)) {
//                    if (texto.equals("Novo") || (texto.equals("Alterar")) || (texto.equals("Excluir"))) {
//                        field.setEnabled(false);
//                    } else {
//                        field.setEnabled(true);
//                    }
//                } else if (estado == Rotinas.Padrao) {
//                    if (texto.equals("Novo") || (texto.equals("Alterar")) || (texto.equals("Excluir")) || (texto.equals("Cancelar")) || (texto.equals("Gravar"))) {
//                        field.setEnabled(true);
//                    }
//                } else {
//                    field.setEnabled(false);
//                }
//            }
//        }
//
//    }
    public void ValidaEstado(Container container, int estado, JButton botao1,
            JButton botao2, JButton botao3, JButton botao4, JButton botao5) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton field = (JButton) component;
                String texto = field.getText();
                if ((estado == Rotinas.Alterar)) {
                    botao1.setEnabled(true);
                    botao2.setEnabled(true);
                    botao3.setEnabled(true);
                    botao4.setEnabled(true);
                    botao5.setEnabled(true);
                }
                if ((estado == Rotinas.Incluir)) {
                    botao1.setEnabled(false);
                    botao2.setEnabled(false);
                    botao3.setEnabled(false);
                    botao4.setEnabled(true);
                    botao5.setEnabled(true);
                } else if (estado == Rotinas.Padrao) {

                    botao1.setEnabled(true);
                    botao2.setEnabled(false);
                    botao3.setEnabled(false);
                    botao4.setEnabled(false);
                    botao5.setEnabled(false);
                }
            }
        }

    }

    public void HabilitarCampos(Container container, boolean ativa) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                JTextField field = (JTextField) component;
                field.setEnabled(ativa);
            }
//            JTextField field = (JTextField) component;
//            String texto = field.getText();
//           if (texto.equals("jTfcodigo")|| (texto.equals("JtfSequencia"))
//                   || (texto.equals("JtfSequencia2"))){
//           field.setEnabled(desativa);
//           } 
                   
        }
        
    }

}
