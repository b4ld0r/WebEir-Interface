package com.ciia.webeirinterface.model.db;

import java.io.Serializable;
import java.util.List;

public class ModuloSistema implements Serializable {
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
		ModuloSistema other = (ModuloSistema) obj;
		if (idModuloSistema == null) {
			if (other.idModuloSistema != null)
				return false;
		} else if (!idModuloSistema.equals(other.idModuloSistema))
			return false;
		return true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3979754518464212103L;
	private Integer idModuloSistema;
	private String descripcion;
	private Boolean activo;		
	private List<PermisoSistema> permisoSistema;

	public ModuloSistema() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdModuloSistema() {
		return idModuloSistema;
	}

	public void setIdModuloSistema(Integer idModuloSistema) {
		this.idModuloSistema = idModuloSistema;
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

	public ModuloSistema(Integer idModuloSistema, String descripcion) {
		super();
		this.idModuloSistema = idModuloSistema;
		this.descripcion = descripcion;
	}
	
	/**
	 * @param idModuloSistema
	 */
	public ModuloSistema(Integer idModuloSistema) {
		super();
		this.idModuloSistema = idModuloSistema;
	}

	/**
	 * @param idModuloSistema
	 * @param activo
	 */
	public ModuloSistema(Integer idModuloSistema, Boolean activo) {
		super();
		this.idModuloSistema = idModuloSistema;
		this.activo = activo;
	}
}
