package com.ciia.webeirinterface.model.db;

import java.io.Serializable;
import java.util.List;

public class PerfilSistema implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2908007777397479947L;
	private Integer idPerfilSistema;
	private String descripcion;
	private List<PermisoSistema> permisoSistema;
	private Boolean activo;			

	public PerfilSistema() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdPerfilSistema() {
		return idPerfilSistema;
	}

	public void setIdPerfilSistema(Integer idPerfilSistema) {
		this.idPerfilSistema = idPerfilSistema;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<PermisoSistema> getPermisoSistema() {
		return permisoSistema;
	}

	public void setPermisoSistema(List<PermisoSistema> permisoSistema) {
		this.permisoSistema = permisoSistema;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public PerfilSistema(Integer idPerfilSistema, String descripcion) {
		super();
		this.idPerfilSistema = idPerfilSistema;
		this.descripcion = descripcion;
	}
}
