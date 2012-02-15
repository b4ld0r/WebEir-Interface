package com.ciia.webeirinterface.controllers.administracion;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.model.db.Usuario;

@Controller
@RequestMapping("cambioClave.htm")
public class ContraseniaController {
	
	private final String tilesAsignado = "cambioContraseniaTiles";
	private final String nombrePagina = "Cambiar contrase&ntilde;a";
	
    @RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
    	
    	model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_CONTRASENIA, new Usuario());
		
		return this.tilesAsignado;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(BindingResult result, ModelMap model, HttpServletRequest request) {
		
		Usuario contraseniaCambio = (Usuario)model.get(ConstantesWeb.CONST_ATTRIBUTE_CONTRASENIA);
		Usuario usuarioSesion =(Usuario) request.getSession().getAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN);
		
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		
		if (!result.hasErrors()) {
			model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_CONTRASENIA, new Usuario());
			return tilesAsignado;
		}
		else{
			model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_CONTRASENIA, contraseniaCambio);
		}
		
		return tilesAsignado;
	}


}
