package com.ciia.webeirinterface.model.db;

import java.io.Serializable;

public class TipoLista implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8854112654087969005L;
	private Integer idTipoLista;
	private String descripcion;			

	public Integer getIdTipoLista() {
		return idTipoLista;
	}

	public void setIdTipoLista(Integer idTipoLista) {
		this.idTipoLista = idTipoLista;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoLista() {
		// TODO Auto-generated constructor stub
	}

	public TipoLista(Integer idTipoLista, String descripcion) {
		super();
		this.idTipoLista = idTipoLista;
		this.descripcion = descripcion;
	}
}
