package ru.dmilut.prodlenka.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ru.dmilut.prodlenka.entity.Address;
import ru.dmilut.prodlenka.entity.Club;
import ru.dmilut.prodlenka.entity.Unit;
import ru.dmilut.prodlenka.repository.AddressRepository;
import ru.dmilut.prodlenka.repository.ClubRepository;
import ru.dmilut.prodlenka.repository.UnitRepository;

@Service
@Transactional
public class ClubService {

	@Autowired
	private ClubRepository clubRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private UnitRepository unitRepository;

	public List<Club> findAll() {
		return clubRepository.findAll();
	}

	public List<Club> findAllByQuery(String query) {
		List<Club> clubs = clubRepository.findAllByQuery(query);

		return clubs;
	}

	public List<Club> findAllWithAddressesUnits() {
		List<Club> clubs = findAll();
		List<Address> addresses;
		List<Unit> units;
		Long clubId;

		for (Club club : clubs) {
			clubId = club.getId();
			addresses = addressRepository.findByClubId(clubId, new PageRequest(0,
					10, Direction.DESC, "id"));
			club.setAddresses(addresses);
			units = unitRepository.findByClubId(clubId, new PageRequest(0, 10,
					Direction.DESC, "id"));
			club.setUnits(units);
		}

		return clubs;
	}

	public Object findAllWithAddressesUnitsByQuery(String city) {
		List<Club> clubs = findAllByQuery(city);
		List<Address> addresses;
		List<Unit> units;
		Long clubId;

		for (Club club : clubs) {
			clubId = club.getId();
			addresses = addressRepository.findByClubId(clubId, new PageRequest(0,
					10, Direction.DESC, "id"));
			club.setAddresses(addresses);
			units = unitRepository.findByClubId(clubId, new PageRequest(0, 10,
					Direction.DESC, "id"));
			club.setUnits(units);
		}

		return clubs;
	}

}
