package com.java.application.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.application.model.Customer;

@RestController
public class CustomerController {

	@RequestMapping("/customerinfo")
	// defines a cache for method's return value
	@Cacheable(value = "customerInfo")
	public List<Customer> customerInformation() {
		System.out.println("customer information from cache");
		List<Customer> detail = Arrays.asList(new Customer(4567637, "Balaji", "Current A/C", 450.00),
				new Customer(7878777, "Magesh", "Savings A/C", 3400.00));
		return detail;
	}

}
