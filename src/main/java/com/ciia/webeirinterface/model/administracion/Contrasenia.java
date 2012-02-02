package com.ciia.webeirinterface.model.administracion;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


public class Contrasenia {
	@NotEmpty
	@Size(min = 0, max = 50)
	private String actual;
	
	@NotEmpty
	@Size(min = 0, max = 20)
	private String nueva;

	@NotEmpty
	@Size(min = 0, max = 20)
	private String confirmacionNueva;

	public void setActual(String actual) {
		this.actual = actual;
	}

	public String getActual() {
		return actual;
	}

	public void setNueva(String nueva) {
		this.nueva = nueva;
	}

	public String getNueva() {
		return nueva;
	}

	public void setConfirmacionNueva(String confirmacionNueva) {
		this.confirmacionNueva = confirmacionNueva;
	}

	public String getConfirmacionNueva() {
		return confirmacionNueva;
	}
}
