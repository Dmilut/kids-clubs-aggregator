package ru.dmilut.prodlenka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.dmilut.prodlenka.entity.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {

}
