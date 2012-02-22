package com.ciia.webeirinterface.model.db;

import java.io.Serializable;

public class PermisoSistema implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7756621902795988119L;
	private Integer idPermisoSistema;
	private String descripcion;	
	private Integer idModuloSistema;
	private Boolean activo;			

	public Integer getIdPermisoSistema() {
		return idPermisoSistema;
	}

	public void setIdPermisoSistema(Integer idPermisoSistema) {
		this.idPermisoSistema = idPermisoSistema;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idModuloSistema == null) ? 0 : idModuloSistema.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermisoSistema other = (PermisoSistema) obj;
		if (idModuloSistema == null) {
			if (other.idModuloSistema != null)
				return false;
		} else if (!idModuloSistema.equals(other.idModuloSistema))
			return false;
		return true;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdModuloSistema() {
		return idModuloSistema;
	}

	public void setIdModuloSistema(Integer idModuloSistema) {
		this.idModuloSistema = idModuloSistema;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public PermisoSistema() {
		// TODO Auto-generated constructor stub
	}

	public PermisoSistema(Integer idPermisoSistema, String descripcion) {
		super();
		this.idPermisoSistema = idPermisoSistema;
		this.descripcion = descripcion;
	}
} 
