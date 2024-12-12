package model;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cedula")
	private String cedula;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "correo")
	private String correo;

	@Column(name = "celular")
	private String celular;
	
	@Column(name = "automovil")
	private String auto;
	
	@Column(name = "tipo_sangre")
	private String sangre;

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
	}
	
	public String getSangre() {
		return sangre;
	}

	public void setSangre(String sangre) {
		this.sangre = sangre;
	}
	
}
