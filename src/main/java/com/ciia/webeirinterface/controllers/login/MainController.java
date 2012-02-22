package com.ciia.webeirinterface.controllers.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;

@Controller
@RequestMapping("/inicio/")
public class MainController {
	
	@RequestMapping(value="inicio.htm",method = RequestMethod.GET)
	public String initFormInicio(ModelMap model , HttpServletRequest request) {
		
		if(request.getSession().getAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN) != null ){
			return "principalTiles";
		}
		else{
			return "redirect:../login.htm";
		}
    }
	
	@RequestMapping(value="cierreSesion.htm",method = RequestMethod.GET)
	public String initFormCierre(ModelMap model , HttpServletRequest request) {
		request.getSession().invalidate();
		
		return initFormInicio(model,request);
    }
}
