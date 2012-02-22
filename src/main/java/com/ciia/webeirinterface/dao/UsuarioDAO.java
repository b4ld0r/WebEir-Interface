package com.ciia.webeirinterface.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ciia.webeirinterface.model.db.Directorio;
import com.ciia.webeirinterface.model.db.PerfilSistema;
import com.ciia.webeirinterface.model.db.Usuario;
import com.ciia.webeirinterface.mybatis.AccesoIbatis;

public class UsuarioDAO {
	private static final String LOGIN = "Usuario.permisoAcceso";
	private static final String LISTA_USUARIOS = "Usuario.getListaUsuario";
	private static final String USUARIO_PORID = "Usuario.getUsuario";
	private static final String VALIDA_USUARIO = "Usuario.validaNombre"; 
	private static final String ACTUALIZAR_USUARIO = "Usuario.updateUsuario";
	private static final String INSERTAR_USUARIO = "Usuario.insertUsuario";
	private static final String CAMBIO_CONTRASENIA = "Usuario.updateContrasenia";
	private static final String ASIGNAR_PERFIL = "Usuario.insertPerfilUsuario";
	private static final String BORRADO_LOGICO = "Usuario.borradoLogico";
	
	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}

	public Usuario autentificarUsuario(Usuario usuario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Usuario usuarioLogin = (Usuario)ibatis.getSqlSession().selectOne(LOGIN, usuario);
			PerfilSistemaDAO perfilUsuarioDao = new PerfilSistemaDAO();
			DirectorioDAO directorioUsuarioDao = new DirectorioDAO();
			
			if (usuarioLogin == null)
				return null;
			
			PerfilSistema perfilUsuario = perfilUsuarioDao.consultarPerfilPorUsuario(usuarioLogin);
			
			if(perfilUsuario != null)
				usuarioLogin.setPerfilSistema(perfilUsuario);
			
			Directorio directorio = directorioUsuarioDao.consultarDirectorioPadreUsuario(usuarioLogin);
			
			if (directorio != null)
				usuarioLogin.setDirectorio(directorio);
			
			return usuarioLogin;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al loguearse. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> consultarUsuarios(Integer cursor, Integer registros, String columnas) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Map<String, Object> pMap = new HashMap<String, Object>();
			pMap.put("cursor", cursor);
			pMap.put("registros", registros);
			pMap.put("columnas", columnas);
			
			return (List<Usuario>)ibatis.getSqlSession().selectList(LISTA_USUARIOS, pMap);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al obtener lista de usuarios. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Usuario consultarPorId(Usuario usuario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			return (Usuario)ibatis.getSqlSession().selectOne(USUARIO_PORID);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al obtener el usuarios. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Boolean validarUsuarioNombre(Usuario usuario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			return (Usuario)ibatis.getSqlSession().selectOne(VALIDA_USUARIO, usuario) != null ? false : true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al validar el nombre de usuario. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}

	public Boolean actualizarUsuario(Usuario usuario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer actualiza = ibatis.getSqlSession().update(ACTUALIZAR_USUARIO, usuario);
			
			if (actualiza > 0 && actualiza != null)
			{
				ibatis.getSqlSession().commit();
				return true;
			}
			
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			ibatis.getSqlSession().rollback();
			e.printStackTrace();
			throw new Exception("Error al acutalizar el usuario. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Usuario insertarUsuario(Usuario usuario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer inserta = ibatis.getSqlSession().insert(INSERTAR_USUARIO, usuario);
			
			if (inserta > 0 && !inserta.equals(null))
			{	
				ibatis.getSqlSession().commit();
				usuario.setCambioContrasenia(false);
				return usuario;
			}
			
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			ibatis.getSqlSession().rollback();
			e.printStackTrace();
			throw new Exception("Error al insertar el usuarios. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Boolean cambiarContrasenia(Usuario usuario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer actualiza = ibatis.getSqlSession().update(CAMBIO_CONTRASENIA, usuario);
			
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
			throw new Exception("Error al cambiar la contrasenia. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Boolean asignarPerfil(Usuario usuario, PerfilSistema perfilSistema) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Map<String,Object> pMap = new HashMap<String, Object>();
			pMap.put("idUsuario", usuario.getIdUsuario());
			pMap.put("idPerfilSistema", perfilSistema.getIdPerfilSistema());
			
			Integer insertar = ibatis.getSqlSession().insert(ASIGNAR_PERFIL, pMap);
			
			if (insertar != null &&  insertar > 0)
			{
				ibatis.getSqlSession().commit();
				return true;
			}
			
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			ibatis.getSqlSession().rollback();
			e.printStackTrace();
			throw new Exception("Error al asignar el perfil al usuario. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Boolean activarDesactivarUsuario(Usuario usuario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer actualiza = ibatis.getSqlSession().update(BORRADO_LOGICO, usuario);
			
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
			throw new Exception("Error al " + (usuario.getActivo() == true ? "activar" : "desactivar") + " el usuario. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
}
