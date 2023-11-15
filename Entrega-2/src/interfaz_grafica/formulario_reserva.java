package interfaz_grafica;

import javax.imageio.ImageIO;
import javax.swing.*;

import Reservas_modelo.Categoria_vehiculo;
import Reservas_modelo.Empresa;
import Reservas_modelo.Historial;
import Reservas_modelo.Seguro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import interfaz_grafica.Inicio_sesion;
import Reservas_modelo.Vehiculo;
import Reservas_modelo.Empresa;

public class formulario_reserva extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private static Inicio_sesion padre;
    
    private JLabel inicioSesionLabel;
    private JLabel fechaInicioLabel;
    private JTextField fechaInicioTextField;
    private JLabel fechaFinLabel;
    private JTextField fechaFinTextField;
    private JLabel seguroLabel;
    private JComboBox<String> seguroComboBox;
    private JLabel sedeLabel;
    private JTextField sedeTextField;
    private JButton botonReserva;
    
	
	public formulario_reserva(Inicio_sesion padre) 
    {
		
		
		//Nueva pestaña
        super("Formulario de reserva");
        
        this.padre = padre;
        
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setResizable(false);

        setVisible(true);
        // Crear el panel izquierdo (menú)
        JPanel menuPanel = Funciones.createMenuPanel();

        // Panel central
        JPanel centralPanel = new JPanel(new BorderLayout());
        centralPanel.setBackground(Color.WHITE);
        

        JPanel topPanel = Funciones.crearPanelConFondo("RecursosInterfaz\\reservaPanel.jpg", 700, 100);
        topPanel.setOpaque(false); //Configuar el panel como transparente
        topPanel.setLayout(new BorderLayout());// Configura el diseño del panel para utilizar un BorderLayout

        
    
        inicioSesionLabel = new JLabel();
        inicioSesionLabel.setForeground(Color.WHITE);
        inicioSesionLabel.setBorder(BorderFactory.createEmptyBorder(20, 30, 100,30));
        inicioSesionLabel.setBackground(Color.WHITE);

        
        topPanel.add(inicioSesionLabel, BorderLayout.SOUTH);
        
        
        //Panel con los botones de funcionalidades
        JPanel botonesPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER; 
        botonesPanel.setBackground(Color.WHITE);

        JPanel Panelb1 = new JPanel();
        Panelb1.setBackground(Color.WHITE);
        Panelb1.setLayout(new BoxLayout(Panelb1,BoxLayout.Y_AXIS));
        
        
        


        fechaInicioLabel = new JLabel("Ingrese la fecha de inicio de la reserva (dd/mm/yyyy):");
        fechaInicioLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        fechaInicioLabel.setHorizontalAlignment(SwingConstants.LEFT);
        fechaInicioLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        fechaInicioLabel.setPreferredSize(new Dimension(70, 30));

        fechaInicioTextField = new JTextField();
        fechaInicioTextField.setMaximumSize(new Dimension(1000,80));
        
        fechaInicioTextField.setForeground(Color.WHITE);
        


        fechaInicioTextField.setBackground(Color.BLACK);
        
        
        fechaFinLabel = new JLabel("Ingrese la fecha de finalización de la reserva (dd-mm-yyyy):");
        fechaFinLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        fechaFinLabel.setHorizontalAlignment(SwingConstants.LEFT);
        fechaFinTextField = new JTextField();
        fechaFinTextField.setMaximumSize(new Dimension(1000,70));
        fechaFinTextField.setBackground(Color.BLACK);
        fechaFinLabel.setPreferredSize(new Dimension(60, 30));
        fechaFinTextField.setForeground(Color.WHITE);



        seguroLabel = new JLabel("Seleccione el número de seguro:");
        seguroLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        seguroLabel.setHorizontalAlignment(SwingConstants.LEFT);

        seguroComboBox = new JComboBox(new String[]{"RC", "CDW", "AW"});
        seguroComboBox.setBackground(Color.BLACK);
        seguroComboBox.setForeground(Color.WHITE);
        seguroLabel.setPreferredSize(new Dimension(70, 30));
        seguroComboBox.setMaximumSize(new Dimension(1000,50));




        sedeLabel = new JLabel("Ingrese la sede de entrega del vehículo:");
        sedeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        sedeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        sedeLabel.setPreferredSize(new Dimension(70, 30));

        sedeTextField = new JTextField();
        sedeTextField.setBackground(Color.BLACK);
        sedeTextField.setMaximumSize(new Dimension(1000,70));
        sedeLabel.setPreferredSize(new Dimension(70, 30));
        sedeTextField.setForeground(Color.WHITE);


       
       

        Panelb1.add(fechaInicioLabel);
        Panelb1.add(fechaInicioTextField);
        Panelb1.add(fechaFinLabel);
        Panelb1.add(fechaFinTextField);
        Panelb1.add(seguroLabel);
        Panelb1.add(seguroComboBox);
        Panelb1.add(sedeLabel);
        Panelb1.add(sedeTextField);


        JPanel izquierdacentro = new JPanel();
        izquierdacentro.setBackground(Color.WHITE);
        izquierdacentro.setPreferredSize(new Dimension(100,300));
        centralPanel.add(izquierdacentro, BorderLayout.WEST);


        JPanel derechacentro = new JPanel();
        derechacentro.setBackground(Color.WHITE);
        derechacentro.setPreferredSize(new Dimension(200,300));
        centralPanel.add(derechacentro, BorderLayout.EAST);







        //agregar panel abajo - Boton de reservar vehiculo
        JPanel PanelBoton = new JPanel();
        PanelBoton.setBackground(Color.WHITE);
        PanelBoton.setPreferredSize(new Dimension(100,150));


        //Panel de boton
        JPanel PanelBotoninic = new JPanel();
        PanelBotoninic.setBackground(Color.WHITE);
        
 


        botonReserva = new JButton("");
        botonReserva.addActionListener( this );
        botonReserva.setBorderPainted(false);
        botonReserva.setFocusPainted(false);
        botonReserva.setOpaque(false);
        botonReserva.setBackground(Color.WHITE);

        PanelBotoninic.add(botonReserva);
        PanelBotoninic.setAlignmentX(Component.LEFT_ALIGNMENT);
        agregarImagenABoton(botonReserva,"RecursosInterfaz\\reservaboton.jpg");

        PanelBoton.add(PanelBotoninic, BorderLayout.EAST);
       


        // Agrega los botones al panel central
        centralPanel.add(topPanel, BorderLayout.NORTH);
        centralPanel.add(Panelb1, BorderLayout.CENTER);
        centralPanel.setPreferredSize(new Dimension(70,50));

        
        // Agrega los paneles al JFrame
        add(menuPanel, BorderLayout.WEST);
        add(centralPanel, BorderLayout.CENTER);
        centralPanel.add(PanelBoton, BorderLayout.SOUTH);
        
        setVisible(true);


    }





    static void agregarImagenABoton(JButton boton, String rutaImagen) {
        try {
            BufferedImage image = ImageIO.read(new File(rutaImagen));
            Image scaledImage = image.getScaledInstance(250, 100, Image.SCALE_SMOOTH); // Ajusta el tamaño de la imagen
            boton.setIcon(new ImageIcon(scaledImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	        if(e.getSource( )==botonReserva)
	        {
	            registrar( );
	        }
	        
	    }
    
    public void registrar ()
	 {
		 
		 //String placa = obtenerPlacaDisponible(); 
		 String inicio = fechaInicioTextField.getText();
		 String fin = fechaFinTextField.getText();
		 String sede = sedeTextField.getText();
		 String seguro = (String) seguroComboBox.getSelectedItem() ;
		 String correo = padre.getCorreoUsuario();
		 
		 Vehiculo vehiculo = asignarVehiculoAutomatico(inicio,fin);
		 String placa = vehiculo.getPlaca();
		 String tarifa = Tarifa(vehiculo.getCategoria());
		 System.out.println(vehiculo.getCategoria());
		 String union = correo+","+placa+","+inicio+","+fin+","+tarifa+","+seguro+padre.getSedeu()+","+sede+","+"Alquilado";
		 
		 String archivo = "./data/reservas.csv";
		 
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) 
		 {
	            writer.write(union);
	            JOptionPane.showMessageDialog(this, "Información guardada ");
	        } 
		 catch (IOException e) 
		 {
			 
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error al guardar la información en el archivo");
	        }
	 }
    
    public int calcularDiferenciaDias() {
       
    	String fechaInicio = fechaInicioTextField.getText();
    	
    	String fechaFin = fechaFinTextField.getText();
    	
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        
        LocalDate fechaInicioObj = LocalDate.parse(fechaInicio, formatter);
        LocalDate fechaFinObj = LocalDate.parse(fechaFin, formatter);

  
        int diasDiferencia = (int) ChronoUnit.DAYS.between(fechaInicioObj, fechaFinObj);

        return diasDiferencia;
    }
    
    public String Tarifa (String categoria)
    {
    	String seguro = (String) seguroComboBox.getSelectedItem() ;
    	
    	
        Seguro seguron = Seguro.obtenerInformacionSeguroPorNombre(seguro);

        
        int numeroDias = calcularDiferenciaDias();
        
        
        Categoria_vehiculo provisionalC = Categoria_vehiculo.obtenerInformacionCategoriaPorNombre(categoria);
        double tarifaTotal = Empresa.calcularTarifaAlquiler(provisionalC, seguron, numeroDias);
        
        String cadena = String.valueOf(tarifaTotal);
        System.out.println("ANALISIS");
        System.out.println(provisionalC);
        System.out.println(seguron);
        System.out.println(numeroDias);
        return cadena;
    }

    public static Vehiculo asignarVehiculoAutomatico(String fechaInicio, String fechaFin) {
        
        List<Vehiculo> vehiculos =  padre.getVehiculos();
        

        
        for (Vehiculo vehiculo : vehiculos) {
            
            try {
				if (vehiculo.getEstado().equalsIgnoreCase("disponible") && !verificarDisponibilidad(vehiculo.getPlaca(), fechaInicio, fechaFin)) {
				    
				    vehiculo.setEstado("reservado");
				    return vehiculo;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return null;
    }
    
    public static boolean verificarDisponibilidad(String placa, String fechaInicio, String fechaFin)
    {
    	boolean estado = false;

    	for (Historial reserva : padre.getHistorial()) {
 	       if (reserva.getVehiculoReservado().equals(placa)) {
 	    	 LocalDate inicio1 = LocalDate.parse(fechaInicio);
 	         LocalDate fin1 = LocalDate.parse(fechaFin);
 	         LocalDate inicio2 = LocalDate.parse(reserva.getFechaAlquiler());
 	         LocalDate fin2 = LocalDate.parse(reserva.getFechaReserva());
 	        estado = (inicio1.compareTo(inicio2) >= 0) && (fin1.compareTo(fin2) <= 0);
 	        }
 	    }

    	
    	return estado;
    }




















    }

