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
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.nio.file.AccessMode;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Juguetes extends JDialog {

	private final JPanel contentPanelJuguetes = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Juguetes dialog = new Juguetes(null, true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param b 
	 * @param piñaMeloco 
	 */
	//este constructor no lo necesitamos
//	public Juguetes() {
//		
//	}
//	
	//Usamos este segundo constructor para llamar a la ventana padre
	public Juguetes(PiñaMeloco padre, boolean modal	) {
		super(padre);
		this.setModal(modal);
		setBounds(100, 100, 652, 789);
		getContentPane().setLayout(new BorderLayout());
		contentPanelJuguetes.setBackground(SystemColor.controlDkShadow);
		contentPanelJuguetes.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanelJuguetes, BorderLayout.CENTER);
		contentPanelJuguetes.setLayout(null);
		{
			JLabel lblJuguetes = new JLabel("JUGUETES");
			lblJuguetes.setBounds(53, 11, 360, 41);
			lblJuguetes.setBackground(new Color(255, 105, 180));
			lblJuguetes.setForeground(new Color(255, 105, 180));
			lblJuguetes.setFont(new Font("Tahoma", Font.BOLD, 18));
			contentPanelJuguetes.add(lblJuguetes);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(31, 63, 554, 2);
			contentPanelJuguetes.add(separator);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 680, 554, 2);
		contentPanelJuguetes.add(separator);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(568, 86, 17, 550);
		contentPanelJuguetes.add(scrollBar);
		
		JComboBox comboBox_Precio = new JComboBox();
		comboBox_Precio.setBounds(63, 121, 107, 22);
		comboBox_Precio.setIgnoreRepaint(true);
		comboBox_Precio.setForeground(Color.WHITE);
		comboBox_Precio.setModel(new DefaultComboBoxModel(new String[] {"0-10 \u20AC", "10-20 \u20AC", "30-40\u20AC", "40-50\u20AC", "50-100\u20AC"}));
		comboBox_Precio.setToolTipText("");
		comboBox_Precio.setBackground(new Color(255, 105, 180));
		contentPanelJuguetes.add(comboBox_Precio);
		
		JComboBox comboBox_Sexo = new JComboBox();
		comboBox_Sexo.setBounds(218, 121, 107, 22);
		comboBox_Sexo.setModel(new DefaultComboBoxModel(new String[] {"MUJER", "HOMBRE"}));
		comboBox_Sexo.setToolTipText("");
		comboBox_Sexo.setIgnoreRepaint(true);
		comboBox_Sexo.setForeground(Color.WHITE);
		comboBox_Sexo.setBackground(new Color(255, 105, 180));
		contentPanelJuguetes.add(comboBox_Sexo);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}

			
		});
		btnCerrar.setBounds(489, 693, 107, 46);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCerrar.setBackground(new Color(255, 255, 153));
		contentPanelJuguetes.add(btnCerrar);
		
		JLabel lblPrecio2 = new JLabel("PRECIO");
		lblPrecio2.setBounds(63, 96, 107, 14);
		lblPrecio2.setForeground(new Color(255, 255, 153));
		lblPrecio2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio2.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		contentPanelJuguetes.add(lblPrecio2);
		
		JLabel lblSexo = new JLabel("SEXO");
		lblSexo.setBounds(218, 96, 107, 14);
		lblSexo.setForeground(new Color(255, 255, 153));
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPanelJuguetes.add(lblSexo);
		
		JLabel lblDESC = new JLabel("Desc:");
		lblDESC.setBounds(299, 185, 107, 14);
		lblDESC.setBackground(new Color(255, 105, 180));
		lblDESC.setForeground(new Color(255, 105, 180));
		lblDESC.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanelJuguetes.add(lblDESC);
		
		JTextPane textPanel_Desc = new JTextPane();
		textPanel_Desc.setBackground(SystemColor.controlDkShadow);
		textPanel_Desc.setBounds(299, 210, 209, 97);
		textPanel_Desc.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204)));
		contentPanelJuguetes.add(textPanel_Desc);
		
		JLabel lblPrecio1 = new JLabel("Precio");
		lblPrecio1.setBounds(309, 323, 132, 22);
		lblPrecio1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrecio1.setForeground(new Color(255, 255, 153));
		contentPanelJuguetes.add(lblPrecio1);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(78, 327, 107, 14);
		lblNombre.setForeground(new Color(255, 105, 180));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBackground(new Color(255, 105, 180));
		contentPanelJuguetes.add(lblNombre);
		
		JTextPane textPane_Desc = new JTextPane();
		textPane_Desc.setBackground(SystemColor.controlDkShadow);
		textPane_Desc.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204), new Color(255, 153, 204)));
		textPane_Desc.setBounds(299, 430, 209, 97);
		contentPanelJuguetes.add(textPane_Desc);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 204), new Color(0, 255, 255), new Color(255, 153, 102), new Color(255, 153, 204)));
		lblImagen.setBounds(53, 187, 148, 120);
		contentPanelJuguetes.add(lblImagen);
		
		JLabel lblImagen2 = new JLabel("");
		lblImagen2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 204), new Color(0, 255, 255), new Color(255, 153, 102), new Color(255, 153, 204)));
		lblImagen2.setBounds(53, 408, 148, 120);
		contentPanelJuguetes.add(lblImagen2);
		
		JLabel lblPrecio3 = new JLabel("Precio");
		lblPrecio3.setForeground(new Color(255, 255, 153));
		lblPrecio3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrecio3.setBounds(309, 538, 132, 22);
		contentPanelJuguetes.add(lblPrecio3);
		
		JLabel lblNombre2 = new JLabel("NOMBRE");
		lblNombre2.setForeground(new Color(255, 105, 180));
		lblNombre2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre2.setBackground(new Color(255, 105, 180));
		lblNombre2.setBounds(78, 548, 107, 14);
		contentPanelJuguetes.add(lblNombre2);
	}
	
	//MEtodos
	private void cerrar() {
		this.dispose();
		
	}
}
