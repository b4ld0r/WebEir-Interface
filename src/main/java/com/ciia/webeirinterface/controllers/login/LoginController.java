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
import com.ciia.webeirinterface.dao.UsuarioDAO;
import com.ciia.webeirinterface.model.db.PerfilSistema;
import com.ciia.webeirinterface.model.db.Usuario;
import com.ciia.webeirinterface.model.login.Menu;

@Controller
@RequestMapping("login.htm")
//@SessionAttributes(types=Login.class)
public class LoginController {
	
	private final String nombrePagina = "Acceso al sistema";
	private final String tilesAsignado = "loginTiles";
	private final String tilesSiguiente = "principalTiles";
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN, new Usuario());
		
		return this.tilesAsignado;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid Usuario form ,BindingResult result, ModelMap model, HttpServletRequest request) {
		Usuario usuarioBd;
		UsuarioDAO serviciodb;
		
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN, form);
		
		if (!result.hasErrors()) {
			/*serviciodb = new UsuarioDAO();
			//usuarioBd = serviciodb.loginUsuario(form);
			
			if (usuarioBd == null) {
				result.rejectValue("contrasenia","NotMatch.contrasenia");
				
				return this.tilesAsignado; 
			}
			*/
			if (!form.getNombreUsuario().equals(form.getContrasenia())) {
				result.rejectValue("contrasenia","NotMatch.login.contrasenia");
				
				return this.tilesAsignado; 
			}
			
			
			//Creacion de temporal
			form.setPerfilSistema(new PerfilSistema(1,"Administrador"));
			
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
			submenu.add(new Menu("Usuarios",request.getContextPath()+"/usuario/usuarios.htm"));
			submenu.add(new Menu("Perfiles",request.getContextPath()+"/perfiles.htm"));
			submenu.add(new Menu("Permisos","#"));
			submenu.add(new Menu("Reportes","#"));
			submenu.add(new Menu("Cambiar contrase&ntilde;a",request.getContextPath()+"/cambioClave.htm"));
			menu.add(new Menu("Administraci&oacute;n", submenu));
			
			request.getSession().setAttribute(ConstantesWeb.CONST_ATTRIBUTE_MENU, menu);
			request.getSession().setAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN, form);//usuarioBd
			
			return tilesSiguiente;
		}
		
		return tilesAsignado;
	}


}
