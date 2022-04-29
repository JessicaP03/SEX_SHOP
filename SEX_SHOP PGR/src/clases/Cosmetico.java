package clases;

import java.sql.Date;

public class Cosmetico extends Producto {
	
	//ATRIBUTOS
	private String caducidad;
	private String ingrediente;
	
	//CONSTRUCTORES
	public Cosmetico(String idProducto, String nombreProd, String categoria, String sexo, int precio, String tipo,
			String caducidad, String ingrediente) {
		super(idProducto, nombreProd, categoria, sexo, precio, tipo);
		this.caducidad = caducidad;
		this.ingrediente = ingrediente;
	}
	
	//GETTERS Y SETTERS
	public Cosmetico() {
		super();
	}

	public String getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}

	public String getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	
	
}
