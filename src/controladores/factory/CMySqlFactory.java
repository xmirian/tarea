/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.factory;

import controladores.CMySqlActividad;
import controladores.CMySqlRepartidor;
import controladores.CMySqlTarjeta;

/**
 *
 * @author Rosary
 */
public class CMySqlFactory extends CFactory{

    @Override
    public IActividad getCActividad() {
        return new CMySqlActividad();
    }

    @Override
    public IRepartidor getCRepartidor() {
        return new CMySqlRepartidor();
    }

    @Override
    public ITarjeta getCTarjeta() {
        return new CMySqlTarjeta();
    }

    
}
