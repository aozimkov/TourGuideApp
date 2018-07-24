package com.example.android.tourguideapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
public class NewsFragment extends Fragment{

    @BindArray(R.array.news_array_1) String[] news1;
    @BindArray(R.array.news_array_2) String[] news2;
    @BindArray(R.array.news_array_3) String[] news3;
    @BindArray(R.array.news_array_4) String[] news4;
    @BindArray(R.array.news_array_5) String[] news5;

    @BindView(R.id.card_recycle) RecyclerView mRecyclerView;

    private Unbinder unbinder;

    private ArrayList<Card> cards = new ArrayList<>();

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

        public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.card_recycle, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        cards.add(new Card(R.drawable.news1, news1[0], news1[1], news1[2]));
        cards.add(new Card(R.drawable.news2, news2[0], news2[1], news2[2]));
        cards.add(new Card(R.drawable.news3, news3[0], news3[1], news3[2]));
        cards.add(new Card(R.drawable.news4, news4[0], news4[1], news4[2]));
        cards.add(new Card(R.drawable.news5, news5[0], news5[1], news5[2]));

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
        ((CardRecycleAdapter) mAdapter).setOnItemClickListener(
                new CardRecycleAdapter.CardClickListener() {
                    @Override
                    public void onItemClick(int position, View v) {
                        Card currentCard = cards.get(position);
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
                }
        );
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

}
