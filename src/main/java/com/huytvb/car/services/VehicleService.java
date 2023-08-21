package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.Vehicle;
import com.huytvb.car.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	// return list of countries
	public List<Vehicle> getVehiecles() {

		return vehicleRepository.findAll();
	}

	// save states
	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	// get by id
	public Optional<Vehicle> findById(int id) {
		return vehicleRepository.findById(id);
	}

	// delete states
	public void delete(int id) {
		vehicleRepository.deleteById(id);

	}
}
