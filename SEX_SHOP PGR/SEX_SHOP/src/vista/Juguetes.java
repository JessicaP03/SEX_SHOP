package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import clases.Juguete;
import clases.Producto;
import modelo.ControladorDatos;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JTree;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.nio.file.AccessMode;
import java.util.Map;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Juguetes extends JDialog implements ItemListener {

	private final JPanel contentPanel = new JPanel();
	private Map<String, Producto> productos;
	private JTable tablaProducto;
	private TableRowSorter<DefaultTableModel> sorter;
	private JComboBox comboProducto;
	private TableRowSorter trsfiltro;
	private DefaultTableModel modelo;
	Producto prod = null;
	private double precio = 0;
	private int cantidad = 0;
	private JLabel lblPrecio_1;

	/**
	 * @param piñaMeloco
	 * @param modal
	 * @param datos
	 * @param producto
	 */
	public Juguetes(PiñaMeloco piñaMeloco, boolean modal, ControladorDatos datos, Producto producto) {

		super(piñaMeloco);
		this.setModal(modal);

		setBounds(100, 100, 652, 614);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlDkShadow);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("JUGUETES");
			lblNewLabel.setBounds(53, 11, 360, 41);
			lblNewLabel.setBackground(new Color(255, 105, 180));
			lblNewLabel.setForeground(new Color(255, 105, 180));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
			contentPanel.add(lblNewLabel);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(31, 63, 554, 2);
			contentPanel.add(separator);
		}

		JSeparator separator = new JSeparator();
		separator.setBounds(45, 494, 554, 2);
		contentPanel.add(separator);

		comboProducto = new JComboBox();
		comboProducto.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		comboProducto.setBounds(129, 101, 136, 22);
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
		btnNewButton.setBounds(492, 507, 107, 46);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(255, 255, 153));
		contentPanel.add(btnNewButton);

		JLabel lblProduco = new JLabel("PRODUCTO");
		lblProduco.setBounds(31, 103, 107, 14);
		lblProduco.setForeground(new Color(255, 255, 153));
		lblProduco.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProduco.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {

			}
		});
		contentPanel.add(lblProduco);
		
		
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
		scroll.setBounds(53, 224, 532, 242);

		JButton btnComprar = new JButton("COMPRAR PRODUCTO");
		btnComprar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprarProducto();
				
			}
		});
		btnComprar.setBackground(new Color(0, 153, 204));
		btnComprar.setForeground(Color.BLACK);
		btnComprar.setBounds(66, 148, 199, 46);
		contentPanel.add(btnComprar);

	}

	protected void comprarProducto() {
		if (comboProducto.getSelectedIndex()==1) {
			int input = JOptionPane.showConfirmDialog(this, "SEGURO QUE QUIERES COMPRAR?",
					"SELECIONA UNA OPCIÓN:", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (input==0) {
				JOptionPane.showMessageDialog(this, "HAS COMPRADO EL PRODUCTO");
			}else if (input==1) {
				JOptionPane.showMessageDialog(this, "SE HA CANCELADO LA COMPRA");
			}
		}else {
			JOptionPane.showMessageDialog(this, "ELIGA UN PRODUCTO");
		}
		
		
	}



	private JTable cargarTabla(Producto producto, ControladorDatos datos) {
		// ASIGNAR LOS NOMBRES DE LAS COLUMNAS
		String[] nombreColumnas = { "IDPRODUCTO", "NOMBRE_PROD", "CATEGORI", "SEXO", "PRECIO", "TIPO" };
		String[] registros = new String[6];

		DefaultTableModel modelo = new DefaultTableModel(null, nombreColumnas);
		modelo.setRowCount(0);

		// RECOGER LOS DATOS DE JUGUETES
		productos = datos.listarJuguetes();

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

		productos = datos.listarJuguetes();

		if (!productos.isEmpty()) {
			for (Producto pro : productos.values()) {
				comboProducto.addItem(pro.getNombreProd());
			}
		}
		comboProducto.setSelectedIndex(-1);

	}

	

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}
}
