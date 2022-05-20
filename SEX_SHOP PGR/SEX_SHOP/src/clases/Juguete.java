package clases;

public class Juguete extends Producto {

	//ATRIBUTOS
	private String material;

	//CONSTRUCTORES
	/**
	 * @param idProducto lo utilizamos como clave primaria de producto 
	 * @param nombreProd
	 * @param categoria
	 * @param sexo
	 * @param precio
	 * @param tipo
	 * @param material
	 */
	public Juguete(String idProducto, String nombreProd, String categoria, String sexo, int precio, String tipo,
			String material) {
		super(idProducto, nombreProd, categoria, sexo, precio, tipo);
		this.material = material;
	}
	
	/**
	 * 
	 */
	public Juguete() {
		super();
	}
	
	
	//GETTERS Y SETTERS

	/**
	 * @return
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * @param material
	 */
	public void setMaterial(String material) {
		this.material = material;
	}
	
	
	
	
}
