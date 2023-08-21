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

import com.huytvb.car.models.VehicleModel;
import com.huytvb.car.services.VehicleModelService;

@Controller
public class VehicleModelController {

	@Autowired
	private VehicleModelService vehicleModelService;

	@GetMapping("/vehicle-model")
	public String goVehicleModel(Model model) {

		List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();

		model.addAttribute("vehicleModels", vehicleModelList);

		return "vehicle-model";
	}

	@PostMapping("/vehicle-model/addNew")
	public String addNew(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);

		return "redirect:/vehicle-model";
	}

	@RequestMapping("vehicle-model/findById")
	@ResponseBody
	public Optional<VehicleModel> findById(int id) {

		return vehicleModelService.findById(id);
	}

	@RequestMapping(value = "/vehicle-model/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);

		return "redirect:/vehicle-model";
	}

	@RequestMapping(value = "/vehicle-model/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		vehicleModelService.delete(id);

		return "redirect:/vehicle-model";
	}
}
