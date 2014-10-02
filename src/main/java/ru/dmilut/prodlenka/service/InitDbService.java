package ru.dmilut.prodlenka.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.dmilut.prodlenka.entity.Address;
import ru.dmilut.prodlenka.entity.Club;
import ru.dmilut.prodlenka.entity.ContactInfo;
import ru.dmilut.prodlenka.entity.Phone;
import ru.dmilut.prodlenka.entity.Role;
import ru.dmilut.prodlenka.entity.Type;
import ru.dmilut.prodlenka.entity.Unit;
import ru.dmilut.prodlenka.entity.User;
import ru.dmilut.prodlenka.repository.AddressRepository;
import ru.dmilut.prodlenka.repository.ClubRepository;
import ru.dmilut.prodlenka.repository.ContactInfoRepository;
import ru.dmilut.prodlenka.repository.PhoneRepository;
import ru.dmilut.prodlenka.repository.RoleRepository;
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
	private RoleRepository roleRepository;

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

	@PostConstruct
	public void init() {
		Set<Role> roles = new HashSet<Role>();
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);

		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		roles.add(roleAdmin);
		roles.add(roleUser);

		Set<User> users = new HashSet<User>();
		User userAdmin = new User();
		userAdmin.setFirstName("firstAdminName");
		userAdmin.setLastName("lastAdminName");
		userAdmin.setPassword("testPassword");
		userAdmin.setEmail("testUserAdminEmail@test.ru");
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		users.add(userAdmin);

		Set<Club> clubs = new HashSet<Club>();
		Club club = new Club();
		club.setName("testClub");
		club.setType(Type.MARTIAL_ARTS);
		club.setDescription("testDescription");
		club.setUsers(users);

		Set<Address> addresses1 = new HashSet<Address>();
		Address address1 = new Address();
		address1.setCity("testCity1");
		address1.setStreet("testStreet1");
		address1.setHome("testHome1");
		address1.setApartment("testApart1");
		/* addressRepository.save(address1); */

		Set<Address> addresses2 = new HashSet<Address>();
		Address address2 = new Address();
		address2.setCity("testCity2");
		address2.setStreet("testStreet2");
		address2.setHome("testHome2");
		address2.setApartment("testApart2");

		Set<Unit> units = new HashSet<Unit>();
		Unit unit = new Unit();
		unit.setActivity("testActivity");
		unit.setClub(club);
		unit.setAddresses(addresses1);

		Set<ContactInfo> contactInfos = new HashSet<ContactInfo>();
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setContactPerson("testContactPerson");
		contactInfo.setEmail("testContactInfoEmail@test.ru");
		contactInfo.setUrl("http://www.google.com");

		Set<Phone> phones = new HashSet<Phone>();
		Phone phone = new Phone();
		phone.setNumber("12345678910");
		phone.setContactInfo(contactInfo);

		address1.setUnit(unit);
		addresses1.add(address1);

		address2.setClub(club);
		addresses2.add(address2);

		phones.add(phone);

		contactInfo.setPhones(phones);
		contactInfos.add(contactInfo);

		unit.setContactInfos(contactInfos);
		units.add(unit);

		club.setAddresses(addresses1);
		club.setUnits(units);
		club.setContactInfos(contactInfos);
		clubs.add(club);

		userAdmin.setClubs(clubs);

		/* unitRepository.save(unit); */

		/* addressRepository.save(address2); */

		/* phoneRepository.save(phone); */

		/* contactInfoRepository.save(contactInfo); */

		clubRepository.save(club);
		userRepository.save(userAdmin);

	}

}
