package com.mitocode.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Customer;

@Repository
public interface ICustomerRepo extends MongoRepository<Customer, String>{

}
