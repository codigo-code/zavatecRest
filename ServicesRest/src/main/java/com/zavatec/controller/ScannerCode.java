package com.zavatec.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zavatec.model.Product;

@RestController
public class ScannerCode {
	private List<Product> productList;

	public ScannerCode() throws IOException {
		FileReader file = new FileReader("image.txt");
		BufferedReader br = new BufferedReader(file);

		Product p = new Product();
		p.setCount(4);
		p.setPrice(100.0);
		p.setName("MotherBoard");
		p.setSerialCode("ABC123");
		String sCurrentLine;

		while ((sCurrentLine = br.readLine()) != null) {
			p.setImageB64(sCurrentLine);
		}

		this.productList = new ArrayList<>();
		this.productList.add(p);
	}

	@CrossOrigin
	@GetMapping(value = "/getProduct")
	public List<Product> getProduct() {
		return this.productList;
	}

	@CrossOrigin
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

	@CrossOrigin
	@GetMapping(value = "/getProduct/{id}")
	public Product getProductById(@PathVariable("id") int id) {

		return this.productList.get(id);
	}
}
