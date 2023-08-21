package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.VehicleHire;
import com.huytvb.car.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {

	@Autowired
	private VehicleHireRepository vehicleHireRepository;

	// return list of VehicleHire
	public List<VehicleHire> getVehicleHires() {
		return (List<VehicleHire>) vehicleHireRepository.findAll();
	}
	
	//save VehicleHire
	public void save(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
	}
	
	//get by id
	public Optional<VehicleHire> findById(int id) {
		return vehicleHireRepository.findById(id);
	}

	//delete VehicleHire
	public void delete(int id) {
		vehicleHireRepository.deleteById(id);
	}
}
