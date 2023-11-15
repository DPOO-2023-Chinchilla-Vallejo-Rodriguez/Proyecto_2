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

import Reservas_modelo.Historial;
import Reservas_modelo.Vehiculo;
import reservas_procesamiento.Reservas;

public class DelVeh extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Inicio_sesion padre;
	
	
	private JLabel lblplacai;
	private JTextField txtplacai;
	private JButton btniniciar;
	private JButton btneliminar;
	
	private JLabel lblplaca;
	private JLabel lblmarca;
	private JLabel lblmodelo;
	private JLabel lblcolor;
	private JLabel lbltipo;
	
	private JLabel lblcategoria;
	private JLabel lblestado;
	private JLabel lblsede;
	private JLabel lblTit;
	private JLabel lblEliminar;
	
	
	private JTextField txtplaca;
	private JTextField txtmarca;
	private JTextField txtmodelo;
	private JTextField txtcolor;
	private JTextField txttipo;
	
	private JTextField txtcategoria;
	private JTextField txtestado;
	private JTextField txtsede;
	
	
	private JPanel panelInicio;
	private JPanel panelTitulo;
	private JPanel panelInfo;
	
	private FrameVehiculos principal;
	
	
	
	
	public DelVeh (FrameVehiculos pprincipal, Inicio_sesion padre) throws Exception
	{
		this.padre = padre;
		
		
		pprincipal = principal;
		setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Amdministrar Reserva" ) );
        
        panelInicio = new JPanel( );
        add(panelInicio,BorderLayout.CENTER);
        panelInicio.setBackground(Color.GRAY);
        
        panelInicio.setLayout( new GridLayout( 1, 2 ) );
        
        lblplacai = new JLabel ("Placa");
        panelInicio.add( lblplacai);
        lblplacai.setForeground(Color.WHITE);
        txtplacai = new JTextField ();
        panelInicio.add(txtplacai);
        txtplacai.setBackground(Color.WHITE);
        txtplacai.setForeground(Color.BLACK);
        
        btniniciar = new JButton( "Cargar" );
        panelInicio.add( btniniciar ); 
        btniniciar.setBackground(Color.WHITE);
        btniniciar.setForeground(Color.BLACK);
        
        btniniciar.addActionListener( this );
        
        
        panelTitulo = new JPanel ();
        add(panelTitulo,BorderLayout.NORTH);
        panelTitulo.setBackground(Color.GRAY);
        
        ImageIcon imagen = new ImageIcon("./RecursosInterfaz/DelVehiculo.png");
        Image im = imagen.getImage();
        Image mod = im.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon modi = new ImageIcon(mod);
        JLabel lbltit = new JLabel(modi);
        
        panelTitulo.add( lbltit); 
        
        panelInfo = new JPanel ();
        add(panelInfo,BorderLayout.SOUTH);
        panelInfo.setBackground(Color.WHITE);
        panelInfo.setLayout( new GridLayout( 10, 2 ) );
        
        lblplaca = new JLabel ("Placa");
        panelInfo.add( lblplaca);
        txtplaca = new JTextField ();
        txtplaca.setEditable(false);
        panelInfo.add(txtplaca);
        txtplaca.setBackground(Color.BLACK);
        txtplaca.setForeground(Color.WHITE);
        
        lblmarca = new JLabel ("Marca");
        panelInfo.add( lblmarca);
        txtmarca = new JTextField ();
        txtmarca.setEditable(false);
        panelInfo.add(txtmarca);
        txtmarca.setBackground(Color.BLACK);
        txtmarca.setForeground(Color.WHITE);
        
        lblmodelo = new JLabel ("Modelo");
        panelInfo.add( lblmodelo);
        txtmodelo= new JTextField ();
        txtmodelo.setEditable(false);
        panelInfo.add(txtmodelo);
        txtmodelo.setBackground(Color.BLACK);
        txtmodelo.setForeground(Color.WHITE);
        
        lblcolor = new JLabel ("Color");
        panelInfo.add( lblcolor );
        txtcolor = new JTextField ();
        txtcolor .setEditable(false);
        panelInfo.add(txtcolor );
        txtcolor .setBackground(Color.BLACK);
        txtcolor .setForeground(Color.WHITE);
        
        lbltipo = new JLabel ("Tipo Transmisión");
        panelInfo.add( lbltipo );
        txttipo = new JTextField ();
        txttipo .setEditable(false);
        panelInfo.add(txttipo );
        txttipo .setBackground(Color.BLACK);
        txttipo .setForeground(Color.WHITE);
        
    
        
        lblcategoria = new JLabel ("Categoria");
        panelInfo.add( lblcategoria    );
        txtcategoria    = new JTextField ();
        txtcategoria  .setEditable(false);
        panelInfo.add(txtcategoria    );
        txtcategoria  .setBackground(Color.BLACK);
        txtcategoria  .setForeground(Color.WHITE);
        
        lblestado = new JLabel ("Estado");
        panelInfo.add( lblestado   );
        txtestado   = new JTextField ();
        txtestado.setEditable(false);
        panelInfo.add(txtestado   );
        txtestado.setBackground(Color.BLACK);
        txtestado.setForeground(Color.WHITE);
        
        lblsede = new JLabel ("Sede");
        panelInfo.add( lblsede  );
        txtsede   = new JTextField ();
        txtsede.setEditable(false);
        panelInfo.add(txtsede   );
        txtsede.setBackground(Color.BLACK);
        txtsede.setForeground(Color.WHITE);
        
        
        lblEliminar = new JLabel ("Eliminar");
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
		
		for (Vehiculo reserva : padre.getVehiculos()) {
			if (reserva.getPlaca().equals(txtplacai.getText()) ) 
			{
				txtplaca.setText(reserva.getPlaca());
				txtmarca.setText(reserva.getMarca());
				txtmodelo.setText(reserva.getModelo());
				txtcolor.setText(reserva.getColor());
				txttipo.setText(reserva.getTipoTransmision());
				
				txtcategoria.setText(reserva.getCategoria());
				txtestado.setText(reserva.getEstado());
				txtsede.setText(reserva.getsede());
			}
            
        }
	 }
	
	@SuppressWarnings("static-access")
	public void eliminar() {
	    
	    String correoEliminar = txtplacai.getText();
	    
	   
	    List<Vehiculo> nuevasReservas = new ArrayList<>();

	    for (Vehiculo reserva : padre.getVehiculos()) {
	        if (!reserva.getPlaca().equals(correoEliminar)) {
	           
	            nuevasReservas.add(reserva);
	        }
	    }

	 
	    padre.setVehiculos(nuevasReservas);

	   
	    String archivo = "./data/inventario.csv";
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
	        for (Vehiculo reserva : nuevasReservas) {
	            String union = reserva.getPlaca() + "," + reserva.getMarca() + "," +
	                    reserva.getModelo() + "," + reserva.getColor() + "," + reserva.getTipoTransmision() + "," +
	                    reserva.getCategoria() + "," + reserva.getEstado() + "," + reserva.getsede()   ;
	            writer.write(union);
	            writer.newLine(); 
	        }
	        JOptionPane.showMessageDialog(this, "Información guardada ");
	    } catch (IOException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error al guardar la información en el archivo");
	    }
	}
	

}