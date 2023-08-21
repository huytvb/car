package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.VehicleType;
import com.huytvb.car.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {
	
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;

	// return list of vehicleType
	public List<VehicleType> getVehicleTypes() {
		return (List<VehicleType>) vehicleTypeRepository.findAll();
	}
	
	//save vehicleType
	public void save(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}
	
	//get by id
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeRepository.findById(id);
	}

	//delete vehicleType
	public void delete(int id) {
		vehicleTypeRepository.deleteById(id);
		
	}

}
