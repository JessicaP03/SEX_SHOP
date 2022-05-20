package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Compra;
import clases.Producto;
import modelo.ControladorBDImplementacion;
import modelo.ControladorDatos;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lencerias extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablaProducto;
	private Map<String, Producto> productos;
	private JComboBox comboProducto;

	/**
	 * @param piñaMeloco
	 * @param modal
	 * @param datos
	 * @param producto
	 */
	public Lencerias(PiñaMeloco piñaMeloco, boolean modal, ControladorDatos datos, Producto producto) {

		super(piñaMeloco);
		this.setModal(modal);

		setBounds(100, 100, 652, 630);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlDkShadow);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("LENCERIA");
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
		separator.setBounds(31, 493, 554, 2);
		contentPanel.add(separator);

		comboProducto = new JComboBox();
		comboProducto.setBounds(137, 94, 145, 22);
		comboProducto.setIgnoreRepaint(true);
		comboProducto.setForeground(Color.WHITE);
		comboProducto.setToolTipText("");
		comboProducto.setBackground(new Color(255, 105, 180));
		contentPanel.add(comboProducto);

		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar();
			}
		});
		btnNewButton.setBounds(485, 526, 107, 46);
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

		llenarCombo(datos);
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
		scroll.setBounds(53, 217, 532, 240);
		
		JButton btnNewButton_1 = new JButton("COMPRAR PRODUCTO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprarProducto((ControladorBDImplementacion) datos);
			}
		});
		btnNewButton_1.setBackground(new Color(0, 153, 204));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(99, 138, 183, 46);
		contentPanel.add(btnNewButton_1);

	}

		protected void comprarProducto(ControladorBDImplementacion datos) {
			int codusuario = 0;
			String idproducto = null;
			if (comboProducto.getSelectedIndex()==1) {
			int input = JOptionPane.showConfirmDialog(this, "SEGURO QUE QUIERES COMPRAR?",
					"SELECIONA UNA OPCIÓN:", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (input==0) {
				Compra compra = new Compra();
				compra.setIdproducto(idproducto);
				compra.setCodusuario(codusuario);
				compra.setFecha_compra(null);
				datos.comprarProducto(compra);
		
				JOptionPane.showMessageDialog(this, "HAS COMPRADO EL PRODUCTO");
				
			}else if (input==1) {
				JOptionPane.showMessageDialog(this, "SE HA CANCELADO LA COMPRA");
			}
		}else{
			JOptionPane.showMessageDialog(this, "ELIGA UN PRODUCTO");
		}
		
		
	}

	private JTable cargarTabla(Producto producto, ControladorDatos datos) {

		String[] nombreColumnas = { "IDPRODUCTO", "NOMBRE_PROD", "CATEGORI", "SEXO", "PRECIO", "TIPO" };
		String[] registros = new String[6];

		DefaultTableModel modelo = new DefaultTableModel(null, nombreColumnas);
		modelo.setRowCount(0);

		productos = datos.listarLenceria();

		for (Producto prod : productos.values()) {
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

	private void llenarCombo(ControladorDatos datos) {

		productos = datos.listarLenceria();

		if (!productos.isEmpty()) {
			for (Producto pro : productos.values()) {
				comboProducto.addItem(pro.getNombreProd());
			}
		}
		comboProducto.setSelectedIndex(-1);

	}
	
}
