package clases;

public class Lenceria extends Producto {

	//ATRIBUTOS
	private String talla;

	//CONSTRUCTORES
	public Lenceria(String idProducto, String nombreProd, String categoria, String sexo, int precio, String tipo,
			String talla) {
		super(idProducto, nombreProd, categoria, sexo, precio, tipo);
		this.talla = talla;
	}
	
	public Lenceria() {
		super();
	}

	//GETTERS Y SETTERS
	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}
	
	
}
