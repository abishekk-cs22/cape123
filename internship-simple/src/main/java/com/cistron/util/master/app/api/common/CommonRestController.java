package com.cistron.util.master.app.api.common;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cistron.util.master.app.service.StringManipulation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class CommonRestController {
  
		@Autowired
		StringManipulation stringManipulation;
		
	
	   @GetMapping("test_api")
	   public ResponseEntity<String> testAPI(HttpServletRequest request, HttpServletResponse response) {

		   try {
			   return ResponseEntity.ok().body("API works correctly.");
		   }catch (Exception e) {
			   e.printStackTrace();		   
			   return ResponseEntity.ok().body("Error in API: "+ e.getMessage());
		   }
		   
	   }
	   
	   @PostMapping("/reverse_text")
	   public ResponseEntity<String> getReverseText(@RequestBody String inputData, HttpServletRequest request, HttpServletResponse response) {

		   try {
			   
			   JSONObject inputDataJSON = new JSONObject(inputData);
			   String inputText = inputDataJSON.getString("input");

			   String reversedText = stringManipulation.reverseInput(inputText);
			   
			   return ResponseEntity.ok().body("Reversed Text: "+reversedText);
		   }catch (Exception e) {
			   e.printStackTrace();		   
			   return ResponseEntity.ok().body("Error in API: "+ e.getMessage());
		   }
	   }	   

	   @PutMapping("/reverse_text")
	   public ResponseEntity<String> getReverseTextUsingPUTMethod(@RequestBody String inputData, HttpServletRequest request, HttpServletResponse response) {

		   try {
			   
			   JSONObject inputDataJSON = new JSONObject(inputData);
			   String inputText = inputDataJSON.getString("input"); 
			   
			   String reversedText = stringManipulation.reverseInput(inputText);
			   
			   return ResponseEntity.ok().body("Reversed Text: "+reversedText);
		   }catch (Exception e) {
			   e.printStackTrace();		   
			   return ResponseEntity.ok().body("Error in API: "+ e.getMessage());
		   }
	   }

	   @DeleteMapping("/test_api")
	   public ResponseEntity<String> testAPIWithDeleteMethod(HttpServletRequest request, HttpServletResponse response) {

		   try {
			   return ResponseEntity.ok().body("Delete API works correctly.");
		   }catch (Exception e) {
			   e.printStackTrace();		   
			   return ResponseEntity.ok().body("Error in Delete API: "+ e.getMessage());
		   }
		   
	   }	   
	   
}