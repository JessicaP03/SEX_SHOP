package modelo;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import clases.Compra;
import clases.Empleado;
import clases.Persona;
import clases.Producto;

/**
 * @author 1dam
 *
 */
public interface ControladorDatos {

	/**
	 * @param prod
	 */
	public void modificarProducto(Producto prod);

	/**
	 * @return
	 */
	public Map<String, Producto> listarProducto();

	/**
	 * @param prod
	 */
	public void eliminarProducto(Producto prod);

	/**
	 * @param idProducto
	 * @return
	 */
	public Producto leerDatosPantalla(String idProducto);

	/**
	 * @param emp
	 */
	public void modificarEmpleado(Empleado emp);

	/**
	 * @param emp
	 */
	public void eliminarEmpleado(Empleado emp);

	/**
	 * @param cadena
	 * @return
	 */
	public boolean validarInteger(String cadena);

	/**
	 * @param prod
	 */
	public void bajaProducto(Producto prod);

	/**
	 * @param codusuario
	 * @return
	 */
	public Empleado leerDatosEmpleado(String codusuario);

	/**
	 * @return
	 */
	public Map<String, Empleado> listarEmpleado();

	/**
	 * @param idproducto
	 * @return
	 */
	public Producto obtenerProducto(String idproducto);

	/**
	 * @param pers
	 */
	public void modificarUsuario(Persona pers);

	/**
	 * @return
	 */
	public Map<Integer, Persona> listarUsuario();

	/**
	 * @return
	 */
	public Map<String, Producto> listarJuguetes();

	/**
	 * @return
	 */
	public Map<String, Producto> listarCosmetico();

	/**
	 * @return
	 */
	public Map<String, Producto> listarLenceria();

	/**
	 * @param comp
	 */
	public void comprarProducto(Compra comp);

	/**
	 * @return
	 */
	public Map<String, Compra> listarCompra();
}
