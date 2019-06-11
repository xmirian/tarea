package util;

/**
 * Autor : Rosary :)
 */
import java.util.Vector;
import javax.swing.table.*;

/**
 *
 * @author Rosary
 */
public class MyAbstractTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    Vector cache; // Contendrá objetos String[] 
    int colCount;
    String[] headers;
    private boolean editable[];

    public MyAbstractTableModel() {
        cache = new Vector();
    }


    @Override
    public String getColumnName(int i) {
        return headers[i];
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }

    @Override
    public int getRowCount() {
        return cache.size();
    }

    @Override
    public Object getValueAt(
            int row,
            int col) {
        return ((String[]) cache.elementAt(row))[col];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (editable == null) {
            return false;
        }
        return editable[column];
    }

    /**
     * @param cache
     * @param columnNames nombre de columnas separadas por una coma ',' Por
     * ejemplo: setData(rs, "Id,Facultad");
     */
    public void setData(Vector cache, String columnNames) {
        this.cache = cache;

        // Poniendo nombres de columnas
        headers = columnNames.split(",");
        colCount = headers.length;

        fireTableChanged(null); // notifica que tenemos una nueva tabla
    }


    public void setEditable(String pEditables) {
        String[] editables = pEditables.split(",");
        editable = new boolean[editables.length];
        for (int i = 0; i < editables.length; i++) {
            editable[i] = Boolean.valueOf(editables[i]);
        }
    }
}
