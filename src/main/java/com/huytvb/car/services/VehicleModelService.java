package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.VehicleModel;
import com.huytvb.car.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {

	@Autowired
	private VehicleModelRepository vehicleModelRepository;

	// return list of VehicleModel
	public List<VehicleModel> getVehicleModels() {
		return (List<VehicleModel>) vehicleModelRepository.findAll();
	}
	
	//save VehicleModel
	public void save(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}
	
	//get by id
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelRepository.findById(id);
	}

	//delete VehicleModel
	public void delete(int id) {
		vehicleModelRepository.deleteById(id);
		
	}
}
