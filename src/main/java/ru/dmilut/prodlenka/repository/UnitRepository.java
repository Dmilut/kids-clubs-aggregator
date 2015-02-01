package ru.dmilut.prodlenka.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ru.dmilut.prodlenka.entity.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {

	@Query("SELECT u FROM Unit u INNER JOIN u.users us WHERE us.id = ?1")
	List<Unit> findByUser(Long userId, Pageable pageable);

	Unit findOne(Long id);

}
