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

import com.huytvb.car.models.VehicleMaintenance;
import com.huytvb.car.services.SupplierService;
import com.huytvb.car.services.VehicleMaintenanceService;
import com.huytvb.car.services.VehicleService;

@Controller
public class VehicleMaintenanceController {
	
	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private SupplierService suplierService;

	@GetMapping("/vehicle-maintenance")
	public String goVehicleMaintenance(Model model) {
		model.addAttribute("vehicleMaintenances", vehicleMaintenanceService.getVehicleMaintenances());
		model.addAttribute("vehicles", vehicleService.getVehiecles());
		model.addAttribute("suppliers", suplierService.getSupplier());

		return "vehicle-maintenance";
	}

	@PostMapping("/vehicle-maintenance/addNew")
	public String addNew(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);

		return "redirect:/vehicle-maintenance";
	}

	@RequestMapping("vehicle-maintenance/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> findById(int id) {

		return vehicleMaintenanceService.findById(id);
	}

	@RequestMapping(value = "/vehicle-maintenance/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);

		return "redirect:/vehicle-maintenance";
	}

	@RequestMapping(value = "/vehicle-maintenance/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		vehicleMaintenanceService.delete(id);

		return "redirect:/vehicle-maintenance";
	}
}
