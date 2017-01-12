package com.ciia.webeirinterface.model.db;

import java.io.Serializable;
import java.sql.Date;

public class Operadora implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7720620123820804119L;
	private Integer idOperadora;
	private String nombre;			
	private Date fechaAlta;			
	private Estatus estatus;		
	private String userNameSFTP;			
	private String contraseniaSFTP;			
	private String ipSFTP;			
	private String puertoSFTP;	
	private Date fechaCaducidadSFTP;
	private String nombreResposable;			
	private String apellidoPaternoResposable;			
	private String apellidoMaternoResposable;			
	private String emailResposable;
	private Directorio directorio;
	private Boolean activo;
	
	public Integer getIdOperadora() {
		return idOperadora;
	}

	public void setIdOperadora(Integer idOperadora) {
		this.idOperadora = idOperadora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

	public String getUserNameSFTP() {
		return userNameSFTP;
	}

	public void setUserNameSFTP(String userNameSFTP) {
		this.userNameSFTP = userNameSFTP;
	}

	public String getContraseniaSFTP() {
		return contraseniaSFTP;
	}

	public void setContraseniaSFTP(String contraseniaSFTP) {
		this.contraseniaSFTP = contraseniaSFTP;
	}

	public String getIpSFTP() {
		return ipSFTP;
	}

	public void setIpSFTP(String ipSFTP) {
		this.ipSFTP = ipSFTP;
	}

	public String getPuertoSFTP() {
		return puertoSFTP;
	}

	public void setPuertoSFTP(String puertoSFTP) {
		this.puertoSFTP = puertoSFTP;
	}

	public Date getFechaCaducidadSFTP() {
		return fechaCaducidadSFTP;
	}

	public void setFechaCaducidadSFTP(Date fechaCaducidadSFTP) {
		this.fechaCaducidadSFTP = fechaCaducidadSFTP;
	}

	public String getNombreResposable() {
		return nombreResposable;
	}

	public void setNombreResposable(String nombreResposable) {
		this.nombreResposable = nombreResposable;
	}

	public String getApellidoPaternoResposable() {
		return apellidoPaternoResposable;
	}

	public void setApellidoPaternoResposable(String apellidoPaternoResposable) {
		this.apellidoPaternoResposable = apellidoPaternoResposable;
	}

	public String getApellidoMaternoResposable() {
		return apellidoMaternoResposable;
	}

	public void setApellidoMaternoResposable(String apellidoMaternoResposable) {
		this.apellidoMaternoResposable = apellidoMaternoResposable;
	}

	public String getEmailResposable() {
		return emailResposable;
	}

	public void setEmailResposable(String emailResposable) {
		this.emailResposable = emailResposable;
	}

	public Directorio getDirectorio() {
		return directorio;
	}

	public void setDirectorio(Directorio directorio) {
		this.directorio = directorio;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Operadora() {
		// TODO Auto-generated constructor stub
	}

	public Operadora(Integer idOperadora, String nombre, Date fechaAlta,
			Estatus estatus, String userNameSFTP, String contraseniaSFTP,
			String ipSFTP, String puertoSFTP, String nombreResposable,
			String apellidoPaternoResposable, String apellidoMaternoResposable,
			String emailResposable, Boolean activo) {
		super();
		this.idOperadora = idOperadora;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.estatus = estatus;
		this.userNameSFTP = userNameSFTP;
		this.contraseniaSFTP = contraseniaSFTP;
		this.ipSFTP = ipSFTP;
		this.puertoSFTP = puertoSFTP;
		this.nombreResposable = nombreResposable;
		this.apellidoPaternoResposable = apellidoPaternoResposable;
		this.apellidoMaternoResposable = apellidoMaternoResposable;
		this.emailResposable = emailResposable;
		this.activo = activo;
	}

	/**
	 * @param idOperadora
	 * @param activo
	 */
	public Operadora(Integer idOperadora, Boolean activo) {
		super();
		this.idOperadora = idOperadora;
		this.activo = activo;
	}	
}
