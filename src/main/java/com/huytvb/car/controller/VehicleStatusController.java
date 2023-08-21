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

import com.huytvb.car.models.VehicleStatus;
import com.huytvb.car.services.VehicleStatusService;

@Controller
public class VehicleStatusController {
	
	@Autowired
	private VehicleStatusService vehicleStatusService;

	@GetMapping("/vehicle-status")
	public String goVehicleStatus(Model model) {

		List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatus();

		model.addAttribute("vehicleStatus", vehicleStatusList);

		return "vehicle-status";
	}

	@PostMapping("/vehicle-status/addNew")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);

		return "redirect:/vehicle-status";
	}

	@RequestMapping("vehicle-status/findById")
	@ResponseBody
	public Optional<VehicleStatus> findById(int id) {

		return vehicleStatusService.findById(id);
	}

	@RequestMapping(value = "/vehicle-status/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);

		return "redirect:/vehicle-status";
	}

	@RequestMapping(value = "/vehicle-status/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		vehicleStatusService.delete(id);

		return "redirect:/vehicle-status";
	}
}
