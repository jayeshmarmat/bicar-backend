package com.bicar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bicar.entity.HandShakeResponseDTO;
import com.bicar.entity.Handshake;
import com.bicar.entity.Rider;
import com.bicar.entity.RiderResponseDTO;
import com.bicar.service.RiderService;

@RestController
public class RiderController {

	@Autowired
	RiderService riderservice;
	
	//  Offer a ride Api
	
	@PostMapping("/offerRide")
	public Rider addRider(@RequestBody Rider rider) {
		return riderservice.addRider(rider);
	}
	
	@GetMapping("/All")
	public List<Rider> GetAll() {
		return riderservice.GetAll();
	}
	
	
	
	// Find a Ride
	@PostMapping("/findRider")
	public List<RiderResponseDTO> CreateRide(@RequestBody Rider rider) {
		return riderservice.CreateRide(rider);
	}
	
	//Create REQ
	@PostMapping("/REQ")
	public Handshake BookRide(@RequestBody Handshake handshake) {
		return riderservice.BookRide(handshake);
	}
	
	
	//List Of REQ 
	@PostMapping("/listOfReq")
	public List<HandShakeResponseDTO> ListOfReq(@RequestBody Handshake approver) {
		
		return riderservice.ListOfReq(approver.getApprover());
		
	}
	
	@PostMapping("/app")
	public Handshake ApproveRide(@RequestBody Handshake handshake) {
		return riderservice.ApproveRide(handshake);
	}
	
	@PostMapping("/status")
	public HandShakeResponseDTO checkStatus(@RequestBody Handshake handshake) {
		return riderservice.checkStatus(handshake);
	}
	
	
}
