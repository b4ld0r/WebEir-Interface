package com.ciia.webeirinterface.controllers.administracion;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.dao.UsuarioDAO;
import com.ciia.webeirinterface.model.Contrasenia;
import com.ciia.webeirinterface.model.db.Usuario;

@Controller
@RequestMapping("cambioClave.htm")
public class ContraseniaController {
	
	private final String tilesAsignado = "cambioContraseniaTiles";
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
    @RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
    	
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_CONTRASENIA, new Contrasenia());
		
		return this.tilesAsignado;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid Contrasenia form, BindingResult result, ModelMap model, HttpServletRequest request) throws Exception{
		
		Usuario usuarioSesion = null;
		
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_CONTRASENIA, form);
		
		if (!result.hasErrors()) {
			usuarioSesion =(Usuario) request.getSession().getAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN);
			
			if(!usuarioSesion.getContrasenia().equals(form.getContraseniaActual())) {
				
				result.rejectValue("contraseniaActual","NotMatch.contraseniaActual");
				
				return this.tilesAsignado;
			}
			
			usuarioSesion.setContrasenia(form.getContraseniaNueva());
			
			usuarioDAO.cambiarContrasenia(usuarioSesion);
			
			request.getSession().setAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN, usuarioSesion);
			
			model.addAttribute(ConstantesWeb.CONST_MESSAGE_RESPUESTA, "El cambio de contrase&ntilde;a se realiz&oacute; con &eacute;xito");
			model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_CONTRASENIA, new Contrasenia());
			return this.tilesAsignado;
		}
		
		return this.tilesAsignado;
	}


}
