package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Cliente;
import clases.Empleado;
import clases.Persona;
import clases.Producto;
import modelo.ControladorBDImplementacion;
import modelo.ControladorDatos;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Empleado;
import clases.Persona;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * @author 1dam
 *
 */
public class GestionarUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textEmail;
	private ButtonGroup jefe, admin;
	private JTextField textID;
	private ControladorDatos datos;
	private JTable tablaEmpleado;
	private Map<String, Empleado> empleados;
	private Map<Integer, Persona> personas;

	/**
	 * @param padre
	 * @param modal
	 * @param datos
	 * @param persona
	 */
	public GestionarUsuarios(Configuracion padre, boolean modal, ControladorDatos datos, Persona persona) {
		super(padre);
		this.setModal(modal);
		setBounds(100, 100, 730, 353);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(128, 128, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		textNombre = new JTextField();
		textNombre.setBackground(new Color(255, 51, 153));
		textNombre.setBounds(139, 130, 86, 20);
		textNombre.setColumns(10);
		contentPanel.add(textNombre);

		textEmail = new JTextField();
		textEmail.setBackground(new Color(255, 51, 153));
		textEmail.setBounds(139, 177, 86, 20);
		textEmail.setColumns(10);
		contentPanel.add(textEmail);

		JLabel lblPuesto = new JLabel("Nombre ");
		lblPuesto.setForeground(new Color(255, 250, 250));
		lblPuesto.setBounds(26, 131, 145, 14);
		lblPuesto.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPanel.add(lblPuesto);

		JLabel lblCodigo_2 = new JLabel("Email");
		lblCodigo_2.setForeground(new Color(255, 250, 250));
		lblCodigo_2.setBounds(26, 183, 145, 14);
		lblCodigo_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPanel.add(lblCodigo_2);

		JLabel lblNewLabel = new JLabel("INTRODUCIR DATOS DE USUARIO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(26, 23, 284, 23);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modificar(datos);
			}
		});
		btnModificar.setBackground(new Color(255, 255, 153));
		btnModificar.setBounds(27, 272, 89, 23);
		contentPanel.add(btnModificar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}

		ButtonGroup jefe = new ButtonGroup();

		ButtonGroup admin = new ButtonGroup();

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 153));
		separator.setBounds(21, 247, 676, 2);
		contentPanel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(255, 255, 153));
		separator_1.setBounds(21, 57, 665, 2);
		contentPanel.add(separator_1);

		textID = new JTextField();
		textID.setColumns(10);
		textID.setBackground(new Color(204, 255, 255));
		textID.setBounds(179, 70, 98, 20);
		contentPanel.add(textID);

		JLabel lblNewLabel_2 = new JLabel("COD_USUARIO:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 153));
		lblNewLabel_2.setBounds(31, 71, 138, 14);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Necesario en caso de modificar");
		lblNewLabel_3.setForeground(new Color(255, 255, 153));
		lblNewLabel_3.setBounds(26, 75, 188, 54);
		contentPanel.add(lblNewLabel_3);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBackground(new Color(255, 255, 153));
		btnLimpiar.setBounds(155, 272, 89, 23);
		contentPanel.add(btnLimpiar);
	
	this.presentarTabla(persona, datos);
		
	
	}

	protected void limpiar() {
		Empleado emp;
		emp = new Empleado();

		emp.setPuesto("");
		emp.setHorario("");
		emp.setAdministrador("");

	}

	protected void modificar(ControladorDatos datos) {

		Persona pers = datos.leerDatosEmpleado(textID.getText());

		datos.modificarUsuario(pers);
		JOptionPane.showMessageDialog(this, "EL USUARIO SE HA MODIFICADO CORRECTAMENTE");

	}

	// INSERTAR EMPLEADO NUEVO
	public Empleado leerDatosUsuario(String codusuario, ControladorDatos datos) {
		Persona pers;
		pers = new Cliente();

		if (textNombre.equals("") || textEmail.equals("")) {
			pers.setNombre(textNombre.getText());
			pers.setEmail(textEmail.getText());

			datos.modificarUsuario(pers);
		}
		return (Empleado) pers;
	}

	private void presentarTabla(Persona persona, ControladorDatos datos) {

		JScrollPane scroll = new JScrollPane();
		scroll.setForeground(new Color(255, 153, 204));
		tablaEmpleado = this.cargarTabla(datos);
		scroll.setViewportView(tablaEmpleado);

		contentPanel.add(scroll);
		scroll.setBounds(301, 70, 384, 154);

	}

	private JTable cargarTabla( ControladorDatos datos) {

		String[] nombreColumnas = { "COD_USUARIO", "NOMRBE", "EMAIL" };
		String[] registros = new String[3];

		DefaultTableModel modelo = new DefaultTableModel(null, nombreColumnas);
		modelo.setRowCount(0);

		personas = datos.listarUsuario();

		for (Persona per : personas.values()) {
			registros[0] = String.valueOf(per.getCodUsuario());
			registros[1] = per.getNombre();
			registros[2] = per.getEmail();

			modelo.addRow(registros);
		}

		return new JTable(modelo);

	}
}

