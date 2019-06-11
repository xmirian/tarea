/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import util.Resultado;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rosary
 */
public class CRUD {

    protected Connection cn;
    protected Statement st;

    public CRUD(){
        
    }
    
    protected void closeConnection() {
        try {
            if (st != null) {
                st.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException e) {
        }
    }

    protected Resultado insert(String sql){
        return transact(sql);
    }
    
    protected Resultado update(String sql){
        return transact(sql);
    }
    
    protected Resultado delete (String sql){
        return transact (sql);
    }
    
    private Resultado transact(String sql){
        Resultado resultado = new Resultado();
        cn = Conexion.getConnection();
        try{
            st = cn.createStatement();
            st.executeUpdate(sql);
            resultado.setCorrecto(true);
        }catch(SQLException ex){
            resultado.setCorrecto(false);
            resultado.setMensajeError(ex.getMessage());
        }finally{
            closeConnection();
        }
        return resultado;
    }
}
