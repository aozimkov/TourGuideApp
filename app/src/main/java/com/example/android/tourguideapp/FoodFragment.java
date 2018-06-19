package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.card_list, container, false);

        final ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(
                -1,
                "Название Кафе/Ресторана",
                "Описание",
                "http://cafe-hinkali.ru",
                22.11111,
                083.1311,
                "+7999123456",
                "+7999765432"));


        CardAdapter adapter = new CardAdapter(getActivity(), cards, "list");
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Card currentCard = cards.get(i);
                Intent intent = new Intent();

                if(currentCard.hasCardImage()) intent.putExtra(
                        "image", currentCard.getmImage());
                if(currentCard.hasUrl()) {
                    intent.putExtra("url", currentCard.getmUrl());
                    intent.putExtra("button", getString(R.string.open_in_browser));
                }

                if(currentCard.hasCardFirstContact()){
                    intent.putExtra("phone1", currentCard.getmContactOne());
                }

                if(currentCard.hasCardSecondContact()){
                    intent.putExtra("phone2", currentCard.getmContactOne());
                }

                if(currentCard.hasCoordinates()){
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
