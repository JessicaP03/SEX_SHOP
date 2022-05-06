package modelo;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import clases.Cosmetico;
import clases.Juguete;
import clases.Lenceria;
import clases.Persona;
import clases.Producto;

public class ControladorBDImplementacion implements ControladorDatos{

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
	final String loguearse = "SELECT * FROM persona WHERE email=? and contraseña=?";
	final String ObtenerProducto = "SELECT * FROM producto";
	final String INSERTproducto = "INSERT INTO producto (idproducto, nombre_prod, categori, sexo, precio, tipo) VALUES (?, ?, ?, ?, ?, ?)";
	final String INSERTLenceria = "INSERT INTO lenceria (idproducto, talla) VALUES (?, ?)";
	final String INSERTjuguete = "INSERT INTO juguete (idproducto, material) VALUES (?, ?)";
	final String INSERTcosmetico = "INSERT INTO cosmetico (idproducto, caducidad, ingredientes) VALUES (?, ?, ?)";
	final String UPDATEproducto = "UPDATE producto SET nombre_prod = ?, sexo = ?, precio = ?, tipo = ? where idproducto= ?";
	final String UPDATELenceria = "UPDATE lenceria SET talla = ? where idproducto = ?";
	final String UPDATEJugute = "UPDATE juguete SET material = ? where idproducto = ?";
	final String UPDATECosmetico = "UPDATE cosmetico SET caducidad = ?, ingredientes = ? where idproducto = ?";
	final String DELETEProducto = "DELETE FROM producto where idproducto =?;";
	final String SELECTProducto = "SELECT * FROM producto where idproducto=?";

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

	// METODO PARA LOGEARSE
	public Persona login(Persona pers) {

		ResultSet rs = null;

		this.openConnection();

		try {
			stmt = con.prepareStatement(loguearse);
			stmt.setString(1, pers.getEmail());
			stmt.setString(2, pers.getContrasena());

			rs = stmt.executeQuery();

			pers = new Persona();
			if (rs.next()) {
				// RECOGEMOS LOS DATOS DE PERSONA
				pers.setCodUsuario(rs.getInt(1));
				pers.setNombre(rs.getString(2));
				pers.setApellido(rs.getString(3));
				pers.setEmail(rs.getString(4));
				pers.setContrasena(rs.getString(5));
				pers.setTipo(rs.getString(6));
			}
		} catch (SQLException e) {
			Logger.getLogger(ControladorBDImplementacion.class.getName()).log(Level.SEVERE, null, e);

		}
		return pers;
	}

	// METODO PARA INSERTAR PRODUCTO DEPENDIENDO LA CATEGORIA
	public void insertarProducto(Producto prod) {

		ResultSet rs = null;

		this.openConnection();

		try {

			stmt = con.prepareStatement(INSERTproducto); // Cargamos el insert de persona con el stmt

			// Posicionamos cada valor para insertarlo en la base de datos
			stmt.setString(1, prod.getIdProducto());
			stmt.setString(2, prod.getNombreProd());
			stmt.setString(3, prod.getCategoria());
			stmt.setString(4, prod.getSexo());
			stmt.setString(5, prod.getTipo());

			rs = stmt.executeQuery();

			if (stmt.executeQuery() != null) {
				if (prod.getCategoria().equalsIgnoreCase("LENCERIA")) {
					stmt = con.prepareStatement(INSERTLenceria);

					stmt.setString(1, prod.getIdProducto());
					stmt.setString(2, ((Lenceria) prod).getTalla());
					stmt.executeQuery();

				} else if (prod.getCategoria().equalsIgnoreCase("JUGUETES")) {

					stmt = con.prepareStatement(INSERTjuguete);

					stmt.setString(1, prod.getIdProducto());
					stmt.setString(2, ((Juguete) prod).getMaterial());

				} else if (prod.getCategoria().equalsIgnoreCase("COSMETICOS")) {

					stmt = con.prepareStatement(INSERTcosmetico);
					stmt.setString(1, prod.getIdProducto());
					stmt.setString(2, ((Cosmetico) prod).getCaducidad());
					stmt.setString(3, ((Cosmetico) prod).getIngrediente());
				}
			}

			stmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// Listar los productos

	public ArrayList<Producto> listarProducto() {
		ResultSet rs = null;
		Producto prod;
		ArrayList<Producto> listaProductos = new ArrayList<>();
		this.openConnection();

		try {
			stmt = con.prepareStatement(ObtenerProducto);
			rs = stmt.executeQuery();
			while (rs.next()) {
				prod = new Producto();
				prod.setIdProducto(rs.getString("idproducto"));
				prod.setNombreProd(rs.getString("nombreproducto"));
				prod.setCategoria(rs.getString("categori"));
				prod.setSexo(rs.getString("sexo"));
				prod.setPrecio(rs.getInt("precio"));
				prod.setTipo(rs.getString("tipo"));

				listaProductos.add(prod);

			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return listaProductos;
	}

	
	
	
	
	
	
	
	
	// Metodo para modificar los productos
	public void modificarproducto(Producto prod) {
		// Abrimos la conexion con la base de datos
		this.openConnection();

		// Metemos los valores dentro del stmt
		try {
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			stmt = con.prepareStatement(UPDATEproducto);

			// EL ID NO SE MODIFICA
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
				System.out.println("Error en el cierre de la Base de Datos");
				e.printStackTrace();
			}
		}
	}
//
//	// Metodo para dar de baja los productos
//	public void bajaProducto(Producto prod) {
//		// Abrimos la conexión
//		this.openConnection();
//
//		// Metemos los valores del propietario dentro del stat:
//		try {
//
//			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
//			stmt = con.prepareStatement(DELETEProducto);
//
//			stmt.setString(1, prod.getIdProducto());
//
//			stmt.executeUpdate();
//		} catch (SQLException e1) {
//			System.out.println("Error en la modificación SQL");
//			e1.printStackTrace();
//		} finally {
//			try {
//				this.closeConnection();
//			} catch (SQLException e) {
//				System.out.println("Error en cierre de la BD");
//				e.printStackTrace();
//			}
//		}
//	}

		
	

	@Override
	public Producto obtenerProducto(String idproducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bajaproducto(String codigo) {
		// TODO Auto-generated method stub
		
	}

}
