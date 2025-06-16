package mx.uam;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConexionMySQL conn = new ConexionMySQL();
        Connection c =  conn.getConnection();


        //GestorUsuario gestor = new GestorUsuario();
        //gestor.getAll();
    }
}