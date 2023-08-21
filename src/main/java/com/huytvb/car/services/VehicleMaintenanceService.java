package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.VehicleMaintenance;
import com.huytvb.car.repositories.VehicleMaintenanceRepository;

@Service
public class VehicleMaintenanceService {
	
	@Autowired
	private VehicleMaintenanceRepository vehicleMaintenanceRepository;

	// return list of states
	public List<VehicleMaintenance> getVehicleMaintenances() {

		return vehicleMaintenanceRepository.findAll();
	}
	
	//save states
	public void save(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}
	
	//get by id
	public Optional<VehicleMaintenance> findById(int id) {
		return vehicleMaintenanceRepository.findById(id);
	}

	//delete states
	public void delete(int id) {
		vehicleMaintenanceRepository.deleteById(id);
		
	}
}
