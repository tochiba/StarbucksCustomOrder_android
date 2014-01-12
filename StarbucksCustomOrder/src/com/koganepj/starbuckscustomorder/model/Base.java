package com.koganepj.starbuckscustomorder.model;

import java.io.Serializable;

public class Base implements Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = 208596570241306589L;
    private String base;

	public Base(String base) {
		this.base = base;
	}
	
	public String getBase() {
		return this.base;
	}
}
