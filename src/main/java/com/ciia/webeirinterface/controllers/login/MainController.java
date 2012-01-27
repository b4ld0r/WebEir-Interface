package com.ciia.webeirinterface.controllers.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("inicio.htm")
public class MainController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		return "redirect:login.htm";
    }
}
