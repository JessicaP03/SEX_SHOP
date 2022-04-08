package clases;

public class Persona {

	//ATTRIBUTOS
	private String codUsuario;
	private String email;
	private String nombre;
	private String apellido;
	private String contraseña;
	private String tipo;
	
	//CONSTRUCTORES
	public Persona(String codUsuario, String email, String nombre, String apellido, String contraseña, String tipo) {
		super();
		this.codUsuario = codUsuario;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.tipo = tipo;
	}
	
	public Persona() {
		super();
	}

	//GETTERS Y SETTERS
	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	//GETDATOS
	
	//SETDATOS
	
	
}
