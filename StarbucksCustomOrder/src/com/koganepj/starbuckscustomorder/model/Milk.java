package com.koganepj.starbuckscustomorder.model;

import java.io.Serializable;

public class Milk implements Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = -906750618519503774L;
    private String milk;
	
	public Milk(String milk) {
		this.milk = milk;
	}
	
	public String getMilk() {
		return this.milk;
	}
}
