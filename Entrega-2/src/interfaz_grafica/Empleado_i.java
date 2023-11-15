package interfaz_grafica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Reservas_modelo.Categoria_vehiculo;
import Reservas_modelo.Empresa;
import Reservas_modelo.Seguro;
import Reservas_modelo.Usuario;
import Reservas_modelo.Vehiculo;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import interfaz_grafica.Reserva_cliente;
import interfaz_grafica.Inicio_sesion;

public class Empleado_i extends JFrame {
	
	private static Inicio_sesion padre;

	private static final long serialVersionUID = 1L;
	public Empleado_i( Inicio_sesion padre) {
		
		
		//Nueva pestaña
        super("Empleado");
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
        
        JLabel inicioSesionLabel = new JLabel("Iniciaste sesión como empleado");
        inicioSesionLabel.setForeground(Color.WHITE);
        inicioSesionLabel.setBorder(BorderFactory.createEmptyBorder(0, 103, 180, 0));
        inicioSesionLabel.setBackground(Color.WHITE);

        topPanel.add(label, BorderLayout.NORTH);
        topPanel.add(inicioSesionLabel, BorderLayout.SOUTH);
        
        
        //Panel con los botones de funcionalidades
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
        Funciones.agregarImagenABoton(boton1, "./RecursosInterfaz/BotonGestionaralquileres.png");
        Panelb1.add(boton1);

        // Botón 2
        JButton boton2 = new JButton();
        boton2.setBackground(Color.WHITE);
        boton2.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton2, "./RecursosInterfaz/BotonActualizarautos.png");
        Panelb1.add(boton2);
        
        botonesPanel.add(Panelb1, gbc);
        gbc.gridy++;
        
        JPanel Panelb2 = new JPanel();
        Panelb2.setBackground(Color.WHITE);
        
        // Botón 3
        JButton boton3 = new JButton();
        boton3.setBackground(Color.WHITE);
        boton3.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton3, "./RecursosInterfaz/Botongestionarusuarios.png");
        Panelb2.add(boton3);
        
        botonesPanel.add(Panelb2, gbc);
        gbc.gridy++;

        // Agrega los botones al panel central
        centralPanel.add(topPanel, BorderLayout.NORTH);
        centralPanel.add(botonesPanel, BorderLayout.CENTER);

        
        // Panel con la grafica de disponibilidad de autos
        JPanel derechaPanel = Funciones.visualizaciondealtonivel();
 
        // Agrega los paneles al JFrame
        add(menuPanel, BorderLayout.WEST);
        add(graficaScrollPanel, BorderLayout.CENTER);
        add(derechaPanel, BorderLayout.EAST);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					Reserva_cliente r = new Reserva_cliente (padre);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

        // ActionListener para el botón 2
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewTab(new AdminActualizarAutos(), "Actualizar Autos");
            }
        });
        
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña con el PanelSeguros
                openNewTab(new Adminusuarios(), "Administrar información ususarios");
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
	
	@SuppressWarnings("serial")
	public class GestionarReservasPanel extends JPanel {

    public GestionarReservasPanel() {
        setLayout(new BorderLayout());

        // Contenido del panel de Gestionar Reservas
        JLabel label = new JLabel("Gestionar Reservas");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel correoLabel = new JLabel("Correo del Usuario:");
        JTextField correoField = new JTextField();
        correoField.setPreferredSize(new Dimension(200, 30));
        
        JButton verReservasButton = new JButton("Ver Reservas");
        personalizarBoton(verReservasButton);

        verReservasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String correoUsuario = correoField.getText();
                // Verificar si el correo está vacío o realizar otras validaciones según sea necesario
                if (!correoUsuario.isEmpty()) {
                    // Abre una nueva pestaña para ver las reservas del usuario específico
                    openNewTab(new VerReservasPanel(correoUsuario), "Ver Reservas");
                } else {
                    // Muestra un mensaje de error o realiza otra acción según sea necesario
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el correo del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                }
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
        
        JButton nuevaReservaButton = new JButton("Nueva Reserva");
        personalizarBoton(nuevaReservaButton);

        nuevaReservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña para crear una nueva reserva
                openNewTab(new ReservarPanel(), "Nueva Reserva");
            }
        });

        JPanel innerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        innerPanel.setPreferredSize(new Dimension(200, 200));
        

        innerPanel.add(correoLabel, gbc);
        gbc.gridy++;
        innerPanel.add(correoField, gbc);
        gbc.gridy++;
        innerPanel.add(verReservasButton, gbc);
        
        // Agrega los componentes al panel con GridLayout
        JPanel botonesPanel = new JPanel();
        botonesPanel.add(innerPanel);
        botonesPanel.add(cancelarReservasButton);
        botonesPanel.add(nuevaReservaButton);
        
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

    	public VerReservasPanel( String correou) {
            setLayout(new GridBagLayout());

         // Crear etiquetas para mostrar la información
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            
            // Contenido del panel "Administrar mi información"
            JLabel label = new JLabel("Reservas ");
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            label.setBorder(new EmptyBorder(10, 10, 10, 10));
            add(label, gbc);
            gbc.gridy++;
            
            List<List<String>> informacionReservas = Empresa.obtenerReservasPorCorreo(correou);
            System.out.println(correou);

            
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
	        label.setBorder(new MatteBorder(100, 10, 10, 10, Color.WHITE));
	        
	        
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
	        
	        JLabel correoLabel = new JLabel("Correo del Usuario:");
	        JTextField correoField = new JTextField();
	        correoField.setPreferredSize(new Dimension(600, 85));
	        correoField.setBackground(Color.LIGHT_GRAY);
	        correoField.setBorder(new MatteBorder(10, 10, 10, 10, Color.WHITE));
	        correoLabel.setHorizontalAlignment(JLabel.CENTER);
	        correoLabel.setFont(new Font("Arial", Font.BOLD, 24));
	        correoLabel.setBackground(Color.white);
	        correoLabel.setBorder(new MatteBorder(10, 10, 10, 10, Color.WHITE));
	        

	        JButton cancelarButton1 = new JButton("Cancelar Reserva");
	        cancelarButton1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String correoUsuario = correoField.getText();
	                // Verificar si el correo está vacío o realizar otras validaciones según sea necesario
	                if (!correoUsuario.isEmpty()) {
	                    // Cancelar la reserva para el usuario específico
	                    Empresa.cancelarReserva(correoUsuario, usernameField.getText());
	                    usernameField.setText(null);
	                } else {
	                    // Muestra un mensaje de error o realiza otra acción según sea necesario
	                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el correo del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
	        
	        JPanel innerPanel = new JPanel(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        innerPanel.setPreferredSize(new Dimension(200, 200));
	        innerPanel.setBackground(Color.white);
	
	        innerPanel.add(correoLabel, gbc);
	        gbc.gridy++;
	        innerPanel.add(correoField, gbc);
	        gbc.gridy++;
	        innerPanel.add(cancelarButton1, gbc);
	        
	       
	        
	        
	        cancelarButton1.addActionListener(new ActionListener() {
	        	
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
    
	  	//Falta formulario para hacer nuevas reservas
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
	public class AdminActualizarAutos extends JPanel {
	    
		 public AdminActualizarAutos() {
		        setLayout(new BorderLayout());

		        // Contenido del panel de Gestionar Reservas
		        JLabel label = new JLabel("Gestionar vehiculos");
		        label.setHorizontalAlignment(JLabel.CENTER);
		        label.setFont(new Font("Arial", Font.BOLD, 24));
		        label.setBorder(new EmptyBorder(10, 10, 10, 10));

		        JButton verReservasButton = new JButton("Ver vehiculos");
		        personalizarBoton(verReservasButton);

		        verReservasButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // Abre una nueva pestaña para ver las reservas
		                openNewTab(new VerautosPanel(), "Ver Vehiculos");
		            }
		        });
		        JButton cancelarReservasButton = new JButton("Verificar disponibilidad");
		        personalizarBoton(cancelarReservasButton);

		        cancelarReservasButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // Abre una nueva pestaña para cancelar las reservas
		                openNewTab(new VerificarDisponibilidadPanel(), "Verificar disponibilidad de un vehiculo");
		            }
		        });
		        
		        JButton Tarifa = new JButton("Calcular tarifa");
		        personalizarBoton(Tarifa);

		        Tarifa.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // Abre una nueva pestaña para cancelar las reservas
		                openNewTab(new Tarifa(), "Calcular tarifa");
		            }
		        });
		        // Agrega los componentes al panel con GridLayout
		        JPanel botonesPanel = new JPanel();
		        botonesPanel.add(Tarifa);
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
		public class VerautosPanel extends JPanel {
			
	    	public VerautosPanel() {
	            setLayout(new GridBagLayout());
	
	         // Crear etiquetas para mostrar la información
	            GridBagConstraints gbc = new GridBagConstraints();
	            gbc.gridx = 0;
	            gbc.gridy = 0;
	            gbc.anchor = GridBagConstraints.WEST;
	            
	            // Contenido del panel "Administrar mi información"
	            JLabel label = new JLabel("Información de los autos de la Sede");
	            label.setHorizontalAlignment(JLabel.CENTER);
	            label.setFont(new Font("Arial", Font.BOLD, 24));
	            label.setBorder(new EmptyBorder(10, 10, 10, 10));
	            add(label, gbc);
	            gbc.gridy++;
	            
	            List<List<String>> informacionautos = Vehiculo.verVehiculosSede(Inicio_sesion.getSedeu());
	            
	            
	         // Crear etiquetas para mostrar la información
	            JPanel innerPanel = new JPanel(new GridBagLayout());
	            GridBagConstraints gbc1 = new GridBagConstraints();
	            for (List<String> reservaInfo : informacionautos) {
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
	            scrollPane.setPreferredSize(new Dimension(300, 300))
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
		public class VerificarDisponibilidadPanel extends JPanel {

  		public VerificarDisponibilidadPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Contenido del panel "Verificar Disponibilidad"
        JLabel label = new JLabel("Verificar Disponibilidad de Vehículo");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBorder(new MatteBorder(10, 10, 10, 10, Color.WHITE));

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.setBackground(Color.WHITE);

        JTextField placaField = new JTextField();
        placaField.setPreferredSize(new Dimension(200, 30));

        JButton verificarButton = new JButton("Verificar Disponibilidad");
        verificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = placaField.getText();
                if (Vehiculo.verificarDisponibilidadVehiculo(placa)) {
                    JOptionPane.showMessageDialog(null, "El vehículo está disponible.", "Disponibilidad", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "El vehículo no está disponible.", "Disponibilidad", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Agregar los componentes al panel
        inputPanel.add(new JLabel("Ingrese la placa del vehículo:"));
        inputPanel.add(placaField);
        inputPanel.add(verificarButton);

        add(label, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
    }
}
    	
  		@SuppressWarnings("serial")
    	public class Tarifa extends JPanel {

	    public Tarifa() {
	        setLayout(new BorderLayout());
	        setBackground(Color.WHITE);
	
	        // Contenido del panel "Tarifa"
	        JLabel label = new JLabel("Calcular Tarifa de Alquiler");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));
	        label.setBorder(new MatteBorder(10, 10, 10, 10, Color.WHITE));
	
	        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
	        inputPanel.setBackground(Color.WHITE);
	
	        // Mostrar información sobre categorías y obtener la categoría seleccionada
	        String categoria = JOptionPane.showInputDialog("Ingrese el nombre de la categoría del alquiler:");
	
	        // Mostrar información sobre seguros y obtener el seguro seleccionado
	        String seguroInput = JOptionPane.showInputDialog("Ingrese el nombre del seguro (Deje en blanco si no selecciona ninguno): ");
	        Seguro seguro = Seguro.obtenerInformacionSeguroPorNombre(seguroInput);
	
	        // Obtener el número de días de alquiler
	        String numeroDiasInput = JOptionPane.showInputDialog("Ingrese el número de días de alquiler: ");
	        int numeroDias = Integer.parseInt(numeroDiasInput);
	
	        // Calcular la tarifa total
	        Categoria_vehiculo provisionalC = Categoria_vehiculo.obtenerInformacionCategoriaPorNombre(categoria);
	        double tarifaTotal = Empresa.calcularTarifaAlquiler(provisionalC, seguro, numeroDias);
	
	        // Mostrar la tarifa total
	        JLabel resultadoLabel = new JLabel("Tarifa total de alquiler: " + tarifaTotal);
	        resultadoLabel.setHorizontalAlignment(JLabel.CENTER);
	
	        // Botón para calcular la tarifa
	        JButton calcularTarifaButton = new JButton("Calcular Tarifa");
	        calcularTarifaButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Actualizar la información y recalcular la tarifa
	                // (puedes agregar lógica adicional aquí si es necesario)
	                String categoria = JOptionPane.showInputDialog("Ingrese el nombre de la categoría del alquiler:");
	                String seguroInput = JOptionPane.showInputDialog("Ingrese el nombre del seguro (Deje en blanco si no selecciona ninguno): ");
	                Seguro seguro = Seguro.obtenerInformacionSeguroPorNombre(seguroInput);
	                String numeroDiasInput = JOptionPane.showInputDialog("Ingrese el número de días de alquiler: ");
	                int numeroDias = Integer.parseInt(numeroDiasInput);
	
	                Categoria_vehiculo provisionalC = Categoria_vehiculo.obtenerInformacionCategoriaPorNombre(categoria);
	                double tarifaTotal = Empresa.calcularTarifaAlquiler(provisionalC, seguro, numeroDias);
	
	                resultadoLabel.setText("Tarifa total de alquiler: " + tarifaTotal);
	            }
	        });
	
	        // Agregar los componentes al panel
	        inputPanel.add(new JLabel("Categoría de Alquiler: " + categoria));
	        inputPanel.add(new JLabel("Seguro: " + (seguro != null ? seguro.getNombre() : "Ninguno")));
	        inputPanel.add(new JLabel("Número de días de alquiler: " + numeroDias));
	        inputPanel.add(resultadoLabel);
	        inputPanel.add(new JLabel("")); // Espacio en blanco
	        inputPanel.add(calcularTarifaButton);
	
	        add(label, BorderLayout.NORTH);
	        add(inputPanel, BorderLayout.CENTER);
	    }
	}

    	
    @SuppressWarnings("serial")
	public class Adminusuarios extends JPanel {
		public Adminusuarios() {
	        setLayout(new BorderLayout());

	        // Contenido del panel de Gestionar Reservas
	        JLabel label = new JLabel("Gestionar Usarios");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));
	        label.setBorder(new EmptyBorder(10, 10, 10, 10));

	        JLabel correoLabel = new JLabel("Correo del Usuario:");
	        JTextField correoField = new JTextField();
	        correoField.setPreferredSize(new Dimension(200, 30));
	        
	        JButton verReservasButton = new JButton("Ver Usuario");
	        personalizarBoton(verReservasButton);

	        verReservasButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String correoUsuario = correoField.getText();
	                // Verificar si el correo está vacío o realizar otras validaciones según sea necesario
	                if (!correoUsuario.isEmpty()) {
	                    // Abre una nueva pestaña para ver las reservas del usuario específico
	                    openNewTab(new VerUsuario(correoUsuario), "Ver Usuarios");
	                } else {
	                    // Muestra un mensaje de error o realiza otra acción según sea necesario
	                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el correo del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
	        JButton cancelarReservasButton = new JButton("Modificar Usuario");
	        personalizarBoton(cancelarReservasButton);

	        cancelarReservasButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para cancelar las reservas
	                openNewTab(new ModificarUsuario(), "Modificar Usuario");
	            }
	        });
	        
	        JButton nuevaReservaButton = new JButton("Crear Usuario");
	        personalizarBoton(nuevaReservaButton);

	        nuevaReservaButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para crear una nueva reserva
	                openNewTab(new CrearUsuario(), "Crear Usuario");
	            }
	        });

	        JPanel innerPanel = new JPanel(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        innerPanel.setPreferredSize(new Dimension(200, 200));
	        

	        innerPanel.add(correoLabel, gbc);
	        gbc.gridy++;
	        innerPanel.add(correoField, gbc);
	        gbc.gridy++;
	        innerPanel.add(verReservasButton, gbc);
	        
	        // Agrega los componentes al panel con GridLayout
	        JPanel botonesPanel = new JPanel();
	        botonesPanel.add(innerPanel);
	        botonesPanel.add(cancelarReservasButton);
	        botonesPanel.add(nuevaReservaButton);
	        
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
		public class VerUsuario extends JPanel {
		
		public VerUsuario(String usuario) {
	        setLayout(new GridBagLayout());

	        // Contenido del panel "Administrar mi información"
	        JLabel label = new JLabel("Informacion del usuario");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));
	        label.setBorder(new EmptyBorder(10, 10, 10, 10));
	        add(label);
	        
	        List<String> informacionUsuario = Usuario.verPerfilUsuario(usuario);
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
		public class ModificarUsuario extends JPanel {

	    
		public ModificarUsuario() {
	        setLayout(new BorderLayout());

	        // Contenido del panel "Administrar mi información"
	        JLabel label = new JLabel("Administrar mi información");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));

	        

	        // Agrega los componentes al panel
	        add(label, BorderLayout.CENTER);
	        
	    }
	}

		//Formulario Para crear ususario
		@SuppressWarnings("serial")	
		public class CrearUsuario extends JPanel {

			    
				public CrearUsuario() {
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
	    Empleado_i empleado = new Empleado_i(padre);
		empleado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    empleado.setVisible(true);
	}
    }



