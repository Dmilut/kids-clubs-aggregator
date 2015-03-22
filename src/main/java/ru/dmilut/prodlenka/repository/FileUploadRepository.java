package ru.dmilut.prodlenka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.dmilut.prodlenka.entity.UploadedFile;

public interface FileUploadRepository extends JpaRepository<UploadedFile, Long> {

}
