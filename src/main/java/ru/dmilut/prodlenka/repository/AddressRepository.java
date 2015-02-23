package ru.dmilut.prodlenka.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ru.dmilut.prodlenka.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByClubId(Long id, Pageable pageable);

}
