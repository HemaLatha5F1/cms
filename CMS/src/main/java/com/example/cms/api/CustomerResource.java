package com.example.cms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cms.model.Customer;
import com.example.cms.service.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping
	public List<Customer> getCustomers(){
		return customerService.getCustomers();	
	}
	
	@GetMapping(value = "/{cid}")
	public Customer getCustomer(@PathVariable("cid") int cid) {
		return customerService.getCustomer(cid);
	}
	
	@PutMapping(value = "/{cid}")
	public Customer updateCustomer(@PathVariable("cid") int cid, @RequestBody Customer customer) {
		return customerService.updateCustomer(cid, customer);
	}
	
	@DeleteMapping(value = "/{cid}")
	public void deleteCustomer(@PathVariable("cid") int cid) {
		customerService.deleteCustomer(cid);
	}
}
