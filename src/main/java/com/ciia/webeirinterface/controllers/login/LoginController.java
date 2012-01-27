package com.ciia.webeirinterface.controllers.login;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.model.login.Login;;

@Controller
@RequestMapping("login.htm")
public class LoginController {
	
	public static final String CONST_MODEL_ATTRIBUTE = "login";
	
	private final String tilesAsignado = "loginTiles";
	
    @RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
    	Login loginBean = new Login();
		model.addAttribute(CONST_MODEL_ATTRIBUTE, loginBean);
		return this.tilesAsignado;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid Login formulario, BindingResult result, Map<String,Object> model) {
		String usuario = "a";
		String contrasenia = "a";
		String regreso = this.tilesAsignado;
		
		formulario = (Login) model.get(CONST_MODEL_ATTRIBUTE);
		
		if (!result.hasErrors()) {
			if (!formulario.getUsuario().equals(usuario) || !formulario.getContrasenia().equals(contrasenia)) {
				result.rejectValue("contrasenia","NotMatch.contrasenia");
				return regreso;
			}
			model.put(CONST_MODEL_ATTRIBUTE, formulario);
			regreso = "principalTiles";
		}
		
		return regreso;
	}


}
