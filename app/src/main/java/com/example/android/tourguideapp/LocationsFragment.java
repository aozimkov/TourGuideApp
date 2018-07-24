package com.example.android.tourguideapp;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationsFragment extends Fragment {

    @BindArray(R.array.location_array_1) String[] location1;
    @BindArray(R.array.location_array_2) String[] location2;
    @BindArray(R.array.location_array_3) String[] location3;
    @BindArray(R.array.location_array_4) String[] location4;
    @BindArray(R.array.location_array_5) String[] location5;
    @BindArray(R.array.location_array_6) String[] location6;

    @BindView(R.id.card_recycle)
    RecyclerView mRecycleView;

    private Unbinder unbinder;

    private ArrayList<Card> cards = new ArrayList<>();

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public LocationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.card_recycle_grid, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        cards.add(new Card(
                R.drawable.location1, location1[0], location1[1], location1[2], location1[3]));
        cards.add(new Card(
                 R.drawable.location2, location1[0], location1[1], location1[2], location1[3]));
        cards.add(new Card(
                 R.drawable.location3, location1[0], location1[1], location1[2], location1[3]));
        cards.add(new Card(
                 R.drawable.location4, location1[0], location1[1], location1[2], location1[3]));
        cards.add(new Card(
                 R.drawable.location5, location1[0], location1[1], location1[2], location1[3]));
        cards.add(new Card(
                 R.drawable.location6, location1[0], location1[1], location1[2], location1[3]));

        mLayoutManager = new GridLayoutManager(getContext(), 2 );
        mRecycleView.setLayoutManager(mLayoutManager);
        mAdapter = new CardRecycleAdapter(cards, "grid");
        mRecycleView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(),
                GridLayoutManager.VERTICAL);
       mRecycleView.addItemDecoration(itemDecoration);


//        CardAdapter adapter = new CardAdapter(getActivity(), cards, "grid");
//        gridView.setAdapter(adapter);
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                Card currentCard = cards.get(i);
//                Intent intent = new Intent();
//
//                /**
//                 * Add data to intent for moving it to single card
//                 */
//
//                if(currentCard.hasCardImage()) intent.putExtra(
//                        "image", currentCard.getmImage());
//                if(currentCard.hasCoordinates()) {
//                    intent.putExtra("lat", currentCard.getmLat());
//                    intent.putExtra("lon", currentCard.getmLon());
//                }
//                intent.putExtra("header", currentCard.getmHeader());
//                intent.putExtra("description", currentCard.getmDescription());
//
//                intent.setClass(getActivity(), SingleActivity.class);
//                startActivity(intent);
//            }
//        });

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
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
