package interfaz_grafica;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;

import Reservas_modelo.Empleado;
import Reservas_modelo.Usuario;
import reservas_procesamiento.Reservas;

import java.util.List;

public class Inicio_sesion {
	private static Reservas reserva;
    private static Usuario usuarioSesion;
    static String Sedeu = null;
    static String Nombreu = null;
    static String correoUsuario = null;
    static JFrame frame = new JFrame("Inicio de Sesión");
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	//Cargar fuente de texto Eyesome Script
            try {
                Font eyesomeScriptFont = Font.createFont(Font.TRUETYPE_FONT, new File("RecursosInterfaz\\eyesome\\Eyesome Script.otf"));
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(eyesomeScriptFont);
                
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Crear pantalla
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

          /************************************************************
           * Panel izquierdo con los elementos para el inicio de sesion *
           ************************************************************/
            
            JPanel loginPanel = new JPanel();
            loginPanel.setLayout(new BorderLayout());
            loginPanel.setBackground(Color.BLACK);
   
            //Panel con la etiqueta de bienvenida, los cajones de texto y el boton de inicio
            JPanel loginElementsPanel = new JPanel(new GridBagLayout());
            loginElementsPanel.setBackground(Color.BLACK);
            GridBagConstraints gbcElements = new GridBagConstraints();
            gbcElements.gridx = 0;
            gbcElements.gridy = 0;
            gbcElements.fill = GridBagConstraints.HORIZONTAL;
            gbcElements.anchor = GridBagConstraints.CENTER; 

            //Etiqueta de bienvenida al usuario
            JLabel welcomeLabel = new JLabel("! Hola de nuevo ¡");
            welcomeLabel.setFont(new Font("Sans", Font.PLAIN, 24));
            Color blanco = Color.WHITE;
            welcomeLabel.setForeground(blanco);
            welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

            //panel con los elementos donde se ingresa el usuario o correo
            JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            userPanel.setBackground(Color.WHITE);

            //caja de texto para escribir el usuario o correo
            JTextField usernameField = new JTextField(25);
            usernameField.setPreferredSize(new Dimension(45, 45));
            usernameField.setBorder(new MatteBorder(0, 0, 0, 0, Color.WHITE));
            usernameField.setOpaque(true);
            usernameField.setBackground(Color.WHITE);

            //Imagen de la caja de texto del usuario
            ImageIcon userIcon = new ImageIcon("RecursosInterfaz\\i.correologin.png");
            JLabel userLabel = new JLabel(userIcon);
            int width = 45;
            int height = 45;
            userIcon.setImage(userIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));

            userPanel.add(userLabel);
            userPanel.add(usernameField);
            userPanel.setBackground(Color.WHITE);

            //Panel de texto para los elementos de la contraseña
            JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            passwordPanel.setBackground(Color.WHITE);

            //caja de texto para escribir la contraseña
            JPasswordField passwordField = new JPasswordField(25);
            passwordField.setPreferredSize(new Dimension(45, 45));
            passwordField.setBorder(new MatteBorder(0, 0, 0, 0, Color.WHITE));
            passwordField.setOpaque(true);
            passwordField.setBackground(Color.WHITE);

            //Imagen de la contraseña
            ImageIcon passwordIcon = new ImageIcon("RecursosInterfaz\\i.password.login.png");
            JLabel passwordLabel = new JLabel(passwordIcon);
            passwordIcon.setImage(passwordIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));

            passwordPanel.add(passwordLabel);
            passwordPanel.add(passwordField);

            //Configuraciones del boton para ingresar
            ImageIcon buttonIcon = new ImageIcon("RecursosInterfaz\\BotonIngresar.png");
            Image scaledImage = buttonIcon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JButton loginButton = new JButton(scaledIcon);
            loginButton.setBorder(BorderFactory.createEmptyBorder());
            loginButton.setContentAreaFilled(false);
            
            loginButton.addActionListener(new ActionListener() {

            	    @Override
            	    public void actionPerformed(ActionEvent e) {
            	        // Obtener el nombre de usuario y la contraseña ingresados por el usuario
            	        String username = usernameField.getText();
            	        String password = new String(passwordField.getPassword());

            	        try {
            	            // Llamar a la lógica de inicio de sesión con el nombre de usuario y la contraseña
            	            iniciarSesion(username, password);
            	        } catch (IOException ex) {
            	            ex.printStackTrace();
            	        }
            	    }
            });
            

            
            //Agregar los elemntos del Login al panel correspondiente
            loginElementsPanel.add(welcomeLabel, gbcElements);
            gbcElements.gridy++;

            loginElementsPanel.add(userPanel, gbcElements);
            gbcElements.gridy++;
            gbcElements.insets = new Insets(5, 5, 0, 0);

            loginElementsPanel.add(passwordPanel, gbcElements);
            gbcElements.gridy++;
            gbcElements.insets = new Insets(5, 5, 0, 0);
            
            loginElementsPanel.add( loginButton, gbcElements);
            gbcElements.gridy++;
            gbcElements.insets = new Insets(5, 5, 0, 0);

            //Etiquieta con las inicailes de la "empresa"
            JLabel cvLabel = new JLabel("CV");
            cvLabel.setFont(new Font("Eyesome Script", Font.PLAIN, 24));
            cvLabel.setForeground(Color.WHITE);
            cvLabel.setOpaque(false);
            cvLabel.setAlignmentX(Component.LEFT_ALIGNMENT); 
            cvLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
            
            //Imagen del carro en la esquina inferior izquierda
            ImageIcon imagenizquierda = new ImageIcon("RecursosInterfaz\\carroadelante.png");
            imagenizquierda.setImage(imagenizquierda.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT));
            JLabel imagenizquierdaL = new JLabel(imagenizquierda);
            imagenizquierdaL.setBackground(Color.WHITE);
            imagenizquierdaL.setBorder(null);

            JPanel imageizquierdaP = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            imageizquierdaP.add(imagenizquierdaL);
            imageizquierdaP.setBackground(Color.BLACK);
            imageizquierdaP.setBorder(null);

            // Agregar todos los elementos al panel izquierdo
            loginPanel.add(cvLabel, BorderLayout.NORTH); 
            loginPanel.add(loginElementsPanel, BorderLayout.CENTER);
            loginPanel.add(imageizquierdaP, BorderLayout.SOUTH);

            
            

            
          /************************************************
           * Panel derecho con informacion de la empresa  *
           ************************************************/
            JPanel welcomePanel = new JPanel();
            welcomePanel.setLayout(new BorderLayout());

            // Etiqueta "CarVoyage" en la parte superior
            JLabel carVoyageLabel = new JLabel("CarVoyage");
            carVoyageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            carVoyageLabel.setFont(new Font("Eyesome Script", Font.PLAIN, 60));

            // Separador 
            JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
            separator.setForeground(Color.BLACK); // Color de la línea

            // Panel de texto 
            JPanel textPanel = new JPanel();
            textPanel.setLayout(new BorderLayout());
            textPanel.setPreferredSize(new Dimension(555,155));
            textPanel.setBackground(Color.WHITE); 

            //JLabel con el texto
            String bienvenidaTexto = "¡Bienvenidos a CarVoyage! Aquí, tu viaje comienza con infinitas posibilidades. En nuestra aplicación, podrás reservar el vehículo perfecto para tus aventuras, ya sea un viaje de negocios, unas vacaciones en familia o una escapada de fin de semana. Descubre una amplia gama de vehículos y tarifas atractivas. ¿No tienes un usuario? ¡No te preocupes! Pasa por una de nuestras sedes y nuestro amable administrador estará encantado de crearte una cuenta para que puedas empezar a disfrutar de la libertad en la carretera. ¡CarVoyage, tu viaje, tu elección!";
            String htmlText = "<html><div style='text-align: justify;'>" + bienvenidaTexto + "</div></html>";
            JLabel textoLabel = new JLabel(htmlText);
            Font fuenteActual = textoLabel.getFont();
            Font fuenteGrande = new Font(fuenteActual.getName(), fuenteActual.getStyle(),13 );
            textoLabel.setFont(fuenteGrande);
            textoLabel.setHorizontalAlignment(SwingConstants.CENTER);
            textPanel.add(textoLabel);
            
            // Crear un panel para centrar el contenido
            JPanel centerPanel = new JPanel(new GridBagLayout());
            centerPanel.setBackground(Color.WHITE); 
            
            // Configurar restricciones para el centrado
            GridBagConstraints centerGbc = new GridBagConstraints();
            centerGbc.gridx = 600;
            centerGbc.gridy = 700;
            centerGbc.fill = GridBagConstraints.HORIZONTAL;

            // Agregar lo elementos al panel central para alinear los elementos
            centerPanel.add(carVoyageLabel, centerGbc);
            centerGbc.gridy++;
            centerPanel.add(separator, centerGbc);
            centerGbc.gridy++;
            centerPanel.add(textPanel, centerGbc);
            
            //Imagen inferior izquierda
            ImageIcon imagenBorde = new ImageIcon("RecursosInterfaz\\carroatras.png");

            // Escalar la imagen al tamaño deseado 
            imagenBorde.setImage(imagenBorde.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT));
            JLabel imagenLabel = new JLabel();
            imagenLabel.setIcon(imagenBorde);
            imagenLabel.setBackground(Color.WHITE);
            imagenLabel.setBorder(null); // Eliminar el borde

            // Crear un panel interno con un FlowLayout para alinear la imagen a la izquierda
            JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            imagePanel.add(imagenLabel);
            imagePanel.setBackground(Color.WHITE);
            imagePanel.setBorder(null); // Eliminar el borde
            
            // Agregar los elemntos al panel derecho
            welcomePanel.add(centerPanel);
            welcomePanel.add(imagePanel, BorderLayout.SOUTH);
            
            // Configuración de la ventana principal
            frame.setLayout(new GridLayout(1, 2)); // Establece el diseño de cuadrícula (1 fila, 2 columnas)
            frame.add(loginPanel); // Agrega el panel de inicio de sesión
            frame.add(welcomePanel); // Agrega el panel informativo
            frame.setVisible(true); // Hace visible la ventana
        });
        }
        
        private static void iniciarSesion(String usuario, String contraseña) throws FileNotFoundException, IOException {
        	reserva = new Reservas();
    		reserva.inicializar();
        	// Obtener la lista de usuarios y empleados desde la instancia de Reservas
            List<Usuario> usuarios = Reservas.getUsuarios();
            List<Empleado> empleados = Reservas.getEmpleados();

            // Variable para almacenar el rol del usuario
            String rolUsuario = null;

            boolean inicioSesionExitoso = false;
            for (Usuario user : usuarios) {
                if (user.getCorreo().equals(usuario) && user.getpassword().equals(contraseña)) {
                    // El usuario ha iniciado sesión correctamente como cliente
                    System.out.println("Inicio de sesión exitoso como cliente.");
                    inicioSesionExitoso = true;
                    setUsuarioSesion(user);
                    rolUsuario = "cliente";
                    Nombreu=user.getNombres();
                    correoUsuario = user.getCorreo();
                    // Llamar al método correspondiente para el menú del cliente en la interfaz gráfica
                    
                    Cliente_i cliente_i = new Cliente_i();
					cliente_i.setVisible(true);
					frame.setVisible(false);
                    break;
                }
            }

            if (!inicioSesionExitoso) {
                for (Empleado empleado : empleados) {
                    if (empleado.getLogin().equals(usuario) && empleado.getPassword().equals(contraseña)) {
                        // El empleado ha iniciado sesión correctamente
                        System.out.println("Inicio de sesión exitoso como " + empleado.getRol() + ".");
                        inicioSesionExitoso = true;
                        Sedeu = empleado.getSede();
                        Nombreu = empleado.getNombre();
                        rolUsuario = empleado.getRol();
                        break;
                    }
                }
            }

            if (inicioSesionExitoso) {
                // Llamar al método correspondiente para el menú según el rol del usuario en la interfaz gráfica
                switch (rolUsuario) {
                    case "Admin Local":
                    	AdminLocal_i adminlocal = new AdminLocal_i();
                        adminlocal.setVisible(true);
                        frame.setVisible(false);
                        break;
                    case "Admin General":
                    	AdminGeneral_i admingeneral = new AdminGeneral_i();
                        admingeneral.setVisible(true);
                        frame.setVisible(false);
                        break;
                    case "Empleado":
                        Empleado_i empleado = new Empleado_i();
                        empleado.setVisible(true);
                        frame.setVisible(false);
                        break;
                }
            } else {
                // Mostrar un mensaje de error en la interfaz gráfica
                JOptionPane.showMessageDialog(null, "Inicio de sesión fallido. Verifica tus credenciales.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            }
        }

		public static String getSedeu() {
			return Sedeu;
		}

		public static void setSedeu(String sedeu) {
			Sedeu = sedeu;
		}

		public static String getNombreu() {
			return Nombreu;
		}

		public static void setNombreu(String nombreu) {
			Nombreu = nombreu;
		}

		public static String getCorreoUsuario() {
			return correoUsuario;
		}

		public static void setCorreoUsuario(String correoUsuario) {
			Inicio_sesion.correoUsuario = correoUsuario;
		}

		public static Usuario getUsuarioSesion() {
			return usuarioSesion;
		}

		public static void setUsuarioSesion(Usuario usuarioSesion) {
			Inicio_sesion.usuarioSesion = usuarioSesion;
		}
    
    }

