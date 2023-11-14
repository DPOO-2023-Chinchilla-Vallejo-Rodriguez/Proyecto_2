package interfaz_grafica;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class InformacionClientes {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	//Cargar fuente Eyesome Script
            try {
                Font eyesomeScriptFont = Font.createFont(Font.TRUETYPE_FONT, new File("RecursosInterfaz\\eyesome\\Eyesome Script.otf"));
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(eyesomeScriptFont);

            } catch (Exception e) {
                e.printStackTrace();
            }
            //Nueva pestaña
            JFrame frame = new JFrame("Información para Clientes");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

            //Panel con el menu
            JPanel menuPanel = Funciones.createMenuPanel();

            // Crear el panel derecho con scroll
            JPanel infoPanel = new JPanel(new GridBagLayout());
            infoPanel.setLayout(new BorderLayout());
            
            //Panel con todos los elementos del panel derecho
            JPanel ContenidoPanel = new JPanel(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			ContenidoPanel.setBackground(Color.WHITE);
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.CENTER; // Alineación al centro

            // Agregar imagen con el nombre de la "empresa"
            ImageIcon infoImage = new ImageIcon("RecursosInterfaz\\imagenPinformacion.png");
            Image image3 = infoImage.getImage();
            Image scaledImage3 = image3.getScaledInstance(1260, 600, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
            JLabel imageLabel = new JLabel(scaledIcon3);
            infoPanel.add(imageLabel, BorderLayout.NORTH);

            // Crear un panel para el texto debajo de la línea
            JPanel textPanel = new JPanel();
            textPanel.setLayout(new BorderLayout());
            textPanel.setPreferredSize(new Dimension(900,155));
            textPanel.setBackground(Color.WHITE); // Fondo negro
            
			String informacionTexto = "CarVoyage es mucho más que una empresa de alquiler de vehículos; somos tu socio en la movilidad. Con un compromiso inquebrantable con la satisfacción del cliente, ofrecemos una amplia flota de vehículos para satisfacer todas tus necesidades de viaje. Desde opciones económicas hasta vehículos de lujo, te brindamos comodidad, confiabilidad y la libertad de explorar. Nuestra prioridad es convertir cada viaje en una experiencia inolvidable. ¡Bienvenido a CarVoyage, donde tus aventuras en la carretera comienzan a rodar.";
			String htmlText = "<html><div style='text-align: justify;'>" + informacionTexto + "</div></html>";
			JLabel textoLabel = new JLabel(htmlText);
			Font fuentePersonalizada = new Font("Sans", Font.PLAIN, 16);
			textoLabel.setFont(fuentePersonalizada);
			textoLabel.setHorizontalAlignment(SwingConstants.CENTER);
            textPanel.add(textoLabel);
            
            /*
             *  Sección "¿Qué carros alquilamos?" 
             */
            
            //titulo
            JLabel carrosAlquilamosTitulo = new JLabel("¿Qué vehículos alquilamos?");
            Font fuente = new Font("Sans", Font.PLAIN, 30);
            carrosAlquilamosTitulo.setFont(fuente);
            carrosAlquilamosTitulo.setHorizontalAlignment(SwingConstants.CENTER);
            //Separador
            JSeparator separator1 = new JSeparator(JSeparator.HORIZONTAL);
            separator1.setBackground(Color.BLACK);  
            UIManager.put("Separator.width", 5);  // Cambiael ancho deseado

            // Crear el panel con cuatro columnas de información
            JPanel carrosPanel = new JPanel(new GridLayout(1, 4));
            carrosPanel.setBackground(Color.WHITE);
            // Información de los carros
            String[] titulos = {
                "Económicos - Ford Fiesta",
                "Económicos - Ford Fiesta",
                "Lujo - Mercedes Benz Clase E",
                "Van - Hyundai H1"
            };

            String[] descripciones = {
                "Carros compactos y eficientes en consumo de combustible, ideales para desplazamientos en la ciudad. El Ford Fiesta ofrece comodidad y un manejo ágil.",
                "Carros compactos y eficientes en consumo de combustible, ideales para desplazamientos en la ciudad. El Ford Fiesta ofrece comodidad y un manejo ágil.",
                "Experimenta el lujo y el rendimiento en un Mercedes-Benz Clase E. Este sedán de lujo ofrece un interior elegante y características avanzadas.",
                "Las vans Hyundai H1 son perfectas para grupos grandes o viajes en familia. Espaciosas y versátiles, ofrecen comodidad y capacidad para múltiples pasajeros."
            };

            String[] precios = {
                "Precio por Día: $90,000",
                "Precio por Día: $90,000",
                "Precio por Día: $300,000",
                "Precio por Día: $250,000"
            };
            
            String[] rutas = {
            		"RecursosInterfaz\\fordfiesta.png" ,
                    "RecursosInterfaz\\suv.png",
                    "RecursosInterfaz\\mercedes.png",
                    "RecursosInterfaz\\van.png"
                };
            
            //Ciclo para agregar la información
            for (int i = 0; i < 4; i++) {
                // Crear un panel para cada columna
                JPanel columnPanel = new JPanel(new GridBagLayout());
                GridBagConstraints gbcc = new GridBagConstraints();
                gbcc.gridx = 0;
                gbcc.gridy = 0;
                gbcc.fill = GridBagConstraints.HORIZONTAL;
                gbcc.anchor = GridBagConstraints.CENTER; // Alineación al centro

             // Agregar una imagen a la columna
                ImageIcon columnImage = new ImageIcon(rutas[i]);
                Image imagecar = columnImage.getImage();
                Image scaledImagecar = imagecar.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                ImageIcon scaledIconcar = new ImageIcon(scaledImagecar);
                JLabel carrosLabel = new JLabel(scaledIconcar);
                columnPanel.add(carrosLabel,gbcc);
                gbcc.gridy++;

                // Agregar el título
                JLabel titleLabel = new JLabel(titulos[i]);
                titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
                titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16)); // Negrita y tamaño 16
                titleLabel.setBorder(BorderFactory.createEmptyBorder(18, 0, 0, 0)); // Margen superior
                columnPanel.add(titleLabel, gbcc);
                gbcc.gridy++;
                
                // Agregar la descripción
                JPanel textPaneld = new JPanel();
                textPaneld.setLayout(new BorderLayout());
                textPaneld.setPreferredSize(new Dimension(200,150));
                textPaneld.setBackground(Color.WHITE); 
                String descripcion = (descripciones[i]);
                String htmlTextd = "<html><div style='text-align: justify;'>" + descripcion + "</div></html>";
    			JLabel textoLabeld = new JLabel(htmlTextd);
    			textPaneld.add(textoLabeld);
                columnPanel.add(textPaneld, gbcc);
                gbcc.gridy++;

                // Agregar el precio
                JLabel priceLabel = new JLabel(precios[i]);
                priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
                priceLabel.setFont(new Font("SansSerif", Font.BOLD, 14)); // Negrita y tamaño 14
                columnPanel.add(priceLabel, gbcc);
                gbcc.gridy++;
                columnPanel.setBackground(Color.WHITE);

                // Agregar el panel de la columna al panel de carros
                carrosPanel.add(columnPanel);
                
            }
           

            /*
             *  Sección "¿Qué seguros ofrecemos?" 
             */ 
            //Titulo
            JLabel segurosOfrecemosTitulo = new JLabel("¿Qué seguros ofrecemos?");
            segurosOfrecemosTitulo.setFont(fuente);
            segurosOfrecemosTitulo.setHorizontalAlignment(SwingConstants.CENTER);
            //Separador
            JSeparator separator2 = new JSeparator(JSeparator.HORIZONTAL);
            separator2.setBackground(Color.BLACK);  
            UIManager.put("Separator.width", 5);  // Cambia al ancho deseado
            
            // Crear el panel con tres columnas de información
            JPanel segurosPanel = new JPanel(new GridLayout(1, 3));
            segurosPanel.setBackground(Color.WHITE);

            // Información de los seguros
            String[] titulosseguros = {
                "Seguro de Responsabilidad Civil (RC)",
                "Seguro de Colisión (CDW)",
                "Seguro de Asistencia en Carretera",
            };

            String[] descripcionesseguros = {
                "Este seguro cubre los daños a terceros en caso de un accidente. Proporciona tranquilidad en caso de lesiones corporales o daños a la propiedad de otras personas..",
                "El seguro de colisión cubre los daños al vehículo de alquiler en caso de accidente, colisión o daños accidentales. Esto reduce la responsabilidad del conductor en caso de daños al vehículo.",
                "Este seguro proporciona asistencia las 24 horas del día en caso de problemas en la carretera, como una llanta desinflada, una batería descargada o llaves perdidas. Ofrece tranquilidad y ayuda en situaciones de emergencia.",
            };

            String[] preciosseguros = {
                "Precio por Día: $50,000",
                "Precio por Día: $20,000",
                "Precio por Día: $15,000",
            };
            
            String[] rutasseguros = {
            		"RecursosInterfaz\\SeguroRC.png" ,
                    "RecursosInterfaz\\SeguroCLS.png",
                    "RecursosInterfaz\\SeguroAC.png",
                };

            //Ciclo para gregar la información de los seguros
            for (int i = 0; i < 3; i++) {
                // Crear un panel para cada columna
                JPanel columnPanel = new JPanel(new GridBagLayout());
                GridBagConstraints gbcc = new GridBagConstraints();
                gbcc.gridx = 0;
                gbcc.gridy = 0;
                gbcc.fill = GridBagConstraints.HORIZONTAL;
                gbcc.anchor = GridBagConstraints.CENTER; // Alineación al centro

                // Agregar una imagen a la columna
                ImageIcon columnImage = new ImageIcon(rutasseguros[i]);
                Image imagecar = columnImage.getImage();
                Image scaledImagecar = imagecar.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                ImageIcon scaledIconcar = new ImageIcon(scaledImagecar);
                JLabel carrosLabel = new JLabel(scaledIconcar);
                columnPanel.add(carrosLabel,gbcc);
                gbcc.gridy++;

                // Agregar el título
                JLabel titleLabel = new JLabel(titulosseguros[i]);
                titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
                titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16)); // Negrita y tamaño 16
                titleLabel.setBorder(BorderFactory.createEmptyBorder(18, 0, 0, 0)); // Margen superior
                columnPanel.add(titleLabel, gbcc);
                gbcc.gridy++;
                
                // Agregar la descripción
                JPanel textPaneld = new JPanel();
                textPaneld.setLayout(new BorderLayout());
                textPaneld.setPreferredSize(new Dimension(200,150));
                textPaneld.setBackground(Color.WHITE); 
                String descripcion = (descripcionesseguros[i]);
                String htmlTextd = "<html><div style='text-align: justify;'>" + descripcion + "</div></html>";
    			JLabel textoLabeld = new JLabel(htmlTextd);
    			textPaneld.add(textoLabeld);
                columnPanel.add(textPaneld, gbcc);
                gbcc.gridy++;

             // Agregar el precio
                JLabel priceLabel = new JLabel(preciosseguros[i]);
                priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
                priceLabel.setFont(new Font("SansSerif", Font.BOLD, 14)); // Negrita y tamaño 14
                priceLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0)); // Margen superior
                columnPanel.add(priceLabel, gbcc);
                gbcc.gridy++;
                columnPanel.setBackground(Color.WHITE);

                // Agregar el panel de la columna al panel de seguros
                segurosPanel.add(columnPanel);
                
            }

            //Agregar los elementos al panel
            ContenidoPanel.add(textPanel, gbc);
            gbc.gridy++;
            ContenidoPanel.add(carrosAlquilamosTitulo, gbc);
            gbc.gridy++;
            gbc.insets = new Insets(40, 50, 0, 0);
            ContenidoPanel.add(separator1, gbc);
            gbc.gridy++;
            ContenidoPanel.add(carrosPanel, gbc);
            gbc.gridy++;           
            ContenidoPanel.add(segurosOfrecemosTitulo, gbc);
            gbc.gridy++;
            gbc.insets = new Insets(40, 50, 0, 0);          
            ContenidoPanel.add(separator2, gbc);
            gbc.gridy++;            
            ContenidoPanel.add(segurosPanel, gbc);
            gbc.gridy++;
            
            
            infoPanel.add(ContenidoPanel);
            //Configuraciones del scroll
            JScrollPane infoScrollPanel = new JScrollPane(infoPanel);
            infoScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            infoScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            // Agregar el menú y el panel de información a la ventana
            frame.setLayout(new BorderLayout());
            frame.add(menuPanel, BorderLayout.WEST);
            frame.add(infoScrollPanel, BorderLayout.EAST);
            frame.setVisible(true);
        });
    }
}
