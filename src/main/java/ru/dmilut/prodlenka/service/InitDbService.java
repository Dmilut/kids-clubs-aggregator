package ru.dmilut.prodlenka.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.dmilut.prodlenka.entity.Club;
import ru.dmilut.prodlenka.entity.Company;
import ru.dmilut.prodlenka.entity.Role;
import ru.dmilut.prodlenka.entity.Unit;
import ru.dmilut.prodlenka.entity.User;
import ru.dmilut.prodlenka.repository.AddressRepository;
import ru.dmilut.prodlenka.repository.ClubRepository;
import ru.dmilut.prodlenka.repository.CompanyRepository;
import ru.dmilut.prodlenka.repository.ContactInfoRepository;
import ru.dmilut.prodlenka.repository.PhoneRepository;
import ru.dmilut.prodlenka.repository.ScheduleRepository;
import ru.dmilut.prodlenka.repository.TeacherRepository;
import ru.dmilut.prodlenka.repository.UnitRepository;
import ru.dmilut.prodlenka.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClubRepository clubRepository;

	@Autowired
	private UnitRepository unitRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ContactInfoRepository contactInfoRepository;

	@Autowired
	private PhoneRepository phoneRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@PostConstruct
	public void init() {

		Set<User> users = new HashSet<User>();
		User userAdmin = new User();
		userAdmin.setFirstName("firstUserAdminName");
		userAdmin.setLastName("lastUserAdminName");
		userAdmin.setPassword("testPassword");
		userAdmin.setEmail("testUserAdminEmail@test.ru");

		Set<Role> roles = new HashSet<Role>();
		Role roleAdmin = new Role();
		roleAdmin.setName("ADMIN");
		roles.add(roleAdmin);

		userAdmin.setRoles(roles);

		Company company = new Company();
		company.setName("testCompany");
		userAdmin.setCompany(company);

		company.setUsers(users);

		Set<Club> clubs = new HashSet<Club>();
		Club club = new Club();
		club.setName("testClub");
		club.setCompany(company);

		Set<Unit> units = new HashSet<Unit>();
		Unit unit = new Unit();
		unit.setActivity("testActivity");
		unit.setClub(club);
		units.add(unit);

		club.setUnits(units);
		clubs.add(club);
		company.setUsers(users);
		company.setClubs(clubs);

		companyRepository.save(company);
		userAdmin.setCompany(company);
		userAdmin.setUnits(units);
		users.add(userAdmin);
		userRepository.save(userAdmin);
		unitRepository.save(unit);
		clubRepository.save(club);

	}

}
