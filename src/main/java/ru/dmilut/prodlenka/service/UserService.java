package ru.dmilut.prodlenka.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ru.dmilut.prodlenka.entity.Role;
import ru.dmilut.prodlenka.entity.Unit;
import ru.dmilut.prodlenka.entity.User;
import ru.dmilut.prodlenka.repository.UnitRepository;
import ru.dmilut.prodlenka.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UnitRepository unitRepository;

	public List<User> findAll() {

		return userRepository.findAll();

	}

	public User findOne(long id) {
		return userRepository.findOne(id);
	}

	public User findOneWithUnits(long id) {
		User user = findOne(id);
		List<Unit> units = unitRepository.findByUser(user.getId(),
				new PageRequest(0, 10, Direction.DESC, "id"));
		user.setUnits(units);

		return user;
	}

	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		List<Role> roles = new ArrayList<>();
		roles.add(Role.ROLE_USER);
		user.setRoles(roles);
		
		userRepository.save(user);
	}

	public User findOneWithUnits(String name) {
		User user = userRepository.findByName(name);
		
		return findOneWithUnits(user.getId());
	}
}
