package com.cistron.util.master.app.controller;

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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class CRUDExampleController {

		   @Autowired
		   CRUDExampleService crudExampleService;
		
		   @GetMapping("/example_for_read_operation")
		   public ResponseEntity<String> exampleForReadOperation(HttpServletRequest request, HttpServletResponse response) {
	
			   try {
				   //int number = Integer.parseInt("Hi"); //To test the negative scenario
				   String outputMessage = "Get method is Tested and verified";
				   return ResponseEntity.ok().body(outputMessage);
			   }catch (Exception e) {
				   e.printStackTrace();
				   String errorMessage = "Error Occurred.";
				   return ResponseEntity.internalServerError().body(errorMessage);
			   }
			   
		   }	
		
	
		   @PostMapping("/example_for_insert_operation")
		   public ResponseEntity<String> exampleForInsertOperation(@RequestBody String inputJSONString, HttpServletRequest request, HttpServletResponse response) {
	
			   try {
				   JSONObject inputJSON = new JSONObject(inputJSONString);
				   
				   String outputMessage = "Your name '" + inputJSON.getString("name") +"' and the age '" + inputJSON.getInt("age") + "' are inserted into the Database.";
				   return ResponseEntity.ok().body(outputMessage);
			   }catch (Exception e) {
				   e.printStackTrace();
				   String errorMessage = "Error Occurred.";
				   return ResponseEntity.internalServerError().body(errorMessage);
			   }
			   
		   }	   
		   
		   @PutMapping("/example_for_update_operation/{id}")
		   public ResponseEntity<String> exampleForUpdateOperation(@RequestBody String inputJSONString, @PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
	
			   try {
				   JSONObject inputJSON = new JSONObject(inputJSONString);
				   
				   String outputMessage = crudExampleService.arrayManipulation(inputJSON, id);
				   return ResponseEntity.ok().body(outputMessage);
			   }catch (Exception e) {
				   e.printStackTrace();
				   String errorMessage = "Error Occurred.";
				   return ResponseEntity.internalServerError().body(errorMessage);
			   }
			   
		   }
		   
		   @DeleteMapping("/example_for_delete_operation/{id}")
		   public ResponseEntity<String> exampleForDeleteOperation(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
	
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
					   if(currentJSON.getInt("id")!= id) {
						   updatedStudentArray.put(currentJSON);
					   }
					   
				   }			   
				   
	
				   System.out.println("After the Delete: ");
				   for(int i=0; i<updatedStudentArray.length();i++)
				   {
					   JSONObject printJSON = updatedStudentArray.getJSONObject(i);				   
					   System.out.println("Id: "+printJSON.getInt("id")+" Name: "+printJSON.getString("name")+" Age: "+ printJSON.getInt("age"));
				   }
				   
				   
				   String outputMessage = "The data for the Id: "+id+" is deleted from the Database.";
				   return ResponseEntity.ok().body(outputMessage);
			   }catch (Exception e) {
				   e.printStackTrace();
				   String errorMessage = "Error Occurred.";
				   return ResponseEntity.internalServerError().body(errorMessage);
			   }
			   
		   }	   
		   
	}

