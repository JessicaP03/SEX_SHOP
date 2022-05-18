package modelo;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import clases.Empleado;
import clases.Persona;
import clases.Producto;

public interface ControladorDatos {

	public void modificarProducto(Producto prod);

	public Map<String, Producto> listarProducto();

	public void eliminarProducto(Producto prod);

	public Producto leerDatosPantalla(String idProducto);

	public void modificarEmpleado(Empleado emp);

	public void eliminarEmpleado(Empleado emp);

	public boolean validarInteger(String cadena);

	public void bajaProducto(Producto prod);

	public Empleado leerDatosEmpleado(String codusuario);

	public Map<String, Empleado> listarEmpleado();

	public Producto obtenerProducto(String idproducto);

	public void modificarUsuario(Persona pers);

	public Map<String, Persona> listarUsuario();

	public Map<String, Producto> listarJuguetes();

	public Map<String, Producto> listarCosmetico();

	public Map<String, Producto> listarLenceria();

	
}
