package ru.dmilut.prodlenka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.dmilut.prodlenka.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
