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

import com.huytvb.car.models.VehicleHire;
import com.huytvb.car.services.ClientService;
import com.huytvb.car.services.LocationService;
import com.huytvb.car.services.VehicleHireService;
import com.huytvb.car.services.VehicleService;

@Controller
public class VehicleHireController {
	
	@Autowired
	private VehicleHireService vehicleHireService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private ClientService clientService;

	@GetMapping("/vehicle-hire")
	public String goVehicleHire(Model model) {

		model.addAttribute("vehicleHires", vehicleHireService.getVehicleHires());
		model.addAttribute("vehicles", vehicleService.getVehiecles());
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("clients", clientService.findAll());

		return "vehicle-hire";
	}

	@PostMapping("/vehicle-hire/addNew")
	public String addNew(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);

		return "redirect:/vehicle-hire";
	}

	@RequestMapping("vehicle-hire/findById")
	@ResponseBody
	public Optional<VehicleHire> findById(int id) {

		return vehicleHireService.findById(id);
	}

	@RequestMapping(value = "/vehicle-hire/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);

		return "redirect:/vehicle-hire";
	}

	@RequestMapping(value = "/vehicle-hire/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		vehicleHireService.delete(id);

		return "redirect:/vehicle-hire";
	}
}
