/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.factory;

import entidades.Tarjeta;
import util.Resultado;

/**
 *
 * @author Rosary
 */
public interface ITarjeta {
    public abstract Resultado actualizar(Tarjeta tarjeta);
    public abstract Resultado registrar(Tarjeta tarjeta);
    public abstract Resultado listarTarjetasAsignadas(int idActividad,int idRepartidor);
    public abstract Tarjeta buscar(String numTarjeta,int idActividad);
}
