package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.ImageIcon;

public class InicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textEmail;
	private JTextField textcontrasenia;

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
		textEmail.setBackground(new Color(255, 20, 147));
		textEmail.setBounds(24, 80, 208, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("E-MAIL");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 49, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblContraseNIa = new JLabel("CONTRASE\u00D1A");
		lblContraseNIa.setForeground(Color.WHITE);
		lblContraseNIa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContraseNIa.setBounds(24, 124, 149, 14);
		contentPane.add(lblContraseNIa);
		
		textcontrasenia = new JTextField();
		textcontrasenia.setForeground(Color.WHITE);
		textcontrasenia.setColumns(10);
		textcontrasenia.setBackground(new Color(255, 20, 147));
		textcontrasenia.setBounds(24, 159, 208, 20);
		contentPane.add(textcontrasenia);
		
		JButton btnInicioSesion = new JButton("INICIO SESION");
		btnInicioSesion.setBackground(new Color(255, 255, 153));
		btnInicioSesion.setForeground(new Color(0, 0, 0));
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JButton btnRegistrate = new JButton("REGISTRATE");
		btnRegistrate.setForeground(Color.BLACK);
		btnRegistrate.setBackground(new Color(255, 255, 153));
		btnRegistrate.setBounds(41, 323, 132, 23);
		contentPane.add(btnRegistrate);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\Pi\u00F1a melocoton SEX SHOP 3g.png"));
		lblNewLabel_1.setBounds(276, 51, 148, 116);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\DAM\\SEX_SHOP\\teleoperador.png"));
		lblNewLabel_2.setBounds(391, 305, 33, 59);
		contentPane.add(lblNewLabel_2);
	}
}
