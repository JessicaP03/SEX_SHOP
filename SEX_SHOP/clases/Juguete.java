package clases;

public class Juguete extends Producto {

	//ATRIBUTOS
	private String material;

	//CONSTRUCTORES
	public Juguete(String idProducto, String nombreProd, String categoria, String sexo, int precio, String tipo,
			String material) {
		super(idProducto, nombreProd, categoria, sexo, precio, tipo);
		this.material = material;
	}
	
	public Juguete() {
		super();
	}
	
	
	//GETTERS Y SETTERS

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	
	
	
}
