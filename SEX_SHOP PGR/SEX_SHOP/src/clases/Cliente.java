package clases;

import java.util.Vector;

/**
 * @author 1dam
 * @
 */
public class Cliente extends Persona {

	private String direccion;

	// Constructores
	/**
	 * @param codUsuario lo utilizamos como clave primaria
	 * @param email se utiliza para iniciar sesion
	 * @param nombre
	 * @param apellido
	 * @param contraseña se utiliza para iniciar sesion
	 * @param tipo
	 * @param direccion se utiliza para las compras
	 */
	public Cliente(int codUsuario, String email, String nombre, String apellido, String contraseña, String tipo,
			String direccion) {
		super(codUsuario, email, nombre, apellido, contraseña, tipo);
		this.direccion = direccion;
	}

	/**
	 * 
	 */
	public Cliente() {
		super();
	}

	// GETTERS Y SETTERS
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



	


}
