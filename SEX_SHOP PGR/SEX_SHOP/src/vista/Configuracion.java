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
import javax.swing.ImageIcon;

/**
 * @author 1dam
 *
 */
public class Configuracion extends JDialog {

	
	/**
	 * @param datos
	 */
	public Configuracion(ControladorDatos datos) {
//		super(padre);
//		this.setModal(modal);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\SEX_SHOP\\SEX_SHOP\\SEX_SHOP PGR\\SEX_SHOP\\src\\imagenes\\logo.png"));
		getContentPane().setBackground(SystemColor.controlDkShadow);
		setBounds(100, 100, 532, 300);
		getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 213, 474, 2);
		getContentPane().add(separator);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(new Color(255, 255, 153));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCerrar.setBounds(432, 226, 74, 23);
		getContentPane().add(btnCerrar);
		
		JButton btnRegistrar_Empleado = new JButton("Configurar Empleado");
		btnRegistrar_Empleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarEmpleado(datos);
			}
		});
		btnRegistrar_Empleado.setBackground(Color.PINK);
		btnRegistrar_Empleado.setBounds(10, 226, 171, 23);
		getContentPane().add(btnRegistrar_Empleado);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 30, 474, 2);
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
			public void actionPerformed(ActionEvent e) {
				btnInsertar(datos);
			}
		});
		btnInsertar.setBounds(46, 75, 99, 23);
		getContentPane().add(btnInsertar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
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
		
		JButton btnRegistrar_Empleado_1 = new JButton("Gestionar Usuarios");
		btnRegistrar_Empleado_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionarUsuario(datos);
			}
		});
		btnRegistrar_Empleado_1.setBackground(Color.PINK);
		btnRegistrar_Empleado_1.setBounds(212, 226, 150, 23);
		getContentPane().add(btnRegistrar_Empleado_1);
	}

	protected void registrarEmpleado(ControladorDatos datos) {
		GestionaEmpleados registrar = new GestionaEmpleados(this, true, datos, null);
		registrar.setVisible(true);
		
	}

	protected void baja(ControladorDatos datos) {
		DarBajaProducto baja = new DarBajaProducto(this, true, datos, null);
		baja.setVisible(true);
	}

	protected void modificar(ControladorDatos datos) {
		ModificarProducto modificar = new ModificarProducto(this, true, datos, null);
		modificar.setVisible(true);
	}

	protected void btnInsertar(ControladorDatos datos) {
		InsertarProducto insertar = new InsertarProducto(this, true, datos);
		insertar.setVisible(true);
	}
	
	protected void gestionarUsuario(ControladorDatos datos) {
		GestionarUsuarios usuario = new GestionarUsuarios(this, true, datos, null);
		usuario.setVisible(true);
	}
}
