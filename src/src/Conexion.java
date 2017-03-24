package src;

import java.sql.*;

public class Conexion {
     //INGRESA EL NOMBRE DE LA BASE DE DATOS CON EL USUARIO Y CONTRASEÑA.
    static String strBd = "limpieza_ventas";    
    static String strUser;
    static String strPassword;
    private String strUrl;
    
    public Conexion() {
        strUser="root";
        strPassword="";
        
        
    }
    
    public Conexion(String Usuario, String Contraseña) {
        strUser=Usuario;
        strPassword=Contraseña;
    }
    
    public Connection getConnection() throws SQLException {
        strUrl = "jdbc:mysql://127.0.0.1:3306/" + strBd;
        return DriverManager.getConnection(strUrl, strUser, strPassword);
    }
    
   
}