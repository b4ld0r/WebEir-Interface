package com.ciia.webeirinterface.model.db;

import java.io.Serializable;

public class Documento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5155560728663019597L;
	private Integer idDocumento;
	private String descripcion;			
	private Boolean obligatorio;			
	private Boolean activo;			
	
	public Integer getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getObligatorio() {
		return obligatorio;
	}

	public void setObligatorio(Boolean obligatorio) {
		this.obligatorio = obligatorio;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Documento() {
		// TODO Auto-generated constructor stub
	}

	public Documento(Integer idDocumento, String descripcion,
			Boolean obligatorio) {
		super();
		this.idDocumento = idDocumento;
		this.descripcion = descripcion;
		this.obligatorio = obligatorio;
	}
}
