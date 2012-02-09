package com.ciia.webeirinterface.dao;

import java.util.List;

import com.ciia.webeirinterface.model.db.Directorio;
import com.ciia.webeirinterface.model.db.Usuario;
import com.ciia.webeirinterface.mybatis.AccesoIbatis;

public class DirectorioDAO {
	private static final String DIRECTORIO_USUARIO = "Directorio.directorioPadreUsuario";
	private static final String SUBDIRECTORIOS = "Directorio.subdirectorioUsuario";
	
	public DirectorioDAO() {
		// TODO Auto-generated constructor stub
	}

	public Directorio directorioPadreUsuario(Usuario usuario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Directorio directorioFinal = (Directorio)ibatis.getSqlSession().selectOne(DIRECTORIO_USUARIO, usuario);
			directorioFinal.setSubdirectorioPadre((List<Directorio>)ibatis.getSqlSession().selectList(SUBDIRECTORIOS, directorioFinal));
			
			return directorioFinal;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error al obtener el directorio del usuario. - " + e.getMessage());
		}
		finally {
			ibatis.cerrarSession();
		}
	}
}
