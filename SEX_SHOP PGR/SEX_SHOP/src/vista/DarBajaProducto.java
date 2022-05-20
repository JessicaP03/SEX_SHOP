package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Empleado;
import clases.Producto;
import modelo.ControladorBDImplementacion;
import modelo.ControladorDatos;

import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import java.awt.ComponentOrientation;
import javax.swing.JTable;

/**
 * @author 1dam
 *
 */
public class DarBajaProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablaProducto;
	private Map<String, Producto> productos;
	private JTextField textID;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public DarBajaProducto(Configuracion padre, boolean modal, ControladorDatos datos, Producto producto) {

		super(padre);
		this.setModal(modal);

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1dam\\Downloads\\logo.png"));
		setBounds(100, 100, 539, 523);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlDkShadow);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(67, 423, 388, 2);
			contentPanel.add(separator);
		}
		{
			JButton btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cerrar();
				}
			});
			btnCerrar.setForeground(Color.BLACK);
			btnCerrar.setBackground(new Color(255, 255, 153));
			btnCerrar.setBounds(354, 436, 75, 25);
			contentPanel.add(btnCerrar);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 32, 414, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblNewLabel = new JLabel("Seleccione el producto que quiera dar de baja.");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(30, 58, 325, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("DAR DE BAJA EL PRODUCTO");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(10, 11, 207, 14);
			contentPanel.add(lblNewLabel_1);
		}

		JLabel lblNewLabel_1 = new JLabel("Datos del producto seleccionado:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(48, 130, 240, 25);
		contentPanel.add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(216, 289, 1, -83);
		contentPanel.add(separator);
		{
			JLabel lblNewLabel_2 = new JLabel(" Nombre del producto");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setBounds(45, 165, 366, 25);
			contentPanel.add(lblNewLabel_2);
		}

		JButton btnBaja = new JButton("BAJA");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				eliminarProducto(datos);
			}
		});
		btnBaja.setForeground(Color.BLACK);
		btnBaja.setBackground(new Color(255, 255, 153));
		btnBaja.setBounds(55, 436, 87, 25);
		contentPanel.add(btnBaja);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlDkShadow);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}

		this.presentarTabla(producto, datos);

	}

	protected void cerrar() {
		this.dispose();
	}

	protected void eliminarProducto(ControladorDatos datos) {
		Producto prod;
		prod = new Producto();

		
		prod.setIdProducto(textID.getText());
		datos.eliminarProducto(prod);
	
		JOptionPane.showMessageDialog(this, "PRODUCTO ELIMINADO CORRECTAMENTE");

	}

	private void presentarTabla(Producto producto, ControladorDatos datos) {

		JScrollPane scroll = new JScrollPane();
		scroll.setBackground(Color.PINK);
		tablaProducto = this.cargarTabla(producto, datos);
		scroll.setViewportView(tablaProducto);

		contentPanel.add(scroll);
		scroll.setBounds(55, 201, 414, 191);

		textID = new JTextField();
		textID.setBounds(48, 99, 133, 20);
		contentPanel.add(textID);
		textID.setColumns(10);

	}

	private JTable cargarTabla(Producto producto, ControladorDatos datos) {

		String[] nombreColumnas = { "IDPRODUCTO", "NOMBRE_PROD", "CATEGORI", "SEXO", "PRECIO", "TIPO" };
		String[] registros = new String[6];

		DefaultTableModel modelo = new DefaultTableModel(null, nombreColumnas);
		modelo.setRowCount(0);

		productos = datos.listarProducto();

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

	protected void baja(ControladorDatos datos, ModificarProducto modificar) {
		Producto prod= modificar.leerDatosPantalla(textID.getText());
		
		datos.eliminarProducto(prod);
		
		JOptionPane.showMessageDialog(this, "PRODUCTO ELIMINADO CORRECTAMENTE");
	}
	


}
