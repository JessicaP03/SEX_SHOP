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

public class Lenceria extends JDialog {

	private final JPanel contentPanelLenceria = new JPanel();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			Lenceria dialog = new Lenceria(null, true);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @param b 
	 * @param piñaMeloco 
	 */
//	public Lenceria() {
//		
//	}
	
	public Lenceria(PiñaMeloco padre, boolean modal) {
		super(padre);
		this.setModal(modal);
		
		
		JLabel lblNewLabel_1 = new JLabel("JUEGUETES");
		lblNewLabel_1.setForeground(new Color(255, 20, 147));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(53, 11, 360, 41);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(31, 63, 554, 2);

		setBounds(100, 100, 652, 789);
		getContentPane().setLayout(new BorderLayout());
		contentPanelLenceria.setBackground(SystemColor.controlDkShadow);
		contentPanelLenceria.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanelLenceria, BorderLayout.CENTER);
		contentPanelLenceria.setLayout(null);
		{
			JLabel lblLenceria = new JLabel("LENCERIA");
			lblLenceria.setBounds(53, 11, 360, 41);
			lblLenceria.setBackground(new Color(255, 105, 180));
			lblLenceria.setForeground(new Color(255, 105, 180));
			lblLenceria.setFont(new Font("Tahoma", Font.BOLD, 16));
			contentPanelLenceria.add(lblLenceria);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(31, 63, 554, 2);
			contentPanelLenceria.add(separator);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 680, 554, 2);
		contentPanelLenceria.add(separator);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(568, 86, 17, 550);
		contentPanelLenceria.add(scrollBar);
		
		JComboBox comboBox_Precio = new JComboBox();
		comboBox_Precio.setBounds(63, 121, 107, 22);
		comboBox_Precio.setIgnoreRepaint(true);
		comboBox_Precio.setForeground(Color.WHITE);
		comboBox_Precio.setModel(new DefaultComboBoxModel(new String[] {"0-10 \u20AC", "10-20 \u20AC", "30-40\u20AC", "40-50\u20AC", "50-100\u20AC"}));
		comboBox_Precio.setToolTipText("");
		comboBox_Precio.setBackground(new Color(255, 105, 180));
		contentPanelLenceria.add(comboBox_Precio);
		
		JComboBox comboBox_Sexo = new JComboBox();
		comboBox_Sexo.setBounds(218, 121, 107, 22);
		comboBox_Sexo.setModel(new DefaultComboBoxModel(new String[] {"MUJER", "HOMBRE"}));
		comboBox_Sexo.setToolTipText("");
		comboBox_Sexo.setIgnoreRepaint(true);
		comboBox_Sexo.setForeground(Color.WHITE);
		comboBox_Sexo.setBackground(new Color(255, 105, 180));
		contentPanelLenceria.add(comboBox_Sexo);
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}

			
		});
		btnNewButton.setBounds(489, 693, 107, 46);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(255, 255, 153));
		contentPanelLenceria.add(btnNewButton);
		
		JLabel lblPrecio = new JLabel("PRECIO");
		lblPrecio.setBounds(63, 96, 107, 14);
		lblPrecio.setForeground(new Color(255, 255, 153));
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		contentPanelLenceria.add(lblPrecio);
		
		JLabel lblSexo = new JLabel("SEXO");
		lblSexo.setBounds(218, 96, 107, 14);
		lblSexo.setForeground(new Color(255, 255, 153));
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPanelLenceria.add(lblSexo);
		
		JLabel lblDESC = new JLabel("Desc:");
		lblDESC.setBounds(299, 185, 107, 14);
		lblDESC.setBackground(new Color(255, 105, 180));
		lblDESC.setForeground(new Color(255, 105, 180));
		lblDESC.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanelLenceria.add(lblDESC);
		
		JTextPane textPanelDesc = new JTextPane();
		textPanelDesc.setBackground(SystemColor.controlDkShadow);
		textPanelDesc.setBounds(299, 210, 209, 97);
		textPanelDesc.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204)));
		contentPanelLenceria.add(textPanelDesc);
		
		JLabel lblPrecio1 = new JLabel("Precio");
		lblPrecio1.setBounds(309, 323, 132, 22);
		lblPrecio1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrecio1.setForeground(new Color(255, 255, 153));
		contentPanelLenceria.add(lblPrecio1);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(78, 327, 107, 14);
		lblNombre.setForeground(new Color(255, 105, 180));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBackground(new Color(255, 105, 180));
		contentPanelLenceria.add(lblNombre);
		
		JTextPane textPaneDesc2 = new JTextPane();
		textPaneDesc2.setBackground(SystemColor.controlDkShadow);
		textPaneDesc2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204)));
		textPaneDesc2.setBounds(299, 430, 209, 97);
		contentPanelLenceria.add(textPaneDesc2);
		
		JLabel lblNFoto = new JLabel("");
		lblNFoto.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 204), new Color(0, 255, 255), new Color(255, 153, 102), new Color(255, 153, 204)));
		lblNFoto.setBounds(53, 187, 148, 120);
		contentPanelLenceria.add(lblNFoto);
		
		JLabel lblNoFoto = new JLabel("");
		lblNoFoto.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 204), new Color(0, 255, 255), new Color(255, 153, 102), new Color(255, 153, 204)));
		lblNoFoto.setBounds(53, 408, 148, 120);
		contentPanelLenceria.add(lblNoFoto);
		
		JLabel lblPrecio2 = new JLabel("Precio");
		lblPrecio2.setForeground(new Color(255, 255, 153));
		lblPrecio2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrecio2.setBounds(309, 538, 132, 22);
		contentPanelLenceria.add(lblPrecio2);
		
		JLabel lblNombre2 = new JLabel("NOMBRE");
		lblNombre2.setForeground(new Color(255, 105, 180));
		lblNombre2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre2.setBackground(new Color(255, 105, 180));
		lblNombre2.setBounds(78, 548, 107, 14);
		contentPanelLenceria.add(lblNombre2);
	}
	private void cerrar() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
