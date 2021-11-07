package com.example.cms.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.cms.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	@Override
	List<Customer> findAll();
}
