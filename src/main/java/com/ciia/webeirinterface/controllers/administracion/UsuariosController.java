package com.ciia.webeirinterface.controllers.administracion;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.dao.UsuarioDAO;
import com.ciia.webeirinterface.model.db.Usuario;
import com.ciia.webeirinterface.model.json.PaginaGrid;
import com.ciia.webeirinterface.model.json.RespuestaJson;
import java.util.ArrayList;
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
	
    @RequestMapping(value="usuarios.htm",method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		return this.tilesAsignado;
	}
	

	@RequestMapping(value="obtenUsuarios.htm",method = RequestMethod.GET)
	 public @ResponseBody PaginaGrid<Usuario> listaUsuarios(
      @RequestParam(value = "page", required = false, defaultValue = "1") int page,
      @RequestParam(value = "max", required = false, defaultValue = "20") int max,
	  @RequestParam(value = "sord", required = false, defaultValue = "nombre") String sord,
	  @RequestParam(value = "sixd", required = false, defaultValue = "asc") String sixd) {
		try {
			sixd=(sixd!=null && !sixd.isEmpty()?sixd.split("_")[1]:ConstantesWeb.CONST_SORT_FIELD_USUARIO) +" "+sord;
			List<Usuario> usuarios=usuarioDAO.consultarUsuarios(max*(page-1), max, sixd);
			return new PaginaGrid<Usuario>(usuarios.subList(max*(page-1), (max*page)>usuarios.size()?usuarios.size():(max*page)), page, usuarios.size(), max);
		} catch (Exception ex) {
			Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return new PaginaGrid<Usuario>();
	}
	
	@RequestMapping(value="editaUsuario.htm",method = {RequestMethod.PUT, RequestMethod.POST})
	public @ResponseBody RespuestaJson editarUsuario(@RequestBody Usuario usuario) {
		
		RespuestaJson respuesta=new RespuestaJson();
		
		try {
			if(usuario.getIdUsuario()==null){
				usuario.setContrasenia(usuario.getNombreUsuario());
				if(usuarioDAO.insertarUsuario(usuario)!=null){
					respuesta.setMessage("El usuario ha sido creado correctamente.");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
				}else{
					respuesta.setMessage("Ocurrió un error al insertar el usuario");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
				}
			}else{
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
	
	
	private List<Usuario> dameusuaList(){
		List<Usuario> usuarios= new ArrayList<Usuario>();//usuarioDAO.listaUsuarios();
			usuarios.add(new Usuario(1, "Nombre", "Apellido", "Apellido", "nombreUs", "", "adasd@dfalsd.com", "alguna"));
			usuarios.add(new Usuario(2, "Nombre1", "Apellido1", "Apellido1", "nombreUs1", "", "adasd@dfalsd.com", "alguna"));
			usuarios.add(new Usuario(3, "Nombre2", "Apellido2", "Apellido2", "nombreUs2", "", "adasd@dfalsd.com", "alguna"));
			usuarios.add(new Usuario(4, "Nombre3", "Apellido3", "Apellido3", "nombreUs3", "", "adasd@dfalsd.com", "alguna"));
			usuarios.add(new Usuario(5, "Nombre4", "Apellido4", "Apellido4", "nombreUs4", "", "adasd@dfalsd.com", "alguna"));
			usuarios.add(new Usuario(6, "Nombre5", "Apellido5", "Apellido5", "nombreUs5", "", "adasd@dfalsd.com", "alguna"));
			usuarios.add(new Usuario(7, "Nombre6", "Apellido6", "Apellido6", "nombreUs6", "", "adasd@dfalsd.com", "alguna"));
			usuarios.add(new Usuario(8, "Nombre7", "Apellido7", "Apellido7", "nombreUs7", "", "adasd@dfalsd.com", "alguna"));
		for(Usuario us:usuarios) us.setActivo(Boolean.TRUE);
		return usuarios;
	}
	
}
