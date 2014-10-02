package ru.dmilut.prodlenka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.dmilut.prodlenka.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
