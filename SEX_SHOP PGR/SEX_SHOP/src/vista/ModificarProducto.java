package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Cosmetico;
import clases.Juguete;
import clases.Lenceria;
import clases.Producto;
import modelo.ControladorBDImplementacion;
import modelo.ControladorDatos;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ModificarProducto extends JDialog {

	/**
	 * Launch the application.
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_IDProducto;
	private JTextField textField_NombreProd;
	private JTextField textField_Ingredientes;
	private JTextField textField_Precio;
	private JTextField textField_Tipo;
	private JTextField textField_Material;
	private JTextField textField_Caducidad;

	private ButtonGroup categoria;
	private JRadioButton rdbtnLenceria, rdbtnJuguete, rdbtnCosmetico;
	private JLabel lblIngredientes, lblTalla, lblCaducidad, lblMaterial;
	private JTextField textID, textCaducidad, textMaterial, textPrecio, textIngredientes, textNombreProd, textTipo;
	private JComboBox comboTalla;
	private JComboBox comboSexo;
	private ControladorDatos datos;
	private JTable tablaProducto;
	private Map<String, Producto> productos;

	public static void main(String[] args) {
		try {
			ModificarProducto dialog = new ModificarProducto(null, true, null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Creamos este segundo constructor para saber cual es la ventana padre
	public ModificarProducto(Configuracion padre, boolean modal, ControladorDatos datos, Producto producto) {
		super(padre);
		this.setModal(modal);
		setForeground(new Color(0, 0, 0));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBackground(new Color(0, 0, 0));
		setBounds(100, 100, 971, 520);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlDkShadow);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Modificar producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(32, 11, 133, 17);
		contentPanel.add(lblNewLabel);
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(32, 36, 894, 9);
			contentPanel.add(separator);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Introduce  el ID del producto que deseas modificar");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(32, 39, 338, 28);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_IDProducto = new JLabel("ID Producto");
			lblNewLabel_IDProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_IDProducto.setBackground(new Color(255, 20, 147));
			lblNewLabel_IDProducto.setForeground(new Color(255, 255, 153));
			lblNewLabel_IDProducto.setBounds(32, 78, 133, 14);
			contentPanel.add(lblNewLabel_IDProducto);
		}
		{
			JLabel lblNewLabel_NombreProducto = new JLabel("Nombre del producto ");
			lblNewLabel_NombreProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_NombreProducto.setForeground(new Color(255, 255, 153));
			lblNewLabel_NombreProducto.setBounds(32, 110, 170, 14);
			contentPanel.add(lblNewLabel_NombreProducto);
		}
		{
			JLabel lblNewLabel_Sexo = new JLabel("Sexo");
			lblNewLabel_Sexo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Sexo.setForeground(new Color(255, 255, 153));
			lblNewLabel_Sexo.setBounds(32, 174, 103, 14);
			contentPanel.add(lblNewLabel_Sexo);
		}
		{
			JLabel lblNewLabel_Precio = new JLabel("Precio");
			lblNewLabel_Precio.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Precio.setForeground(new Color(255, 255, 153));
			lblNewLabel_Precio.setBounds(32, 206, 46, 14);
			contentPanel.add(lblNewLabel_Precio);
		}
		{
			lblMaterial = new JLabel("Material");
			lblMaterial.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblMaterial.setForeground(new Color(255, 255, 153));
			lblMaterial.setBounds(32, 270, 56, 14);
			contentPanel.add(lblMaterial);
		}
		{
			lblCaducidad = new JLabel("Caducidad");
			lblCaducidad.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCaducidad.setForeground(new Color(255, 255, 153));
			lblCaducidad.setBounds(32, 302, 103, 14);
			contentPanel.add(lblCaducidad);
		}
		{
			lblIngredientes = new JLabel("Ingredientes");
			lblIngredientes.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblIngredientes.setForeground(new Color(255, 255, 153));
			lblIngredientes.setBounds(32, 334, 103, 14);
			contentPanel.add(lblIngredientes);
		}
		{
			lblTalla = new JLabel("Talla");
			lblTalla.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblTalla.setForeground(new Color(255, 255, 153));
			lblTalla.setBounds(32, 366, 78, 14);
			contentPanel.add(lblTalla);
		}
		{
			JLabel lblNewLabel_Categoria = new JLabel("Categoria");
			lblNewLabel_Categoria.setBackground(Color.MAGENTA);
			lblNewLabel_Categoria.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Categoria.setForeground(new Color(255, 255, 153));
			lblNewLabel_Categoria.setBounds(32, 142, 78, 14);
			contentPanel.add(lblNewLabel_Categoria);
		}

		JSeparator separator = new JSeparator();
		separator.setBounds(32, 418, 894, 9);
		contentPanel.add(separator);
		{
			JButton cancelButton_Cerrar = new JButton("Cerrar");
			cancelButton_Cerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cerrar();
				}
			});
			cancelButton_Cerrar.setFont(new Font("Tahoma", Font.BOLD, 14));
			cancelButton_Cerrar.setForeground(Color.BLACK);
			cancelButton_Cerrar.setBounds(793, 438, 133, 23);
			contentPanel.add(cancelButton_Cerrar);
			cancelButton_Cerrar.setBackground(new Color(255, 255, 153));
			cancelButton_Cerrar.setActionCommand("Cancel");
		}
		{
			textID = new JTextField();
			textID.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					comprobarId(datos);
				}
			});
			textID.setColumns(10);
			textID.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textID.setBackground(new Color(255, 20, 147));
			textID.setBounds(226, 78, 111, 20);
			contentPanel.add(textID);
		}
		{
			textCaducidad = new JTextField();
			textCaducidad.setColumns(10);
			textCaducidad.setBorder(
					new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textCaducidad.setBackground(new Color(255, 20, 147));
			textCaducidad.setBounds(226, 302, 111, 20);
			contentPanel.add(textCaducidad);
		}
		{
			textMaterial = new JTextField();
			textMaterial.setColumns(10);
			textMaterial.setBorder(
					new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textMaterial.setBackground(new Color(255, 20, 147));
			textMaterial.setBounds(226, 270, 111, 20);
			contentPanel.add(textMaterial);
		}
		{
			textPrecio = new JTextField();
			textPrecio.setColumns(10);
			textPrecio.setBorder(
					new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textPrecio.setBackground(new Color(255, 20, 147));
			textPrecio.setBounds(226, 206, 111, 20);
			contentPanel.add(textPrecio);
		}
		{
			textIngredientes = new JTextField();
			textIngredientes.setColumns(10);
			textIngredientes.setBorder(
					new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textIngredientes.setBackground(new Color(255, 20, 147));
			textIngredientes.setBounds(226, 334, 111, 20);
			contentPanel.add(textIngredientes);
		}
		{
			textNombreProd = new JTextField();
			textNombreProd.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
				}
			});
			textNombreProd.setColumns(10);
			textNombreProd.setBorder(
					new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textNombreProd.setBackground(new Color(255, 20, 147));
			textNombreProd.setBounds(226, 110, 111, 20);
			contentPanel.add(textNombreProd);
		}

		JButton btnAgregar = new JButton("Modificar");
		btnAgregar.setBackground(new Color(255, 255, 153));
		btnAgregar.setForeground(Color.BLACK);
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modificar(datos);

			}
		});
		btnAgregar.setBounds(32, 438, 133, 23);
		contentPanel.add(btnAgregar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlDkShadow);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}

		textTipo = new JTextField();
		textTipo.setColumns(10);
		textTipo.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		textTipo.setBackground(new Color(255, 20, 147));
		textTipo.setBounds(226, 238, 111, 20);
		contentPanel.add(textTipo);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(new Color(255, 255, 153));
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipo.setBounds(32, 238, 78, 14);
		contentPanel.add(lblTipo);

		rdbtnLenceria = new JRadioButton("LENCERIA");
		rdbtnLenceria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				categoriaElegida();
			}
		});
		rdbtnLenceria.setForeground(new Color(255, 255, 255));
		rdbtnLenceria.setBackground(new Color(255, 20, 147));
		rdbtnLenceria.setBounds(141, 140, 86, 23);
		contentPanel.add(rdbtnLenceria);

		rdbtnJuguete = new JRadioButton("JUGUETE");
		rdbtnJuguete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				categoriaElegida();
			}
		});
		rdbtnJuguete.setForeground(new Color(255, 255, 255));
		rdbtnJuguete.setBackground(new Color(255, 20, 147));
		rdbtnJuguete.setBounds(251, 140, 86, 23);
		contentPanel.add(rdbtnJuguete);

		rdbtnCosmetico = new JRadioButton("COSMETICO");
		rdbtnCosmetico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				categoriaElegida();
			}
		});
		rdbtnCosmetico.setForeground(new Color(255, 255, 255));
		rdbtnCosmetico.setBackground(new Color(255, 20, 147));
		rdbtnCosmetico.setBounds(359, 140, 103, 23);
		contentPanel.add(rdbtnCosmetico);

		// GRUPO DE BOTONES DE CATEGORIA
		categoria = new ButtonGroup();
		categoria.add(rdbtnLenceria);
		categoria.add(rdbtnJuguete);
		categoria.add(rdbtnCosmetico);

		comboSexo = new JComboBox();
		comboSexo.setForeground(new Color(255, 255, 255));
		comboSexo.setBackground(new Color(255, 20, 147));
		comboSexo.setModel(new DefaultComboBoxModel(new String[] { "MUJER", "HOMBRE", "UNISEX" }));
		comboSexo.setBounds(226, 172, 111, 22);
		contentPanel.add(comboSexo);
		{
			comboTalla = new JComboBox();
			comboTalla.setModel(new DefaultComboBoxModel(new String[] { "XS", "S", "M", "L", "XL" }));
			comboTalla.setForeground(new Color(255, 255, 255));
			comboTalla.setBackground(new Color(255, 20, 147));
			comboTalla.setBounds(226, 364, 111, 22);
			contentPanel.add(comboTalla);
		}
	
		this.presentarTabla(producto, datos);
	}
	
	
	


	protected void comprobarId(ControladorDatos datos) {
		Producto prod=null;
		prod = datos.obtenerProducto(textID.getText());;
		
	}

	
		
	

	protected void categoriaElegida() {

		// SI ELIGES LA CATEGORIA LENCERIA
		if (rdbtnLenceria.isSelected()) {
			// JUGUETES
			textMaterial.setVisible(false);
			lblMaterial.setVisible(false);
			// COSMETICOS
			lblCaducidad.setVisible(false);
			lblIngredientes.setVisible(false);

			textIngredientes.setVisible(false);
			textCaducidad.setVisible(false);

			// LENCERIA
			lblTalla.setVisible(true);
			comboTalla.setVisible(true);

			// SI LA CATEGORIA ELEGIDA ES JUGUETE

		} else if (rdbtnJuguete.isSelected()) {

			// JUGUETES
			textMaterial.setVisible(true);
			lblMaterial.setVisible(true);

			// COSMETICOS
			lblCaducidad.setVisible(false);
			lblIngredientes.setVisible(false);

			textIngredientes.setVisible(false);
			textCaducidad.setVisible(false);

			// LENCERIA
			lblTalla.setVisible(false);
			comboTalla.setVisible(false);

			// SI LA CATEGORIA ELEGIDA ES
		} else if (rdbtnCosmetico.isSelected()) {

			// JUGUETES
			textMaterial.setVisible(false);
			lblMaterial.setVisible(false);

			// COSMETICOS
			lblCaducidad.setVisible(true);
			lblIngredientes.setVisible(true);
			textIngredientes.setVisible(true);
			textCaducidad.setVisible(true);

			// LENCERIA
			lblTalla.setVisible(false);
			comboTalla.setVisible(false);

		}
		
	}

	// Metodo para modificar los productos
	protected void modificar(ControladorDatos datos) {
		Producto prod = leerDatosPantalla(textID.getText());
		// el id del producto no cambia en la modificación
		datos.modificarProducto(prod);
		//
		JOptionPane.showMessageDialog(this, "EL PRODUCTO SE HA MODIFICADO CORRECTAMENTE");

	}

	public Producto leerDatosPantalla(String idProducto) {
		Producto prod = new Producto();

		ControladorBDImplementacion bd = new ControladorBDImplementacion();
		
		//CUANDO LA VALIDACION ES IGUAL A TRUE
		boolean v = bd.validarInteger(textPrecio.getText());

		if (textID.getText().equals("") || textPrecio.getText().equals("") || textNombreProd.getText().equals("")
				|| textTipo.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "FALTAN CAMPOS POR RELLENAR!");
		} else {
			//VALIDA QUE NO SE PUEDAN INTRODUCIR STRINGS
			if (v != false) {
				// SI LA CATEGORIA ELEGIDA ES LENCERIA
				if (rdbtnLenceria.isSelected()) {
					prod = new Lenceria();
					prod.setIdProducto(idProducto);
					prod.setNombreProd(textNombreProd.getText());
					prod.setCategoria("LENCERIA");
					prod.setSexo(comboSexo.getSelectedItem().toString());
					prod.setPrecio(Integer.parseInt(textPrecio.getText()));
					prod.setTipo(textTipo.getText());
					((Lenceria) prod).setTalla(comboTalla.getSelectedItem().toString());
					JOptionPane.showMessageDialog(this, "PRODUCTO MODIFICADO CORRECTAMENTE");

					// SI LA CATEGORIA ELEGIDA ES JUGUETE
				} else if (rdbtnJuguete.isSelected()) {
					if (textMaterial.getText().equals("")) {
						JOptionPane.showMessageDialog(this, "FALTA RELLENAR EL CAMPO MATERIAL");
					} else {
					prod = new Juguete();
					prod.setIdProducto(idProducto);
					prod.setNombreProd(textNombreProd.getText());
					prod.setCategoria("JUGUETE");
					prod.setSexo(comboSexo.getSelectedItem().toString());
					prod.setPrecio(Integer.parseInt(textPrecio.getText()));
					prod.setTipo(textTipo.getText());
					((Juguete) prod).setMaterial(textMaterial.getText());
					JOptionPane.showMessageDialog(this, "PRODUCTO MODIFICADO CORRECTAMENTE");
					}
					// SI LA CATEGORIA ELEGIDA ES COSMETICO
				} else if (rdbtnCosmetico.isSelected()) {
					if (textIngredientes.getText().equals("") || textCaducidad.getText().equals("")) {
						JOptionPane.showMessageDialog(this, "FALTAN CAMPOS POR RELLENAR!");
					} else {

						prod = new Cosmetico();
						prod.setIdProducto(idProducto);
						prod.setNombreProd(textNombreProd.getText());
						prod.setCategoria("COSMETICO");
						prod.setSexo(comboSexo.getSelectedItem().toString());
						prod.setPrecio(Integer.parseInt(textPrecio.getText()));
						prod.setTipo(textTipo.getText());
						((Cosmetico) prod).setCaducidad(textCaducidad.getText());
						((Cosmetico) prod).setIngrediente(textIngredientes.getText());
						JOptionPane.showMessageDialog(this, "PRODUCTO MODIFICADO CORRECTAMENTE");
					}
					
				} else {

					JOptionPane.showMessageDialog(this, "ERROR AL INSERTAR PRODUCTO");
				}

			} else {
				JOptionPane.showMessageDialog(this, "EL PRECIO DEBE SER UN NÚMERO");
			}

		}
		return prod;
	}
	// ESCONDER CAMPOS DE TEXTOS SEGUN CATEGORIA

	private void cerrar() {
		this.dispose();
	}
	
	
	
private void presentarTabla(Producto producto, ControladorDatos datos) {
		
		JScrollPane scroll = new JScrollPane();
		tablaProducto = this.cargarTabla(producto, datos);
		scroll.setViewportView(tablaProducto);
		

		
		
		contentPanel.add(scroll);
		scroll.setBounds(482,56,420,330);
	

	}
	
	private JTable cargarTabla(Producto producto, ControladorDatos datos) {
		
		String[] nombreColumnas = { "IDPRODUCTO", "NOMBRE_PROD", "CATEGORI", "SEXO", "PRECIO", "TIPO" };
		String[] registros = new String[6];
		

		DefaultTableModel modelo = new DefaultTableModel(null, nombreColumnas);
		modelo.setRowCount(0);
		
		productos= datos.listarProducto();
		
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
