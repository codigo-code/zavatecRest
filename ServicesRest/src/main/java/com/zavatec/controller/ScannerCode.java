package com.zavatec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zavatec.model.Product;

@RestController
public class ScannerCode {
	private List<Product> productList;

	public ScannerCode() {
		Product p = new Product();
		p.setCount(4);
		p.setPrice(100.0);
		p.setName("MotherBoard");
		p.setSerialCode("ABC123");
		this.productList = new ArrayList<>();
		this.productList.add(p);
	}

	@GetMapping(value = "/getProduct")
	public List<Product> getProduct() {
		return this.productList;
	}

	@PostMapping(value = "/setPoduct")
	public ResponseEntity<Product> setProduct(@RequestBody Product product) {
			System.out.println(product);
		try {
			this.productList.add(product);
			return new ResponseEntity<Product>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getProduct/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		
		return this.productList.get(id);
	}
}
