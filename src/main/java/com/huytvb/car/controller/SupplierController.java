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

import com.huytvb.car.models.Supplier;
import com.huytvb.car.services.CountryService;
import com.huytvb.car.services.StateSerive;
import com.huytvb.car.services.SupplierService;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private StateSerive stateService;
	@Autowired 
	private CountryService countryService;


	@GetMapping("/supplier")
	public String goSupplier(Model model) {

		model.addAttribute("suppliers", supplierService.getSupplier());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("countries", countryService.getCountries());

		return "supplier";
	}

	@PostMapping("/supplier/addNew")
	public String addNew(Supplier supplier) {
		supplierService.save(supplier);

		return "redirect:/supplier";
	}

	@RequestMapping("supplier/findById")
	@ResponseBody
	public Optional<Supplier> findById(int id) {

		return supplierService.findById(id);
	}

	@RequestMapping(value = "/supplier/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Supplier supplier) {
		supplierService.save(supplier);

		return "redirect:/supplier";
	}

	@RequestMapping(value = "/supplier/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		supplierService.delete(id);

		return "redirect:/supplier";
	}
}
