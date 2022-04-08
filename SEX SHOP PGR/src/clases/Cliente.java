package clases;

public class Cliente extends Persona {

	 private String direccion;

	 //Constructores
	public Cliente(String codUsuario, String email, String nombre, String apellido, String contraseņa, String tipo,
			String direccion) {
		super(codUsuario, email, nombre, apellido, contraseņa, tipo);
		this.direccion = direccion;
	}
	
	public Cliente() {
		super();
	}

	//GETTERS Y SETTERS
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	 
	
	
}
