package com.huytvb.car.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huytvb.car.models.Form;
import com.huytvb.car.services.FormService;

@Controller
public class FormController {

	@Autowired
	private FormService formService;
	
	@GetMapping("/form/Edit/{id}")
	public String editForm(@PathVariable Integer id, Model model) {
		Form form = formService.findById(id);
		model.addAttribute("form", form);

		return "form-edit";
	}
	
	@GetMapping("/form")
	public String goForm(Model model) {
		model.addAttribute("forms", formService.findAll());

		return "form";
	}

	@PostMapping("/form/addNew")
	public String addNew(Form form) {
		formService.save(form);

		return "redirect:/form";
	}

	@RequestMapping("form/findById")
	@ResponseBody
	public Optional<Form> findById(int id) {

		return formService.findByIdOptional(id);
	}

	@RequestMapping(value = "/form/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Form form) {
		formService.save(form);

		return "redirect:/form";
	}

	@RequestMapping(value = "/form/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		formService.delete(id);

		return "redirect:/form";
	}
}
