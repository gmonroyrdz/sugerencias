package mx.uam;

import java.util.List;

import mx.uam.entities.Usuario;

public class Main {
    public static void main(String[] args) {
        //ConexionMySQL conn = new ConexionMySQL();
        //Connection c =  conn.getConnection();


        GestorUsuario gestor = new GestorUsuario();
        List<Usuario> usrs = gestor.getAll();
        for (Usuario u : usrs) {
            System.out.println(u.toString());
        }
    }
}