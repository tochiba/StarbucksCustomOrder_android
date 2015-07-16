package com.koganepj.starbuckscustomorder.model;

import java.io.Serializable;

public class WhippedCream implements Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = 7018400567821580018L;
    private String whippedCream;
	
	public WhippedCream(String whippedCream) {
		this.whippedCream = whippedCream;
	}
	
	public String getWhippedCream() {
		return this.whippedCream;
	}
}
