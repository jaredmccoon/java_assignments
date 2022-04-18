package com.codingdojo.FruityLoops.models;

public class Item {

// member variables
	private String name;
	private double price;

	
// Constructor
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	
// getters and setters
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
}