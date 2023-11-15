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

public class AggEmpls extends JPanel implements ActionListener {

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
	private JLabel lbl_rol;
	
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
	private JTextField txt_rol;
	
	private JButton btn_guardar;
	
	private FrameEmpls principal;
	
	public AggEmpls (FrameEmpls pprincipal)
	{
		pprincipal = principal;
		setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Crear Usuario de Empleado" ) );
        
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
        
        lbl_rol = new JLabel ("Rol");
        panelAgregar.add( lbl_rol);
        txt_rol = new JTextField ();
        panelAgregar.add(txt_rol);
        
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
        
        ImageIcon imagen = new ImageIcon("./RecursosInterfaz/AgEmpleado.png");
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
        
        txt_sede.setBackground(Color.BLACK);
        txt_sede.setForeground(Color.WHITE);
        
        txt_rol.setBackground(Color.BLACK);
        txt_rol.setForeground(Color.WHITE);
        
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
		 String sede = txt_sede.getText();
		 String rol = txt_rol.getText();
		 
		 String union = correo + "," + contrasena + "," + rol + "," + nombre + "," + tel + "," 
		 + fnac + "," + nacionalidad+ "," + id+ ",,,,,,,,,"  +sede;
		 
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