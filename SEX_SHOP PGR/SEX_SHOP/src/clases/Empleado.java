package clases;

import java.sql.Date;
import java.time.LocalDate;

public class Empleado extends Persona {

	//ATRIBUTOS
	private String puesto;
	private String horario;
	private String administrador;
	private int codJefe;
	
	//CONSTRUCTORES
	
	public Empleado(int codUsuario, String email, String nombre, String apellido, String contraseña, String tipo,
			String puesto, String horario, String administrador, int codJefe) {
		super(codUsuario, email, nombre, apellido, contraseña, tipo);
		this.puesto = puesto;
		this.horario = horario;
		this.administrador = administrador;
		this.codJefe = codJefe;
	}


	public Empleado() {
		super();
	}

	//GETTERS Y SETTER
	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String string) {
		this.horario = string;
	}

	public String getAdministrador() {
		return administrador;
	}

	public void setAdministrador(String string) {
		this.administrador = string;
	}

	public int getCodJefe() {
		return codJefe;
	}

	public void setCodJefe(int codJefe) {
		this.codJefe = codJefe;
	}
	
	
	
}
