package com.bicar.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bicar.entity.Customer;
import com.bicar.service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

	@Autowired	
	CustomerService customerService;

	@PostMapping("/addUpdateCustomer")
	public Customer CustomerAdd(@RequestBody Customer customer) throws Exception {
		return customerService.CustomerAdd(customer);
	}

	@GetMapping("/getCustomer")
	public List<Customer> CustomerGet() throws Exception {
		return customerService.CustomerGet();
	}

	@GetMapping("/findCustomer/{custid}")
	public Customer findCustomerId(@PathVariable("custid") int id) throws Exception {
		return customerService.findCustomerId(id);
	}

	@DeleteMapping("/deleteCustomer/{custid}")
	public void DeleteCustomer(@PathVariable ("custid") int id) throws Exception {
		customerService.DeleteCustomer(id);
	}


}
