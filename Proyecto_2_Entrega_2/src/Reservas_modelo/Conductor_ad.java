package Reservas_modelo;

public class Conductor_ad {
    private Licencia_conducion licenciaConducion;

    public Conductor_ad(Licencia_conducion licenciaConducion) {
        this.licenciaConducion = licenciaConducion;
    }


    
    // Otros métodos y funcionalidades relacionados con el conductor adicional
    public Licencia_conducion getLicenciaConducion() {
        return licenciaConducion;
    }
}
