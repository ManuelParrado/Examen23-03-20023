package Model;

import java.sql.Date;

public class Inquilino {

	private int id;
	private String dni;
	private String nombreCompleto;
	private java.util.Date fechaIncioAlquiler;
	private java.util.Date fechaFinAlquiler;
	private Float coutaMensual;
	private int idVivienda;

	/**
	 * 
	 */
	public Inquilino() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param dni
	 * @param nombreCompleto
	 * @param fechaIncioAlquiler
	 * @param fechaFinAlquiler
	 * @param coutaMensual
	 * @param idVivienda
	 */
	public Inquilino(int id, String dni, String nombreCompleto, Date fechaIncioAlquiler, Date fechaFinAlquiler,
			Float coutaMensual, int idVivienda) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.fechaIncioAlquiler = fechaIncioAlquiler;
		this.fechaFinAlquiler = fechaFinAlquiler;
		this.coutaMensual = coutaMensual;
		this.idVivienda = idVivienda;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * @return the fechaIncioAlquiler
	 */
	public java.util.Date getFechaIncioAlquiler() {
		return fechaIncioAlquiler;
	}

	/**
	 * @param fechaIncioAlquiler the fechaIncioAlquiler to set
	 */
	public void setFechaIncioAlquiler(java.util.Date fechaIncioAlquiler) {
		this.fechaIncioAlquiler = fechaIncioAlquiler;
	}

	/**
	 * @return the fechaFinAlquiler
	 */
	public java.util.Date getFechaFinAlquiler() {
		return fechaFinAlquiler;
	}

	/**
	 * @param fechaFinAlquiler the fechaFinAlquiler to set
	 */
	public void setFechaFinAlquiler(java.util.Date fechaFinAlquiler) {
		this.fechaFinAlquiler = fechaFinAlquiler;
	}

	/**
	 * @return the coutaMensual
	 */
	public Float getCoutaMensual() {
		return coutaMensual;
	}

	/**
	 * @param coutaMensual the coutaMensual to set
	 */
	public void setCoutaMensual(Float coutaMensual) {
		this.coutaMensual = coutaMensual;
	}

	/**
	 * @return the idVivienda
	 */
	public int getIdVivienda() {
		return idVivienda;
	}

	/**
	 * @param idVivienda the idVivienda to set
	 */
	public void setIdVivienda(int idVivienda) {
		this.idVivienda = idVivienda;
	}

	@Override
	public String toString() {
		return "Inquilino [id=" + id + ", dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", fechaIncioAlquiler="
				+ fechaIncioAlquiler + ", fechaFinAlquiler=" + fechaFinAlquiler + ", coutaMensual=" + coutaMensual
				+ ", idVivienda=" + idVivienda + "]";
	}

}
