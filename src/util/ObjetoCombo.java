/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author Rosary
 */
public class ObjetoCombo {
    
    private int id;
    private String valor;

    public ObjetoCombo(int id, String valor){
        this.id = id;
        this.valor = valor;
    }
    public ObjetoCombo(){
        
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString(){
        return valor;
    }
    
}
