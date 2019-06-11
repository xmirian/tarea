/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.factory;

import controladores.CAccessActividad;
import controladores.CAccessRepartidor;
import controladores.CAccessTarjeta;

/**
 *
 * @author Rosary
 */
public class CAccessFactory extends CFactory{

    @Override
    public IActividad getCActividad() {
        return new CAccessActividad();
    }

    @Override
    public IRepartidor getCRepartidor() {
        return new CAccessRepartidor();
    }

    @Override
    public ITarjeta getCTarjeta() {
        return new CAccessTarjeta();
    }
    
}
