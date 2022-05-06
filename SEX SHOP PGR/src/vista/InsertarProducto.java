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
import javax.swing.JPanel;
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
import java.awt.event.ActionEvent;

public class InsertarProducto extends JDialog {
	
	/**
	 * Launch the application.
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField textID;
	private JTextField textIngredientes;
	private JTextField textCaducidad;
	private JTextField textMaterial;
	private JTextField textPrecio;
	private JTextField textNombre;

	
	//Este constructor es para que me diga cual es la ventana padre
	public InsertarProducto(Configuracion padre, boolean modal) {
		super(padre);
		this.setModal(modal);
		setBackground(SystemColor.windowBorder);
		setBounds(100, 100, 436, 506);
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
			lblNewLabel_Sexo.setBounds(32, 178, 103, 14);
			contentPanel.add(lblNewLabel_Sexo);
		}
		{
			JLabel lblNewLabel_Precio = new JLabel("Precio");
			lblNewLabel_Precio.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Precio.setForeground(new Color(255, 255, 153));
			lblNewLabel_Precio.setBounds(32, 216, 46, 14);
			contentPanel.add(lblNewLabel_Precio);
		}
		{
			JLabel lblNewLabel_Material = new JLabel("Material");
			lblNewLabel_Material.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Material.setForeground(new Color(255, 255, 153));
			lblNewLabel_Material.setBounds(32, 248, 56, 14);
			contentPanel.add(lblNewLabel_Material);
		}
		{
			JLabel lblNewLabel_Caducidad = new JLabel("Caducidad");
			lblNewLabel_Caducidad.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Caducidad.setForeground(new Color(255, 255, 153));
			lblNewLabel_Caducidad.setBounds(32, 273, 103, 25);
			contentPanel.add(lblNewLabel_Caducidad);
		}
		{
			JLabel lblNewLabel_Ingredientes = new JLabel("Ingredientes");
			lblNewLabel_Ingredientes.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Ingredientes.setForeground(new Color(255, 255, 153));
			lblNewLabel_Ingredientes.setBounds(32, 309, 103, 14);
			contentPanel.add(lblNewLabel_Ingredientes);
		}
		{
			JLabel lblNewLabel_Talla = new JLabel("Talla");
			lblNewLabel_Talla.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Talla.setForeground(new Color(255, 255, 153));
			lblNewLabel_Talla.setBounds(32, 346, 78, 14);
			contentPanel.add(lblNewLabel_Talla);
		}
		{
			JLabel lblNewLabel_Categoria = new JLabel("Categoria");
			lblNewLabel_Categoria.setBackground(Color.MAGENTA);
			lblNewLabel_Categoria.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Categoria.setForeground(new Color(255, 255, 153));
			lblNewLabel_Categoria.setBounds(32, 141, 78, 14);
			contentPanel.add(lblNewLabel_Categoria);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(32, 388, 378, 9);
		contentPanel.add(separator);
		{
			JButton cancelButton_Cerrar = new JButton("Cerrar");
			cancelButton_Cerrar.addActionListener(new ActionListener() {
				//LLamamos al metodo cerrar
				public void actionPerformed(ActionEvent e) {
					cerrar();
				}

				
			});
			cancelButton_Cerrar.setFont(new Font("Tahoma", Font.BOLD, 14));
			cancelButton_Cerrar.setForeground(Color.BLACK);
			cancelButton_Cerrar.setBounds(298, 423, 86, 23);
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
			textIngredientes = new JTextField();
			textIngredientes.setColumns(10);
			textIngredientes.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textIngredientes.setBackground(new Color(255, 20, 147));
			textIngredientes.setBounds(226, 308, 111, 20);
			contentPanel.add(textIngredientes);
		}
		{
			textCaducidad = new JTextField();
			textCaducidad.setColumns(10);
			textCaducidad.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textCaducidad.setBackground(new Color(255, 20, 147));
			textCaducidad.setBounds(226, 277, 111, 20);
			contentPanel.add(textCaducidad);
		}
		{
			textMaterial = new JTextField();
			textMaterial.setColumns(10);
			textMaterial.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textMaterial.setBackground(new Color(255, 20, 147));
			textMaterial.setBounds(226, 247, 111, 20);
			contentPanel.add(textMaterial);
		}
		{
			textPrecio = new JTextField();
			textPrecio.setColumns(10);
			textPrecio.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textPrecio.setBackground(new Color(255, 20, 147));
			textPrecio.setBounds(226, 215, 111, 20);
			contentPanel.add(textPrecio);
		}
		{
			textNombre = new JTextField();
			textNombre.setColumns(10);
			textNombre.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textNombre.setBackground(new Color(255, 20, 147));
			textNombre.setBounds(226, 109, 111, 20);
			contentPanel.add(textNombre);
		}
		{
			JComboBox comboBox_Sexo = new JComboBox();
			comboBox_Sexo.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			comboBox_Sexo.setBackground(new Color(255, 20, 147));
			comboBox_Sexo.setBounds(226, 177, 111, 20);
			contentPanel.add(comboBox_Sexo);
		}
		{
			JComboBox comboBox_Talla = new JComboBox();
			comboBox_Talla.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			comboBox_Talla.setBackground(new Color(255, 20, 147));
			comboBox_Talla.setBounds(226, 345, 111, 20);
			contentPanel.add(comboBox_Talla);
		}
		{
			JComboBox comboBox_Categoria = new JComboBox();
			comboBox_Categoria.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			comboBox_Categoria.setBackground(new Color(255, 20, 147));
			comboBox_Categoria.setBounds(226, 140, 111, 20);
			contentPanel.add(comboBox_Categoria);
		}
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInsertar.setForeground(new Color(0, 0, 0));
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarProducto();
			}
		});
		btnInsertar.setBackground(new Color(255, 255, 102));
		btnInsertar.setBounds(32, 423, 103, 23);
		contentPanel.add(btnInsertar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlDkShadow);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

	protected void insertarProducto() {
		
		
		ControladorBDImplementacion datos = new ControladorBDImplementacion();
		Producto prod;
		Lenceria lenc;
		Juguete jug;
		Cosmetico cos;
		
		jug= new Juguete();
		prod= new Producto();
		cos = new Cosmetico();
		lenc= new Lenceria();
		
		prod.setIdProducto(textID.getText());
		prod.setNombreProd(textNombre.getText());
		
		prod.setPrecio(1);
		jug.setMaterial(textMaterial.getText());
		cos.setCaducidad(textCaducidad.getText());
		lenc.setTalla("hoal");
		prod.getCategoria();
		
		
	}

	//Utilizamos este metodo para cerrar la pagina y volver a la de configuración
	private void cerrar() {
		this.dispose();	
	}
	
	//Metodo para insertar productos en la base de datos
	
	private void cargarPropietarios(ControladorBDImplementacion datos) {
		//
		
		productos = datos.cargarCategorias();
		
		if(!propietarios.isEmpty()) {
			for (Propietario pro : propietarios.values()) {
				cbLista.addItem(pro.getId() +" "+ pro.getNombre());
			}
		}
		cbLista.setSelectedIndex(-1);
		
	}
	
	
}
