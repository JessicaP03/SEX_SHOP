package clases;

public class Producto {

	//ATRIBUTOS
	private String idProducto;
	private String nombreProd;
	private String categoria;
	private String sexo;
	private int precio;
	private String tipo;
	
	//CONSTRUCTORES
	public Producto(String idProducto, String nombreProd, String categoria, String sexo, int precio, String tipo) {
		super();
		this.idProducto = idProducto;
		this.nombreProd = nombreProd;
		this.categoria = categoria;
		this.sexo = sexo;
		this.precio = precio;
		this.tipo = tipo;
	}
	
	public Producto() {
		super();
	}

	//GETTERS Y SETTERS
	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProd() {
		return nombreProd;
	}

	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
