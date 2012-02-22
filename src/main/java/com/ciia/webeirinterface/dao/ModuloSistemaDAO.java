package com.ciia.webeirinterface.dao;

import java.util.ArrayList;
import java.util.List;

import com.ciia.webeirinterface.model.db.ModuloSistema;
import com.ciia.webeirinterface.model.db.PermisoSistema;
import com.ciia.webeirinterface.mybatis.AccesoIbatis;

public class ModuloSistemaDAO {
	private static final String MODULO_PORID = "ModuloSistema.getModuloSistema";
	
	public ModuloSistemaDAO() {
		// TODO Auto-generated constructor stub
	}

	public List<ModuloSistema> ordenarPermisosUsuario(List<PermisoSistema> permisos) throws Exception {		
		List<ModuloSistema> modulosOrdenados = new ArrayList<ModuloSistema>();
		int count =0;
		try {
			for (PermisoSistema permisoSistema : permisos) {
				if (modulosOrdenados.contains(new ModuloSistema(permisoSistema.getIdModuloSistema()))) {
					for (int i = 0; i < modulosOrdenados.size(); i++) {
						if(modulosOrdenados.get(i).getIdModuloSistema() == permisoSistema.getIdModuloSistema())
							if (modulosOrdenados.get(i).getPermisoSistema() == null) {
								modulosOrdenados.get(i).setPermisoSistema(new ArrayList<PermisoSistema>());
								modulosOrdenados.get(i).getPermisoSistema().add(permisoSistema);
							}
							else
								modulosOrdenados.get(i).getPermisoSistema().add(permisoSistema);
					}
				} else {
					modulosOrdenados.add(consultarModuloSistemaPorId(new ModuloSistema(permisoSistema.getIdModuloSistema())));
					if (modulosOrdenados.get(count).getPermisoSistema() == null) {
						modulosOrdenados.get(count).setPermisoSistema(new ArrayList<PermisoSistema>());
						modulosOrdenados.get(count).getPermisoSistema().add(permisoSistema);
					}
					count++;
				}
			}
			
			return modulosOrdenados;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al ordenar los modulos de los permisos de usuario. - " + e.getMessage());
		} finally {
			
		}
	}
	
	public ModuloSistema consultarModuloSistemaPorId(ModuloSistema moduloSistema) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			return (ModuloSistema)ibatis.getSqlSession().selectOne(MODULO_PORID, moduloSistema);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al obtener el modulo del sistema. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
}
