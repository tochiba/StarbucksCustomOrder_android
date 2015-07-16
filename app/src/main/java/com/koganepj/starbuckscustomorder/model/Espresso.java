package com.koganepj.starbuckscustomorder.model;

import java.io.Serializable;

public class Espresso implements Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = -1244496344046101167L;

    private String espresso;
	
	public Espresso(String espresso) {
		this.espresso = espresso;
	}
	
	public String getEspresso() {
		return this.espresso;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (o == null) {
	        return false;
	    }
	    
	    if ((o instanceof Espresso) == false) {
	        return false;
	    }
	    Espresso another = (Espresso)o;
	    return espresso.equals(another.espresso);
	}
	
}
