package com.koganepj.starbuckscustomorder.view.ranking;

import com.koganepj.starbuckscustomorder.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RankingFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ranking, null);

        ListView listView = (ListView)view.findViewById(R.id.ListMenu);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        for (int i = 0; i < 100; i++) {
            adapter.add("number:" + (i + 1));
        }

        return view;
    }
    
}
