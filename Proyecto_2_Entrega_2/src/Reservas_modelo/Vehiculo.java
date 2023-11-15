package Reservas_modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import java.util.Iterator;



import reservas_procesamiento.Reservas;

public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String tipoTransmision;
    private String categoria;
    private String estado; // alquilado, disponible, en mantenimiento
    private String sede; // Cambiamos el tipo de ubicación a Sede
    
    //Constructor vehiculos
    public Vehiculo(String placa, String marca, String modelo, String color, String tipoTransmision, String categoria,String estado, String sede )
    {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipoTransmision = tipoTransmision;
        this.categoria = categoria;
        this.estado =estado;     
        this.sede = sede;// Inicialmente no tiene ubicación
    }
    
    
   public static List<List<String>> verVehiculosSede(String sedeNombre) {
    List<Vehiculo> vehiculos = Reservas.getVehiculos();
    List<List<String>> informacionVehiculos = new ArrayList<>();

    for (Vehiculo vehiculo : vehiculos) {
        if (vehiculo.getsede().equalsIgnoreCase(sedeNombre)) {
            // Crear una lista con la información del vehículo y agregarla a la lista principal
            List<String> infoVehiculo = new ArrayList<>();
            infoVehiculo.add("Placa: " + vehiculo.getPlaca());
            infoVehiculo.add("Marca: " + vehiculo.getMarca());
            infoVehiculo.add("Modelo: " + vehiculo.getModelo());
            infoVehiculo.add("Color: " + vehiculo.getColor());
            infoVehiculo.add("Transmisión: " + vehiculo.getTipoTransmision());
            infoVehiculo.add("Categoría: " + vehiculo.getCategoria());
            infoVehiculo.add("Estado: " + vehiculo.getEstado());
            infoVehiculo.add("Ubicación: " + vehiculo.getsede());

            informacionVehiculos.add(infoVehiculo);
        }
    }

    // Retornar la lista con la información de los vehículos
    return informacionVehiculos;
}

    public static void asignarVehiculoASede(String placaVehiculoModificar, String nuevaUbicacion) {
    List<Sede> sedes = Reservas.getSedes();
    List<Vehiculo> vehiculos = Reservas.getVehiculos();

    // Variable para indicar si se encontró el vehículo en la lista
    boolean vehiculoEncontrado = false;

    // Buscar el vehículo en la lista
    for (Vehiculo vehiculo : vehiculos) {
        if (vehiculo.getPlaca().equals(placaVehiculoModificar)) {
            vehiculoEncontrado = true;

            for (Sede sede : sedes) {
                if (sede.getNombre().equals(nuevaUbicacion)) {
                    vehiculo.setUbicacion(sede.getNombre());
                    break; // Agrega este break para salir del bucle una vez que se encuentra la sede
                }
            }
        }
    }

    // Si no se encontró el vehículo, no se realiza ningún cambio
    if (!vehiculoEncontrado) {
    	System.err.println("No se encontró el vehículo especificado.");
    }

    // Actualizar la lista de vehículos en memoria
    guardarVehiculosEnArchivo(vehiculos);
}

    public static void agregarVehiculo(String placa, String marca, String modelo, String color, String tipoTransmision,
        String categoria, String estado, String sede) {
    List<Vehiculo> vehiculos = Reservas.getVehiculos();

    // Crear un nuevo objeto Vehiculo y agregarlo a la lista
    Vehiculo nuevoVehiculo = new Vehiculo(placa, marca, modelo, color, tipoTransmision, categoria, estado, sede);
    vehiculos.add(nuevoVehiculo);

    // Guardar los cambios en el archivo
    guardarVehiculosEnArchivo(vehiculos);
}
    
    public static void eliminarVehiculo(String placaEliminar) {
    List<Vehiculo> vehiculos = Reservas.getVehiculos();
    Iterator<Vehiculo> iterador = vehiculos.iterator();
    while (iterador.hasNext()) {
        Vehiculo vehiculo = iterador.next();
        if (vehiculo.getPlaca().equals(placaEliminar)) {
            iterador.remove();
            // Guardar los cambios en el archivo
            guardarVehiculosEnArchivo(vehiculos);
            
             // Salir del método después de eliminar el vehículo
        }
    }

    System.err.println("No se encontró ningún vehículo con la placa especificada.");
}

    public static void cambiarEstadoUbicacionVehiculo(String sede, String placaVehiculoModificar, String nuevoEstado, String nuevaUbicacion) {
    List<Sede> sedes = Reservas.getSedes();
    List<Vehiculo> vehiculos = Reservas.getVehiculos();


    // Buscar el vehículo en la lista
    for (Vehiculo vehiculo : vehiculos) {
        if (vehiculo.getPlaca().equals(placaVehiculoModificar) && vehiculo.getsede().equals(sede)) {
            

            // Modificar el estado del vehículo si se proporciona un nuevo estado
            if (nuevoEstado != null) {
                vehiculo.setEstado(nuevoEstado);
            }

            // Modificar la sede del vehículo si se proporciona una nueva ubicación
            if (nuevaUbicacion != null) {
                for (Sede sedeObj : sedes) {
                    if (sedeObj.getNombre().equals(nuevaUbicacion)) {
                        vehiculo.setUbicacion(sedeObj.getNombre());
                        break; // Salir del bucle una vez que se encuentra la sede
                    }
                }
            }
        }
    }

    // Actualizar la lista de vehículos en memoria
    guardarVehiculosEnArchivo(vehiculos);

    
}


    public static boolean verificarDisponibilidadVehiculo(String placaVehiculo) {
        List<Vehiculo> vehiculos = Reservas.getVehiculos();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placaVehiculo) && vehiculo.getEstado().equals("Disponible")) {
                return true;
            }
        }
        return false;
    }

    
    public static String obtenerPlacaVehiculoAlAzar(String nombreCategoria, String nombreSede) {
    List<Vehiculo> vehiculos = Reservas.getVehiculos();

    String estado = "Disponible";
    for (Vehiculo vehiculo : vehiculos) {
        if (vehiculo.getCategoria().equals((nombreCategoria)) && vehiculo.getsede().equals(nombreSede)&& vehiculo.getEstado().equals(estado)) {
        	return vehiculo.getPlaca();
        }
    }
	return null;
}

    //Guardar en archivo
    public static void guardarVehiculosEnArchivo(List<Vehiculo> vehiculos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("./data/inventario.csv"))) {
            // Escribir la cabecera en la primera línea
            writer.println("Placa,Marca,Modelo,Color,TipoTransmision,Categoria,Estado,Sede");

            // Escribir datos a partir de la segunda línea
            for (Vehiculo vehiculo : vehiculos) {
                writer.println(vehiculo.getPlaca() + "," + vehiculo.getMarca() + "," + vehiculo.getModelo()
                        + "," + vehiculo.getColor() + "," + vehiculo.getTipoTransmision() + "," + vehiculo.getCategoria()
                        + "," + vehiculo.getEstado() + "," + vehiculo.getsede());
                // Agregar más campos según sea necesario
            }

            
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de vehículos: " + e.getMessage());
        }
    }

    
    
    
 // Función para obtener la disponibilidad de vehículos por día en un mes y sede específicos
    public static List<Integer> obtenerDisponibilidad(String sede, int mes) {
        List<Vehiculo> vehiculos = Reservas.getVehiculos();
        List<Historial> historial = Reservas.getHistorial();
        List<Integer> disponibilidadPorDia = new ArrayList<>();

        // Código para inicializar la lista de disponibilidad con valores predeterminados (todos disponibles)
        int diasEnElMes = obtenerDiasEnElMes(mes);
        disponibilidadPorDia.addAll(Arrays.asList(new Integer[diasEnElMes]));
        disponibilidadPorDia.replaceAll(val -> 0); // Inicializar a 0, ya que se va a sumar

        

        // Recorrer las reservas y actualizar la disponibilidad
        for (Historial reserva : historial) {
            if (reserva.getEntrega().equals(sede)) { 
                int diaReservado = obtenerDia(reserva.getFechaAlquiler());
                // Incrementar el contador de carros en la sede
                if (obtenerMes(reserva.getFechaAlquiler()) == mes) {
                    disponibilidadPorDia.set(diaReservado - 1, disponibilidadPorDia.get(diaReservado - 1) - 1);
                }
                
            }
        }

        // Recorrer los vehículos en la sede y sumar 1 a la disponibilidad por día
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getsede().equals(sede)) {
               

                for (int dia = 1; dia <= diasEnElMes; dia++) {
                    disponibilidadPorDia.set(dia - 1, disponibilidadPorDia.get(dia - 1) + 1);
                }
            }
        }

        

        return disponibilidadPorDia;
    }
    // Función para obtener el día de una fecha representada como cadena
    private static int obtenerDia(String fecha) {
        LocalDate localDate = LocalDate.parse(fecha); // Puede necesitar un formato específico
        return localDate.getDayOfMonth();
    }

    // Función para obtener el mes de una fecha representada como cadena
    private static int obtenerMes(String fecha) {
        LocalDate localDate = LocalDate.parse(fecha); // Puede necesitar un formato específico
        return localDate.getMonthValue();
    }


    // Función para obtener la cantidad de días en un mes (puedes ajustarla según tus necesidades)
    private static int obtenerDiasEnElMes(int mes) {
        switch (mes) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return 28; // Ignorando años bisiestos por simplicidad
            default:
                return 31;
        }
    }

    

    public static void eliminarVehiculos(String vehiculoAEliminar) {
        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("./data/inventario.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Excluir la línea que coincide con el correo a eliminar
                if (!linea.startsWith(vehiculoAEliminar + ",")) {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sobrescribir el archivo con el contenido actualizado
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./data/inventario.csv"))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    //Metodos para cambiar la información del vehiculo
    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void actualizarUbicacion(String nuevaUbicacion) {
        this.sede = nuevaUbicacion;
    }
    
    public void setUbicacion(String destino) {
        this.sede = destino;
    }

    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }
    
    //Metodos para obtener información del vehiculo
    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getTipoTransmision() {
        return tipoTransmision;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEstado() {
        return estado;
    }

    public String getsede() {
        return sede;
    }
}