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

import com.huytvb.car.models.VehicleType;
import com.huytvb.car.services.VehicleTypeService;

@Controller
public class VehicleTypeController {

	@Autowired
	private VehicleTypeService vehicleTypeService;

	@GetMapping("/vehicle-type")
	public String goVehicleType(Model model) {

		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();

		model.addAttribute("vehicleTypes", vehicleTypeList);

		return "vehicle-type";
	}

	@PostMapping("/vehicle-type/addNew")
	public String addNew(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);

		return "redirect:/vehicle-type";
	}

	@RequestMapping("vehicle-type/findById")
	@ResponseBody
	public Optional<VehicleType> findById(int id) {

		return vehicleTypeService.findById(id);
	}

	@RequestMapping(value = "/vehicle-type/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);

		return "redirect:/vehicle-type";
	}

	@RequestMapping(value = "/vehicle-type/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		vehicleTypeService.delete(id);

		return "redirect:/vehicle-type";
	}
}
