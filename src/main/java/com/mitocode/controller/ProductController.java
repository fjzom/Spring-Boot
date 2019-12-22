package com.mitocode.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mitocode.model.Product;
import com.mitocode.repository.IProductRepo;

@Controller 
@RequestMapping(value="/")
public class ProductController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private IProductRepo productRepo;
	
	public ProductController(IProductRepo productRepo) {
		super();
		this.productRepo = productRepo;
	}
	
	@RequestMapping(value="/addproduct", method=RequestMethod.POST)
	public String addProduct(@RequestParam (name="name", required=false, defaultValue="NEW") String name, Model model) {
		log.info("Save product.");
		Product p =  new Product();
		p.setName(name);
		productRepo.save(p);
		return "addproduct";
	}
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String getAllProducts(Model model){
		log.info("Get all products");
		model.addAttribute("products", productRepo.findAll());
		return "products";
	}
}
