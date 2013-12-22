package com.koganepj.starbuckscustomorder.model;

public class CoffeeName {
	public static final String ITEM_NAME = "Name";
	private String name;

	public CoffeeName(String name) {
		this.name = name;
	}

	public String getCoffeeName() {
		return name;
	}
}
