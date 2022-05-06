package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Producto;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarProducto extends JDialog {
	
	/**
	 * Launch the application.
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_IDProducto;
	private JTextField textField_NombreProd;
	private JTextField textField_Precio;
	private JTextField textField_Material;
	private JTextField textField_Caducidad;
	private JTextField textField_Ingredientes;

	

	//Creamos este segundo constructor para saber cual es la ventana padre
	public ModificarProducto(Configuracion padre, boolean modal) {
		super(padre);
		this.setModal(modal);
		setBackground(SystemColor.windowBorder);
		setBounds(100, 100, 436, 506);
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
			lblNewLabel_Sexo.setBounds(32, 142, 103, 14);
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
			JLabel lblNewLabel_Material = new JLabel("Material");
			lblNewLabel_Material.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Material.setForeground(new Color(255, 255, 153));
			lblNewLabel_Material.setBounds(32, 334, 56, 14);
			contentPanel.add(lblNewLabel_Material);
		}
		{
			JLabel lblNewLabel_Caducidad = new JLabel("Caducidad");
			lblNewLabel_Caducidad.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Caducidad.setForeground(new Color(255, 255, 153));
			lblNewLabel_Caducidad.setBounds(32, 238, 103, 14);
			contentPanel.add(lblNewLabel_Caducidad);
		}
		{
			JLabel lblNewLabel_Ingredientes = new JLabel("Ingredientes");
			lblNewLabel_Ingredientes.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Ingredientes.setForeground(new Color(255, 255, 153));
			lblNewLabel_Ingredientes.setBounds(32, 270, 103, 14);
			contentPanel.add(lblNewLabel_Ingredientes);
		}
		{
			JLabel lblNewLabel_Talla = new JLabel("Talla");
			lblNewLabel_Talla.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Talla.setForeground(new Color(255, 255, 153));
			lblNewLabel_Talla.setBounds(32, 302, 78, 14);
			contentPanel.add(lblNewLabel_Talla);
		}
		{
			textField_IDProducto = new JTextField();
			textField_IDProducto.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textField_IDProducto.setBackground(new Color(255, 20, 147));
			textField_IDProducto.setColumns(10);
			textField_IDProducto.setBounds(226, 75, 111, 20);
			contentPanel.add(textField_IDProducto);
		}
		{
			JComboBox comboBox_Talla = new JComboBox();
			comboBox_Talla.setBackground(new Color(255, 20, 147));
			comboBox_Talla.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			comboBox_Talla.setBounds(226, 298, 111, 20);
			contentPanel.add(comboBox_Talla);
		}
		{
			JLabel lblNewLabel_Categoria = new JLabel("Categoria");
			lblNewLabel_Categoria.setBackground(Color.MAGENTA);
			lblNewLabel_Categoria.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Categoria.setForeground(new Color(255, 255, 153));
			lblNewLabel_Categoria.setBounds(32, 174, 78, 14);
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
			textField_NombreProd = new JTextField();
			textField_NombreProd.setColumns(10);
			textField_NombreProd.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textField_NombreProd.setBackground(new Color(255, 20, 147));
			textField_NombreProd.setBounds(226, 109, 111, 20);
			contentPanel.add(textField_NombreProd);
		}
		{
			textField_Precio = new JTextField();
			textField_Precio.setColumns(10);
			textField_Precio.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textField_Precio.setBackground(new Color(255, 20, 147));
			textField_Precio.setBounds(226, 333, 111, 20);
			contentPanel.add(textField_Precio);
		}
		{
			textField_Material = new JTextField();
			textField_Material.setColumns(10);
			textField_Material.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textField_Material.setBackground(new Color(255, 20, 147));
			textField_Material.setBounds(226, 205, 111, 20);
			contentPanel.add(textField_Material);
		}
		{
			textField_Caducidad = new JTextField();
			textField_Caducidad.setColumns(10);
			textField_Caducidad.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textField_Caducidad.setBackground(new Color(255, 20, 147));
			textField_Caducidad.setBounds(226, 237, 111, 20);
			contentPanel.add(textField_Caducidad);
		}
		{
			textField_Ingredientes = new JTextField();
			textField_Ingredientes.setColumns(10);
			textField_Ingredientes.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textField_Ingredientes.setBackground(new Color(255, 20, 147));
			textField_Ingredientes.setBounds(226, 269, 111, 20);
			contentPanel.add(textField_Ingredientes);
		}
		{
			JComboBox comboBox_Sexo = new JComboBox();
			comboBox_Sexo.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			comboBox_Sexo.setBackground(new Color(255, 20, 147));
			comboBox_Sexo.setBounds(226, 140, 111, 20);
			contentPanel.add(comboBox_Sexo);
		}
		{
			JComboBox comboBox_Categoria = new JComboBox();
			comboBox_Categoria.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			comboBox_Categoria.setBackground(new Color(255, 20, 147));
			comboBox_Categoria.setBounds(226, 173, 111, 20);
			contentPanel.add(comboBox_Categoria);
		}
		{
			JButton btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modificar();
				}
			});
			btnModificar.setBackground(new Color(255, 255, 102));
			btnModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnModificar.setForeground(new Color(0, 0, 0));
			btnModificar.setBounds(21, 425, 133, 23);
			contentPanel.add(btnModificar);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.controlDkShadow);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	
	//Metodo para modificar los productos
	protected void modificar() {
		Producto prod = leerDatosPantalla(textField_IDProducto.getText());
		
		//el id del producto no cambia en la modificación
		//datos.modificarProducto(prod);

		//
		JOptionPane.showMessageDialog(this, "El Producto ha sido modificado con exito");
		
	}



	private Producto leerDatosPantalla(String text) {
		return null;
				
	}
	
	
	
	private void cerrar() {
		this.dispose();
	}
	
	
}
