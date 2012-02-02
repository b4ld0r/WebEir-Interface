package com.ciia.webeirinterface.controllers.catalogos;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.model.catalogos.Escenario;

@Controller
@RequestMapping("escenarios.htm")
public class EscenarioController {
	
	private final String tilesAsignado = "escenarioTiles";
	private final String nombrePagina = "Registrar Escenario";
	
    @RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_ESCENARIO, new Escenario());
		return this.tilesAsignado;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid Escenario form, BindingResult result, ModelMap model) {
		
		form = (Escenario) model.get(ConstantesWeb.CONST_ATTRIBUTE_ESCENARIO);
		
		if (!result.hasErrors()) {
			model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, form);
		}
		
		return tilesAsignado;
	}


}
