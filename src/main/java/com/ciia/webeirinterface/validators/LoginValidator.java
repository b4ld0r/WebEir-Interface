package com.ciia.webeirinterface.validators;

import com.ciia.webeirinterface.forms.LoginForm;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class LoginValidator implements Validator{
	LoginForm login;
	
	@Override
	public boolean supports(Class clazz) {
        return LoginForm.class.isAssignableFrom(clazz);
    }
	
	@Override
    public void validate(Object commandObject, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName","Campo requerido.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","Campo requerido.");
 
        login = (LoginForm) commandObject;
 
        if ((login.getPassword() != "password")&&
            (login.getUserName() != "partha")){
            errors.reject("Usuario y password incorrecto.");
        }
    }


}
