package com.ciia.webeirinterface.controllers.administracion;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.model.login.Login;

@Controller
@RequestMapping("1.htm")
public class N1ombreController {
	
	private final String tilesAsignado = "loginTiles";
	private final String tilesSiguiente = "principalTiles";
	
    @RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
    	Login loginBean = new Login();
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN, loginBean);
		return this.tilesAsignado;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid Login formulario, BindingResult result, ModelMap model) {
		Login loginBD = null;
		
		formulario = (Login) model.get(ConstantesWeb.CONST_ATTRIBUTE_LOGIN);
		
		if (!result.hasErrors()) {
			//Obtiene Login y valida
			if (!formulario.getContrasenia().equals(formulario.getUsuario())) {
				result.rejectValue("contrasenia","NotMatch.contrasenia");
				return tilesAsignado;
			}
			//Obtiene perfiles
			
			
			model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN, formulario);
			return tilesSiguiente;
		}
		
		return tilesAsignado;
	}


}
