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

public class AggVel extends JPanel implements ActionListener {

	private JLabel lblplaca;
	private JLabel lblmarca;
	private JLabel lblmodelo;
	private JLabel lblcolor;
	private JLabel lbltransmision;
	private JLabel lblcategoria;
	private JLabel lblestado;
	private JLabel lblsede;
	private JLabel lbl_tit;
	
	
	private JPanel panelAgregar;
	private JPanel panelFinal;
	private JPanel panelTitulo;
	
	private JTextField txtplaca;
	private JTextField txtmarca;
	private JTextField txtmodelo;
	private JTextField txtcolor;
	private JTextField txttransmision;
	private JTextField txtcategoria;
	private JTextField txtestado;
	private JTextField txtsede;
	
	
	private JButton btn_guardar;
	
	private FrameVehiculos principal;
	
	public AggVel (FrameVehiculos pprincipal)
	{
		pprincipal = principal;
		setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Crear Vehiculos" ) );
        
        panelAgregar = new JPanel( );
        add(panelAgregar,BorderLayout.CENTER);
        panelAgregar.setBackground(Color.WHITE);
        
        panelAgregar.setLayout( new GridLayout( 16, 2 ) );
        
        lblplaca = new JLabel ("Placa");
        panelAgregar.add( lblplaca);
        txtplaca = new JTextField ();
        panelAgregar.add(txtplaca);
        
        lblmarca = new JLabel ("Marca");
        panelAgregar.add( lblmarca);
        txtmarca = new JTextField ();
        panelAgregar.add(txtmarca);
        
        lblmodelo = new JLabel ("Modelo");
        panelAgregar.add( lblmodelo);
        txtmodelo = new JTextField ();
        panelAgregar.add(txtmodelo);
        
        lblcolor = new JLabel ("Color");
        panelAgregar.add( lblcolor);
        txtcolor = new JTextField ();
        panelAgregar.add(txtcolor);
        
        lbltransmision = new JLabel ("Tipo de Transmisión");
        panelAgregar.add( lbltransmision);
        txttransmision = new JTextField ();
        panelAgregar.add(txttransmision);
        
        lblcategoria = new JLabel ("Categoría");
        panelAgregar.add( lblcategoria);
        txtcategoria = new JTextField ();
        panelAgregar.add(txtcategoria);
        
        lblestado = new JLabel ("Estado");
        panelAgregar.add( lblestado);
        txtestado = new JTextField ();
        panelAgregar.add(txtestado);
        
        lblsede = new JLabel ("Sede");
        panelAgregar.add( lblsede);
        txtsede = new JTextField ();
        panelAgregar.add(txtsede);
        
        
        panelFinal = new JPanel( );
        add(panelFinal,BorderLayout.SOUTH);
        panelFinal.setBackground(Color.WHITE);
        
        btn_guardar = new JButton( "Guardar" );
        panelFinal.add( btn_guardar ); 
        
        btn_guardar.addActionListener( this );
        
        
        panelTitulo = new JPanel ();
        add(panelTitulo,BorderLayout.NORTH);
        panelTitulo.setBackground(Color.WHITE);
        
        ImageIcon imagen = new ImageIcon("./RecursosInterfaz/AgVehiculo.png");
        Image im = imagen.getImage();
        Image mod = im.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon modi = new ImageIcon(mod);
        JLabel lbl_tit = new JLabel(modi);
        
        panelTitulo.add( lbl_tit); 
        
        
        txtplaca.setBackground(Color.BLACK);
        txtplaca.setForeground(Color.WHITE);
        
        txtmarca.setBackground(Color.BLACK);
        txtmarca.setForeground(Color.WHITE);
        
        txtmodelo.setBackground(Color.BLACK);
        txtmodelo.setForeground(Color.WHITE);
        
        txtcolor.setBackground(Color.BLACK);
        txtcolor.setForeground(Color.WHITE);
        
        txttransmision.setBackground(Color.BLACK);
        txttransmision.setForeground(Color.WHITE);
        
        txtcategoria.setBackground(Color.BLACK);
        txtcategoria.setForeground(Color.WHITE);
        
        txtestado.setBackground(Color.BLACK);
        txtestado.setForeground(Color.WHITE);
        
        txtsede.setBackground(Color.BLACK);
        txtsede.setForeground(Color.WHITE);
        
        
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
		 String placa = txtplaca.getText();
		 String marca = txtmarca.getText();
		 String modelo = txtmodelo.getText();
		 String color = txtcolor.getText();
		 String tipo = txttransmision.getText();
		 String cat = txtcategoria.getText();
		 String estado = txtestado.getText();
		 String sede = txtsede.getText();
		 
		 
		 String union = placa + "," + marca + "," + modelo + "," + color + "," + tipo + "," 
		 + cat + "," + estado+ ","   +sede;
		 
		 String archivo = "./data/inventario.csv";
		 
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