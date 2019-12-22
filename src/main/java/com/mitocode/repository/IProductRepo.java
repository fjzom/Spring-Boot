package com.mitocode.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Product;

@Repository
public interface IProductRepo extends JpaRepository<Product, Integer>{
	
}
