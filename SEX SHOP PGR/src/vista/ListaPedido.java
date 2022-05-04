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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaPedido extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ListaPedido dialog = new ListaPedido();
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
	public ListaPedido(PiñaMeloco padre, boolean modal) {
		super(padre);
		this.setModal(modal);
		
		setForeground(SystemColor.desktop);
		setBounds(100, 100, 446, 573);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlDkShadow);
		contentPanel.setForeground(SystemColor.controlDkShadow);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LISTA DE  PEDIDOS REALIZADOS");
		lblNewLabel.setForeground(new Color(255, 20, 147));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 23, 309, 14);
		contentPanel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 48, 393, 2);
		contentPanel.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("LISTA DE PEDIDOS");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(20, 61, 211, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("FECHA PEDIDO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(20, 86, 135, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Desc:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(238, 130, 238));
		lblNewLabel_3.setBounds(214, 113, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_2 = new JLabel("Desc:");
		lblNewLabel_3_2.setForeground(new Color(238, 130, 238));
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(214, 231, 46, 14);
		contentPanel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4 = new JLabel("NOMBRE");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setForeground(new Color(238, 130, 238));
		lblNewLabel_4.setBounds(67, 206, 63, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("20.99\u20AC");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setForeground(new Color(255, 215, 0));
		lblNewLabel_5.setBounds(214, 206, 67, 14);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("20.99\u20AC");
		lblNewLabel_5_1.setForeground(new Color(255, 215, 0));
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_1.setBounds(214, 321, 67, 14);
		contentPanel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("NOMBRE");
		lblNewLabel_4_1.setForeground(new Color(238, 130, 238));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(67, 321, 63, 14);
		contentPanel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("20.99\u20AC");
		lblNewLabel_5_1_1.setForeground(new Color(255, 215, 0));
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_1_1.setBounds(214, 437, 67, 14);
		contentPanel.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Desc:");
		lblNewLabel_3_2_1.setForeground(new Color(238, 130, 238));
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1.setBounds(214, 345, 46, 14);
		contentPanel.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("NOMBRE");
		lblNewLabel_4_1_1.setForeground(new Color(238, 130, 238));
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1_1.setBounds(67, 437, 63, 14);
		contentPanel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\viagra (1) (1).png"));
		lblNewLabel_6.setBounds(67, 139, 46, 40);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\condon (1) (1).png"));
		lblNewLabel_7.setBounds(67, 256, 52, 47);
		contentPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\4380221 (1).png"));
		lblNewLabel_8.setBounds(67, 368, 50, 53);
		contentPanel.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("CERRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 153));
		btnNewButton.setBounds(293, 489, 89, 23);
		contentPanel.add(btnNewButton);
	}
	
	
	private void cerrar() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
