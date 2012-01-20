package com.ciia.webeirinterface.controllers;

import java.util.Map;

import javax.validation.Valid;

import junit.framework.TestCase;

import com.ciia.webeirinterface.forms.LoginForm;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LoginControllerTest extends TestCase{
	
	public final void testEjemplo(){
		int num1 = 3; 
        int num2 = 2; 
        int total = 5; 
        int sum = 0; 
        sum = num1 + num2;
        assertEquals(sum, total); 
	}

}
