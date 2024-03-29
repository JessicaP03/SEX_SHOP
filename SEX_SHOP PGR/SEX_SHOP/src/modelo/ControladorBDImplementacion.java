package modelo;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ComboBoxEditor;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Result;

import clases.Compra;
import clases.Cosmetico;
import clases.Empleado;
import clases.Juguete;
import clases.Lenceria;
import clases.Persona;
import clases.Producto;

public class ControladorBDImplementacion implements ControladorDatos {

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

	final String ObtenerProductos = "SELECT * FROM producto";

	final String ObtenerProducto = "SELECT * FROM producto where idproducto = ?";

	final String INSERTproducto = "INSERT INTO producto (idproducto, nombre_prod, categori, sexo, precio, tipo) VALUES (?, ?, ?, ?, ?, ?)";

	final String INSERTLenceria = "INSERT INTO lenceria (idproducto, talla) VALUES (?, ?)";

	final String INSERTjuguete = "INSERT INTO juguete (idproducto, material) VALUES (?, ?)";

	final String INSERTcosmetico = "INSERT INTO cosmetico (idproducto, caducidad, ingredientes) VALUES (?, ?, ?)";

	final String UPDATEJuguete = "UPDATE juguete SET material = ? where idproducto = ?";

	final String UPDATECosmetico = "UPDATE cosmetico SET caducidad = ?, ingredientes = ? where idproducto = ?";

	final String UPDATELenceria = "UPDATE lenceria SET talla = ? where idproducto = ?";

	final String UPDATEproducto = "UPDATE producto SET nombre_prod = ?, categori = ?, sexo = ?, precio = ?, tipo = ? WHERE idproducto= ?";

	final String UPDATEusuario = "UPDATE usuario SET nombre = ?, email = ? WHERE codusuario= ?";

	final String DELETEProducto = "DELETE FROM producto where idproducto=?";

	final String DELETEJuguete = "DELETE FROM juguete where idproducto=?";

	final String DELETELenceria = "DELETE FROM lenceria where idproducto=?";

	final String DELETECosmetico = "DELETE FROM cosmetico where idproducto=?";

	final String INSERTempleado = "INSERT INTO empleado (puesto, horario, administrador, codjefe) VALUES (?,?,?,?)";

	final String UPDATEmpleado = "UPDATE empleado SET puesto=?, horario=?, administrador=?, codjefe=? WHERE codusuario=?";

	final String DELETEempleado = "DELETE FROM empleado WHERE codusuario=?";

	final String ObtenerEmpleado = "SELECT * FROM empleado";

	final String ObtenerUsuario = "SELECT codusuario, nombre, email FROM persona WHERE TIPO LIKE '%CLIENTE%'";

	final String obtenerSoloJuguete = "SELECT * FROM producto WHERE categori like '%JUGUETE%'";

	final String obtenerSoloCosmetico = "SELECT * FROM producto WHERE categori like '%COSMETICO%'";

	final String obtenerSoloLenceria = "SELECT * FROM producto WHERE categori like '%LENCERIA%'";

	final String seleccionarCategoria = "SELECT CATEGORI FROM producto";

	final String ObtenerCompra = "SELECT* FROM compra";

	final String comprarProducto = "INSERT INTO producto (fecha_compra, idproducto, codusuario) VALUES (?,?,?)";

	// Para la conexión utilizamos un fichero de configuaración, configuracion que
	// guardamos en el paquete control:

	/**
	 * 
	 */
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
	/**
	 * @param pers insertar persona en la base de datos
	 */
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
		try {
			this.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// METODO PARA VERIFICAR SI EXISTE EL USUARIO
	/**
	 * @param persona
	 * @return verifica si existe la persona , para que no se repita
	 */
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

	/**
	 * @param producto
	 * @return verifica si existe el producto, para que no se repita
	 */
	public int existeProducto(String producto) {
		ResultSet rs = null;
		String existeProducto = "SELECT COUNT(IDPRODUCTO)FROM PRODUCTO WHERE IDPRODUCTO=?";
		this.openConnection();

		try {
			stmt = con.prepareStatement(existeProducto);
			stmt.setString(1, producto);
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
	/**
	 * @param email verifica que el email sigue el patron de un email convencional
	 * @return
	 */
	public boolean esEmail(String email) {
		// Patrón para validar el email
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		// El email a validar

		Matcher mather = pattern.matcher(email);

		return mather.find();
	}

	// METODO PARA LOGEARSE
	/**
	 * @param pers metodo mediante el que se loguea una persona
	 * @return
	 */
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
	/**
	 * @param prod metodo mediante el que el admin introduce un producto
	 */
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
			stmt.setInt(5, prod.getPrecio());
			stmt.setString(6, prod.getTipo());

			if (stmt.executeUpdate() == 1) {
				if (prod instanceof Lenceria) {
					stmt = con.prepareStatement(INSERTLenceria);

					stmt.setString(1, prod.getIdProducto());
					stmt.setString(2, ((Lenceria) prod).getTalla());
					stmt.executeUpdate();
				} else if (prod instanceof Juguete) {
					stmt = con.prepareStatement(INSERTjuguete);

					stmt.setString(1, prod.getIdProducto());
					stmt.setString(2, ((Juguete) prod).getMaterial());
					stmt.executeUpdate();
				} else if (prod instanceof Cosmetico) {
					stmt = con.prepareStatement(INSERTcosmetico);
					stmt.setString(1, prod.getIdProducto());
					stmt.setString(2, ((Cosmetico) prod).getCaducidad());
					stmt.setString(3, ((Cosmetico) prod).getIngrediente());
					stmt.executeUpdate();
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void comprarProducto(Compra comp) {
		this.openConnection();

		try {

			stmt = con.prepareStatement(comprarProducto);

			stmt.setDate(1, comp.getFecha_compra());
			stmt.setString(2, comp.getIdproducto());
			stmt.setInt(3, comp.getCodusuario());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modificarProducto(Producto prod) {

		ResultSet rs = null;

		// Abrimos la conexion con la base de datos
		this.openConnection();

		try {

			stmt = con.prepareStatement(UPDATEproducto);

			stmt.setString(1, prod.getNombreProd());
			stmt.setString(2, prod.getCategoria());
			stmt.setString(3, prod.getSexo());
			stmt.setInt(4, prod.getPrecio());
			stmt.setString(5, prod.getTipo());

			stmt.setString(6, prod.getIdProducto());

			if (stmt.executeUpdate() == 1) {
				if (prod instanceof Lenceria) {
					stmt = con.prepareStatement(UPDATELenceria);

					stmt.setString(1, prod.getIdProducto());
					stmt.setString(2, ((Lenceria) prod).getTalla());

					stmt.executeUpdate();
				} else if (prod instanceof Juguete) {
					stmt = con.prepareStatement(UPDATEJuguete);

					stmt.setString(1, prod.getIdProducto());
					stmt.setString(2, ((Juguete) prod).getMaterial());

					stmt.executeUpdate();
				} else if (prod instanceof Cosmetico) {
					stmt = con.prepareStatement(UPDATECosmetico);
					stmt.setString(1, prod.getIdProducto());
					stmt.setString(2, ((Cosmetico) prod).getCaducidad());
					stmt.setString(3, ((Cosmetico) prod).getIngrediente());

					stmt.executeUpdate();
				}

			}
		} catch (SQLException e1) {
			System.out.println("Error en la modificación SQL");
			e1.printStackTrace();

		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// Metodo para dar de baja los productos
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

	// Listar los productos

	public Map<String, Producto> listarProducto() {
		ResultSet rs = null;
		Producto prod;
		Map<String, Producto> listaProductos = new HashMap<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(ObtenerProductos);

			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Producto();
				prod.setIdProducto(rs.getString("idproducto"));
				prod.setNombreProd(rs.getString("nombre_prod"));
				prod.setCategoria(rs.getString("categori"));
				prod.setSexo(rs.getString("sexo"));
				prod.setPrecio(rs.getInt("precio"));
				prod.setTipo(rs.getString("tipo"));
				listaProductos.put(prod.getIdProducto(), prod);
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

	public Map<String, Compra> listarCompra() {
		ResultSet rs = null;
		Compra comp;
		Map<String, Compra> listaCompras = new HashMap<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(ObtenerCompra);

			rs = stmt.executeQuery();

			while (rs.next()) {

				comp = new Compra();
				comp.setFecha_compra(rs.getDate("fecha_compra"));
				comp.setIdproducto(rs.getString("idproducto"));
				comp.setCodusuario(rs.getInt("codusuario"));

				listaCompras.put(comp.getIdproducto(), comp);
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
		return listaCompras;
	}

	public Producto obtenerProducto(String idproducto) {
		ResultSet rs = null;
		Producto prod = null;

		this.openConnection();

		try {
			stmt = con.prepareStatement(ObtenerProducto);

			stmt.setString(0, idproducto);
			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Producto();
				prod.setIdProducto(rs.getString("idproducto"));
				prod.setNombreProd(rs.getString("nombre_prod"));
				prod.setCategoria(rs.getString("categori"));
				prod.setSexo(rs.getString("sexo"));
				prod.setPrecio(rs.getInt("precio"));
				prod.setTipo(rs.getString("tipo"));

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
		return prod;
	}

	/**
	 * @return recoges la informacion de empleados
	 */
	public Map<String, Empleado> listarEmpleados() {
		ResultSet rs = null;
		Empleado emp;
		Map<String, Empleado> listaEmpleados = new HashMap<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(ObtenerEmpleado);

			rs = stmt.executeQuery();

			while (rs.next()) {

				emp = new Empleado();
				emp.setCodUsuario(rs.getInt("codusuario"));
				emp.setPuesto(rs.getString("puesto"));
				emp.setHorario(rs.getString("horario"));
				emp.setAdministrador(rs.getString("administrador"));
				emp.setCodJefe(rs.getInt("codjefe"));
				listaEmpleados.put(String.valueOf(emp.getCodUsuario()), emp);

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
		return listaEmpleados;
	}

	/**
	 * @return
	 */
	/**
	 * @return muestra la informacion de productos
	 */
	public DefaultTableModel mostrarProductos() {

		String[] nombreColumnas = { "IDPRODUCTO, NOMBRE_PRODUC, CATEGORI, SEXO, PRECIO, TIPO" };
		String[] registros = new String[200];

		DefaultTableModel modelo = new DefaultTableModel(null, nombreColumnas);

		this.openConnection();

		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(ObtenerProducto);
			stmt.executeQuery();

			while (rs.next()) {
				registros[0] = rs.getString("IDPRODUCTO");
				registros[1] = rs.getString("NOMBRE_PROD");
				registros[2] = rs.getString("CATEGORI");
				registros[3] = rs.getString("SEXO");
				registros[4] = rs.getString("PRECIO");
				registros[5] = rs.getString("TIPO");

				modelo.addRow(registros);
			}

			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return modelo;

	}

	public void eliminarEmpleado(Empleado emp) {

		ResultSet rs = null;
		this.openConnection();

		try {

			stmt = con.prepareStatement(DELETEempleado);
			stmt.setInt(1, emp.getCodUsuario());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	}

	public void eliminarProducto(Producto prod) {

		this.openConnection();

		try {

			stmt = con.prepareStatement(DELETEProducto);
			stmt.setString(1, prod.getIdProducto());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet

			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}

		}

	}

	/**
	 * @param emp metodo mediante el cual un admin inserta un empleado
	 */
	public void insertarEmpleado(Empleado emp) {
		this.openConnection();

		try {

			stmt = con.prepareStatement(INSERTempleado); // Cargamos el insert de persona con el stmt

			// Posicionamos cada valor para insertarlo en la base de datos
			stmt.setString(1, emp.getPuesto());
			stmt.setString(2, emp.getHorario());
			stmt.setString(3, emp.getAdministrador());
			stmt.setInt(4, emp.getCodJefe());

			stmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			this.closeConnection();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// VALIDAR QUE NO SE PUEDAN INTRODUCIR STRINGS
	public boolean validarInteger(String cadena) {
		int num;
		try {
			// SI ES UN INT
			num = Integer.parseInt(cadena);
			return true;

		} catch (Exception e) {
			// SI ES UN STRING
			return false;
		}
	}

	public void modificarEmpleado(Empleado emp) {

		ResultSet rs = null;

		// Abrimos la conexion con la base de datos
		this.openConnection();

		try {

			stmt = con.prepareStatement(UPDATEmpleado);

			stmt.setString(1, emp.getPuesto());
			stmt.setString(2, emp.getHorario());
			stmt.setString(3, emp.getAdministrador());
			stmt.setInt(4, emp.getCodJefe());

			stmt.setInt(5, emp.getCodUsuario());

			stmt.executeUpdate();

		} catch (SQLException e1) {
			System.out.println("Error en la modificación SQL");
			e1.printStackTrace();

		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void modificarUsuario(Persona pers) {

		ResultSet rs = null;

		this.openConnection();

		try {

			stmt = con.prepareStatement(UPDATEusuario); // Cargamos el insert de persona con el stmt

			// Posicionamos cada valor para insertarlo en la base de datos
			stmt.setString(1, pers.getNombre());
			stmt.setString(2, pers.getEmail());

			stmt.setInt(3, pers.getCodUsuario());
			stmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			this.closeConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Map<Integer, Persona> listarUsuario() {
		ResultSet rs = null;
		Persona pers;
		Map<Integer, Persona> listaUsuarios = new HashMap<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(ObtenerUsuario);

			rs = stmt.executeQuery();

			while (rs.next()) {
				pers = new Persona();
				pers.setCodUsuario(rs.getInt("codusuario"));
				pers.setNombre(rs.getString("nombre"));
				pers.setEmail(rs.getString("email"));

				listaUsuarios.put(pers.getCodUsuario(), pers);

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
		return listaUsuarios;
	}

	public Map<String, Empleado> listarEmpleado() {
		ResultSet rs = null;
		Empleado emp;
		Map<String, Empleado> listarEmpleado = new HashMap<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(ObtenerEmpleado);

			rs = stmt.executeQuery();

			while (rs.next()) {
				emp = new Empleado();
				emp.setCodUsuario(rs.getInt("codusuario"));
				emp.setPuesto(rs.getString("puesto"));
				emp.setHorario(rs.getString("horario"));
				emp.setAdministrador(rs.getString("administrador"));
				emp.setCodJefe(rs.getInt("codjefe"));
				listarEmpleado.put(String.valueOf(emp.getCodUsuario()), emp);

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
		return listarEmpleado;
	}

	@Override
	public Producto leerDatosPantalla(String idProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado leerDatosEmpleado(String codusuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Producto> listarJuguetes() {
		ResultSet rs = null;
		Producto prod;
		Map<String, Producto> listarProducto = new HashMap<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(obtenerSoloJuguete);

			rs = stmt.executeQuery();

			while (rs.next()) {

				prod = new Producto();
				prod.setIdProducto(rs.getString("idproducto"));
				prod.setNombreProd(rs.getString("nombre_prod"));
				prod.setCategoria(rs.getString("categori"));
				prod.setPrecio(rs.getInt("precio"));
				prod.setSexo(rs.getString("sexo"));
				prod.setTipo(rs.getString("tipo"));
				listarProducto.put(prod.getIdProducto(), prod);

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
		return listarProducto;
	}

	public Map<String, Producto> listarCosmetico() {
		ResultSet rs = null;
		Producto prod;
		Map<String, Producto> listarProducto = new HashMap<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(obtenerSoloCosmetico);

			rs = stmt.executeQuery();

			while (rs.next()) {

				prod = new Producto();
				prod.setIdProducto(rs.getString("idproducto"));
				prod.setNombreProd(rs.getString("nombre_prod"));
				prod.setCategoria(rs.getString("categori"));
				prod.setPrecio(rs.getInt("precio"));
				prod.setSexo(rs.getString("sexo"));
				prod.setTipo(rs.getString("tipo"));
				listarProducto.put(prod.getIdProducto(), prod);

				if (prod.getPrecio() < 10) {
					stmt = con.prepareStatement(obtenerSoloCosmetico + "AND precio<10");

				} else if (prod.getPrecio() < 20 & prod.getPrecio() > 10) {
					stmt = con.prepareStatement(obtenerSoloCosmetico + "AND precio>10 AND precio<20");
				} else if (prod.getPrecio() < 30 & prod.getPrecio() > 20) {
					stmt = con.prepareStatement(obtenerSoloCosmetico + "AND precio>20 AND precio<30");
				} else if (prod.getPrecio() < 40 & prod.getPrecio() > 30) {
					stmt = con.prepareStatement(obtenerSoloCosmetico + "AND precio>30 AND precio<40");
				} else if (prod.getPrecio() < 50 & prod.getPrecio() > 40) {
					stmt = con.prepareStatement(obtenerSoloCosmetico + "AND precio>50 AND precio<100");

				}

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
		return listarProducto;
	}

	public Map<String, Producto> listarLenceria() {
		ResultSet rs = null;
		Producto prod;
		Map<String, Producto> listarProducto = new HashMap<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(obtenerSoloLenceria);

			rs = stmt.executeQuery();

			while (rs.next()) {

				prod = new Producto();
				prod.setIdProducto(rs.getString("idproducto"));
				prod.setNombreProd(rs.getString("nombre_prod"));
				prod.setCategoria(rs.getString("categori"));
				prod.setPrecio(rs.getInt("precio"));
				prod.setSexo(rs.getString("sexo"));
				prod.setTipo(rs.getString("tipo"));
				listarProducto.put(prod.getIdProducto(), prod);

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
		return listarProducto;
	}

}
