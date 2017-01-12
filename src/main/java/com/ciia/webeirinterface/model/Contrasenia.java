package com.ciia.webeirinterface.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Contrasenia {
	@NotEmpty
	private String contraseniaActual;
	
	@NotEmpty
	private String contraseniaNueva;
	
	@NotEmpty
	private String confirmaContraseniaNueva;
	
	public String getContraseniaActual() {
		return contraseniaActual;
	}
	public void setContraseniaActual(String contraseniaActual) {
		this.contraseniaActual = contraseniaActual;
	}
	public String getContraseniaNueva() {
		return contraseniaNueva;
	}
	public void setContraseniaNueva(String contraseniaNueva) {
		this.contraseniaNueva = contraseniaNueva;
	}
	public void setConfirmaContraseniaNueva(String confirmaContraseniaNueva) {
		this.confirmaContraseniaNueva = confirmaContraseniaNueva;
	}
	public String getConfirmaContraseniaNueva() {
		return confirmaContraseniaNueva;
	}
	
	
}
