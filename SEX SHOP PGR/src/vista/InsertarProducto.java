package vista;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import clases.Cosmetico;
import clases.Juguete;
import clases.Lenceria;
import clases.Producto;
import modelo.ControladorBDImplementacion;
import modelo.ControladorDatos;

import java.awt.event.ActionListener;
import java.io.ObjectInputFilter.Config;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.Cursor;
import java.awt.Dialog.ModalityType;

public class InsertarProducto extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField textID, textCaducidad, textMaterial, textPrecio, textIngredientes, textNombreProd;
	private JRadioButton rdbtnLenceria, rdbtnJuguete, rdbtnCosmetico;
	private ButtonGroup categoria, sexo, talla;
	private JLabel lblIngredientes, lblTalla, lblCaducidad, lblMaterial;
	private JComboBox comboSexo;
	private ArrayList<Producto> productos;
	private JTextField textTipo;
	private ControladorBDImplementacion datos;
	private JComboBox comboTalla;
	private int anio;
	private int dia;
	private int mes;

	public InsertarProducto(Configuracion padre, boolean modal, ControladorDatos datos) {
		super(padre);
		this.setModal(modal);
		setForeground(new Color(0, 0, 0));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBackground(new Color(0, 0, 0));
		setBounds(100, 100, 512, 520);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlDkShadow);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Insertar producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(32, 11, 133, 17);
		contentPanel.add(lblNewLabel);
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(32, 36, 378, 9);
			contentPanel.add(separator);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Insertar los datos del producto que desea introducir");
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
		separator.setBounds(32, 418, 378, 9);
		contentPanel.add(separator);
		{
			JButton cancelButton_Cerrar = new JButton("Cerrar");
			cancelButton_Cerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cerrarVentana();
				}
			});
			cancelButton_Cerrar.setFont(new Font("Tahoma", Font.BOLD, 14));
			cancelButton_Cerrar.setForeground(Color.BLACK);
			cancelButton_Cerrar.setBounds(312, 438, 133, 23);
			contentPanel.add(cancelButton_Cerrar);
			cancelButton_Cerrar.setBackground(new Color(255, 255, 153));
			cancelButton_Cerrar.setActionCommand("Cancel");
		}
		{
			textID = new JTextField();
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

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBackground(new Color(255, 255, 153));
		btnAgregar.setForeground(Color.BLACK);
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				agregarProducto();

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
	}

	protected void cerrarVentana() {
		this.dispose();

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

	protected void agregarProducto() {
		Producto prod;
		ControladorBDImplementacion bd = new ControladorBDImplementacion();
		boolean v = bd.validarInteger(textPrecio.getText());

		// SI FALTA ALGUN CAMPO POR RELLENAR
		if (textID.getText().equals("") || textPrecio.getText().equals("") || textNombreProd.getText().equals("")
				|| textTipo.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "FALTAN CAMPOS POR RELLENAR!");
		} else {

			if (v != false) {
				if (bd.existeProducto(textID.getText()) == 0) {
					// SI LA CATEGORIA ELEGIDA ES LENCERIA
					if (rdbtnLenceria.isSelected()) {

						prod = new Lenceria();
						prod.setIdProducto(textID.getText());
						prod.setNombreProd(textNombreProd.getText());
						prod.setCategoria("LENCERIA");
						prod.setSexo(comboSexo.getSelectedItem().toString());
						prod.setPrecio(Integer.parseInt(textPrecio.getText()));
						prod.setTipo(textTipo.getText());
						((Lenceria) prod).setTalla(comboTalla.getSelectedItem().toString());

						datos = new ControladorBDImplementacion();
						datos.insertarProducto(prod);

						JOptionPane.showMessageDialog(this, "PRODUCTO AÑADIDO CORRECTAMENTE");

						// SI LA CATEGORIA ELEGIDA ES JUGUETE
					} else if (rdbtnJuguete.isSelected()) {
						if (textMaterial.getText().equals("")) {
							JOptionPane.showMessageDialog(this, "FALTA RELLENAR EL CAMPO MATERIAL");
						} else {
							prod = new Juguete();
							prod.setIdProducto(textID.getText());
							prod.setNombreProd(textNombreProd.getText());
							prod.setCategoria("JUGUETE");
							prod.setSexo(comboSexo.getSelectedItem().toString());
							prod.setPrecio(Integer.parseInt(textPrecio.getText()));
							prod.setTipo(textTipo.getText());
							((Juguete) prod).setMaterial(textMaterial.getText());

							datos = new ControladorBDImplementacion();
							datos.insertarProducto(prod);
							JOptionPane.showMessageDialog(this, "PRODUCTO AÑADIDO CORRECTAMENTE");
						}

						// SI LA CATEGORIA ELEGIDA ES COSMETICO
					} else if (rdbtnCosmetico.isSelected()) {
						if (textIngredientes.getText().equals("") || textCaducidad.getText().equals("")) {
							JOptionPane.showMessageDialog(this, "FALTAN CAMPOS POR RELLENAR");
						} else {
							prod = new Cosmetico();
							prod.setIdProducto(textID.getText());
							prod.setNombreProd(textNombreProd.getText());
							prod.setCategoria("COSMETICO");
							prod.setSexo(comboSexo.getSelectedItem().toString());
							prod.setPrecio(Integer.parseInt(textPrecio.getText()));
							prod.setTipo(textTipo.getText());

							DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
							LocalDate fecha = LocalDate.parse(textCaducidad.getText(), formateador);
							
							
							((Cosmetico) prod).setCaducidad(fecha.toString());
							((Cosmetico) prod).setIngrediente(textIngredientes.getText());

							JOptionPane.showMessageDialog(this, "PRODUCTO AÑADIDO CORRECTAMENTE");
							datos = new ControladorBDImplementacion();
							datos.insertarProducto(prod);
						}
					}
				} else {
					JOptionPane.showMessageDialog(this, "EL CODIGO ESTA REPETIDO");
				}
			}else {
				JOptionPane.showMessageDialog(this, "EL PRECIO DEBE SER UN NÚMERO");
			}
		}

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
