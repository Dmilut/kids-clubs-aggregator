package ru.dmilut.prodlenka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.dmilut.prodlenka.entity.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {

}
