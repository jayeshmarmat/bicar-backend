package com.bicar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bicar.entity.LoginResponseDTO;
import com.bicar.entity.User;
import com.bicar.entity.UserDto;
import com.bicar.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginservice;

	@GetMapping("/home")
	public String home(@RequestBody User user){

		return "This is Home Page";
	}

	@GetMapping("/admin")
	public String admin(){
		System.out.println("admin.............");
		return "This is Admin Page";
	}

	@PostMapping("/login")
	public LoginResponseDTO checkPass(@RequestBody UserDto dto) {

		LoginResponseDTO loginResponseDTO=loginservice.checkPass(dto);
		if(null!=loginResponseDTO ) {
			return loginResponseDTO;
		}
		return null;    	
	}
}

