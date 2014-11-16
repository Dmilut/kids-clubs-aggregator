package ru.dmilut.prodlenka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.dmilut.prodlenka.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	
}
