package com.huytvb.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huytvb.car.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
