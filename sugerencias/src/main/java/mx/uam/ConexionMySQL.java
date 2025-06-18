package mx.uam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    // MALA PRACTICA : Hardconding !!!
    private static final String URL = "jdbc:mysql://localhost:3306/recomendador";
    private static final String USER = "cliente_usr";
    private static final String PASSWORD = "p455w0rD!";
    private Connection conn;

    public Connection getConnection(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(URL,USER,PASSWORD);
            return conn;
        }        
        catch(ClassNotFoundException e){
            System.err.println("Ha ocurrido un error: "+ e.getMessage());
            return  null;
        }catch(SQLException enf){
            System.err.println("No se pudo conectar al Servidor de MySQL:" + enf.getMessage());
            return null;
        }
    
    }

}
