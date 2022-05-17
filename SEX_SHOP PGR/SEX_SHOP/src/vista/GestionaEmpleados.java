package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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

public class GestionaEmpleados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textPuesto;
	private JTextField textHorario;
	private ButtonGroup jefe, admin;
	private JRadioButton rdbtnAdminNo, rdbtnAdminSi;
	private JComboBox comboJefe;
	private JTextField textID;
	private ControladorDatos datos;
	private Map<String, Empleado> empleados;
	private JTable tablaEmpleado;

	public GestionaEmpleados(Configuracion padre, boolean modal, ControladorDatos datos, Empleado empleado) {
		super(padre);
		this.setModal(modal);
		setBounds(100, 100, 766, 359);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(128, 128, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		textPuesto = new JTextField();
		textPuesto.setBackground(new Color(255, 51, 153));
		textPuesto.setBounds(160, 70, 86, 20);
		textPuesto.setColumns(10);
		contentPanel.add(textPuesto);

		textHorario = new JTextField();
		textHorario.setBackground(new Color(255, 51, 153));
		textHorario.setBounds(160, 112, 86, 20);
		textHorario.setColumns(10);
		contentPanel.add(textHorario);

		JLabel lblPuesto = new JLabel("Puesto");
		lblPuesto.setForeground(new Color(255, 250, 250));
		lblPuesto.setBounds(26, 71, 145, 14);
		lblPuesto.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPanel.add(lblPuesto);

		JLabel lblCodigo_2 = new JLabel("Horario");
		lblCodigo_2.setForeground(new Color(255, 250, 250));
		lblCodigo_2.setBounds(26, 113, 145, 14);
		lblCodigo_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPanel.add(lblCodigo_2);

		JLabel lblCodigo_3_1 = new JLabel("Administrador");
		lblCodigo_3_1.setForeground(new Color(255, 250, 250));
		lblCodigo_3_1.setBounds(26, 161, 98, 14);
		lblCodigo_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPanel.add(lblCodigo_3_1);

		rdbtnAdminSi = new JRadioButton("Si");
		rdbtnAdminSi.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnAdminSi.setBackground(new Color(255, 51, 153));
		rdbtnAdminSi.setForeground(new Color(255, 255, 255));
		rdbtnAdminSi.setBounds(160, 159, 52, 23);
		contentPanel.add(rdbtnAdminSi);

		rdbtnAdminNo = new JRadioButton("No");
		rdbtnAdminNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnAdminNo.setForeground(new Color(255, 255, 255));
		rdbtnAdminNo.setBackground(new Color(255, 51, 153));
		rdbtnAdminNo.setBounds(227, 159, 51, 23);
		contentPanel.add(rdbtnAdminNo);

		JLabel lblNewLabel = new JLabel("INTRODUCIR DATOS DE EMPLEADO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(26, 23, 284, 23);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPanel.add(lblNewLabel);

		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setBackground(new Color(255, 255, 153));
		btnInsertar.setForeground(new Color(0, 0, 0));
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				insertar();
			}
		});
		btnInsertar.setBounds(26, 270, 89, 23);
		contentPanel.add(btnInsertar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modificar(datos);
			}
		});
		btnModificar.setBackground(new Color(255, 255, 153));
		btnModificar.setBounds(160, 270, 89, 23);
		contentPanel.add(btnModificar);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarEmpleado(datos);
			}
		});
		btnBorrar.setBackground(new Color(255, 255, 153));
		btnBorrar.setBounds(310, 270, 89, 23);
		contentPanel.add(btnBorrar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}

		ButtonGroup jefe = new ButtonGroup();

		ButtonGroup admin = new ButtonGroup();
		admin.add(rdbtnAdminSi);
		admin.add(rdbtnAdminNo);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 153));
		separator.setBounds(26, 257, 680, 2);
		contentPanel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(255, 255, 153));
		separator_1.setBounds(21, 57, 685, 2);
		contentPanel.add(separator_1);

		comboJefe = new JComboBox();
		comboJefe.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		comboJefe.setForeground(new Color(255, 255, 255));
		comboJefe.setBackground(new Color(255, 51, 153));
		comboJefe.setBounds(160, 201, 118, 22);
		contentPanel.add(comboJefe);

		JLabel lblNewLabel_1 = new JLabel("Jefe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(26, 200, 46, 14);
		contentPanel.add(lblNewLabel_1);

		textID = new JTextField();
		textID.setColumns(10);
		textID.setBackground(new Color(204, 255, 255));
		textID.setBounds(445, 70, 98, 20);
		contentPanel.add(textID);

		JLabel lblNewLabel_2 = new JLabel("COD_USUARIO:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 153));
		lblNewLabel_2.setBounds(310, 71, 138, 14);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Necesario en caso de modificar \r\no dar de baja");
		lblNewLabel_3.setForeground(new Color(255, 255, 153));
		lblNewLabel_3.setBounds(310, 78, 228, 47);
		contentPanel.add(lblNewLabel_3);
		
		this.presentarTabla(empleado, datos);
	}

	protected void eliminarEmpleado(ControladorDatos datos) {
		Empleado emp = leerDatosEmpleado(textID.getText());

		datos.eliminarEmpleado(emp);

		// Mensaje de confirmación
		JOptionPane.showMessageDialog(this, "EMPLEADO ELIMINADO");

	}

	protected void modificar(ControladorDatos datos) {
		
		Empleado emp = leerDatosEmpleado(textID.getText());
		if (textID.equals("1") || textID.equals("2") || textID.equals("3") || textID.equals("4")
				|| textID.equals("5")) {
			JOptionPane.showMessageDialog(this, "LOS JEFES NO SE PUEDE ACTUALIZAR");
		} else {
			datos.modificarEmpleado(emp);
			JOptionPane.showMessageDialog(this, "EL EMPLEADO SE HA MODIFICADO CORRECTAMENTE");

		}

	}

	// INSERTAR EMPLEADO NUEVO
	public Empleado leerDatosEmpleado(String codusuario) {
		Empleado emp;
		emp = new Empleado();

		if (textPuesto.equals("") || textHorario.equals("")) {
			JOptionPane.showMessageDialog(this, "FALTAN CAMPOS POR RELLENAR");
		} else {
			// INTROODUCIR ATRIBUTOS DE EMPLEADO
			emp.setCodUsuario(Integer.parseInt(codusuario));
			emp.setPuesto(textPuesto.getText());
			emp.setHorario(textHorario.getText());

			// SI EL BOTON ADMIN ESTA SELECIONADO
			if (rdbtnAdminSi.isSelected()) {
				emp.setAdministrador("SI");

				// SI EL BOTON ADMIN NO ESTA SELECIONADO
			} else if (rdbtnAdminNo.isSelected()) {
				emp.setAdministrador("NO");
			} else {
				// SI FALTA ALGUN BOTON POR ELEGIR
				JOptionPane.showMessageDialog(this, "FALTAN CAMPOS POR RELLENAR");
			}
			emp.setCodJefe(Integer.parseInt((String) comboJefe.getSelectedItem()));
			ControladorBDImplementacion datos = new ControladorBDImplementacion();
			datos.modificarEmpleado(emp);

		}

		return emp;
	}

	protected void insertar() {
		Empleado emp;
		emp = new Empleado();

		if (textPuesto.equals("") || textHorario.equals("")) {
			JOptionPane.showMessageDialog(this, "FALTAN CAMPOS POR RELLENAR");
		} else {
			// INTROODUCIR ATRIBUTOS DE EMPLEADO
			emp.setPuesto(textPuesto.getText());
			emp.setHorario(textHorario.getText());

			// SI EL BOTON ADMIN ESTA SELECIONADO
			if (rdbtnAdminSi.isSelected()) {
				emp.setAdministrador("SI");

				// SI EL BOTON ADMIN NO ESTA SELECIONADO
			} else if (rdbtnAdminNo.isSelected()) {
				emp.setAdministrador("NO");

			} else {
				// SI FALTA ALGUN BOTON POR ELEGIR
				JOptionPane.showMessageDialog(this, "FALTAN CAMPOS POR RELLENAR");
			}
			emp.setCodJefe(Integer.parseInt((String) comboJefe.getSelectedItem()));

			JOptionPane.showMessageDialog(this, "EMPLEADO AÑADIDO CORRECTAMENTE");
			ControladorBDImplementacion datos = new ControladorBDImplementacion();
			datos.insertarEmpleado(emp);

		}

	}

	private void presentarTabla(Empleado empleado, ControladorDatos datos) {

		JScrollPane scroll = new JScrollPane();
		tablaEmpleado = this.cargarTabla(empleado, datos);
		scroll.setViewportView(tablaEmpleado);

		contentPanel.add(scroll);
		scroll.setBounds(310, 112, 366, 132);
		
		textID = new JTextField();
		textID.setBounds(48, 99, 133, 20);
		contentPanel.add(textID);
		textID.setColumns(10);
	}

	private JTable cargarTabla(Empleado empleado, ControladorDatos datos) {

		String[] nombreColumnas = { "CODUSUARIO", "PUESTO", "HORARIO", "ADMIN", "CODJEFE" };
		String[] registros = new String[5];

		DefaultTableModel modelo = new DefaultTableModel(null, nombreColumnas);
		modelo.setRowCount(0);

		empleados = datos.listarEmpleado();

		for (Empleado emp : empleados.values()) {
			registros[0] = String.valueOf(emp.getCodUsuario());
			registros[1] = emp.getPuesto();
			registros[2] = emp.getHorario();
			registros[3] = emp.getAdministrador();
			registros[4] = String.valueOf(emp.getCodJefe());

			modelo.addRow(registros);
		}

		return new JTable(modelo);

	}
	
	
}
