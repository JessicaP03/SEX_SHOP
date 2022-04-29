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

public class Cosmetico extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cosmetico dialog = new Cosmetico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cosmetico() {
		AbstractButton contentPanel_1 = null;
		contentPanel_1.setLayout(null);
		contentPanel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel_1.setBackground(SystemColor.controlDkShadow);
		
		JLabel lblNewLabel_1 = new JLabel("JUEGUETES");
		lblNewLabel_1.setForeground(new Color(255, 20, 147));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(53, 11, 360, 41);
		contentPanel_1.add(lblNewLabel_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(31, 63, 554, 2);
		contentPanel_1.add(separator_1);
		setBounds(100, 100, 652, 789);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlDkShadow);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Cosmeticos");
			lblNewLabel.setBounds(53, 11, 360, 41);
			lblNewLabel.setBackground(new Color(255, 105, 180));
			lblNewLabel.setForeground(new Color(255, 105, 180));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			contentPanel.add(lblNewLabel);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(31, 63, 554, 2);
			contentPanel.add(separator);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 680, 554, 2);
		contentPanel.add(separator);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(568, 86, 17, 550);
		contentPanel.add(scrollBar);
		
		JComboBox comboBox_Precio_2 = new JComboBox();
		comboBox_Precio_2.setBounds(379, 121, 107, 22);
		comboBox_Precio_2.setBackground(new Color(255, 105, 180));
		contentPanel.add(comboBox_Precio_2);
		
		JComboBox comboBox_Precio_1 = new JComboBox();
		comboBox_Precio_1.setBounds(63, 121, 107, 22);
		comboBox_Precio_1.setIgnoreRepaint(true);
		comboBox_Precio_1.setForeground(Color.WHITE);
		comboBox_Precio_1.setModel(new DefaultComboBoxModel(new String[] {"0-10 \u20AC", "10-20 \u20AC", "30-40\u20AC", "40-50\u20AC", "50-100\u20AC"}));
		comboBox_Precio_1.setToolTipText("");
		comboBox_Precio_1.setBackground(new Color(255, 105, 180));
		contentPanel.add(comboBox_Precio_1);
		
		JComboBox comboBox_Precio_1_1 = new JComboBox();
		comboBox_Precio_1_1.setBounds(218, 121, 107, 22);
		comboBox_Precio_1_1.setModel(new DefaultComboBoxModel(new String[] {"MUJER", "HOMBRE"}));
		comboBox_Precio_1_1.setToolTipText("");
		comboBox_Precio_1_1.setIgnoreRepaint(true);
		comboBox_Precio_1_1.setForeground(Color.WHITE);
		comboBox_Precio_1_1.setBackground(new Color(255, 105, 180));
		contentPanel.add(comboBox_Precio_1_1);
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.setBounds(489, 693, 107, 46);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(255, 255, 153));
		contentPanel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("PRECIO");
		lblNewLabel_2.setBounds(63, 96, 107, 14);
		lblNewLabel_2.setForeground(new Color(255, 255, 153));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("SEXO");
		lblNewLabel_2_1.setBounds(218, 96, 107, 14);
		lblNewLabel_2_1.setForeground(new Color(255, 255, 153));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Desc:");
		lblNewLabel_3.setBounds(299, 185, 107, 14);
		lblNewLabel_3.setBackground(new Color(255, 105, 180));
		lblNewLabel_3.setForeground(new Color(255, 105, 180));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel_3);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(SystemColor.controlDkShadow);
		textPane.setBounds(299, 210, 209, 97);
		textPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204)));
		contentPanel.add(textPane);
		
		JLabel lblNewLabel_4 = new JLabel("Precio");
		lblNewLabel_4.setBounds(309, 323, 132, 22);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setForeground(new Color(255, 255, 153));
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("NOMBRE");
		lblNewLabel_3_1.setBounds(78, 327, 107, 14);
		lblNewLabel_3_1.setForeground(new Color(255, 105, 180));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBackground(new Color(255, 105, 180));
		contentPanel.add(lblNewLabel_3_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(SystemColor.controlDkShadow);
		textPane_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204)));
		textPane_1.setBounds(299, 430, 209, 97);
		contentPanel.add(textPane_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 204), new Color(0, 255, 255), new Color(255, 153, 102), new Color(255, 153, 204)));
		lblNewLabel_5.setBounds(53, 187, 148, 120);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 204), new Color(0, 255, 255), new Color(255, 153, 102), new Color(255, 153, 204)));
		lblNewLabel_5_1.setBounds(53, 408, 148, 120);
		contentPanel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Precio");
		lblNewLabel_4_1.setForeground(new Color(255, 255, 153));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4_1.setBounds(309, 538, 132, 22);
		contentPanel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("NOMBRE");
		lblNewLabel_3_1_1.setForeground(new Color(255, 105, 180));
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBackground(new Color(255, 105, 180));
		lblNewLabel_3_1_1.setBounds(78, 548, 107, 14);
		contentPanel.add(lblNewLabel_3_1_1);
	}
}