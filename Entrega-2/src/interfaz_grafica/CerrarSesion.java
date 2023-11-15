package interfaz_grafica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CerrarSesion {

	private static JFrame frame;  // Referencia al JFrame principal

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());

        // Cargar fuente de texto Eyesome Script
        try {
            Font eyesomeScriptFont = Font.createFont(Font.TRUETYPE_FONT, new File("./RecursosInterfaz/eyesome/Eyesome Script.otf/"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(eyesomeScriptFont);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void createAndShowGUI() {
        frame = new JFrame("Cerrar Sesión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());

        // Panel Izquierdo
        JPanel leftPanel = Funciones.createMenuPanel();
        frame.add(leftPanel, BorderLayout.WEST);

        // Panel Derecho
        JPanel rightPanel = createLogoutPanel();
        frame.add(rightPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    

    private static JPanel createLogoutPanel() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 400));
        // Agregar bordes al panel
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen de 10 píxeles en todos los lados
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("CarVoyage");
        titleLabel.setFont(new Font("Eyesome Script", Font.BOLD, 70));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(100, 10, 10, 10));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);

       

      //Separador
        JPanel separador = new JPanel();
        separador.setBackground(Color.BLACK);
        separador.setMaximumSize(new Dimension(800,0));
        
        panel.add(separador);

        String questionText = "<html><div style='text-align: center;'><b>¿Estás seguro de cerrar la sesión?</b></div></html>";
        JLabel questionLabel = new JLabel(questionText);
        questionLabel.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
        
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        panel.add(questionLabel);
        

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);

        // Botón "Sí" con imagen
        ImageIcon yesIcon = new ImageIcon("./RecursosInterfaz/BotonSi.png"); // Reemplaza con la ruta real de la imagen
        Image scaledImage = yesIcon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JButton yesButton = new JButton(scaledIcon);
        yesButton.setBorder(BorderFactory.createEmptyBorder());
        yesButton.setBackground(Color.white);

        // Botón "No" con imagen
        ImageIcon noIcon = new ImageIcon("./RecursosInterfaz/BotonNo.png"); // Reemplaza con la ruta real de la imagen
        Image scaledImage1 = noIcon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);
        JButton noButton = new JButton(scaledIcon1);
        noButton.setBorder(BorderFactory.createEmptyBorder());
        noButton.setBackground(Color.white);

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cerrar la sesión
                System.out.println("Sesión cerrada");
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cancelar el cierre de sesión
                System.out.println("Cierre de sesión cancelado");
            }
        });

        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
        panel.add(buttonPanel);

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cerrar la sesión
                System.out.println("Sesión cerrada");
                // Cierra todas las pestañas abiertas
                System.exit(0);
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cancelar el cierre de sesión
            	frame.setVisible(false);
                // Puedes agregar más lógica aquí si no quieres que ocurra nada al presionar "No"
            }
        });
        
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Agregar una imagen (reemplaza "path/to/your/image.png" con la ruta real de tu imagen)
        ImageIcon imageIcon = new ImageIcon("./RecursosInterfaz/carroNegro.png");
        Image scaledImage3 = imageIcon.getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH); // Ajusta las dimensiones según sea necesario
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);

        JLabel imageLabel = new JLabel(scaledIcon3);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(imageLabel);

        return panel;
    }
}
