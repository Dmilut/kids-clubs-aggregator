package ru.dmilut.prodlenka.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.dmilut.prodlenka.entity.Address;
import ru.dmilut.prodlenka.repository.AddressRepository;

@Service
@Transactional
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public List<Address> findAll() {
		return addressRepository.findAll();
	}

}
