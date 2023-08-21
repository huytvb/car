package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.Supplier;
import com.huytvb.car.repositories.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;

	// return list of Supplier
	public List<Supplier> getSupplier() {

		return supplierRepository.findAll();
	}
	
	//save Supplier
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
	//get by id
	public Optional<Supplier> findById(int id) {
		return supplierRepository.findById(id);
	}

	//delete Supplier
	public void delete(int id) {
		supplierRepository.deleteById(id);
		
	}
}
