package interfaz_grafica;

import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Empleado_i extends JFrame {

	private static final long serialVersionUID = 1L;
	public Empleado_i() {
		//Nueva pestaña
        super("Empleado");
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
        Funciones.agregarImagenABoton(boton1, "RecursosInterfaz\\BotonGestionaralquileres.png");
        Panelb1.add(boton1);

        // Botón 2
        JButton boton2 = new JButton();
        boton2.setBackground(Color.WHITE);
        boton2.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton2, "RecursosInterfaz\\BotonActualizarautos.png");
        Panelb1.add(boton2);
        
        botonesPanel.add(Panelb1, gbc);
        gbc.gridy++;
        
        JPanel Panelb2 = new JPanel();
        Panelb2.setBackground(Color.WHITE);
        
        // Botón 3
        JButton boton3 = new JButton();
        boton3.setBackground(Color.WHITE);
        boton3.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton3, "./RecursosInterfaz\\Botongestionarusuarios.png");
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
                openNewTab(new AdminGestionAlquileres(), "Gestionar Alquileres");
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
	
	public class AdminGestionAlquileres extends JPanel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public AdminGestionAlquileres() {
	        // Configura el panel con la lógica para gestionar alquileres
	        setLayout(new BorderLayout());

	        // Etiqueta con el nombre del panel
	        JLabel nameLabel = new JLabel("Gestionar Alquileres");
	        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
	        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        add(nameLabel, BorderLayout.NORTH);

	        // Agrega aquí la lógica específica para gestionar alquileres
	        // ...

	        // Botón de regreso
	        JButton backButton = new JButton("Volver");
	        backButton.addActionListener(e -> {
	            // Acción al hacer clic en "Volver"
	            getParent().remove(this); // Remueve este panel
	        });
	        add(backButton, BorderLayout.SOUTH);
	    }
	}
	
	
	public class AdminActualizarAutos extends JPanel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public AdminActualizarAutos() {
	        // Configura el panel con la lógica para actualizar autos
	        setLayout(new BorderLayout());

	        // Etiqueta con el nombre del panel
	        JLabel nameLabel = new JLabel("Actualizar Autos");
	        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
	        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        add(nameLabel, BorderLayout.NORTH);

	        // Agrega aquí la lógica específica para actualizar autos
	        // ...

	        // Botón de regreso
	        JButton backButton = new JButton("Volver");
	        backButton.addActionListener(e -> {
	            // Acción al hacer clic en "Volver"
	            getParent().remove(this); // Remueve este panel
	        });
	        add(backButton, BorderLayout.SOUTH);
	    }
	}
	
	public class Adminusuarios extends JPanel {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Adminusuarios() {
	        setLayout(new BorderLayout());

	        // Contenido del panel "Administrar mi información"
	        JLabel label = new JLabel("Administrar mi información");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));

	        JButton backButton = new JButton("Volver");
	        backButton.addActionListener(e -> {
	            // Acción al hacer clic en "Volver"
	            setVisible(false); // Oculta este panel
	            // Agrega aquí la lógica para volver a la interfaz anterior o realizar cualquier otra acción necesaria
	        });

	        // Agrega los componentes al panel
	        add(label, BorderLayout.CENTER);
	        add(backButton, BorderLayout.SOUTH);
	    }
	}
		
	public static void main(String[] args) {
		//Valores provisionales
	    Empleado_i empleado = new Empleado_i();
		empleado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    empleado.setVisible(true);
	}
    }



