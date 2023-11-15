package Reservas_modelo;


public class Historial {
    private String correoCliente;
    private String vehiculoReservado;
    private String fechaReserva;
    private String fechaAlquiler;
    private Double tarifa;
    private String seguros;
    private String entrega;
    private String devolucion;
    private String estado;

    public Historial(String correoCliente, String vehiculoReservado, String fechaReserva, String fechaAlquiler, Double tarifa, String seguros, String entrega, String devolucion, String estado) {
        this.correoCliente = correoCliente;
        this.vehiculoReservado = vehiculoReservado;
        this.fechaReserva = fechaReserva;
        this.fechaAlquiler = fechaAlquiler;
        this.tarifa = tarifa;
        this.seguros = seguros;
        this.entrega = entrega;
        this.devolucion = devolucion;
        this.estado = estado;
    }


    //Otros metodos y funcionalidades
	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getVehiculoReservado() {
		return vehiculoReservado;
	}

	public void setVehiculoReservado(String vehiculoReservado) {
		this.vehiculoReservado = vehiculoReservado;
	}

	public String getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(String fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public String getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(String fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

	public Double getTarifa() {
		return tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	public String getSeguros() {
		return seguros;
	}

	public void setSeguros(String seguros) {
		this.seguros = seguros;
	}

	public String getEntrega() {
		return entrega;
	}

	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}

	public String getDevolucion() {
		return devolucion;
	}

	public void setDevolucion(String devolucion) {
		this.devolucion = devolucion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


    // Otros métodos que puedas necesitar
}

