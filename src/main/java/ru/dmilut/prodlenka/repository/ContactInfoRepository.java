package ru.dmilut.prodlenka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.dmilut.prodlenka.entity.ContactInfo;

public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {

}
