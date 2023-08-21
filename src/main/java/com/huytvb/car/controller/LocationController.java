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
import com.huytvb.car.models.Location;
import com.huytvb.car.models.State;
import com.huytvb.car.services.CountryService;
import com.huytvb.car.services.LocationService;
import com.huytvb.car.services.StateSerive;

@Controller
public class LocationController {


	@Autowired
	private StateSerive stateService;
	@Autowired 
	private CountryService countryService;
	@Autowired
	private LocationService locationService;

	@GetMapping("/location")
	public String goLocation(Model model) {

		List<Location> locationList = locationService.getLocations();
		List<State> stateList = stateService.getStates();
		List<Country> countryList = countryService.getCountries();

		model.addAttribute("locations", locationList);
		model.addAttribute("states", stateList);
		model.addAttribute("countries", countryList);

		return "location";
	}

	@PostMapping("/locations/addNew")
	public String addNew(Location location) {
		locationService.save(location);

		return "redirect:/location";
	}

	@RequestMapping("locations/findById")
	@ResponseBody
	public Optional<Location> findById(int id) {

		return locationService.findById(id);
	}

	@RequestMapping(value = "/locations/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Location location) {
		locationService.save(location);

		return "redirect:/location";
	}

	@RequestMapping(value = "/locations/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		locationService.delete(id);

		return "redirect:/location";
	}
}
