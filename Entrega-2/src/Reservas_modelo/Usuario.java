package Reservas_modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import reservas_procesamiento.Reservas;


public class Usuario {
	private String correo;
	private String password;
    private String nombres;
    private String datosContacto;
    private String fechaNacimiento;
    private String nacionalidad;
    private String imagenDocumentoIdentidad;
    private Licencia_conducion licenciaConduccion;
    private Medio_pago medioPago;
    

    public static void crearNuevoUsuario(String correo, String password, String nombre, String telefono,
                                     String fechaNacimiento, String nacionalidad, String id,
                                     String numeroLicencia, String paisExpedicionLicencia,
                                     String fechaVencimientoLicencia, String imagenLicencia,
                                     String nombreTitularTarjeta, String numeroTarjeta,
                                     String fechaVencimientoTarjeta, String codigoSeguridadTarjeta) {
    List<Usuario> usuarios = Reservas.getUsuarios();

    // Crear un nuevo objeto Licencia_conducion y Medio_pago
    Licencia_conducion licencia = new Licencia_conducion(numeroLicencia, paisExpedicionLicencia, fechaVencimientoLicencia, imagenLicencia);
    Medio_pago medioPago = new Medio_pago(nombreTitularTarjeta, numeroTarjeta, fechaVencimientoTarjeta, codigoSeguridadTarjeta);

    // Crear un nuevo objeto Usuario y agregarlo a la lista
    Usuario nuevoUsuario = new Usuario(correo, password, nombre, telefono, fechaNacimiento, nacionalidad, id, licencia, medioPago);
    usuarios.add(nuevoUsuario);

    // Guardar los cambios en el archivo
    guardarUsuariosEnArchivo(usuarios);

    
}

    public static List<String> verPerfilUsuario(String correoUsuario) {
    List<String> perfilUsuario = new ArrayList<>();

    // Obtener la lista de usuarios desde la instancia de Reservas
    List<Usuario> usuarios = Reservas.getUsuarios();

    for (Usuario usuario : usuarios) {
        if (usuario.getCorreo().equals(correoUsuario)) {
            // Agregar la información del usuario a la lista
            perfilUsuario.add("Correo: " + usuario.getCorreo());
            perfilUsuario.add("Nombre: " + usuario.getNombres());
            perfilUsuario.add("Teléfono: " + usuario.getDatosContacto());
            perfilUsuario.add("Fecha de nacimiento: " + usuario.getFechaNacimiento());
            perfilUsuario.add("Nacionalidad: " + usuario.getNacionalidad());
            perfilUsuario.add("Número de licencia: " + usuario.getLicenciaConduccion().getNumero());
            // Agregar otros detalles según la estructura de tu Licencia_conduccion
            perfilUsuario.add("ID: " + usuario.getImagenDocumentoIdentidad());
            // Agregar otros detalles según la estructura de tu Usuario
            return perfilUsuario;
        }
    }

    perfilUsuario.add("No se encontró ningún usuario con el correo especificado.");
    return perfilUsuario;
}

    
    public static void modificarInformacionUsuario(String correoUsuario, String nuevoNombre, String nuevoTelefono,
        String nuevaFechaNacimiento, String nuevaNacionalidad) {
    // Obtener la lista de usuarios desde la instancia de Reservas
    List<Usuario> usuarios = Reservas.getUsuarios();

    for (Usuario usuario : usuarios) {
        if (usuario.getCorreo().equals(correoUsuario)) {
            // Actualizar la información del usuario
            usuario.setNombres(nuevoNombre);
            usuario.setDatosContacto(nuevoTelefono);
            usuario.setFechaNacimiento(nuevaFechaNacimiento);
            usuario.setNacionalidad(nuevaNacionalidad);

            // Guardar los cambios en el archivo
            guardarUsuariosEnArchivo(usuarios);

            
            return;
        }
    }

    System.err.println("No se encontró ningún usuario con el correo especificado.");
}

    public static void guardarUsuariosEnArchivo(List<Usuario> usuarios) {
    	List<Empleado> empleados = Reservas.getEmpleados();
    try (PrintWriter writer = new PrintWriter(new FileWriter("./data/usuarios.csv"))) {
        writer.println("Correo,Password,Rol,Nombre,Telefono,FechaNacimiento,Nacionalidad,ID,NumeroLicencia,PaisExpedicionLicencia,FechaVencimientoLicencia,ImagenLicencia,NombreTitularTarjeta,NumeroTarjeta,FechaVencimientoTarjeta,CodigoSeguridadTarjeta,Sede");

        // Guardar información de clientes
        for (Usuario usuario : usuarios) {
            Licencia_conducion licencia = usuario.getLicenciaConduccion();
            Medio_pago tarjeta = usuario.getMedioPago();

            writer.println(usuario.getCorreo() + ","
                    + usuario.getpassword() + ","
                    + "cliente" + ","
                    + usuario.getNombres() + ","
                    + usuario.getDatosContacto() + ","
                    + usuario.getFechaNacimiento() + ","
                    + usuario.getNacionalidad() + ","
                    + usuario.getImagenDocumentoIdentidad() + ","
                    + licencia.getNumero() + ","
                    + licencia.getPaisExpedicion() + ","
                    + licencia.getFechaVencimiento() + ","
                    + licencia.getImagenLicencia() + ","
                    + tarjeta.getNombreTitular() + ","
                    + tarjeta.getNumeroTarjeta() + ","
                    + tarjeta.getFechaVencimiento() + ","
                    + tarjeta.getCodigoSeguridad() + ","
                    + "null");  // Sede del cliente, ajusta según tu estructura

            // Agregar más campos según sea necesario
        }

        // Guardar información de empleados
        for (Empleado empleado : empleados) {
            // Ajusta estos campos según tu estructura de datos para empleados
            writer.println(empleado.getLogin() + ","
                    + empleado.getPassword() + ","
                    + empleado.getRol() + ","
                    + empleado.getNombre() + ","
                    + empleado.getTelefono() + ","
                    + empleado.getFechaNacimiento() + ","
                    + empleado.getNacionalidad() + ","
                    + empleado.getId() + ","
                    + "" + ","
                    + "" + ","
                    + "" + ","
                    + "" + ","
                    + "" + ","
                    + "" + ","
                    + "" + ","
                    + "" + ","
                    + empleado.getSede());  // Sede del empleado, ajusta según tu estructura

            // Agregar más campos según sea necesario
        }
    } catch (IOException e) {
        System.err.println("Error al escribir en el archivo de usuarios: " + e.getMessage());
    }
}

    
  //Constructor Clientes
    public Usuario(String correo, String password, String nombres, String datosContacto, String fechaNacimiento, String nacionalidad,
    		String imagenDocumentoIdentidad, Licencia_conducion licenciaConduccion, Medio_pago medioPago) {
        this.nombres = nombres;
        this.correo=correo;
        this.password=password;
        this.datosContacto = datosContacto;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.imagenDocumentoIdentidad = imagenDocumentoIdentidad;
        this.licenciaConduccion =licenciaConduccion;
        this.medioPago=medioPago;
        
    }


   
    
    // Método para calcular la cantidad de días entre dos fechas
    public static int calcularDiasReserva(String fechaInicio, String fechaFin) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateInicio = dateFormat.parse(fechaInicio);
            Date dateFin = dateFormat.parse(fechaFin);

            long tiempoInicio = dateInicio.getTime();
            long tiempoFin = dateFin.getTime();
            long diferencia = tiempoFin - tiempoInicio;

            // Calcular la cantidad de milisegundos en un día
            long milisegundosPorDia = 1000 * 60 * 60 * 24;

            // Calcular la cantidad de días
            int diasReserva = (int) (diferencia / milisegundosPorDia);

            // Agregar 1 día porque el primer día también cuenta
            return diasReserva + 1;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0; // En caso de error, devuelve 0 días
        }
    }
    
    // Metodos para obtener información
    public String getNombres() {
        return nombres;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public String getpassword() {
        return password;
    }
    
    public Licencia_conducion getLicenciaConduccion() {
        return licenciaConduccion;
    }

    public Medio_pago getMedioPago() {
        return medioPago;
    }
    
    public String getDatosContacto() {
        return datosContacto;
    }
    
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public String getNacionalidad() {
        return nacionalidad;
    }
    
    public String getImagenDocumentoIdentidad() {
        return imagenDocumentoIdentidad;
    }
    
    //metodos para poner información
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    public void setLicenciaConduccion(Licencia_conducion licenciaConduccion) {
        this.licenciaConduccion = licenciaConduccion;
    }

    public void setMedioPago(Medio_pago medioPago) {
        this.medioPago = medioPago;
    }

    public void setDatosContacto(String datosContacto) {
        this.datosContacto = datosContacto;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setImagenDocumentoIdentidad(String imagenDocumentoIdentidad) {
        this.imagenDocumentoIdentidad = imagenDocumentoIdentidad;
    }
}




