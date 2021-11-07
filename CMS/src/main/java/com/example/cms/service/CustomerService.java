package com.example.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.cms.exception.CustomerNotFoundException;
import com.example.cms.model.Customer;
import com.example.cms.repos.CustomerRepository;

@Component
public class CustomerService {
	
	@Autowired
	private CustomerRepository cRepository;
	
	
	public Customer addCustomer(Customer customer) {
		return cRepository.save(customer);
	}
	
	public List<Customer> getCustomers(){
		return cRepository.findAll();
	}
	
	public Customer getCustomer(int id) {
		Optional<Customer> value = cRepository.findById(id);
		if(!value.isPresent())
			throw new CustomerNotFoundException("Customer Record is not found");
		return value.get();
	}
	
	public Customer updateCustomer(int cid,Customer customer){
		customer.setCid(cid);
		return cRepository.save(customer);
	}
	
	public void deleteCustomer(int cid){
		 cRepository.deleteById(cid);
	}
}

