package ru.dmilut.prodlenka.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

		Set<User> users1 = new HashSet<User>();
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

		Set<Club> clubs1 = new HashSet<Club>();
		Club club1 = new Club();
		Club club2 = new Club();
		club1.setName("testClub1");
		club1.setCompany(company1);
		club2.setName("testClub2");
		club2.setCompany(company2);

		List<Unit> units = new ArrayList<Unit>();
		Set<Unit> unitsSet = new HashSet<Unit>();
		Unit unit1 = new Unit();
		Unit unit2 = new Unit();
		unit1.setActivity("testActivity1");
		unit1.setClub(club1);
		unit2.setActivity("testActivity2");
		unit2.setClub(club2);
		units.add(unit1);
		units.add(unit2);

		for (Unit unit : units) {
			unitsSet.add(unit);
		}

		club1.setUnits(unitsSet);
		club2.setUnits(unitsSet);
		clubs1.add(club1);
		clubs1.add(club2);
		company1.setUsers(users1);
		company1.setClubs(clubs1);
		company2.setUsers(users1);
		company2.setClubs(clubs1);

		companyRepository.save(company1);
		companyRepository.save(company2);
		userAdmin.setCompany(company1);
		userAdmin.setUnits(units);

		users1.add(userAdmin);

		unitRepository.save(unit1);
		unitRepository.save(unit2);

		userRepository.save(userAdmin);

	}

}
