package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.State;
import com.huytvb.car.repositories.StateRepository;

@Service
public class StateSerive {

	@Autowired
	private StateRepository stateRepository;

	// return list of states
	public List<State> getStates() {

		return stateRepository.findAll();
	}
	

	//save states
	public void save(State state) {
		stateRepository.save(state);
	}
	
	//get by id
	public Optional<State> findById(int id) {
		return stateRepository.findById(id);
	}

	//delete states
	public void delete(int id) {
		stateRepository.deleteById(id);
		
	}
}
