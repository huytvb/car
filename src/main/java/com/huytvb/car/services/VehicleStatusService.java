package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.VehicleStatus;
import com.huytvb.car.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {

	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;

	// return list of vehicleStatus
	public List<VehicleStatus> getVehicleStatus() {
		return (List<VehicleStatus>) vehicleStatusRepository.findAll();
	}
	
	//save vehicleStatus
	public void save(VehicleStatus vehicleStatus) {
		vehicleStatusRepository.save(vehicleStatus);
	}
	
	//get by id
	public Optional<VehicleStatus> findById(int id) {
		return vehicleStatusRepository.findById(id);
	}

	//delete vehicleStatus
	public void delete(int id) {
		vehicleStatusRepository.deleteById(id);
		
	}
}
