package com.koganepj.starbuckscustomorder.model;

public class Calorie {
	public static final String ITEM_CALORIE = "Calorie";
	private int point;

	public Calorie(int point) {
		this.point = point;
	}

	public int getCalorie() {
		return point;
	}
}
