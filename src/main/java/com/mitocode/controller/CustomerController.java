package com.mitocode.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Customer;
import com.mitocode.repository.ICustomerRepo;

@RestController
@RequestMapping(value = "/")
public class CustomerController {

	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private final ICustomerRepo customerRepo;

	public CustomerController(ICustomerRepo customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	@PostMapping("/addcustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		log.info(" Save customer");
		return customerRepo.save(customer);
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomer() {
		log.info("Getting all the customers");
		return customerRepo.findAll();
	}

}
