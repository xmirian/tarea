/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Component;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

/**
 * Creado por: Rosario A. Alvarez Rodriguez. Esta clase ofrece muchos métodos
 * que son útiles para visualizar elementos de una tabla, combo, caja...
 */
public class Formateador {

    /**
     * Establece la data y las cabeceras de la tabla. También les asigna el
     * ancho de las columnas.
     *
     * @param tabla la tabla a formatear
     * @param cabeceras nombres de las columnas
     * @param anchos los anchos de las columnas.
     */
    public static void redimensionar(JTable tabla, String cabeceras, String anchos) {
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.getColumn("Id").setMinWidth(0);
        String[] cabecera = cabeceras.split(",");
        String[] ancho = anchos.split(",");
        for (int i = 0; i < cabecera.length; i++) {
            tabla.getColumn(cabecera[i]).setPreferredWidth(Integer.valueOf(ancho[i]));
        }
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * devuelve el item seleccionado de la tabla
     * @param tabla
     * @return 
     */
    public static int getItemSeleccionado(JTable tabla) {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un elemento", "Atención", JOptionPane.WARNING_MESSAGE);
            return -1;
        }
        int index = tabla.convertRowIndexToModel(filaSeleccionada);
        int id = Integer.parseInt(tabla.getModel().getValueAt(index, 0).toString());
        return id;
    }

    /**
     * Establece el máximo tamanio del JTextField y lo que se tipea lo convierte
     * a mayúsucula.
     *
     * @param caja es el JTextField a formatear
     * @param tamanio es el maximo tamanio del texto que se puede tipear
     * @param evt el evento que produce al tipear
     */
    public static void setMaxTamanio(JTextField caja, int tamanio, KeyEvent evt) {
        if(evt.getKeyChar()=='\''){
            evt.consume();
            return;
        }
        if (caja.getText().length() >= tamanio) {
            evt.consume();
            return;
        }
        if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }

    public static void setMaxTamanio(JTextArea areaTexto, int tamanio, KeyEvent evt) {
        if(evt.getKeyChar()=='\''){
            evt.consume();
            return;
        }
        if (areaTexto.getText().length() >= tamanio) {
            evt.consume();
            return;
        }
        if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }
    
    public static void mostrarMensajeError(Resultado resultado, Component comp) {
        JOptionPane.showMessageDialog(comp, resultado.getMensajeError(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void setLocationCenter(JInternalFrame jf, JDesktopPane jd) {
        jf.setLocation(((jd.getWidth() / 2) - (jf.getWidth() / 2)), ((jd.getHeight() / 2) - (jf.getHeight() / 2)));
    }
    
    public static void agregarEventoFiltrador(final TableRowSorter sorter,
            final JTextField txt, final JComboBox cbo,final int column1, final int column2) {
        txt.getDocument().addDocumentListener(
                new DocumentListener() {
                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        filtrar(sorter,txt,cbo,column1,column2);
                    }

                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        filtrar(sorter,txt,cbo,column1,column2);
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        filtrar(sorter,txt,cbo,column1,column2);
                    }
                });
    }

    private static void filtrar(TableRowSorter sorter,JTextField txt,
            JComboBox cbo,int column1,int column2) {
        RowFilter<AbstractTableModel, Object> Filtrador_Filas = null;
        
        int indiceColumnaTabla = 2;
        switch (cbo.getSelectedIndex()) {
            case 0:
                indiceColumnaTabla = column1;
                break;
            case 1:
                indiceColumnaTabla = column2;
                break;
        }
        
        try {
            Filtrador_Filas = RowFilter.regexFilter(txt.getText(), indiceColumnaTabla);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(Filtrador_Filas);
    }
}
