package clases;

import java.sql.Date;

/**
 * @author 1dam
 *
 */
public class Tienda {
	
	//ATRIBUTOS
	private String codTienda;
	private int codPostal;
	private String direccion;
	private int telefono;
	private String horario;
	
	//COSNTRUCTORES
	/**
	 * @param codTienda
	 * @param codPostal
	 * @param direccion
	 * @param telefono
	 * @param horario
	 */
	public Tienda(String codTienda, int codPostal, String direccion, int telefono, String horario) {
		super();
		this.codTienda = codTienda;
		this.codPostal = codPostal;
		this.direccion = direccion;
		this.telefono = telefono;
		this.horario = horario;
	}
	
	/**
	 * 
	 */
	public Tienda() {
		super();
	}

	//SETTERS Y GETTERS
	/**
	 * @return
	 */
	public String getCodTienda() {
		return codTienda;
	}

	/**
	 * @param codTienda
	 */
	public void setCodTienda(String codTienda) {
		this.codTienda = codTienda;
	}

	/**
	 * @return
	 */
	public int getCodPostal() {
		return codPostal;
	}

	/**
	 * @param codPostal
	 */
	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	/**
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return
	 */
	public String getHorario() {
		return horario;
	}

	/**
	 * @param horario
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}
}
