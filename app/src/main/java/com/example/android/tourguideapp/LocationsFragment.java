package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationsFragment extends Fragment {


    public LocationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.card_grid, container, false);

        final ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(
                 R.drawable.news1,
                "Название Локации",
                "Описание",
                22.11111,
                083.1311));


        CardAdapter adapter = new CardAdapter(getActivity(), cards, "grid");
        GridView gridView = (GridView) rootView.findViewById(R.id.grid);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Card currentCard = cards.get(i);
                Intent intent = new Intent();

                if(currentCard.hasCardImage()) intent.putExtra(
                        "image", currentCard.getmImage());
                intent.putExtra("header", currentCard.getmHeader());
                intent.putExtra("description", currentCard.getmDescription());

                intent.setClass(getActivity(), SingleActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
