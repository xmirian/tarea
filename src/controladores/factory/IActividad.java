/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.factory;

import entidades.Actividad;
import util.Resultado;

/**
 *
 * @author Rosary
 */
public interface IActividad {
   public abstract Resultado registrar(Actividad actividad);
   public abstract Resultado listar();
   public abstract Actividad buscar(int idActividad);
   public abstract Resultado eliminar(int idActividad);
}
