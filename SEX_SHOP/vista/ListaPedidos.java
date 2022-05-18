package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

public class ListaPedidos extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */

	public ListaPedidos(PiñaMeloco piñaMeloco, boolean b) {
		setBounds(100, 100, 450, 537);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlDkShadow);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblListaDePedidos = new JLabel("LISTA DE PEDIDOS");
			lblListaDePedidos.setForeground(Color.WHITE);
			lblListaDePedidos.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblListaDePedidos.setBounds(26, 11, 149, 14);
			contentPanel.add(lblListaDePedidos);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(26, 36, 346, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblNombre = new JLabel("NOMBRE");
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNombre.setBounds(26, 288, 77, 14);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblNombre = new JLabel("NOMBRE");
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNombre.setBounds(26, 403, 77, 14);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblNewLabel = new JLabel("Fecha del pedido");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(36, 49, 115, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(26, 457, 346, 2);
			contentPanel.add(separator);
		}
	}

}
