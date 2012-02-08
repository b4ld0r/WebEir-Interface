package com.ciia.webeirinterface.model.catalogos;

public class Motivo {
	
	private Integer idMotivo;

	private String descripcion;
	
	private Boolean activo;
	
	public Motivo(){
	}
	
	public Motivo(Integer idMotivo,String descripcion, Boolean activo){
		this.idMotivo = idMotivo;
		this.descripcion = descripcion;
		this.activo = activo;
	}
	
	public Motivo(String descripcion){
		this.descripcion = descripcion;
	}
	
	public void setIdMotivo(Integer idMotivo) {
		this.idMotivo = idMotivo;
	}

	public Integer getIdMotivo() {
		return idMotivo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Boolean getActivo() {
		return activo;
	}
}
