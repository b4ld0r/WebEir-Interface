package com.ciia.webeirinterface.model.login;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;


public class Login {
	@NotEmpty
	@Size(min = 0, max = 50)
	private String usuario;
	
	@NotEmpty
	@Size(min = 0, max = 20)
	private String contrasenia;
	
	private List<Permiso> permisos;
	
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

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

	public List<Permiso> getPermisos() {
		return permisos;
	}

}
