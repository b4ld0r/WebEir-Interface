package com.ciia.webeirinterface.dao;

import java.util.*;

import com.ciia.webeirinterface.model.db.PerfilSistema;
import com.ciia.webeirinterface.model.db.PermisoSistema;
import com.ciia.webeirinterface.mybatis.AccesoIbatis;

public class PermisoSistemaDAO {
	private static final String PERMISO_USUARIO = "PermisoSistema.permisoPerfil";
	
	public PermisoSistemaDAO() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<PermisoSistema> permisosUsuario(PerfilSistema perfilSistema) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			return ((List<PermisoSistema>)ibatis.getSqlSession().selectList(PERMISO_USUARIO, perfilSistema));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al obtener el perfil del usuarios. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
}
