package com.sunil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunil.model.Customer;
import com.sunil.repository.CustomerRepository;

@RestController
public class LoginController {

	@Autowired
	CustomerRepository customerRepository;
	
	@PostMapping("/register")
	public Customer registerUster(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
}
