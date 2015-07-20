package com.koganepj.starbuckscustomorder.model;

import java.io.Serializable;

public class Syrup implements Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = 6646384643837647486L;
    private String syrup;
	
	public Syrup(String syrup) {
		this.syrup = syrup;
	}

	public String getSyrup() {
		return this.syrup;
	}
}
