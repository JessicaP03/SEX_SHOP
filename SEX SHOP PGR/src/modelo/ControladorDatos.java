package modelo;

import clases.Persona;
import clases.Producto;

public interface ControladorDatos {

	
	public void insertarProducto (Producto prod);

	public void  modificarProducto (Producto prod);
	
	public Producto obtenerProducto (String idproducto); 
	
	public void bajaProducto (String codigo);

	public Persona login(Persona pers);
	
	
	
	
}
