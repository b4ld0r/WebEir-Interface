package ejemplo;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class ContactForm {
	@NotEmpty
	private String dato;
	
	private List<Contact> contacts;     
	
	public void setDato(String dato) {
		this.dato = dato;
	}

	public String getDato() {
		return dato;
	}

	public List<Contact> getContacts() {        
		return contacts;    
	}     
	
	public void setContacts(List<Contact> contacts) {        
		this.contacts = contacts;    
	}
}
