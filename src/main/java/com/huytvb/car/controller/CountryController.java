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
import com.huytvb.car.services.CountryService;


@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/contries")
	public String goContries(Model model) {
		
		List<Country> countryList = countryService.getCountries();
		
		model.addAttribute("countries",countryList);
		
		return "country";
	}
	
	@PostMapping("/countries/addNew")
	public String addNew(Country country) {
		countryService.save(country);
		
		return "redirect:/contries";
	}
	
	@RequestMapping("contries/findById")
	@ResponseBody
	public Optional<Country> findById(int id){
		
		return countryService.findById(id);
	}
	
	@RequestMapping(value="/countries/update" ,method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Country country) {
		countryService.save(country);
		
		return "redirect:/contries";
	}
	

	@RequestMapping(value="/contries/delete" ,method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(int id) {
		countryService.delete(id);
		
		return "redirect:/contries";
	}
}
