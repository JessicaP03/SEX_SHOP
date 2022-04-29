package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Persona;
import modelo.ControladorBDImplementacion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEmail;
	private JPasswordField passwordConstrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Registro dialog = new Registro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Registro() {
		setBounds(100, 100, 450, 439);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlDkShadow);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblRegistro = new JLabel("REGISTRO");
			lblRegistro.setForeground(Color.WHITE);
			lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblRegistro.setBounds(20, 11, 149, 14);
			contentPanel.add(lblRegistro);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(20, 36, 365, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblNombre = new JLabel("NOMBRE");
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNombre.setBounds(30, 49, 77, 14);
			contentPanel.add(lblNombre);
		}
		{
			textNombre = new JTextField();
			textNombre.setForeground(Color.WHITE);
			textNombre.setColumns(10);
			textNombre.setBackground(new Color(255, 20, 147));
			textNombre.setBounds(25, 74, 208, 20);
			contentPanel.add(textNombre);
		}
		{
			JLabel lblApellido = new JLabel("APELLIDO");
			lblApellido.setForeground(Color.WHITE);
			lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblApellido.setBounds(30, 111, 77, 14);
			contentPanel.add(lblApellido);
		}
		{
			textApellido = new JTextField();
			textApellido.setForeground(Color.WHITE);
			textApellido.setColumns(10);
			textApellido.setBackground(new Color(255, 20, 147));
			textApellido.setBounds(25, 136, 208, 20);
			contentPanel.add(textApellido);
		}
		{
			JLabel lblEmail = new JLabel("E-MAIL");
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblEmail.setBounds(30, 172, 77, 14);
			contentPanel.add(lblEmail);
		}
		{
			textEmail = new JTextField();
			textEmail.setForeground(Color.WHITE);
			textEmail.setColumns(10);
			textEmail.setBackground(new Color(255, 20, 147));
			textEmail.setBounds(25, 197, 208, 20);
			contentPanel.add(textEmail);
		}
		{
			JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
			lblContrasea.setForeground(Color.WHITE);
			lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblContrasea.setBounds(30, 239, 128, 14);
			contentPanel.add(lblContrasea);
		}

		passwordConstrasena = new JPasswordField();
		passwordConstrasena.setBackground(new Color(255, 20, 147));
		passwordConstrasena.setBounds(25, 264, 208, 20);
		contentPanel.add(passwordConstrasena);

		JButton btnCrearCuenta = new JButton("CREAR CUENTA");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevaCuenta();
			}

			
		});
		btnCrearCuenta.setForeground(Color.BLACK);
		btnCrearCuenta.setBackground(new Color(255, 255, 153));
		btnCrearCuenta.setBounds(37, 310, 132, 23);
		contentPanel.add(btnCrearCuenta);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 355, 365, 2);
		contentPanel.add(separator);
		{
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\DAM\\SEX_SHOP\\teleoperador.png"));
			lblNewLabel_2.setBounds(391, 285, 33, 59);
			contentPanel.add(lblNewLabel_2);
		}
	}
	
	//Metodo para crear nueva cuenta
	private void nuevaCuenta() {
		//RECOGER DATOS DE PERSONA
	
		//if (Persona.verificarPersona(contrasena)==-1) {
			//DEVOLVER DATOS DE CLIENTES
			Persona pers= new Persona();
			pers.setNombre(textNombre.getText());
			pers.setApellido(textApellido.getText());
			pers.setEmail(textEmail.getText());
			pers.setContrasena(passwordConstrasena.getPassword().toString());
			
			ControladorBDImplementacion datos = new ControladorBDImplementacion();
			datos.insertarPersona(pers);
			
			JOptionPane.showMessageDialog(this, "LA PERSONA SE HA REGISTRADO CORRECTAMENTE!");
		//}else {
//			JOptionPane.showMessageDialog(this, "ESTE USUARIO YA EXISTE");
//		}
	}

	public void actionPerformed(ActionEvent e) {
	
		
		
	
	
	
	}
}
