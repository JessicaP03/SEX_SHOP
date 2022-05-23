package clases;

import java.sql.Date;
import java.time.LocalDate;

/**
 * @author 1dam
 *
 */
public class Compra {
	private Date fecha_compra;
	private String idproducto;
	private int codusuario;

	/**
	 * @param fecha_compra guardamos la fecha de compra del producto
	 * @param idproducto lo utilizamos como clave primaria de producto
	 * @param codusuario lo utilizamos como clave primaria de usuario
	 */
	public Compra(Date fecha_compra, String idproducto, int codusuario) {
		super();
		this.fecha_compra = fecha_compra;
		this.idproducto = idproducto;
		this.codusuario = codusuario;
	}

	/**
	 * 
	 */
	public Compra() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return
	 */
	public Date getFecha_compra() {
		return fecha_compra;
	}

	/**
	 * @param fecha_compra
	 */
	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	/**
	 * @return
	 */
	public String getIdproducto() {
		return idproducto;
	}

	/**
	 * @param idproducto
	 */
	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	/**
	 * @return
	 */
	public int getCodusuario() {
		return codusuario;
	}

	/**
	 * @param codusuario
	 */
	public void setCodusuario(int codusuario) {
		this.codusuario = codusuario;
	}

}
