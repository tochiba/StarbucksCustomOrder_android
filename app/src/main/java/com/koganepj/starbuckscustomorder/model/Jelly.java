package com.koganepj.starbuckscustomorder.model;

import java.io.Serializable;

public class Jelly implements Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = 7493707668772019960L;

    private String jelly;
	
	public Jelly(String jelly) {
		this.jelly = jelly;
	}
	
	public String getJelly() {
		return this.jelly;
	}
}
