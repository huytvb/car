package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.Form;
import com.huytvb.car.repositories.FormRepository;

@Service
public class FormService {

	@Autowired
	private FormRepository formRepository;

	// Get All Form
	public List<Form> findAll() {
		return formRepository.findAll();
	}

	// Get Form By Id
	public Form findById(int id) {
		return formRepository.findById(id).orElse(null);
	}
	
	//get by id
		public Optional<Form> findByIdOptional(int id) {
			return formRepository.findById(id);
		}

	// Delete Form
	public void delete(int id) {
		formRepository.deleteById(id);
	}

	// Update Form
	public void save(Form client) {
		formRepository.save(client);
	}

}
