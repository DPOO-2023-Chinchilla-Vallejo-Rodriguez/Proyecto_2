package Reservas_modelo;

public class Admin_local {
    private String nombre;
    private String rol;
    private String sedeAsignada;

  //Constructor Administradores locales
    public Admin_local(String nombre, String sedeAsignada) {
        this.nombre = nombre;
        this.rol = "Administrador Local"; // Establecemos el rol
        this.sedeAsignada = sedeAsignada;
    }
  
    // Otros métodos y funcionalidades relacionados con la administración local

    public String getNombre() {
        return nombre;
    }
    
    public String getRol() {
        return rol;
    }
    
    public String getsedeAsignada() {
        return sedeAsignada;
    }
}

