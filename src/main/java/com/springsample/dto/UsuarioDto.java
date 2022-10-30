/**
 * 
 */
package com.springsample.dto;

/**
 * @author brayg
 *
 */
public class UsuarioDto {
	private long id;
	private String nombre;
	private String apellido;
	private String username;
	private String password;
	private int disney;
	private int hboMax;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the disney
	 */
	public int getDisney() {
		return disney;
	}
	/**
	 * @param disney the disney to set
	 */
	public void setDisney(int disney) {
		this.disney = disney;
	}
	/**
	 * @return the hboMax
	 */
	public int getHboMax() {
		return hboMax;
	}
	/**
	 * @param hboMax the hboMax to set
	 */
	public void setHboMax(int hboMax) {
		this.hboMax = hboMax;
	}

	
	
}
