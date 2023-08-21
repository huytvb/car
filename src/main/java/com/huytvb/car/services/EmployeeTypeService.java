package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.EmployeeType;
import com.huytvb.car.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {

	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;

	// return list of EmployeeType
	public List<EmployeeType> getEmployeeTypes() {
		return (List<EmployeeType>) employeeTypeRepository.findAll();
	}
	
	//save EmployeeType
	public void save(EmployeeType vehicleStatus) {
		employeeTypeRepository.save(vehicleStatus);
	}
	
	//get by id
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeRepository.findById(id);
	}

	//delete EmployeeType
	public void delete(int id) {
		employeeTypeRepository.deleteById(id);
		
	}
}
