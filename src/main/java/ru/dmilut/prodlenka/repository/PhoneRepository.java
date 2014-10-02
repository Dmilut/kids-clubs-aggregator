package ru.dmilut.prodlenka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.dmilut.prodlenka.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
