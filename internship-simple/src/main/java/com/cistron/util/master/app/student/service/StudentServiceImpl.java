package com.cistron.util.master.app.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cistron.util.master.app.student.model.Student;
import com.cistron.util.master.app.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository; 
	
	public List<Student> showAllStudentsData() {

		List<Student> studentsList = new ArrayList<Student>();

		try {

			   studentsList = studentRepository.findAll();
			   
			   for(Student student: studentsList) {
				   System.out.println("Id: "+ student.getId());
				   System.out.println("Name: "+ student.getName());
				   System.out.println("Address: "+ student.getAddress());
				   System.out.println("Phone: "+ student.getPhone());
				   System.out.println("Email: "+ student.getEmail());
				   System.out.println("Gender: "+ student.getGender().getName());
				   System.out.println("=============================================");
			   }
			   
			   return studentsList;
		   }catch (Exception e) {
			   e.printStackTrace();
			   String errorMessage = "Error Occurred.";
			   return studentsList;
		   }		
	}

	public Student showStudentDataById(int id) {
	
		Student student = null;
		try {
			
			student = studentRepository.findById(id).get();

			return student;
			
	    }catch (Exception e) {
			   e.printStackTrace();
			   String errorMessage = "Error Occurred.";
			   return student;
		   }				
	}
	
		
	public void addNewStudentData(Student student) {
		
		//Student student = null;
		try {
			
			studentRepository.save(student);
			//return student;
			
	    }catch (Exception e) {
			   e.printStackTrace();
			   String errorMessage = "Error Occurred.";
			   //return student;
		   }				
	}

	
	public Student updateStudentData(Student student) {
		
		Student updatedStudent = new Student();
		try {
			
			updatedStudent = studentRepository.save(student);
		
	    }catch (Exception e) {
			   e.printStackTrace();
			   String errorMessage = "Error Occurred.";
		   }
		return updatedStudent;
	}
	
	public void deleteStudentData(int id) {
		
		try {
			
			studentRepository.deleteById(id);
		
	    }catch (Exception e) {
			   e.printStackTrace();
			   String errorMessage = "Error Occurred.";
		   }
	}	
}
