package com.ciia.webeirinterface.controllers.catalogos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.model.catalogos.Escenario;
import com.ciia.webeirinterface.model.catalogos.Motivo;

@Controller
@RequestMapping("escenarios.htm")
public class EscenarioController {
	
	private final String tilesAsignado = "escenarioTiles";
	private final String nombrePagina = "Registrar Escenario";
	
    @RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
    	Escenario escenario = new Escenario();
    	
    	List<Motivo> motivos = new ArrayList<Motivo>();
    	
    	escenario.setMotivos(motivos);
    	
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_ESCENARIO, escenario);
		return this.tilesAsignado;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid Escenario form, BindingResult result, ModelMap model) {
		
		//form = (Escenario) model.get(ConstantesWeb.CONST_ATTRIBUTE_ESCENARIO);
		if(form.getMotivos() != null){
			for (Motivo motivo : form.getMotivos()) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + motivo.getDescripcion());
			}
		}
		
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_ESCENARIO, form);
		if (!result.hasErrors()) {
			//model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_ESCENARIO, form);
		}
		
		return tilesAsignado;
	}


}
