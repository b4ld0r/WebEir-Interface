package com.ciia.webeirinterface.model.db;

import java.io.Serializable;

public class Nomenclatura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2695208604205981614L;
	private Integer idNomenclatura;
	private String descripcion;			
	private String extension;			
	private String definicion;			
	private Boolean activo;			

	public Integer getIdNomenclatura() {
		return idNomenclatura;
	}

	public void setIdNomenclatura(Integer idNomenclatura) {
		this.idNomenclatura = idNomenclatura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getDefinicion() {
		return definicion;
	}

	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Nomenclatura() {
		// TODO Auto-generated constructor stub
	}

	public Nomenclatura(Integer idNomenclatura, String descripcion,
			String extension, String definicion) {
		super();
		this.idNomenclatura = idNomenclatura;
		this.descripcion = descripcion;
		this.extension = extension;
		this.definicion = definicion;
	}

	/**
	 * @param idNomenclatura
	 * @param activo
	 */
	public Nomenclatura(Integer idNomenclatura, Boolean activo) {
		super();
		this.idNomenclatura = idNomenclatura;
		this.activo = activo;
	}
}
