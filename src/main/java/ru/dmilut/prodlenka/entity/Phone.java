package ru.dmilut.prodlenka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Phone {
	
	@Id
	@GeneratedValue	
	private Long id;
	
	@NotEmpty
	@Size(min = 2, max = 12)
	private Integer number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}	

}
