package mx.uam;

import java.util.List;

import mx.uam.entities.Usuario;

public class Main {
    public static void main(String[] args) {

        GestorUsuario g = new GestorUsuario();
        List<Usuario> list = g.getAll();
        print(list);

        Usuario u1 = new Usuario(0, "Laura", "Flores", "Flores");

        Usuario u2 = new Usuario("Pedro","Marmol","Olivares");

        g.addUser(u1);
        g.addUser(u2);

        list = g.getAll();
        print(list);


    }

    private static void print(List<Usuario> usrs){
        for (Usuario u : usrs) {
            System.out.println(u.toString());
        }
    }
}