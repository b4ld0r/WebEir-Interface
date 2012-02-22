package com.ciia.webeirinterface.controllers.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.ibatis.io.Resources;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.dao.UsuarioDAO;
import com.ciia.webeirinterface.model.Menu;
import com.ciia.webeirinterface.model.db.ModuloSistema;
import com.ciia.webeirinterface.model.db.PermisoSistema;
import com.ciia.webeirinterface.model.db.Usuario;

@Controller
@RequestMapping("login.htm")
//@SessionAttributes(types=Login.class)
public class LoginController {
	
	private final String configUrl = "urlPermisos.properties";
	
	private final String nombrePagina = "Acceso al sistema";
	private final String tilesAsignado = "loginTiles";
	private final String tilesSiguiente = "redirect:/inicio/inicio.htm";
	
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
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
			
			request.getSession().setAttribute(ConstantesWeb.CONST_ATTRIBUTE_MENU, 
					this.generarMenu(usuarioBd.getPerfilSistema().getModuloSistema(),request.getContextPath().concat("/")));
			request.getSession().setAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN, usuarioBd);
			
			return tilesSiguiente;
		}
		
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_USUARIO, form);
		
		return tilesAsignado;
	}
	
	private List<Menu> generarMenu (List<ModuloSistema> modulos, String pathAplicacion) throws Exception{
		List<Menu> menu = new ArrayList<Menu>();
		List<Menu> submenu = null;
		String rutaHtml = null;
		Properties urlPath = new Properties();
		
		urlPath.load(Resources.getResourceAsReader(configUrl));
		
		for (ModuloSistema modulo : modulos) {
			submenu = new ArrayList<Menu>();
			
			for (PermisoSistema permiso : modulo.getPermisoSistema()) {
				rutaHtml = pathAplicacion + urlPath.getProperty( "idPermiso"+ permiso.getIdPermisoSistema()).trim();
				
				submenu.add( new Menu(permiso.getDescripcion(), rutaHtml) );
			}
			
			menu.add(new Menu(modulo.getDescripcion(), submenu));
		}

		return menu;
	}


}
