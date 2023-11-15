package Reservas_modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Iterator;

import reservas_procesamiento.Reservas;

public class Empresa {
   
	public static List<List<String>> obtenerInformacionReservas() {
	    List<Historial> historial = Reservas.getHistorial();
	    List<List<String>> informacionReservas = new ArrayList<>();

	    for (Historial reserva : historial) {
	        // Crear una lista con la información de la reserva y agregarla a la lista principal
	        List<String> infoReserva = new ArrayList<>();
	        infoReserva.add(reserva.getCorreoCliente());
	        infoReserva.add(reserva.getVehiculoReservado());
	        infoReserva.add(reserva.getFechaReserva());
	        infoReserva.add(reserva.getFechaAlquiler());
	        infoReserva.add(String.valueOf(reserva.getTarifa()));
	        infoReserva.add(reserva.getSeguros());
	        infoReserva.add(reserva.getEntrega());
	        infoReserva.add(reserva.getDevolucion());
	        infoReserva.add(reserva.getEstado());

	        informacionReservas.add(infoReserva);
	    }

	    return informacionReservas;
	}



	public static List<String> obtenerReservasPorSede(String nombreSede) {
	    List<Historial> historial = Reservas.getHistorial();
	    List<String> reservasPorSede = new ArrayList<>();

	    for (Historial reserva : historial) {
	        // Verificar si la reserva pertenece a la sede especificada
	        if (reserva.getEntrega().equals(nombreSede)) {
	            // Crear una cadena con la información de la reserva y agregarla a la lista
	            String infoReserva = reserva.getCorreoCliente() + " \n- "
	                    + reserva.getVehiculoReservado() + "\n - "
	                    + reserva.getFechaReserva() + " \n- "
	                    + reserva.getFechaAlquiler() + " \n- "
	                    + reserva.getTarifa() + "\n - "
	                    + reserva.getSeguros() + "\n - "
	                    + reserva.getEntrega() + "\n - "
	                    + reserva.getDevolucion() + "\n - "
	                    + reserva.getEstado();

	            reservasPorSede.add(infoReserva);
	        }
	    }

	    return reservasPorSede;
	}


	public static List<List<String>> obtenerReservasPorCorreo(String correoCliente) {
    List<Historial> historial = Reservas.getHistorial();
    List<List<String>> reservasPorCorreo = new ArrayList<>();

    for (Historial reserva : historial) {
        // Verificar si la reserva pertenece al cliente especificado
        if (reserva.getCorreoCliente().equals(correoCliente)) {
            // Crear una lista con la información de la reserva y agregarla a la lista principal
            List<String> infoReserva = new ArrayList<>();
            infoReserva.add("Vehículo: " + reserva.getVehiculoReservado());
            infoReserva.add("Fecha de Reserva: " + reserva.getFechaReserva());
            infoReserva.add("Fecha de Alquiler: " + reserva.getFechaAlquiler());
            infoReserva.add("Tarifa: " + reserva.getTarifa());
            infoReserva.add("Seguros: " + reserva.getSeguros());
            infoReserva.add("Entrega: " + reserva.getEntrega());
            infoReserva.add("Devolución: " + reserva.getDevolucion());
            infoReserva.add("Estado: " + reserva.getEstado());

            reservasPorCorreo.add(infoReserva);
        }
    }

    return reservasPorCorreo;
}



    public static void cancelarReserva(String correoCliente, String vehiculoReserva) {
    List<Historial> historial = Reservas.getHistorial();
    Iterator<Historial> iterador = historial.iterator();

    while (iterador.hasNext()) {
        Historial reserva = iterador.next();

        if (reserva.getCorreoCliente().equals(correoCliente) && reserva.getVehiculoReservado().equals(vehiculoReserva)) {
            // Eliminar la reserva del historial
            iterador.remove();
            
            // Guardar los cambios en el historial
            guardarHistorialEnArchivo(historial);
            JOptionPane.showMessageDialog(null, "La reserva fue Cancelada", "La reserva fue Cancelada", JOptionPane.ERROR_MESSAGE);
            break;
        }
        else {
            JOptionPane.showMessageDialog(null, "Verifica la placa del vehiculo", "La información no es correcta", JOptionPane.ERROR_MESSAGE);
            break;
    }
    
    }

    // No se encontró ninguna reserva con el vehículo especificado
}

    public static void crearNuevaReserva(String correoCliente, String placaVehiculo,String fechaReserva, String fechaAlquiler,
    		Double tarifa, String seguros, String entrega, String devolucion, String estado) {
    	List<Historial> historial = Reservas.getHistorial();
        

			// Crear una nueva reserva
			Historial nuevaReserva = new Historial(correoCliente, placaVehiculo, fechaReserva, fechaAlquiler, tarifa, seguros, entrega, devolucion, estado);

			Vehiculo.cambiarEstadoUbicacionVehiculo(entrega, placaVehiculo, "Alquilado", devolucion);
			// Agregar la reserva al historial
			historial.add(nuevaReserva);
		

        // Guardar los cambios en el historial
        guardarHistorialEnArchivo(Reservas.getHistorial());

    }

    public static double calcularTarifaAlquiler(Categoria_vehiculo categoriaSeleccionada, Seguro seguroSeleccionado, int numeroDias) {
    // Validar la categoría y el número de días
    if (categoriaSeleccionada == null || numeroDias <= 0) {
        System.out.println("Parámetros no válidos.");
        return 0.0;
    }

    // Calcular la tarifa base
    double tarifaBase = categoriaSeleccionada.getTarifaDiaria();

    // Calcular la tarifa del seguro si está seleccionado, de lo contrario, será 0
    double tarifaSeguro = (seguroSeleccionado != null) ? seguroSeleccionado.getCostoAdicionalPorDia() : 0;

    // Calcular la tarifa total
    double tarifaTotal = tarifaBase + tarifaSeguro * numeroDias;

    // Puedes devolver directamente la tarifa sin imprimir en consola
    return tarifaTotal;
}

    public static LocalDate parseFecha(String fechaStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fechaStr, formatter);
    }

    // Método para calcular la duración en días entre dos fechas
    public static int calcularDuracionEnDias(LocalDate fechaInicio, LocalDate fechaFin) {
        return (int) fechaInicio.until(fechaFin, java.time.temporal.ChronoUnit.DAYS);
    }
        
        
    public static void guardarHistorialEnArchivo(List<Historial> historial) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("./data/reservas.csv"))) {
        	writer.println("Correo cliente,Vehículo Reservado,Fecha de Reserva,Fecha de Alquiler,Tarifa,Seguros,Entrega,Devolución,Estado");

            for (Historial reserva : historial) {
                writer.println(reserva.getCorreoCliente() + ","
                        + reserva.getVehiculoReservado() + ","
                        + reserva.getFechaReserva() + ","
                        + reserva.getFechaAlquiler() + ","
                        + reserva.getTarifa() + ","
                        + reserva.getSeguros() + ","
                        + reserva.getEntrega() + ","
                        + reserva.getDevolucion() + ","
                        + reserva.getEstado());
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de historial: " + e.getMessage());
        }
    }

    }
    

    
 




