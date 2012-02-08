package com.ciia.webeirinterface.controllers.ejemplo;

import java.util.ArrayList;
import java.util.List; 

import javax.validation.Valid;

import ejemplo.Contact;
import ejemplo.ContactForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.AutoPopulatingList;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView; 

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.model.catalogos.Escenario;
import com.ciia.webeirinterface.model.catalogos.Motivo;
@Controller
@RequestMapping("contactos.htm")
public class ContactController {     
	//private static List<Contact> contacts = new ArrayList<Contact>();     
	static {        
		/*
		contacts.add(new Contact("Barack", "Obama", "barack.o@whitehouse.com", "147-852-965"));        
		contacts.add(new Contact("George", "Bush", "george.b@whitehouse.com", "785-985-652"));        
		contacts.add(new Contact("Bill", "Clinton", "bill.c@whitehouse.com", "236-587-412"));        
		contacts.add(new Contact("Ronald", "Reagan", "ronald.r@whitehouse.com", "369-852-452"));
		*/    
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		ContactForm contactForm = new ContactForm();
		
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact("Barack", "Obama", "barack.o@whitehouse.com", "147-852-965"));        
		contacts.add(new Contact("Karen", "Bush", "george.b@whitehouse.com", "785-985-652"));        
		contacts.add(new Contact("Bill", "Clinton", "bill.c@whitehouse.com", "236-587-412"));        
		contacts.add(new Contact("Ronald", "Reagan", "ronald.r@whitehouse.com", "369-852-452"));
		
		contactForm.setContacts(contacts);         
		
		
		
		model.addAttribute("contactForm", contactForm);
		return "add_contact";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid ContactForm form,BindingResult result, ModelMap model) {
		List<Contact> contacts = form.getContacts();
		
		model.addAttribute("contactForm", form);
		
		if(null != contacts && contacts.size() > 0) {            
			for (Contact contact : contacts) {                
				
				System.out.printf("%s \t %s \n", contact.getFirstname(), contact.getLastname());            
			}        
		}         
		return "add_contact"; 
	}
}
