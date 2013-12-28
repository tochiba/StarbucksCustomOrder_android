package com.koganepj.starbuckscustomorder.view.ranking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;

public class RankingAdapter extends ArrayAdapter<SimpleCoffeeModel> {
    
    private LayoutInflater mInflater;
    
    public RankingAdapter(Context context) {
        super(context, 0);
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.layout_ranking_cell, null);
        
        ImageView imageView = (ImageView)view.findViewById(R.id.ImageCoffee);
        TextView textView = (TextView)view.findViewById(R.id.TextCoffeeName);
        
        SimpleCoffeeModel coffeeModel = getItem(position);
        imageView.setImageResource(coffeeModel.photo.getPhoto());
        textView.setText(coffeeModel.coffeeName.getCoffeeName());
        
        return view;
    }

}
