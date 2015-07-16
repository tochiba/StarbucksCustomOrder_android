package com.koganepj.starbuckscustomorder.model;

import java.io.Serializable;

public class Powder implements Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = -6325251106055967195L;
    private String powder;
	
	public Powder(String powder) {
		this.powder = powder;
	}
	
	public String getPowder() {
		return this.powder;
	}
}
