package com.ciia.webeirinterface.model.db;

import java.io.Serializable;
import java.util.List;

public class Solicitud implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2006901465605506039L;
	private Integer idSolicitud;
	private TipoSolicitud tipoSolicitud;		
	private Estatus estatus;		
	private Escenario escenario;		
	private Archivo archivo;
	private Empleado empleado;
	private Operadora operadora;
	private List<Imei> imei;
	private Boolean documentos;			

	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public TipoSolicitud getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

	public Escenario getEscenario() {
		return escenario;
	}

	public void setEscenario(Escenario escenario) {
		this.escenario = escenario;
	}

	public Archivo getArchivo() {
		return archivo;
	}

	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}
	
	public List<Imei> getImei() {
		return imei;
	}

	public void setImei(List<Imei> imei) {
		this.imei = imei;
	}

	public Boolean getDocumentos() {
		return documentos;
	}

	public void setDocumentos(Boolean documentos) {
		this.documentos = documentos;
	}

	public Solicitud() {
		// TODO Auto-generated constructor stub
	}

	public Solicitud(Integer idSolicitud, TipoSolicitud tipoSolicitud,
			Estatus estatus, Escenario escenario, Archivo archivo,
			Empleado empleado, Operadora operadora, Boolean documentos) {
		super();
		this.idSolicitud = idSolicitud;
		this.tipoSolicitud = tipoSolicitud;
		this.estatus = estatus;
		this.escenario = escenario;
		this.archivo = archivo;
		this.empleado = empleado;
		this.operadora = operadora;
		this.documentos = documentos;
	}
}
