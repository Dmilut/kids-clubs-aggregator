package ru.dmilut.prodlenka.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "units")
public class Unit {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "clubs_id")
	private Club club;

	@NotEmpty
	@Size(min = 2, max = 30)
	private String activity;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "units_teachers", joinColumns = { @JoinColumn(name = "units_id") }, inverseJoinColumns = { @JoinColumn(name = "teachers_id") })
	private Set<Teacher> teachers;

	@OneToMany(mappedBy = "unit")
	private Set<ContactInfo> contactInfos;

	@OneToMany(mappedBy = "unit", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Set<Address> addresses;

	@OneToMany(mappedBy = "unit")
	private Set<Schedule> schedules;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_units", joinColumns = { @JoinColumn(name = "units_id") }, inverseJoinColumns = { @JoinColumn(name = "users_id") })
	private List<User> users;

	private Date dateOfRegistration = new Date();

	@OneToMany(mappedBy = "unit")
	private Set<Comment> comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<ContactInfo> getContactInfos() {
		return contactInfos;
	}

	public void setContactInfos(Set<ContactInfo> contactInfos) {
		this.contactInfos = contactInfos;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(Set<Schedule> schedules) {
		this.schedules = schedules;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}
