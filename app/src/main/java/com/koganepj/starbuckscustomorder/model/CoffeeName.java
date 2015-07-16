package com.koganepj.starbuckscustomorder.model;

import java.io.Serializable;

public class CoffeeName implements Serializable {
    private static final long serialVersionUID = -2280261818709421196L;

    public static final String ITEM_NAME = "Name";
	private String name;

	public CoffeeName(String name) {
		this.name = name;
	}

	public String getCoffeeName() {
		return name;
	}
}
