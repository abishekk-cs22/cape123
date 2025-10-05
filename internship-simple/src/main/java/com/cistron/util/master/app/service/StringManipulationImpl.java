package com.cistron.util.master.app.service;

import org.springframework.stereotype.Service;

@Service
public class StringManipulationImpl implements StringManipulation {

	@Override
	public String reverseInput(String inputText) {
		
		String reversedText = new StringBuilder(inputText).reverse().toString();	
		return reversedText;
	}

}
