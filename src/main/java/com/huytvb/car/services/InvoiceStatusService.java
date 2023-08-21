package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.InvoiceStatus;
import com.huytvb.car.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {
	
	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;

	// return list of InvoiceStatus
	public List<InvoiceStatus> getInvoiceStatus() {
		return (List<InvoiceStatus>) invoiceStatusRepository.findAll();
	}
	
	//save invoiceStatus
	public void save(InvoiceStatus vehicleStatus) {
		invoiceStatusRepository.save(vehicleStatus);
	}
	
	//get by id
	public Optional<InvoiceStatus> findById(int id) {
		return invoiceStatusRepository.findById(id);
	}

	//delete invoiceStatus
	public void delete(int id) {
		invoiceStatusRepository.deleteById(id);
		
	}
}
