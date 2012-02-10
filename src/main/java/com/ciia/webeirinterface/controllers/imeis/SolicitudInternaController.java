package com.ciia.webeirinterface.controllers.imeis;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.model.imeis.SolicitudInterna;
import com.ciia.webeirinterface.model.login.Login;

@Controller
@RequestMapping("solicitudInterna.htm")
public class SolicitudInternaController {
	
	private final String tilesAsignado = "solicitudInternaTiles";
	
    @RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_SOLICITUD_INTERNA, new SolicitudInterna());
		return this.tilesAsignado;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid Login formulario, BindingResult result, ModelMap model) {
		
		formulario = (Login) model.get(ConstantesWeb.CONST_ATTRIBUTE_LOGIN);
		
		if (!result.hasErrors()) {
			//Obtiene Login y valida
			if (!formulario.getContrasenia().equals(formulario.getUsuario())) {
				result.rejectValue("contrasenia","NotMatch.contrasenia");
				return tilesAsignado;
			}
			
			model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN, formulario);
			return tilesAsignado;
		}
		
		return tilesAsignado;
	}


}
