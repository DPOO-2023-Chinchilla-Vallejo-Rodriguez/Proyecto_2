package interfaz_grafica;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import interfaz_grafica.Crear_cliente;
import reservas_procesamiento.Reservas;
import interfaz_grafica.EliminarReserva;


public class CliEliminar extends JFrame{
	
	/**
	 * 
	 */
	
	private  Inicio_sesion padre;
	
	private static Reservas reserva;
	private static final long serialVersionUID = 1L;
	private Crear_cliente crear;
	private EliminarResCli eliminar;
	private JPanel panelAgregar;
	
	public CliEliminar (Inicio_sesion padre) throws Exception
	{
		this.padre = padre;
		reserva = new Reservas();
		reserva.inicializar();
		setSize( 750, 600 );
        setTitle( "Cliente" );
        //setDefaultCloseOperation( EXIT_ON_CLOSE );
//        setResizable( false );
        setVisible(true);
        setLayout( new BorderLayout( ) );
        
        
        
        eliminar = new EliminarResCli( this, padre);
        add(eliminar, BorderLayout.CENTER);
        
        
	}
	
	
	
	
	
	
	
	

	
}
