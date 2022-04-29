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
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Oferta extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			Oferta dialog = new Oferta(null, true);
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
	
//	public Oferta() {
//		}
	
	public Oferta(PiñaMeloco padre, boolean modal) {
		super(padre);
		this.setModal(modal);
		setBounds(100, 100, 492, 645);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlDkShadow);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 36, 414, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblNewLabel = new JLabel("OFERTAS");
			lblNewLabel.setForeground(new Color(255, 255, 153));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(10, 11, 95, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JComboBox comboBoxPrecio = new JComboBox();
			comboBoxPrecio.setForeground(Color.WHITE);
			comboBoxPrecio.setBackground(new Color(255, 105, 180));
			comboBoxPrecio.setModel(new DefaultComboBoxModel(new String[] {"0-10\u20AC", "10-20\u20AC", "20-30\u20AC", "30-40\u20AC", "40-50\u20AC", "50-100\u20AC"}));
			comboBoxPrecio.setBounds(20, 49, 95, 22);
			contentPanel.add(comboBoxPrecio);
		}
		{
			JComboBox comboBoxSexo = new JComboBox();
			comboBoxSexo.setForeground(Color.WHITE);
			comboBoxSexo.setBackground(new Color(255, 105, 180));
			comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"MUJER", "HOMBRE"}));
			comboBoxSexo.setBounds(142, 49, 95, 22);
			contentPanel.add(comboBoxSexo);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(268, 49, 95, 22);
			contentPanel.add(comboBox);
		}
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(419, 76, 17, 443);
		contentPanel.add(scrollBar);
		
		JLabel lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 153));
		lblNewLabel_1.setBounds(181, 230, 82, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Precio");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 153));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(295, 230, 75, 14);
		contentPanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Precio");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 153));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(50, 341, 82, 14);
		contentPanel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Precio");
		lblNewLabel_1_1_2.setForeground(new Color(255, 255, 153));
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(168, 341, 82, 14);
		contentPanel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Precio");
		lblNewLabel_1_1_3.setForeground(new Color(255, 255, 153));
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_3.setBounds(295, 341, 82, 14);
		contentPanel.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Precio");
		lblNewLabel_1_1_4.setForeground(new Color(255, 255, 153));
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_4.setBounds(50, 468, 82, 14);
		contentPanel.add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Precio");
		lblNewLabel_1_1_5.setForeground(new Color(255, 255, 153));
		lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_5.setBounds(181, 468, 82, 14);
		contentPanel.add(lblNewLabel_1_1_5);
		
		JLabel lblNewLabel_1_1_6 = new JLabel("Precio");
		lblNewLabel_1_1_6.setForeground(new Color(255, 255, 153));
		lblNewLabel_1_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_6.setBounds(302, 468, 82, 14);
		contentPanel.add(lblNewLabel_1_1_6);
		
		JLabel lblNewLabel_1_1_7 = new JLabel("Oferta");
		lblNewLabel_1_1_7.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_7.setBounds(50, 205, 82, 14);
		contentPanel.add(lblNewLabel_1_1_7);
		
		JLabel lblNewLabel_1_1 = new JLabel("Precio");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 153));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(50, 230, 82, 14);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_7_1 = new JLabel("Oferta");
		lblNewLabel_1_1_7_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1_7_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_7_1.setBounds(50, 316, 82, 14);
		contentPanel.add(lblNewLabel_1_1_7_1);
		
		JLabel lblNewLabel_1_1_7_2 = new JLabel("Oferta");
		lblNewLabel_1_1_7_2.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1_7_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_7_2.setBounds(50, 443, 82, 14);
		contentPanel.add(lblNewLabel_1_1_7_2);
		
		JLabel lblNewLabel_1_1_7_3 = new JLabel("Oferta");
		lblNewLabel_1_1_7_3.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1_7_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_7_3.setBounds(181, 205, 82, 14);
		contentPanel.add(lblNewLabel_1_1_7_3);
		
		JLabel lblNewLabel_1_1_7_4 = new JLabel("Oferta");
		lblNewLabel_1_1_7_4.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1_7_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_7_4.setBounds(168, 316, 82, 14);
		contentPanel.add(lblNewLabel_1_1_7_4);
		
		JLabel lblNewLabel_1_1_7_5 = new JLabel("Oferta");
		lblNewLabel_1_1_7_5.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1_7_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_7_5.setBounds(181, 443, 82, 14);
		contentPanel.add(lblNewLabel_1_1_7_5);
		
		JLabel lblNewLabel_1_1_7_6 = new JLabel("Oferta");
		lblNewLabel_1_1_7_6.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1_7_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_7_6.setBounds(295, 205, 82, 14);
		contentPanel.add(lblNewLabel_1_1_7_6);
		
		JLabel lblNewLabel_1_1_7_7 = new JLabel("Oferta");
		lblNewLabel_1_1_7_7.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1_7_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_7_7.setBounds(295, 316, 82, 14);
		contentPanel.add(lblNewLabel_1_1_7_7);
		
		JLabel lblNewLabel_1_1_7_8 = new JLabel("Oferta");
		lblNewLabel_1_1_7_8.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1_7_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_7_8.setBounds(302, 443, 82, 14);
		contentPanel.add(lblNewLabel_1_1_7_8);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\consolador (2) (2).png"));
		lblNewLabel_2.setBounds(295, 255, 48, 50);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\muneca (1) (1) (1).png"));
		lblNewLabel_3.setBounds(50, 142, 42, 52);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\consolador (1) (1) (1).png"));
		lblNewLabel_4.setBounds(50, 249, 46, 58);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\vr (1) (1).png"));
		lblNewLabel_5.setBounds(181, 140, 48, 54);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\descarga (1) (1).png"));
		lblNewLabel_6.setBounds(297, 147, 46, 50);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\anal (1) (1).png"));
		lblNewLabel_7.setBounds(168, 255, 46, 50);
		contentPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\mascara (1) (1).png"));
		lblNewLabel_8.setBounds(50, 366, 48, 66);
		contentPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\latigo (1) (1).png"));
		lblNewLabel_9.setBounds(181, 377, 48, 55);
		contentPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\descarga (2).png"));
		lblNewLabel_10.setBounds(302, 377, 48, 55);
		contentPanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBackground(SystemColor.controlDkShadow);
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\offer_50 (1).png"));
		lblNewLabel_11.setBounds(30, 82, 36, 37);
		contentPanel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\offer_20 (1).png"));
		lblNewLabel_12.setBounds(76, 82, 37, 37);
		contentPanel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\offer_10.png"));
		lblNewLabel_13.setBounds(123, 82, 36, 36);
		contentPanel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\offer_5.png"));
		lblNewLabel_14.setBounds(168, 82, 36, 36);
		contentPanel.add(lblNewLabel_14);
		
		JButton btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}

			
		});
		btnCerrar.setBackground(new Color(255, 255, 153));
		btnCerrar.setBounds(335, 562, 101, 23);
		contentPanel.add(btnCerrar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlDkShadow);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	private void cerrar() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
