package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.Contact;
import com.huytvb.car.repositories.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	// return list of states
	public List<Contact> getContacts() {

		return contactRepository.findAll();
	}
	
	//save states
	public void save(Contact contact) {
		contactRepository.save(contact);
	}
	
	//get by id
	public Optional<Contact> findById(int id) {
		return contactRepository.findById(id);
	}

	//delete states
	public void delete(int id) {
		contactRepository.deleteById(id);
		
	}

}
