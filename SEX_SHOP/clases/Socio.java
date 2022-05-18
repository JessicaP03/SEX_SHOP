package clases;

public class Socio extends Cliente {

	//ATRIBUTOS
	private int oferta;
	private int puntos;
	
	//CONSTRUCTORES
	public Socio(int codUsuario, String email, String nombre, String apellido, String contraseña, String tipo,
			String direccion, int oferta, int puntos) {
		super(codUsuario, email, nombre, apellido, contraseña, tipo, direccion);
		this.oferta = oferta;
		this.puntos = puntos;
	}
	
	public Socio() {
		super();
	}

	//GETTERS Y SETTERS
	public int getOferta() {
		return oferta;
	}

	public void setOferta(int oferta) {
		this.oferta = oferta;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}	
}
