package clases;

public class Proveedor {
	//ATRIBUTOS
	private String codProveedor;
	private String sector;
	
	//CONSTRUCTORES
	public Proveedor(String codProveedor, String sector) {
		super();
		this.codProveedor = codProveedor;
		this.sector = sector;
	}
	
	public Proveedor() {
		super();
	}

	//GETTERS Y SETTERS
	public String getCodProveedor() {
		return codProveedor;
	}

	public void setCodProveedor(String codProveedor) {
		this.codProveedor = codProveedor;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
	
	
	

}
