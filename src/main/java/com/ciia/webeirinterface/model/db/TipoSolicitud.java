package com.ciia.webeirinterface.model.db;

import java.io.Serializable;

public class TipoSolicitud implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1647250360155255754L;
	private Integer idTipoSolicitud;
	private String descripcion;
	
	public Integer getIdTipoSolicitud() {
		return idTipoSolicitud;
	}

	public void setIdTipoSolicitud(Integer idTipoSolicitud) {
		this.idTipoSolicitud = idTipoSolicitud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoSolicitud() {
		// TODO Auto-generated constructor stub
	}

	public TipoSolicitud(Integer idTipoSolicitud, String descripcion) {
		super();
		this.idTipoSolicitud = idTipoSolicitud;
		this.descripcion = descripcion;
	}
}
