package Reservas_modelo;


public class Licencia_conducion {
    private String numero;
    private String paisExpedicion;
    private String fechaVencimiento;
    private String imagenLicencia;

    //Constructor licencia
    public Licencia_conducion(String numero, String paisExpedicion, String fechaVencimiento, String imagenLicencia) {
        this.numero = numero;
        this.paisExpedicion = paisExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.imagenLicencia = imagenLicencia;
    }



	

    // Otros métodos y funcionalidades relacionados con la licencia de condución

    public String getNumero() {
        return numero;
    }
    
    public void setImagenLicencia(String imagenLicencia) {
        this.imagenLicencia = imagenLicencia;
    }

    public String getImagenLicencia() {
        return imagenLicencia;
    }

    public void setPaisExpedicion(String paisExpedicion) {
        this.paisExpedicion = paisExpedicion;
    }

    public String getPaisExpedicion() {
        return paisExpedicion;
    }
    
    public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	
}
	}
