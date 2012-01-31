package com.ciia.webeirinterface.controllers.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.model.login.Login;

@Controller
@RequestMapping("inicio.htm")
public class MainController {
	/*
	public ModelMap foo(@ModelAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN) Login l) {
	    return new ModelMap(l); 
	}*/
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model , HttpServletRequest request) {
		
		if(request.getSession().getAttribute(ConstantesWeb.CONST_ATTRIBUTE_LOGIN) != null ){
			return "principalTiles";
		}
		else{
			return "redirect:login.htm";
		}
    }
}
