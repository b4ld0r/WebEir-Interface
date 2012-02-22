package com.ciia.webeirinterface.model.db;

import java.io.Serializable;
import java.util.List;

public class Escenario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1193862388572626415L;
	private Integer idEscenario;
	private String descripcion;			
	private String inicial;
	private List<Motivo> motivo;
	private Boolean activo;			

	public Integer getIdEscenario() {
		return idEscenario;
	}

	public void setIdEscenario(Integer idEscenario) {
		this.idEscenario = idEscenario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getInicial() {
		return inicial;
	}

	public void setInicial(String inicial) {
		this.inicial = inicial;
	}
	
	public List<Motivo> getMotivo() {
		return motivo;
	}

	public void setMotivo(List<Motivo> motivo) {
		this.motivo = motivo;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Escenario() {
		// TODO Auto-generated constructor stub
	}

	public Escenario(String descripcion, String inicial, Boolean activo) {
		super();
		this.descripcion = descripcion;
		this.inicial = inicial;
		this.activo = activo;
	}

	/**
	 * @param idEscenario
	 */
	public Escenario(Integer idEscenario) {
		super();
		this.idEscenario = idEscenario;
	}
}
