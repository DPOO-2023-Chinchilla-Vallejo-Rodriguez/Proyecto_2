package Reservas_modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import reservas_procesamiento.Reservas;

public class Empleado {
    private String login;
    private String password;
    private String rol;
    private String nombre;
    private String sede;
    private String Telefono;
    private String FechaNacimiento;
    private String Nacionalidad;
    private String id;

    // Contructor empleados 
    public Empleado(String login, String password, String rol, String nombre, String Telefono, String FechaNacimiento, String Nacionalidad, String id, String sede) {
        this.setLogin(login);
        this.setPassword(password);
        this.setRol(rol);
        this.setNombre(nombre);
        this.setSede(sede);
    }

    public static  Empleado obtenerEmpleadoPorCorreo(String correo) {
        List<Empleado> empleados = Reservas.getEmpleados();
        for (Empleado empleado : empleados) {
            if (empleado.getLogin().equals(correo)) {
                return empleado;
            }
        }
        return null;
    }
    
    public static List<String> mostrarEmpleadossede(String sedeNombre) {
        List<Empleado> empleados = Reservas.getEmpleados();
        List<String> infoEmpleados = new ArrayList<>();

        for (Empleado empleado : empleados) {
            if (empleado.getSede().equalsIgnoreCase(sedeNombre)) {
                String info = empleado.getNombre() + " - " + empleado.getRol();
                infoEmpleados.add(info);
            }
        }

        return infoEmpleados;
    }

    public static void agregarEmpleado( String correoEmpleado, String contraseñaEmpleado,
            String rolEmpleado, String nombreEmpleado, String telefonoEmpleado, String fechaNacimientoEmpleado,
            String nacionalidadEmpleado, String id, String sedeEmpleado) {
        
    	List<Empleado> empleados = Reservas.getEmpleados();
        // Crear y agregar el nuevo empleado a la lista
        Empleado nuevoEmpleado = new Empleado(correoEmpleado, contraseñaEmpleado, rolEmpleado, nombreEmpleado,
                telefonoEmpleado, fechaNacimientoEmpleado, nacionalidadEmpleado, id, sedeEmpleado);
        empleados.add(nuevoEmpleado);

        // Guardar los cambios en el archivo
        guardarEmpleadosEnArchivo(correoEmpleado, contraseñaEmpleado, rolEmpleado, nombreEmpleado,
                telefonoEmpleado, fechaNacimientoEmpleado, nacionalidadEmpleado, id, sedeEmpleado);

    }

    public static void modificarEmpleadoExistente(String correo, String nuevoNombre, String nuevaContraseña,
            String nuevoRol, String nuevoTelefono, String nuevaFechaNacimiento, String nuevaNacionalidad,
            String nuevaSede) {
        
        List<Empleado> empleados = Reservas.getEmpleados();

        for (Empleado empleado : empleados) {
            if (empleado.getLogin().equals(correo)) {
               
            	String originalLogin = empleado.getLogin();
                String originalPassword = empleado.getPassword();
                String originalRol = empleado.getRol();
                String originalNombre = empleado.getNombre();
                String originalTelefono = empleado.getTelefono();
                String originalFechaNacimiento = empleado.getFechaNacimiento();
                String originalNacionalidad = empleado.getNacionalidad();
                String originalId = empleado.getId();
                String originalSede = empleado.getSede();
                // Modificar el empleado con los nuevos datos, solo si no son null
                if (nuevoNombre != null) {
                    empleado.setNombre(nuevoNombre);
                    originalNombre = nuevoNombre;
                }
                if (nuevaContraseña != null) {
                    empleado.setPassword(nuevaContraseña);
                    originalPassword = nuevaContraseña;
                }
                if (nuevoRol != null) {
                    empleado.setRol(nuevoRol);
                    originalRol = nuevoRol;
                }
                if (nuevoTelefono != null) {
                    empleado.setTelefono(nuevoTelefono);
                    originalTelefono = nuevoTelefono;
                }
                if (nuevaFechaNacimiento != null) {
                    empleado.setFechaNacimiento(nuevaFechaNacimiento);
                    originalFechaNacimiento = nuevaFechaNacimiento;
                }
                if (nuevaNacionalidad != null) {
                    empleado.setNacionalidad(nuevaNacionalidad);
                    originalNacionalidad = nuevaNacionalidad;
                }
                if (nuevaSede != null) {
                    empleado.setSede(nuevaSede);
                    originalSede = nuevaSede;
                }
                
                // Eliminar el antiguo empleado
                eliminarEmpleados(correo);

                // Guardar los cambios en el archivo utilizando las constantes actualizadas
                guardarEmpleadosEnArchivo(originalLogin, originalPassword, originalRol, originalNombre,
                        originalTelefono, originalFechaNacimiento, originalNacionalidad, originalId, originalSede);

                break;  // Salir del bucle después de modificar el empleado
            }
        }
    }
    
    
    //Modificar archivo
   public static void guardarEmpleadosEnArchivo(String correoEmpleado, String contraseñaEmpleado, String rolEmpleado, String nombreEmpleado,
        String telefonoEmpleado, String fechaNacimientoEmpleado, String nacionalidadEmpleado, String id, String sedeEmpleado) {
    
    try (PrintWriter writer = new PrintWriter(new FileWriter("./data/usuarios.csv", true))) {

        writer.println(correoEmpleado + "," + contraseñaEmpleado + "," + rolEmpleado + ","
                + nombreEmpleado + "," + telefonoEmpleado + "," + fechaNacimientoEmpleado + ","
                + nacionalidadEmpleado + "," + " " + "," + " " + "," + " " + "," + " " + "," + " " + "," + " " + "," + " " + "," + " " + ","+""+","
                + sedeEmpleado);

    } catch (IOException e) {
        System.err.println("Error al escribir en el archivo de empleados: " + e.getMessage());
    }
}
    
   
   public static void eliminarEmpleados(String correoAEliminar) {
       List<String> lineas = new ArrayList<>();

       try (BufferedReader br = new BufferedReader(new FileReader("./data/usuarios.csv"))) {
           String linea;
           while ((linea = br.readLine()) != null) {
               // Excluir la línea que coincide con el correo a eliminar
               if (!linea.startsWith(correoAEliminar + ",")) {
                   lineas.add(linea);
               }
               
           }
           JOptionPane.showMessageDialog(null, "Empleado eliminado", "Empleado eliminado", JOptionPane.INFORMATION_MESSAGE);

       } catch (IOException e) {
           e.printStackTrace();
       }

       // Sobrescribir el archivo con el contenido actualizado
       try (BufferedWriter bw = new BufferedWriter(new FileWriter("./data/usuarios.csv"))) {
           for (String linea : lineas) {
               bw.write(linea);
               bw.newLine();
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    //Otros metodos
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
}

