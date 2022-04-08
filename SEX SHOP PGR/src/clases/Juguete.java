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
	//GETTERS Y SETTERS
	public Juguete() {
		super();
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	
	
	
}
