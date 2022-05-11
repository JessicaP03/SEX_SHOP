package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PiñaMeloco extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PiñaMeloco dialog = new PiñaMeloco();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PiñaMeloco() {
		setBounds(100, 100, 470, 433);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlDkShadow);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 32, 414, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblNewLabel = new JLabel("PI\u00D1A-MELOCO");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(10, 7, 134, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnOferta = new JButton("OFERTA");
			btnOferta.setBackground(new Color(153, 204, 255));
			btnOferta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnOferta.setBounds(261, 59, 89, 23);
			contentPanel.add(btnOferta);
		}
		{
			JButton btnNewButton = new JButton("CERRAR");
			btnNewButton.setBackground(new Color(255, 255, 153));
			btnNewButton.setBounds(360, 361, 89, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnVerListaCompra = new JButton("VER LISTA COMPRA");
			btnVerListaCompra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnVerListaCompra.setBackground(new Color(255, 255, 153));
			btnVerListaCompra.setBounds(10, 362, 147, 23);
			contentPanel.add(btnVerListaCompra);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Seleccione que desea hacer.");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBackground(Color.WHITE);
			lblNewLabel_1.setBounds(22, 96, 211, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JButton btnNewButton_1 = new JButton("JUGUETES");
			btnNewButton_1.setBackground(new Color(255, 20, 147));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.setBounds(26, 129, 118, 23);
			contentPanel.add(btnNewButton_1);
		}
		{
			JButton btnNewButton_2 = new JButton("COSMETICOS");
			btnNewButton_2.setForeground(Color.WHITE);
			btnNewButton_2.setBackground(new Color(255, 20, 147));
			btnNewButton_2.setBounds(25, 186, 119, 23);
			contentPanel.add(btnNewButton_2);
		}
		{
			JButton btnNewButton_3 = new JButton("LENCERIA");
			btnNewButton_3.setForeground(Color.WHITE);
			btnNewButton_3.setBackground(new Color(255, 20, 147));
			btnNewButton_3.setBounds(26, 250, 118, 23);
			contentPanel.add(btnNewButton_3);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 342, 421, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\7305821 (1).png"));
			lblNewLabel_2.setBounds(376, 45, 46, 50);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\descarga (3) (3) (1).png"));
			lblNewLabel_3.setBounds(282, 129, 124, 180);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlDkShadow);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
