package com.koganepj.starbuckscustomorder.view.ranking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

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
        return mInflater.inflate(R.layout.layout_ranking_cell, null);
    }

}
