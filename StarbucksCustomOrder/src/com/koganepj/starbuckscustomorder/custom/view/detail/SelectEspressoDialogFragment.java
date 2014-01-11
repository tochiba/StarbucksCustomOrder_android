package com.koganepj.starbuckscustomorder.custom.view.detail;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.model.Espresso;

public class SelectEspressoDialogFragment extends DialogFragment {
    
    public static final String KEY_ITEMS = "key_items";
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        ListView listView = (ListView)inflater.inflate(R.layout.layout_custom_customize_select_list_dialog, null);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.layout_custom_customize_select_list_dialog_cell);
        listView.setAdapter(adapter);
        
        @SuppressWarnings("unchecked")
        final ArrayList<Espresso> items = (ArrayList<Espresso>)arguments.getSerializable(KEY_ITEMS);
        for (Espresso item : items) {
            adapter.add(item.getEspresso());
        }
        
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Espresso espresso = items.get(position);
                Log.d("test", "select espresson : " + espresso.getEspresso());
                Log.d("test", "activity is " + getActivity().getClass());
            }
        });
        
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(listView);
        return builder.create();
    }
    
}
