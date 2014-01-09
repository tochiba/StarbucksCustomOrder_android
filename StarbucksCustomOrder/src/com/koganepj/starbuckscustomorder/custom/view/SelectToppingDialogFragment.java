package com.koganepj.starbuckscustomorder.custom.view;

import java.util.ArrayList;

import com.koganepj.starbuckscustomorder.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SelectToppingDialogFragment extends DialogFragment {
    
    public static final String KEY_ITEMS = "key_items";
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        ListView listView = (ListView)inflater.inflate(R.layout.layout_custom_customize_select_list_dialog, null);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.layout_custom_customize_select_list_dialog_cell);
        listView.setAdapter(adapter);
        
        @SuppressWarnings("unchecked")
        ArrayList<String> items = (ArrayList<String>)arguments.getSerializable(KEY_ITEMS);
        for (String item : items) {
            adapter.add(item);
        }
        
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(listView);
        return builder.create();
    }
    
}
