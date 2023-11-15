package Reservas_modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import reservas_procesamiento.Reservas;

public class Seguro {
    private String nombre;
    private String descripcion;
    private double costoAdicionalPorDia;

    public Seguro(String nombre, String descripcion, double costoAdicionalPorDia) {
        this.nombre = nombre;
        this.descripcion=descripcion;
        this.costoAdicionalPorDia = costoAdicionalPorDia;
    }


    public static List<List<String>> obtenerInformacionSeguros() {
        List<Seguro> seguros = Reservas.getSeguros();
        List<List<String>> informacionSeguros = new ArrayList<>();

        for (Seguro seguro : seguros) {
            List<String> infoSeguro = new ArrayList<>();
            infoSeguro.add("Nombre: " + seguro.getNombre());
            infoSeguro.add("Descripción: " + seguro.getDescripcion());
            infoSeguro.add("Precio por día: " + seguro.getCostoAdicionalPorDia());
            infoSeguro.add("-----------------------");

            informacionSeguros.add(infoSeguro);
        }

        return informacionSeguros;
    }


    public static void agregarSeguro(String nombre, String descripcion, double precio) {
        List<Seguro> seguros = Reservas.getSeguros();

        // Crear un nuevo objeto Seguro y agregarlo a la lista
        Seguro nuevoSeguro = new Seguro(nombre, descripcion, precio);
        seguros.add(nuevoSeguro);

        // Guardar los cambios en el archivo
        guardarSegurosEnArchivo(seguros);
    }

    public static void modificarInformacionSeguro(String nombreSeguro, String nuevoNombre, String nuevaDescripcion, double nuevoPrecio) {
        List<Seguro> seguros = Reservas.getSeguros();
        for (Seguro seguro : seguros) {
            if (seguro.getNombre().equals(nombreSeguro)) {
                // Modificar el seguro con los nuevos datos
                seguro.setNombre(nuevoNombre);
                seguro.setDescripcion(nuevaDescripcion);
                seguro.setCostoAdicionalPorDia(nuevoPrecio);
                eliminarSeguro(nombreSeguro);
                // Guardar los cambios en el archivo
                guardarSegurosEnArchivo(seguros); 
                 // Salir del método después de modificar el seguro
            }
        }
    }
    
    public static Seguro obtenerInformacionSeguroPorNombre(String nombreCategoria) {
    	List<Seguro> seguros = Reservas.getSeguros();
        for (Seguro seguro : seguros) {
            if (seguro.getNombre().equals(nombreCategoria)) {
                
                return seguro;
            }
        }
		return null;
        
    }

    public static void eliminarSeguro(String nombre) {
        List<Seguro> seguros = Reservas.getSeguros();
        
        Iterator<Seguro> iterador = seguros.iterator();
        while (iterador.hasNext()) {
            Seguro seguro = iterador.next();
            if (seguro.getNombre().equals(nombre)) {
                iterador.remove();
                guardarSegurosEnArchivo(seguros);  // Actualizar el archivo después de la eliminación
                  // Salir del método después de eliminar el seguro
            }
        }
    }
   
    //Guardar en archivo
    public static void guardarSegurosEnArchivo(List<Seguro> seguros) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("./data/seguro.csv"))) {
            // Escribir la cabecera en la primera línea
            writer.println("Nombre,Descripcion,CostoAdicionalPorDia");

            // Escribir datos a partir de la segunda línea
            for (Seguro seguro : seguros) {
                writer.println(seguro.getNombre() + "," + seguro.getDescripcion() + "," + seguro.getCostoAdicionalPorDia());
            }

            
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de seguros: " + e.getMessage());
        }
    }


    //Otros  metodos y duncionalidades
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getCostoAdicionalPorDia() {
		return costoAdicionalPorDia;
	}

	public void setCostoAdicionalPorDia(double costoAdicionalPorDia) {
		this.costoAdicionalPorDia = costoAdicionalPorDia;
	}



    // Otros métodos y funcionalidades relacionados con los seguros

    
 
}
