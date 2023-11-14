package interfaz_grafica;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class formulario_reserva extends JFrame 
{
	private static final long serialVersionUID = 1L;
	public formulario_reserva(String nombreUsuario) 
    {
		//Nueva pestaña
        super("Formulario de reserva");
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setResizable(false);

        // Crear el panel izquierdo (menú)
        JPanel menuPanel = Funciones.createMenuPanel();

        // Panel central
        JPanel centralPanel = new JPanel(new BorderLayout());
        centralPanel.setBackground(Color.WHITE);
        

        JPanel topPanel = Funciones.crearPanelConFondo("RecursosInterfaz\\reservaPanel.png", 700, 100);
        topPanel.setOpaque(false); //Configuar el panel como transparente
        topPanel.setLayout(new BorderLayout());// Configura el diseño del panel para utilizar un BorderLayout

        
    
        JLabel inicioSesionLabel = new JLabel();
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
        
        
        


        JLabel fechaInicioLabel = new JLabel("Ingrese la fecha de inicio de la reserva (dd/mm/yyyy):");
        fechaInicioLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        fechaInicioLabel.setHorizontalAlignment(SwingConstants.LEFT);
        fechaInicioLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        fechaInicioLabel.setPreferredSize(new Dimension(70, 30));

        JTextField fechaInicioTextField = new JTextField();
        fechaInicioTextField.setMaximumSize(new Dimension(1000,80));
        
        fechaInicioTextField.setForeground(Color.WHITE);
        


        fechaInicioTextField.setBackground(Color.BLACK);
        
        
        JLabel fechaFinLabel = new JLabel("Ingrese la fecha de finalización de la reserva (dd/mm/yyyy):");
        fechaFinLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        fechaFinLabel.setHorizontalAlignment(SwingConstants.LEFT);
        JTextField fechaFinTextField = new JTextField();
        fechaFinTextField.setMaximumSize(new Dimension(1000,70));
        fechaFinTextField.setBackground(Color.BLACK);
        fechaFinLabel.setPreferredSize(new Dimension(60, 30));
        fechaFinTextField.setForeground(Color.WHITE);



        JLabel seguroLabel = new JLabel("Seleccione el número de seguro:");
        seguroLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        seguroLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JComboBox seguroComboBox = new JComboBox(new String[]{"Seguro 1", "Seguro 2", "Seguro 3"});
        seguroComboBox.setBackground(Color.BLACK);
        seguroComboBox.setForeground(Color.WHITE);
        seguroLabel.setPreferredSize(new Dimension(70, 30));
        seguroComboBox.setMaximumSize(new Dimension(1000,50));




        JLabel sedeLabel = new JLabel("Ingrese la sede de entrega del vehículo:");
        sedeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        sedeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        sedeLabel.setPreferredSize(new Dimension(70, 30));

        JTextField sedeTextField = new JTextField();
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
        
 


        JButton botonReserva = new JButton("");
        
        botonReserva.setBorderPainted(false);
        botonReserva.setFocusPainted(false);
        botonReserva.setOpaque(false);
        botonReserva.setBackground(Color.WHITE);

        PanelBotoninic.add(botonReserva);
        PanelBotoninic.setAlignmentX(Component.LEFT_ALIGNMENT);
        agregarImagenABoton(botonReserva,"RecursosInterfaz\\reservarBoton.png");

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



	public static void main(String[] args) 
    {
		//Valores provisionales
	    formulario_reserva adminGeneral = new formulario_reserva(null);
		adminGeneral.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		adminGeneral.setVisible(true);
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






    }

