package com.cistron.util.master.app.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cistron.util.master.app.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	//Reference: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

}
