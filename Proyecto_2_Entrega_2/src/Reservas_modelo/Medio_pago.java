package Reservas_modelo;

public class Medio_pago {
    private String nombreTitular;
    private String numeroTarjeta;
    private String fechaVencimiento;
    private String codigoSeguridad;

    //Constructor Medio de pago
    public Medio_pago(String nombreTitular, String numeroTarjeta, String fechaVencimiento, String codigoSeguridad) {
        this.nombreTitular = nombreTitular;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoSeguridad = codigoSeguridad;
    }

   

    // Otros métodos y funcionalidades relacionados con el medio de pago

    public String getNombreTitular() {
        return nombreTitular;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }
}
