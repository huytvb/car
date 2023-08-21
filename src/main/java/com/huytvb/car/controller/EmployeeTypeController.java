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

import com.huytvb.car.models.EmployeeType;
import com.huytvb.car.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {
	
	@Autowired
	private EmployeeTypeService employeeTypeService;

	@GetMapping("/employee-type")
	public String goEmployeeType(Model model) {

		List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();

		model.addAttribute("employeeTypes", employeeTypeList);

		return "employee-type";
	}

	@PostMapping("/employee-type/addNew")
	public String addNew(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);

		return "redirect:/employee-type";
	}

	@RequestMapping("employee-type/findById")
	@ResponseBody
	public Optional<EmployeeType> findById(int id) {

		return employeeTypeService.findById(id);
	}

	@RequestMapping(value = "/employee-type/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);

		return "redirect:/employee-type";
	}

	@RequestMapping(value = "/employee-type/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		employeeTypeService.delete(id);

		return "redirect:/employee-type";
	}
}
