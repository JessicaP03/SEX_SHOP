package modelo;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import clases.Producto;

public interface ControladorDatos {



	public void modificarProducto(Producto prod);
	
	public Map<String, Producto> listarProducto(Producto prod);

}
