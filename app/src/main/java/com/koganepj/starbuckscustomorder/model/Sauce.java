package com.koganepj.starbuckscustomorder.model;

import java.io.Serializable;

public class Sauce implements Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = 5654654119282323081L;
    private String sauce;
	
	public Sauce(String sauce) {
		this.sauce = sauce;
	}
	
	public String getSauce() {
		return this.sauce;
	}
}
