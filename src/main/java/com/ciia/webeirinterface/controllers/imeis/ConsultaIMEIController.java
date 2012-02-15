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
import com.ciia.webeirinterface.dao.ImeiDAO;
import com.ciia.webeirinterface.model.db.Imei;

@Controller
@RequestMapping("consultaIMEI.htm")
public class ConsultaIMEIController {
	
	private final String tilesAsignado = "consultaIMEITiles";
	private final String nombrePagina = "Consultar IMEI";
	
    @RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
    	
    	model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_IMEI, new Imei());
		return this.tilesAsignado;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid Imei form, BindingResult result, ModelMap model){
		
		List<Imei> listaIMEI;
		
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_IMEI, form);
		
		if (!result.hasErrors()) {
			try{
				
				ImeiDAO imeiDao = new ImeiDAO();
				Imei imeiConsulta = imeiDao.consultaPorImei(form);
				listaIMEI = new ArrayList<Imei>();

				if(imeiConsulta != null){
					listaIMEI.add(imeiConsulta);
				}
				model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_LISTA_IMEI, listaIMEI);
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return this.tilesAsignado;
	}

}
