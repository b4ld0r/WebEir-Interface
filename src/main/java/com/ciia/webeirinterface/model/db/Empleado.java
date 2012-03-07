package com.ciia.webeirinterface.model.db;

import java.io.Serializable;

public class Empleado implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4334242746095835670L;
	private Integer idEmpleadoFE;
	private String empleadoFE;
	private String noSolicitud;
	private String noSolicitudFE;
	private String nombreEmpleado;
	private String apellidoPaternoEmpleado;
	private String apellidoMaternoEmpleado;
	private String emailEmpleado;
	private Cac cac;
	
	public Integer getIdEmpleadoFE() {
		return idEmpleadoFE;
	}

	public void setIdEmpleadoFE(Integer idEmpleadoFE) {
		this.idEmpleadoFE = idEmpleadoFE;
	}

	public String getEmpleadoFE() {
		return empleadoFE;
	}

	public void setEmpleadoFE(String empleadoFE) {
		this.empleadoFE = empleadoFE;
	}

	public String getNoSolicitud() {
		return noSolicitud;
	}

	public void setNoSolicitud(String noSolicitud) {
		this.noSolicitud = noSolicitud;
	}

	public String getNoSolicitudFE() {
		return noSolicitudFE;
	}

	public void setNoSolicitudFE(String noSolicitudFE) {
		this.noSolicitudFE = noSolicitudFE;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getApellidoPaternoEmpleado() {
		return apellidoPaternoEmpleado;
	}

	public void setApellidoPaternoEmpleado(String apellidoPaternoEmpleado) {
		this.apellidoPaternoEmpleado = apellidoPaternoEmpleado;
	}

	public String getApellidoMaternoEmpleado() {
		return apellidoMaternoEmpleado;
	}

	public void setApellidoMaternoEmpleado(String apellidoMaternoEmpleado) {
		this.apellidoMaternoEmpleado = apellidoMaternoEmpleado;
	}

	public String getEmailEmpleado() {
		return emailEmpleado;
	}

	public void setEmailEmpleado(String emailEmpleado) {
		this.emailEmpleado = emailEmpleado;
	}

	public Cac getCac() {
		return cac;
	}

	public void setCac(Cac cac) {
		this.cac = cac;
	}

	public String getNombreCompletoEmpleado(){
		return this.nombreEmpleado + " " + this.apellidoPaternoEmpleado + " "  + this.apellidoMaternoEmpleado;
	}
	
	public Empleado(Integer idEmpleadoFE, String empleadoFE,
			String nombreEmpleado, String apellidoPaternoEmpleado,
			String apellidoMaternoEmpleado, String emailEmpleado) {
		super();
		this.idEmpleadoFE = idEmpleadoFE;
		this.empleadoFE = empleadoFE;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidoPaternoEmpleado = apellidoPaternoEmpleado;
		this.apellidoMaternoEmpleado = apellidoMaternoEmpleado;
		this.emailEmpleado = emailEmpleado;
	}
	
	public Empleado(Integer idEmpleadoFE) {
		super();
		this.idEmpleadoFE = idEmpleadoFE;
	}
	
	public Empleado(Integer idEmpleadoFE, String empleadoFE) {
		super();
		this.idEmpleadoFE = idEmpleadoFE;
		this.empleadoFE = empleadoFE;
	}

	public Empleado() {
		// TODO Auto-generated constructor stub
	}
}
