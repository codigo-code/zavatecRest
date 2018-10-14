package com.zavatec.model;

import org.springframework.stereotype.Component;

@Component
public class Product {

	private String serialCode;
	private String name;
	private String description;
	private double price;
	private int count;
	private String imageB64;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	

	public String getImageB64() {
		return imageB64;
	}

	public void setImageB64(String imageB64) {
		this.imageB64 = imageB64;
	}

	public String getSerialCode() {
		return serialCode;
	}

	public void setSerialCode(String serialCode) {
		this.serialCode = serialCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Product [serialCode=" + serialCode + ", name=" + name + ", description=" + description + ", price="
				+ price + ", count=" + count + ", imageB64=" + imageB64 + "]";
	}

}
