package clases;

/**
 * @author 1dam
 *
 */
public class Producto {

	//ATRIBUTOS
	private String idProducto;
	private String nombreProd;
	private String categoria;
	private String sexo;
	private int precio;
	private String tipo;
	
	//CONSTRUCTORES
	/**
	 * @param idProducto
	 * @param nombreProd
	 * @param categoria
	 * @param sexo
	 * @param precio
	 * @param tipo
	 */
	public Producto(String idProducto, String nombreProd, String categoria, String sexo, int precio, String tipo) {
		super();
		this.idProducto = idProducto;
		this.nombreProd = nombreProd;
		this.categoria = categoria;
		this.sexo = sexo;
		this.precio = precio;
		this.tipo = tipo;
	}
	
	/**
	 * 
	 */
	public Producto() {
		super();
	}

	//GETTERS Y SETTERS
	/**
	 * @return
	 */
	public String getIdProducto() {
		return idProducto;
	}

	/**
	 * @param idProducto
	 */
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * @return
	 */
	public String getNombreProd() {
		return nombreProd;
	}

	/**
	 * @param nombreProd
	 */
	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	/**
	 * @return
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * @param precio
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
