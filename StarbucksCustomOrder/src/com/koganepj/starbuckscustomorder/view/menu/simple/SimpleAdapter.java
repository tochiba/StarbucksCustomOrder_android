package com.koganepj.starbuckscustomorder.view.menu.simple;

import com.koganepj.starbuckscustomorder.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class SimpleAdapter extends ArrayAdapter<String> {
    
    private LayoutInflater mInflater;
    
    public SimpleAdapter(Context context) {
        super(context, 0);
        mInflater = LayoutInflater.from(context);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return mInflater.inflate(R.layout.layout_menu_simple_cell, null);
    }
    
}
