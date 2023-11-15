package reservas_consola;
   
import java.util.Scanner;


import Reservas_modelo.Categoria_vehiculo;
import Reservas_modelo.Empleado;
import Reservas_modelo.Empresa;
import Reservas_modelo.Sede;
import Reservas_modelo.Seguro;
import Reservas_modelo.Usuario;
import Reservas_modelo.Vehiculo;
import reservas_procesamiento.Reservas;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;





public class Sistema {
	
	private Reservas reserva;
    private static Usuario usuarioSesion;
    static String Sedeu = null;
    static String Nombreu = null;
    static String correoUsuario = null;
    
    
	

    //Inicio de sesion 
    	public Sistema() throws FileNotFoundException, IOException {
        reserva = new Reservas();
		reserva.inicializar();

		// Listas de usuarios y empleados desde la instancia de Reservas
		List<Usuario> usuarios = Reservas.getUsuarios();
		List<Empleado> empleados = Reservas.getEmpleados();

		System.out.println("Lista de suarios:");
		for (Usuario usuario : usuarios) {
		    System.out.println(usuario.getCorreo() + "-" + usuario.getpassword());
		}
		System.out.println("\nLista de Empleados:");
		for (Empleado empleado : empleados) {
		    System.out.println(empleado.getLogin() + "-" + empleado.getPassword());
		}

		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese el usuario: ");
		String correoUsuario = scanner.next();
		System.out.print("Ingrese la contraseña: ");
		String passwordUsuario = scanner.next();

		// Variable para almacenar el rol del usuario
		String rolUsuario = null;

		boolean inicioSesionExitoso = false;
		for (Usuario usuario : usuarios) {
		    if (usuario.getCorreo().equals(correoUsuario) && usuario.getpassword().equals(passwordUsuario)) {
		        // El usuario ha iniciado sesión correctamente como cliente
		        System.out.println("Inicio de sesión exitoso como cliente.");
		        inicioSesionExitoso = true;
		        usuarioSesion = usuario;
		        rolUsuario = "cliente";
		        correoUsuario= usuario.getCorreo();
		        MenuCliente(scanner);
		        break;

		    }
		    
		}
		if (!inicioSesionExitoso) {
		    for (Empleado empleado : empleados) {
		        if (empleado.getLogin().equals(correoUsuario) && empleado.getPassword().equals(passwordUsuario)) {
		            // El empleado ha iniciado sesión correctamente
		            System.out.println("Inicio de sesión exitoso como " + empleado.getRol() + ".");
		            inicioSesionExitoso = true;
		            Sedeu = empleado.getSede();
		            Nombreu = empleado.getNombre();
		            rolUsuario = empleado.getRol();
		            break;
		        }
		    }
		}

		if (inicioSesionExitoso) {
		    if (rolUsuario.equals("Admin Local")) {
		        menuAdministradorLocal(scanner);
		    } else if (rolUsuario.equals("Admin General")) {
		        menuAdministradorGeneral(scanner);
		    } else if (rolUsuario.equals("Empleado")) {
		        menuEmpleado(scanner);
		    }
		} else {
		    System.out.println("Inicio de sesión fallido. Verifica tus credenciales.");
		}

		scanner.close();
    }


    /************************************************
     * Menú y métodos para Administrador Local
     * Descripción:
     * Este menú está diseñado para el Administrador Local y proporciona las herramientas necesarias
     * para gestionar la información específica de una sede, así como para supervisar y administrar
     * empleados y vehículos asociados a esa sede.
     * 
     * Funcionalidades:
     * 1. Ver y cambiar la información específica de su sede.
     *    - Proporciona al Administrador Local la capacidad de visualizar y modificar detalles como el nombre, la ubicación
     *      y los horarios de atención de la sede que está supervisando.
     * 2. Ver, registrar, cambiar y eliminar empleados de la sede.
     *    - Permite al Administrador Local gestionar el personal asignado a su sede, incluyendo la visualización, registro,
     *      modificación y eliminación de empleados.
     * 3. Ver, actualizar el estado y la ubicación de los vehículos en su sede.
     *    - Ofrece al Administrador Local la capacidad de supervisar el inventario de vehículos, así como actualizar el estado
     *      y la ubicación de los vehículos asignados a su sede.
     *      
     * Nota:
     * Cada funcionalidad está respaldada por métodos específicos implementados en la clase Admin_local.
     ************************************************/

    	private static void menuAdministradorLocal(Scanner scanner) {
	    boolean menuActivo = true;
	    while (menuActivo) {
	        System.out.println("\nMenú del Administrador Local:");
	        System.out.println("1. Ver información de la sede");
	        System.out.println("2. Cambiar información de la sede");
	        System.out.println("3. Ver información de los vehículos de la sede");
	        System.out.println("4. Cambiar estado o ubicación de algún vehículo");
	        System.out.println("5. Gestionar empleados");
	        System.out.println("6. Cerrar sesión");
	        System.out.print("Elija una opción: ");
	
	        // Verificar si hay un siguiente entero antes de intentar leer
	        if (scanner.hasNextInt()) {
	            int opcion = scanner.nextInt();
	            scanner.nextLine(); // Consumir el salto de línea pendiente
	
	            switch (opcion) {
	                case 1:
	                	System.out.println (Sede.verInformacionSede(Sedeu));
	                    break;
	                case 2:
	                	 System.out.print("Nuevo nombre de la sede: ");
	                     String nuevoNombre = scanner.nextLine();
	                     
	                     System.out.print("Nueva ubicación de la sede: ");
	                     String nuevaUbicacion = scanner.nextLine();
	                     
	                     System.out.print("Nuevos horarios de atención de la sede: ");
	                     String nuevosHorarios = scanner.nextLine();
	                     
	                    Sede.cambiarInformacionSedes(Sedeu, nuevoNombre, nuevaUbicacion, nuevosHorarios);
	                    break;
	                case 3:
	                	System.out.print(Vehiculo.verVehiculosSede(Sedeu));
	                    break;
	                case 4:
	                	 System.out.print("Ingrese la placa del vehículo a modificar: ");
	                	    String placaVehiculoModificar = scanner.nextLine();

	                	    System.out.print("Ingrese el nuevo estado del vehículo: ");
	                	    String nuevoEstado = scanner.nextLine();

	                	    System.out.print("Ingrese la nueva sede del vehículo: ");
	                	    String nuevaUbicacion1 = scanner.nextLine();

	                	    Vehiculo.cambiarEstadoUbicacionVehiculo(Sedeu, placaVehiculoModificar, nuevoEstado, nuevaUbicacion1);
	                	    System.out.println("Información del vehículo cambiada con éxito.");
		                    break;
	                    
	                case 5:
	                    menuGestionEmpleados(scanner);
	                    break;
	                case 6:
	                    menuActivo = false;
	                    break;
	                default:
	                    System.out.println("Opción no válida.");
	            }
	        } else {
	            System.out.println("Entrada no válida. Debe ingresar un número.");
	            scanner.nextLine(); // Consumir la entrada incorrecta
	        }
	    }
	}
    	
    	private static boolean menuActivo = true; 
    	
    	private static void menuGestionEmpleados(Scanner scanner) {
	   
	    while (menuActivo) {
	        System.out.println("\nMenú de Gestión de Empleados:");
	        System.out.println("1. Ver empleados existentes");
	        System.out.println("2. Modificar un usuario existente");
	        System.out.println("3. Agregar un nuevo empleado");
	        System.out.println("4. Eliminar un empleado de la sede");
	        System.out.println("5. Volver al menú anterior");
	        System.out.print("Elija una opción: ");
	
	        // Verificar si hay un siguiente entero antes de intentar leer
	        if (scanner.hasNextInt()) {
	            int opcion = scanner.nextInt();
	            scanner.nextLine(); // Consumir el salto de línea pendiente
	
	            switch (opcion) {
	                case 1:
	                    System.out.println("Empleados de la Sede:");
	                    System.out.println(Empleado.mostrarEmpleadossede(Sedeu));
	                    break;
	                case 2:
	                    System.out.print("Ingrese el correo del usuario a modificar: ");
	                    String correoUsuario = scanner.nextLine();
	                    Scanner scanner1 = new Scanner(System.in);

	                    System.out.println("\nIngrese los nuevos datos:");

	                    System.out.print("Nuevo nombre: ");
	                    String nuevoNombre = scanner1.nextLine();

	                    System.out.print("Nueva contraseña: ");
	                    String nuevaContraseña = scanner1.nextLine();

	                    System.out.print("Nuevo rol: ");
	                    String nuevoRol = scanner1.nextLine();

	                    System.out.print("Nuevo teléfono: ");
	                    String nuevoTelefono = scanner1.nextLine();

	                    System.out.print("Nueva fecha de nacimiento: ");
	                    String nuevaFechaNacimiento = scanner1.nextLine();

	                    System.out.print("Nueva nacionalidad: ");
	                    String nuevaNacionalidad = scanner1.nextLine();

	                    System.out.print("Nueva sede: ");
	                    String nuevaSede = scanner1.nextLine();

	                    // Modificar el empleado con los nuevos datos
	                    Empleado.modificarEmpleadoExistente(correoUsuario, nuevoNombre, nuevaContraseña, nuevoRol,
	                            nuevoTelefono, nuevaFechaNacimiento, nuevaNacionalidad, nuevaSede);

	                    System.out.println("Usuario modificado con éxito.");
	                    break;
	                case 3:
	                	Scanner scanner11 = new Scanner(System.in);
	                	System.out.print("Nombre del nuevo empleado: ");
	        	        String nombreEmpleado = scanner11.nextLine();
	        	        System.out.print("Correo del nuevo empleado: ");
	        	        String correoEmpleado = scanner11.nextLine();
	        	        System.out.print("Contraseña del nuevo empleado: ");
	        	        String contraseñaEmpleado = scanner11.nextLine();
	        	        System.out.print("Rol del nuevo empleado: ");
	        	        String rolEmpleado = scanner11.nextLine();
	        	        System.out.print("Teléfono del nuevo empleado: ");
	        	        String telefonoEmpleado = scanner11.nextLine();
	        	        System.out.print("Numero de documento de identidad: ");
	        	        String id = scanner11.nextLine();
	        	        System.out.print("Fecha de nacimiento del nuevo empleado: ");
	        	        String fechaNacimientoEmpleado = scanner11.nextLine();
	        	        System.out.print("Nacionalidad del nuevo empleado: ");
	        	        String nacionalidadEmpleado = scanner11.nextLine();
	        	        System.out.print("Sede del nuevo empleado: ");
	        	        String sedeEmpleado = scanner11.nextLine();
	        	
	        	        // Llamar al método para agregar el nuevo empleado
	        	        Empleado.agregarEmpleado(correoEmpleado, contraseñaEmpleado, rolEmpleado, nombreEmpleado,
	        	                telefonoEmpleado, fechaNacimientoEmpleado, nacionalidadEmpleado, id, sedeEmpleado);
	        	
	        	        System.out.print("Empleado agregado con exito. ");
	                    break;
	                case 4:
	                    System.out.print("Ingrese el correo del usuario a eliminar: ");
	                    String correo = scanner.nextLine();
	                    Empleado.eliminarEmpleados(correo);
	                    System.out.print("Empleado eliminado con exito. ");
	                    break;
	                case 5:
	                    menuActivo = false;
	                    break;
	                default:
	                    System.out.println("Opción no válida.");
	            }
	        } else {
	            System.out.println("Entrada no válida. Debe ingresar un número.");
	            
	        }
	    }
	}
    	
    	
    	
    /************************************************
     * Menú y métodos para Administrador General 
     * 
     * Descripción:
     * Este menú proporciona al Administrador General las herramientas necesarias
     * para realizar tareas de alto nivel en el sistema de alquiler de vehículos.
     * 
     * Funcionalidades:
     * 1. Registrar la compra de nuevos vehículos.
     *    - Permite al Administrador General agregar nuevos vehículos al inventario.
     * 2. Dar de baja vehículos que ya no pueden ser alquilados.
     *    - Permite al Administrador General retirar vehículos del inventario que están fuera de servicio o han sido vendidos.
     * 3. Gestionar las tarifas de alquiler y los seguros.
     *    - Permite ajustar las tarifas de alquiler y gestionar la información de los seguros disponibles.
     * 4. Supervisar la información de todas las sedes y empleados.
     *    - Proporciona una visión general de todas las sedes y empleados registrados en el sistema.
     * 5. Configurar usuarios y roles.
     *    - Permite al Administrador General configurar y gestionar usuarios y roles en el sistema.
     * 
     * Nota:
     * Cada funcionalidad está respaldada por métodos específicos implementados en la clase Admin_general.
     ************************************************/
    
	    private static void menuAdministradorGeneral(Scanner scanner) {
	        boolean menuActivo = true;
	
	        while (menuActivo) {
	            System.out.println("\nMenú del Administrador General:");
	            System.out.println("1. Gestionar Sedes");
	            System.out.println("2. Gestionar Vehículos");
	            System.out.println("3. Gestionar Empleados");
	            System.out.println("4. Gestionar Seguros");
	            System.out.println("5. Gestionar Categorías");
	            System.out.println("6. Ver Reservas");
	            System.out.println("7. Cerrar sesión");
	            System.out.print("Elija una opción: ");
	
	            int opcion = scanner.nextInt();
	            scanner.nextLine(); // Consumir el salto de línea pendiente
	
	            switch (opcion) {
	                case 1:
	                    gestionarSedes(scanner);
	                    break;
	                case 2:
	                    gestionarVehiculos(scanner);
	                    break;
	                case 3:
	                    menuGestionEmpleadosg(scanner);
	                    break;
	                case 4:
	                    menuGestionSegurosg(scanner);
	                    break;
	                case 5:
	                    gestionarCategorias(scanner);
	                    break;
	                case 6:
	                	System.out.println(Empresa.obtenerInformacionReservas());
	                    break;
	                case 7:
	                    menuActivo = false;
	                    break; 
	                default:
	                    System.out.println("Opción no válida.");
	            }
	        }
	    }
	
	    private static void gestionarSedes(Scanner scanner) {
	        boolean menuSedesActivo = true;
	
	        while (menuSedesActivo) {
	            System.out.println("\nMenú de Gestión de Sedes:");
	            System.out.println("1. Ver información de sedes");
	            System.out.println("2. Cambiar información de sedes");
	            System.out.println("3. Volver al menú principal");
	            System.out.print("Elija una opción: ");
	
	            int opcion = scanner.nextInt();
	            scanner.nextLine(); // Consumir el salto de línea pendiente
	
	            switch (opcion) {
	                case 1:
	                	System.out.print("Ingrese el nombre de la sede: ");
	                    String nombreSedeConsulta = scanner.nextLine();
	                    System.out.println(Sede.verInformacionSede(nombreSedeConsulta));
	                    break;
	                case 2:
	                	System.out.print("Ingrese el nombre de la sede: ");
	                    String nombreSedeCambio = scanner.nextLine();
	                    System.out.print("Nuevo nombre de la sede: ");
	                    String nuevoNombre = scanner.nextLine();
	                    
	                    System.out.print("Nueva ubicación de la sede: ");
	                    String nuevaUbicacion = scanner.nextLine();
	                    
	                    System.out.print("Nuevos horarios de atención de la sede: ");
	                    String nuevosHorarios = scanner.nextLine();
	                    
	                   Sede.cambiarInformacionSedes(nombreSedeCambio, nuevoNombre, nuevaUbicacion, nuevosHorarios);
	                   System.out.println("Información de la sede cambiada con éxito.");
	                    break;
	                case 3:
	                    menuSedesActivo = false;
	                    break;
	                default:
	                    System.out.println("Opción no válida.");
	            }
	        }
	    }
	    
	    private static void gestionarVehiculos(Scanner scanner) {
	    boolean menuVehiculosActivo = true;
	
	    while (menuVehiculosActivo) {
	        System.out.println("\nMenú de Gestión de Vehículos:");
	        System.out.println("1. Ver vehículos de sedes");
	        System.out.println("2. Asignar vehículos a sedes");
	        System.out.println("3. Agregar vehículos");
	        System.out.println("4. Eliminar vehículos");
	        System.out.println("5. Volver al menú principal");
	        System.out.print("Elija una opción: ");
	
	        int opcion = scanner.nextInt();
	        scanner.nextLine(); // Consumir el salto de línea pendiente
	
	        switch (opcion) {
	            case 1:
	                System.out.print("Ingrese el nombre de la sede: ");
	                String nombreSedeConsultaVehiculos = scanner.nextLine();
	                System.out.print(Vehiculo.verVehiculosSede(nombreSedeConsultaVehiculos));
	                break;
	            case 2:
	                System.out.print("Ingrese la placa del vehículo a asignar: ");
	                String placaVehiculoAsignar = scanner.nextLine();
	                System.out.print("Ingrese la sede a la que desea asignar el vehículo: ");
	                String nuevaSedeAsignar = scanner.nextLine();
	                Vehiculo.asignarVehiculoASede(placaVehiculoAsignar, nuevaSedeAsignar);
	                System.out.println("Vehículo asignado a sede con éxito.");
	                break;
	            case 3:
	            	System.out.println("Agregar nuevo vehículo:");
	
	                System.out.print("Placa: ");
	                String placa = scanner.nextLine();
	
	                System.out.print("Marca: ");
	                String marca = scanner.nextLine();
	
	                System.out.print("Modelo: ");
	                String modelo = scanner.nextLine();
	
	                System.out.print("Color: ");
	                String color = scanner.nextLine();
	
	                System.out.print("Tipo de Transmisión: ");
	                String tipoTransmision = scanner.nextLine();
	
	                System.out.print("Categoría: ");
	                String categoria = scanner.nextLine();
	
	                System.out.print("Estado: ");
	                String estado = scanner.nextLine();
	
	                System.out.print("Sede: ");
	                String sede = scanner.nextLine();
	
	                // Crear un nuevo objeto Vehiculo y agregarlo a la lista
	                Vehiculo.agregarVehiculo(placa, marca, modelo, color, tipoTransmision, categoria, estado, sede);
	                
	                break;
	            case 4:
	                System.out.print("Ingrese la placa del vehículo a eliminar: ");
	                String placaVehiculoEliminar = scanner.nextLine();
	                Vehiculo.eliminarVehiculo(placaVehiculoEliminar);
	                System.out.println("Vehículo eliminado con éxito.");
	                break;
	            case 5:
	                menuVehiculosActivo = false;
	                break;
	            default:
	                System.out.println("Opción no válida.");
	        }
	    }
	}
	
	    private static void menuGestionEmpleadosg(Scanner scanner) {
		   
		    while (menuActivo) {
		        System.out.println("\nMenú de Gestión de Empleados:");
		        System.out.println("1. Ver empleados existentes");
		        System.out.println("2. Modificar un usuario existente");
		        System.out.println("3. Agregar un nuevo empleado");
		        System.out.println("4. Eliminar un empleado de la sede");
		        System.out.println("5. Volver al menú anterior");
		        System.out.print("Elija una opción: ");
		
		        // Verificar si hay un siguiente entero antes de intentar leer
		        if (scanner.hasNextInt()) {
		            int opcion = scanner.nextInt();
		            scanner.nextLine(); // Consumir el salto de línea pendiente
		
		            switch (opcion) {
		                case 1:
		                	System.out.print("Ingrese el nombre de la sede para ver los empleados: ");
		                	String sedeNombre = scanner.nextLine();
		                    System.out.println("Empleados de la Sede:");
		                    System.out.println(Empleado.mostrarEmpleadossede(sedeNombre));
		                    break;
		                case 2:
		                    System.out.print("Ingrese el correo del usuario a modificar: ");
		                    String correoUsuario = scanner.nextLine();
		                    Scanner scanner1 = new Scanner(System.in);
	
		                    System.out.println("\nIngrese los nuevos datos:");
	
		                    System.out.print("Nuevo nombre: ");
		                    String nuevoNombre = scanner1.nextLine();
	
		                    System.out.print("Nueva contraseña: ");
		                    String nuevaContraseña = scanner1.nextLine();
	
		                    System.out.print("Nuevo rol: ");
		                    String nuevoRol = scanner1.nextLine();
	
		                    System.out.print("Nuevo teléfono: ");
		                    String nuevoTelefono = scanner1.nextLine();
	
		                    System.out.print("Nueva fecha de nacimiento: ");
		                    String nuevaFechaNacimiento = scanner1.nextLine();
	
		                    System.out.print("Nueva nacionalidad: ");
		                    String nuevaNacionalidad = scanner1.nextLine();
	
		                    System.out.print("Nueva sede: ");
		                    String nuevaSede = scanner1.nextLine();
	
		                    // Modificar el empleado con los nuevos datos
		                    Empleado.modificarEmpleadoExistente(correoUsuario, nuevoNombre, nuevaContraseña, nuevoRol,
		                            nuevoTelefono, nuevaFechaNacimiento, nuevaNacionalidad, nuevaSede);
	
		                    System.out.println("Usuario modificado con éxito.");
		                    break;
		                case 3:
		                	Scanner scanner11 = new Scanner(System.in);
		                	System.out.print("Nombre del nuevo empleado: ");
		        	        String nombreEmpleado = scanner11.nextLine();
		        	        System.out.print("Correo del nuevo empleado: ");
		        	        String correoEmpleado = scanner11.nextLine();
		        	        System.out.print("Contraseña del nuevo empleado: ");
		        	        String contraseñaEmpleado = scanner11.nextLine();
		        	        System.out.print("Rol del nuevo empleado: ");
		        	        String rolEmpleado = scanner11.nextLine();
		        	        System.out.print("Teléfono del nuevo empleado: ");
		        	        String telefonoEmpleado = scanner11.nextLine();
		        	        System.out.print("Numero de documento de identidad: ");
		        	        String id = scanner11.nextLine();
		        	        System.out.print("Fecha de nacimiento del nuevo empleado: ");
		        	        String fechaNacimientoEmpleado = scanner11.nextLine();
		        	        System.out.print("Nacionalidad del nuevo empleado: ");
		        	        String nacionalidadEmpleado = scanner11.nextLine();
		        	        System.out.print("Sede del nuevo empleado: ");
		        	        String sedeEmpleado = scanner11.nextLine();
		        	
		        	        // Llamar al método para agregar el nuevo empleado
		        	        Empleado.agregarEmpleado(correoEmpleado, contraseñaEmpleado, rolEmpleado, nombreEmpleado,
		        	                telefonoEmpleado, fechaNacimientoEmpleado, nacionalidadEmpleado, id, sedeEmpleado);
		        	
		        	        System.out.print("Empleado agregado con exito. ");
		                    break;
		                case 4:
		                    System.out.print("Ingrese el correo del usuario a eliminar: ");
		                    String correo = scanner.nextLine();
		                    Empleado.eliminarEmpleados(correo);
		                    System.out.print("Empleado eliminado con exito. ");
		                    break;
		                case 5:
		                    menuActivo = false;
		                    break;
		                default:
		                    System.out.println("Opción no válida.");
		            }
		        } else {
		            System.out.println("Entrada no válida. Debe ingresar un número.");
		            
		        }
		    }
		}
	    
	    private static void menuGestionSegurosg(Scanner scanner) {
	 	   
		    while (menuActivo) {
		    	System.out.println("\nMenú de Gestión de Seguros:");
	            System.out.println("1. Ver Seguros");
	            System.out.println("2. Agregar Nuevo Seguro");
	            System.out.println("3. Modificar Información de Seguro");
	            System.out.println("4. Eliminar Seguro");
	            System.out.println("5. Volver al Menú Principal");
	            System.out.print("Elija una opción: ");
		
		        // Verificar si hay un siguiente entero antes de intentar leer
		        
		            int opcion = scanner.nextInt();
		            scanner.nextLine(); // Consumir el salto de línea pendiente
		
		            switch (opcion) {
		                case 1:
		                	System.out.println(Seguro.obtenerInformacionSeguros());;
		                    break;
		                case 2:
		                	System.out.println("Agregar nuevo seguro:");
		                    System.out.print("Nombre: ");
		                    String nombre = scanner.nextLine();
		                    System.out.print("Descripción: ");
		                    String descripcion = scanner.nextLine();
		                    System.out.print("Precio por día: ");
		                    double precio = scanner.nextDouble();
	
		                    // Crear un nuevo objeto Seguro y agregarlo a la lista
		                    Seguro.agregarSeguro(nombre, descripcion, precio);
		                    
		                    break;
		                case 3:
		                	System.out.print("Ingrese el nombre  seguro a modificar: ");
		                    String nombreSeguroModificar = scanner.nextLine();
		                    
		                    System.out.print("Nuevo Nombre: ");
		                    String nuevoNombre = scanner.nextLine();
		                    
		                    System.out.print("Nueva descripción: ");
		                    String nuevaDescripcion = scanner.nextLine();
		                    
		                    System.out.print("Nuevo precio: ");
		                    double nuevoPrecio = scanner.nextDouble();
		                    
		                    Seguro.modificarInformacionSeguro(nombreSeguroModificar, nuevoNombre, nuevaDescripcion, nuevoPrecio);
		                    System.out.println("Información del seguro modificada con éxito.");
		                    break;
		                    
		                case 4:
		                	System.out.print("Ingrese el nombre del seguro a eliminar: ");
		                    String nombreSeguroEliminar = scanner.nextLine();
		                	Seguro.eliminarSeguro(nombreSeguroEliminar);
		                	System.out.println("Seguro eliminado con éxito.");
		                    break;
		                case 5:
		                    menuActivo = false;
		                    break;
		                default:
		                    System.out.println("Opción no válida.");
		            }
		        } 
		            
		        }
	
	    private static void gestionarCategorias(Scanner scanner) {
	    boolean menuCategoriasActivo = true;
	
	    while (menuCategoriasActivo) {
	        System.out.println("\nMenú de Gestión de Categorías:");
	        System.out.println("1. Ver Categorías");
	        System.out.println("2. Agregar Nueva Categoría");
	        System.out.println("3. Modificar Información de Categoría");
	        System.out.println("4. Eliminar Categoría");
	        System.out.println("5. Volver al Menú Principal");
	        System.out.print("Elija una opción: ");
	
	        int opcion = scanner.nextInt();
	        scanner.nextLine(); // Consumir el salto de línea pendiente
	
	        switch (opcion) {
	            case 1:
	                System.out.println(Categoria_vehiculo.obtenerInformacionCategorias());
	                break;
	            case 2:
	                System.out.print("Nombre: ");
	                String nombreCategoria = scanner.nextLine();
	                System.out.print("Descripción: ");
	                String descripcion = scanner.nextLine();
	                System.out.print("Tarifa diaria: ");
	                double tarifaDiaria = scanner.nextDouble();
	                Categoria_vehiculo.agregarCategoria(nombreCategoria, descripcion, tarifaDiaria);
	                System.out.println("Categoría de vehículo agregada con éxito.");
	                break;
	            case 3:
	                System.out.print("Ingrese el nombre de la categoría de vehículo a modificar: ");
	                String nombreCategoriaModificar = scanner.nextLine();
	                System.out.print("Nuevo Nombre: ");
	                String nuevoNombre = scanner.nextLine();
	                System.out.print("Nueva descripción: ");
	                String nuevaDescripcion = scanner.nextLine();
	                System.out.print("Nueva tarifa diaria: ");
	                double nuevaTarifaDiaria = scanner.nextDouble();
	                Categoria_vehiculo.modificarInformacionCategoria(nombreCategoriaModificar, nuevoNombre, nuevaDescripcion, nuevaTarifaDiaria);
	                System.out.println("Información de la categoría de vehículo modificada con éxito.");
	                break;
	            case 4:
	                System.out.print("Ingrese el nombre de la categoría de vehículo a eliminar: ");
	                String nombreCategoriaEliminar = scanner.nextLine();
	                Categoria_vehiculo.eliminarCategoria(nombreCategoriaEliminar);
	                System.out.println("Categoría de vehículo eliminada con éxito.");
	                break;
	            case 5:
	                menuCategoriasActivo = false;
	                break;
	            default:
	                System.out.println("Opción no válida.");
	        }
	    }
	}
	
	    
    /************************************************
     * Menú y métodos para Empleados
     * Descripción:
     * Este menú está diseñado para los empleados que trabajan en las sedes y están encargados de la atención
     * al cliente, la gestión de vehículos y el seguimiento de reservas y alquileres.
     * 
     * Funcionalidades:
     * 1. Atender a los clientes que llegan a la sede para recoger y devolver vehículos.
     *    - Permite a los empleados realizar operaciones relacionadas con el alquiler y devolución de vehículos.
     * 2. Actualizar el estado de los vehículos (limpieza, mantenimiento, disponibilidad).
     *    - Proporciona herramientas para que los empleados gestionen y actualicen el estado de los vehículos disponibles.
     * 3. Registrar conductores adicionales al momento de alquilar un vehículo.
     *    - Permite a los empleados agregar información sobre conductores adicionales durante el proceso de alquiler.
     * 4. Gestionar alquileres y reservas en la sede.
     *    - Ofrece a los empleados la capacidad de ver, modificar y cancelar reservas, así como crear nuevas reservas.
     * 
     * Nota:
     * Cada funcionalidad está respaldada por métodos específicos implementados en la clase Empleado.
     ************************************************/

    
    private static void menuEmpleado(Scanner scanner) {
        boolean menuActivo = true;

        while (menuActivo) {
            System.out.println("\nMenú del Empleado:");
            System.out.println("1. Gestionar Reservas");
            System.out.println("2. Gestionar Usuarios");
            System.out.println("3. Gestionar Automóviles");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
                case 1:
                    menuGestionarReservas(scanner);
                    break;
                case 2:
                    menuGestionarUsuarios(scanner);
                    break;
                case 3:
                    menuGestionarAutomoviles(scanner);
                    break;
                
                case 4:
                    menuActivo = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    
    private static void menuGestionarReservas(Scanner scanner) {
        boolean menuActivo = true;

        while (menuActivo) {
            System.out.println("\nMenú de Gestión de Reservas:");
            System.out.println("1. Mostrar Reservas por Correo");
            System.out.println("2. Cancelar Reserva");
            System.out.println("3. Crear Nueva Reserva");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
            case 1:
                System.out.print("Ingrese el correo del cliente: ");
                String correoCliente = scanner.nextLine();
                System.out.print(Empresa.obtenerReservasPorCorreo(correoCliente));
                break;
            
            case 2:
                System.out.print("Ingrese el correo del cliente: ");
                String correoCancelar = scanner.nextLine();
                System.out.print("Ingrese la placa del auto reservado: ");
                String Placareserva = scanner.nextLine();
                Empresa.cancelarReserva(correoCancelar, Placareserva);
                break;
            case 3:
                System.out.print("Ingrese el correo del cliente: ");
                correoUsuario= scanner.nextLine();
                System.out.print("Ingrese la fecha de inicio de la reserva (dd/mm/yyyy): ");
                String fechaInicioStr = scanner.next();
                LocalDate fechaInicio = Empresa.parseFecha(fechaInicioStr);

                System.out.print("Ingrese la fecha de finalización de la reserva (dd/mm/yyyy): ");
                String fechaFinStr = scanner.next();
                LocalDate fechaFin = Empresa.parseFecha(fechaFinStr);

                int duracionEnDias = Empresa.calcularDuracionEnDias(fechaInicio, fechaFin);

                // Imprimir la duración en días
                System.out.println("La reserva dura " + duracionEnDias + " días.");

                System.out.println(Categoria_vehiculo.obtenerInformacionCategorias());

                System.out.print("\nPor favor, Escriba el nombre de la categoría deseada: ");
                String nombreCategoria = scanner.next();
                Categoria_vehiculo categoria = Categoria_vehiculo.obtenerInformacionCategoriaPorNombre(nombreCategoria);

                System.out.println("Ha seleccionado la Categoría " + categoria.getNombre());
                System.out.println("Descripción: " + categoria.getDescripcion());
                System.out.println("Tarifa Diaria: $" + categoria.getTarifaDiaria());

                Double tarifa = Empresa.calcularTarifaAlquiler(categoria, null, duracionEnDias);
                double montoCobroInicial = tarifa * 0.30;
                System.out.println("El monto del cobro inicial 30%: $" + montoCobroInicial);

                double montoRestante = tarifa - montoCobroInicial;
                System.out.println("Monto a pagar al recoger el vehículo (70% restante): $" + montoRestante);
                // Informa al cliente que solo se está cobrando el 30% por adelantado
                System.out.println("Tenga en cuenta que solo se está cobrando el 30% del cobro inicial ahora.");

                // Preguntar si el cliente desea un seguro
                System.out.print("¿Desea agregar un seguro? (Si/No): ");
                String respuestaSeguro = scanner.next();

                String nombreSeguro = "";
                if (respuestaSeguro.equalsIgnoreCase("Si")) {
                    // Muestra los tipos de seguros disponibles
                    System.out.println(Seguro.obtenerInformacionSeguros());

                    System.out.print("\nPor favor, Escriba el nombre del seguro deseado: ");
                    nombreSeguro = scanner.next();
                    Seguro seguro = Seguro.obtenerInformacionSeguroPorNombre(nombreSeguro);

                    System.out.println("Ha seleccionado El seguro " + seguro.getNombre());
                    System.out.println("Descripción: " + seguro.getDescripcion());
                    System.out.println("Tarifa Diaria: $" + seguro.getCostoAdicionalPorDia());

                    tarifa = Empresa.calcularTarifaAlquiler(categoria, seguro, duracionEnDias);
                    montoCobroInicial = tarifa * 0.30;
                    System.out.printf("\nEl monto del 30 porciento de la tarifa del vehiculo más el seguro es: $" + montoCobroInicial);
                }

                // Sede
                System.out.print("\nIngrese la sede de recogida del vehículo: ");
                String sedeR = scanner.next();

                String placa = Vehiculo.obtenerPlacaVehiculoAlAzar(categoria.getNombre(), sedeR);
                Empresa.crearNuevaReserva(correoUsuario, placa, fechaInicioStr, fechaFinStr, tarifa, nombreSeguro, sedeR, sedeR, "Alquilado");
                System.out.print("Reserva realizada con éxito (: ");
            
                break;
                case 5:
                    menuActivo = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuGestionarUsuarios(Scanner scanner) {
        boolean menuActivo = true;

        while (menuActivo) {
            System.out.println("\nMenú de Gestión de Usuarios:");
            System.out.println("1. Crear Nuevo Usuario");
            System.out.println("2. Ver Perfil de Usuario");
            System.out.println("3. Modificar Información de Usuario");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
                case 1:
                	System.out.println("Crear nuevo usuario:");

                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();

                    System.out.print("Contraseña: ");
                    String password = scanner.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Fecha de nacimiento: ");
                    String fechaNacimiento = scanner.nextLine();

                    System.out.print("Nacionalidad: ");
                    String nacionalidad = scanner.nextLine();

                    System.out.print("ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Número de licencia: ");
                    String numeroLicencia = scanner.nextLine();

                    System.out.print("País de expedición de la licencia: ");
                    String paisExpedicionLicencia = scanner.nextLine();

                    System.out.print("Fecha de vencimiento de la licencia: ");
                    String fechaVencimientoLicencia = scanner.nextLine();

                    System.out.print("Imagen de la licencia: ");
                    String imagenLicencia = scanner.nextLine();

                    System.out.print("Nombre titular de la tarjeta: ");
                    String nombreTitularTarjeta = scanner.nextLine();

                    System.out.print("Número de la tarjeta: ");
                    String numeroTarjeta = scanner.nextLine();

                    System.out.print("Fecha de vencimiento de la tarjeta: ");
                    String fechaVencimientoTarjeta = scanner.nextLine();

                    System.out.print("Código de seguridad de la tarjeta: ");
                    String codigoSeguridadTarjeta = scanner.nextLine();

                    
                    Usuario.crearNuevoUsuario(correo, password, nombre, telefono, fechaNacimiento, nacionalidad, id,
                            numeroLicencia, paisExpedicionLicencia, fechaVencimientoLicencia, imagenLicencia,
                            nombreTitularTarjeta, numeroTarjeta, fechaVencimientoTarjeta, codigoSeguridadTarjeta);

                    System.out.println("Usuario creado con éxito.");
                    
                    break;
                case 2:
                	System.out.print("Ingrese el correo del usuario cuyo perfil desea ver: ");
                    String correoUsuarioPerfil = scanner.next();
                    Usuario.verPerfilUsuario(correoUsuarioPerfil);
                    break;
                case 3:
                	System.out.print("Ingrese el correo del usuario que desea modificar: ");
                    String correoUsuario = scanner.next();

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.next();
                    
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTelefono = scanner.next();

                    System.out.print("Nueva fecha de nacimiento: ");
                    String nuevaFechaNacimiento = scanner.next();

                    System.out.print("Nueva nacionalidad: ");
                    String nuevaNacionalidad = scanner.next();

                    Usuario.modificarInformacionUsuario(correoUsuario, nuevoNombre, nuevoTelefono, nuevaFechaNacimiento, nuevaNacionalidad);
                    System.out.println("Información del usuario modificada con éxito.");
                    break;
                case 4:
                    menuActivo = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuGestionarAutomoviles(Scanner scanner) {
        boolean menuActivo = true;

        while (menuActivo) {
            System.out.println("\nMenú de Gestión de Automóviles:");
            System.out.println("1. Mostrar Vehículos Disponibles");
            System.out.println("2. Verificar Disponibilidad de un Vehículo");
            System.out.println("3. Ver Información de Categorías de Autos");
            System.out.println("4. Ver Información de Seguros de Autos");
            System.out.println("5. Calcular Tarifa de Alquiler");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
                case 1:
                	System.out.print(Vehiculo.verVehiculosSede(Sedeu));
                    break;
                case 2:
                	System.out.print("Ingrese la placa del vehículo: ");
                    String placa = scanner.nextLine();
                    if (Vehiculo.verificarDisponibilidadVehiculo(placa)) {
                        System.out.println("El vehículo está disponible.");
                    } else {
                        System.out.println("El vehículo no está disponible.");
                    }
                    break;
                case 3:
                	System.out.print(Categoria_vehiculo.obtenerInformacionCategorias());
                    break;
                case 4:
                	System.out.print(Seguro.obtenerInformacionSeguros());
                    break;
                case 5:
                	System.out.print(Categoria_vehiculo.obtenerInformacionCategorias());
                	System.out.print("Ingrese el nombre de la categoria del alquiler: ");
                    String categoria = scanner.next();
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    Categoria_vehiculo provisionalc = Categoria_vehiculo.obtenerInformacionCategoriaPorNombre(categoria);
                    
                    System.out.print(Seguro.obtenerInformacionSeguros());
                	System.out.print("Ingrese el nombre del seguro (Deje en blanco si no selecciona ninguno): ");
                    Seguro seguro = Seguro.obtenerInformacionSeguroPorNombre(scanner.next());
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    
                	System.out.print("Ingrese el número de días de alquiler: ");
                    int numeroDias = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                	
                	double tarifaTotal = Empresa.calcularTarifaAlquiler(provisionalc, seguro, numeroDias);
                    System.out.println("Tarifa total de alquiler: " + tarifaTotal);
                    break;
                case 6:
                    menuActivo = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

   

     
    /************************************************
     * Menú y métodos para Clientes
     * Descripción:
     * Este menú está diseñado para los clientes que desean alquilar vehículos, realizar reservas y realizar operaciones relacionadas con su cuenta.
     * 
     * Funcionalidades:
     * 1. Visualizar vehículos disponibles.
     *    - Permite a los clientes ver la lista de vehículos disponibles en la sede.
     * 2. Realizar una reserva.
     *    - Permite a los clientes reservar un vehículo para una fecha específica.
     * 3. Ver y gestionar reservas activas.
     *    - Muestra a los clientes sus reservas activas y les brinda opciones para modificar o cancelar.
     * 4. Consultar historial de alquiler.
     *    - Permite a los clientes ver su historial de alquileres anteriores.
     * 5. Cancelar reserva.
     *    - Permite a los clientes cancelar una reserva existente.
     * 
     * Nota:
     * Cada funcionalidad está respaldada por métodos específicos implementados en la clase Cliente.
     ************************************************/

    private static void MenuCliente(Scanner scanner) {
    while (menuActivo) {
        System.out.println("\nMenú Cliente:");
        System.out.println("1. Ver Catálogo de Vehículos");
        System.out.println("2. Realizar Reserva");
        System.out.println("3. Ver Mis Reservas");
        System.out.println("4. Cancelar Reserva");
        System.out.println("5. Ver Información del Usuario");
        System.out.println("6. Modificar Información del Usuario");
        System.out.println("7. Salir");
        System.out.print("Elija una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        switch (opcion) {
            case 1:
                // Lógica para ver el catálogo de vehículos
                System.out.println("Catálogo de Vehículos:");
                System.out.println(Categoria_vehiculo.obtenerInformacionCategorias());
                break;
            case 2:
            	System.out.print("Ingrese la fecha de inicio de la reserva (dd/mm/yyyy): ");
                String fechaInicioStr = scanner.next();
                LocalDate fechaInicio = Empresa.parseFecha(fechaInicioStr);

                System.out.print("Ingrese la fecha de finalización de la reserva (dd/mm/yyyy): ");
                String fechaFinStr = scanner.next();
                LocalDate fechaFin = Empresa.parseFecha(fechaFinStr);

                int duracionEnDias = Empresa.calcularDuracionEnDias(fechaInicio, fechaFin);

                // Imprimir la duración en días
                System.out.println("La reserva dura " + duracionEnDias + " días.");

                System.out.println(Categoria_vehiculo.obtenerInformacionCategorias());

                System.out.print("\nPor favor, Escriba el nombre de la categoría deseada: ");
                String nombreCategoria = scanner.next();
                Categoria_vehiculo categoria = Categoria_vehiculo.obtenerInformacionCategoriaPorNombre(nombreCategoria);

                System.out.println("Ha seleccionado la Categoría " + categoria.getNombre());
                System.out.println("Descripción: " + categoria.getDescripcion());
                System.out.println("Tarifa Diaria: $" + categoria.getTarifaDiaria());

                Double tarifa = Empresa.calcularTarifaAlquiler(categoria, null, duracionEnDias);
                double montoCobroInicial = tarifa * 0.30;
                System.out.println("El monto del cobro inicial 30%: $" + montoCobroInicial);

                double montoRestante = tarifa - montoCobroInicial;
                System.out.println("Monto a pagar al recoger el vehículo (70% restante): $" + montoRestante);
                // Informa al cliente que solo se está cobrando el 30% por adelantado
                System.out.println("Tenga en cuenta que solo se está cobrando el 30% del cobro inicial ahora.");

                // Preguntar si el cliente desea un seguro
                System.out.print("¿Desea agregar un seguro? (Si/No): ");
                String respuestaSeguro = scanner.next();

                String nombreSeguro = "";
                if (respuestaSeguro.equalsIgnoreCase("Si")) {
                    // Muestra los tipos de seguros disponibles
                    System.out.println(Seguro.obtenerInformacionSeguros());

                    System.out.print("\nPor favor, Escriba el nombre del seguro deseado: ");
                    nombreSeguro = scanner.next();
                    Seguro seguro = Seguro.obtenerInformacionSeguroPorNombre(nombreSeguro);

                    System.out.println("Ha seleccionado El seguro " + seguro.getNombre());
                    System.out.println("Descripción: " + seguro.getDescripcion());
                    System.out.println("Tarifa Diaria: $" + seguro.getCostoAdicionalPorDia());

                    tarifa = Empresa.calcularTarifaAlquiler(categoria, seguro, duracionEnDias);
                    montoCobroInicial = tarifa * 0.30;
                    System.out.printf("\nEl monto del 30 porciento de la tarifa del vehiculo más el seguro es: $" + montoCobroInicial);
                }

                // Sede
                System.out.print("\nIngrese la sede de recogida del vehículo: ");
                String sedeR = scanner.next();

                
                
                String placa = Vehiculo.obtenerPlacaVehiculoAlAzar(categoria.getNombre(), sedeR);
                Empresa.crearNuevaReserva(usuarioSesion.getCorreo(), placa, fechaInicioStr, fechaFinStr, tarifa, nombreSeguro, sedeR, sedeR, "Alquilado");
                System.out.print("Reserva realizada con éxito (: ");
            
            
                break;
            case 3:
                // Lógica para ver las reservas del cliente
                System.out.println("Mis Reservas:");
                System.out.println(Empresa.obtenerReservasPorCorreo(usuarioSesion.getCorreo()));
                break;
            case 4:
                System.out.println("Cancelar Reserva:");
                System.out.print("Ingrese la placa del vehículo a cancelar: ");
                String placaCancelar = scanner.nextLine();
                Empresa.cancelarReserva(usuarioSesion.getCorreo(), placaCancelar);
                System.out.print("Reserva cancelada con exito.");
                break;
            case 5:
                // Ver información del usuario
                System.out.println("Información del Usuario:");
                System.out.println(Usuario.verPerfilUsuario(usuarioSesion.getCorreo()));
                break;
            case 6:
                // Modificar información del usuario
            	;
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = scanner.next();
                
                System.out.print("Nuevo teléfono: ");
                String nuevoTelefono = scanner.next();

                System.out.print("Nueva fecha de nacimiento: ");
                String nuevaFechaNacimiento = scanner.next();

                System.out.print("Nueva nacionalidad: ");
                String nuevaNacionalidad = scanner.next();

                Usuario.modificarInformacionUsuario(usuarioSesion.getCorreo(), nuevoNombre, nuevoTelefono, nuevaFechaNacimiento, nuevaNacionalidad);
                System.out.println("Información del usuario modificada con éxito.");
                
                break;
            case 7:
                menuActivo = false;
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida. Por favor, elija una opción válida.");
        }
    }

    scanner.close();
}

    


    public static void main(String[] args) throws FileNotFoundException {
        try {
        	 new Sistema();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


	public static Usuario getUsuarioSesion() {
		return usuarioSesion;
	}



}
