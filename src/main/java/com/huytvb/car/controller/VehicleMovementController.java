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

import com.huytvb.car.models.VehicleMovement;
import com.huytvb.car.services.LocationService;
import com.huytvb.car.services.VehicleMovementService;
import com.huytvb.car.services.VehicleService;

@Controller
public class VehicleMovementController {

	@Autowired
	private VehicleMovementService vehicleMovementService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private LocationService locationService;

	@GetMapping("/vehicle-movement")
	public String goVehicleMovement(Model model) {
		model.addAttribute("vehicleMovements", vehicleMovementService.getvehicleMovements());
		model.addAttribute("vehicles", vehicleService.getVehiecles());
		model.addAttribute("locations", locationService.getLocations());

		return "vehicle-movement";
	}

	@PostMapping("/vehicle-movement/addNew")
	public String addNew(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);

		return "redirect:/vehicle-movement";
	}

	@RequestMapping("vehicle-movement/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(int id) {

		return vehicleMovementService.findById(id);
	}

	@RequestMapping(value = "/vehicle-movement/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);

		return "redirect:/vehicle-movement";
	}

	@RequestMapping(value = "/vehicle-movement/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		vehicleMovementService.delete(id);

		return "redirect:/vehicle-movement";
	}
}
