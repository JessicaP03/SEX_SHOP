package modelo;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import clases.Cosmetico;
import clases.Juguete;
import clases.Lenceria;
import clases.Persona;
import clases.Producto;

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
	final String INSERTpersona = "INSERT INTO persona (nombre, apellido, email, contraseña, tipo) VALUES ( ?, ?, ?, ?,?)";
	final String INSERTproducto = "INSERT INTO producto (idProducto, nombreProd, categori, sexo, precio, tipo) VALUES ( ?, ?, ?, ?, ?, ?)";
	final String INSERTlenceria = "INSERT INTO lenceria (idProducto, talla) VALUES (?, ?)";
	final String INSERTjuguetes = "INSERT INTO juguete (idProducto, material) VALUES (?, ?)";
	final String INSERTcosmeticos = "INSERT INTO cosmetico (idProducto, caducidad, ingredientes) VALUES (?, ?, ?)";
	final String MODIFproductos = "UPDATE producto SET nombreProd = ?, categori = ?, sexo = ?, precio = ?, tipo = ?";
	final String DELETEProducto = "DELETE FROM producto WHERE idProducto = ?";
	
	
	// Para la conexión utilizamos un fichero de configuaración, configuracion que
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
		// Patrón para validar el email
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		// El email a validar

		Matcher mather = pattern.matcher(email);

		return mather.find();
	}

	// INSERTAR PRODUCTO (clase de insertar producto, dentro de la configuracion
	// siendo admin

	public void insertarProducto(Producto produc) {
		this.openConnection();

		try {

			stmt = con.prepareStatement(INSERTproducto); // Cargamos el insert de persona con el stmt

			// Posicionamos cada valor para insertarlo en la base de datos
			stmt.setString(1, produc.getIdProducto());
			stmt.setString(2, produc.getNombreProd());
			stmt.setString(3, produc.getCategoria());
			stmt.setString(4, produc.getSexo());
			stmt.setInt(5, produc.getPrecio());
			stmt.setString(6, produc.getTipo());

			// Si la categoria es igual a lenceria
			if (produc.getCategoria().equalsIgnoreCase("LENCERIA")) {

				stmt = con.prepareStatement(INSERTlenceria);
				Lenceria lenc;
				lenc = new Lenceria();
				stmt.setString(1, lenc.getIdProducto());
				stmt.setString(2, lenc.getTalla());

				// Si la categoria es igual a juguete
			} else if (produc.getCategoria().equalsIgnoreCase("JUGUETE")) {
				stmt = con.prepareStatement(INSERTjuguetes);
				Juguete jug;
				jug = new Juguete();
				stmt.setString(1, jug.getIdProducto());
				stmt.setString(2, jug.getMaterial());

				// Si la categoria es igual a cosmético
			} else if (produc.getCategoria().equalsIgnoreCase("COSMETICO")) {
				stmt = con.prepareStatement(INSERTcosmeticos);
				Cosmetico cos;
				cos = new Cosmetico();
				stmt.setString(1, cos.getIdProducto());
				stmt.setString(2, cos.getCaducidad());
				stmt.setString(3, cos.getIngrediente());
			}

			stmt.executeUpdate();

			/// idProducto; nombreProd; categoria; sexo; precio; tipo;

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	//Con este metodo cargamos las categorias
	public Map<String, Producto> cargarCategorias() {

		Producto prod;
		ResultSet rs = null;

		Map<String, Producto> productos = new TreeMap<>();
		this.openConnection();

		String cargar = "SELECT * FROM producto";

		try {
			stmt = con.prepareStatement(cargar);

			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Producto();
				prod.setIdProducto("id");
				prod.setNombreProd("nombre");
				prod.setCategoria("categori");
				prod.setSexo("sexo");
				prod.setPrecio(2);
				prod.setTipo("tipo");

			}
			con.close();
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception ex) {
				System.out.println("ERROR EN LA CONSULTA DE PRODUCTOS");

			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("ERROR AL CERRAR LA BASE DE DATOS");
				e.printStackTrace();
			} catch (Exception ex) {
				System.out.println("ERROR AL CERRAR");

			}
		}
		return productos;
	}

	
	//Metodo para modificar los productos
	public void modificarproducto(Producto prod) {
		//Abrimos la conexion con la base de datos
		this.openConnection();
		
		//Metemos los valores dentro del stmt
		try {
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			stmt = con.prepareStatement(MODIFproductos);

			//EL ID NO SE MODIFICA
			stmt.setString(1, prod.getNombreProd());
			stmt.setString(2, prod.getCategoria());
			stmt.setString(3, prod.getSexo());
			stmt.setInt(4, prod.getPrecio());
			stmt.setString(5, prod.getTipo());

			stmt.executeUpdate();
			
		} catch (SQLException e1) {
			System.out.println("Error en la modificación SQL");
			e1.printStackTrace();
		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
	}
	
	//Metodo para dar de baja los productos
	public void bajaProducto(Producto prod) {
		// Abrimos la conexión
		this.openConnection();

		// Metemos los valores del propietario dentro del stat:
		try {
			

			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			stmt = con.prepareStatement(DELETEProducto);

			stmt.setString(1, prod.getIdProducto());

			stmt.executeUpdate();
		} catch (SQLException e1) {
			System.out.println("Error en la modificación SQL");
			e1.printStackTrace();
		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
	}
		
}
