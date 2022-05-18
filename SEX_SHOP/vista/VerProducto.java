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
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

public class VerProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerProducto dialog = new VerProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerProducto() {
		setBounds(100, 100, 347, 505);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlDkShadow);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombreDeProducto = new JLabel("NOMBRE DE PRODUCTO");
			lblNombreDeProducto.setForeground(Color.WHITE);
			lblNombreDeProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNombreDeProducto.setBounds(57, 11, 194, 14);
			contentPanel.add(lblNombreDeProducto);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(31, 36, 251, 2);
			contentPanel.add(separator);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(31, 169, 251, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblDescripcion = new JLabel("DESCRIPCION:");
			lblDescripcion.setForeground(new Color(255, 20, 147));
			lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDescripcion.setBounds(22, 182, 194, 14);
			contentPanel.add(lblDescripcion);
		}
		{
			JLabel lblSexo = new JLabel("Sexo:");
			lblSexo.setForeground(new Color(255, 20, 147));
			lblSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblSexo.setBounds(22, 298, 76, 14);
			contentPanel.add(lblSexo);
		}
		{
			JLabel lblCategoria = new JLabel("Categoria:");
			lblCategoria.setForeground(new Color(255, 20, 147));
			lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCategoria.setBounds(22, 344, 194, 14);
			contentPanel.add(lblCategoria);
		}
		{
			JLabel lblPrecio = new JLabel("Precio:");
			lblPrecio.setForeground(new Color(255, 20, 147));
			lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPrecio.setBounds(22, 382, 76, 14);
			contentPanel.add(lblPrecio);
		}
		{
			JButton btnNewButton = new JButton("COMPRAR");
			btnNewButton.setBackground(new Color(153, 204, 153));
			btnNewButton.setBounds(31, 432, 126, 23);
			contentPanel.add(btnNewButton);
		}
		
		JTextPane textPane = new JTextPane();
		textPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), SystemColor.text, SystemColor.text, SystemColor.text));
		textPane.setBackground(SystemColor.controlDkShadow);
		textPane.setForeground(new Color(255, 255, 255));
		textPane.setBounds(32, 205, 231, 66);
		contentPanel.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.text, SystemColor.text, SystemColor.text, SystemColor.text));
		textPane_1.setBackground(SystemColor.textInactiveText);
		textPane_1.setBounds(107, 298, 120, 20);
		contentPanel.add(textPane_1);
		{
			JTextPane textPane_1_1 = new JTextPane();
			textPane_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.text, SystemColor.text, SystemColor.text, SystemColor.text));
			textPane_1_1.setBackground(SystemColor.textInactiveText);
			textPane_1_1.setBounds(120, 344, 120, 20);
			contentPanel.add(textPane_1_1);
		}
		{
			JTextPane textPane_1_1 = new JTextPane();
			textPane_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.text, SystemColor.text, SystemColor.text, SystemColor.text));
			textPane_1_1.setBackground(SystemColor.textInactiveText);
			textPane_1_1.setBounds(96, 382, 120, 20);
			contentPanel.add(textPane_1_1);
		}
		{
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\118623-SATISFYER_PRO_2_1 (1).png"));
			lblNewLabel.setBounds(131, 36, 45, 123);
			contentPanel.add(lblNewLabel);
		}
	}
}
