/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.Vector;

/**
 *
 * @author Rosary
 */
public class Resultado {

    private String mensajeError;
    private boolean correcto;
    private Vector cache;
    private Object[][] data;
    private Vector<ObjetoCombo> itemsCombo  ;
    
    public Resultado(){
        cache=new Vector();
        itemsCombo= new Vector<>(); 
    }
    
    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

    public Vector getCache() {
        return cache;
    }

    public Vector<ObjetoCombo> getItemsCombo() {
        return itemsCombo;
    } 

    public Object[][] getData() {
        return data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public void setCache(Vector cache) {
        this.cache = cache;
    }
}
