package com.cistron.util.master.app.gender.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cistron.util.master.app.gender.model.Gender;
import com.cistron.util.master.app.gender.repository.GenderRepository;

@Service
public class GenderServiceImpl implements GenderService {

	@Autowired
	GenderRepository genderRepository; 
	
	public List<Gender> showAllGenders() {

		List<Gender> genderList = new ArrayList<Gender>();

		try {

				genderList = genderRepository.findAll();
			   
				return genderList;
		   }catch (Exception e) {
			   e.printStackTrace();
			   String errorMessage = "Error Occurred.";
			   return genderList;
		   }		
	}
	
}
