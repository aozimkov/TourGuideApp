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
public class NewsFragment extends Fragment{

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.card_list, container, false);

        final ArrayList<Card> cards = new ArrayList<>();

        Resources res = getResources();

        String[] news1 = res.getStringArray(R.array.news_array_1);
        String[] news2 = res.getStringArray(R.array.news_array_2);
        String[] news3 = res.getStringArray(R.array.news_array_3);
        String[] news4 = res.getStringArray(R.array.news_array_4);
        String[] news5 = res.getStringArray(R.array.news_array_5);

        cards.add(new Card(
                R.drawable.news1,
                news1[0],
                news1[1],
                news1[2]));

        cards.add(new Card(R.drawable.news2,
                news2[0],
                news2[1],
                news2[2]));

        cards.add(new Card(R.drawable.news3,
                news3[0],
                news3[1],
                news3[2]));

        cards.add(new Card(R.drawable.news4,
                news4[0],
                news4[1],
                news4[2]));

        cards.add(new Card(R.drawable.news5,
                news5[0],
                news5[1],
                news5[2]));

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
                    intent.putExtra("button", getString(R.string.read_more));
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
