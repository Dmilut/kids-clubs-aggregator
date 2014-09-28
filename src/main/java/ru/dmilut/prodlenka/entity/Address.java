package ru.dmilut.prodlenka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address {
	
	@Id
	@GeneratedValue	
	private Long id;
	
	@NotEmpty
	@Size(min = 2, max = 30)
	private String city;
	
	@NotEmpty
	@Size(min = 2, max = 50)
	private String street;
	
	@Size(max = 10)
	private String home;
	
	@Size(max = 10)
	private String apartment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

}
