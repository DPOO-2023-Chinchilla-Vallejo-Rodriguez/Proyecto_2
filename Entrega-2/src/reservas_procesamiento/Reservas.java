package reservas_procesamiento;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Reservas_modelo.Empleado;
import Reservas_modelo.Licencia_conducion;
import Reservas_modelo.Medio_pago;
import Reservas_modelo.Sede;
import Reservas_modelo.Seguro;
import Reservas_modelo.Usuario;
import Reservas_modelo.Vehiculo;
import Reservas_modelo.Historial;
import Reservas_modelo.Categoria_vehiculo;

// Reservas_modelo.Licencia_conducion;
//import Reservas_modelo.Medio_pago;

public class Reservas {
	
	
	/************************************************
	 * ATRIBUTOS 
	 ************************************************/
	
	private static List <Usuario> usuarios;
	private static List <Empleado> empleados;
	private static List <Vehiculo> vehiculos;
	private static List <Sede> sedes;
	private static List <Categoria_vehiculo> categoria;
	private static List <Historial> historial;
	private Licencia_conducion licencia;
	private Medio_pago MedioPago;
	private Empleado empleado;
	private static List<Seguro> seguros;
	

	private HashMap<String, String> nombres;
	/************************************************
	 * CONSTRUCTOR
	 ************************************************/
	@SuppressWarnings("static-access")
	public Reservas()
	{
		this.usuarios = new ArrayList <Usuario>();
		this.nombres = new HashMap<String,String>();
		this.empleados= new ArrayList <Empleado>();
		this.sedes =  new ArrayList <Sede>();
		this.seguros= new ArrayList <Seguro>();
		this.categoria= new ArrayList <Categoria_vehiculo>();
		this.historial= new ArrayList <Historial>();
		this.vehiculos= new ArrayList <Vehiculo>();
;
	}
	
	/************************************************
	 * MÉTODOS
	 ************************************************/

	public void readTextDataUTF8Usuario() {
	    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/usuarios.csv"), "UTF-8"))) {
	        String line;
	        br.readLine(); // Omitir la primera línea de encabezados
	        while ((line = br.readLine()) != null) {
	            String[] data = line.split(","); // datos separados por comas
	            if (data.length >= 17) {
	                String correo = data[0];
	                String password = data[1];
	                String rol = data[2];
	                String nombre = data[3];
	                String telefono = data[4];
	                String fechaNacimiento = data[5];
	                String nacionalidad = data[6];
	                String ID = data[7];
	                String numeroLicencia = data[8];
	                String paisExpedicionLicencia = data[9];
	                String fechaVencimientoLicencia = data[10];
	                String imagenLicencia = data[11];
	                String nombreTitularTarjeta = data[12];
	                String numeroTarjeta = data[13];
	                String fechaVencimientoTarjeta = data[14];
	                String codigoSeguridadTarjeta = data[15];
	                String sede = data[16];

	                if ("cliente".equals(rol)) {
	                    Licencia_conducion licencia = new Licencia_conducion(numeroLicencia, paisExpedicionLicencia, fechaVencimientoLicencia, imagenLicencia);

	                    Medio_pago medioPago = new Medio_pago(nombreTitularTarjeta, numeroTarjeta, fechaVencimientoTarjeta, codigoSeguridadTarjeta);

	                    Usuario user = new Usuario(correo, password, nombre, telefono, fechaNacimiento, nacionalidad, ID, licencia, medioPago);

	                    usuarios.add(user);
	                } else {
	                    Empleado empleado = new Empleado(correo, password, rol, nombre, telefono, fechaNacimiento,nacionalidad, ID,  sede);
	                    empleados.add(empleado);	                    
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	public void readTextDataUTF8Sedes() {
	    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/sedes.csv"), "UTF-8"))) {
	        String line;
	        br.readLine(); // Omitir la primera línea de encabezados
	        while ((line = br.readLine()) != null) {
	            String[] data = line.split(","); // Datos separados por comas

	            if (data.length >= 3) {
	                String nombreSede = data[0];
	                String ubicacion = data[1];
	                String horarios = data[2];

	                // Crear un objeto de Sede con los datos y agregarlo a la lista de sedes
	                Sede sede = new Sede(nombreSede, ubicacion, horarios);
	                sedes.add(sede);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void readTextDataUTF8Inventario() {
	    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/inventario.csv"), "UTF-8"))) {
	        String line;
	        br.readLine(); // Omitir la primera línea de encabezados
	        while ((line = br.readLine()) != null) {
	            String[] data = line.split(","); // Datos separados por comas

	            if (data.length >= 8) {
	                String placa = data[0];
	                String marca = data[1];
	                String modelo = data[2];
	                String color = data[3];
	                String transmision = data[4];
	                String categoria = data[5];
	                String estado = data[6];
	                String ubicacion = data[7];

	                Vehiculo vehiculo = new Vehiculo(placa, marca, modelo, color, transmision, categoria, estado, ubicacion);
                    vehiculos.add(vehiculo);
	                
	                
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}



	
	    public void readTextDataUTF8Seguros() {
	        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/seguro.csv"), "UTF-8"))) {
	            String line;
	            br.readLine(); // Omitir la primera línea de encabezados
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(","); // Datos separados por comas

	                if (data.length >= 3) {
	                	String nombreSeguro = data[0];
	 	                String descripcion = data[1];
	 	                double precio = Double.parseDouble(data[2]); // Convertir el precio a double

	                    // Crear un objeto de Sede con los datos y agregarlo a la lista de seguros
	                    Seguro seguro = new Seguro(nombreSeguro, descripcion, precio);
	                    seguros.add(seguro);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	    public void readTextDataUTF8Categorias() {
	        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/categorias.csv"), "UTF-8"))) {
	            String line;
	            br.readLine(); // Omitir la primera línea de encabezados
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(","); // Datos separados por comas

	                if (data.length >= 3) {
		                String nombrecategoria = data[0];
		                String descripcion = data[1];
		                double precio = Double.parseDouble(data[2]); // Convertir el precio a double

		                // Crear un objeto de Sede con los datos y agregarlo a la lista de sedes
		                Categoria_vehiculo categoriav = new Categoria_vehiculo(nombrecategoria, descripcion, precio);
		                categoria.add(categoriav);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }


	public void readTextDataUTF8Historial() {
	    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data/reservas.csv"), "UTF-8"))) {
	        String line;
	        br.readLine(); // Omitir la primera línea de encabezados
	        while ((line = br.readLine()) != null) {
	            String[] data = line.split(","); // Datos separados por tabulaciones

	            if (data.length >= 9) {
	                String correoCliente = data[0];
	                String vehiculoReservado = data[1];
	                String fechaReserva = data[2];
	                String fechaAlquiler = data[3];
	                Double tarifa = Double.parseDouble(data[4]); // Convertir la tarifa a double
	                String seguros = data[5];
	                String entrega = data[6];
	                String devolucion = data[7];
	                String estado = data[8];

	                // Crear un objeto de Reserva con los datos y agregarlo a la lista de reservas
	                Historial historia= new Historial ( correoCliente, vehiculoReservado, fechaReserva, fechaAlquiler, tarifa, seguros, entrega, devolucion, estado);
	                historial.add(historia);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


	// Método para inicializar los datos al iniciar el programa
    public void inicializar() {
        readTextDataUTF8Usuario();
        readTextDataUTF8Sedes();
        readTextDataUTF8Inventario();
        readTextDataUTF8Seguros();
        readTextDataUTF8Categorias();
        readTextDataUTF8Historial();
    }



	
	public static List <Empleado> getEmpleados ()
	{
		return empleados;
	}
	
	public static List <Usuario> getUsuarios()
	{
		return usuarios;
	}
	
	
	public static List <Vehiculo> getVehiculos ()
	{
		return vehiculos;
	}
	
	public static List <Historial> getHistorial ()
	{
		return historial;
	}
	
	public static List<Sede> getSedes ()
	{
		return sedes;
	}
	
	public static List<Seguro> getSeguros() {
		return seguros;
	}



	public static List<Categoria_vehiculo> getCategoria() {
		return categoria;
	}

	public static void setCategoria(List<Categoria_vehiculo> categoria) {
		Reservas.categoria = categoria;
	}

	public Map<String,String> getNombres()
	{
		return nombres;
	}
	

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Medio_pago getMedioPago() {
		return MedioPago;
	}
	
	

	public void setMedioPago(Medio_pago medioPago) {
		MedioPago = medioPago;
	}

	public Licencia_conducion getLicencia() {
		return licencia;
	}

	public void setLicencia(Licencia_conducion licencia) {
		this.licencia = licencia;
	}


    public static void main(String[] args) {
        
    }

	public static void setHistorial(List<Historial> nuevasReservas) {
		// TODO Auto-generated method stub
		historial = nuevasReservas;
		
	}
	
	public static void setUsuarios(List<Usuario> nuevasReservas) {
		// TODO Auto-generated method stub
		usuarios = nuevasReservas;
		
	}
	
	public static void setEmpleados(List<Empleado> nuevasReservas) {
		// TODO Auto-generated method stub
		empleados = nuevasReservas;
		
	}

	public static void setVehiculos(List<Vehiculo> nuevasReservas) {
		// TODO Auto-generated method stub
		vehiculos = nuevasReservas;
		
	}

}
