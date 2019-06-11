/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.factory.IRepartidor;
import entidades.Repartidor;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ObjetoCombo;
import util.Resultado;

/**
 *
 * @author Rosary
 */
public class CMySqlRepartidor extends CRUD implements IRepartidor{
    
    
    @Override
    public Resultado registrar (Repartidor repartidor){
        String sql = "insert into repartidor (nombre) "
                + "values('"+repartidor.getNombre()+"')";
        return insert(sql);
    }
    
    /**
     * Lista todos los repartidores 
     * @return matriz tipo string de todos sus campos
     */
    @Override
    public Resultado listar(){
        String sql = "select idRepartidor, nombre "
                + "from repartidor order by nombre ";
        cn = Conexion.getConnection();
        Resultado resultado = new Resultado();
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String [] fila = new String [7];
                fila[0] = rs.getString("idRepartidor");
                fila[1] = rs.getString("nombre");
                
                resultado.getCache().add(fila);
                resultado.getItemsCombo().add(new ObjetoCombo(rs.getInt("idRepartidor"), rs.getString("nombre")));
            }
            resultado.setCorrecto(true);
        }catch(SQLException ex){
            resultado.setCorrecto(false);
            resultado.setMensajeError(ex.getMessage());
        }finally{
            closeConnection();
        }
        return resultado;
    }
    
    /**
     * Lista todos los repartidores de una actividad
     * @param idActividad
     * @return matriz tipo string y lista objeto combo
     */
    @Override
    public Resultado listar(int idActividad){
        String sql = "select idRepartidor, nombre "
                + "from repartidor ";
        cn = Conexion.getConnection();
        Resultado resultado = new Resultado();
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String [] fila = new String [7];
                fila[0] = rs.getString("idRepartidor");
                fila[1] = rs.getString("nombre");
                
                resultado.getCache().add(fila);
                resultado.getItemsCombo().add(new ObjetoCombo(rs.getInt("idRepatidor"), rs.getString("nombre")));
            }
            resultado.setCorrecto(true);
        }catch(SQLException ex){
            resultado.setCorrecto(false);
            resultado.setMensajeError(ex.getMessage());
        }finally{
            closeConnection();
        }
        return resultado;
    }
    @Override
     public Repartidor buscar (String nombre){
        String sql = "select idRepartidor "
                + "from repartidor "
                + "where nombre = '"+nombre+"'";
        cn = Conexion.getConnection();
        Repartidor repartidor = null;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                repartidor = new Repartidor();
                repartidor.setIdRepartidor(rs.getInt("idRepartidor"));
                repartidor.setNombre(nombre);
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            closeConnection();
        }
        return repartidor;
    }
     
    @Override
     public Resultado eliminar(int idRepartidor){
         String sql = "delete from repartidor where idRepartidor = "+idRepartidor;
         return delete(sql);
     }
    
    
    @Override
    public Repartidor buscar (int idRepartidor){
        String sql = "select nombre "
                + "from repartidor "
                + "where idRepartidor = "+idRepartidor;
        cn = Conexion.getConnection();
        Repartidor repartidor = null;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                repartidor = new Repartidor();
                repartidor.setIdRepartidor(idRepartidor);
                repartidor.setNombre(rs.getString("nombre"));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            closeConnection();
        }
        return repartidor;
    }
    
}
