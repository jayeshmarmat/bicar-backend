package com.bicar.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.bicar.dao.CustomerDao;
import com.bicar.entity.Customer;
import com.bicar.entity.User;


@Service
public class CustomerService  {

	@Autowired
	CustomerDao dao;
	
//	@Autowired
//	PasswordEncoder passwordEncoder; 

	public Customer CustomerAdd(Customer customer) throws Exception {
		Optional<Customer> cusOptional=dao.findById(customer.getCustid());
		if(cusOptional.isPresent()) {
			Customer c=new Customer();
			c.setAddress(customer.getAddress());
			c.setAge(customer.getAge());
			c.setCompany_name(customer.getCompany_name());
			c.setCust_type(customer.getCust_type());
			c.setCustid(customer.getCustid());
			c.setEmail(customer.getEmail());
			c.setMobile(customer.getMobile());
			c.setName(customer.getName());
			c.setPincode(customer.getPincode());
			c.setPrimary_id(customer.getPrimary_id());
			c.setRating(customer.getRating());	
			
			User p=customer.getUser();
//			p.setPassword(passwordEncoder.encode(p.getPassword()));
			p.setPassword(p.getPassword());
			c.setUser(p);
		
			c.setUser(customer.getUser());
			dao.save(c);
			
		} else {
			User c=customer.getUser();
			//c.setPassword(passwordEncoder.encode(c.getPassword()));
			c.setPassword(c.getPassword());
			c.setCustomer(customer);
			customer.setUser(c);
			customer=dao.save(customer);	
		}
		return customer;
	}

	public List<Customer> CustomerGet() throws Exception {
		List<Customer> c=dao.findAll();
		if(c.isEmpty()) {
			throw new Exception("No Data in Customer");
		} else {
			return c;
		}

	}

	public Customer findCustomerId(int id) throws Exception {
		Optional<Customer> cusOptional=dao.findById(id);
		if(cusOptional.isPresent()) {
			return cusOptional.get();
		} else {
			throw new Exception("No Such Customer Found");
		}

	}

	public void DeleteCustomer(int id) throws Exception {
		Optional<Customer> c=dao.findById(id);
		if(c.isPresent()) {
			dao.deleteById(id);	
		}else {
			throw new Exception("Id Not Available");
		}

	}






}
