package com.ciia.webeirinterface.interceptors;

import java.util.List;

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
	private String main = "/inicio/inicio.htm";
	
	
	private static Log logger = LogFactory.getLog(SessionInterceptor.class);
	private BitacoraDAO bitacoraDAO = new BitacoraDAO();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String urlMapping = request.getServletPath();
		PermisoSistema permisoSeleccionado = null;
		Boolean peticionValida = Boolean.FALSE;
		
		if(urlMapping.equals(login) || 
				(request.getSession().getAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN) != null && (urlMapping.equals(logout) || urlMapping.equals(main)) )){
			peticionValida =  Boolean.TRUE;
		}
		else if(request.getSession().getAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN) != null){
			permisoSeleccionado = this.buscarPermiso( ( (Usuario) request.getSession().getAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN) ).getPerfilSistema().getModuloSistema()
					, urlMapping);
			
			if(permisoSeleccionado != null){
				request.setAttribute(ConstantesWeb.CONST_ATTRIBUTE_PERMISO_SELECCIONADO, permisoSeleccionado);
				peticionValida =  Boolean.TRUE;
			}
			
		}
		
		if(!peticionValida){
			response.sendRedirect(request.getContextPath() +  login);
		}
		
		return peticionValida.booleanValue();
	}
	
	@Override
	 public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
			 ModelAndView modelAndView) throws Exception{
		Bitacora bitacora = null;
		Usuario usuario = null;
		Boolean encontrado = Boolean.FALSE;
		Integer indexModuloSeleccionado = -1;
		String urlMapping = request.getServletPath();
		PermisoSistema permisoSeleccionado = null;
		List<ModuloSistema> modulos = null;
		
		if(!urlMapping.equals(login) && !urlMapping.equals(logout) && !urlMapping.equals(main)){
			usuario = (Usuario) request.getSession().getAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN);
			modulos = usuario.getPerfilSistema().getModuloSistema();
			permisoSeleccionado = (PermisoSistema) request.getAttribute(ConstantesWeb.CONST_ATTRIBUTE_PERMISO_SELECCIONADO);

			if(modelAndView != null){//Es una pagina
				
				if(permisoSeleccionado != null){
					for(ModuloSistema modulo : modulos){
						indexModuloSeleccionado++;
						
						for(PermisoSistema permiso : modulo.getPermisoSistema()){
							if(permiso.getUrl().equals(urlMapping)){
								encontrado = Boolean.TRUE;
								break;
							}
						}

						if(encontrado){
							break;
						}
					}
				}
				
				modelAndView.getModelMap().addAttribute(ConstantesWeb.CONST_ATTRIBUTE_INDEX_MODULO_SELECCIONADO, indexModuloSeleccionado);
			}
			
			if(permisoSeleccionado == null){
				logger.info("La url solicitada no existe en BD, verifique las url de los permisos y subpermisos");
			}
			else{
				bitacora = (Bitacora) request.getAttribute(ConstantesWeb.CONST_ATTRIBUTE_INTERCEPTOR_BITACORA);
				
				if(bitacora != null){
					
					request.removeAttribute(ConstantesWeb.CONST_ATTRIBUTE_INTERCEPTOR_BITACORA);
					bitacora.setUsuario(usuario);
					bitacora.setModuloSistema(new ModuloSistema(permisoSeleccionado.getIdModuloSistema()));
					bitacoraDAO.insertarBitacora(bitacora);
				}
			}
			
		}
	}
	
	private PermisoSistema buscarPermiso(List<ModuloSistema> modulos, String urlMapping){
		PermisoSistema permisoSeleccionado = null;
		
		for(ModuloSistema modulo : modulos){
			logger.info(">>>>Modulo:" + modulo.getIdModuloSistema() + ",Descripcion:" +modulo.getDescripcion());
			for(PermisoSistema permiso : modulo.getPermisoSistema()){
				logger.info(">>>>>>>>Permiso:" + permiso.getIdPermisoSistema() + ",Descripcion:" +permiso.getDescripcion());	
				
				if(permiso.getUrl().equals(urlMapping)){
					permisoSeleccionado = permiso;
				}
				else if(permiso.getPermisoSistema() != null){
					
					for(PermisoSistema subPermiso : permiso.getPermisoSistema()){
						logger.info(">>>>>>>>>>>>SubPermiso:" + subPermiso.getIdPermisoSistema() + ",Descripcion:" +subPermiso.getDescripcion());
						if(subPermiso.getUrl().equals(urlMapping)){
							permisoSeleccionado = subPermiso;
							permisoSeleccionado.setIdModuloSistema(permiso.getIdModuloSistema());
							break;
						}
						
					}
				}
				
				if(permisoSeleccionado != null){
					break;
				}
			}
			
			if(permisoSeleccionado != null){
				break;
			}

		}
		return permisoSeleccionado;
	}
	
}
