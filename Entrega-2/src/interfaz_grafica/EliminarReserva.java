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

import reservas_procesamiento.Reservas;

public class EliminarReserva extends JPanel implements ActionListener {
	
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
	private JLabel lblvehiculo;
	private JLabel lblFreserva;
	private JLabel lblFalquiler;
	private JLabel lblTarifa;
	private JLabel lblSeguro;
	private JLabel lblEntrega;
	private JLabel lblDevolucion;
	private JLabel lblEstado;
	private JLabel lblTit;
	private JLabel lblEliminar;
	
	
	private JTextField txtcorreo;
	private JTextField txtvehiculo;
	private JTextField txtFreserva;
	private JTextField txtFalquiler;
	private JTextField txtTarifa;
	private JTextField txtSeguro;
	private JTextField txtEntrega;
	private JTextField txtDevolucion;
	private JTextField txtEstado;
	
	
	private JPanel panelInicio;
	private JPanel panelTitulo;
	private JPanel panelInfo;
	
	private Reserva_cliente principal;
	
	
	
	
	public EliminarReserva (Reserva_cliente pprincipal, Inicio_sesion padre) throws Exception
	{
		this.padre = padre;
		
		
		pprincipal = principal;
		setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Amdministrar Reserva" ) );
        
        panelInicio = new JPanel( );
        add(panelInicio,BorderLayout.CENTER);
        panelInicio.setBackground(Color.GRAY);
        
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
        
        ImageIcon imagen = new ImageIcon("./RecursosInterfaz/Cliente_eliminar.png");
        Image im = imagen.getImage();
        Image mod = im.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        ImageIcon modi = new ImageIcon(mod);
        JLabel lbltit = new JLabel(modi);
        
        panelTitulo.add( lbltit); 
        
        panelInfo = new JPanel ();
        add(panelInfo,BorderLayout.SOUTH);
        panelInfo.setBackground(Color.WHITE);
        panelInfo.setLayout( new GridLayout( 10, 2 ) );
        
        lblcorreo = new JLabel ("Correo");
        panelInfo.add( lblcorreo);
        txtcorreo = new JTextField ();
        txtcorreo.setEditable(false);
        panelInfo.add(txtcorreo);
        txtcorreo.setBackground(Color.BLACK);
        txtcorreo.setForeground(Color.WHITE);
        
        lblvehiculo = new JLabel ("Vehículo");
        panelInfo.add( lblvehiculo);
        txtvehiculo = new JTextField ();
        txtvehiculo.setEditable(false);
        panelInfo.add(txtvehiculo);
        txtvehiculo.setBackground(Color.BLACK);
        txtvehiculo.setForeground(Color.WHITE);
        
        lblFreserva = new JLabel ("Fecha de la reserva");
        panelInfo.add( lblFreserva);
        txtFreserva= new JTextField ();
        txtFreserva.setEditable(false);
        panelInfo.add(txtFreserva);
        txtFreserva.setBackground(Color.BLACK);
        txtFreserva.setForeground(Color.WHITE);
        
        lblFalquiler = new JLabel ("Fecha del alquiler");
        panelInfo.add( lblFalquiler );
        txtFalquiler = new JTextField ();
        txtFalquiler .setEditable(false);
        panelInfo.add(txtFalquiler );
        txtFalquiler .setBackground(Color.BLACK);
        txtFalquiler .setForeground(Color.WHITE);
        
        lblTarifa = new JLabel ("Tarifa");
        panelInfo.add( lblTarifa );
        txtTarifa = new JTextField ();
        txtTarifa .setEditable(false);
        panelInfo.add(txtTarifa );
        txtTarifa .setBackground(Color.BLACK);
        txtTarifa .setForeground(Color.WHITE);
        
        lblSeguro = new JLabel ("Seguro");
        panelInfo.add( lblSeguro  );
        txtSeguro  = new JTextField ();
        txtSeguro  .setEditable(false);
        panelInfo.add(txtSeguro  );
        txtSeguro  .setBackground(Color.BLACK);
        txtSeguro  .setForeground(Color.WHITE);
        
        lblEntrega = new JLabel ("Sede de Entrega");
        panelInfo.add( lblEntrega   );
        txtEntrega   = new JTextField ();
        txtEntrega .setEditable(false);
        panelInfo.add(txtEntrega   );
        txtEntrega .setBackground(Color.BLACK);
        txtEntrega .setForeground(Color.WHITE);
        
        lblDevolucion = new JLabel ("Sede de Devolución");
        panelInfo.add( lblDevolucion   );
        txtDevolucion   = new JTextField ();
        txtDevolucion.setEditable(false);
        panelInfo.add(txtDevolucion   );
        txtDevolucion.setBackground(Color.BLACK);
        txtDevolucion.setForeground(Color.WHITE);
        
        lblEstado = new JLabel ("Estado");
        panelInfo.add( lblEstado  );
        txtEstado   = new JTextField ();
        txtEstado.setEditable(false);
        panelInfo.add(txtEstado   );
        txtEstado.setBackground(Color.BLACK);
        txtEstado.setForeground(Color.WHITE);
        
        
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
		
		for (Historial reserva : padre.getHistorial()) {
			if (reserva.getCorreoCliente().equals(txtcorreoi.getText()) ) 
			{
				txtcorreo.setText(reserva.getCorreoCliente());
				txtvehiculo.setText(reserva.getVehiculoReservado());
				txtFreserva.setText(reserva.getFechaReserva());
				txtFalquiler.setText(reserva.getFechaAlquiler());
				txtTarifa.setText(String.valueOf(reserva.getTarifa()));
				txtSeguro.setText(reserva.getSeguros());
				txtEntrega.setText(reserva.getEntrega());
				txtDevolucion.setText(reserva.getDevolucion());
				txtEstado.setText(reserva.getEstado());
			}
            
        }
	 }
	
	@SuppressWarnings("static-access")
	public void eliminar() {
	    
	    String correoEliminar = txtcorreoi.getText();
	    
	   
	    List<Historial> nuevasReservas = new ArrayList<>();

	    for (Historial reserva : padre.getHistorial()) {
	        if (!reserva.getCorreoCliente().equals(correoEliminar)) {
	           
	            nuevasReservas.add(reserva);
	        }
	    }

	 
	    padre.setHistorial(nuevasReservas);

	   
	    String archivo = "./data/reservas.csv";
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
	        for (Historial reserva : nuevasReservas) {
	            String union = reserva.getCorreoCliente() + "," + reserva.getVehiculoReservado() + "," +
	                    reserva.getFechaReserva() + "," + reserva.getFechaAlquiler() + "," + reserva.getTarifa() + "," +
	                    reserva.getSeguros() + "," + reserva.getEntrega() + "," + reserva.getDevolucion() + "," +
	                    reserva.getEstado()  ;
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
