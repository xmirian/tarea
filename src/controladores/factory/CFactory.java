/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.factory;

/**
 *
 * @author Rosary
 */
public abstract class CFactory {

    public static final int MYSQL = 1;
    public static final int ACCESS = 2;

    public abstract IActividad getCActividad();
    public abstract IRepartidor getCRepartidor();
    public abstract ITarjeta getCTarjeta();
    

    public static CFactory getCFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL:
                return new CMySqlFactory();
            case ACCESS:
                return new CAccessFactory();
            default:
                return null;
        }
    }
}
