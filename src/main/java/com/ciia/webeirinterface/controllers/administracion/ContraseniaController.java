package com.ciia.webeirinterface.controllers.administracion;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.model.administracion.Contrasenia;

@Controller
@RequestMapping("cambioClave.htm")
public class ContraseniaController {
	
	private final String tilesAsignado = "cambioContraseniaTiles";
	private final String nombrePagina = "Cambiar contrase&ntilde;a";
	
    @RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
    	
    	model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_CONTRASENIA, new Contrasenia());
		return this.tilesAsignado;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid Contrasenia form, BindingResult result, ModelMap model) {
		
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_CONTRASENIA, form);
		
		if (!result.hasErrors()) {
			return tilesAsignado;
		}
		
		return tilesAsignado;
	}


}
