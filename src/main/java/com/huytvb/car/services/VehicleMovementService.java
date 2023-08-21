package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.VehicleMovement;
import com.huytvb.car.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {

	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;

	// return list of VehicleMovement
	public List<VehicleMovement> getvehicleMovements() {
		return (List<VehicleMovement>) vehicleMovementRepository.findAll();
	}
	
	//save VehicleMovement
	public void save(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);
	}
	
	//get by id
	public Optional<VehicleMovement> findById(int id) {
		return vehicleMovementRepository.findById(id);
	}

	//delete VehicleMovement
	public void delete(int id) {
		vehicleMovementRepository.deleteById(id);
		
	}
}
