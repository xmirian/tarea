/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.factory;

import entidades.Repartidor;
import util.Resultado;

/**
 *
 * @author Rosary
 */
public interface IRepartidor {
   
    public abstract Resultado registrar(Repartidor repartidor);
    public abstract Resultado listar();
    public abstract Resultado listar(int idActividad);
    public abstract Repartidor buscar(String nombre);
    public abstract Repartidor buscar(int idRepartidor);
    public abstract Resultado eliminar(int idRepartidor);
    
    
}
