package com.ciia.webeirinterface.controllers.imeis;

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
import com.ciia.webeirinterface.model.login.Perfil;

@Controller
@RequestMapping("login.htm")
public class NombreController {
	
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
			List<Perfil> listaPerfiles =new ArrayList<Perfil>();
			Perfil tmp = new Perfil(1,"Admin");
			listaPerfiles.add(tmp);
			tmp = new Perfil(2,"Fraudes");
			listaPerfiles.add(tmp);
			loginBD = formulario;
			loginBD.setPerfiles(listaPerfiles);
			
			model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN, formulario);
			return tilesSiguiente;
		}
		
		return tilesAsignado;
	}


}
