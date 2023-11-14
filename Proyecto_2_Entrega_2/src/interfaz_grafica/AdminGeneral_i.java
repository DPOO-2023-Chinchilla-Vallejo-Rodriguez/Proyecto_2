package interfaz_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGeneral_i extends JFrame {
	private static final long serialVersionUID = 1L;
	public AdminGeneral_i() {
		//Nueva pestaña
        super("AdminGeneral");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Crear el panel izquierdo (menú)
        JPanel menuPanel = Funciones.createMenuPanel();

        // Panel central
        JPanel centralPanel = new JPanel(new BorderLayout());
        centralPanel.setBackground(Color.WHITE);

        JPanel topPanel = Funciones.crearPanelConFondo("RecursosInterfaz\\UsuarioPanel.png", 700, 300);
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
        Funciones.agregarImagenABoton(boton1, "RecursosInterfaz\\BotonAdminInfoSedes.png");
        Panelb1.add(boton1);
        
        // Botón 2
        JButton boton2 = new JButton();
        boton2.setBackground(Color.WHITE);
        boton2.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton2, "RecursosInterfaz\\BotonAdminEmpleadosSedes.png");
        Panelb1.add(boton2);
        
        botonesPanel.add(Panelb1, gbc);
        gbc.gridy++;
        
        JPanel Panelb2 = new JPanel();
        Panelb2.setBackground(Color.WHITE);
        // Botón 3
        JButton boton3 = new JButton();
        boton3.setBackground(Color.WHITE);
        boton3.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton3, "RecursosInterfaz\\BotonAdminautosSedes.png");
        Panelb2.add(boton3);
        
        
        // Botón 4
        JButton boton4 = new JButton();
        boton4.setBackground(Color.WHITE);
        boton4.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton4, "RecursosInterfaz\\BotonGestionarSeguros.png");
        Panelb2.add(boton4);
        
        botonesPanel.add(Panelb2, gbc);
        gbc.gridy++;

        JPanel Panelb3 = new JPanel();
        Panelb3.setBackground(Color.WHITE);
        // Botón 5
        JButton boton5 = new JButton();
        boton5.setBackground(Color.WHITE);
        boton5.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton5, "RecursosInterfaz\\BotongestionarCategorias.png");
        Panelb3.add(boton5);
        
        
        // Botón 6
        JButton boton6 = new JButton();
        boton6.setBackground(Color.WHITE);
        boton6.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton6, "RecursosInterfaz\\BotonGestionarReservas.png");
        Panelb3.add(boton6);
        
        botonesPanel.add(Panelb3, gbc);
        gbc.gridy++;
        
        // Agrega los botones al panel central
        centralPanel.add(topPanel, BorderLayout.NORTH);
        centralPanel.add(botonesPanel, BorderLayout.CENTER);

        //Listas provisional 
        
        // Panel con la grafica de disponibilidad de autos
        //JPanel derechaPanel = Funciones.visualizaciondealtonivel( );
 
        // Agrega los paneles al JFrame
        add(menuPanel, BorderLayout.WEST);
        add(graficaScrollPanel, BorderLayout.CENTER);
       // add(derechaPanel, BorderLayout.EAST);
        
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
                openNewTab(new AdminEmpleadosSede(), "Administrar Empleados");
            }
        });

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña con AdministrarAutosSedes
                openNewTab(new AdminInfoSedes(), "Administrar Autos");
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
	
	public class PanelSeguros extends JPanel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public PanelSeguros() {
	        setLayout(new BorderLayout());

	        JLabel mensajeLabel = new JLabel("Hola");
	        mensajeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	        mensajeLabel.setHorizontalAlignment(JLabel.CENTER);

	        add(mensajeLabel, BorderLayout.CENTER);
	    }
	}
	
	public class AdminInfoSedes extends JPanel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public AdminInfoSedes() {
	        setLayout(new BorderLayout());

	        // Etiqueta con el nombre del panel
	        JLabel nameLabel = new JLabel("Administrar Sedes");
	        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
	        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        add(nameLabel, BorderLayout.CENTER);

	        // Contenido adicional del panel (puedes agregar tu lógica aquí)
	    }
	}
	
	public class AdminEmpleadosSede extends JPanel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public AdminEmpleadosSede() {
	        setLayout(new BorderLayout());

	        // Etiqueta con el nombre del panel
	        JLabel nameLabel = new JLabel("Administrar Empleados");
	        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
	        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        add(nameLabel, BorderLayout.CENTER);

	        // Contenido adicional del panel (puedes agregar tu lógica aquí)
	    }
	}
	
	
	public class AdministrarAutosSede extends JPanel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public AdministrarAutosSede() {
	        setLayout(new BorderLayout());

	        // Etiqueta con el nombre del panel
	        JLabel nameLabel = new JLabel("Administrar Autos");
	        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
	        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        add(nameLabel, BorderLayout.CENTER);

	        // Contenido adicional del panel (puedes agregar tu lógica aquí)
	    }
	}
	
	public class GestionarCategoriasPanel extends JPanel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public GestionarCategoriasPanel() {
	        // Implementa la lógica y la interfaz gráfica para gestionar categorías
	        JLabel label = new JLabel("Gestionar Categorías");
	        add(label);
	    }
	}

	// Clase para el panel de Gestionar Reservas
	public class GestionarReservasPanel extends JPanel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public GestionarReservasPanel() {
	        // Implementa la lógica y la interfaz gráfica para gestionar reservas
	        JLabel label = new JLabel("Gestionar Reservas");
	        add(label);
	    }
	}
	
	public static void main(String[] args) {
		//Valores provisionales
		
	    AdminGeneral_i adminGeneral = new AdminGeneral_i();
		adminGeneral.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		adminGeneral.setVisible(true);
	}
    }





