package vista;

import java.awt.BorderLayout;
import static java.util.Objects.hash;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.Persona;
import modelo.ControladorBDImplementacion;
import modelo.ControladorDatos;

import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class InicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 339, 2);
		contentPane.add(separator);

		JLabel lblInicioSesion = new JLabel("INICIO DE SESI\u00D3N");
		lblInicioSesion.setForeground(SystemColor.text);
		lblInicioSesion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInicioSesion.setBounds(10, 11, 149, 14);
		contentPane.add(lblInicioSesion);

		textEmail = new JTextField();
		textEmail.setForeground(Color.WHITE);
		textEmail.setBackground(new Color(255, 0, 102));
		textEmail.setBounds(24, 80, 208, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(SystemColor.text);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(20, 49, 175, 14);
		contentPane.add(lblEmail);

		JLabel lblContraseNIa = new JLabel("CONTRASE\u00D1A");
		lblContraseNIa.setForeground(Color.WHITE);
		lblContraseNIa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContraseNIa.setBounds(24, 124, 149, 14);
		contentPane.add(lblContraseNIa);

		JButton btnInicioSesion = new JButton("INICIO SESION");
		btnInicioSesion.setBackground(new Color(255, 255, 153));
		btnInicioSesion.setForeground(new Color(0, 0, 0));
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarSesion();
			}

		});
		btnInicioSesion.setBounds(41, 229, 132, 23);
		contentPane.add(btnInicioSesion);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(24, 285, 325, 2);
		contentPane.add(separator_1);

		JLabel lblFormaParte = new JLabel("\u00BFQuieres formar parte de nosotros?");
		lblFormaParte.setForeground(Color.WHITE);
		lblFormaParte.setBounds(24, 298, 273, 14);
		contentPane.add(lblFormaParte);

		// VENTANA REGISTRARSE
		JButton btnRegistrate = new JButton("REGISTRATE");
		btnRegistrate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro();

			}

		});
		btnRegistrate.setForeground(Color.BLACK);
		btnRegistrate.setBackground(new Color(255, 255, 153));
		btnRegistrate.setBounds(41, 323, 132, 23);
		contentPane.add(btnRegistrate);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\Pi\u00F1a melocoton SEX SHOP 3g.png"));
		lblNewLabel_1.setBounds(91, 49, 361, 274);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\DAM\\SEX_SHOP\\teleoperador.png"));
		lblNewLabel_2.setBounds(391, 305, 33, 59);
		contentPane.add(lblNewLabel_2);

		passContrasenia = new JPasswordField();
		passContrasenia.setBackground(new Color(255, 0, 102));
		passContrasenia.setBounds(24, 161, 208, 20);
		contentPane.add(passContrasenia);
	}

	// BOTON DE REGISTRARSE
	private void registro() {
		// Nos lleva a lapantalla de registro
		Registro abrir = new Registro();
		abrir.setVisible(true);
		this.dispose();
	}

	// Recorremos la informacion
	private static List<Persona> datos = new ArrayList<Persona>();
	private JPasswordField passContrasenia;

	// BOTON INICIAR SESION
	private void iniciarSesion() {
		Persona pers = new Persona();
		// RECOGER EMAIL Y CONTRASEÑA
		pers.setEmail(textEmail.getText());
		pers.setContrasena(new String(passContrasenia.getPassword()));

		ControladorBDImplementacion datos = new ControladorBDImplementacion();
		pers = datos.login(pers);

		// SI FALTA ALGUN CAMPO VACIO
		if (textEmail.getText().equals("") || passContrasenia.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "FALTA CAMPOS POR RELLENAR!");
		} else {
			// SI EL TIPO ES IGUAL A ADMIN
			if (pers.getTipo().equalsIgnoreCase("ADMIN")) {
				Configuracion conf = new Configuracion();
				conf.setVisible(true);
				this.dispose();
				// SI EL TIPO ES IGUAL A CLIENTE
			} else if (pers.getTipo().equalsIgnoreCase("CLIENTE")) {
				PiñaMeloco pm = new PiñaMeloco();
				pm.setVisible(true);
				this.dispose();

				// SI EL EMAIL O CONTRASEÑA NO COINCIDEN
			} else {
				JOptionPane.showMessageDialog(this, "ERROR! EMAIL O CONTRASEÑA INCORRECTOS");
			}
		}

	}

}
