package com.ciia.webeirinterface.dao;

import java.util.*;

import com.ciia.webeirinterface.model.db.PerfilSistema;
import com.ciia.webeirinterface.model.db.PermisoSistema;
import com.ciia.webeirinterface.mybatis.AccesoIbatis;

public class PermisoSistemaDAO {
	private static final String PERMISO_USUARIO = "PermisoSistema.permisoPerfil";
	private static final String LISTA_PERMISO_SF = "PermisoSistema.getListaPermisoSistemaSF"; 
	private static final String PERMISO_HIJO = "PermisoSistema.permisoPerfilHijo";
	
	public PermisoSistemaDAO() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<PermisoSistema> consultarPermisoSistema() throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			return (List<PermisoSistema>)ibatis.getSqlSession().selectList(LISTA_PERMISO_SF);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al obtener lista de permisos del sistema. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<PermisoSistema> permisosUsuario(PerfilSistema perfilSistema) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			//Recuperar permisos padre
			List<PermisoSistema> listaPermisos = ((List<PermisoSistema>)ibatis.getSqlSession().selectList(PERMISO_USUARIO, perfilSistema));
			
			//Recuperar permisos hijo
			for (int i = 0; i < listaPermisos.size(); i++) {
				List<PermisoSistema> permisoHijo = ((List<PermisoSistema>)ibatis.getSqlSession().selectList(PERMISO_HIJO, listaPermisos.get(i)));

				if (permisoHijo != null && !permisoHijo.isEmpty()){
					listaPermisos.get(i).setPermisoSistema(permisoHijo);
				}
			}
			
			return listaPermisos;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al obtener el perfil del usuarios. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
}
