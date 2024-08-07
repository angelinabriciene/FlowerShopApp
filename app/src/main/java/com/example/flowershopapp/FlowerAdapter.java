package com.example.flowershopapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FlowerAdapter extends ArrayAdapter<Flower> {
    public FlowerAdapter(Context context, ArrayList<Flower> flowers) {
        super(context, 0, flowers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Flower flower = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_flower, parent, false);
        }
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewSurname = convertView.findViewById(R.id.textViewPlant);

        textViewName.setText(flower.getName());
        textViewSurname.setText(flower.getPlant());

        return convertView;
    }
}
