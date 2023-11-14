package interfaz_grafica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminLocal_i extends JFrame {
	private static final long serialVersionUID = 1L;
	public AdminLocal_i() {
		//Nueva pestaña
        super("AdminLocal");
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
        Funciones.agregarImagenABoton(boton1, "RecursosInterfaz\\BotonAdminInfoSede.png");
        Panelb1.add(boton1);
        
        // Botón 2
        JButton boton2 = new JButton();
        boton2.setBackground(Color.WHITE);
        boton2.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton2, "RecursosInterfaz\\BotonAdminEmpleadosSede.png");
        Panelb1.add(boton2);
        
        botonesPanel.add(Panelb1, gbc);
        gbc.gridy++;
        
        JPanel Panelb2 = new JPanel();
        Panelb2.setBackground(Color.WHITE);
        // Botón 3
        JButton boton3 = new JButton();
        boton3.setBackground(Color.WHITE);
        boton3.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton3, "RecursosInterfaz\\BotonAdministrarautosSede.png");
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
                openNewTab(new AdminEmpleadosSede(), "Administrar Empleados");
            }
        });

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña con AdministrarAutosSede
                openNewTab(new AdministrarAutosSede(), "Administrar Autos");
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
	
	public void AdminInfoSedes() {
        setLayout(new BorderLayout());

        // Panel con información de sedes (reemplaza esto con tu lógica real)
        JLabel infoLabel = new JLabel("Información de sedes:");
        add(infoLabel, BorderLayout.CENTER);

        // Botón de regreso
        JButton backButton = new JButton("Volver");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción al hacer clic en "Volver"
                setVisible(false); // Oculta este panel
                // Agrega aquí la lógica para volver al panel central original o hacer cualquier otra acción necesaria
            }
        });
        add(backButton, BorderLayout.SOUTH);
    }
	
	;

	       
	    

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

	    
	
	public static void main(String[] args) {
		//Valores provisionales
		
		AdminLocal_i AdminLocal = new AdminLocal_i();
		AdminLocal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		AdminLocal.setVisible(true);
	}
    }





