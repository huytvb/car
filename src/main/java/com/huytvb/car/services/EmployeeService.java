package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.Employee;
import com.huytvb.car.models.User;
import com.huytvb.car.repositories.EmployeeRepository;
import com.huytvb.car.repositories.UserRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private UserRepository userRepository;

	// return list of Employee
	public List<Employee> getEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	// save Employee
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	// get by id
	public Optional<Employee> findById(int id) {
		return employeeRepository.findById(id);
	}

	// delete Employee
	public void delete(int id) {
		employeeRepository.deleteById(id);

	}

	//get by username
	public Employee findByUsername(String un) {
		return employeeRepository.findByUsername(un);
	}
	
	//Set the Username of the employee where firstname and lastname match
	public void assignUsername(int id){
		Employee employee = employeeRepository.findById(id).orElse(null);
		User user = userRepository.findByFirstnameAndLastname(
				employee.getFirstname(),
				employee.getLastname());
		employee.setUsername(user.getUsername());
		employeeRepository.save(employee);
	}
}
