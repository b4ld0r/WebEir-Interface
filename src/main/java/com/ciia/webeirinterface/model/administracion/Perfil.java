package com.ciia.webeirinterface.model.administracion;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Perfil {
	private Integer idPerfil;
	
	@NotEmpty
	@Size(min = 0, max = 50)
	private String descripcion;

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	public Integer getIdPerfil() {
		return idPerfil;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
}
