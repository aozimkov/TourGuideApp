package com.example.android.tourguideapp;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
public class HotelsFragment extends Fragment {

    @BindArray(R.array.hotel_array_1) String[] hotel1;
    @BindArray(R.array.hotel_array_2) String[] hotel2;
    @BindArray(R.array.hotel_array_3) String[] hotel3;

    @BindView(R.id.card_recycle)
    RecyclerView mRecyclerView;

    private Unbinder unbinder;

    private ArrayList<Card> cards = new ArrayList<>();

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.card_recycle, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        cards.add(new Card(
                R.drawable.hotel1, hotel1[0], hotel1[1], hotel1[2], hotel1[3], hotel1[4]));
        cards.add(new Card(
                R.drawable.hotel2, hotel2[0], hotel2[1], hotel2[2], hotel2[3], hotel2[4]));
        cards.add(new Card(
                R.drawable.hotel3, hotel3[0], hotel3[1], hotel3[2], hotel3[3], hotel3[4]));

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CardRecycleAdapter(cards, "list");
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(),
                LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((CardRecycleAdapter) mAdapter).setOnItemClickListener(new CardRecycleAdapter.CardClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                  Card currentCard = cards.get(position);
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
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
