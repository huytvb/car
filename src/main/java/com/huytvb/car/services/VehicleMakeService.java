package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.VehicleMake;
import com.huytvb.car.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {
	
	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;

	// return list of vehicleMake
	public List<VehicleMake> getVehicleMakes() {
		return (List<VehicleMake>) vehicleMakeRepository.findAll();
	}
	

	//save vehicleMake
	public void save(VehicleMake vehicle) {
		vehicleMakeRepository.save(vehicle);
	}
	
	//get by id
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeRepository.findById(id);
	}

	//delete vehicleMake
	public void delete(int id) {
		vehicleMakeRepository.deleteById(id);
		
	}

}
