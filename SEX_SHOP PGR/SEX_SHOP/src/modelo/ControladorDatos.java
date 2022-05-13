package modelo;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import clases.Empleado;
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
}
