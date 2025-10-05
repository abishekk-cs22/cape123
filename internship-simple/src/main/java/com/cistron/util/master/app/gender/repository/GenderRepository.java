package com.cistron.util.master.app.gender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cistron.util.master.app.gender.model.Gender;

public interface GenderRepository extends JpaRepository<Gender, Integer>{

	//Reference: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

}
