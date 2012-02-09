package com.ciia.webeirinterface.controllers.login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.model.login.Login;
import com.ciia.webeirinterface.model.login.Menu;
import com.ciia.webeirinterface.model.login.Permiso;

@Controller
@RequestMapping("login.htm")
//@SessionAttributes(types=Login.class)
public class LoginController {
	
	private final String tilesAsignado = "loginTiles";
	private final String tilesSiguiente = "principalTiles";
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		Login loginBean = new Login();
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN, loginBean);
		return this.tilesAsignado;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid Login form, BindingResult result, ModelMap model, HttpServletRequest request) {
		
		form = (Login) model.get(ConstantesWeb.CONST_ATTRIBUTE_LOGIN);
		
		if (!result.hasErrors()) {
			//Obtiene Login y valida
			if (!form.getContrasenia().equals(form.getUsuario())) {
				result.rejectValue("contrasenia","NotMatch.contrasenia");
				return tilesAsignado;
			}
			//Obtiene permisos
			List<Permiso> permisos = new ArrayList<Permiso>();
			permisos.add(new Permiso(1,"Test"));
			form.setPermisos(permisos);
			
			List<Menu> menu = new ArrayList<Menu>();
			List<Menu> submenu = new ArrayList<Menu>();
			
			submenu.add(new Menu("Consulta","#"));
			submenu.add(new Menu("Alta","#"));
			menu.add(new Menu("Solicitudes", submenu));
			
			submenu = new ArrayList<Menu>();
			submenu.add(new Menu("Consulta",request.getContextPath()+"/consultaIMEI.htm"));
			submenu.add(new Menu("Alta","#"));
			menu.add(new Menu("IMEIs", submenu));
			
			submenu = new ArrayList<Menu>();
			submenu.add(new Menu("Operadoras","#"));
			submenu.add(new Menu("Documentos","#"));
			submenu.add(new Menu("Escenarios",request.getContextPath()+"/escenarios.htm"));
			
			menu.add(new Menu("Cat&aacute;logos", submenu));
			
			submenu = new ArrayList<Menu>();
			submenu.add(new Menu("Usuarios","#"));
			submenu.add(new Menu("Perfiles",request.getContextPath()+"/perfiles.htm"));
			submenu.add(new Menu("Permisos","#"));
			submenu.add(new Menu("Reportes","#"));
			submenu.add(new Menu("Cambiar contrase&ntilde;a",request.getContextPath()+"/cambioClave.htm"));
			menu.add(new Menu("Administraci&oacute;n", submenu));
			
			request.getSession().setAttribute(ConstantesWeb.CONST_ATTRIBUTE_MENU, menu);
			request.getSession().setAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN, form);
			
			return tilesSiguiente;
		}
		
		return tilesAsignado;
	}


}
