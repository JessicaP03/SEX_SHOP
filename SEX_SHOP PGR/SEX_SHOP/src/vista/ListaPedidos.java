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
			lblNombre.setBounds(26, 175, 77, 14);
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
			JLabel lblDescripcion = new JLabel("DESCRIPCI\u00D3N");
			lblDescripcion.setForeground(new Color(255, 20, 147));
			lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDescripcion.setBounds(143, 84, 149, 14);
			contentPanel.add(lblDescripcion);
		}
		{
			JLabel lblDescripcion = new JLabel("DESCRIPCI\u00D3N");
			lblDescripcion.setForeground(new Color(255, 20, 147));
			lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDescripcion.setBounds(143, 197, 149, 14);
			contentPanel.add(lblDescripcion);
		}
		{
			JLabel lblDescripcion = new JLabel("DESCRIPCI\u00D3N");
			lblDescripcion.setForeground(new Color(255, 20, 147));
			lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDescripcion.setBounds(143, 312, 149, 14);
			contentPanel.add(lblDescripcion);
		}
		{
			JLabel lblNewLabel_Sexo = new JLabel("Precio");
			lblNewLabel_Sexo.setForeground(new Color(255, 255, 153));
			lblNewLabel_Sexo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Sexo.setBounds(143, 175, 103, 14);
			contentPanel.add(lblNewLabel_Sexo);
		}
		{
			JLabel lblNewLabel_Sexo = new JLabel("Precio");
			lblNewLabel_Sexo.setForeground(new Color(255, 255, 153));
			lblNewLabel_Sexo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Sexo.setBounds(143, 288, 103, 14);
			contentPanel.add(lblNewLabel_Sexo);
		}
		{
			JLabel lblNewLabel_Sexo = new JLabel("Precio");
			lblNewLabel_Sexo.setForeground(new Color(255, 255, 153));
			lblNewLabel_Sexo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Sexo.setBounds(143, 403, 103, 14);
			contentPanel.add(lblNewLabel_Sexo);
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
		{
			JTextPane textPane = new JTextPane();
			textPane.setBounds(143, 107, 149, 55);
			contentPanel.add(textPane);
		}
		{
			JTextPane textPane = new JTextPane();
			textPane.setBounds(143, 222, 149, 55);
			contentPanel.add(textPane);
		}
		{
			JTextPane textPane = new JTextPane();
			textPane.setBounds(143, 337, 149, 55);
			contentPanel.add(textPane);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\DAM\\SEX_SHOP\\foto1.png"));
			lblNewLabel_1.setBounds(23, 61, 73, 115);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\DAM\\SEX_SHOP\\foto2.png"));
			lblNewLabel_2.setBounds(26, 200, 77, 80);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\1dam\\Desktop\\DAM\\SEX_SHOP\\anal (1).png"));
			lblNewLabel_3.setBounds(19, 311, 84, 91);
			contentPanel.add(lblNewLabel_3);
		}
	}

}
