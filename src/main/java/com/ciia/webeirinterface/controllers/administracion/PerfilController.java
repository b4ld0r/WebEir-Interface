package com.ciia.webeirinterface.controllers.administracion;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.model.administracion.Perfil;

@Controller
@RequestMapping("perfiles.htm")
public class PerfilController {
	
	private final String tilesAsignado = "perfilTiles";
	private final String nombrePagina = "Registrar Perfil";
	
    @RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
    	
    	model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_PERFIL, new Perfil());
		return this.tilesAsignado;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid Perfil form, BindingResult result, ModelMap model) {
		
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_PERFIL, form);
		
		if (!result.hasErrors()) {
			return tilesAsignado;
		}
		
		return tilesAsignado;
	}


}
