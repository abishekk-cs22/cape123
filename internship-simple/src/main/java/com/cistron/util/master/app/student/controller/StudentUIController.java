package com.cistron.util.master.app.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cistron.util.master.app.gender.model.Gender;
import com.cistron.util.master.app.gender.service.GenderService;
import com.cistron.util.master.app.service.CRUDExampleService;
import com.cistron.util.master.app.student.model.Student;
import com.cistron.util.master.app.student.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class StudentUIController {

		   @Autowired
		   StudentService studentService;
		
		   @Autowired
		   GenderService genderService;

			@GetMapping("/students_menu")
			public String viewStudentsMenu(Model model) {
			    return "students_menu";
			}		   
		   
			@GetMapping("/students")
			public String viewLoginPage(Model model) {
				System.out.println("User Opened Login page");
			    List<Student> students = studentService.showAllStudentsData();
			    
			    model.addAttribute("title", "Student Management");
			    model.addAttribute("students", students);
			    return "students";
			}

			@GetMapping("/student/{id}")
		    public String editStudentPage(@PathVariable("id") int inputId, Model model) {
				//int id = Integer.parseInt(inputId);
 
				Student student = studentService.showStudentDataById(inputId);
				List<Gender> genders = genderService.showAllGenders(); 
				
				System.out.println("Student Name: "+student.getName());
		        model.addAttribute("title", "Details of "+student.getName());
		        if(student!=null) {
		        	model.addAttribute("student", student);
		        	model.addAttribute("genders", genders);		        	
		        }

		        return "student";
		    }
			
			@GetMapping("/new_student")
		    public String addStudentPage(Model model) {
				//int id = Integer.parseInt(inputId);
 
				Student student = new Student();
				List<Gender> genders = genderService.showAllGenders(); 

				student.setName("");
				student.setAddress("");
				student.setPhone("");
				student.setEmail("");
				Gender gender = new Gender(); 
				gender.setId(1);
				student.setGender(gender);

		        model.addAttribute("title", "New Student");
		        if(student!=null) {
		        	model.addAttribute("student", student);
		        	model.addAttribute("genders", genders);		        	
		        }

		        return "student";
		    }
			
}
