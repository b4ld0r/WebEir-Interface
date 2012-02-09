package com.ciia.webeirinterface.model.imeis;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ConsultaIMEI {
	@NotEmpty
	@Size(min = 0, max = 12)
	private String imei;
	
	private List<IMEI> listaIMEIS;
	
	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImei() {
		return imei;
	}	

	public void setListaIMEIS(List<IMEI> listaIMEIS) {
		this.listaIMEIS = listaIMEIS;
	}

	public List<IMEI> getListaIMEIS() {
		return listaIMEIS;
	}
	
}
