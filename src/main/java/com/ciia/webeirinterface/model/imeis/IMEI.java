package com.ciia.webeirinterface.model.imeis;

public class IMEI {
	
	private Long idIMEI;
	private String ime;
	
	public IMEI(Long idIMEI,String ime){
		this.idIMEI = idIMEI;
		this.ime = ime;
	}
	
	public Long getIdIMEI() {
		return idIMEI;
	}
	public void setIdIMEI(Long idIMEI) {
		this.idIMEI = idIMEI;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
}
