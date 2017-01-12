package com.ciia.webeirinterface.model.db;

import java.io.Serializable;
import java.util.List;

public class PermisoSistema implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7756621902795988119L;
	private Integer idPermisoSistema;
	private String descripcion;	
	private Integer orden;
	private String url;
	private String tituloPagina;
	private List<PermisoSistema> permisoSistema;
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

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTituloPagina() {
		return tituloPagina;
	}

	public void setTituloPagina(String tituloPagina) {
		this.tituloPagina = tituloPagina;
	}

	public List<PermisoSistema> getPermisoSistema() {
		return permisoSistema;
	}

	public void setPermisoSistema(List<PermisoSistema> permisoSistema) {
		this.permisoSistema = permisoSistema;
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

	/**
	 * @param idPermisoSistema
	 * @param activo
	 */
	public PermisoSistema(Integer idPermisoSistema, Boolean activo) {
		super();
		this.idPermisoSistema = idPermisoSistema;
		this.activo = activo;
	}
} 
