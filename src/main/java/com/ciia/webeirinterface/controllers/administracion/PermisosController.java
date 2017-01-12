
package com.ciia.webeirinterface.controllers.administracion;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.dao.PerfilSistemaDAO;
import com.ciia.webeirinterface.dao.PermisoSistemaDAO;
import com.ciia.webeirinterface.model.PermisosPerfil;
import com.ciia.webeirinterface.model.db.PerfilSistema;
import com.ciia.webeirinterface.model.db.PermisoSistema;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/administracion/")
public class PermisosController {
	
	PermisoSistemaDAO permisoSistemaDAO=new PermisoSistemaDAO();
	PerfilSistemaDAO perfilSistemaDAO=new PerfilSistemaDAO();
	
	private final String tilesAsignado = "permisoTiles";
	
	@RequestMapping(value="asignaPerfil.htm",method = RequestMethod.GET)
	public String initForm(ModelMap model,@RequestParam(value = "id", required = true) int id) {
		PermisosPerfil permisosPerfil;
		try {
			permisosPerfil=new PermisosPerfil(id, permisoSistemaDAO.permisosUsuario(new PerfilSistema(id)));
			model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_PERFIL, permisosPerfil);
			model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_LISTA_PERMISOS, permisoSistemaDAO.consultarPermisoSistema());
		} catch (Exception ex) {
			Logger.getLogger(PerfilController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return this.tilesAsignado;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@RequestParam(value = "id", required = true) int id,
							  @RequestParam(value = "permisosSistema", required = false) String [] ids , ModelMap model) throws Exception{
		System.out.println(id+" "+ids);
		List<PermisoSistema> permisos=new ArrayList<PermisoSistema>(ids.length);
		for(String idPS:ids){
			permisos.add(new PermisoSistema(new Integer(idPS), Boolean.TRUE));
		}
		if(perfilSistemaDAO.asignarPermiso(new PerfilSistema(id), permisos)){
			model.addAttribute(tilesAsignado, model);
		}
		
		return new PerfilController().initForm(model);
	}
	
}
