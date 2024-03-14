package com.example.tyit_29_prac1.CustomAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tyit_29_prac1.R;

import java.util.ArrayList;

public class Prac4GridViewAdapter extends ArrayAdapter {

    public Prac4GridViewAdapter(@NonNull Context context, ArrayList<String> prodcuts) {
        super(context, 0, prodcuts);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridviewItem = convertView;
        if (gridviewItem == null) {
            gridviewItem = LayoutInflater.from(getContext()).inflate(R.layout.custom_gridview_layout, parent, false);
        }
        String text = getItem(position).toString();
        TextView tvGridView = gridviewItem.findViewById(R.id.prac4GVCustomLayout);

        tvGridView.setText(text);
        return gridviewItem;
    }
}
