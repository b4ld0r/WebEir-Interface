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
@RequestMapping("/imei/")
public class ConsultaIMEIController {
	
	private final String tilesAsignado = "consultaIMEITiles";
	
	private ImeiDAO imeiDao = new ImeiDAO();
	
    @RequestMapping(value="consultaIMEI.htm",method = RequestMethod.GET)
	public String initForm(ModelMap model) {
    	
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_IMEI, new Imei());
		
		return this.tilesAsignado;
	}

	@RequestMapping(value="consultaIMEI.htm",method = RequestMethod.POST)
	public String processForm(@Valid Imei form, BindingResult result, ModelMap model){
		List<Imei> listaImei = new ArrayList<Imei>();

		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_IMEI, form);
		
		if (!result.hasErrors()) {
			try{
				
				Imei imeiConsulta = this.imeiDao.consultarPorImei(form);

				if(imeiConsulta != null){
					
					listaImei.add(imeiConsulta);
				}
				model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_LISTA_IMEI, listaImei);
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return this.tilesAsignado;
	}

}
