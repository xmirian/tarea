package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.DatosIni;

/**
 *
 * @author Rosary
 */
public class Conexion {
    
    //se hace privado el constructor para evitar que el cliente lo instancie
    private Conexion() {

    }

    /**
     * Obtiene la instancia a través de un método estático que devuelve siempre
     * la misma instancia.
     *
     * @return objeto Connection
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            
            connection = DriverManager.getConnection(DatosIni.getUrl(),
                    DatosIni.getUsuario(),DatosIni.getPassword());
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return connection;
    }
}
