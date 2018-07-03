package com.example.android.tourguideapp;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

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

        Resources res = getResources();

        String[] location1 = res.getStringArray(R.array.location_array_1);
        String[] location2 = res.getStringArray(R.array.location_array_2);
        String[] location3 = res.getStringArray(R.array.location_array_3);
        String[] location4 = res.getStringArray(R.array.location_array_4);
        String[] location5 = res.getStringArray(R.array.location_array_5);
        String[] location6 = res.getStringArray(R.array.location_array_6);

        cards.add(new Card(
                R.drawable.location1,
                location1[0],
                location1[1],
                location1[2],
                location1[3]
                ));

        cards.add(new Card(
                 R.drawable.location2,
                location1[0],
                location1[1],
                location1[2],
                location1[3]));

        cards.add(new Card(
                 R.drawable.location3,
                location1[0],
                location1[1],
                location1[2],
                location1[3]));

        cards.add(new Card(
                 R.drawable.location4,
                location1[0],
                location1[1],
                location1[2],
                location1[3]));

        cards.add(new Card(
                 R.drawable.location5,
                location1[0],
                location1[1],
                location1[2],
                location1[3]));

        cards.add(new Card(
                 R.drawable.location6,
                location1[0],
                location1[1],
                location1[2],
                location1[3]));

        CardAdapter adapter = new CardAdapter(getActivity(), cards, "grid");
        GridView gridView = (GridView) rootView.findViewById(R.id.grid);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Card currentCard = cards.get(i);
                Intent intent = new Intent();

                /**
                 * Add data to intent for moving it to single card
                 */

                if(currentCard.hasCardImage()) intent.putExtra(
                        "image", currentCard.getmImage());
                if(currentCard.hasCoordinates()) {
                    intent.putExtra("lat", currentCard.getmLat());
                    intent.putExtra("lon", currentCard.getmLon());
                }
                intent.putExtra("header", currentCard.getmHeader());
                intent.putExtra("description", currentCard.getmDescription());

                intent.setClass(getActivity(), SingleActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
