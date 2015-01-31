package ru.dmilut.prodlenka.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.dmilut.prodlenka.entity.Unit;
import ru.dmilut.prodlenka.repository.UnitRepository;

@Service
@Transactional
public class UnitService {

	@Autowired
	private UnitRepository unitRepository;

	public List<Unit> findAll() {

		return unitRepository.findAll();

	}

}
