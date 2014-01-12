package com.koganepj.starbuckscustomorder.custom.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.koganepj.starbuckscustomorder.R;

public class CustomizeAdapter extends ArrayAdapter<CustomizeNameModel> {

    public CustomizeAdapter(Context context) {
        super(context, R.layout.layout_custom_customize_select_list_dialog_cell, R.id.TextCustomName);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        
        CustomizeNameModel model = getItem(position);
        
        View checkBox = view.findViewById(R.id.ImageCheckbox);
        if (model.isSelected()) {
            checkBox.setVisibility(View.VISIBLE);
        } else { 
            checkBox.setVisibility(View.GONE);
        }
        
        return view;
    }

}
