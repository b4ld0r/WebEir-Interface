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
	private List<ModuloSistema> moduloSistema;
	private Boolean activo;			

	public PerfilSistema() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param descripcion
	 * @param activo
	 */
	public PerfilSistema(String descripcion, Boolean activo) {
		super();
		this.descripcion = descripcion;
		this.activo = activo;
	}
	
	
	/**
	 * @param idPermiso
	 * @param activo
	 */
	public PerfilSistema(Integer idPerfilSistema, Boolean activo) {
		super();
		this.idPerfilSistema = idPerfilSistema;
		this.activo = activo;
	}

	/**
	 * @param idPerfilSistema
	 */
	public PerfilSistema(Integer idPerfilSistema) {
		super();
		this.idPerfilSistema = idPerfilSistema;
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
	
	public List<ModuloSistema> getModuloSistema() {
		return moduloSistema;
	}

	public void setModuloSistema(List<ModuloSistema> moduloSistema) {
		this.moduloSistema = moduloSistema;
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
