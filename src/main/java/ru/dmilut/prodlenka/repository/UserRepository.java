package ru.dmilut.prodlenka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.dmilut.prodlenka.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
}
