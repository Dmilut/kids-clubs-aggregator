package ru.dmilut.prodlenka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ru.dmilut.prodlenka.entity.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {

	@Query("SELECT c FROM Club c INNER JOIN c.addresses a WHERE a.city = ?1")
	List<Club> findAllByQuery(String query);

}
