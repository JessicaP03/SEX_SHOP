package clases;

import java.util.Vector;

public class Cliente extends Persona {

	private String direccion;

	// Constructores
	public Cliente(String codUsuario, String email, String nombre, String apellido, String contrase�a, String tipo,
			String direccion) {
		super(codUsuario, email, nombre, apellido, contrase�a, tipo);
		this.direccion = direccion;
	}

	public Cliente() {
		super();
	}

	// GETTERS Y SETTERS
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	


}
