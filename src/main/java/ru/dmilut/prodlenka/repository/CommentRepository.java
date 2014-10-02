package ru.dmilut.prodlenka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.dmilut.prodlenka.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
