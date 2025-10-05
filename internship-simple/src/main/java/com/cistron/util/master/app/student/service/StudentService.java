package com.cistron.util.master.app.student.service;

import java.util.List;

import com.cistron.util.master.app.student.model.Student;

public interface StudentService {

	public List<Student> showAllStudentsData();
	
	public Student showStudentDataById(int id);
	
	public void addNewStudentData(Student student);
	
	public Student updateStudentData(Student student);	
	
	public void deleteStudentData(int id);
	
}
