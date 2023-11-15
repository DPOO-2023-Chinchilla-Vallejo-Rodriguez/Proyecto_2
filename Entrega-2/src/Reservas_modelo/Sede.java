package Reservas_modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


import reservas_procesamiento.Reservas;

public class Sede {
    private String nombre;
    private String ubicacion;
    private String horariosAtencion;


    //Constructor Sedes
    public Sede(String nombre, String ubicacion, String horariosAtencion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.horariosAtencion = horariosAtencion;   
    }

    public static List<String> vernombresSede() {
        List<String> informacionSede = new ArrayList<>();

        // Recorrer la lista de sedes y buscar la correspondiente al nombre proporcionado
        List<Sede> sedes = Reservas.getSedes();
        for (Sede sede : sedes) {
                informacionSede.add(sede.getNombre());
                                  // Salir del bucle una vez que se encuentra la sede
            }
        
        // Retornar la lista con la información de la sede
        return informacionSede;
    }
    
   
    public static List<String> verInformacionSede(String sedeNombre) {
        List<String> informacionSede = new ArrayList<>();
        boolean sedeEncontrada = false;

        // Recorrer la lista de sedes y buscar la correspondiente al nombre proporcionado
        List<Sede> sedes = Reservas.getSedes();
        for (Sede sede : sedes) {
            if (sede.getNombre().equalsIgnoreCase(sedeNombre)) {
                informacionSede.add("Información de la Sede:");
                informacionSede.add("Nombre: " + sede.getNombre());
                informacionSede.add("Ubicación: " + sede.getUbicacion());
                informacionSede.add("Horarios de Atención: " + sede.getHorariosAtencion());
                sedeEncontrada = true;
                break;  // Salir del bucle una vez que se encuentra la sede
            }
        }

        if (!sedeEncontrada) {
            informacionSede.add("No se encontró la sede con el nombre especificado.");
        }

        // Retornar la lista con la información de la sede
        return informacionSede;
    }

	public static void cambiarInformacionSedes(String sede, String nuevoNombre, String nuevaUbicacion, String nuevosHorarios) {
    List<Sede> sedes = Reservas.getSedes();
    boolean sedeEncontrada = false;

    for (Sede s : sedes) {
        if (s.getNombre().equalsIgnoreCase(sede)) {
            s.setNombre(nuevoNombre);
            s.setUbicacion(nuevaUbicacion);
            s.setHorariosAtencion(nuevosHorarios);
            sedeEncontrada = true;
            break;  // Salir del bucle al encontrar la sede
        }
    }

    if (!sedeEncontrada) {
    	System.err.println("No se encontró la sede con el nombre especificado.");
    }

    eliminarLinea(sede);
    // Guardar los cambios en el archivo
    guardarSedesEnArchivo(nuevoNombre, nuevaUbicacion,nuevosHorarios);
}


	//Guardar en archivo

	public static void guardarSedesEnArchivo(String nombreSede, String ubicacionSede, String horariosAtencionSede) {
	    String informacionSede = nombreSede + "," + ubicacionSede + "," + horariosAtencionSede;

	    guardarInformacionEnArchivo("./data/sedes.csv", informacionSede);
	}
	
	public static void guardarInformacionEnArchivo(String rutaArchivo, String informacion) {
	    try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo, true))) {
	        writer.println(informacion);
	    } catch (IOException e) {
	        System.err.println("Error al escribir en el archivo: " + e.getMessage());
	    }
	}

	public static void eliminarLinea( String identificador) {
	    List<String> lineas = new ArrayList<>();

	    try (BufferedReader br = new BufferedReader(new FileReader("./data/sedes.csv"))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            // Excluir la línea que coincide con el identificador a eliminar
	            if (!linea.startsWith(identificador + ",")) {
	                lineas.add(linea);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // Sobrescribir el archivo con el contenido actualizado
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter("./data/sedes.csv"))) {
	        for (String linea : lineas) {
	            bw.write(linea);
	            bw.newLine();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
    // Otros metodos y funcionalidades

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHorariosAtencion() {
        return horariosAtencion;
    }

    public void setHorariosAtencion(String horariosAtencion) {
        this.horariosAtencion = horariosAtencion;
    }
}
