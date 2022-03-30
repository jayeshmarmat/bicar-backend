package com.bicar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bicar.Repository.UserRepository;
import com.bicar.entity.LoginResponseDTO;
import com.bicar.entity.User;
import com.bicar.entity.UserDto;

@Service
public class LoginService {

	@Autowired
	UserRepository dao;

//	@Autowired
//	PasswordEncoder passwordEncoder; 

	public LoginResponseDTO checkPass(UserDto dto) {
		
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		User uname= dao.findByUsername(dto.getUsername());
				
		if(dto.getUsername().equalsIgnoreCase(uname.getUsername()) &&
				//passwordEncoder.matches(dto.getPassword() ,uname.getPassword())) {
				dto.getPassword().equals(uname.getPassword())) {
			loginResponseDTO.setCustid(uname.getCustomer().getCustid());
			loginResponseDTO.setStatus("200");
		return loginResponseDTO;	
		}
		return null;
	}
}
