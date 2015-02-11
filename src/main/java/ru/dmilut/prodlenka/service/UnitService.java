package ru.dmilut.prodlenka.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.dmilut.prodlenka.entity.Unit;
import ru.dmilut.prodlenka.entity.User;
import ru.dmilut.prodlenka.repository.UnitRepository;
import ru.dmilut.prodlenka.repository.UserRepository;

@Service
@Transactional
public class UnitService {

	@Autowired
	private UnitRepository unitRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	public List<Unit> findAll() {
		return unitRepository.findAll();
	}

	public void delete(long id) {
		unitRepository.delete(id);
	}

	/*
	 * public void delete(long id) { List<User> users =
	 * userService.findAllByUnit(id); Unit unit = unitRepository.findOne(id);
	 * for (User u : users) { List<Unit> units = u.getUnits(); for (int i = 0; i
	 * < u.getUnits().size(); i++) { if (units.get(i).equals(unit)) {
	 * units.remove(i); } } u.setUnits(units); } unitRepository.delete(id); }
	 */
}
