package com.koganepj.starbuckscustomorder.custom.view;

public class CustomizeNameModel {
    
    private String mName;
    private boolean mSelected;
    
    public CustomizeNameModel(String name, boolean selected) {
        mName = name;
        mSelected = selected;
    }
    
    public boolean isSelected() {
        return mSelected;
    }
    
    public String getName() {
        return mName;
    }
    
    @Override
    public String toString() {
        return mName;
    }
    
}
