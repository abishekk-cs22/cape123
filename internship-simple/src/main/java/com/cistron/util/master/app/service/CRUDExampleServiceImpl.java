package com.cistron.util.master.app.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cistron.util.master.app.student.model.Student;
import com.cistron.util.master.app.student.repository.StudentRepository;

@Service
public class CRUDExampleServiceImpl implements CRUDExampleService {

	@Autowired
	StudentRepository studentRepository; 
	
	public String arrayManipulation(JSONObject inputJSON, int id) {

		try {

			   JSONArray studentArray = new JSONArray();
			   
			   JSONObject j1 = new JSONObject();
			   j1.put("id", 1);			   
			   j1.put("name", "Amal");
			   j1.put("age", 10);

			   JSONObject j2 = new JSONObject();
			   j2.put("id", 2);			   
			   j2.put("name", "Aslam");
			   j2.put("age", 9);

			   JSONObject j3 = new JSONObject();
			   j3.put("id", 3);			   
			   j3.put("name", "Alman");
			   j3.put("age", 7);
			   
			   
			   studentArray.put(j1);
			   studentArray.put(j2);
			   studentArray.put(j3);
			   
			   System.out.println("Before the Update: ");
			   for(int i=0; i<studentArray.length();i++)
			   {
				   JSONObject printJSON = studentArray.getJSONObject(i);
				   System.out.println("Id: "+printJSON.getInt("id")+" Name: "+printJSON.getString("name")+" Age: "+ printJSON.getInt("age"));
			   }
			   
			   
			   JSONArray updatedStudentArray = new JSONArray();
			   for(int i=0; i<studentArray.length();i++)
			   {
				   JSONObject currentJSON = studentArray.getJSONObject(i);
				   if(currentJSON.getInt("id") == id) {
					   currentJSON.put("name", inputJSON.getString("name"));
					   currentJSON.put("age", inputJSON.getInt("age"));
				   }
				   updatedStudentArray.put(currentJSON);
			   }			   
			   

			   System.out.println("After the Update: ");
			   for(int i=0; i<updatedStudentArray.length();i++)
			   {
				   JSONObject printJSON = updatedStudentArray.getJSONObject(i);				   
				   System.out.println("Id: "+printJSON.getInt("id")+" Name: "+printJSON.getString("name")+" Age: "+ printJSON.getInt("age"));
			   }
			   
			   
			   String outputMessage = "Input name '" + inputJSON.getString("name") +"' and the age '" + inputJSON.getInt("age") + "' are updated into the Database.";

			   List<Student> studentsList = studentRepository.findAll();
			   
			   for(Student student: studentsList) {
				   System.out.println("Id: "+ student.getId());
				   System.out.println("Name: "+ student.getName());
				   System.out.println("Address: "+ student.getAddress());
				   System.out.println("Phone: "+ student.getPhone());
				   System.out.println("Email: "+ student.getEmail());
				   System.out.println("Gender: "+ student.getGender().getName());
				   System.out.println("=============================================");
				   
			   }
			   
			   return outputMessage;
		   }catch (Exception e) {
			   e.printStackTrace();
			   String errorMessage = "Error Occurred.";
			   return errorMessage;
		   }		
	}

}
