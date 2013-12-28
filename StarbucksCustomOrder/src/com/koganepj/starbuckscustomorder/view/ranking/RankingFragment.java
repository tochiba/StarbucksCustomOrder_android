package com.koganepj.starbuckscustomorder.view.ranking;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.SimpleCoffeeModel;
import com.koganepj.starbuckscustomorder.view.ranking.adapter.RankingAdapter;

public class RankingFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ranking, null);

        ListView listView = (ListView)view.findViewById(R.id.ListMenu);
        RankingAdapter adapter = new RankingAdapter(getActivity());
        listView.setAdapter(adapter);
        for (int i = 0; i < 100; i++) {
            adapter.add(new SimpleCoffeeModel());
        }
        
        return view;
    }
    
}
