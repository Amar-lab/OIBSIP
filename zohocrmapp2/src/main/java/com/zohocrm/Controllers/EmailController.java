package com.zohocrm.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.Services.EmailService;

@Controller
public class EmailController {
     
	@Autowired
	private EmailService emailService;
	@RequestMapping("/composeEmail")
	public String composeEmail(@RequestParam("email")String email,Model model) {
		model.addAttribute("email",email);
		return "compose_email";
	}
	@RequestMapping("/sendEmail")
	public String sendEmail(@RequestParam("to")String to,@RequestParam("sub")String sub,@RequestParam("msg")String msg,Model model) {
		emailService.sendEmail(to,sub,msg);
		model.addAttribute("msg", "mail send !!");
		return "compose_email";
	}
}
