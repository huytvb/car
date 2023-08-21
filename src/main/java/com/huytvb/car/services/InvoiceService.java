package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.Invoice;
import com.huytvb.car.repositories.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceSepository;

	// return list of invoice
	public List<Invoice> getInvoice() {

		return invoiceSepository.findAll();
	}
	

	//save invoice
	public void save(Invoice invoice) {
		invoiceSepository.save(invoice);
	}
	
	//get by id
	public Optional<Invoice> findById(int id) {
		return invoiceSepository.findById(id);
	}

	//delete invoice
	public void delete(int id) {
		invoiceSepository.deleteById(id);
		
	}
}
