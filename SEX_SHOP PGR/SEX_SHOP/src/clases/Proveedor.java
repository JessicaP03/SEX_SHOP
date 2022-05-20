package clases;

public class Proveedor {
	//ATRIBUTOS
	private String codProveedor;
	private String sector;
	
	//CONSTRUCTORES
	/**
	 * @param codProveedor
	 * @param sector
	 */
	public Proveedor(String codProveedor, String sector) {
		super();
		this.codProveedor = codProveedor;
		this.sector = sector;
	}
	
	/**
	 * 
	 */
	public Proveedor() {
		super();
	}

	//GETTERS Y SETTERS
	/**
	 * @return
	 */
	public String getCodProveedor() {
		return codProveedor;
	}

	/**
	 * @param codProveedor
	 */
	public void setCodProveedor(String codProveedor) {
		this.codProveedor = codProveedor;
	}

	/**
	 * @return
	 */
	public String getSector() {
		return sector;
	}

	/**
	 * @param sector
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}
	
	
	

}
