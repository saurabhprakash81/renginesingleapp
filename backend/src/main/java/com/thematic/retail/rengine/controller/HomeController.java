package com.thematic.retail.rengine.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class HomeController {

    @GetMapping("/home")
	public ResponseEntity<String> testController(){
		  
		String testControllerMessage = "Success";
		ResponseEntity<String> response = new ResponseEntity<String>(testControllerMessage, HttpStatus.OK);
		return response;
	}
}
