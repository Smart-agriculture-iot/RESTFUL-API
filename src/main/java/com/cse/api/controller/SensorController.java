package com.cse.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.xml.transform.Templates;

import com.cse.api.exception.ResourceNotFoundException;
import com.cse.api.model.Sensor;
import com.cse.api.repository.SensorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SensorController {

  @Autowired
  private SensorRepository sensorRepository;
  
 
  @PostMapping("/send")
  public Sensor createdata(@Valid @RequestBody Sensor sensor) throws ResourceNotFoundException {
    return sensorRepository.save(sensor);
  }

  @GetMapping("/retrieve")
  public List<Sensor> getAllData() {
    return sensorRepository.findAll();
  }  
};