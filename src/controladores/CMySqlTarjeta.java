/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.factory.ITarjeta;
import entidades.Tarjeta;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.Resultado;

/**
 *
 * @author Rosary
 */
public class CMySqlTarjeta extends CRUD implements ITarjeta{

    @Override
    public Resultado actualizar(Tarjeta tarjeta) {
        String sql = "update tarjeta set "
                + "colaborador = '" + tarjeta.getColaborador() + "' ,"
                + "montoPagado = " + tarjeta.getMontoPagado() + ","
                + "nota = '" + tarjeta.getNota() + "' ,"
                + "estado = '" + tarjeta.getEstado() + "', "
                + "id_actividad= " + tarjeta.getId_actividad() + ", "
                + "id_repartidor=  " + tarjeta.getId_repartidor()
                + " where idTarjeta = " + tarjeta.getIdTarjeta();
        return update(sql);
    }

    @Override
    public Resultado registrar(Tarjeta tarjeta) {
        String sql = "insert into tarjeta (estado,montoPagado,nota,"
                + "numTarjeta,id_actividad,id_repartidor,colaborador) "
                + "values ('" + tarjeta.getEstado() + "',"
                + tarjeta.getMontoPagado() + ",'"+tarjeta.getNota()+"','"
                + tarjeta.getNumTarjeta() + "',"
                + tarjeta.getId_actividad() + ","
                + tarjeta.getId_repartidor() + ",'"+tarjeta.getColaborador()+"')";
        return insert(sql);
    }

    /**
     * Selecciona el id de la tarjeta asignada y el num de tarjeta
     *
     * @param idActividad
     * @param idRepartidor
     * @return matriz tipo string
     */
    @Override
    public Resultado listarTarjetasAsignadas(int idActividad, int idRepartidor) {
        String sql = "select  idTarjeta, numTarjeta "
                + "from tarjeta  "
                + "where id_actividad = " + idActividad + " and "
                + "id_repartidor = " + idRepartidor + " order by numTarjeta ";

        Resultado resultado = new Resultado();
        cn = Conexion.getConnection();
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] fila = new String[2];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                resultado.getCache().add(fila);
            }
            resultado.setCorrecto(true);
        } catch (SQLException ex) {
            resultado.setCorrecto(false);
            resultado.setMensajeError(ex.getMessage());
        } finally {
            closeConnection();
        }
        return resultado;
    }

    
    @Override
    public Tarjeta buscar(String numTarjeta,int idActividad) {
        String sql = "select idTarjeta, estado,  id_repartidor "
                + "from tarjeta "
                + "where numTarjeta = '" + numTarjeta + "' and id_actividad = "+idActividad;
        cn = Conexion.getConnection();
        Tarjeta tarjeta = null;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                tarjeta = new Tarjeta();
                tarjeta.setEstado(rs.getString("estado"));
                tarjeta.setIdTarjeta(rs.getInt("idTarjeta"));
                tarjeta.setId_actividad(idActividad);
                tarjeta.setId_repartidor(rs.getInt("id_repartidor"));
                tarjeta.setNumTarjeta(numTarjeta);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            closeConnection();
        }
        return tarjeta;
    }
}
