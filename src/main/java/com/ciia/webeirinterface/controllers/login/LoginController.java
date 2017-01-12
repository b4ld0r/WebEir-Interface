package com.ciia.webeirinterface.controllers.login;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.dao.UsuarioDAO;
import com.ciia.webeirinterface.model.db.ModuloSistema;
import com.ciia.webeirinterface.model.db.PerfilSistema;
import com.ciia.webeirinterface.model.db.Usuario;

@Controller
@RequestMapping("login.htm")
public class LoginController {
	
	private final String tilesAsignado = "loginTiles";
	private final String tilesSiguiente = "redirect:/inicio/inicio.htm";
	
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_USUARIO, new Usuario());
		
		return this.tilesAsignado;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid Usuario form ,BindingResult result, ModelMap model, HttpServletRequest request) throws Exception{
		Usuario usuarioBd = null;

		if (!result.hasErrors()) {
			
			usuarioBd = usuarioDAO.autentificarUsuario(form);
			
			if (usuarioBd == null) {
				
				result.rejectValue("contrasenia","NotMatch.contrasenia");
				
				return this.tilesAsignado; 
			}
			
			if(usuarioBd.getPerfilSistema() == null || usuarioBd.getPerfilSistema().getModuloSistema() == null){
				
				PerfilSistema perfilVacio = new PerfilSistema();
				perfilVacio.setModuloSistema(new ArrayList<ModuloSistema>());
				usuarioBd.setPerfilSistema(perfilVacio);
			}

			request.getSession().setAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN, usuarioBd);
			
			return tilesSiguiente;
		}
		
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_USUARIO, form);
		
		return tilesAsignado;
	}
	
}

