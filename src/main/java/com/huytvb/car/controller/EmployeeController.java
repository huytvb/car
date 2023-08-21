package com.huytvb.car.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.huytvb.car.models.Employee;
import com.huytvb.car.services.EmployeeService;
import com.huytvb.car.services.StateSerive;
import com.huytvb.car.services.CountryService;
import com.huytvb.car.services.EmployeeTypeService;
import com.huytvb.car.services.JobTitleService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private JobTitleService jobTitleService;
	@Autowired
	private EmployeeTypeService employeeTypeService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private StateSerive stateService;

	public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/assets/uploads/";

	@GetMapping("/employee")
	public String goEmployee(Model model) {

		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("jobTitles", jobTitleService.getJobtitles());
		model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());

		return "employee";
	}

	@PostMapping("/employee/addNew")
	public String addNew(Employee employee) {
		employeeService.save(employee);

		return "redirect:/employee";
	}

	@RequestMapping("employee/findById")
	@ResponseBody
	public Optional<Employee> findById(int id) {

		return employeeService.findById(id);
	}

	@RequestMapping(value = "/employee/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Employee employee) {
		employeeService.save(employee);

		return "redirect:/employee";
	}

	@RequestMapping(value = "/employee/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		employeeService.delete(id);

		return "redirect:/employee";
	}

	// Assign Employee Username
	@RequestMapping(value = "/employee/assignUsername")
	public String assignUsername(int id) {
		employeeService.assignUsername(id);
		return "redirect:/employee";
	}

	// upload avatar
	@PostMapping("/employee/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate date = currentTime.toLocalDate();
		String fileName = file.getOriginalFilename();
		String fileNameDate = date + "_" + fileName;
		
		Path path = Paths.get(UPLOAD_DIRECTORY + fileNameDate);

		try {
			Files.write(path, file.getBytes());
			return ResponseEntity.ok("File uploaded successfully!");
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file!");
		}
	}
}
