package interfaz_grafica;



import javax.imageio.ImageIO;
import javax.swing.*;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;


import Reservas_modelo.Sede;
import Reservas_modelo.Vehiculo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;


class Funciones {
	

	
	
	private static void mostrarCerrarSesion() {
        CerrarSesion.createAndShowGUI();
    }
	
	static JPanel createMenuPanel() {
		  
		//Cargar fuente de texto Eyesome Script
          try {
              Font eyesomeScriptFont = Font.createFont(Font.TRUETYPE_FONT, new File("./RecursosInterfaz/eyesome/Eyesome Script.otf/"));
              GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
              ge.registerFont(eyesomeScriptFont);
              
          } catch (Exception e) {
              e.printStackTrace();
          }
          
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        menuPanel.setPreferredSize(new Dimension(100, 0));
        menuPanel.setBackground(Color.BLACK);

        // Agregar "CV" en la esquina superior
        JLabel cvLabel = new JLabel("CV");
        cvLabel.setFont(new Font("Eyesome Script", Font.PLAIN, 30));
        cvLabel.setForeground(Color.WHITE);
        cvLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cvLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 180, 0));

        // Agregar botones con imágenes
        ImageIcon button1Icon = new ImageIcon("./RecursosInterfaz/boton.inicioB.png");
        Image image = button1Icon.getImage();
        Image scaledImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JButton button1 = new JButton(scaledIcon);
        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);

        
        
        ImageIcon button2Icon = new ImageIcon("./RecursosInterfaz/boton.usuarioG.png");
        Image image1 = button2Icon.getImage();
        Image scaledImage1 = image1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        JButton button2 = new JButton(scaledIcon1);
        button2.setBorderPainted(false);
        button2.setContentAreaFilled(false);

        
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InformacionClientes informacionClientes = new InformacionClientes();
				informacionClientes.setVisible(true);
            }
        });
        
        ImageIcon exitIcon = new ImageIcon("./RecursosInterfaz/boton.salida.png");
        Image image2 = exitIcon.getImage();
        Image scaledImage2 = image2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        JButton exitButton = new JButton(scaledIcon2);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción al hacer clic en el botón de salida (abrir otra pestaña, ventana, etc.)
            	SwingUtilities.invokeLater(() -> mostrarCerrarSesion());
            }
        });
        // Crear el panel central para los botones
        JPanel centralPanel = new JPanel();
        centralPanel.setPreferredSize(new Dimension(0, 0));
        centralPanel.setBackground(Color.BLACK);
        centralPanel.add(button1, BorderLayout.CENTER);
        centralPanel.add(button2, BorderLayout.CENTER);

        // Agregar botones al menú
        menuPanel.add(cvLabel, BorderLayout.NORTH);
        menuPanel.add(centralPanel, BorderLayout.CENTER);
        menuPanel.add(exitButton, BorderLayout.SOUTH);

        return menuPanel;
    }
	  
	  
	static void agregarImagenABoton(JButton boton, String rutaImagen) {
	        try {
	            BufferedImage image = ImageIO.read(new File(rutaImagen));
	            Image scaledImage = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH); // Ajusta el tamaño de la imagen
	            boton.setIcon(new ImageIcon(scaledImage));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	// Método para crear un panel con fondo de imagen
    
    static JPanel crearPanelConFondo(String rutaImagen, int imageWidth, int imageHeight) {
        return new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Carga la imagen desde el archivo y ajusta su tamaño
                try {
                    BufferedImage image = ImageIO.read(new File(rutaImagen));
                    int panelWidth = getWidth();
                    int panelHeight = getHeight();
                    int x = (panelWidth - imageWidth) / 2;
                    int y = (panelHeight - imageHeight) / 2;
                    g.drawImage(image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH), x, y, this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }
    
    static JPanel graficaPanel = new JPanel();
    private static int mesActual;

    static {
        // Inicializa el mesActual con el número del mes actual
        Calendar calendar = Calendar.getInstance();
        mesActual = calendar.get(Calendar.MONTH) + 1; // Sumamos 1 porque los meses se indexan desde 0
    }
    
    static JPanel visualizaciondealtonivel() {
        List<String> listaSedes = Sede.vernombresSede();
        
        // Panel derecho
        JPanel derechaPanel = new JPanel();
        derechaPanel.setLayout(new BorderLayout());
        derechaPanel.setPreferredSize(new Dimension(500, 0));
        derechaPanel.setBackground(Color.BLACK);

        // Panel de texto
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setPreferredSize(new Dimension(300, 100));
        textPanel.setBackground(Color.BLACK);

        // JLabel con el texto
        String bienvenidaTexto = "Ver la disponibilidad de vehiculos: ";
        String htmlText = "<html><div style='text-align: center;'>" + bienvenidaTexto + "</div></html>";
        JLabel textoLabel = new JLabel(htmlText);
        textoLabel.setForeground(Color.WHITE);
        textoLabel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        Font fuenteActual = textoLabel.getFont();
        Font fuenteGrande = new Font(fuenteActual.getName(), fuenteActual.getStyle(), 25);
        textoLabel.setFont(fuenteGrande);
        textoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textPanel.add(textoLabel);

        derechaPanel.add(textPanel, BorderLayout.NORTH);

        // Panel de lista
        JPanel listaPanel = new JPanel();
        listaPanel.setLayout(new BorderLayout());
        listaPanel.setPreferredSize(new Dimension(300, 30));
        listaPanel.setBackground(Color.WHITE);

        // Calendario con colores para la disponibilidad
        JPanel calendarioPanel = new JPanel();

        // Lista desplegable
        JComboBox<String> sedeComboBox = new JComboBox<>();
        for (String sede : listaSedes) {
            sedeComboBox.addItem(sede);
        }
        sedeComboBox.setPreferredSize(new Dimension(200, 50));
        sedeComboBox.setBackground(Color.WHITE);
        listaPanel.add(sedeComboBox);
 
        JButton mesAnteriorButton = new JButton("<");
        mesAnteriorButton.setBackground(Color.BLACK);
        mesAnteriorButton.setForeground(Color.WHITE); // Cambiar color del texto

        JButton mesSiguienteButton = new JButton(">");
        mesSiguienteButton.setBackground(Color.BLACK);
        mesSiguienteButton.setForeground(Color.WHITE); 

        // Cambiar el tamaño de los botones (puedes ajustar los números según tus necesidades)
        mesAnteriorButton.setSize(10, 10);
        mesSiguienteButton.setSize(10, 10);

        // Crear panel
        JPanel panelBotones = new JPanel();
        
        // Establecer diseño del panel a FlowLayout para colocar los botones horizontalmente
        panelBotones.setLayout(new FlowLayout());
        panelBotones.setBackground(Color.BLACK);
        // Agregar botones al panel
        panelBotones.add(mesAnteriorButton);
        panelBotones.add(mesSiguienteButton);
        panelBotones.setMaximumSize(new Dimension(10, 10));
        // ActionListener para el botón de mes anterior
        mesAnteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mesActual--;
                actualizarGrafica(sedeComboBox);
            }
        });

        // ActionListener para el botón de mes siguiente
        mesSiguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mesActual++;
                actualizarGrafica(sedeComboBox);
            }
        });
        
       
        
        calendarioPanel.add(listaPanel, BorderLayout.NORTH);


        String sedeSeleccionada = (String) sedeComboBox.getSelectedItem();
        List<Integer> listaAutos = Vehiculo.obtenerDisponibilidad(sedeSeleccionada, 10);
        GraphDemo graphDemo = new GraphDemo(listaAutos, mesActual, sedeSeleccionada);
        
        // Obtén el gráfico desde graphDemo
        JFreeChart chart = graphDemo.getChart();
        // Crea un ChartPanel a partir del gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 400));

        graficaPanel.add(chartPanel);
        JScrollPane graficaScrollPanel = new JScrollPane(graficaPanel);
        graficaScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        graficaScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        graficaScrollPanel.setPreferredSize(new Dimension(400, 400));
        // Agrega el chartPanel al calendarioPanel
        calendarioPanel.add(graficaScrollPanel);
        calendarioPanel.setBackground(Color.BLACK);

        // Agrega el calendarioPanel con el gráfico al centralPanel
        derechaPanel.add(calendarioPanel, BorderLayout.CENTER);

        calendarioPanel.add(panelBotones);
        
        sedeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cuando se selecciona una nueva sede, actualiza la gráfica
                actualizarGrafica(sedeComboBox);
            }
        });
        
        // Agregar imagen con el logo de la "empresa"
        ImageIcon infoImage = new ImageIcon("./RecursosInterfaz/carroBlanco.png");
        Image image3 = infoImage.getImage();
        Image scaledImage3 = image3.getScaledInstance(300, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
        JLabel imageLabel = new JLabel(scaledIcon3);
        derechaPanel.add(imageLabel, BorderLayout.SOUTH);
		return derechaPanel;

       
    }

    private static void actualizarGrafica(JComboBox<String> sedeComboBox) {
    // Capturar la sede seleccionada
    String sedeSeleccionada = (String) sedeComboBox.getSelectedItem();

    // Obtener la disponibilidad para el mes actual
    List<Integer> listaAutos = Vehiculo.obtenerDisponibilidad(sedeSeleccionada, mesActual);

    // Crear y mostrar la gráfica
    GraphDemo graphDemo = new GraphDemo(listaAutos, mesActual, sedeSeleccionada);
    
    // Obtén el gráfico desde graphDemo
    JFreeChart chart = graphDemo.getChart();

    // Crea un ChartPanel a partir del gráfico
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new Dimension(800, 400));

    // Remplaza el panel existente con el nuevo ChartPanel
    graficaPanel.removeAll();
    graficaPanel.add(chartPanel);
    graficaPanel.revalidate();
    graficaPanel.repaint();
}
}


