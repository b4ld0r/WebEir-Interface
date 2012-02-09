package com.ciia.webeirinterface.model.db;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Bitacora implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3711653430694447951L;
	private Integer idBitacora;
	private Date fecha;			
	private Time hora;			
	private String campo;			
	private Accion accion;		
	private ModuloSistema moduloSistema;		
	private Usuario usuario;		
	
	public Integer getIdBitacora() {
		return idBitacora;
	}

	public void setIdBitacora(Integer idBitacora) {
		this.idBitacora = idBitacora;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public Accion getAccion() {
		return accion;
	}

	public void setAccion(Accion accion) {
		this.accion = accion;
	}

	public ModuloSistema getModuloSistema() {
		return moduloSistema;
	}

	public void setModuloSistema(ModuloSistema moduloSistema) {
		this.moduloSistema = moduloSistema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Bitacora() {
		// TODO Auto-generated constructor stub
	}

	public Bitacora(Integer idBitacora, Date fecha, Time hora, String campo,
			Accion accion, ModuloSistema moduloSistema, Usuario usuario) {
		super();
		this.idBitacora = idBitacora;
		this.fecha = fecha;
		this.hora = hora;
		this.campo = campo;
		this.accion = accion;
		this.moduloSistema = moduloSistema;
		this.usuario = usuario;
	}
}
