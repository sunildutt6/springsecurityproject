package com.sunil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunil.model.Customer;
import com.sunil.repository.CustomerRepository;

@RestController
public class LoginController {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public Customer registerUster(@RequestBody Customer customer) {
		String hashPwd = passwordEncoder.encode(customer.getPwd());
		customer.setPwd(hashPwd);
		return customerRepository.save(customer);
	}
}
