package com.ciia.webeirinterface.model.db;

import java.io.Serializable;
import java.sql.Date;

public class Imei implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4188920539150173779L;
	private Integer idImei;
	private String imei;			
	private TipoLista tipoLista;		
	private Date fechaRegistro;			
	private Date fechaModificacion;
	private String concepto;
	private String operadora;

	public Integer getIdImei() {
		return idImei;
	}

	public void setIdImei(Integer idImei) {
		this.idImei = idImei;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public TipoLista getTipoLista() {
		return tipoLista;
	}

	public void setTipoLista(TipoLista tipoLista) {
		this.tipoLista = tipoLista;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public Imei() {
		// TODO Auto-generated constructor stub
	}

	public Imei(Integer idImei, String imei, TipoLista tipoLista,
			Date fechaRegistro, Date fechaModificacion) {
		super();
		this.idImei = idImei;
		this.imei = imei;
		this.tipoLista = tipoLista;
		this.fechaRegistro = fechaRegistro;
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * Constructor para agilizar busqueda por Imei
	 * @param imei
	 */
	public Imei(String imei) {
		super();
		this.imei = imei;
	}
}
