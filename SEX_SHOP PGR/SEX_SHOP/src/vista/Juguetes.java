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

public class Juguetes extends JDialog implements ItemListener {

	private final JPanel contentPanel = new JPanel();
	private Map<String, Producto> productos;
	private JTable tablaProducto;
	private JTextField textBuscador;
	private TableRowSorter<DefaultTableModel> sorter;
	private JComboBox comboProducto;
	private TableRowSorter trsfiltro;
	private DefaultTableModel modelo;

	public Juguetes(PiñaMeloco piñaMeloco, boolean modal, ControladorDatos datos, Producto producto) {

		super(piñaMeloco);
		this.setModal(modal);
		llenarCombo(datos);
		setBounds(100, 100, 652, 789);
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
		separator.setBounds(31, 680, 554, 2);
		contentPanel.add(separator);

		comboProducto = new JComboBox();
		comboProducto.setBounds(129, 101, 107, 22);
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
		btnNewButton.setBounds(489, 693, 107, 46);
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

		JLabel lblNewLabel_2_1 = new JLabel("CANTIDAD");
		lblNewLabel_2_1.setBounds(31, 147, 107, 14);
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
		scroll.setBounds(53, 294, 532, 375);

		textBuscador = new JTextField();

		textBuscador.setBackground(new Color(204, 204, 255));
		textBuscador.setBounds(411, 88, 168, 34);
		contentPanel.add(textBuscador);
		textBuscador.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner.setBounds(130, 146, 30, 20);
		contentPanel.add(spinner);
		
		JButton btnComprar = new JButton("COMPRAR PRODUCTO");
		btnComprar.setBackground(new Color(154, 205, 50));
		btnComprar.setForeground(Color.BLACK);
		btnComprar.setBounds(411, 204, 174, 46);
		contentPanel.add(btnComprar);
		
		JLabel lblPrecio = new JLabel("PRECIO");
		lblPrecio.setForeground(new Color(255, 255, 153));
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.setBounds(31, 191, 107, 14);
		contentPanel.add(lblPrecio);
		
		JLabel lblImporte = new JLabel("IMPORTE");
		lblImporte.setForeground(new Color(255, 255, 153));
		lblImporte.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblImporte.setBounds(31, 239, 107, 14);
		contentPanel.add(lblImporte);
		
		JLabel lblPrecio_1 = new JLabel("0.00\u20AC");
		lblPrecio_1.setBackground(new Color(216, 191, 216));
		lblPrecio_1.setForeground(new Color(255, 192, 203));
		lblPrecio_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio_1.setBounds(129, 193, 107, 14);
		contentPanel.add(lblPrecio_1);
		
		JLabel lblPrecio_2 = new JLabel("0.00\u20AC");
		lblPrecio_2.setForeground(new Color(255, 192, 203));
		lblPrecio_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio_2.setBounds(129, 239, 107, 14);
		contentPanel.add(lblPrecio_2);

	}

	private JTable cargarTabla(Producto producto, ControladorDatos datos) {
		// ASIGNAR LOS NOMBRES DE LAS COLUMNAS
		String[] nombreColumnas = { "IDPRODUCTO", "NOMBRE_PROD", "CATEGORI", "SEXO", "PRECIO", "TIPO" };
		String[] registros = new String[6];
		double precio=0;
		int cantidad=0;

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
		
		productos= datos.listarJuguetes();

		for (int i=0; i< productos.size();i++) {
			comboProducto.addItem(productos.get(i).getNombreProd());
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
