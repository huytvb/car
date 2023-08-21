package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.Location;
import com.huytvb.car.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	// return list of location
	public List<Location> getLocations() {
		return (List<Location>) locationRepository.findAll();
	}
	

	//save location
	public void save(Location location) {
		locationRepository.save(location);
	}
	
	//get by id
	public Optional<Location> findById(int id) {
		return locationRepository.findById(id);
	}

	//delete location
	public void delete(int id) {
		locationRepository.deleteById(id);
		
	}
}
