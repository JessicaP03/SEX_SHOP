package clases;

import java.sql.Date;
import java.time.LocalDate;

public class Empleado extends Persona {

	//ATRIBUTOS
	private String puesto;
	private Date horario;
	private boolean administrador;
	
	//CONSTRUCTORES
	public Empleado(int codUsuario, String email, String nombre, String apellido, String contraseña, String tipo,
			String puesto, Date horario, boolean administrador) {
		super(codUsuario, email, nombre, apellido, contraseña, tipo);
		this.puesto = puesto;
		this.horario = horario;
		this.administrador = administrador;
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

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	
	
	
}
