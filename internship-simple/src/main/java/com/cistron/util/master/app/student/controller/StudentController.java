package com.cistron.util.master.app.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cistron.util.master.app.service.CRUDExampleService;
import com.cistron.util.master.app.student.model.Student;
import com.cistron.util.master.app.student.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class StudentController {

		   @Autowired
		   StudentService studentService;
		
		   @GetMapping("/students")
		   public List<Student> getAllData(HttpServletRequest request, HttpServletResponse response) {
	
			   List<Student> studentList = new ArrayList<Student>();
			   try {
				   studentList = studentService.showAllStudentsData();
				   return studentList;
			   }catch (Exception e) {
				   e.printStackTrace();
				   String errorMessage = "Error Occurred.";
				   System.out.print(errorMessage);
				   return studentList;
			   }
			   
		   }	

		   @GetMapping("/students/{id}")
		   public Student getParticularData(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
	
			   Student student = new Student();
			   try {
				   student= studentService.showStudentDataById(id);
				   return student;
			   }catch (Exception e) {
				   e.printStackTrace();
				   String errorMessage = "Error Occurred.";
				   System.out.print(errorMessage);
				   return student;
			   }
			   
		   }		   
		   
	
		   @PostMapping("/student")
		   public ResponseEntity<String> addStudent(@RequestBody Student newStudent, HttpServletRequest request, HttpServletResponse response) {
	
			   try {

				   studentService.addNewStudentData(newStudent);
				   
				   return ResponseEntity.ok().body("Data saved successfully");
			   }catch (Exception e) {
				   e.printStackTrace();
				   String errorMessage = "Error Occurred.";
				   return ResponseEntity.internalServerError().body(errorMessage);
			   }
			   
		   }	   
		   
		   @PutMapping("/student/{id}")
		   public ResponseEntity<Student> exampleForUpdateOperation(@RequestBody Student existingStudent, @PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
	
			   Student updatedStudent = new Student();
				   try {

					   existingStudent.setId(id);
					   updatedStudent = studentService.updateStudentData(existingStudent);
					   
					   return ResponseEntity.ok().body(updatedStudent);
				   }catch (Exception e) {
					   e.printStackTrace();
					   String errorMessage = "Error Occurred.";
					   return ResponseEntity.internalServerError().body(updatedStudent);
				   }				  
			   
		   }
		   
		   @DeleteMapping("/student/{id}")
		   public ResponseEntity<String> exampleForDeleteOperation(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
	
			   try {
				   
				   studentService.deleteStudentData(id);
				   String outputMessage = "Data deleted successfully";
				   return ResponseEntity.ok().body(outputMessage);
			   }catch (Exception e) {
				   e.printStackTrace();
				   String errorMessage = "Error Occurred.";
				   return ResponseEntity.internalServerError().body(errorMessage);
			   }
			   
		   }	   
		   
	}
