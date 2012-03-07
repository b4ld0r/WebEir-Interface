/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciia.webeirinterface.controllers.solicitudes;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Sergio
 */
@Controller
@RequestMapping("/solicitudes/")
public class SolicitudesController {
	
	private final String tilesAsignado = "solicitudesTiles";
	
	@RequestMapping(value="solicitudes.htm",method = RequestMethod.GET)
	public String init(ModelMap model) {
		return this.tilesAsignado;
	}
}
