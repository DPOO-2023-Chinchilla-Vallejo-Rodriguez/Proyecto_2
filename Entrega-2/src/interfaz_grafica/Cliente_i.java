package interfaz_grafica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Reservas_modelo.Empresa;
import Reservas_modelo.Usuario;


import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Cliente_i extends JFrame {
	private static Inicio_sesion padre;

	private static final long serialVersionUID = 1L;
	public Cliente_i(Inicio_sesion padre) {
		//Nueva pestaña
        super("Cliente");
        this.padre = padre;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Crear el panel izquierdo (menú)
        JPanel menuPanel = Funciones.createMenuPanel();

        // Panel central
        JPanel centralPanel = new JPanel(new BorderLayout());
        centralPanel.setBackground(Color.WHITE);

        JPanel topPanel = Funciones.crearPanelConFondo("./RecursosInterfaz/UsuarioPanel.png", 700, 300);
        topPanel.setOpaque(false); //Configuar el panel como transparente
        topPanel.setLayout(new BorderLayout());// Configura el diseño del panel para utilizar un BorderLayout

        //Etiquetas dentro del panel con la informacion del inicio de sesion
        JLabel label = new JLabel("Hola, " + Inicio_sesion.getNombreu());
        label.setForeground(Color.WHITE);
        Font fuenteActual1 = label.getFont();
        Font fuenteGrande1 = new Font(fuenteActual1.getName(), fuenteActual1.getStyle(),30 );
        label.setFont(fuenteGrande1);
        label.setBorder(BorderFactory.createEmptyBorder(60, 100, 0, 0));
        
        JLabel inicioSesionLabel = new JLabel("Iniciaste sesión como cliente");
        inicioSesionLabel.setForeground(Color.WHITE);
        inicioSesionLabel.setBorder(BorderFactory.createEmptyBorder(0, 103, 180, 0));
        inicioSesionLabel.setBackground(Color.WHITE);

        topPanel.add(label, BorderLayout.NORTH);
        topPanel.add(inicioSesionLabel, BorderLayout.SOUTH);
        
        
        JPanel botonesPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER; 

        JScrollPane graficaScrollPanel = new JScrollPane(centralPanel);
        graficaScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        graficaScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        graficaScrollPanel.setPreferredSize(new Dimension(200, 200));
        botonesPanel.setBackground(Color.WHITE);

        JPanel Panelb1 = new JPanel();
        Panelb1.setBackground(Color.WHITE);
        

        // Botón 1
        JButton boton1 = new JButton();
        boton1.setBackground(Color.WHITE);
        boton1.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton1, "./RecursosInterfaz/BotonReservar.png");
        Panelb1.add(boton1);

        // Botón 2
        JButton boton2 = new JButton();
        boton2.setBackground(Color.WHITE);
        boton2.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton2, "./RecursosInterfaz/BotonGestionarReservas.png");
        Panelb1.add(boton2);
        
        botonesPanel.add(Panelb1, gbc);
        gbc.gridy++;
        
        JPanel Panelb2 = new JPanel();
        Panelb2.setBackground(Color.WHITE);
        
        // Botón 3
        JButton boton3 = new JButton();
        boton3.setBackground(Color.WHITE);
        boton3.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton3, "./RecursosInterfaz/BotonverMiInfo.png");
        Panelb2.add(boton3);
        
        
        // Botón 4
        JButton boton4 = new JButton();
        boton4.setBackground(Color.WHITE);
        boton4.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton4, "./RecursosInterfaz/BotonModificarMiInfo.png");
        Panelb2.add(boton4);
        
        
        botonesPanel.add(Panelb2, gbc);
        gbc.gridy++;

        // Agrega los botones al panel central
        centralPanel.add(topPanel, BorderLayout.NORTH);
        centralPanel.add(botonesPanel, BorderLayout.CENTER);


        //Listas provisional 
        
        // Panel con la grafica de disponibilidad de autos
        JPanel derechaPanel = Funciones.visualizaciondealtonivel( );
 
        // Agrega los paneles al JFrame
        add(menuPanel, BorderLayout.WEST);
        add(graficaScrollPanel, BorderLayout.CENTER);
        add(derechaPanel, BorderLayout.EAST);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña con la funcionalidad correspondiente a Reservar
                try {
					formulario_reserva res = new formulario_reserva(padre);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

        // Listener para el botón 2 (Gestionar Reservas)
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña con la funcionalidad correspondiente a Gestionar Reservas
                try {
					CliEliminar eliminar = new CliEliminar(padre);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña con AdministrarAutosSedes
                openNewTab(new VermiInfo(), "Ver mi información");
            }
        });
    

        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña con el PanelSeguros
                openNewTab(new AdminmiInfo(), "Administrar mi información");
            }
        });

        
        setVisible(true);
    }
	
	private void openNewTab(JPanel panel, String title) {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab(title, null, panel, null);

        JFrame frame = new JFrame();
        frame.add(tabbedPane);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
	
	//Formulario para hacer nuevas reservas
	@SuppressWarnings("serial")
	public class ReservarPanel extends JPanel {

	public ReservarPanel() {
        setLayout(new BorderLayout());

        // Contenido del panel de Reservar
        JLabel label = new JLabel("Panel de Reservar");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));

        

        // Agrega los componentes al panel
        add(label, BorderLayout.CENTER);
        
    }
}

	@SuppressWarnings("serial")
	public class GestionarReservasPanel extends JPanel {

    public GestionarReservasPanel() {
        setLayout(new BorderLayout());

        // Contenido del panel de Gestionar Reservas
        JLabel label = new JLabel("Gestionar Reservas");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton verReservasButton = new JButton("Ver Reservas");
        personalizarBoton(verReservasButton);

        verReservasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña para ver las reservas
                openNewTab(new VerReservasPanel(), "Ver Reservas");
            }
        });
        JButton cancelarReservasButton = new JButton("Cancelar Reservas");
        personalizarBoton(cancelarReservasButton);

        cancelarReservasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña para cancelar las reservas
                openNewTab(new CancelarReservasPanel(), "Cancelar Reservas");
            }
        });
        // Agrega los componentes al panel con GridLayout
        JPanel botonesPanel = new JPanel();
        botonesPanel.add(verReservasButton);
        botonesPanel.add(cancelarReservasButton);
        
     // Agregar una imagen (reemplaza "path/to/your/image.png" con la ruta real de tu imagen)
        ImageIcon imageIcon = new ImageIcon("./RecursosInterfaz/carroNegro.png");
        Image scaledImage3 = imageIcon.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH); // Ajusta las dimensiones según sea necesario
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);

        JLabel imageLabel = new JLabel(scaledIcon3);
        
        // Agrega los componentes al panel principal
        add(label, BorderLayout.NORTH);
        add(botonesPanel, BorderLayout.CENTER);
        add(imageLabel, BorderLayout.SOUTH);
    }

    private void personalizarBoton(JButton boton) {
        boton.setBackground(Color.BLACK);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setMaximumSize(new Dimension(30, 30));
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acciones del botón
            }
        });
    }
}
    
	@SuppressWarnings("serial")
		public class VerReservasPanel extends JPanel {

    	public VerReservasPanel() {
            setLayout(new GridBagLayout());

         // Crear etiquetas para mostrar la información
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            
            // Contenido del panel "Administrar mi información"
            JLabel label = new JLabel("Mi información");
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            label.setBorder(new EmptyBorder(10, 10, 10, 10));
            add(label, gbc);
            gbc.gridy++;
            
            List<List<String>> informacionReservas = Empresa.obtenerReservasPorCorreo(Inicio_sesion.getCorreoUsuario());
            System.out.println(Empresa.obtenerReservasPorCorreo(Inicio_sesion.getCorreoUsuario()));

            
         // Crear etiquetas para mostrar la información
            JPanel innerPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc1 = new GridBagConstraints();
            for (List<String> reservaInfo : informacionReservas) {
                for (String atributo : reservaInfo) {
                    JLabel infoLabel = new JLabel(atributo);
                    infoLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
                    innerPanel.add(infoLabel, gbc1);
                    gbc1.gridy++;
                }
            }
            
            JScrollPane scrollPane = new JScrollPane(innerPanel);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setPreferredSize(new Dimension(200, 200))
            ;
            // Agrega el JScrollPane al panel principal
            add(scrollPane, gbc);
            gbc.gridy++;

            // Agregar una imagen (reemplaza "path/to/your/image.png" con la ruta real de tu imagen)
            ImageIcon imageIcon = new ImageIcon("./RecursosInterfaz/carroNegro.png");
            Image scaledImage3 = imageIcon.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH); // Ajusta las dimensiones según sea necesario
            ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);

            JLabel imageLabel = new JLabel(scaledIcon3);
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Configurar restricciones para la imagen
            gbc1.gridx = 0;
            gbc1.gridy++;
            gbc1.gridwidth = GridBagConstraints.REMAINDER; // La imagen ocupa toda la fila
            gbc1.anchor = GridBagConstraints.CENTER; // La imagen está centrada

            // Agrega los componentes al panel
            
            add(imageLabel, gbc);
            gbc.gridy++;
            // Agregar el panel interno al JScrollPane

        }
    }

    @SuppressWarnings("serial")
		public class CancelarReservasPanel extends JPanel {

	    public CancelarReservasPanel() {
	        setLayout(new BorderLayout());
	        setBackground(Color.white);
	        // Contenido del panel "Cancelar Reservas"
	        JLabel label = new JLabel("Ingrese la placa para cancelar la reserva:");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));
	        label.setBackground(Color.white);
	        label.setBorder(new MatteBorder(100, 10, 100, 10, Color.WHITE));
	        
	        
	        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        userPanel.setBackground(Color.WHITE);
	
	        //caja de texto para escribir el usuario o correo
	        JTextField usernameField = new JTextField();
	        usernameField.setPreferredSize(new Dimension(600, 85));
	        usernameField.setBorder(new MatteBorder(10, 10, 10, 10, Color.WHITE));
	        usernameField.setOpaque(true);
	        usernameField.setBackground(Color.LIGHT_GRAY);
	
	        Font usernameFieldfont = usernameField.getFont();
	        Font newTextFieldFont = new Font(usernameFieldfont.getName(), usernameFieldfont.getStyle(), 16); // Ajusta el tamaño según sea necesario
	        usernameField.setFont(newTextFieldFont);
	        
	        //Imagen de la caja de texto del usuario
	        
	        userPanel.add(usernameField);
	        userPanel.setBackground(Color.WHITE);
	        
	        // Botón para cancelar la reserva
	        JButton cancelarButton = new JButton("Cancelar Reserva");
	        cancelarButton.setBackground(Color.BLACK);
	        cancelarButton.setForeground(Color.WHITE);
	        cancelarButton.setPreferredSize(new Dimension(300, 60));
	        cancelarButton.setFont(new Font("Arial", Font.BOLD, 16));
	        
	        
	        JPanel innerPanel = new JPanel(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        innerPanel.setPreferredSize(new Dimension(200, 200));
	        innerPanel.setBackground(Color.white);
	
	        innerPanel.add(cancelarButton, gbc);
	        gbc.gridy++;
	        
	       
	        
	        
	        cancelarButton.addActionListener(new ActionListener() {
	        	
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	                Empresa.cancelarReserva(Inicio_sesion.getCorreoUsuario(),usernameField.getText());
	                usernameField.setText(null);
	            }
	        });
	
	        
	        
	        // Agrega los componentes al panel
	        add(label, BorderLayout.NORTH);
	        add(userPanel, BorderLayout.CENTER);
	        add(innerPanel, BorderLayout.SOUTH);
	    }
	}
    
	@SuppressWarnings("serial")
	public class VermiInfo extends JPanel {
		
	public VermiInfo() {
        setLayout(new GridBagLayout());

        // Contenido del panel "Administrar mi información"
        JLabel label = new JLabel("Mi información");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(label);
        
        List<String> informacionUsuario = Usuario.verPerfilUsuario(Inicio_sesion.getCorreoUsuario());
        System.out.println(Usuario.verPerfilUsuario(Inicio_sesion.getCorreoUsuario()));

        // Crear etiquetas para mostrar la información
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        for (String info : informacionUsuario) {
            JLabel infoLabel = new JLabel(info);
            infoLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
            gbc.gridy++;
            add(infoLabel, gbc);
        }

        // Agregar una imagen (reemplaza "path/to/your/image.png" con la ruta real de tu imagen)
        ImageIcon imageIcon = new ImageIcon("./RecursosInterfaz/carroNegro.png");
        Image scaledImage3 = imageIcon.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH); // Ajusta las dimensiones según sea necesario
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);

        JLabel imageLabel = new JLabel(scaledIcon3);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Configurar restricciones para la imagen
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // La imagen ocupa toda la fila
        gbc.anchor = GridBagConstraints.CENTER; // La imagen está centrada

        // Agrega los componentes al panel
        
        add(imageLabel, gbc);
    }
}
	
	//Formulario Para cambiar la información del ususario
	@SuppressWarnings("serial")
	public class AdminmiInfo extends JPanel {

    
	public AdminmiInfo() {
        setLayout(new BorderLayout());

        // Contenido del panel "Administrar mi información"
        JLabel label = new JLabel("Administrar mi información");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));

        

        // Agrega los componentes al panel
        add(label, BorderLayout.CENTER);
        
    }
}
	

	public static void main(String[] args) {
		//Valores provisionales
	    
	    Cliente_i cliente = new Cliente_i(padre);
	    cliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    cliente.setVisible(true);
	}
	
	}


