package mx.uam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    private static final String URL = "jdbc://localhost:3306/recomendador";
    private static final String USER = "root";
    private static final String PASSWORD = "515t3m45D";

    public static void main(String[] args){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(URL,USER,PASSWORD);
        }        
        catch(ClassNotFoundException e){
            System.err.println("Ha ocurrido un error: "+ e.getMessage());
        }catch(SQLException enf){
            System.err.println("No se pudo conectar al Servidor de MySQL:" + enf.getMessage());
        }
    
    }

}
