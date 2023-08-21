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

import com.huytvb.car.models.VehicleMake;
import com.huytvb.car.services.VehicleMakeService;

@Controller
public class VehicleMakeController {
	
	@Autowired
	private VehicleMakeService vehicleMakeService;

	@GetMapping("/vehicle-make")
	public String goVehicleMake(Model model) {

		List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();

		model.addAttribute("vehicleMakes", vehicleMakeList);

		return "vehicle-make";
	}

	@PostMapping("/vehicle-make/addNew")
	public String addNew(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);

		return "redirect:/vehicle-make";
	}

	@RequestMapping("vehicle-make/findById")
	@ResponseBody
	public Optional<VehicleMake> findById(int id) {

		return vehicleMakeService.findById(id);
	}

	@RequestMapping(value = "/vehicle-make/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);

		return "redirect:/vehicle-make";
	}

	@RequestMapping(value = "/vehicle-make/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		vehicleMakeService.delete(id);

		return "redirect:/vehicle-make";
	}
}
