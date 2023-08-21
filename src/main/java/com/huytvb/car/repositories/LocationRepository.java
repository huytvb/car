package com.huytvb.car.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.huytvb.car.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
