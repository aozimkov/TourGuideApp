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

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {

    @BindArray(R.array.food_array_1) String[] food1;
    @BindArray(R.array.food_array_2) String[] food2;
    @BindArray(R.array.food_array_3) String[] food3;
    @BindArray(R.array.food_array_4) String[] food4;
    @BindArray(R.array.food_array_5) String[] food5;
    @BindArray(R.array.food_array_6) String[] food6;

    @BindView(R.id.list) ListView listView;

    private Unbinder unbind;

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.card_list, container, false);

        unbind = ButterKnife.bind(this, rootView);

        final ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(
                R.drawable.food1, food1[0], food1[1], food1[2], food1[3], food1[4], food1[5]));
        cards.add(new Card(
                R.drawable.food2, food2[0], food2[1], food2[2], food2[3], food2[4], food2[5]));
        cards.add(new Card(
                R.drawable.food3, food3[0], food3[1], food3[2], food3[3], food3[4], food3[5]));
        cards.add(new Card(
                R.drawable.food4, food4[0], food4[1], food4[2], food4[3], food4[4], food4[5]));
        cards.add(new Card(
                R.drawable.food5, food5[0], food5[1], food5[2], food5[3], food5[4], food5[5]));
        cards.add(new Card(
                R.drawable.food6, food6[0], food6[1], food6[2], food6[3], food6[4], food6[5]));


        CardAdapter adapter = new CardAdapter(getActivity(), cards, "list");
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

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        unbind.unbind();
    }
}
