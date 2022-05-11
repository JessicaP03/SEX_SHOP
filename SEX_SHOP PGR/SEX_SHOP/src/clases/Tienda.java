package clases;

import java.sql.Date;

public class Tienda {
	
	//ATRIBUTOS
	private String codTienda;
	private int codPostal;
	private String direccion;
	private int telefono;
	private String horario;
	
	//COSNTRUCTORES
	public Tienda(String codTienda, int codPostal, String direccion, int telefono, String horario) {
		super();
		this.codTienda = codTienda;
		this.codPostal = codPostal;
		this.direccion = direccion;
		this.telefono = telefono;
		this.horario = horario;
	}
	
	public Tienda() {
		super();
	}

	//SETTERS Y GETTERS
	public String getCodTienda() {
		return codTienda;
	}

	public void setCodTienda(String codTienda) {
		this.codTienda = codTienda;
	}

	public int getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
}
