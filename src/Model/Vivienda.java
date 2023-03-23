package Model;

public class Vivienda {
	
	private int id;
	private String descripcion;
	private int idLocalidad;
	
	/**
	 * 
	 */
	public Vivienda() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param descripcion
	 * @param idLocalidad
	 */
	public Vivienda(int id, String descripcion, int idLocalidad) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.idLocalidad = idLocalidad;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the idLocalidad
	 */
	public int getIdLocalidad() {
		return idLocalidad;
	}

	/**
	 * @param idLocalidad the idLocalidad to set
	 */
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	@Override
	public String toString() {
		return descripcion;
	}
	
	
	

}
