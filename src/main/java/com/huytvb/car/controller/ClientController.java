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

import com.huytvb.car.models.Client;
import com.huytvb.car.services.ClientService;
import com.huytvb.car.services.CountryService;
import com.huytvb.car.services.StateSerive;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private StateSerive stateService;
	@Autowired 
	private CountryService countryService;


	@GetMapping("/client")
	public String goClient(Model model) {

		model.addAttribute("clients", clientService.findAll());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("countries", countryService.getCountries());

		return "client";
	}

	@PostMapping("/client/addNew")
	public String addNew(Client client) {
		clientService.save(client);

		return "redirect:/client";
	}

	@RequestMapping("client/findById")
	@ResponseBody
	public Optional<Client> findById(int id) {

		return clientService.findById(id);
	}

	@RequestMapping(value = "/client/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Client client) {
		clientService.save(client);

		return "redirect:/client";
	}

	@RequestMapping(value = "/client/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		clientService.delete(id);

		return "redirect:/client";
	}
}
