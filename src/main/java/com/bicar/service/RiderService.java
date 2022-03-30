package com.bicar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bicar.Repository.HandshakeRepository;
import com.bicar.Repository.RiderRepository;
import com.bicar.dao.CustomerDao;
import com.bicar.entity.Customer;
import com.bicar.entity.HandShakeResponseDTO;
import com.bicar.entity.Handshake;
import com.bicar.entity.Rider;
import com.bicar.entity.RiderResponseDTO;

@Service
public class RiderService {

	@Autowired
	RiderRepository dao;

	@Autowired
	HandshakeRepository handshakeDao;

	@Autowired
	CustomerDao customerDao;

	public Rider addRider(Rider rider) {

		Optional<Rider> rid=dao.findById(rider.getId());
		if(rid.isPresent()) {
			Rider r =rid.get();
			r.setStart_time(rider.getDate());
			r.setRide_price(rider.getRide_price());
			r.setOrigin_source(rider.getOrigin_source());
			r.setDestination(rider.getDestination());
			r.setDate(rider.getDate());
			r.setCustid(rider.getCustid());
			r.setOwner(true);

			r=dao.save(r);
		}else {
			rider= dao.save(rider);
		}
		return rider;
	}


	//utility method

	public List<RiderResponseDTO> getAllRides(Rider rider){

		List<Rider> r1 =dao.findAll();
		List<Rider> res= r1.stream().filter(r->r.getOrigin_source().equalsIgnoreCase(rider.getOrigin_source()) &&
				r.getDestination().equalsIgnoreCase(rider.getDestination()) &&
				r.getStart_time().equals(rider.getStart_time()) && r.isOwner() == true

				).collect(Collectors.toList());
		List<RiderResponseDTO> riderList = new ArrayList<RiderResponseDTO>();
		res.forEach(rsd-> {
			Optional<Customer> c = customerDao.findById(Integer.parseInt(rsd.getCustid()));
			RiderResponseDTO riderResponseDTO = new RiderResponseDTO();
			riderResponseDTO.setName(c.get().getName());
			riderResponseDTO.setCustid(rsd.getCustid());
			riderResponseDTO.setDate(rsd.getDate());
			riderResponseDTO.setStart_time(rsd.getStart_time());
			riderResponseDTO.setDestination(rsd.getDestination());
			riderResponseDTO.setOrigin_source(rsd.getOrigin_source());
			riderResponseDTO.setRide_price(rsd.getRide_price());
			riderList.add(riderResponseDTO);
		});
		return riderList;
	}

	public List<RiderResponseDTO> CreateRide(Rider rider) {
		Optional<Rider> rid=dao.findById(rider.getId());
		if(rid.isPresent()) {
			Rider r =rid.get();
			r.setStart_time(rider.getDate());
			r.setRide_price(rider.getRide_price());
			r.setOrigin_source(rider.getOrigin_source());
			r.setDestination(rider.getDestination());
			r.setDate(rider.getDate());
			r.setCustid(rider.getCustid());
			r.setOwner(false);

			r=dao.save(r);
		}else {
			rider= dao.save(rider);
		}
		return getAllRides(rider) ;
	}


	public List<Rider> GetAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}


	public Handshake BookRide(Handshake handshake) {

		handshake.setReqStatus("REQ");

		return handshakeDao.save(handshake);
	}


	public List<HandShakeResponseDTO> ListOfReq(Integer Approver) {

		List<HandShakeResponseDTO> handShakeList = new ArrayList<HandShakeResponseDTO>();
		List<Object[]> ls = handshakeDao.ListOfRreq(Approver);
		for(Object[] obj: ls) {
			HandShakeResponseDTO handShakeResponseDTO =new HandShakeResponseDTO();
			System.out.println(obj.toString());

			handShakeResponseDTO.setCustid((Integer.parseInt(obj[1].toString())));
			handShakeResponseDTO.setDate((String)obj[2]);
			handShakeResponseDTO.setDestination((String)obj[3]);
			handShakeResponseDTO.setOrigin_source((String)obj[5]);
			handShakeResponseDTO.setRide_price((null!=(String)obj[6])?(String)obj[6]:"100");
			handShakeResponseDTO.setStart_time((String)obj[7]);

			Optional<Customer> c=customerDao.findById(handShakeResponseDTO.getCustid());
			handShakeResponseDTO.setName(c.get().getName());

			handShakeList.add(handShakeResponseDTO);

		}
		return handShakeList;
	}


	public Handshake ApproveRide(Handshake handshake) {
		Handshake h=handshakeDao.findRequestorApprover(handshake.getRequestor(), handshake.getApprover());
		if(null!=h) {
			h.setReqStatus(handshake.getReqStatus());
		}
		return handshakeDao.save(h);
		
	}


	public HandShakeResponseDTO checkStatus(Handshake handshake) {
		Handshake hs =handshakeDao.findRequestor(handshake.getRequestor());
		HandShakeResponseDTO handShakeResponseDTO = new HandShakeResponseDTO();
		Optional<Customer> c =customerDao.findById(hs.getApprover());
		handShakeResponseDTO.setName(c.get().getName());
		if("REQ".equals(hs.getReqStatus())) {
			handShakeResponseDTO.setStatus("REQUESTED");			
		}else if("ACT".equals(hs.getReqStatus())) {
			handShakeResponseDTO.setStatus("ACCEPTED");	
		}else {
			handShakeResponseDTO.setStatus("REJECTED");			
		}
		return handShakeResponseDTO;
	}
	
}