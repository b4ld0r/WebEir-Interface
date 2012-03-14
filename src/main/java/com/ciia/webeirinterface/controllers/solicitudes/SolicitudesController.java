/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciia.webeirinterface.controllers.solicitudes;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.dao.SolicitudDAO;
import com.ciia.webeirinterface.model.db.Solicitud;
import com.ciia.webeirinterface.model.db.Solicitud;
import com.ciia.webeirinterface.model.json.PaginaGrid;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Sergio
 */
@Controller
@RequestMapping("/solicitudes/")
public class SolicitudesController {
	
	private final String tilesAsignado = "solicitudesTiles";
	
	SolicitudDAO solicitudDAO=new SolicitudDAO();
	
	@RequestMapping(value="solicitudes.htm",method = RequestMethod.GET)
	public String init(ModelMap model) {
		return this.tilesAsignado;
	}
	
	@RequestMapping(value="obtenUsuarios.htm",method = RequestMethod.GET)
	 public @ResponseBody PaginaGrid<Solicitud> listaUsuarios(
      @RequestParam(value = "page", required = false, defaultValue = "1") int page,
      @RequestParam(value = "max", required = false, defaultValue = "20") int max,
	  @RequestParam(value = "sord", required = false, defaultValue = "solicitudesT_nombre") String sord,
	  @RequestParam(value = "sidx", required = false, defaultValue = "asc") String sidx) {
		try {
			sidx=(sidx!=null && !sidx.isEmpty()?sidx.split("_")[1]:ConstantesWeb.CONST_SORT_FIELD_USUARIO) +" "+sord;
			List<Solicitud> solicitudes=solicitudDAO.consultarSolicitud(max*(page-1), max, sidx);
			return new PaginaGrid<Solicitud>(solicitudes, page, solicitudDAO.consultarSolicitud().size(), max);
		} catch (Exception ex) {
		}
		return new PaginaGrid<Solicitud>();
	}
}
