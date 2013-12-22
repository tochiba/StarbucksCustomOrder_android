package com.koganepj.starbuckscustomorder.model;

public class Price {
	public static final String ITEM_PRICE = "Price";
	private int value;

	public Price(int value) {
		this.value = value;
	}

	public int getPrice() {
		return value;
	}
}
