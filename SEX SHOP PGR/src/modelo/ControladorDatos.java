package modelo;

import clases.Producto;

public interface ControladorDatos {

	
	public void insertarProducto (Producto prod);

	public void  modificarProducto (Producto prod);
	
	public Producto obtenerProducto (String idproducto); 
	
	public void bajaproducto (String codigo);
	
	
	
	
}
