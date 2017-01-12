package com.ciia.webeirinterface.controllers.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.model.db.Usuario;

@Controller
@RequestMapping("/inicio/")
public class MainController {
	private static Log logger = LogFactory.getLog(MainController.class);
	
	@RequestMapping(value="inicio.htm",method = RequestMethod.GET)
	public String initFormInicio(HttpServletRequest request) {
		String urlPrincipal = null;
		
		try{
			urlPrincipal = ((Usuario) request.getSession().getAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN)).getPerfilSistema().getModuloSistema().get(0).getPermisoSistema().get(0).getUrl();
			
			return "redirect:.." + urlPrincipal;
		}catch(Exception e){
			logger.error("No se pudo obtener la pagina principal" + e.getStackTrace());
		}
		return "principalTiles";
    }
	
	@RequestMapping(value="cierreSesion.htm",method = RequestMethod.GET)
	public String initFormCierre(ModelMap model , HttpServletRequest request) {
		request.getSession().invalidate();
		
		return "redirect:../login.htm";
    }
}
