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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertarProducto extends JDialog {
	
	/**
	 * Launch the application.
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {
			ModificarProducto dialog = new ModificarProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public InsertarProducto() {
		
	}
*/	
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
			lblNewLabel_Sexo.setBounds(32, 142, 103, 14);
			contentPanel.add(lblNewLabel_Sexo);
		}
		{
			JLabel lblNewLabel_Precio = new JLabel("Precio");
			lblNewLabel_Precio.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Precio.setForeground(new Color(255, 255, 153));
			lblNewLabel_Precio.setBounds(32, 174, 46, 14);
			contentPanel.add(lblNewLabel_Precio);
		}
		{
			JLabel lblNewLabel_Material = new JLabel("Material");
			lblNewLabel_Material.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Material.setForeground(new Color(255, 255, 153));
			lblNewLabel_Material.setBounds(32, 206, 56, 14);
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
			JLabel lblNewLabel_Categoria = new JLabel("Categoria");
			lblNewLabel_Categoria.setBackground(Color.MAGENTA);
			lblNewLabel_Categoria.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_Categoria.setForeground(new Color(255, 255, 153));
			lblNewLabel_Categoria.setBounds(32, 334, 78, 14);
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
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textField_5.setBackground(new Color(255, 20, 147));
			textField_5.setBounds(226, 78, 111, 20);
			contentPanel.add(textField_5);
		}
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textField.setBackground(new Color(255, 20, 147));
			textField.setBounds(226, 269, 111, 20);
			contentPanel.add(textField);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textField_1.setBackground(new Color(255, 20, 147));
			textField_1.setBounds(226, 237, 111, 20);
			contentPanel.add(textField_1);
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textField_2.setBackground(new Color(255, 20, 147));
			textField_2.setBounds(226, 205, 111, 20);
			contentPanel.add(textField_2);
		}
		{
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textField_3.setBackground(new Color(255, 20, 147));
			textField_3.setBounds(226, 173, 111, 20);
			contentPanel.add(textField_3);
		}
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			textField_4.setBackground(new Color(255, 20, 147));
			textField_4.setBounds(226, 109, 111, 20);
			contentPanel.add(textField_4);
		}
		{
			JComboBox comboBox_Sexo = new JComboBox();
			comboBox_Sexo.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			comboBox_Sexo.setBackground(new Color(255, 20, 147));
			comboBox_Sexo.setBounds(226, 140, 111, 20);
			contentPanel.add(comboBox_Sexo);
		}
		{
			JComboBox comboBox_Sexo = new JComboBox();
			comboBox_Sexo.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			comboBox_Sexo.setBackground(new Color(255, 20, 147));
			comboBox_Sexo.setBounds(226, 300, 111, 20);
			contentPanel.add(comboBox_Sexo);
		}
		{
			JComboBox comboBox_Sexo = new JComboBox();
			comboBox_Sexo.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
			comboBox_Sexo.setBackground(new Color(255, 20, 147));
			comboBox_Sexo.setBounds(226, 332, 111, 20);
			contentPanel.add(comboBox_Sexo);
		}
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInsertar.setForeground(new Color(0, 0, 0));
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

	//Utilizamos este metodo para cerrar la pagina y volver a la de configuración
	private void cerrar() {
		this.dispose();	
	}
}
