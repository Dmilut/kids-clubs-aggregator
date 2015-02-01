package ru.dmilut.prodlenka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ru.dmilut.prodlenka.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);

	@Query("SELECT u FROM User u INNER JOIN u.units un WHERE un.id = ?1")
	List<User> findByUnit(Long id);

}
