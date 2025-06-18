package mx.uam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.uam.entities.Usuario;

public class GestorUsuario {

    private List<Usuario> list;
    public List<Usuario> getList() {
        return list;
    }

    private Connection conn;

    public GestorUsuario() {
        this.list = new ArrayList<>();
    }

    public List<Usuario> getAll(){
        // 1.- Conectamos al servidor DBMS
        ConexionMySQL mysql_con = new ConexionMySQL();
        this.conn =  mysql_con.getConnection();

        // 2. Creamos la consulta para obtener la lista de usuarios
        String sql = "SELECT * FROM usuario";
        try{
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        //3. Iterar sobre la respuesta del DBMS
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

    public void addUser(Usuario usr){
        ConexionMySQL conn = new ConexionMySQL();
        this.conn = conn.getConnection();
        /* MALA PRACTICA: Código suceptible de ataque de SQL Injection */
        /* 
        String nombre="";
        String apellido_paterno="";
        String apellido_materno="";
        String sql = "INSERT INTO usuario VALUES(0,"+nombre+","+apellido_paterno+","+apellido_materno+")";
        */
        String sql = "INSERT INTO usuario VALUES(0,?,?,?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, usr.getNombre());
            stmt.setString(2, usr.getApellido_paterno());
            stmt.setString(3, usr.getApellido_materno());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Ocurrió un error en la inserción de SQL:"+ e.getMessage());
        }

    }
    
}
