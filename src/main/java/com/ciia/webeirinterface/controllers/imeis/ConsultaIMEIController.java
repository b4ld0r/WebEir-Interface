package com.ciia.webeirinterface.controllers.imeis;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.model.imeis.ConsultaIMEI;
import com.ciia.webeirinterface.model.imeis.IMEI;

@Controller
@RequestMapping("consultaIMEI.htm")
public class ConsultaIMEIController {
	
	private final String tilesAsignado = "consultaIMEITiles";
	private final String nombrePagina = "Consultar IMEI";
	
    @RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
    	
    	model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_CONSULTA_IMEI, new ConsultaIMEI());
		return this.tilesAsignado;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid ConsultaIMEI form, BindingResult result, ModelMap model) {
		List<IMEI> listaIMEI = new ArrayList<IMEI>();
		
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_CONSULTA_IMEI, form);
		
		if (!result.hasErrors()) {
			if(form.getImei().equals("111111111111")){
				listaIMEI.add(new IMEI(new Long(1),"123456789"));
				form.setListaIMEIS(listaIMEI);
			}
			return this.tilesAsignado;
		}
		
		return this.tilesAsignado;
	}

}
