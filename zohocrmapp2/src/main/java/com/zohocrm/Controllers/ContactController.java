package com.zohocrm.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zohocrm.Entities.Contact;
import com.zohocrm.Services.ContactService;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;
    
	@RequestMapping("/listContacts")
	public String listContact(Model model) {
		List<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contacts";
	}
}
