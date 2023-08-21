package com.huytvb.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.JobTitle;
import com.huytvb.car.repositories.JobTitleRepository;

@Service
public class JobTitleService {

	@Autowired
	private JobTitleRepository jobTitleRepository;

	// return list of vehicleStatus
	public List<JobTitle> getJobtitles() {
		return (List<JobTitle>) jobTitleRepository.findAll();
	}
	
	//save vehicleStatus
	public void save(JobTitle vehicleStatus) {
		jobTitleRepository.save(vehicleStatus);
	}
	
	//get by id
	public Optional<JobTitle> findById(int id) {
		return jobTitleRepository.findById(id);
	}

	//delete vehicleStatus
	public void delete(int id) {
		jobTitleRepository.deleteById(id);
		
	}
}
