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

import com.huytvb.car.models.Vehicle;
import com.huytvb.car.services.EmployeeService;
import com.huytvb.car.services.LocationService;
import com.huytvb.car.services.VehicleMakeService;
import com.huytvb.car.services.VehicleModelService;
import com.huytvb.car.services.VehicleService;
import com.huytvb.car.services.VehicleStatusService;
import com.huytvb.car.services.VehicleTypeService;

@Controller
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private LocationService locationService;
	@Autowired 
	private EmployeeService employeeService;
	@Autowired
	private VehicleMakeService vehicleMakeService;
	@Autowired
	private VehicleStatusService vehicleStatusService;
	@Autowired 
	private VehicleTypeService vehicleTypeService;
	@Autowired 
	private VehicleModelService vehicleModelService;
	

	@GetMapping("/vehicle")
	public String goVehicle(Model model) {

		model.addAttribute("vehicles", vehicleService.getVehiecles());
		model.addAttribute("locations", locationService.getLocations());
		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
		model.addAttribute("vehicleStatus", vehicleStatusService.getVehicleStatus());
		model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
		model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());

		return "vehicle";
	}

	@PostMapping("/vehicle/addNew")
	public String addNew(Vehicle vehicle) {
		vehicleService.save(vehicle);

		return "redirect:/vehicle";
	}

	@RequestMapping("vehicle/findById")
	@ResponseBody
	public Optional<Vehicle> findById(int id) {

		return vehicleService.findById(id);
	}

	@RequestMapping(value = "/vehicle/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Vehicle vehicle) {
		vehicleService.save(vehicle);

		return "redirect:/vehicle";
	}

	@RequestMapping(value = "/vehicle/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		vehicleService.delete(id);

		return "redirect:/vehicle";
	}
}
