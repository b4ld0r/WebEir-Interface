package com.ciia.webeirinterface.model.catalogos;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


public class Escenario {
	@NotEmpty
	@Size(min = 0, max = 50)
	private String nombre;
	
	@NotEmpty
	@Size(min = 0, max = 20)
	private String inicial;
	
	private List<Motivo> motivos;

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setInicial(String inicial) {
		this.inicial = inicial;
	}

	public String getInicial() {
		return inicial;
	}

	public void setMotivos(List<Motivo> motivos) {
		this.motivos = motivos;
	}

	public List<Motivo> getMotivos() {
		return motivos;
	}

}
