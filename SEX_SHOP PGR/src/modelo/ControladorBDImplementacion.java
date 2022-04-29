package modelo;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import clases.Persona;

public class ControladorBDImplementacion {

	// Atributos
	private Connection con;
	private PreparedStatement stmt;

	// Estos atributos son los necesarios para recoger los valores del fichero de
	// configuracion
	private ResourceBundle configFichero;

	private String driverBD;
	private String urlBD;
	private String userBD;
	private String passwordBD;
	private String id;

	// Sentencias sql
	final String INSERTpersona = "INSERT INTO persona (nombre, apellido, email, contrase�a, tipo) VALUES ( ?, ?, ?, ?,?)";
//	final String codUsuario = "CALL codigo_automatico()"; //LLamamos al procedimiento 

	// Para la conexi�n utilizamos un fichero de configuaraci�n, configuracion que
	// guardamos en el paquete control:

	public ControladorBDImplementacion() {
		this.configFichero = ResourceBundle.getBundle("modelo.configuracion");
		this.driverBD = this.configFichero.getString("Driver");
		this.urlBD = this.configFichero.getString("Conn");
		this.userBD = this.configFichero.getString("DBUser");
		this.passwordBD = this.configFichero.getString("DBPass");
	}

	private void openConnection() {
		try {
			// Class.forName(this.driverBD);
			con = DriverManager.getConnection(this.urlBD, this.userBD, this.passwordBD);
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha abierto la base de datos");
			e.printStackTrace();
		}
	}

	private void closeConnection() throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null)
			con.close();
	}

	// Metodo para insertar un nuevo registro en la base de datos utilizando un
	// procediemiento de mysql
	public void insertarPersona(Persona pers) {
		this.openConnection();

		try {

			stmt = con.prepareStatement(INSERTpersona); // Cargamos el insert de persona con el stmt

			// Posicionamos cada valor para insertarlo en la base de datos
			stmt.setString(1, pers.getNombre());
			stmt.setString(2, pers.getApellido());
			stmt.setString(3, pers.getEmail());
			stmt.setString(4, pers.getContrasena());
			stmt.setString(5, "CLIENTE");

			stmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// METODO PARA VERIFICAR SI EXISTE EL USUARIO
	public int existePersona(String persona) {

		ResultSet rs = null;
		String registrar = "SELECT COUNT(CODUSUARIO)FROM PERSONA WHERE NOMBRE=?";
		this.openConnection();

		try {
			stmt = con.prepareStatement(registrar);
			stmt.setString(1, persona);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
			return 1;

		} catch (SQLException e) {
			e.printStackTrace();

			return 1;

		}

	}

	// METODO PARA VERIFICAR LOS PATRONES DE UN EMAIL
	public boolean esEmail(String email) {
		// Patr�n para validar el email
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		// El email a validar

		Matcher mather = pattern.matcher(email);

		return mather.find();
	}

	public boolean login(Persona pers) {

		ResultSet rs = null;
		String loguearse = "SELECT EMAIL,CONTRASENA FROM PERSONA WHERE EMAIL=?";
		this.openConnection();

		try {
			stmt = con.prepareStatement(loguearse);
			stmt.setString(1, pers.getEmail());
			rs = stmt.executeQuery();

			if (rs.next()) {

				if (pers.getContrasena().equals(rs.getString(2))) {
					pers.setEmail(rs.getString(1));
					pers.setContrasena(rs.getString(2));

					return true;

				} else {
					return false;
				}
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return false;

	}

}