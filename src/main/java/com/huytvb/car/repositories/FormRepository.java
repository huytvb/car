package com.huytvb.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huytvb.car.models.Form;

@Repository
public interface FormRepository extends JpaRepository<Form, Integer>{

}
