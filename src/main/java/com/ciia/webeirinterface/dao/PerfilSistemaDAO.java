package com.ciia.webeirinterface.dao;

import java.util.List;

import com.ciia.webeirinterface.model.db.PerfilSistema;
import com.ciia.webeirinterface.model.db.PermisoSistema;
import com.ciia.webeirinterface.model.db.Usuario;
import com.ciia.webeirinterface.mybatis.AccesoIbatis;

public class PerfilSistemaDAO {
	private static final String PERFIL_USUARIO = "PerfilSistema.perfilUsuario";
	private static final String INSERTAR_PERFIL = "PerfilSistema.insertPerfilSistema";
	private static final String ACTUALIZAR_PERFIL = "PerfilSistema.updatePerfilSistema";
	private static final String LISTA_PERFIL = "PerfilSistema.getListaPerfilSistema";
	private static final String BORRADO_LOGICO = "PerfilSistema.borradoLogico"; 
	
	public PerfilSistemaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public PerfilSistema consultarPerfilPorUsuario(Usuario usuario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			PerfilSistema perfilSistema = (PerfilSistema)ibatis.getSqlSession().selectOne(PERFIL_USUARIO, usuario);
			PermisoSistemaDAO permisoPerfilDAO = new PermisoSistemaDAO();
			List<PermisoSistema> permisos = permisoPerfilDAO.permisosUsuario(perfilSistema);
			ModuloSistemaDAO moduloSistemaDAO = new ModuloSistemaDAO();
			
			if(permisos != null && !permisos.isEmpty())
				perfilSistema.setModuloSistema(moduloSistemaDAO.ordenarPermisosUsuario(permisos));

			return perfilSistema;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al obtener el perfil del usuarios. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<PerfilSistema> consultarPerfilSistema () throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			return (List<PerfilSistema>)ibatis.getSqlSession().selectList(LISTA_PERFIL);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al obtener los perfiles del sistema. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public PerfilSistema insertarPerfil(PerfilSistema perfilSistema) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer inserta = ibatis.getSqlSession().insert(INSERTAR_PERFIL, perfilSistema);
			
			if (inserta != null && inserta > 0)
			{	
				ibatis.getSqlSession().commit();
				return perfilSistema;
			}
			
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al insertar el perfil de sistema. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Boolean actualizarPerfilSistema(PerfilSistema perfilSistema) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer actualiza = ibatis.getSqlSession().update(ACTUALIZAR_PERFIL, perfilSistema);
			
			if (actualiza != null && actualiza > 0)
			{
				ibatis.getSqlSession().commit();
				return true;
			}
			
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			ibatis.getSqlSession().rollback();
			e.printStackTrace();
			throw new Exception("Error al acutalizar el perfil del sistema. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Boolean activarDesactivarPerfilSistema(PerfilSistema perfilSistema) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer actualiza = ibatis.getSqlSession().update(BORRADO_LOGICO, perfilSistema);
			
			if (actualiza != null && actualiza > 0)
			{
				ibatis.getSqlSession().commit();
				return true;
			}
			
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			ibatis.getSqlSession().rollback();
			e.printStackTrace();
			throw new Exception("Error al " + (perfilSistema.getActivo() == true ? "activar" : "desactivar") + " el perfil del sistema. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
}
