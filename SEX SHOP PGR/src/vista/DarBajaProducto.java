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

public class DarBajaProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			DarBajaProducto dialog = new DarBajaProducto();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * Create the dialog.
//	 */
//	//Con el segundo constructor no hace falta este
//	public DarBajaProducto() {
//	
//	}

	public DarBajaProducto(Configuracion padre, boolean modal) {
		super(padre);
		this.setModal(modal);
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
			btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				cerrar();
				}
			});
			btnCerrar.setForeground(Color.BLACK);
			btnCerrar.setBackground(new Color(255, 255, 153));
			btnCerrar.setBounds(362, 378, 111, 25);
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
			JLabel lblNewLabel_BajaProduc = new JLabel("DAR DE BAJA EL PRODUCTO");
			lblNewLabel_BajaProduc.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_BajaProduc.setForeground(Color.WHITE);
			lblNewLabel_BajaProduc.setBounds(10, 11, 207, 14);
			contentPanel.add(lblNewLabel_BajaProduc);
		}
		
		JComboBox comboBox_Seleccion = new JComboBox();
		comboBox_Seleccion.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 20, 147), null, null, null));
		comboBox_Seleccion.setForeground(Color.WHITE);
		comboBox_Seleccion.setBackground(new Color(255, 20, 147));
		comboBox_Seleccion.setBounds(31, 83, 182, 22);
		contentPanel.add(comboBox_Seleccion);
		
		JLabel lblNewLabel_SeleccionProduc = new JLabel("Datos del producto seleccionado:");
		lblNewLabel_SeleccionProduc.setForeground(Color.WHITE);
		lblNewLabel_SeleccionProduc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_SeleccionProduc.setBounds(35, 129, 240, 25);
		contentPanel.add(lblNewLabel_SeleccionProduc);
		
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
			JLabel lblNewLabel_Nombreproduc = new JLabel(" Nombre del producto");
			lblNewLabel_Nombreproduc.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Nombreproduc.setForeground(Color.WHITE);
			lblNewLabel_Nombreproduc.setBounds(45, 165, 366, 25);
			contentPanel.add(lblNewLabel_Nombreproduc);
		}
		{
			JButton btnNewButton = new JButton("Aceptar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cerrar();
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton.setBackground(new Color(255, 255, 102));
			btnNewButton.setBounds(22, 379, 101, 23);
			contentPanel.add(btnNewButton);
		}
	}
	
	//Metodos
	private void cerrar() {
		this.dispose();
		
	}
}
