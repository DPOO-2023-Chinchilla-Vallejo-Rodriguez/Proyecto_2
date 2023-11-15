package interfaz_grafica;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Reservas_modelo.Empleado;
import Reservas_modelo.Empresa;
import Reservas_modelo.Sede;
import Reservas_modelo.Vehiculo;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class AdminLocal_i extends JFrame {
	private static final long serialVersionUID = 1L;
	private static Inicio_sesion padre;
	public AdminLocal_i( Inicio_sesion padre) {
		//Nueva pestaña
        super("AdminLocal");
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
        
        JLabel inicioSesionLabel = new JLabel("Iniciaste sesión como administrador local");
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
        Funciones.agregarImagenABoton(boton1, "./RecursosInterfaz/BotonAdminInfoSede.png");
        Panelb1.add(boton1);
        
        // Botón 2
        JButton boton2 = new JButton();
        boton2.setBackground(Color.WHITE);
        boton2.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton2, "./RecursosInterfaz/BotonAdminEmpleadosSede.png");
        Panelb1.add(boton2);
        
        botonesPanel.add(Panelb1, gbc);
        gbc.gridy++;
        
        JPanel Panelb2 = new JPanel();
        Panelb2.setBackground(Color.WHITE);
        // Botón 3
        JButton boton3 = new JButton();
        boton3.setBackground(Color.WHITE);
        boton3.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton3, "./RecursosInterfaz/BotonAdministrarautosSede.png");
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
                // Abre una nueva pestaña con AdminInfoSedes
                openNewTab(new AdminInfoSedes(), "Administrar Sedes");
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña con AdminEmpleadosSede
                try {
					FrameEmpls em = new FrameEmpls (padre);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña con AdministrarAutosSede
                try {
					FrameVehiculos v = new FrameVehiculos(padre);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        setVisible(true);
    }
	
	private void openNewTab(JPanel panel, String title) {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab(title, panel);

        JFrame frame = new JFrame("Nueva Pestaña");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(tabbedPane);
        frame.setVisible(true);
    }
	
	       
	    

	@SuppressWarnings("serial")
	public class AdminInfoSedes extends JPanel {

		public AdminInfoSedes() {
			setLayout(new BorderLayout());

	        // Contenido del panel de Gestionar Reservas
	        JLabel label = new JLabel("Gestionar Sede");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));
	        label.setBorder(new EmptyBorder(10, 10, 10, 10));

	        JButton verReservasButton = new JButton("Ver informacion de la sede");
	        personalizarBoton(verReservasButton);

	        verReservasButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para ver las reservas
	                openNewTab(new VerSedePanel(), "Ver infromación Sede");
	            }
	        });
	        JButton cancelarReservasButton = new JButton("Cambiar Info sedes");
	        personalizarBoton(cancelarReservasButton);

	        cancelarReservasButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para cancelar las reservas
	                openNewTab(new CambiarsedePanel(), "Cancelar Reservas");
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
		public class VerSedePanel extends JPanel {
	
	    	public VerSedePanel() {
	            setLayout(new GridBagLayout());
	
	         // Crear etiquetas para mostrar la información
	            GridBagConstraints gbc = new GridBagConstraints();
	            gbc.gridx = 0;
	            gbc.gridy = 0;
	            gbc.anchor = GridBagConstraints.WEST;
	            
	            // Contenido del panel "Administrar mi información"
	            JLabel label = new JLabel("Información de la Sede");
	            label.setHorizontalAlignment(JLabel.CENTER);
	            label.setFont(new Font("Arial", Font.BOLD, 24));
	            label.setBorder(new EmptyBorder(10, 10, 10, 10));
	            add(label, gbc);
	            gbc.gridy++;
	            
	            List<String> informacionsede = Sede.verInformacionSede(Inicio_sesion.getSedeu());
	            System.out.println(Empresa.obtenerReservasPorCorreo(Inicio_sesion.getCorreoUsuario()));
	
	            
	         // Crear etiquetas para mostrar la información
	            JPanel innerPanel = new JPanel(new GridBagLayout());
	            GridBagConstraints gbc1 = new GridBagConstraints();
	                for (String atributo : informacionsede) {
	                    JLabel infoLabel = new JLabel(atributo);
	                    infoLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
	                    innerPanel.add(infoLabel, gbc1);
	                    gbc1.gridy++;
	                
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

	    //Falta formulario para cambiar la inormación de la sede
	    @SuppressWarnings("serial")	
	    public class CambiarsedePanel extends JPanel {
	
	    public CambiarsedePanel() {
	        setLayout(new BorderLayout());
	        setBackground(Color.white);
	        // Contenido del panel "Cancelar Reservas"
	        JLabel label = new JLabel("Ingrese la placa para cancelar la reserva:");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));
	        label.setBackground(Color.white);
	        label.setBorder(new MatteBorder(100, 10, 100, 10, Color.WHITE));
	
	        
	        // Agrega los componentes al panel
	        add(label, BorderLayout.NORTH);
	        
	    }
	}
	    

	@SuppressWarnings("serial")
	public class AdminEmpleadosSede extends JPanel {
		public AdminEmpleadosSede() {
			setLayout(new BorderLayout());

	        // Contenido del panel de Gestionar Reservas
	        JLabel label = new JLabel("Gestionar empleados de la Sede");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));
	        label.setBorder(new EmptyBorder(10, 10, 10, 10));

	        JButton verReservasButton = new JButton("Ver informacion de los empleados de la sede");
	        personalizarBoton(verReservasButton);

	        verReservasButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para ver las reservas
	                openNewTab(new VerempleadosPanel(), "Ver información empleados Sede");
	            }
	        });
	        JButton cambiarinfoemplados = new JButton("Cambiar Información de los empleados");
	        personalizarBoton(cambiarinfoemplados);

	        cambiarinfoemplados.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para cancelar las reservas
	                openNewTab(new CambiarempleadosPanel(), "Cambiar info empleados");
	            }
	        });
	        // Agrega los componentes al panel con GridLayout
	        JPanel botonesPaneln = new JPanel();
	        botonesPaneln.add(verReservasButton);
	        botonesPaneln.add(cambiarinfoemplados);
	        
	        JButton AgregarButton = new JButton("Agregar empleados a la sede");
	        personalizarBoton(AgregarButton);

	        AgregarButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para ver las reservas
	                openNewTab(new AgregarempleadosPanel(), "Agregar empleados a la Sede");
	            }
	        });
	        JButton EliminarepleadosButton = new JButton("Eliminar empleados");
	        personalizarBoton(EliminarepleadosButton);

	        EliminarepleadosButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para cancelar las reservas
	                openNewTab(new EliminarempleadosPanel(), "Eliminar empleados");
	            }
	        });
	        // Agrega los componentes al panel con GridLayout
	        JPanel botonesPanels = new JPanel();
	        botonesPanels.add(AgregarButton);
	        botonesPanels.add(EliminarepleadosButton);
	        
	        
	        JPanel botonesPanel = new JPanel(new BorderLayout());
	        botonesPanel.setMaximumSize(new Dimension(100, 100));
		     botonesPanel.add(botonesPaneln,BorderLayout.NORTH);
		     
		     botonesPanel.add(botonesPanels,BorderLayout.SOUTH);
		   
	        
	     // Agregar una imagen (reemplaza "path/to/your/image.png" con la ruta real de tu imagen)
	        ImageIcon imageIcon = new ImageIcon("./RecursosInterfaz/carroNegro.png");
	        Image scaledImage3 = imageIcon.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH); // Ajusta las dimensiones según sea necesario
	        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
	        

	        JLabel imageLabel = new JLabel(scaledIcon3);
	        imageLabel.setBorder(new EmptyBorder(100, 100, 100, 100));
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
		public class VerempleadosPanel extends JPanel {
			
	    	public VerempleadosPanel() {
	            setLayout(new GridBagLayout());
	
	         // Crear etiquetas para mostrar la información
	            GridBagConstraints gbc = new GridBagConstraints();
	            gbc.gridx = 0;
	            gbc.gridy = 0;
	            gbc.anchor = GridBagConstraints.WEST;
	            
	            // Contenido del panel "Administrar mi información"
	            JLabel label = new JLabel("Información de los empleados");
	            label.setHorizontalAlignment(JLabel.CENTER);
	            label.setFont(new Font("Arial", Font.BOLD, 24));
	            label.setBorder(new EmptyBorder(10, 10, 10, 10));
	            add(label, gbc);
	            gbc.gridy++;
	            
	            List<String> informacionsede = Empleado.mostrarEmpleadossede(Inicio_sesion.getSedeu());
	           
	
	            
	         // Crear etiquetas para mostrar la información
	            JPanel innerPanel = new JPanel(new GridBagLayout());
	            GridBagConstraints gbc1 = new GridBagConstraints();
	                for (String atributo : informacionsede) {
	                    JLabel infoLabel = new JLabel(atributo);
	                    infoLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
	                    innerPanel.add(infoLabel, gbc1);
	                    gbc1.gridy++;
	                
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
	
	    //Falta formulario para agreagar empleados a la sede
	    @SuppressWarnings("serial")	
	    public class AgregarempleadosPanel extends JPanel {
	
	    public AgregarempleadosPanel() {
	        setLayout(new BorderLayout());
	        setBackground(Color.white);
	        // Contenido del panel "Cancelar Reservas"
	        JLabel label = new JLabel("Ingrese la placa para cancelar la reserva:");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));
	        label.setBackground(Color.white);
	        label.setBorder(new MatteBorder(100, 10, 100, 10, Color.WHITE));
	
	        
	        // Agrega los componentes al panel
	        add(label, BorderLayout.NORTH);
	        
	    }
	}
	    
	    @SuppressWarnings("serial")
		public class EliminarempleadosPanel extends JPanel {
	
	    	public EliminarempleadosPanel() {
	            setLayout(new BorderLayout());
	            setBackground(Color.white);
	            // Contenido del panel "Cancelar Reservas"
	            JLabel label = new JLabel("Ingrese el correo del usuario a eliminar:");
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
	            JButton cancelarButton = new JButton("Eliminar empleado");
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
	                	Empleado.eliminarEmpleados(usernameField.getText());
	                    
	                    usernameField.setText(null);
	                }
	            });

	            
	            
	            // Agrega los componentes al panel
	            add(label, BorderLayout.NORTH);
	            add(userPanel, BorderLayout.CENTER);
	            add(innerPanel, BorderLayout.SOUTH);
	        }
	    }
	
	    //Falta formulario para cambiar la información de los empleados de la sede
	    @SuppressWarnings("serial")	
	    public class CambiarempleadosPanel extends JPanel {
	
	    public CambiarempleadosPanel() {
	        setLayout(new BorderLayout());
	        setBackground(Color.white);
	        // Contenido del panel "Cancelar Reservas"
	        JLabel label = new JLabel("Ingrese la placa para cancelar la reserva:");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));
	        label.setBackground(Color.white);
	        label.setBorder(new MatteBorder(100, 10, 100, 10, Color.WHITE));
	
	        
	        // Agrega los componentes al panel
	        add(label, BorderLayout.NORTH);
	        
	    }
	}
	    
    
	@SuppressWarnings("serial")
	public class AdministrarAutosSede extends JPanel {
		public AdministrarAutosSede() {
			setLayout(new BorderLayout());

	        // Contenido del panel de Gestionar Reservas
	        JLabel label = new JLabel("Gestionar automoviles de la Sede");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));
	        label.setBorder(new EmptyBorder(10, 10, 10, 10));

	        JButton verReservasButton = new JButton("Ver informacion de los autos");
	        personalizarBoton(verReservasButton);

	        verReservasButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para ver las reservas
	                openNewTab(new VerautosPanel(), "Ver información autos");
	            }
	        });
	        JButton cancelarReservasButton = new JButton("Cambiar estado o ubicación\n de un vehiculo");
	        personalizarBoton(cancelarReservasButton);

	        cancelarReservasButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para cancelar las reservas
	                openNewTab(new CambiarautoPanel(), "Cambiar estado o ubicación\n de un vehiculo");
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
	
	    //Falta formulario para cambiar la inormación de estado o ubicación de los autos
	    @SuppressWarnings("serial")	
	    public class CambiarautoPanel extends JPanel {
	
	    public CambiarautoPanel() {
	        setLayout(new BorderLayout());
	        setBackground(Color.white);
	        // Contenido del panel "Cancelar Reservas"
	        JLabel label = new JLabel("Ingrese la placa para cancelar la reserva:");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));
	        label.setBackground(Color.white);
	        label.setBorder(new MatteBorder(100, 10, 100, 10, Color.WHITE));
	
	        
	        // Agrega los componentes al panel
	        add(label, BorderLayout.NORTH);
	        
	    }
	}
	    
	
	public static void main(String[] args) {
		//Valores provisionales
		
		AdminLocal_i AdminLocal = new AdminLocal_i(padre);
		AdminLocal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		AdminLocal.setVisible(true);
	}
    }





