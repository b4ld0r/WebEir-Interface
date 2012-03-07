package com.ciia.webeirinterface.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.dao.BitacoraDAO;
import com.ciia.webeirinterface.model.db.Bitacora;
import com.ciia.webeirinterface.model.db.ModuloSistema;
import com.ciia.webeirinterface.model.db.PermisoSistema;
import com.ciia.webeirinterface.model.db.Usuario;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	private String login = "/login.htm";
	private String logout = "/inicio/cierreSesion.htm";
	
	private static Log logger = LogFactory.getLog(SessionInterceptor.class);
	private BitacoraDAO bitacoraDAO = new BitacoraDAO();
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		
		if (!request.getServletPath().equals(login) && request.getSession().getAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN) == null) {
			response.sendRedirect(request.getContextPath() +  login);
			
			return false;
		}
		else {
			return true;
		}
 
	}
	
	@Override
	 public void postHandle(HttpServletRequest request,
			 HttpServletResponse response, Object handler, 
			 ModelAndView modelAndView) throws Exception{
		Bitacora bitacora = null;
		Usuario usuario = null;
		Integer indexModuloSeleccionado = 0;
		ModuloSistema moduloSeleccionado = null;
		PermisoSistema permisoSeleccionado = null;
		PermisoSistema subPermisoSeleccionado = null;
		String urlMapping = request.getServletPath();
		
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<Mapping:"  + urlMapping);
		if(!urlMapping.equals(login) && !urlMapping.equals(logout) ){
			usuario = (Usuario) request.getSession().getAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN);
			
			for(ModuloSistema modulo : usuario.getPerfilSistema().getModuloSistema()){
				
				for(PermisoSistema permiso : modulo.getPermisoSistema()){
					
					if(modelAndView == null){//Para peticion asincrona
						
						for(PermisoSistema subPermiso : permiso.getPermisoSistema()){
							if(subPermiso.getUrl().equals(urlMapping)){
								subPermisoSeleccionado = subPermiso;
								break;
							}
						}
					}
					else if(permiso.getUrl().equals(urlMapping)){//Para paginas
						permisoSeleccionado = permiso;
					}
					
					if(permisoSeleccionado != null || subPermisoSeleccionado != null){
						moduloSeleccionado = modulo;
						break;
					}
				}
				if(moduloSeleccionado != null){
					break;
				}
				indexModuloSeleccionado++;
			}
			
			
			if(modelAndView != null){//Es una pagina
				
				modelAndView.getModelMap().addAttribute(ConstantesWeb.CONST_ATTRIBUTE_INDEX_MODULO_SELECCIONADO, indexModuloSeleccionado);
				modelAndView.getModelMap().addAttribute(ConstantesWeb.CONST_ATTRIBUTE_ID_PERMISO_SELECCIONADO, (permisoSeleccionado == null?0:permisoSeleccionado.getIdPermisoSistema()));
				modelAndView.getModelMap().addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, (permisoSeleccionado == null?"":permisoSeleccionado.getTituloPagina()));
				
			}
			
			if(moduloSeleccionado == null){
				logger.error("La url solicitada no existe en BD, verifique las url de los permisos y subpermisos");
			}
			
			bitacora = (Bitacora) request.getAttribute(ConstantesWeb.CONST_ATTRIBUTE_INTERCEPTOR_BITACORA);
			
			if(bitacora != null){
				
				request.removeAttribute(ConstantesWeb.CONST_ATTRIBUTE_INTERCEPTOR_BITACORA);
				bitacora.setUsuario(usuario);
				bitacora.setModuloSistema(moduloSeleccionado);
				bitacoraDAO.insertarBitacora(bitacora);
			}
			
		}
	}
	
}
