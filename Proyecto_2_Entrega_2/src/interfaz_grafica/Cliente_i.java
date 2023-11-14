package interfaz_grafica;

import javax.swing.*;

import Reservas_modelo.Usuario;

import reservas_consola.Sistema;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Cliente_i extends JFrame {

	private static final long serialVersionUID = 1L;
	public Cliente_i() {
		//Nueva pestaña
        super("Cliente");
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
        Funciones.agregarImagenABoton(boton1, "RecursosInterfaz\\BotonReservar.png");
        Panelb1.add(boton1);

        // Botón 2
        JButton boton2 = new JButton();
        boton2.setBackground(Color.WHITE);
        boton2.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton2, "RecursosInterfaz\\BotonGestionarReservas.png");
        Panelb1.add(boton2);
        
        botonesPanel.add(Panelb1, gbc);
        gbc.gridy++;
        
        JPanel Panelb2 = new JPanel();
        Panelb2.setBackground(Color.WHITE);
        
        // Botón 3
        JButton boton3 = new JButton();
        boton3.setBackground(Color.WHITE);
        boton3.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton3, "RecursosInterfaz\\BotonverMiInfo.png");
        Panelb2.add(boton3);
        
        
        // Botón 4
        JButton boton4 = new JButton();
        boton4.setBackground(Color.WHITE);
        boton4.setBorderPainted(false);
        Funciones.agregarImagenABoton(boton4, "RecursosInterfaz\\BotonModificarMiInfo.png");
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
            	
            	openNewTab(new ReservarPanel(), "Formulario de reserva");
            	
         
            	
            }
        });

        // Listener para el botón 2 (Gestionar Reservas)
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre una nueva pestaña con la funcionalidad correspondiente a Gestionar Reservas
                openNewTab(new GestionarReservasPanel(), "Gestionar Reservas");
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
	

	public class ReservarPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReservarPanel() {
		
		
		
        setLayout(new BorderLayout());

        // Contenido del panel de Reservar
        JLabel label = new JLabel("Panel de Reservar");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));

        JButton backButton = new JButton("Volver");
        backButton.addActionListener(e -> {
            // Acción al hacer clic en "Volver"
            // Puedes agregar la lógica para volver a la interfaz anterior o realizar cualquier otra acción necesaria.
            // Por ahora, simplemente ocultamos este panel
            setVisible(true);
            
            
        });

        // Agrega los componentes al panel
        add(label, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }
}

	public class GestionarReservasPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GestionarReservasPanel() {
        setLayout(new BorderLayout());

        // Contenido del panel de Gestionar Reservas
        JLabel label = new JLabel("Panel de Gestionar Reservas");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));

        JButton backButton = new JButton("Volver");
        backButton.addActionListener(e -> {
            // Acción al hacer clic en "Volver"
            // Puedes agregar la lógica para volver a la interfaz anterior o realizar cualquier otra acción necesaria.
            // Por ahora, simplemente ocultamos este panel
            setVisible(false);
        });

        // Agrega los componentes al panel
        add(label, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }
}
	
	public class VermiInfo extends JPanel {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public VermiInfo() {
	        setLayout(new GridBagLayout());

	        // Contenido del panel "Administrar mi información"
	        JLabel label = new JLabel("Mi información");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        label.setFont(new Font("Arial", Font.BOLD, 24));

	        List<String> informacionUsuario = Usuario.verPerfilUsuario(Inicio_sesion.getCorreoUsuario());
	        System.out.println(Usuario.verPerfilUsuario(Inicio_sesion.getCorreoUsuario()));

	        // Crear etiquetas para mostrar la información
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.anchor = GridBagConstraints.WEST;

	        for (String info : informacionUsuario) {
	            JLabel infoLabel = new JLabel(info);
	            add(infoLabel, gbc);
	            gbc.gridy++;
	        }
	        

	        // Agrega los componentes al panel
	        add(label, gbc);
	        }
	    
	    
	}

	public class AdminmiInfo extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminmiInfo() {
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
	    
	    Cliente_i cliente = new Cliente_i();
	    cliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    cliente.setVisible(true);
	}
	
    }

