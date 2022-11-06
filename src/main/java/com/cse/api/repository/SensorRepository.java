package com.cse.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cse.api.model.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
	Sensor findById(String contactId);

    Sensor findTopByOrderByIdDesc();
}
