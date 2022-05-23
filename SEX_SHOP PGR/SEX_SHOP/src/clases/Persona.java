package clases;

import java.util.Vector;

/**
 * @author 1dam
 *
 */
public class Persona {

	//ATTRIBUTOS
	private int codUsuario;
	private String email;
	private String nombre;
	private String apellido;
	private String contrasena;
	private String tipo;
	
	private int cont;
	private String num="";
	//CONSTRUCTORES
	/**
	 * @param codUsuario
	 * @param email
	 * @param nombre
	 * @param apellido
	 * @param contrase�a
	 * @param tipo
	 */
	public Persona(int codUsuario, String email, String nombre, String apellido, String contrase�a, String tipo) {
		super();
		this.codUsuario = codUsuario;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasena = contrase�a;
		this.tipo = tipo;
	}
	
	/**
	 * 
	 */
	public Persona() {
		super();
	}

	//GETTERS Y SETTERS
	/**
	 * @return
	 */
	public int getCodUsuario() {
		return codUsuario;
	}

	/**
	 * @param i
	 */
	public void setCodUsuario(int i) {
		this.codUsuario = i;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * @param contrase�a
	 */
	public void setContrasena(String contrase�a) {
		this.contrasena = contrase�a;
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
