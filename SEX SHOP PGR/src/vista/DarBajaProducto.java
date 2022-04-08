package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;

public class Dar_baja_producto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dar_baja_producto dialog = new Dar_baja_producto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dar_baja_producto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1dam\\Downloads\\logo.png"));
		setBounds(100, 100, 503, 455);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlDkShadow);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(35, 365, 414, 2);
			contentPanel.add(separator);
		}
		{
			JButton btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnCerrar.setForeground(Color.BLACK);
			btnCerrar.setBackground(new Color(255, 255, 153));
			btnCerrar.setBounds(398, 378, 75, 25);
			contentPanel.add(btnCerrar);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 32, 414, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblNewLabel = new JLabel("Seleccione el producto que quiera dar de baja.");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(30, 58, 325, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("DAR DE BAJA EL PRODUCTO");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(10, 11, 207, 14);
			contentPanel.add(lblNewLabel_1);
		}
		
		JComboBox comboBox_Seleccion = new JComboBox();
		comboBox_Seleccion.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 20, 147), null, null, null));
		comboBox_Seleccion.setForeground(Color.WHITE);
		comboBox_Seleccion.setBackground(new Color(255, 20, 147));
		comboBox_Seleccion.setBounds(31, 83, 182, 22);
		contentPanel.add(comboBox_Seleccion);
		
		JLabel lblNewLabel_1 = new JLabel("Datos del producto seleccionado:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(35, 129, 240, 25);
		contentPanel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(216, 289, 1, -83);
		contentPanel.add(separator);
		{
			table = new JTable();
			table.setToolTipText("");
			table.setForeground(new Color(255, 20, 147));
			table.setBounds(45, 190, 366, 164);
			contentPanel.add(table);
		}
		{
			JLabel lblNewLabel_2 = new JLabel(" Nombre del producto");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setBounds(45, 165, 366, 25);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlDkShadow);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
