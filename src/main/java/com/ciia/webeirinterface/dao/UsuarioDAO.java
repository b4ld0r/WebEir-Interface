package com.ciia.webeirinterface.dao;

import java.util.List;

import com.ciia.webeirinterface.model.db.Usuario;
import com.ciia.webeirinterface.mybatis.AccesoIbatis;

public class UsuarioDAO {
	private static final String LOGIN = "Usuario.permisoAcceso";
	private static final String LISTA_USUARIOS = "Usuario.getListaUsuario";
	private static final String USUARIO_BYID = "Usuario.getUsuario";
	private static final String ACTUALIZAR_USUARIO = "Usuario.updateUsuario";
	private static final String INSERTAR_USUARIO = "Usuario.insertUsuario";
	private static final String CAMBIO_CONTRASENIA = "Usuario.updateContrasenia";
	
	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}

	public Usuario loginUsuario(Usuario usuario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Usuario usuarioLogin = (Usuario)ibatis.getSqlSession().selectOne(LOGIN, usuario);
			PerfilSistemaDAO perfilUsuario = new PerfilSistemaDAO();
			DirectorioDAO directorioUsuario = new DirectorioDAO();
			
			if (usuarioLogin == null)
				return null;
			
			usuarioLogin.setPerfilSistema(perfilUsuario.perfilUsuario(usuarioLogin));
			usuarioLogin.setDirectorio(directorioUsuario.directorioPadreUsuario(usuarioLogin));
			
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
	public List<Usuario> listaUsuarios() throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			return (List<Usuario>)ibatis.getSqlSession().selectList(LISTA_USUARIOS);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error al obtener lista de usuarios. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Usuario usuarioPorId(Usuario usuario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			return (Usuario)ibatis.getSqlSession().selectOne(USUARIO_BYID);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error al obtener el usuarios. - " + e.getMessage());
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
			throw new Exception("Error al acutalizar usuarios. - " + e.getMessage());
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
			throw new Exception("Error al insertar el usuarios. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Boolean cambioContrasenia(Usuario usuario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer actualiza = ibatis.getSqlSession().update(CAMBIO_CONTRASENIA, usuario);
			
			if (actualiza > 0 && actualiza != null)
			{
				ibatis.getSqlSession().commit();
				return true;
			}
			
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			ibatis.getSqlSession().rollback();
			throw new Exception("Error al cambiar la contrasenia. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
}
