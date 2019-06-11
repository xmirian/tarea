/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.factory.IActividad;
import entidades.Actividad;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ObjetoCombo;
import util.Resultado;

/**
 *
 * @author Rosary
 */
public class CAccessActividad extends CRUD implements IActividad{

    @Override
    public Resultado registrar(Actividad actividad) {
        String sql = "insert into actividad (nombre,organizador,lugar,fecha,valor,totalTarjetas)"
                + "values('"+actividad.getNombre()+"',"
                + "'"+actividad.getOrganizador()+"',"
                + "'"+actividad.getLugar()+"',"
                + "#"+new Date(actividad.getFecha().getTime())+"#,"
                + actividad.getValor()+","
                + actividad.getTotalTarjetas()+")";
        return insert(sql);
    }

    @Override
    public Resultado listar() {
        String sql = "select idActividad, nombre, organizador, lugar, fecha, "
                + "valor, totalTarjetas "
                + "from actividad order by fecha desc ";
        cn = Conexion.getConnection();
        Resultado resultado = new Resultado();
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String [] fila = new String [7];
                fila[0] = rs.getString("idActividad");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("organizador");
                fila[3] = rs.getString("lugar");
                fila[4] = rs.getString("fecha");
                fila[5] = rs.getString("valor");
                fila[6] = rs.getString("totalTarjetas");
                
                resultado.getCache().add(fila);
                resultado.getItemsCombo().add(new ObjetoCombo(rs.getInt("idActividad"), rs.getString("nombre")));
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
    public Actividad buscar(int idActividad) {
        String sql = "select nombre, organizador, lugar,fecha,valor,totalTarjetas "
                + "from actividad where idActividad = "+idActividad;
        cn = Conexion.getConnection();
        Actividad actividad = null;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                actividad = new Actividad();
                actividad.setFecha(rs.getDate("fecha"));
                actividad.setIdActividad(idActividad);
                actividad.setLugar(rs.getString("lugar"));
                actividad.setNombre(rs.getString("nombre"));
                actividad.setOrganizador(rs.getString("organizador"));
                actividad.setTotalTarjetas(rs.getInt("totalTarjetas"));
                actividad.setValor(rs.getDouble("valor"));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            closeConnection();
        }
        return actividad;
    }

    @Override
    public Resultado eliminar(int idActividad) {
        String sql = "delete from actividad where idActividad = "+idActividad;
        return delete(sql);
    }
    
}
