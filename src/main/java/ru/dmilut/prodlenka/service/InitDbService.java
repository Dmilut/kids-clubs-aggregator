package ru.dmilut.prodlenka.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ru.dmilut.prodlenka.entity.Address;
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

		List<User> users1 = new ArrayList<User>();
		User userAdmin = new User();
		userAdmin.setName("admin");
		userAdmin.setEnabled(true);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));

		List<Role> roles = new ArrayList<>();
		roles.add(Role.ROLE_ADMIN);
		roles.add(Role.ROLE_USER);

		userAdmin.setRoles(roles);
		userAdmin.setEmail("userAdminEmail@test.ru");

		Company company1 = new Company();
		Company company2 = new Company();
		company1.setName("testCompany1");
		company2.setName("testCompany2");
		userAdmin.setCompany(company1);

		company1.setUsers(users1);
		company2.setUsers(users1);

		List<Club> clubs1 = new ArrayList<Club>();
		Club club1 = new Club();
		Club club2 = new Club();
		club1.setName("testClub1");
		club1.setCompany(company1);
		club1.setDescription("Lorem ipsum dolor sit amet conse ctetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco. laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Integer sollicitudin imperdiet tempus. Nullam pellentesque, sem sed tempus eleifend, orci est pharetra dolor, at sollicitudin ");
		club2.setName("testClub2");
		club2.setCompany(company2);
		club2.setDescription("Lorem ipsum dolor sit amet conse ctetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco. laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Integer sollicitudin imperdiet tempus. Nullam pellentesque, sem sed tempus eleifend, orci est pharetra dolor, at sollicitudin ");

		List<Unit> units1 = new ArrayList<Unit>();
		List<Unit> units2 = new ArrayList<Unit>();
		Unit unit1 = new Unit();
		Unit unit2 = new Unit();
		Unit unit3 = new Unit();
		unit1.setActivity("testActivity1");
		unit1.setClub(club1);
		unit2.setActivity("testActivity2");
		unit2.setClub(club1);
		unit3.setActivity("testActivity3");
		unit3.setClub(club2);

		units1.add(unit1);
		units1.add(unit2);
		units2.add(unit3);

		club1.setUnits(units1);
		club2.setUnits(units2);

		List<Address> addresses1 = new ArrayList<>();
		List<Address> addresses2 = new ArrayList<>();
		Address address1 = new Address();
		address1.setCity("Санкт-Петербург");
		address1.setDistrict("Василеостровский");
		address1.setSubwayStation("Приморская");
		address1.setClub(club1);

		Address address2 = new Address();
		address2.setCity("Москва");
		address2.setDistrict("Невский");
		address2.setSubwayStation("Маяковская");
		address2.setClub(club2);

		addresses1.add(address1);
		addresses2.add(address2);

		club1.setAddresses(addresses1);
		club2.setAddresses(addresses2);

		clubs1.add(club1);
		clubs1.add(club2);
		company1.setUsers(users1);
		company1.setClubs(clubs1);
		company2.setUsers(users1);
		company2.setClubs(clubs1);

		companyRepository.save(company1);
		companyRepository.save(company2);
		userAdmin.setCompany(company1);
		userAdmin.setUnits(units1);

		users1.add(userAdmin);

		clubRepository.save(club1);
		clubRepository.save(club2);

		userRepository.save(userAdmin);

	}
}
