package com.cistron.util.master.app.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommonController {

    @GetMapping("/")
    public String viewWebPage(Model model) {
        return "index";
    }

	@GetMapping("/menu")
    public String viewMainMenu(Model model) {
        return "menu";
    }	
	
	@GetMapping("/home")
    public String viewHomePage(Model model) {
    	System.out.println("User Logged In");
    	
        return "redirect:/students";
    }    
    
}

