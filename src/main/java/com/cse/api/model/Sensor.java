package com.cse.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
@Entity
@Table(name = "sensors")
public class Sensor extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonIgnore
	private Long id;

	@Column(name = "temperature", nullable = true)
	private String temperature;

	@Column(name = "humidity", nullable = true)
	private String humidity;

	@Column(name = "soilmoisture", nullable = true)
	private String soilmoisture;

	@Column(name = "iSraining", nullable = true)
	private Integer iSraining;

	@Column(name = "serialNumber", nullable = true)
	private String serialNumber;

	@Column(name = "longtitude", nullable = true)
	private String longtitude;

	@Column(name = "latitude", nullable = true)
	private String latitude;
	
       @Column(name = "voltage", nullable = true)
	private String voltage;


	public Sensor() {
		super();
	}

	public Sensor(String temperature, String humidity, String soilmoisture) {
	
		this.temperature = temperature;
		this.humidity = humidity;
		this.soilmoisture = soilmoisture;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String gettemperature() {
		return temperature;
	}

	public void settemperature(String temperature) {
		this.temperature = temperature;
	}

	public String gethumidity() {
		return humidity;
	}

	public void sethumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getsoilmoisture() {
		return soilmoisture;
	}

	public void setsoilmoisture(String soilmoisture) {
		this.soilmoisture = soilmoisture;
	}


	public void setiSraining(Integer iSraining) {
		this.iSraining = iSraining;
	}

	public Integer getiSraining() {
		return iSraining;
	}


	public void setserialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getserialNumber() {
		return serialNumber;
	}
//
	public void setlongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public String getlongtitude() {
		return longtitude;
	}
	
//

	public void setlatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getlatitude() {
		return latitude;
	}
//
	public void setvoltage(String voltage) {
		this.voltage = voltage;
	}

	public String getvoltage() {
		return voltage;
	}

	
}
