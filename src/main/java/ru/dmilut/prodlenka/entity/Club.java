package ru.dmilut.prodlenka.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Club {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	@Size(min = 2, max = 50)
	private String name;

	@Enumerated(EnumType.STRING)
	private Type type;

	@NotEmpty
	@Size(max = 200)
	private String description;

	@NotNull
	@ManyToMany(mappedBy = "clubs")
	private Set<User> users;

	@NotNull
	@OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
	private Set<Address> addresses;

	@NotNull
	@OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
	private Set<ContactInfo> contactInfos;

	@OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
	private Set<Unit> units;

	@OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
	private Set<Comment> comments;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfRegistration = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<ContactInfo> getContactInfos() {
		return contactInfos;
	}

	public void setContactInfos(Set<ContactInfo> contactInfos) {
		this.contactInfos = contactInfos;
	}

	public Set<Unit> getUnits() {
		return units;
	}

	public void setUnits(Set<Unit> units) {
		this.units = units;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

}
