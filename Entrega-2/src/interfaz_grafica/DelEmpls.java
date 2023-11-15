package interfaz_grafica;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Reservas_modelo.Empleado;
import Reservas_modelo.Historial;
import Reservas_modelo.Usuario;
import reservas_procesamiento.Reservas;

public class DelEmpls extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Inicio_sesion padre;
	
	
	private JLabel lblcorreoi;
	private JTextField txtcorreoi;
	private JButton btniniciar;
	private JButton btneliminar;
	
	private JLabel lblcorreo;

	private JLabel lblnombre;
	private JLabel lbltel;
	private JLabel lblID;
	private JLabel lblEliminar;
	
	
	private JTextField txtcorreo;
	
	private JTextField txtnombre;
	private JTextField txttel;
	private JTextField txtID;
	
	
	
	private JPanel panelInicio;
	private JPanel panelTitulo;
	private JPanel panelInfo;
	
	private FrameEmpls principal;
	
	
	
	
	public DelEmpls (FrameEmpls pprincipal, Inicio_sesion padre) throws Exception
	{
		this.padre = padre;
		
		
		pprincipal = principal;
		setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Amdministrar Reserva" ) );
        
        panelInicio = new JPanel( );
        add(panelInicio,BorderLayout.CENTER);
        panelInicio.setBackground(Color.GRAY);
        Dimension tamano = new Dimension(200, 150);
        panelInicio.setPreferredSize(tamano);
        
        panelInicio.setLayout( new GridLayout( 1, 2 ) );
        
        lblcorreoi = new JLabel ("Correo del cliente");
        panelInicio.add( lblcorreoi);
        lblcorreoi.setForeground(Color.WHITE);
        txtcorreoi = new JTextField ();
        panelInicio.add(txtcorreoi);
        txtcorreoi.setBackground(Color.WHITE);
        txtcorreoi.setForeground(Color.BLACK);
        
        btniniciar = new JButton( "Cargar" );
        panelInicio.add( btniniciar ); 
        btniniciar.setBackground(Color.WHITE);
        btniniciar.setForeground(Color.BLACK);
        
        btniniciar.addActionListener( this );
        
        
        panelTitulo = new JPanel ();
        add(panelTitulo,BorderLayout.NORTH);
        panelTitulo.setBackground(Color.GRAY);
        
        ImageIcon imagen = new ImageIcon("./RecursosInterfaz/DelEmpleado.png");
        Image im = imagen.getImage();
        Image mod = im.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon modi = new ImageIcon(mod);
        JLabel lbltit = new JLabel(modi);
        
        panelTitulo.add( lbltit); 
        
        panelInfo = new JPanel ();
        add(panelInfo,BorderLayout.SOUTH);
        panelInfo.setBackground(Color.WHITE);
        panelInfo.setLayout( new GridLayout( 5, 2 ) );
        
        lblcorreo = new JLabel ("Correo");
        panelInfo.add( lblcorreo);
        txtcorreo = new JTextField ();
        txtcorreo.setEditable(false);
        panelInfo.add(txtcorreo);
        txtcorreo.setBackground(Color.BLACK);
        txtcorreo.setForeground(Color.WHITE);
        
   
        
        lblnombre = new JLabel ("Nombre");
        panelInfo.add( lblnombre);
        txtnombre= new JTextField ();
        txtnombre.setEditable(false);
        panelInfo.add(txtnombre);
        txtnombre.setBackground(Color.BLACK);
        txtnombre.setForeground(Color.WHITE);
        
        lbltel = new JLabel ("Teléfono");
        panelInfo.add( lbltel );
        txttel = new JTextField ();
        txttel .setEditable(false);
        panelInfo.add(txttel );
        txttel .setBackground(Color.BLACK);
        txttel .setForeground(Color.WHITE);
        
        lblID = new JLabel ("ID");
        panelInfo.add( lblID );
        txtID = new JTextField ();
        txtID .setEditable(false);
        panelInfo.add(txtID );
        txtID .setBackground(Color.BLACK);
        txtID .setForeground(Color.WHITE);
        
        
        lblEliminar = new JLabel ("Reserva");
        panelInfo.add( lblEliminar  );
        btneliminar = new JButton( "Eliminar" );
        panelInfo.add( btneliminar ); 
        btneliminar.setBackground(Color.BLACK);
        btneliminar.setForeground(Color.WHITE);
        
        btneliminar.addActionListener( this );
        
	}
	
	public void actionPerformed( ActionEvent e )
    {
        if(e.getSource( )==btniniciar)
        {
            cargar( );
        }
        
        else if (e.getSource( )==btneliminar)
        {
            eliminar( );
        }
        
    }
	
	public void cargar ()
	 {
		
		for (Empleado reserva : padre.getEmpleados()) {
			if (reserva.getLogin().equals(txtcorreoi.getText()) ) 
			{
				txtcorreo.setText(reserva.getLogin());
				txtnombre.setText(reserva.getNombre());
				txttel.setText(reserva.getTelefono());
				txtID.setText(reserva.getId());
				
			}
            
        }
	 }
	
	@SuppressWarnings("static-access")
	public void eliminar() {
	    
	    String correoEliminar = txtcorreoi.getText();
	    
	   
	    List<Empleado> nuevasReservas = new ArrayList<>();

	    for (Empleado reserva : padre.getEmpleados()) {
	        if (!reserva.getLogin().equals(correoEliminar)) {
	           
	            nuevasReservas.add(reserva);
	        }
	    }

	 
	    padre.setEmpleados(nuevasReservas);
	    
	    List<Usuario> clientes = padre.getUsuarios();

	   
	    String archivo = "./data/usuarios.csv";
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
	        for (Empleado reserva : nuevasReservas) {
	            String union = reserva.getLogin() + "," + reserva.getPassword() + "," +
	                    reserva.getRol() + "," + reserva.getNombre() + "," + reserva.getTelefono() + "," +
	                    reserva.getFechaNacimiento() + "," + reserva.getNacionalidad() + "," + reserva.getId() + ",,,,,,,,," +
	                    reserva.getSede()  ;
	            writer.write(union);
	            writer.newLine(); 
	        }
	        
	        
	          Usuario us = new Usuario(archivo, archivo, archivo, archivo, archivo, archivo, archivo, null, null);
	          us.guardarUsuariosEnArchivo (clientes);
	        
	        JOptionPane.showMessageDialog(this, "Información guardada ");
	    } catch (IOException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error al guardar la información en el archivo");
	    }
	}
	

}
