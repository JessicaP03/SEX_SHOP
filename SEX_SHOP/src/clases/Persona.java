package clases;

import java.util.ArrayList;

public class Persona {

	//ATTRIBUTOS
	private String codUsuario;
	private String email;
	protected static String nombre;
	private String apellido;
	private String contrasena;
	private String tipo;
	
	//CONSTRUCTORES
	public Persona(String codUsuario, String email, String nombre, String apellido, String contraseña, String tipo) {
		super();
		this.codUsuario = codUsuario;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasena = contraseña;
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contraseña) {
		this.contrasena = contraseña;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	//GETDATOS
	
	//SETDATOS
	
	public static int verificarPersona(String persona) {

		ArrayList lista = mostrarPersona();
		Persona obj;
		for (int i = 0; i < lista.size(); i++) {
			obj = (Persona) lista.get(i);

			if (obj.getNombre().equalsIgnoreCase(persona)) {
				return i;
			}

		}
		return -1;
	}
	
	// Metodo para mostrar clientes
	public static ArrayList mostrarPersona() {
		// Devuelve el listado de clientes
		return Persona.mostrarPersona();

	}
	
	public static int verificarInicio(String persona, String contrasena) {
		ArrayList lista= mostrarPersona();
		Persona obj;
		for (int i=0;i<lista.size();i++) {
		obj= (Persona)lista.get(i);
		if (obj.getNombre().equalsIgnoreCase(nombre)&&obj.getContrasena().equalsIgnoreCase(contrasena)) {
			return i;
		}
		
		
		}
		
		return -1;
		
	}
}
