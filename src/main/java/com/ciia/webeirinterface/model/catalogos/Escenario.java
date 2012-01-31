package com.ciia.webeirinterface.model.catalogos;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;


public class Escenario {
	@NotEmpty
	@Size(min = 0, max = 50)
	private String nombre;
	
	@NotEmpty
	@Size(min = 0, max = 20)
	private String inicial;
	
	private List<Motivo> motivos;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getInicial() {
		return inicial;
	}

	public void setInicial(String inicial) {
		this.inicial = inicial;
	}

	public List<Motivo> getMotivos() {
		return motivos;
	}

	public void setMotivos(List<Motivo> motivos) {
		this.motivos = motivos;
	}

}
