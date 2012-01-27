package com.ciia.webeirinterface.model.login;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Login {
	@NotEmpty
	@Size(min = 0, max = 50)
	private String usuario;

	@NotEmpty
	@Size(min = 0, max = 20)
	private String contrasenia;

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getContrasenia() {
		return contrasenia;
	}

}
