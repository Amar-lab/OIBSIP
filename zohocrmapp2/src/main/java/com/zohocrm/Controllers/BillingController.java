package com.zohocrm.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.Entities.Billing;
import com.zohocrm.Entities.Contact;
import com.zohocrm.Services.BillingService;
import com.zohocrm.Services.ContactService;

@Controller
public class BillingController {
    @Autowired
    private ContactService contactService;
     
    @Autowired
    private BillingService billingService;
    
	@RequestMapping("/createBill")
	public String generateBill(@RequestParam("id")long id,Model model) {
		Contact contact = contactService.getContactById(id);
		model.addAttribute("contact", contact);
		return "billing_generate";
	}
	@RequestMapping("/saveBill")
	public String saveBill(@ModelAttribute("bill")Billing bill,Model model) {
		billingService.saveBill(bill);
		
		List<Billing> bills = billingService.getAllBills();
		model.addAttribute("bills", bills);
		return "list_bill";
		
		
	}
	@RequestMapping("/listBills")
	public String listBill(Model model) {
		List<Billing> bills = billingService.getAllBills();
		model.addAttribute("bills", bills);
		return "list_bill";
	}
}
