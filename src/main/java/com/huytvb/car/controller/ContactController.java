package com.huytvb.car.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huytvb.car.models.Contact;
import com.huytvb.car.services.ContactService;
@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;


	@GetMapping("/contact")
	public String goContact(Model model) {
		model.addAttribute("contacts", contactService.getContacts());

		return "contact";
	}

	@PostMapping("/contact/addNew")
	public String addNew(Contact contact) {
		contactService.save(contact);

		return "redirect:/contact";
	}

	@RequestMapping("contact/findById")
	@ResponseBody
	public Optional<Contact> findById(int id) {

		return contactService.findById(id);
	}

	@RequestMapping(value = "/contact/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Contact contact) {
		contactService.save(contact);

		return "redirect:/contact";
	}

	@RequestMapping(value = "/contact/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		contactService.delete(id);

		return "redirect:/contact";
	}
}
