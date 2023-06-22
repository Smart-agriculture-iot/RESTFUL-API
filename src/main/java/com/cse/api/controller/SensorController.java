package com.cse.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import javax.validation.Valid;
import javax.xml.transform.Templates;

import com.cse.api.Response.CommonResponse;
import com.cse.api.exception.ResourceNotFoundException;
import com.cse.api.model.Rain;
import com.cse.api.model.Sensor;
import com.cse.api.model.harvest;
import com.cse.api.repository.SensorRepository;
import com.cse.api.repository.harvestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cse.api.repository.RainRepository;


//SensorController.java

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class SensorController {
  @Autowired
  RainRepository rainRepository;

  @Autowired
harvestRepository harvestRepository;
  @Autowired
  private SensorRepository sensorRepository;
  
  @CrossOrigin(origins = "*")
  @PostMapping("/send")
  public List<Sensor> createdata(@Valid @RequestBody List<Sensor> sensor) throws ResourceNotFoundException {
    return sensorRepository.saveAll(sensor);
  }
  @CrossOrigin(origins = "*")
  @GetMapping("/retrieve")
  public List<Sensor> getAllData() {
    return sensorRepository.findAll();
  }  


  @CrossOrigin(origins = "*")
  @GetMapping("/sensordata/{humidity}/{temperature}/{soilmoisture}")
  public Sensor saveheader(
      @PathVariable(value = "humidity") String humidity,@PathVariable(value = "temperature") String temperature,@PathVariable(value = "soilmoisture") String soilmoisture){
        Sensor sensor=new Sensor();

        sensor.sethumidity(humidity);
        sensor.setsoilmoisture(soilmoisture);
        sensor.settemperature(temperature);
        
        return sensorRepository.save(sensor);
      }

      @CrossOrigin(origins = "*")
      @GetMapping("/cleardata")
      public String clearAllData() {
        sensorRepository.deleteAll();
        return "Database cleaned successfully";
      }  
 

      @CrossOrigin(origins = "*")
      @GetMapping("/latest")
      public Sensor getLatestData() {
        
        return sensorRepository.findTopByOrderByIdDesc();
      }


      @CrossOrigin(origins = "*")
      @GetMapping("/allraindata")
      public List<Rain> getAllRainData() {
        
        return rainRepository.findAll();
      }


      @CrossOrigin(origins = "*")
      @GetMapping("/allharvestdata")
      public List<harvest> getAllHarvestData() {
        return harvestRepository.findAll();
      }
      
      

      @CrossOrigin(origins = "*")
      @GetMapping("/weathermodel")
      public Sensor getmetadata() {
        Random random = new Random();
        int[]arr={};
        IntStream temp=random.ints(23, 27);
        System.out.println("£££££££££££££££ "+temp);
        return sensorRepository.findTopByOrderByIdDesc();
      }
    


      @GetMapping("/sensordata")
      public Sensor handleRequest(
              @RequestParam("temperature") String temperature,
              @RequestParam("humidity") String humidity,
              @RequestParam("soilmoisture") String soilmoisture,
              @RequestParam("iSraining") int iSraining,
              @RequestParam("serialNumber") String serialNumber,
              @RequestParam("longtitude") String longtitude,
              @RequestParam("latitude") String latitude,
              @RequestParam("latitude") String voltage
        
              ) {
  
                Sensor sensor=new Sensor();

                sensor.sethumidity(humidity);
                sensor.setsoilmoisture(soilmoisture);
                sensor.settemperature(temperature);
                sensor.setiSraining(iSraining);
                sensor.setserialNumber(serialNumber);
                sensor.setlatitude(latitude);
                sensor.setlongtitude(longtitude);
                 sensor.setvoltage(voltage);
                
                return sensorRepository.save(sensor);
  
      
      }
};
