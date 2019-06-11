/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.PropertyResourceBundle;

/**
 *
 * @author Rosary
 */
public class DatosIni {
    private static String bd = null;
    private static String usuario = null;
    private static String password = null;
    private static String url = null;
    static PropertyResourceBundle properties;
    
    static {
        try {
            properties = new PropertyResourceBundle(new FileInputStream("datos.ini"));
            setBd(properties.getString("BD"));
            setUrl(properties.getString("URL"));
            setUsuario(properties.getString("USER"));
            setPassword(properties.getString("PASSWORD"));

        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }

    public static String getBd() {
        return bd;
    }

    public static void setBd(String aBd) {
        bd = aBd;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String aUsuario) {
        usuario = aUsuario;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String aPassword) {
        password = aPassword;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String aUrl) {
        url = aUrl;
    }
    
}
