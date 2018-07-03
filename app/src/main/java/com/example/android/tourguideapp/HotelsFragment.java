package com.example.android.tourguideapp;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.card_list, container, false);

        final ArrayList<Card> cards = new ArrayList<>();

        Resources res = getResources();

        String[] hotel1 = res.getStringArray(R.array.hotel_array_1);
        String[] hotel2 = res.getStringArray(R.array.hotel_array_2);
        String[] hotel3 = res.getStringArray(R.array.hotel_array_3);

        cards.add(new Card(
                R.drawable.hotel1,
                hotel1[0],
                hotel1[1],
                hotel1[2],
                hotel1[3],
                hotel1[4]));

        cards.add(new Card(
                R.drawable.hotel2,
                hotel2[0],
                hotel2[1],
                hotel2[2],
                hotel2[3],
                hotel2[4]));

        cards.add(new Card(
                R.drawable.hotel3,
                hotel3[0],
                hotel3[1],
                hotel3[2],
                hotel3[3],
                hotel3[4]));


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
                    intent.putExtra("button", getString(R.string.book_now));
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
