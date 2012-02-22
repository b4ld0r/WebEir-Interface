package com.ciia.webeirinterface.controllers.administracion;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.dao.PerfilSistemaDAO;
import com.ciia.webeirinterface.model.db.PerfilSistema;
import com.ciia.webeirinterface.model.json.PaginaGrid;
import com.ciia.webeirinterface.model.json.RespuestaJson;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/administracion/")
public class PerfilController {
	
	private final String tilesAsignado = "perfilTiles";
	private final String nombrePagina = "Registrar Perfil";
	
	PerfilSistemaDAO perfilSistemaDAO=new PerfilSistemaDAO();

	public PerfilController() {
	}
	
    @RequestMapping(value="perfiles.htm",method = RequestMethod.GET)
	public String initForm(ModelMap model) {
    	model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		return this.tilesAsignado;
	}
	
	@RequestMapping(value="obtenPerfiles.htm",method = RequestMethod.GET)
	 public @ResponseBody PaginaGrid<PerfilSistema> listBooks(
      @RequestParam(value = "page", required = false, defaultValue = "1") int page,
      @RequestParam(value = "max", required = false, defaultValue = "10") int max) {
		try {
			List<PerfilSistema> perfiles=perfilSistemaDAO.consultarPerfilSistema();
			
			return new PaginaGrid<PerfilSistema>(perfiles.subList(max*(page-1), (max*page>perfiles.size()?perfiles.size():max*page)), page, perfiles.size(), max);
		} catch (Exception ex) {
			
		}
		return new PaginaGrid<PerfilSistema>();
	}

	@RequestMapping(value="editaPerfil.htm",method = {RequestMethod.PUT, RequestMethod.POST})
	public @ResponseBody RespuestaJson editaPerfil(@RequestBody PerfilSistema perfil) {
		RespuestaJson respuesta=new RespuestaJson();
		perfil.setActivo(Boolean.TRUE);
		try {
			perfilSistemaDAO.insertarPerfil(perfil);
		} catch (Exception ex) {
			Logger.getLogger(PerfilController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		respuesta.setMessage("Se agregó el perfil");
		respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
		
		return respuesta;
	}
	
	@RequestMapping(value="eliminaPerfil.htm",method = RequestMethod.POST)
	public @ResponseBody RespuestaJson eliminaUsuario(@RequestParam(value = "id", required = true) int id) {
		RespuestaJson respuesta=new RespuestaJson();
		try {
			perfilSistemaDAO.activarDesactivarPerfilSistema(new PerfilSistema(new Integer(id), Boolean.FALSE));
			respuesta.setMessage("Se eliminó al usuario correctamente ");
			respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
		} catch (Exception ex) {
			Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
			respuesta.setMessage("Ocurrió una excepcion: "+ex.getMessage());
			respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
		}
		
		
		
		return respuesta;
	}


}
