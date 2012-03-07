/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciia.webeirinterface.model;

import com.ciia.webeirinterface.model.db.PermisoSistema;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class PermisosPerfil {
	private int idPerfil;
	private List<PermisoSistema> permisosSistema;

	public PermisosPerfil(){}
	
	public PermisosPerfil(int idPerfil, List<PermisoSistema> permisoSistemas) {
		this.idPerfil = idPerfil;
		this.permisosSistema = permisoSistemas;
	}
	
	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public List<PermisoSistema> getPermisosSistema() {
		return permisosSistema;
	}
	
	public void setPermisosSistema(String [] ids) {
		List<PermisoSistema> permisos=new ArrayList<PermisoSistema>(ids.length);
		for(String id:ids){
			System.out.println(id);
			permisos.add(new PermisoSistema(new Integer(id), Boolean.TRUE));
		}
		permisosSistema=permisos;
	}
}
