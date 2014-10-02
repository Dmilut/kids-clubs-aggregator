package ru.dmilut.prodlenka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.dmilut.prodlenka.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
