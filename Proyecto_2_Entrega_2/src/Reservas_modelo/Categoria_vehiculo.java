package Reservas_modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import reservas_procesamiento.Reservas;

public class Categoria_vehiculo {
    private String nombre;
    private String descripcion;
    private double tarifaDiaria;

    //Constructor categoras
    public Categoria_vehiculo(String nombre, String descripcion, double tarifaDiaria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tarifaDiaria = tarifaDiaria;
    }

    
    public static List<List<String>> obtenerInformacionCategorias() {
        List<Categoria_vehiculo> categorias = Reservas.getCategoria();
        List<List<String>> informacionCategorias = new ArrayList<>();

        for (Categoria_vehiculo categoria : categorias) {
            List<String> infoCategoria = new ArrayList<>();
            infoCategoria.add("Nombre: " + categoria.getNombre());
            infoCategoria.add("Descripción: " + categoria.getDescripcion());
            infoCategoria.add("Tarifa diaria: " + categoria.getTarifaDiaria());

            informacionCategorias.add(infoCategoria);
        }

        return informacionCategorias;
    }

    
    public static Categoria_vehiculo obtenerInformacionCategoriaPorNombre(String nombreCategoria) {
        List<Categoria_vehiculo> categorias = Reservas.getCategoria();
        for (Categoria_vehiculo categoria : categorias) {
            System.out.println(categoria.getNombre());
            if (categoria.getNombre().equalsIgnoreCase(nombreCategoria)) {
                return categoria;
            }
        }
        
        return null;
    }



    public static void agregarCategoria(String nombre, String descripcion, double tarifaDiaria) {
        List<Categoria_vehiculo> categorias = Reservas.getCategoria();

        // Crear un nuevo objeto Categoria_vehiculo y agregarlo a la lista
        Categoria_vehiculo nuevaCategoria = new Categoria_vehiculo(nombre, descripcion, tarifaDiaria);
        categorias.add(nuevaCategoria);

        // Guardar los cambios en el archivo
        guardarCategoriasEnArchivo(categorias);
    }

    public static void modificarInformacionCategoria(String nombreCategoria, String nuevoNombre, String nuevaDescripcion, double nuevaTarifaDiaria) {
    List<Categoria_vehiculo> categorias = Reservas.getCategoria();

    for (Categoria_vehiculo categoria : categorias) {
        if (categoria.getNombre().equals(nombreCategoria)) {
            // Modificar la categoría de vehículo con los nuevos datos
            categoria.setNombre(nuevoNombre);
            categoria.setDescripcion(nuevaDescripcion);
            categoria.setTarifaDiaria(nuevaTarifaDiaria);
            // Eliminar la categoría de vehículo antigua
            eliminarCategoria(nombreCategoria);
            // Guardar los cambios en el archivo
            guardarCategoriasEnArchivo(categorias);
            // Salir del método después de modificar la categoría de vehículo
            
        }
    }

    // Si no se encontró la categoría de vehículo, mostrar un mensaje
    System.err.println("No se encontró ninguna categoría de vehículo con el nombre especificado.");
}
    
    public static void eliminarCategoria(String nombreCategoria) {
        List<Categoria_vehiculo> categorias = Reservas.getCategoria();

        Iterator<Categoria_vehiculo> iterador = categorias.iterator();
        while (iterador.hasNext()) {
            Categoria_vehiculo categoria = iterador.next();
            if (categoria.getNombre().equals(nombreCategoria)) {
                iterador.remove();

                // Guardar los cambios en el archivo
                guardarCategoriasEnArchivo(categorias);

            }
        }
            }
        

    //Guardar en el archivo
    public static void guardarCategoriasEnArchivo(List<Categoria_vehiculo> categorias) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("./data/categorias.csv"))) {
        	writer.println("Nombre,Descripcion,CostoAdicionalPorDia");
            for (Categoria_vehiculo categoria : categorias) {
                writer.println(categoria.getNombre() + "," + categoria.getDescripcion() + "," + categoria.getTarifaDiaria());
                // Agregar más campos según sea necesario
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de categorías de vehículos: " + e.getMessage());
        }
    }

    

    // Otros métodos y funcionalidades relacionados con la categoría de vehículos
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

	public double getTarifaDiaria() {
		return tarifaDiaria;
	}

	public void setTarifaDiaria(double tarifaDiaria) {
		this.tarifaDiaria = tarifaDiaria;
	}

    

}

