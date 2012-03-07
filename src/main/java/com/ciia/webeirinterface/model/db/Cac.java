package com.ciia.webeirinterface.model.db;

import java.io.Serializable;

public class Cac implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7318007896941737235L;
	
	private Integer idCac;
	private String nombre;

	public Cac() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdCac() {
		return idCac;
	}

	public void setIdCac(Integer idCac) {
		this.idCac = idCac;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
 
}
