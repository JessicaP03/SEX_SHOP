package vista;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import clases.Lenceria;
import clases.Cosmetico;
import clases.Juguete;
import clases.Producto;
import modelo.ControladorBDImplementacion;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class InsertarProducto extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField textID, textCaducidad, textMaterial, textPrecio, textInredientes, textNombreProd;
	private JRadioButton rdbtnLenceria, rdbtnJuguete, rdbtnCosmetico, rdbtnHombre, rdbtnMujer, rdbtnUnisex, rdbtnXs,
			rdbtnS, rdbtnM, rdbtnXL, rdbtnL;
	private ButtonGroup categoria, sexo, talla;
	private JLabel lblIngredientes, lblTalla, lblCaducidad, lblMaterial;

	private ArrayList<Producto> productos;
	private JTextField textTipo;

	/**
	 * Launch the application.
	 */
	
	public InsertarProducto(Configuracion configuracion, boolean modal) {
		setForeground(new Color(0, 0, 0));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBackground(new Color(0, 0, 0));
		setBounds(100, 100, 493, 520);
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
			JLabel lblMaterial = new JLabel("Material");
			lblMaterial.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblMaterial.setForeground(new Color(255, 255, 153));
			lblMaterial.setBounds(32, 270, 56, 14);
			contentPanel.add(lblMaterial);
		}
		{
			JLabel lblCaducidad = new JLabel("Caducidad");
			lblCaducidad.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCaducidad.setForeground(new Color(255, 255, 153));
			lblCaducidad.setBounds(32, 302, 103, 14);
			contentPanel.add(lblCaducidad);
		}
		{
			JLabel lblIngredientes = new JLabel("Ingredientes");
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
			cancelButton_Cerrar.setBounds(326, 441, 119, 20);
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
			textInredientes = new JTextField();
			textInredientes.setColumns(10);
			textInredientes.setBorder(
					new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textInredientes.setBackground(new Color(255, 20, 147));
			textInredientes.setBounds(226, 334, 111, 20);
			contentPanel.add(textInredientes);
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
		rdbtnCosmetico.setBounds(359, 140, 86, 23);
		contentPanel.add(rdbtnCosmetico);
		{
			rdbtnHombre = new JRadioButton("HOMBRE");
			rdbtnHombre.setBackground(new Color(255, 20, 147));
			rdbtnHombre.setForeground(new Color(255, 255, 255));
			rdbtnHombre.setBounds(141, 172, 86, 23);
			contentPanel.add(rdbtnHombre);
		}
		{
			rdbtnMujer = new JRadioButton("MUJER");
			rdbtnMujer.setForeground(new Color(255, 255, 255));
			rdbtnMujer.setBackground(new Color(255, 20, 147));
			rdbtnMujer.setBounds(251, 172, 86, 23);
			contentPanel.add(rdbtnMujer);
		}
		{
			rdbtnUnisex = new JRadioButton("UNISEX");
			rdbtnUnisex.setBackground(new Color(255, 20, 147));
			rdbtnUnisex.setForeground(new Color(255, 255, 255));
			rdbtnUnisex.setBounds(359, 172, 86, 23);
			contentPanel.add(rdbtnUnisex);
		}
		{
			rdbtnXs = new JRadioButton("XS");
			rdbtnXs.setForeground(Color.WHITE);
			rdbtnXs.setBackground(new Color(255, 20, 147));
			rdbtnXs.setBounds(127, 364, 46, 23);
			contentPanel.add(rdbtnXs);
		}
		{
			rdbtnS = new JRadioButton("S");
			rdbtnS.setForeground(Color.WHITE);
			rdbtnS.setBackground(new Color(255, 20, 147));
			rdbtnS.setBounds(198, 364, 46, 23);
			contentPanel.add(rdbtnS);
		}
		{
			rdbtnM = new JRadioButton("M");
			rdbtnM.setForeground(Color.WHITE);
			rdbtnM.setBackground(new Color(255, 20, 147));
			rdbtnM.setBounds(269, 364, 46, 23);
			contentPanel.add(rdbtnM);
		}
		{
			rdbtnL = new JRadioButton("L");
			rdbtnL.setForeground(Color.WHITE);
			rdbtnL.setBackground(new Color(255, 20, 147));
			rdbtnL.setBounds(340, 364, 46, 23);
			contentPanel.add(rdbtnL);
		}
		{
			rdbtnXL = new JRadioButton("XL");
			rdbtnXL.setForeground(Color.WHITE);
			rdbtnXL.setBackground(new Color(255, 20, 147));
			rdbtnXL.setBounds(411, 364, 46, 23);
			contentPanel.add(rdbtnXL);
		}

		// GRUPO DE BOTONES DE CATEGORIA
		categoria = new ButtonGroup();
		categoria.add(rdbtnLenceria);
		categoria.add(rdbtnJuguete);
		categoria.add(rdbtnCosmetico);

		// GRUPO DE BOTONES DE SEXO
		sexo = new ButtonGroup();
		sexo.add(rdbtnHombre);
		sexo.add(rdbtnMujer);
		sexo.add(rdbtnUnisex);

		// GRUPO DE BOTONES DE TALLA
		talla = new ButtonGroup();
		talla.add(rdbtnXs);
		talla.add(rdbtnS);
		talla.add(rdbtnM);
		talla.add(rdbtnL);
		talla.add(rdbtnXL);
	}

	protected void cerrarVentana() {
		this.dispose();
		
	}

	protected void categoriaElegida() {

		// SI ELIGES LA CATEGORIA LENCERIA
		if (rdbtnLenceria.isSelected()) {

			// JUGUETES
			textMaterial.setVisible(false);

			// COSMETICOS

			textInredientes.setVisible(false);
			textCaducidad.setVisible(false);

			// LENCERIA

			rdbtnXs.setVisible(true);
			rdbtnS.setVisible(true);
			rdbtnM.setVisible(true);
			rdbtnL.setVisible(true);
			rdbtnXL.setVisible(true);
		
			//SI LA CATEGORIA ELEGIDA ES JUGUETE
		} else if (rdbtnJuguete.isSelected()) {

			// JUGUETES
			textMaterial.setVisible(true);

			// COSMETICOS

			textInredientes.setVisible(false);
			textCaducidad.setVisible(false);

			// LENCERIA

			rdbtnXs.setVisible(false);
			rdbtnS.setVisible(false);
			rdbtnM.setVisible(false);
			rdbtnL.setVisible(false);
			rdbtnXL.setVisible(false);
			
			//SI LA CATEGORIA ELEGIDA ES
		} else if (rdbtnCosmetico.isSelected()) {

			// JUGUETES
			textMaterial.setVisible(false);

			// COSMETICOS

			textInredientes.setVisible(true);
			textCaducidad.setVisible(true);

			// LENCERIA

			rdbtnXs.setVisible(false);
			rdbtnS.setVisible(false);
			rdbtnM.setVisible(false);
			rdbtnL.setVisible(false);
			rdbtnXL.setVisible(false);
		} else {

		}
	}

	protected void agregarProducto() {
		Producto prod;

		// SI FALTA ALGUN CAMPO POR RELLENAR
		if ((rdbtnHombre.isSelected() || rdbtnMujer.isSelected() || rdbtnUnisex.isSelected())
				|| (rdbtnLenceria.isSelected() || rdbtnCosmetico.isSelected() || rdbtnJuguete.isSelected())
				|| (rdbtnXs.isSelected()) || rdbtnS.isSelected() || rdbtnM.isSelected() || rdbtnL.isSelected()
				|| rdbtnXL.isSelected()) {

			
			//SI LA CATEGORIA ELEGIDA ES LENCERIA
			if (categoria.equals("LENCERIA")) {

				textMaterial.setVisible(false);
				textCaducidad.setEnabled(false);
				prod = new Lenceria();
				prod.setIdProducto(textID.getText());
				prod.setNombreProd(textNombreProd.getText());
				prod.setCategoria(categoria.getSelection().toString());
				prod.setSexo(sexo.getSelection().toString());
				prod.setTipo(textTipo.getText());
				((Lenceria) prod).setTalla(talla.getSelection().toString());
				
			//SI LA CATEGORIA ELEGIDA ES JUGUETE
			} else if (categoria.equals("JUGUETES")) {
				prod = new Juguete();
				prod.setIdProducto(textID.getText());
				prod.setNombreProd(textNombreProd.getText());
				prod.setCategoria(categoria.getSelection().toString());
				prod.setSexo(sexo.getSelection().toString());
				prod.setTipo(textTipo.getText());
				((Juguete) prod).setMaterial(textMaterial.getText());

				//SI LA CATEGORIA ELEGIDA ES COSMETICO
			} else if (categoria.equals("COSMETICOS")) {
				prod = new Cosmetico();
				prod.setIdProducto(textID.getText());
				prod.setNombreProd(textNombreProd.getText());
				prod.setCategoria(categoria.getSelection().toString());
				prod.setSexo(sexo.getSelection().toString());
				prod.setTipo(textTipo.getText());
				((Cosmetico) prod).setCaducidad(textCaducidad.getText());
				((Cosmetico) prod).setIngrediente(textInredientes.getText());
			}
			
			JOptionPane.showMessageDialog(this, "PRODUCTO AÑADIDO CORRECTAMEMTE");
		} else {

			JOptionPane.showMessageDialog(this, "FALTAN CAMPOS POR RELLENAR");		
		}
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

//	protected void consultarSexo() {
//		if (comboBox_Sexo.getSelectedIndex() == -1) {
//			JOptionPane.showMessageDialog(this, "Selecciona el sexo");
//		} else {
//			String cadena = (String) comboBox_Sexo.getSelectedItem();
//			int pos = cadena.indexOf(" ");
//
//		}
//	}

//	private void cargarProductos(ControladorBDImplementacion datos) {
//
//		ArrayList<Producto> listaProductos = datos.listarProducto();
//		comboBox_Sexo.removeAllItems();
//
//		for (int i = 0; i < listaProductos.size(); i++) {
//			comboBox_Sexo.addItem(listaProductos.get(i).getSexo().toString());
//		}
//
//	}

}
