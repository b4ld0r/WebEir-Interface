package com.ciia.webeirinterface.model;

import java.util.List;

public class Menu {
	
	private String nombre;
	private String url;
	private String idTag;
	
	private List<Menu> submenu;
	
	public Menu(String nombre,String url, String idTag){
		this.nombre = nombre;
		this.url = url;
		this.idTag  = idTag;
	}
	
	public Menu(String nombre,List<Menu> submenu){
		this.nombre = nombre;
		this.submenu = submenu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIdTag() {
		return idTag;
	}

	public void setIdTag(String idTag) {
		this.idTag = idTag;
	}

	public List<Menu> getSubmenu() {
		return submenu;
	}

	public void setSubmenu(List<Menu> submenu) {
		this.submenu = submenu;
	}

	
}
