package com.ciia.webeirinterface.controllers.administracion;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.dao.PerfilSistemaDAO;
import com.ciia.webeirinterface.dao.UsuarioDAO;
import com.ciia.webeirinterface.model.db.PerfilSistema;
import com.ciia.webeirinterface.model.db.Usuario;
import com.ciia.webeirinterface.model.json.PaginaGrid;
import com.ciia.webeirinterface.model.json.RespuestaJson;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/administracion/")
public class UsuariosController {
	
	private final String tilesAsignado = "usuarioTiles";
	
	private UsuarioDAO usuarioDAO=new UsuarioDAO();
	private PerfilSistemaDAO perfilSistemaDAO=new PerfilSistemaDAO();
	
    @RequestMapping(value="usuarios.htm",method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		try {
			System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");
			List<PerfilSistema> perfiles=perfilSistemaDAO.consultarPerfilSistema();
			
			for(PerfilSistema perf: perfiles){
				System.out.println("*"+perf.getIdPerfilSistema()+"*");
			}
			
			System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");
			model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_LISTA_PERFILES, perfiles);
			
		} catch (Exception ex) {
			Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return this.tilesAsignado;
	}
	

	@RequestMapping(value="obtenUsuarios.htm",method = RequestMethod.GET)
	 public @ResponseBody PaginaGrid<Usuario> listaUsuarios(
      @RequestParam(value = "page", required = false, defaultValue = "1") int page,
      @RequestParam(value = "max", required = false, defaultValue = "20") int max,
	  @RequestParam(value = "sord", required = false, defaultValue = "usuariosT_nombre") String sord,
	  @RequestParam(value = "sidx", required = false, defaultValue = "asc") String sidx) {
		try {
			sidx=(sidx!=null && !sidx.isEmpty()?sidx.split("_")[1]:ConstantesWeb.CONST_SORT_FIELD_USUARIO) +" "+sord;
			List<Usuario> usuarios=usuarioDAO.consultarUsuarios(max*(page-1), max, sidx);
			return new PaginaGrid<Usuario>(usuarios, page, usuarioDAO.consultarTotalUsuarios(Boolean.TRUE), max);
		} catch (Exception ex) {
			Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return new PaginaGrid<Usuario>();
	}
	
	@RequestMapping(value="editaUsuario.htm",method = {RequestMethod.PUT, RequestMethod.POST})
	public @ResponseBody RespuestaJson editarUsuario(@RequestBody Usuario usuario) {
		
		RespuestaJson respuesta=new RespuestaJson();
		usuario.setActivo(Boolean.TRUE);
		try {
			if(usuario.getIdUsuario()==null){
				if(usuarioDAO.validarUsuarioNombre(usuario)){
					usuario.setContrasenia(usuario.getNombreUsuario()+"00");
					if(usuarioDAO.insertarUsuario(usuario)!=null){
						usuarioDAO.asignarPerfil(usuario, usuario.getPerfilSistema());
						respuesta.setMessage("El usuario ha sido creado correctamente.");
						respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
					}else{
						respuesta.setMessage("Ocurrió un error al insertar el usuario");
						respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
					}
				}else{
					respuesta.setMessage("El nombre de usuario ya existe");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
				}
			}else{
				usuario.setPerfilSistema(perfilSistemaDAO.consultarPerfilPorUsuario(usuario));
				if(usuarioDAO.actualizarUsuario(usuario)){
					respuesta.setMessage("La información ha sido guardada correctamente.");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
				}else{
					respuesta.setMessage("Ocurrió un error al editar al usuario");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
				}
			}
		} catch (com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException ex) {
			Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
			respuesta.setMessage("El nombre de usuario asignado ya existe");
			respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
		}catch (Exception ex) {
			Logger.getLogger(ex.getClass().getName());
			Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
			respuesta.setMessage("Ocurrió un error al insertar el usuario:"+ex.getMessage());
			respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
		}
		return respuesta;
	}
	
	@RequestMapping(value="eliminaUsuario.htm",method = RequestMethod.POST)
	public @ResponseBody RespuestaJson eliminarUsuario(@RequestParam(value = "id", required = true) int id) {
		RespuestaJson respuesta=new RespuestaJson();
		Usuario usuario=null;
		try {
			usuario = new Usuario(id);
			usuario.setActivo(Boolean.FALSE);
			usuarioDAO.activarDesactivarUsuario(usuario);
			respuesta.setMessage("La información ha sido guardada correctamente.");
			respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
		} catch (Exception ex) {
			Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
			respuesta.setMessage("Ocurrió una excepcion: "+ex.getMessage());
			respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
		}
		
		
		
		return respuesta;
	}
	
}
