package com.ciia.webeirinterface.model;

import java.util.List;

public class Menu {
	
	private String nombre;
	private String url;
	
	private List<Menu> submenu;
	
	public Menu(String nombre,String url){
		this.nombre = nombre;
		this.url = url;
	}
	
	public Menu(String nombre,List<Menu> submenu){
		this.nombre = nombre;
		this.setSubmenu(submenu);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setSubmenu(List<Menu> submenu) {
		this.submenu = submenu;
	}

	public List<Menu> getSubmenu() {
		return submenu;
	}
	
}
