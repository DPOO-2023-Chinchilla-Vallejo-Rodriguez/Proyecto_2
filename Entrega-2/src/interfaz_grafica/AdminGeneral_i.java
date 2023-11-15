package interfaz_grafica;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Reservas_modelo.Categoria_vehiculo;
import Reservas_modelo.Empleado;
import Reservas_modelo.Empresa;
import Reservas_modelo.Sede;
import Reservas_modelo.Seguro;
import Reservas_modelo.Vehiculo;
import interfaz_grafica.AdminLocal_i.AgregarempleadosPanel;
import interfaz_grafica.AdminLocal_i.CambiarempleadosPanel;
import interfaz_grafica.AdminLocal_i.CambiarsedePanel;
import interfaz_grafica.AdminLocal_i.EliminarempleadosPanel;
import interfaz_grafica.AdminLocal_i.VerSedePanel;
import interfaz_grafica.AdminLocal_i.VerempleadosPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminGeneral_i extends JFrame {
	private static final long serialVersionUID = 1L;
	private static Inicio_sesion padre;
	public AdminGeneral_i() {
		//Nueva pestaña
        super("AdminGeneral");
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
        
        JLabel inicioSesionLabel = new JLabel("Iniciaste sesión como administrador general");
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
        Funciones.agregarImagenABoton(boton1, "./RecursosInterfaz/BotonAdminInfoSedes.png");
        Panelb1.add(boton1);
        
        // Botón 2
        JButton boton2 = new JButton();
        boton2.setBackground(Color.WHITE);
        boton2.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton2, "./RecursosInterfaz/BotonAdminEmpleadosSedes.png");
        Panelb1.add(boton2);
        
        botonesPanel.add(Panelb1, gbc);
        gbc.gridy++;
        
        JPanel Panelb2 = new JPanel();
        Panelb2.setBackground(Color.WHITE);
        // Botón 3
        JButton boton3 = new JButton();
        boton3.setBackground(Color.WHITE);
        boton3.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton3, "./RecursosInterfaz/BotonAdminautosSedes.png");
        Panelb2.add(boton3);
        
        
        // Botón 4
        JButton boton4 = new JButton();
        boton4.setBackground(Color.WHITE);
        boton4.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton4, "./RecursosInterfaz/BotonGestionarSeguros.png");
        Panelb2.add(boton4);
        
        botonesPanel.add(Panelb2, gbc);
        gbc.gridy++;

        JPanel Panelb3 = new JPanel();
        Panelb3.setBackground(Color.WHITE);
        // Botón 5
        JButton boton5 = new JButton();
        boton5.setBackground(Color.WHITE);
        boton5.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton5, "./RecursosInterfaz/BotongestionarCategorias.png");
        Panelb3.add(boton5);
        
        
        // Botón 6
        JButton boton6 = new JButton();
        boton6.setBackground(Color.WHITE);
        boton6.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton6, "./RecursosInterfaz/BotonGestionarReservas.png");
        Panelb3.add(boton6);
        
        botonesPanel.add(Panelb3, gbc);
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
                // Abre una nueva pestaña con AdminInfoSedes
                openNewTab(new AdminInfoSedes(), "Administrar Sedes");
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña con AdminEmpleadosSedes
            	try {
					FrameEmpls em = new FrameEmpls (padre);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
            }
        });

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña con AdministrarAutosSedes
            	try {
					FrameVehiculos v = new FrameVehiculos(padre);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
            }
        });
    

        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña con el PanelSeguros
                openNewTab(new PanelSeguros(), "Gestionar Seguros");
            }
        });
        
        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña con el panel correspondiente (reemplaza con tu lógica)
                openNewTab(new GestionarCategoriasPanel(), "Gestionar Categorías");
            }
        });

        // Botón 6
        boton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña con el panel correspondiente (reemplaza con tu lógica)
                openNewTab(new GestionarReservasPanel(), "Gestionar Reservas");
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
	
	        // Preguntar al usuario la sede mediante un cuadro de diálogo de entrada
	        String sedeSeleccionada = JOptionPane.showInputDialog(this, "Ingrese la sede:", "Seleccionar Sede", JOptionPane.QUESTION_MESSAGE);
	
	        if (sedeSeleccionada == null) {
	            // El usuario canceló la operación
	            // Puedes manejar esto según tus necesidades
	            return;
	        }
	
	        // Crear etiquetas para mostrar la información
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.anchor = GridBagConstraints.WEST;
	
	        // Contenido del panel "Información de la Sede"
	        JLabel label = new JLabel("Información de la Sede - Sede: " + sedeSeleccionada);
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));
	        label.setBorder(new EmptyBorder(10, 10, 10, 10));
	        add(label, gbc);
	        gbc.gridy++;
	
	        List<String> informacionSede = Sede.verInformacionSede(sedeSeleccionada);
	
	        // Crear etiquetas para mostrar la información
	        JPanel innerPanel = new JPanel(new GridBagLayout());
	        GridBagConstraints gbc1 = new GridBagConstraints();
	        for (String atributo : informacionSede) {
	            JLabel infoLabel = new JLabel(atributo);
	            infoLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
	            innerPanel.add(infoLabel, gbc1);
	            gbc1.gridy++;
	        }
	
	        JScrollPane scrollPane = new JScrollPane(innerPanel);
	        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	        scrollPane.setPreferredSize(new Dimension(300, 300));
	
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
			
			        // Solicitar la sede al usuario mediante un cuadro de diálogo de entrada
			        String sedeSeleccionada = JOptionPane.showInputDialog(this, "Ingrese la sede:", "Seleccionar Sede", JOptionPane.QUESTION_MESSAGE);
			
			        if (sedeSeleccionada == null) {
			            // El usuario canceló la operación
			            // Puedes manejar esto según tus necesidades
			            return;
			        }
			
			        // Contenido del panel "Administrar mi información"
			        JLabel label = new JLabel("Información de los empleados - Sede: " + sedeSeleccionada);
			        label.setHorizontalAlignment(JLabel.CENTER);
			        label.setFont(new Font("Arial", Font.BOLD, 24));
			        label.setBorder(new EmptyBorder(10, 10, 10, 10));
			        add(label, gbc);
			        gbc.gridy++;
			
			        List<String> informacionSede = Empleado.mostrarEmpleadossede(sedeSeleccionada);
			
			        // Crear etiquetas para mostrar la información
			        JPanel innerPanel = new JPanel(new GridBagLayout());
			        GridBagConstraints gbc1 = new GridBagConstraints();
			        for (String atributo : informacionSede) {
			            JLabel infoLabel = new JLabel(atributo);
			            infoLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
			            innerPanel.add(infoLabel, gbc1);
			            gbc1.gridy++;
			        }
			
			        JScrollPane scrollPane = new JScrollPane(innerPanel);
			        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			        scrollPane.setPreferredSize(new Dimension(300, 300));
			
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
	     JLabel label = new JLabel("Gestionar Vehiculos");
	     label.setHorizontalAlignment(JLabel.CENTER);
	     label.setFont(new Font("Arial", Font.BOLD, 24));
	     label.setBorder(new EmptyBorder(10, 10, 10, 10));
	
	     JButton verReservasButton = new JButton("Ver vehiculos de las sedes");
	     personalizarBoton(verReservasButton);
	
	     verReservasButton.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	             // Abre una nueva pestaña para ver las reservas
	             openNewTab(new VerVehiculosPanel(), "Ver vehiculos sedes");
	         }
	     });
	     JButton cambiarinfoemplados = new JButton("Asignar vehiculos a sedes");
	     personalizarBoton(cambiarinfoemplados);
	
	     cambiarinfoemplados.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	             // Abre una nueva pestaña para cancelar las reservas
	             openNewTab(new AsignarVehiculosPanel(), "Asignar vehiculos a sedes");
	         }
	     });
	     // Agrega los componentes al panel con GridLayout
	     JPanel botonesPaneln = new JPanel();
	     botonesPaneln.add(verReservasButton);
	     botonesPaneln.add(cambiarinfoemplados);
	     
	     JButton AgregarButton = new JButton("Agregar vehiculos ");
	     personalizarBoton(AgregarButton);
	
	     AgregarButton.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	             // Abre una nueva pestaña para ver las reservas
	             openNewTab(new AgregarVehiculosPanel(), "Agregar vehiculos ");
	         }
	     });
	     JButton EliminarepleadosButton = new JButton("Eliminar vehiculos");
	     personalizarBoton(EliminarepleadosButton);
	
	     EliminarepleadosButton.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	             // Abre una nueva pestaña para cancelar las reservas
	             openNewTab(new EliminarVehiculosPanel(), "Eliminar vehiculos");
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
			public class VerVehiculosPanel extends JPanel {
	
	        public VerVehiculosPanel() {
	        	setLayout(new GridBagLayout());
				
		        // Crear etiquetas para mostrar la información
		        GridBagConstraints gbc = new GridBagConstraints();
		        gbc.gridx = 0;
		        gbc.gridy = 0;
		        gbc.anchor = GridBagConstraints.WEST;
		
		        // Solicitar la sede al usuario mediante un cuadro de diálogo de entrada
		        String sedeSeleccionada = JOptionPane.showInputDialog(this, "Ingrese la sede:", "Seleccionar Sede", JOptionPane.QUESTION_MESSAGE);
		
		        if (sedeSeleccionada == null) {
		            // El usuario canceló la operación
		            // Puedes manejar esto según tus necesidades
		            return;
		        }
		
		        // Contenido del panel "Administrar mi información"
		        JLabel label = new JLabel("Información de los vehiculos - Sede: " + sedeSeleccionada);
		        label.setHorizontalAlignment(JLabel.CENTER);
		        label.setFont(new Font("Arial", Font.BOLD, 24));
		        label.setBorder(new EmptyBorder(10, 10, 10, 10));
		        add(label, gbc);
		        gbc.gridy++;
		
		        List<List<String>> informacionSede = Vehiculo.verVehiculosSede(sedeSeleccionada);
		
		        // Crear etiquetas para mostrar la información
		        JPanel innerPanel = new JPanel(new GridBagLayout());
		        GridBagConstraints gbc1 = new GridBagConstraints();
		        for (List<String> reservaInfo : informacionSede) {
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
		        scrollPane.setPreferredSize(new Dimension(300, 300));
		
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
			public class AsignarVehiculosPanel extends JPanel {
		
		        public AsignarVehiculosPanel() {
		            setLayout(new BorderLayout());
		
		            // Crear componentes para el panel "Asignar vehículos a sedes"
		            JLabel label = new JLabel("Asignar vehículos a sedes");
		            label.setFont(new Font("Arial", Font.BOLD, 20));
		            label.setHorizontalAlignment(SwingConstants.CENTER);
		            add(label, BorderLayout.NORTH);
		
		            // Crear campos de texto y otros componentes según tus necesidades
		            JTextField placaTextField = new JTextField();
		            JTextField sedeTextField = new JTextField();
		            JButton asignarButton = new JButton("Asignar Vehículo");
		
		            // Agregar componentes al panel
		            JPanel inputPanel = new JPanel(new GridLayout(3, 2));
		            inputPanel.add(new JLabel("Placa del vehículo:"));
		            inputPanel.add(placaTextField);
		            inputPanel.add(new JLabel("Sede a la que asignar:"));
		            inputPanel.add(sedeTextField);
		            inputPanel.add(new JLabel(""));
		            inputPanel.add(asignarButton);
		
		            add(inputPanel, BorderLayout.CENTER);
		
		            // Agregar ActionListener para el botón
		            asignarButton.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    String placaVehiculoAsignar = placaTextField.getText();
		                    String nuevaSedeAsignar = sedeTextField.getText();
		                    Vehiculo.asignarVehiculoASede(placaVehiculoAsignar, nuevaSedeAsignar);
		                    JOptionPane.showMessageDialog(null, "Vehículo asignado a sede con éxito.");
		                }
		            });
		        }
		    }
		
		    //Falta cuestinoario
		    @SuppressWarnings("serial")
			public class AgregarVehiculosPanel extends JPanel {
		
		        public AgregarVehiculosPanel() {
		            setLayout(new BorderLayout());
		
		            // Crear componentes para el panel "Agregar vehículos"
		            JLabel label = new JLabel("Agregar nuevo vehículo");
		            label.setFont(new Font("Arial", Font.BOLD, 20));
		            label.setHorizontalAlignment(SwingConstants.CENTER);
		            add(label, BorderLayout.NORTH);
		
		            // Crear campos de texto y otros componentes según tus necesidades
		            JTextField placaTextField = new JTextField();
		            JTextField marcaTextField = new JTextField();
		            // ... (agregar más campos según sea necesario)
		            JButton agregarButton = new JButton("Agregar Vehículo");
		
		            // Agregar componentes al panel
		            JPanel inputPanel = new JPanel(new GridLayout(4, 2));
		            inputPanel.add(new JLabel("Placa:"));
		            inputPanel.add(placaTextField);
		            inputPanel.add(new JLabel("Marca:"));
		            inputPanel.add(marcaTextField);
		            // ... (agregar más campos según sea necesario)
		            inputPanel.add(new JLabel(""));
		            inputPanel.add(agregarButton);
		
		            add(inputPanel, BorderLayout.CENTER);
		
		            // Agregar ActionListener para el botón
		            agregarButton.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    String placa = placaTextField.getText();
		                    String marca = marcaTextField.getText();
		                    // ... (obtener valores de otros campos según sea necesario)
		
		                    // Crear un nuevo objeto Vehiculo y agregarlo a la lista
		                    //Vehiculo.agregarVehiculo(placa, marca /*otros valores*/);
		                    JOptionPane.showMessageDialog(null, "Vehículo agregado con éxito.");
		                }
		            });
		        }
		    }
		
		    @SuppressWarnings("serial")
			public class EliminarVehiculosPanel extends JPanel {
		
		        public EliminarVehiculosPanel() {
		        	setLayout(new BorderLayout());
		            setBackground(Color.white);
		            // Contenido del panel "Cancelar Reservas"
		            JLabel label = new JLabel("Ingrese la placa del vehiculo a eliminar:");
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
		            JButton cancelarButton = new JButton("Eliminar vehiculo");
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
		                	Vehiculo.eliminarVehiculo(usernameField.getText());
		                    
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
	public class GestionarCategoriasPanel extends JPanel {
	    
		public GestionarCategoriasPanel() {
			setLayout(new BorderLayout());
			
	        // Contenido del panel de Gestionar Reservas
	        JLabel label = new JLabel("Gestionar Categorias");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));
	        label.setBorder(new EmptyBorder(10, 10, 10, 10));
	
	        JButton verReservasButton = new JButton("Ver informacion de las categorias de la sede");
	        personalizarBoton(verReservasButton);
	
	        verReservasButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para ver las reservas
	                openNewTab(new VerCategoriasPanel(), "Ver información categorias");
	            }
	        });
	        JButton cambiarinfoemplados = new JButton("Cambiar Información de las categorias");
	        personalizarBoton(cambiarinfoemplados);
	
	        cambiarinfoemplados.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para cancelar las reservas
	                openNewTab(new CambiarCategoriasPanel(), "Cambiar info categorias");
	            }
	        });
	        // Agrega los componentes al panel con GridLayout
	        JPanel botonesPaneln = new JPanel();
	        botonesPaneln.add(verReservasButton);
	        botonesPaneln.add(cambiarinfoemplados);
	        
	        JButton AgregarButton = new JButton("Agregar categorias ");
	        personalizarBoton(AgregarButton);
	
	        AgregarButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para ver las reservas
	                openNewTab(new AgregarCategoriasPanel(), "Agregar categorias ");
	            }
	        });
	        JButton EliminarepleadosButton = new JButton("Eliminar categorias");
	        personalizarBoton(EliminarepleadosButton);
	
	        EliminarepleadosButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para cancelar las reservas
	                openNewTab(new EliminarCategoriasPanel(), "Eliminar seguros");
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
			public class VerCategoriasPanel extends JPanel {
		
			    public VerCategoriasPanel() {
			        setLayout(new GridBagLayout());
		
			        // Crear etiquetas para mostrar la información
			        GridBagConstraints gbc = new GridBagConstraints();
			        gbc.gridx = 0;
			        gbc.gridy = 0;
			        gbc.anchor = GridBagConstraints.WEST;
		
			        // Contenido del panel "Administrar mi información"
			        JLabel label = new JLabel("Información de las categorías de vehículos disponibles:");
			        label.setHorizontalAlignment(JLabel.CENTER);
			        label.setFont(new Font("Arial", Font.BOLD, 24));
			        label.setBorder(new EmptyBorder(10, 10, 10, 10));
			        add(label, gbc);
			        gbc.gridy++;
		
			        List<List<String>> informacionCategorias = Categoria_vehiculo.obtenerInformacionCategorias();

				     // Crear etiquetas para mostrar la información
				     JPanel innerPanel = new JPanel(new GridBagLayout());
				     GridBagConstraints gbc1 = new GridBagConstraints();
	
				     for (List<String> categoriaInfo : informacionCategorias) {
				         for (String atributo : categoriaInfo) {
				             JLabel infoLabel = new JLabel(atributo);
				             infoLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
				             innerPanel.add(infoLabel, gbc1);
				             gbc1.gridy++;
				         }
				     }

		
			        JScrollPane scrollPane = new JScrollPane(innerPanel);
			        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			        scrollPane.setPreferredSize(new Dimension(300, 300));
		
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
			    }
			}
		
			@SuppressWarnings("serial")
			public class AgregarCategoriasPanel extends JPanel {
		
			    public AgregarCategoriasPanel() {
			        setLayout(new BorderLayout());
			        setBackground(Color.white);
			        // Contenido del panel "Agregar Categorías"
			        JLabel label = new JLabel("Agregar nueva categoría de vehículo:");
			        label.setHorizontalAlignment(JLabel.CENTER);
			        label.setFont(new Font("Arial", Font.BOLD, 24));
			        label.setBackground(Color.white);
			        label.setBorder(new MatteBorder(100, 10, 100, 10, Color.WHITE));
		
			        // Campos para agregar una nueva categoría
			        JTextField nombreField = new JTextField();
			        JTextField descripcionField = new JTextField();
			        JTextField tarifaDiariaField = new JTextField();
		
			        // ...
		
			        // Botón para agregar la nueva categoría
			        JButton agregarButton = new JButton("Agregar Categoría");
			        agregarButton.setBackground(Color.BLACK);
			        agregarButton.setForeground(Color.WHITE);
			        agregarButton.setPreferredSize(new Dimension(300, 60));
			        agregarButton.setFont(new Font("Arial", Font.BOLD, 16));
		
			        agregarButton.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			                // Obtener los valores de los campos y agregar la categoría
			                String nombre = nombreField.getText();
			                String descripcion = descripcionField.getText();
			                double tarifaDiaria = Double.parseDouble(tarifaDiariaField.getText());
		
			                Categoria_vehiculo.agregarCategoria(nombre, descripcion, tarifaDiaria);
		
			                // Limpiar los campos después de agregar la categoría
			                nombreField.setText("");
			                descripcionField.setText("");
			                tarifaDiariaField.setText("");
			            }
			        });
		
			        // ...
		
			        // Agrega los componentes al panel
			        add(label, BorderLayout.NORTH);
		
			        JPanel formPanel = new JPanel(new GridLayout(3, 2));
			        formPanel.setBackground(Color.WHITE);
			        formPanel.add(new JLabel("Nombre: "));
			        formPanel.add(nombreField);
			        formPanel.add(new JLabel("Descripción: "));
			        formPanel.add(descripcionField);
			        formPanel.add(new JLabel("Tarifa Diaria: "));
			        formPanel.add(tarifaDiariaField);
		
			        add(formPanel, BorderLayout.CENTER);
			        add(agregarButton, BorderLayout.SOUTH);
			    }
			}
		
			@SuppressWarnings("serial")
			public class EliminarCategoriasPanel extends JPanel {
		
			    public EliminarCategoriasPanel() {
			    	setLayout(new BorderLayout());
		            setBackground(Color.white);
		            // Contenido del panel "Cancelar Reservas"
		            JLabel label = new JLabel("Ingrese l nombre de la categoria a eliminar");
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
		            JButton cancelarButton = new JButton("Eliminar categoria");
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
		                	Categoria_vehiculo.eliminarCategoria(usernameField.getText());
		                    
		                    usernameField.setText(null);
		                }
		            });

		            
		            
		            // Agrega los componentes al panel
		            add(label, BorderLayout.NORTH);
		            add(userPanel, BorderLayout.CENTER);
		            add(innerPanel, BorderLayout.SOUTH);
		        }
		    }
		
			// Falta formulario para cambiar la información de las categorías
			@SuppressWarnings("serial")
			public class CambiarCategoriasPanel extends JPanel {
		
			    public CambiarCategoriasPanel() {
			        setLayout(new BorderLayout());
			        setBackground(Color.white);
			        // Contenido del panel "Cambiar Categorías"
			        JLabel label = new JLabel("Ingrese el nombre de la categoría de vehículo a modificar:");
			        label.setHorizontalAlignment(JLabel.CENTER);
			        label.setFont(new Font("Arial", Font.BOLD, 24));
			        label.setBackground(Color.white);
			        label.setBorder(new MatteBorder(100, 10, 100, 10, Color.WHITE));
		
			        // Campo para ingresar el nombre de la categoría a modificar
			        JTextField nombreField = new JTextField();
			        nombreField.setPreferredSize(new Dimension(600, 85));
			        nombreField.setBorder(new MatteBorder(10, 10, 10, 10, Color.WHITE));
			        nombreField.setOpaque(true);
			        nombreField.setBackground(Color.LIGHT_GRAY);
		
			        Font nombreFieldfont = nombreField.getFont();
			        Font newTextFieldFont = new Font(nombreFieldfont.getName(), nombreFieldfont.getStyle(), 16); // Ajusta el tamaño según sea necesario
			        nombreField.setFont(newTextFieldFont);
		
			        // ...
		
			        // Botón para cambiar la información de la categoría
			        JButton cambiarButton = new JButton("Cambiar Información");
			        cambiarButton.setBackground(Color.BLACK);
			        cambiarButton.setForeground(Color.WHITE);
			        cambiarButton.setPreferredSize(new Dimension(300, 60));
			        cambiarButton.setFont(new Font("Arial", Font.BOLD, 16));
		
			        cambiarButton.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			                // Obtener el nombre de la categoría a modificar y realizar los cambios
			                String nombreCategoriaModificar = nombreField.getText();
		
			                // Obtener los nuevos valores de los campos y modificar la categoría
			                // ...
		
			                // Limpiar los campos después de cambiar la información de la categoría
			                nombreField.setText("");
			            }
			        });
		
			        // ...
		
			        // Agrega los componentes al panel
			        add(label, BorderLayout.NORTH);
			        add(nombreField, BorderLayout.CENTER);
			        add(cambiarButton, BorderLayout.SOUTH);
			    }
			}

	
	@SuppressWarnings("serial")
	public class PanelSeguros extends JPanel {
	   
	
	    public PanelSeguros() {
	    	setLayout(new BorderLayout());
	
	        // Contenido del panel de Gestionar Reservas
	        JLabel label = new JLabel("Gestionar Seguros");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));
	        label.setBorder(new EmptyBorder(10, 10, 10, 10));
	
	        JButton verReservasButton = new JButton("Ver informacion de los Seguros");
	        personalizarBoton(verReservasButton);
	
	        verReservasButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para ver las reservas
	                openNewTab(new VerSegurosPanel(), "Ver información seguros");
	            }
	        });
	        JButton cambiarinfoemplados = new JButton("Cambiar Información de los Seguros");
	        personalizarBoton(cambiarinfoemplados);
	
	        cambiarinfoemplados.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para cancelar las reservas
	                openNewTab(new CambiarSegurosPanel(), "Cambiar info seguros");
	            }
	        });
	        // Agrega los componentes al panel con GridLayout
	        JPanel botonesPaneln = new JPanel();
	        botonesPaneln.add(verReservasButton);
	        botonesPaneln.add(cambiarinfoemplados);
	        
	        JButton AgregarButton = new JButton("Agregar seguros ");
	        personalizarBoton(AgregarButton);
	
	        AgregarButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para ver las reservas
	                openNewTab(new AgregarSegurosPanel(), "Agregar seguros ");
	            }
	        });
	        JButton EliminarepleadosButton = new JButton("Eliminar seguros");
	        personalizarBoton(EliminarepleadosButton);
	
	        EliminarepleadosButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Abre una nueva pestaña para cancelar las reservas
	                openNewTab(new EliminarSegurosPanel(), "Eliminar seguros");
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
			public class VerSegurosPanel extends JPanel {
			
			    public VerSegurosPanel() {
			        setLayout(new GridBagLayout());
			
			        // Crear etiquetas para mostrar la información
			        GridBagConstraints gbc = new GridBagConstraints();
			        gbc.gridx = 0;
			        gbc.gridy = 0;
			        gbc.anchor = GridBagConstraints.WEST;
			
			        // Solicitar la sede al usuario mediante un cuadro de diálogo de entrada
			       
			
			        // Contenido del panel "Administrar mi información"
			        JLabel label = new JLabel("Información de los seguros disponibles: " );
			        label.setHorizontalAlignment(JLabel.CENTER);
			        label.setFont(new Font("Arial", Font.BOLD, 24));
			        label.setBorder(new EmptyBorder(10, 10, 10, 10));
			        add(label, gbc);
			        gbc.gridy++;
			
			        List<List<String>> informacionSeguros = Seguro.obtenerInformacionSeguros();
			
			        // Crear etiquetas para mostrar la información
			        JPanel innerPanel = new JPanel(new GridBagLayout());
			        GridBagConstraints gbc1 = new GridBagConstraints();

			        for (List<String> infoSeguro : informacionSeguros) {
			            for (String atributo : infoSeguro) {
			                JLabel infoLabel = new JLabel(atributo);
			                infoLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
			                innerPanel.add(infoLabel, gbc1);
			                gbc1.gridy++;
			            }
			        }
			        
			
			        JScrollPane scrollPane = new JScrollPane(innerPanel);
			        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			        scrollPane.setPreferredSize(new Dimension(300, 300));
			
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
			
			//Falta formulario para agregar seguros
			@SuppressWarnings("serial")
			public class AgregarSegurosPanel extends JPanel {
			
			    public AgregarSegurosPanel() {
			        setLayout(new BorderLayout());
			        setBackground(Color.white);
			        // Contenido del panel "Agregar Seguros"
			        JLabel label = new JLabel("Agregar nuevo seguro:");
			        label.setHorizontalAlignment(JLabel.CENTER);
			        label.setFont(new Font("Arial", Font.BOLD, 24));
			        label.setBackground(Color.white);
			        label.setBorder(new MatteBorder(100, 10, 100, 10, Color.WHITE));
			
			        // Campos para agregar un nuevo seguro
			        JTextField nombreField = new JTextField();
			        JTextField descripcionField = new JTextField();
			        JTextField precioField = new JTextField();
			
			        // ...
			
			        // Botón para agregar el nuevo seguro
			        JButton agregarButton = new JButton("Agregar Seguro");
			        agregarButton.setBackground(Color.BLACK);
			        agregarButton.setForeground(Color.WHITE);
			        agregarButton.setPreferredSize(new Dimension(300, 60));
			        agregarButton.setFont(new Font("Arial", Font.BOLD, 16));
			
			        agregarButton.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			                // Obtener los valores de los campos y agregar el seguro
			                String nombre = nombreField.getText();
			                String descripcion = descripcionField.getText();
			                double precio = Double.parseDouble(precioField.getText());
			
			                Seguro.agregarSeguro(nombre, descripcion, precio);
			
			                // Limpiar los campos después de agregar el seguro
			                nombreField.setText("");
			                descripcionField.setText("");
			                precioField.setText("");
			            }
			        });
			
			        // ...
			
			        // Agrega los componentes al panel
			        add(label, BorderLayout.NORTH);
			
			        JPanel formPanel = new JPanel(new GridLayout(3, 2));
			        formPanel.setBackground(Color.WHITE);
			        formPanel.add(new JLabel("Nombre: "));
			        formPanel.add(nombreField);
			        formPanel.add(new JLabel("Descripción: "));
			        formPanel.add(descripcionField);
			        formPanel.add(new JLabel("Precio por día: "));
			        formPanel.add(precioField);
			
			        add(formPanel, BorderLayout.CENTER);
			        add(agregarButton, BorderLayout.SOUTH);
			    }
			}
			
			@SuppressWarnings("serial")
			public class EliminarSegurosPanel extends JPanel {
			
			    public EliminarSegurosPanel() {
			    	setLayout(new BorderLayout());
		            setBackground(Color.white);
		            // Contenido del panel "Cancelar Reservas"
		            JLabel label = new JLabel("Ingrese el nombre del seguro a eliminar:");
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
		            JButton cancelarButton = new JButton("Eliminar seguro");
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
		                	Seguro.eliminarSeguro(usernameField.getText());
		                	
		                    
		                    usernameField.setText(null);
		                }
		            });

		            
		            
		            // Agrega los componentes al panel
		            add(label, BorderLayout.NORTH);
		            add(userPanel, BorderLayout.CENTER);
		            add(innerPanel, BorderLayout.SOUTH);
		        }
		    }
		
			//Falta formulario para cambiar la información de los seguros
			@SuppressWarnings("serial")
			public class CambiarSegurosPanel extends JPanel {
			
			    public CambiarSegurosPanel() {
			        setLayout(new BorderLayout());
			        setBackground(Color.white);
			        // Contenido del panel "Cambiar Seguros"
			        JLabel label = new JLabel("Ingrese el nombre del seguro a modificar:");
			        label.setHorizontalAlignment(JLabel.CENTER);
			        label.setFont(new Font("Arial", Font.BOLD, 24));
			        label.setBackground(Color.white);
			        label.setBorder(new MatteBorder(100, 10, 100, 10, Color.WHITE));
			
			        // Campo para ingresar el nombre del seguro a modificar
			        JTextField nombreField = new JTextField();
			        nombreField.setPreferredSize(new Dimension(600, 85));
			        nombreField.setBorder(new MatteBorder(10, 10, 10, 10, Color.WHITE));
			        nombreField.setOpaque(true);
			        nombreField.setBackground(Color.LIGHT_GRAY);
			
			        Font nombreFieldfont = nombreField.getFont();
			        Font newTextFieldFont = new Font(nombreFieldfont.getName(), nombreFieldfont.getStyle(), 16); // Ajusta el tamaño según sea necesario
			        nombreField.setFont(newTextFieldFont);
			
			        // ...
			
			        // Botón para cambiar la información del seguro
			        JButton cambiarButton = new JButton("Cambiar Información");
			        cambiarButton.setBackground(Color.BLACK);
			        cambiarButton.setForeground(Color.WHITE);
			        cambiarButton.setPreferredSize(new Dimension(300, 60));
			        cambiarButton.setFont(new Font("Arial", Font.BOLD, 16));
			
			        cambiarButton.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			                // Obtener el nombre del seguro a modificar y realizar los cambios
			                String nombreSeguroModificar = nombreField.getText();
			
			                // Obtener los nuevos valores de los campos y modificar el seguro
			                // ...
			
			                // Limpiar los campos después de cambiar la información del seguro
			                nombreField.setText("");
			            }
			        });
			
			        // ...
			
			        // Agrega los componentes al panel
			        add(label, BorderLayout.NORTH);
			        add(nombreField, BorderLayout.CENTER);
			        add(cambiarButton, BorderLayout.SOUTH);
			    }
			}

		
	
	@SuppressWarnings("serial")
	public class GestionarReservasPanel extends JPanel {
	
	    public GestionarReservasPanel() {
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
	
	        List<List<String>> informacionReservas = Empresa.obtenerInformacionReservas();
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
	        scrollPane.setPreferredSize(new Dimension(200, 200));
	
	        // Agrega el JScrollPane al panel principal
	        add(scrollPane, gbc);
	        gbc.gridy++;
	
	        // Agregar una imagen (reemplaza "path/to/your/image.png" con la ruta real de tu imagen)
	        ImageIcon imageIcon = new ImageIcon("./RecursosInterfaz/carroNegro.png");
	        Image scaledImage3 = imageIcon.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH);
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
	    }
	}
	

	public static void main(String[] args) {
		//Valores provisionales
		
	    AdminGeneral_i adminGeneral = new AdminGeneral_i();
		adminGeneral.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		adminGeneral.setVisible(true);
	}
    }





