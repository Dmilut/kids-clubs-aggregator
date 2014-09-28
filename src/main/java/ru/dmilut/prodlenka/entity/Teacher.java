package ru.dmilut.prodlenka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "first_name")
	@NotEmpty
	@Size(min = 2, max = 20)
	private String firstName;

	@Column(name = "last_name")
	@NotEmpty
	@Size(min = 2, max = 20)
	private String lastName;
	
	@Size(max = 60)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
