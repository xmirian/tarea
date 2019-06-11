package util;

import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Rosary :)
 */
public class MyComboBoxModel implements ComboBoxModel {

    private static final long serialVersionUID = 1L;

    Vector<ObjetoCombo> listaObjetos = new Vector<>();
    private final Vector<ListDataListener> listaEventos = new Vector<>();
    private ObjetoCombo itemSeleccionado;

    public MyComboBoxModel() {

    }

    public void setData(Vector<ObjetoCombo> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public ObjetoCombo getSelectedItem(Integer id) {
        for (ObjetoCombo o : listaObjetos) {
            if (id == o.getId()) {
                return o;
            }
        }
        return null;
    }

    public ObjetoCombo getSelectedItem(String s) {
        for (ObjetoCombo o : listaObjetos) {
            if (s.equals(o.getValor())) {
                return o;
            }
        }
        return null;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        itemSeleccionado = anItem instanceof ObjetoCombo ? (ObjetoCombo) anItem : null;
        for (ListDataListener l : listaEventos) {
            l.contentsChanged(new ListDataEvent(this, javax.swing.event.ListDataEvent.CONTENTS_CHANGED, 0, 0));
        }

    }

    @Override
    public Object getSelectedItem() {
        return itemSeleccionado;
    }

    @Override
    public int getSize() {
        return listaObjetos.size();
    }

    @Override
    public Object getElementAt(int i) {
        return listaObjetos.elementAt(i);
    }

    @Override
    public void addListDataListener(ListDataListener ll) {
        listaEventos.add(ll);
    }

    @Override
    public void removeListDataListener(ListDataListener ll) {
        listaEventos.remove(ll);
    }

    public int getSelectedCodigo() {
        return itemSeleccionado == null ? null : itemSeleccionado.getId();
    }

    public String getSelectedDescri() {
        return itemSeleccionado == null ? null : itemSeleccionado.getValor();
    }
    
    public void removeAllElements() {
        listaObjetos.removeAllElements();
    }

}
