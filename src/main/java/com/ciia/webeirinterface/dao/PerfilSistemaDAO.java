package com.ciia.webeirinterface.dao;

import java.util.ArrayList;
import java.util.List;

import com.ciia.webeirinterface.model.db.PerfilSistema;
import com.ciia.webeirinterface.model.db.Usuario;
import com.ciia.webeirinterface.mybatis.AccesoIbatis;

public class PerfilSistemaDAO {
	private static final String PERFIL_USUARIO = "PerfilSistema.perfilUsuario";
	
	public PerfilSistemaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public PerfilSistema perfilUsuario(Usuario usuario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			PerfilSistema perfilSistema = new PerfilSistema(); 
			perfilSistema = (PerfilSistema)ibatis.getSqlSession().selectOne(PERFIL_USUARIO, usuario);
			
			PermisoSistemaDAO permisoPerfil = new PermisoSistemaDAO();
			
			perfilSistema.setPermisoSistema(permisoPerfil.permisosUsuario(perfilSistema));

			return perfilSistema;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al obtener el perfil del usuarios. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
}
