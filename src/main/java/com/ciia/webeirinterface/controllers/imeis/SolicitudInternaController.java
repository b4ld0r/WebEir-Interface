package com.ciia.webeirinterface.controllers.imeis;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.model.db.Usuario;

@Controller
@RequestMapping("solicitudInterna.htm")
public class SolicitudInternaController {
	
	private final String tilesAsignado = "loginTiles";
	private final String tilesSiguiente = "principalTiles";
	
    @RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN, new Usuario());
		return this.tilesAsignado;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid Usuario form, BindingResult result, ModelMap model) {
		
		if (!result.hasErrors()) {
			//Obtiene Login y valida
			if (!form.getContrasenia().equals(form.getContrasenia())) {
				result.rejectValue("contrasenia","NotMatch.contrasenia");
				return tilesAsignado;
			}
			
			
			model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN, form);
			return tilesSiguiente;
		}
		
		return tilesAsignado;
	}


}
