package mx.uam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.uam.entities.Usuario;

public class GestorUsuario {

    private List<Usuario> list;
    private Connection conn;

    public GestorUsuario() {
        this.list = new ArrayList<>();
    }

    public List<Usuario> getAll(){
        ConexionMySQL mysql_con = new ConexionMySQL();
        this.conn =  mysql_con.getConnection();

        //Creamos la consulta para obtener la lista de usuarios
        String sql = "SELECT * FROM usuario";
        try{
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido_paterno = rs.getString(3);
                String apellido_marterno = rs.getString(4);
                Usuario usr = new Usuario(id,nombre,apellido_paterno,apellido_marterno);
                this.list.add(usr);
            }
            return this.list;

        }catch(SQLException ex){
            System.err.println("Hubo un error al recuperar la información:"+ex.getMessage());
            return null;
        }
    }
    
}
