package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cosmetico extends JDialog {

	private final JPanel contentPanelCosmeticos = new JPanel();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			Cosmetico dialog = new Cosmetico(null, true);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * Create the dialog.
//	 * @param b 
//	 * @param piñaMeloco 
//	 */
//	public Cosmetico() {
//		
//		
//	}

	public Cosmetico(PiñaMeloco padre, boolean modal) {
		super(padre);
		this.setModal(modal);
		
		JLabel lblNewLabel_1 = new JLabel("COSMETICOS");
		lblNewLabel_1.setForeground(new Color(255, 20, 147));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(53, 11, 360, 41);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(31, 63, 554, 2);
		
		setBounds(100, 100, 652, 789);
		getContentPane().setLayout(new BorderLayout());
		contentPanelCosmeticos.setBackground(SystemColor.controlDkShadow);
		contentPanelCosmeticos.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanelCosmeticos, BorderLayout.CENTER);
		contentPanelCosmeticos.setLayout(null);
		{
			JLabel lblCosmeticos = new JLabel("Cosmeticos");
			lblCosmeticos.setBounds(53, 11, 360, 41);
			lblCosmeticos.setBackground(new Color(255, 105, 180));
			lblCosmeticos.setForeground(new Color(255, 105, 180));
			lblCosmeticos.setFont(new Font("Tahoma", Font.BOLD, 18));
			contentPanelCosmeticos.add(lblCosmeticos);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(31, 63, 554, 2);
			contentPanelCosmeticos.add(separator);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 680, 554, 2);
		contentPanelCosmeticos.add(separator);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(568, 86, 17, 550);
		contentPanelCosmeticos.add(scrollBar);
		
		JComboBox comboBox_Precio_2 = new JComboBox();
		comboBox_Precio_2.setBounds(379, 121, 107, 22);
		comboBox_Precio_2.setBackground(new Color(255, 105, 180));
		contentPanelCosmeticos.add(comboBox_Precio_2);
		
		JComboBox comboBox_Precio_1 = new JComboBox();
		comboBox_Precio_1.setBounds(63, 121, 107, 22);
		comboBox_Precio_1.setIgnoreRepaint(true);
		comboBox_Precio_1.setForeground(Color.WHITE);
		comboBox_Precio_1.setModel(new DefaultComboBoxModel(new String[] {"0-10 \u20AC", "10-20 \u20AC", "30-40\u20AC", "40-50\u20AC", "50-100\u20AC"}));
		comboBox_Precio_1.setToolTipText("");
		comboBox_Precio_1.setBackground(new Color(255, 105, 180));
		contentPanelCosmeticos.add(comboBox_Precio_1);
		
		JComboBox comboBox_Precio_1_1 = new JComboBox();
		comboBox_Precio_1_1.setBounds(218, 121, 107, 22);
		comboBox_Precio_1_1.setModel(new DefaultComboBoxModel(new String[] {"MUJER", "HOMBRE"}));
		comboBox_Precio_1_1.setToolTipText("");
		comboBox_Precio_1_1.setIgnoreRepaint(true);
		comboBox_Precio_1_1.setForeground(Color.WHITE);
		comboBox_Precio_1_1.setBackground(new Color(255, 105, 180));
		contentPanelCosmeticos.add(comboBox_Precio_1_1);
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}

			
		});
		btnNewButton.setBounds(489, 693, 107, 46);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(255, 255, 153));
		contentPanelCosmeticos.add(btnNewButton);
		
		JLabel lblPrecio3 = new JLabel("PRECIO");
		lblPrecio3.setBounds(63, 96, 107, 14);
		lblPrecio3.setForeground(new Color(255, 255, 153));
		lblPrecio3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio3.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		contentPanelCosmeticos.add(lblPrecio3);
		
		JLabel lblSexo = new JLabel("SEXO");
		lblSexo.setBounds(218, 96, 107, 14);
		lblSexo.setForeground(new Color(255, 255, 153));
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPanelCosmeticos.add(lblSexo);
		
		JLabel lblDEC = new JLabel("Desc:");
		lblDEC.setBounds(299, 185, 107, 14);
		lblDEC.setBackground(new Color(255, 105, 180));
		lblDEC.setForeground(new Color(255, 105, 180));
		lblDEC.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanelCosmeticos.add(lblDEC);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.controlDkShadow);
		textPane.setBounds(299, 210, 209, 97);
		textPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204)));
		contentPanelCosmeticos.add(textPane);
		
		JLabel lblPrecio4 = new JLabel("Precio");
		lblPrecio4.setBounds(309, 323, 132, 22);
		lblPrecio4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrecio4.setForeground(new Color(255, 255, 153));
		contentPanelCosmeticos.add(lblPrecio4);
		
		JLabel lblNombre2 = new JLabel("NOMBRE");
		lblNombre2.setBounds(78, 327, 107, 14);
		lblNombre2.setForeground(new Color(255, 105, 180));
		lblNombre2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre2.setBackground(new Color(255, 105, 180));
		contentPanelCosmeticos.add(lblNombre2);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(SystemColor.controlDkShadow);
		textPane_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204)));
		textPane_1.setBounds(299, 430, 209, 97);
		contentPanelCosmeticos.add(textPane_1);
		
		JLabel lblFoto2 = new JLabel("");
		lblFoto2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 204), new Color(0, 255, 255), new Color(255, 153, 102), new Color(255, 153, 204)));
		lblFoto2.setBounds(53, 187, 148, 120);
		contentPanelCosmeticos.add(lblFoto2);
		
		JLabel lblFoto = new JLabel("");
		lblFoto.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 204), new Color(0, 255, 255), new Color(255, 153, 102), new Color(255, 153, 204)));
		lblFoto.setBounds(53, 408, 148, 120);
		contentPanelCosmeticos.add(lblFoto);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(new Color(255, 255, 153));
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrecio.setBounds(309, 538, 132, 22);
		contentPanelCosmeticos.add(lblPrecio);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(new Color(255, 105, 180));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBackground(new Color(255, 105, 180));
		lblNombre.setBounds(78, 548, 107, 14);
		contentPanelCosmeticos.add(lblNombre);
	}
	
	private void cerrar() {
		// TODO Auto-generated method stub
	this.dispose();	
	}
}