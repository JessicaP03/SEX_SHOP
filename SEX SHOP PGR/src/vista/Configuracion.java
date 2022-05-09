package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.ControladorDatos;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import java.awt.Toolkit;

public class Configuracion extends JDialog {

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 * @param datos 
	 */
	public Configuracion(InicioSesion padre, boolean modal, ControladorDatos datos) {
		super(padre);
		this.setModal(modal);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1dam\\Downloads\\logo.png"));
		getContentPane().setBackground(SystemColor.controlDkShadow);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 213, 414, 2);
		getContentPane().add(separator);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(new Color(255, 255, 153));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
		btnCerrar.setBounds(350, 227, 74, 23);
		getContentPane().add(btnCerrar);
		
		JButton btnRegistrar_Empleado = new JButton("Registrar Empleado");
		btnRegistrar_Empleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				registroEmpleado(datos);
			}
		});
		btnRegistrar_Empleado.setBackground(new Color(255, 255, 153));
		btnRegistrar_Empleado.setBounds(10, 226, 150, 23);
		getContentPane().add(btnRegistrar_Empleado);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 30, 399, 2);
		getContentPane().add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Configuracion");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 5, 125, 27);
		getContentPane().add(lblNewLabel);
		
		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInsertar.setForeground(Color.WHITE);
		btnInsertar.setBackground(new Color(135, 206, 235));
		btnInsertar.addActionListener(new ActionListener() {
			//LLamamos al metodo insertar
			public void actionPerformed(ActionEvent e) {
				insertar(datos);
			}

			
		});
		btnInsertar.setBounds(46, 75, 99, 23);
		getContentPane().add(btnInsertar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			//Llamar al metodo modificar para ir a esa ventana
			public void actionPerformed(ActionEvent e) {
				modificar(datos);
			}

			
		});
		btnModificar.setBackground(new Color(135, 206, 235));
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(46, 121, 99, 23);
		getContentPane().add(btnModificar);
		
		JButton btnBaja = new JButton("BAJA");
		btnBaja.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBaja.setForeground(Color.WHITE);
		btnBaja.setBackground(new Color(135, 206, 235));
		btnBaja.addActionListener(new ActionListener() {
			//Llamar al metodo de baja
			public void actionPerformed(ActionEvent e) {
				baja(datos);
			}

		
		});
		btnBaja.setBounds(46, 165, 99, 23);
		getContentPane().add(btnBaja);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione que quiere hacer");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(20, 43, 203, 14);
		getContentPane().add(lblNewLabel_1);
	}
	
	protected void cerrar() {
		this.dispose();
	}

	protected void registroEmpleado(ControladorDatos datos) {
		
		Registro registroEmpleado = new Registro (datos);
		registroEmpleado.setVisible(true);
	}

	//Metodo para que al pulsar la pantalla de insertar nos diriga a tal pantalla
	private void insertar(ControladorDatos datos) {
		// TODO Auto-generated method stub
		InsertarProducto insertar = new InsertarProducto (this, true, datos);
		insertar.setVisible(true);
	}
	
	private void modificar(ControladorDatos datos) {
		// TODO Auto-generated method stub
		ModificarProducto modificar = new ModificarProducto(this, true, datos);
		modificar.setVisible(true);
	}

	private void baja(ControladorDatos datos) {
		// TODO Auto-generated method stub
		DarBajaProducto baja = new DarBajaProducto (this, true, datos);
		baja.setVisible(true);
	}
	
}
