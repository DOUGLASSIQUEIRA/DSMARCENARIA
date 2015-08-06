
package br.projetotcc.validacoes;

import java.awt.Component;
import java.awt.Container;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import javax.swing.JButton;

/**
 *
 * @author SIKEIRA
 */
public class ValidaBotoes {

    public void ValidaEstado(Container container, int estado) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton field = (JButton) component;
                String texto = field.getText();
                if ((estado == Rotinas. Incluir) ||(estado == Rotinas.Alterar)) {
                    if (texto.equals("Novo") || (texto.equals("Alterar")) || (texto.equals("Excluir"))) {
                        field.setEnabled(false);
                    } else {
                        field.setEnabled(true);
                    }
                } else if (estado == Rotinas.Padrao) {
                    if (texto.equals("Novo") || (texto.equals("Alterar")) || (texto.equals("Excluir")) || (texto.equals("Cancelar"))||(texto.equals("Gravar"))) {
                        field.setEnabled(true);
                    }
                } else {
                    field.setEnabled(false);
                }
            }
        }

    }

}

