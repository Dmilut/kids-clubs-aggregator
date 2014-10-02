package ru.dmilut.prodlenka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.dmilut.prodlenka.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
