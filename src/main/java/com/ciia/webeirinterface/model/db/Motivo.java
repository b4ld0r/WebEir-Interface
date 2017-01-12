package com.ciia.webeirinterface.model.db;

import java.io.Serializable;

public class Motivo implements Serializable{
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idMotivo == null) ? 0 : idMotivo.hashCode());
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
		Motivo other = (Motivo) obj;
		if (idMotivo == null) {
			if (other.idMotivo != null)
				return false;
		} else if (!idMotivo.equals(other.idMotivo))
			return false;
		return true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -197851966975935743L;
	private Integer idMotivo;
	private String descripcion;	
	private Boolean activo;			

	public Integer getIdMotivo() {
		return idMotivo;
	}

	public void setIdMotivo(Integer idMotivo) {
		this.idMotivo = idMotivo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Motivo() {
		// TODO Auto-generated constructor stub
	}

	public Motivo(String descripcion, Boolean activo) {
		super();
		this.descripcion = descripcion;
		this.activo = activo;
	}

	/**
	 * @param idMotivo
	 */
	public Motivo(Integer idMotivo) {
		super();
		this.idMotivo = idMotivo;
	}

	/**
	 * @param idMotivo
	 * @param activo
	 */
	public Motivo(Integer idMotivo, Boolean activo) {
		super();
		this.idMotivo = idMotivo;
		this.activo = activo;
	}
}
