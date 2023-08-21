package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.Country;
import com.huytvb.car.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	//return list of countries
	public List<Country> getCountries(){
		
		return countryRepository.findAll();
	}
	
	//save countries
	public void save(Country country) {
		countryRepository.save(country);
	}
	
	//get by id
	public Optional<Country> findById(int id) {
		return countryRepository.findById(id);
	}

	public void delete(int id) {
		countryRepository.deleteById(id);
		
	}
}
