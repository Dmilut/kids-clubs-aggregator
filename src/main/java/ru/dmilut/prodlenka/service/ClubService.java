package ru.dmilut.prodlenka.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.dmilut.prodlenka.entity.Club;
import ru.dmilut.prodlenka.repository.ClubRepository;

@Service
@Transactional
public class ClubService {

	@Autowired
	private ClubRepository clubRepository;

	public List<Club> findAll() {
		return clubRepository.findAll();
	}

}
