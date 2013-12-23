package com.koganepj.starbuckscustomorder.view.menu.visual;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;

public class VisualAdapter extends ArrayAdapter<SimpleCoffeeModel> {
    
    private LayoutInflater mInflater;
    
    public VisualAdapter(Context context) {
        super(context, 0);
        mInflater = LayoutInflater.from(context);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.layout_menu_visual_cell, null);

        ImageView imageView = (ImageView)view.findViewById(R.id.ImageCoffeePicture);
        TextView textView = (TextView)view.findViewById(R.id.TextCoffeeName);
        
        SimpleCoffeeModel coffeeModel = getItem(position);
        imageView.setImageResource(coffeeModel.photo.getPhoto());
        textView.setText(coffeeModel.coffeeName.getCoffeeName());
        
        return view;
    }

}
