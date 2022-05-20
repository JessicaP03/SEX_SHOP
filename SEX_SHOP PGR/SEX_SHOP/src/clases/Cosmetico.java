	package clases;

import java.sql.Date;

/**
 * @author 1dam
 *
 */
public class Cosmetico extends Producto {
	
	//ATRIBUTOS
	private String caducidad;
	private String ingrediente;
	
	//CONSTRUCTORES
	/**
	 * @param idProducto lo utilizamos como clave primaria del producto
	 * @param nombreProd
	 * @param categoria diferenciamos los productos mediante la categoria
	 * @param sexo
	 * @param precio
	 * @param tipo
	 * @param caducidad distintivo de cosmeticos
	 * @param ingrediente distintivo de cosmeticos
	 */
	public Cosmetico(String idProducto, String nombreProd, String categoria, String sexo, int precio, String tipo,
			String caducidad, String ingrediente) {
		super(idProducto, nombreProd, categoria, sexo, precio, tipo);
		this.caducidad = caducidad;
		this.ingrediente = ingrediente;
	}
	
	//GETTERS Y SETTERS
	/**
	 * 
	 */
	public Cosmetico() {
		super();
	}

	/**
	 * @return
	 */
	public String getCaducidad() {
		return caducidad;
	}

	/**
	 * @param caducidad
	 */
	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}

	/**
	 * @return
	 */
	public String getIngrediente() {
		return ingrediente;
	}

	/**
	 * @param ingrediente
	 */
	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	
	
}
