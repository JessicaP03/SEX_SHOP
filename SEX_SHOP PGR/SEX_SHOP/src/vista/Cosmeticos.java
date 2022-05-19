package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Producto;
import modelo.ControladorDatos;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cosmeticos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Map <String, Producto> productos;
	private JTable tablaProducto;
	

	public Cosmeticos(PiñaMeloco piñaMeloco, boolean modal, ControladorDatos datos, Producto producto) {
		super(piñaMeloco);
		this.setModal(modal);
		
		setBounds(100, 100, 652, 789);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlDkShadow);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("COSMETICOS");
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
		
		JComboBox comboBox_Precio = new JComboBox();
		comboBox_Precio.setBounds(63, 121, 107, 22);
		comboBox_Precio.setIgnoreRepaint(true);
		comboBox_Precio.setForeground(Color.WHITE);
		comboBox_Precio.setModel(new DefaultComboBoxModel(new String[] {"0-10 \u20AC", "10-20 \u20AC", "30-40\u20AC", "40-50\u20AC", "50-100\u20AC"}));
		comboBox_Precio.setToolTipText("");
		comboBox_Precio.setBackground(new Color(255, 105, 180));
		contentPanel.add(comboBox_Precio);
		
		JComboBox comboBox_Sexo = new JComboBox();
		comboBox_Sexo.setBounds(218, 121, 107, 22);
		comboBox_Sexo.setModel(new DefaultComboBoxModel(new String[] {"MUJER", "HOMBRE"}));
		comboBox_Sexo.setToolTipText("");
		comboBox_Sexo.setIgnoreRepaint(true);
		comboBox_Sexo.setForeground(Color.WHITE);
		comboBox_Sexo.setBackground(new Color(255, 105, 180));
		contentPanel.add(comboBox_Sexo);
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
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
	
	
	this.presentarTabla(producto, datos);
	}
	
	
	
	
	protected void cerrar() {
		this.dispose();
		
	}




	private void presentarTabla(Producto producto, ControladorDatos datos) {
		
		JScrollPane scroll = new JScrollPane();
		scroll.setForeground(Color.BLACK);
		scroll.setBackground(Color.GRAY);
		tablaProducto = this.cargarTabla(producto, datos);
		scroll.setViewportView(tablaProducto);

		contentPanel.add(scroll);
		scroll.setBounds(53,170,532,499);
	

	}
	
	private JTable cargarTabla(Producto producto, ControladorDatos datos) {
		
		String[] nombreColumnas = { "IDPRODUCTO", "NOMBRE_PROD", "CATEGORI", "SEXO", "PRECIO", "TIPO" };
		String[] registros = new String[6];
		

		DefaultTableModel modelo = new DefaultTableModel(null, nombreColumnas);
		modelo.setRowCount(0);
		
		productos= datos.listarCosmetico();
		
		for(Producto prod: productos.values()) {
			registros[0] = prod.getIdProducto();
			registros[1] = prod.getNombreProd();
			registros[2] = prod.getCategoria();
			registros[3] = prod.getSexo();
			registros[4] = String.valueOf(prod.getPrecio());
			registros[5] = prod.getTipo();
			
			modelo.addRow(registros);
		}	
		
		return new JTable(modelo);
		
	}
}