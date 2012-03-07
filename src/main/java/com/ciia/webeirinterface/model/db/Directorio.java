package com.ciia.webeirinterface.model.db;

import java.io.Serializable;
import java.util.List;

public class Directorio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8214024912733259383L;
	private Integer idDirectorio;
	private String nombre;			
	private String ruta;			
	private Nomenclatura nomenclatura;		
	private List<Directorio> subdirectorios;
	private Boolean activo;

	public Integer getIdDirectorio() {
		return idDirectorio;
	}

	public void setIdDirectorio(Integer idDirectorio) {
		this.idDirectorio = idDirectorio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Nomenclatura getNomenclatura() {
		return nomenclatura;
	}

	public void setNomenclatura(Nomenclatura nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	public List<Directorio> getSubdirectorioPadre() {
		return subdirectorios;
	}

	public void setSubdirectorioPadre(List<Directorio> subdirectorios) {
		this.subdirectorios = subdirectorios;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Directorio() {
		// TODO Auto-generated constructor stub
	}

	public Directorio(Integer idDirectorio, String nombre, String ruta,
			Nomenclatura nomenclatura) {
		super();
		this.idDirectorio = idDirectorio;
		this.nombre = nombre;
		this.ruta = ruta;
		this.nomenclatura = nomenclatura;
	}

	/**
	 * @param idDirectorio
	 * @param activo
	 */
	public Directorio(Integer idDirectorio, Boolean activo) {
		super();
		this.idDirectorio = idDirectorio;
		this.activo = activo;
	}
}
