package com.koganepj.starbuckscustomorder.view.ranking;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;
import com.koganepj.starbuckscustomorder.parse.CoffeeListParser;
import com.koganepj.starbuckscustomorder.view.ranking.adapter.RankingAdapter;

public class RankingFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ranking, null);
        
        CoffeeListParser parser = new CoffeeListParser(getActivity());
        ArrayList<SimpleCoffeeModel> coffeeList = parser.getCoffeeList();

        ListView listView = (ListView)view.findViewById(R.id.ListMenu);
        RankingAdapter adapter = new RankingAdapter(getActivity());
        adapter.addAll(coffeeList);
        listView.setAdapter(adapter);
        
        return view;
    }
    
}
