package com.ciia.webeirinterface.controllers;

import java.util.Map;

import javax.validation.Valid;

import com.ciia.webeirinterface.forms.LoginForm;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("loginForm.htm")
public class LoginController {
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map<String,Object> model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result,
			Map<String,Object> model) {
		String userName = "a";
		String password = "a";
		if (result.hasErrors()) {
			return "loginForm";
		}
		loginForm = (LoginForm) model.get("loginForm");
		if (!loginForm.getUserName().equals(userName)
				|| !loginForm.getPassword().equals(password)) {
			return "loginForm";
		}
		model.put("mainForm", loginForm);
		return "mainForm";
	}

}
