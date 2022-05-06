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

public class Lencerias extends JDialog {

	private final JPanel contentPanelLenceria = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Lencerias dialog = new Lencerias(null, true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Lencerias(PiñaMeloco padre, boolean modal) {
		super(padre);
		this.setModal(modal);
		setBounds(100, 100, 652, 789);
		getContentPane().setLayout(new BorderLayout());
		contentPanelLenceria.setBackground(SystemColor.controlDkShadow);
		contentPanelLenceria.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanelLenceria, BorderLayout.CENTER);
		contentPanelLenceria.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("JUEGUETES");
		lblNewLabel_1.setForeground(new Color(255, 20, 147));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(53, 11, 360, 41);
		contentPanelLenceria.add(lblNewLabel_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(31, 63, 554, 2);
		contentPanelLenceria.add(separator_1);
		setBounds(100, 100, 652, 789);
		getContentPane().setLayout(new BorderLayout());
		contentPanelLenceria.setBackground(SystemColor.controlDkShadow);
		contentPanelLenceria.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanelLenceria, BorderLayout.CENTER);
		contentPanelLenceria.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("JUGUETES");
			lblNewLabel.setBounds(53, 11, 360, 41);
			lblNewLabel.setBackground(new Color(255, 105, 180));
			lblNewLabel.setForeground(new Color(255, 105, 180));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			contentPanelLenceria.add(lblNewLabel);
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
		
		JLabel lblNewLabel_2 = new JLabel("PRECIO");
		lblNewLabel_2.setBounds(63, 96, 107, 14);
		lblNewLabel_2.setForeground(new Color(255, 255, 153));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		contentPanelLenceria.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("SEXO");
		lblNewLabel_2_1.setBounds(218, 96, 107, 14);
		lblNewLabel_2_1.setForeground(new Color(255, 255, 153));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPanelLenceria.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Desc:");
		lblNewLabel_3.setBounds(299, 185, 107, 14);
		lblNewLabel_3.setBackground(new Color(255, 105, 180));
		lblNewLabel_3.setForeground(new Color(255, 105, 180));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanelLenceria.add(lblNewLabel_3);
		
		JTextPane textPanel_Desc = new JTextPane();
		textPanel_Desc.setBackground(SystemColor.controlDkShadow);
		textPanel_Desc.setBounds(299, 210, 209, 97);
		textPanel_Desc.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204)));
		contentPanelLenceria.add(textPanel_Desc);
		
		JLabel lblNewLabel_Precio1 = new JLabel("Precio");
		lblNewLabel_Precio1.setBounds(309, 323, 132, 22);
		lblNewLabel_Precio1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_Precio1.setForeground(new Color(255, 255, 153));
		contentPanelLenceria.add(lblNewLabel_Precio1);
		
		JLabel lblNewLabel_Nombre = new JLabel("NOMBRE");
		lblNewLabel_Nombre.setBounds(78, 327, 107, 14);
		lblNewLabel_Nombre.setForeground(new Color(255, 105, 180));
		lblNewLabel_Nombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_Nombre.setBackground(new Color(255, 105, 180));
		contentPanelLenceria.add(lblNewLabel_Nombre);
		
		JTextPane textPane_Desc = new JTextPane();
		textPane_Desc.setBackground(SystemColor.controlDkShadow);
		textPane_Desc.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204)));
		textPane_Desc.setBounds(299, 430, 209, 97);
		contentPanelLenceria.add(textPane_Desc);
		
		JLabel lblNewLabel_Imagen = new JLabel("");
		lblNewLabel_Imagen.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 204), new Color(0, 255, 255), new Color(255, 153, 102), new Color(255, 153, 204)));
		lblNewLabel_Imagen.setBounds(53, 187, 148, 120);
		contentPanelLenceria.add(lblNewLabel_Imagen);
		
		JLabel lblNewLabel_Imagen2 = new JLabel("");
		lblNewLabel_Imagen2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 204), new Color(0, 255, 255), new Color(255, 153, 102), new Color(255, 153, 204)));
		lblNewLabel_Imagen2.setBounds(53, 408, 148, 120);
		contentPanelLenceria.add(lblNewLabel_Imagen2);
		
		JLabel lblNewLabel_Precio2 = new JLabel("Precio");
		lblNewLabel_Precio2.setForeground(new Color(255, 255, 153));
		lblNewLabel_Precio2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_Precio2.setBounds(309, 538, 132, 22);
		contentPanelLenceria.add(lblNewLabel_Precio2);
		
		JLabel lblNewLabel_Nombre2 = new JLabel("NOMBRE");
		lblNewLabel_Nombre2.setForeground(new Color(255, 105, 180));
		lblNewLabel_Nombre2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_Nombre2.setBackground(new Color(255, 105, 180));
		lblNewLabel_Nombre2.setBounds(78, 548, 107, 14);
		contentPanelLenceria.add(lblNewLabel_Nombre2);
	}
	
	//MEtodos
		private void cerrar() {
			this.dispose();
			
		}
}
