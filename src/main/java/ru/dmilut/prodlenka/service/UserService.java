package ru.dmilut.prodlenka.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.dmilut.prodlenka.entity.Role;
import ru.dmilut.prodlenka.entity.User;
import ru.dmilut.prodlenka.repository.RoleRepository;
import ru.dmilut.prodlenka.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public List<User> findAll() {

		return userRepository.findAll();

	}

	public User findOne(long id) {
		return userRepository.findOne(id);
	}

	/*@Transactional
	public User findOneWitRoles(long id) {
		User user = findOne(id);
		Set<Role> roles = roleRepository.findByUsers(user);
		user.setRoles(roles);

		return user;
	}
*/
}
