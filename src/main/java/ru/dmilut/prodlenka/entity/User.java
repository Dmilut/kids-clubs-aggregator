package ru.dmilut.prodlenka.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {

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

	@Size(min = 2, max = 12)
	private String nickname;

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	private String password;

	@Enumerated(EnumType.STRING)
	private List<Role> roles;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfRegistration = new Date();

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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Date getPublishingDate() {
		return dateOfRegistration;
	}

	public void setPublishingDate(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

}
