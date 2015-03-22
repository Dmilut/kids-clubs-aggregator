package ru.dmilut.prodlenka.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.dmilut.prodlenka.entity.UploadedFile;
import ru.dmilut.prodlenka.repository.FileUploadRepository;

@Service
@Transactional
public class FileUploadService {

	@Autowired
	private FileUploadRepository filUploadRepository;

	public List<UploadedFile> findAll() {
		return filUploadRepository.findAll();
	}

}
