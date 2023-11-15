package Reservas_modelo;

    public class Admin_general{
    private String nombre;
    private String rol;
   
    //Constructor Administradores generales
    public Admin_general(String nombre) {
        this.nombre = nombre;
        this.rol = "Administrador Global";
    }

    // Otros métodos y funcionalidades relacionados con la administración global

    public String getNombre() {
        return nombre;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getRol() {
        return rol;
    }
}
