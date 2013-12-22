package com.koganepj.starbuckscustomorder.model;

public class Type {
	public static final String ITEM_TYPE = "Type";
	private String typeName;
	
	public Type(String type) {
		this.typeName = type;
	}
	
	public String getType() {
		return typeName;
	}
}
