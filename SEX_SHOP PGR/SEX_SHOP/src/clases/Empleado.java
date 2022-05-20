package clases;

import java.sql.Date;
import java.time.LocalDate;

/**
 * @author 1dam
 *
 */
public class Empleado extends Persona {

	//ATRIBUTOS
	private String puesto;
	private String horario;
	private String administrador;
	private int codJefe;
	
	//CONSTRUCTORES
	
	/**
	 * @param codUsuario lo utilizamos como clave primaria del producto
	 * @param email lo utilizamos como inicio de sesion 
	 * @param nombre
	 * @param apellido
	 * @param contraseña lo utilizamos como inicio de sesion 
	 * @param tipo
	 * @param puesto
	 * @param horario
	 * @param administrador
	 * @param codJefe lo utilizamos como clave foranena de la misma tabla 
	 */
	public Empleado(int codUsuario, String email, String nombre, String apellido, String contraseña, String tipo,
			String puesto, String horario, String administrador, int codJefe) {
		super(codUsuario, email, nombre, apellido, contraseña, tipo);
		this.puesto = puesto;
		this.horario = horario;
		this.administrador = administrador;
		this.codJefe = codJefe;
	}


	/**
	 * 
	 */
	public Empleado() {
		super();
	}

	//GETTERS Y SETTER
	/**
	 * @return
	 */
	public String getPuesto() {
		return puesto;
	}

	/**
	 * @param puesto
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	/**
	 * @return
	 */
	public String getHorario() {
		return horario;
	}

	/**
	 * @param string
	 */
	public void setHorario(String string) {
		this.horario = string;
	}

	/**
	 * @return
	 */
	public String getAdministrador() {
		return administrador;
	}

	/**
	 * @param string
	 */
	public void setAdministrador(String string) {
		this.administrador = string;
	}

	/**
	 * @return
	 */
	public int getCodJefe() {
		return codJefe;
	}

	/**
	 * @param codJefe
	 */
	public void setCodJefe(int codJefe) {
		this.codJefe = codJefe;
	}
	
	
	
}
