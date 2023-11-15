package interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Crear_cliente extends JPanel implements ActionListener {

	private JLabel lbl_nombre;
	private JLabel lbl_contrasena;
	private JLabel lbl_correo;
	private JLabel lbl_tel;
	private JLabel lbl_fnac;
	private JLabel lbl_nacionalidad;
	private JLabel lbl_id;
	private JLabel lbl_nolic;
	private JLabel lbl_paislic;
	private JLabel lbl_vencimientolic;
	private JLabel lbl_imagen;
	private JLabel lbl_titular;
	private JLabel lbl_tarjeta;
	private JLabel lbl_vectarjeta;
	private JLabel lbl_codigo;
	private JLabel lbl_sede;
	private JLabel lbl_tit;
	
	private JPanel panelAgregar;
	private JPanel panelFinal;
	private JPanel panelTitulo;
	
	private JTextField txt_nombre;
	private JTextField txt_contrasena;
	private JTextField txt_correo;
	private JTextField txt_tel;
	private JTextField txt_fnac;
	private JTextField txt_nacionalidad;
	private JTextField txt_id;
	private JTextField txt_nolic;
	private JTextField txt_paislic;
	private JTextField txt_vencimientolic;
	private JTextField txt_imagen;
	private JTextField txt_titular;
	private JTextField txt_tarjeta;
	private JTextField txt_vectarjeta;
	private JTextField txt_codigo;
	private JTextField txt_sede;
	
	private JButton btn_guardar;
	
	private Reserva_cliente principal;
	
	public Crear_cliente (Reserva_cliente pprincipal)
	{
		pprincipal = principal;
		setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Crear Usuarion de Cliente" ) );
        
        panelAgregar = new JPanel( );
        add(panelAgregar,BorderLayout.CENTER);
        panelAgregar.setBackground(Color.WHITE);
        
        panelAgregar.setLayout( new GridLayout( 16, 2 ) );
        
        lbl_nombre = new JLabel ("Nombre");
        panelAgregar.add( lbl_nombre);
        txt_nombre = new JTextField ();
        panelAgregar.add(txt_nombre);
        
        lbl_contrasena = new JLabel ("Contraseña");
        panelAgregar.add( lbl_contrasena);
        txt_contrasena = new JTextField ();
        panelAgregar.add(txt_contrasena);
        
        lbl_correo = new JLabel ("Correo");
        panelAgregar.add( lbl_correo);
        txt_correo = new JTextField ();
        panelAgregar.add(txt_correo);
        
        lbl_tel = new JLabel ("Teléfono");
        panelAgregar.add( lbl_tel);
        txt_tel = new JTextField ();
        panelAgregar.add(txt_tel);
        
        lbl_fnac = new JLabel ("Fecha de nacimiento");
        panelAgregar.add( lbl_fnac);
        txt_fnac = new JTextField ();
        panelAgregar.add(txt_fnac);
        
        lbl_nacionalidad = new JLabel ("Nacionalidad");
        panelAgregar.add( lbl_nacionalidad);
        txt_nacionalidad = new JTextField ();
        panelAgregar.add(txt_nacionalidad);
        
        lbl_id = new JLabel ("ID");
        panelAgregar.add( lbl_id);
        txt_id = new JTextField ();
        panelAgregar.add(txt_id);
        
        lbl_nolic = new JLabel ("Número de licencia");
        panelAgregar.add( lbl_nolic);
        txt_nolic = new JTextField ();
        panelAgregar.add(txt_nolic);
        
        lbl_paislic = new JLabel ("País de licencia");
        panelAgregar.add( lbl_paislic);
        txt_paislic = new JTextField ();
        panelAgregar.add(txt_paislic);
        
        lbl_vencimientolic = new JLabel ("Vencimiento de la Licencia");
        panelAgregar.add( lbl_vencimientolic);
        txt_vencimientolic = new JTextField ();
        panelAgregar.add(txt_vencimientolic);
        
        lbl_imagen = new JLabel ("Ruta de la imagen de la licencia");
        panelAgregar.add( lbl_imagen);
        txt_imagen = new JTextField ();
        panelAgregar.add(txt_imagen);
        
        lbl_titular = new JLabel ("Titular de la tarjeta");
        panelAgregar.add( lbl_titular);
        txt_titular = new JTextField ();
        panelAgregar.add(txt_titular);
        
        lbl_tarjeta = new JLabel ("Tarjeta");
        panelAgregar.add( lbl_tarjeta);
        txt_tarjeta = new JTextField ();
        panelAgregar.add(txt_tarjeta);
        
        lbl_vectarjeta = new JLabel ("Vencimiento de la Tarjeta");
        panelAgregar.add( lbl_vectarjeta);
        txt_vectarjeta = new JTextField ();
        panelAgregar.add(txt_vectarjeta);
        
        lbl_codigo = new JLabel ("Código de seguridad de la tarjeta");
        panelAgregar.add( lbl_codigo);
        txt_codigo = new JTextField ();
        panelAgregar.add(txt_codigo);
        
        lbl_sede = new JLabel ("Sede");
        panelAgregar.add( lbl_sede);
        txt_sede = new JTextField ();
        panelAgregar.add(txt_sede);
        
        panelFinal = new JPanel( );
        add(panelFinal,BorderLayout.SOUTH);
        panelFinal.setBackground(Color.WHITE);
        
        btn_guardar = new JButton( "Guardar" );
        panelFinal.add( btn_guardar ); 
        
        btn_guardar.addActionListener( this );
        
        
        panelTitulo = new JPanel ();
        add(panelTitulo,BorderLayout.NORTH);
        panelTitulo.setBackground(Color.WHITE);
        
        ImageIcon imagen = new ImageIcon("./RecursosInterfaz/Cliente_crear.png");
        Image im = imagen.getImage();
        Image mod = im.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon modi = new ImageIcon(mod);
        JLabel lbl_tit = new JLabel(modi);
        
        panelTitulo.add( lbl_tit); 
        
        
        txt_nombre.setBackground(Color.BLACK);
        txt_nombre.setForeground(Color.WHITE);
        
        txt_contrasena.setBackground(Color.BLACK);
        txt_contrasena.setForeground(Color.WHITE);
        
        txt_correo.setBackground(Color.BLACK);
        txt_correo.setForeground(Color.WHITE);
        
        txt_tel.setBackground(Color.BLACK);
        txt_tel.setForeground(Color.WHITE);
        
        txt_fnac.setBackground(Color.BLACK);
        txt_fnac.setForeground(Color.WHITE);
        
        txt_nacionalidad.setBackground(Color.BLACK);
        txt_nacionalidad.setForeground(Color.WHITE);
        
        txt_id.setBackground(Color.BLACK);
        txt_id.setForeground(Color.WHITE);
        
        txt_nolic.setBackground(Color.BLACK);
        txt_nolic.setForeground(Color.WHITE);
        
        txt_paislic.setBackground(Color.BLACK);
        txt_paislic.setForeground(Color.WHITE);
        
        txt_vencimientolic.setBackground(Color.BLACK);
        txt_vencimientolic.setForeground(Color.WHITE);
        
        txt_imagen.setBackground(Color.BLACK);
        txt_imagen.setForeground(Color.WHITE);
        
        txt_titular.setBackground(Color.BLACK);
        txt_titular.setForeground(Color.WHITE);
        
        txt_tarjeta.setBackground(Color.BLACK);
        txt_tarjeta.setForeground(Color.WHITE);
        
        txt_vectarjeta.setBackground(Color.BLACK);
        txt_vectarjeta.setForeground(Color.WHITE);
        
        txt_codigo.setBackground(Color.BLACK);
        txt_codigo.setForeground(Color.WHITE);
        
        txt_sede.setBackground(Color.BLACK);
        txt_sede.setForeground(Color.WHITE);
        
        btn_guardar.setBackground(Color.BLACK);
        btn_guardar.setForeground(Color.WHITE);
        
        
        
	}
	
	 public void actionPerformed( ActionEvent e )
	    {
	        if(e.getSource( )==btn_guardar)
	        {
	            registrar( );
	        }
	        
	    }
	 
	 public void registrar ()
	 {
		 String nombre = txt_nombre.getText();
		 String contrasena = txt_contrasena.getText();
		 String correo = txt_correo.getText();
		 String tel = txt_tel.getText();
		 String fnac = txt_fnac.getText();
		 String nacionalidad = txt_nacionalidad.getText();
		 String id = txt_id.getText();
		 String nolic = txt_nolic.getText();
		 String paislic = txt_paislic.getText();
		 String vencimientolic = txt_vencimientolic.getText();
		 String imagen = txt_imagen.getText();
		 String titular = txt_titular.getText();
		 String tarjeta = txt_tarjeta.getText();
		 String vectarjeta = txt_vectarjeta.getText();
		 String codigo = txt_codigo.getText();
		 String sede = txt_sede.getText();
		 
		 String union = correo + "," + contrasena + "," + "cliente" + "," + nombre + "," + tel + "," 
		 + fnac + "," + nacionalidad+ "," + id+ "," +nolic+ "," +paislic+ "," +vencimientolic+ "," 
		 + imagen+ "," +titular+ "," +tarjeta+ "," +vectarjeta+ "," +codigo+ "," +sede;
		 
		 String archivo = "./data/usuarios.csv";
		 
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) 
		 {
	            writer.write(union);
	            JOptionPane.showMessageDialog(this, "Información guardada ");
	        } 
		 catch (IOException e) 
		 {
			 
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error al guardar la información en el archivo");
	        }
	 }
}
