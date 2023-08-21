package com.huytvb.car.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huytvb.car.models.Country;
import com.huytvb.car.models.State;
import com.huytvb.car.services.CountryService;
import com.huytvb.car.services.StateSerive;

@Controller
public class StateController {

	@Autowired
	private StateSerive stateService;
	@Autowired 
	private CountryService countryService;

	@GetMapping("/state")
	public String goState(Model model) {

		List<State> stateList = stateService.getStates();
		List<Country> countryList = countryService.getCountries();

		model.addAttribute("states", stateList);
		model.addAttribute("countries", countryList);

		return "state";
	}

	@PostMapping("/states/addNew")
	public String addNew(State state) {
		stateService.save(state);

		return "redirect:/state";
	}

	@RequestMapping("states/findById")
	@ResponseBody
	public Optional<State> findById(int id) {

		return stateService.findById(id);
	}

	@RequestMapping(value = "/states/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(State state) {
		stateService.save(state);

		return "redirect:/state";
	}

	@RequestMapping(value = "/states/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		stateService.delete(id);

		return "redirect:/state";
	}
}
