package ru.dmilut.prodlenka.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "contact_info")
public class ContactInfo {

	@Id
	@GeneratedValue
	@Column(name = "contact_info_id")
	private Long id;

	@Column(name = "contact_person")
	@Size(max = 50)
	private String contactPerson;

	@OneToMany(mappedBy = "contactInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Phone> phones;

	@Email
	private String email;

	@URL
	private String url;

	@ManyToOne
	@JoinColumn(name = "club_id")
	private Club club;

	@ManyToOne
	@JoinColumn(name = "unit_id")
	private Unit unit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
