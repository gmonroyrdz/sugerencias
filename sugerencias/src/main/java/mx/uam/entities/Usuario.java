package mx.uam.entities;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;

    public Usuario(int id, String nombre, String apellido_materno, String apellido_paterno) {
        this.apellido_materno = apellido_materno;
        this.apellido_paterno = apellido_paterno;
        this.id = id;
        this.nombre = nombre;
    }

    public Usuario(String nombre, String apellido_materno, String apellido_paterno) {
        this.apellido_materno = apellido_materno;
        this.apellido_paterno = apellido_paterno;
        this.id = 0;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        String sep = "|";
        str.append(id);
        str.append(sep);
        str.append(nombre);
        str.append(sep);
        str.append(apellido_paterno);
        str.append(sep);
        str.append(apellido_materno);
        return str.toString();

    }
    
}
