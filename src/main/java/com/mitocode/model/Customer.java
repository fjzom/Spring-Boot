package com.mitocode.model;
 
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
 
@Document(collection = "customer")
public class Customer {
	@Id 
	public String customerId;
	
	public String name;
	
}
