package com.example.android.tourguideapp;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by def on 11.06.18.
 */

public class CardAdapter extends ArrayAdapter<Card> {

    String adapterType;

    public CardAdapter(Activity context, ArrayList<Card> cards, String type) {
        super(context, 0, cards);

        adapterType = type;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listViewItem = convertView;

        //inflate list
        if (listViewItem == null){
            listViewItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //Construct Adapter

        Card currentCard = getItem(position);

        ImageView imageView = (ImageView) listViewItem.findViewById(R.id.card_image);
        TextView headerView =  (TextView) listViewItem.findViewById(R.id.card_header);
        TextView descriptionView = (TextView) listViewItem.findViewById(R.id.card_desc);

        // Set image
        if (currentCard.hasCardImage()){
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(currentCard.getmImage());
            headerView.setTextColor(Color.WHITE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        // Set Header
        headerView.setText(currentCard.getmHeader());
        // Set Descr
        if(adapterType.equals("grid")){
            descriptionView.setVisibility(View.GONE);
        } else {
            descriptionView.setVisibility(View.VISIBLE);
            descriptionView.setText(currentCard.getmDescription());
        }

        // About URL - must it been setted here ?

        return listViewItem;
    }
}
