package clases;

public class Socio extends Cliente {

	//ATRIBUTOS
	private int oferta;
	private int puntos;
	
	//CONSTRUCTORES
	/**
	 * @param codUsuario
	 * @param email
	 * @param nombre
	 * @param apellido
	 * @param contraseña
	 * @param tipo
	 * @param direccion
	 * @param oferta
	 * @param puntos
	 */
	public Socio(int codUsuario, String email, String nombre, String apellido, String contraseña, String tipo,
			String direccion, int oferta, int puntos) {
		super(codUsuario, email, nombre, apellido, contraseña, tipo, direccion);
		this.oferta = oferta;
		this.puntos = puntos;
	}
	
	/**
	 * 
	 */
	public Socio() {
		super();
	}

	//GETTERS Y SETTERS
	/**
	 * @return
	 */
	public int getOferta() {
		return oferta;
	}

	/**
	 * @param oferta
	 */
	public void setOferta(int oferta) {
		this.oferta = oferta;
	}

	/**
	 * @return
	 */
	public int getPuntos() {
		return puntos;
	}

	/**
	 * @param puntos
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}	
}
