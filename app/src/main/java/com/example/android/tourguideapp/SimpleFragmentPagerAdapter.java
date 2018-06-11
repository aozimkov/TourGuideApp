package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by def on 10.06.18.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    //Setup fragments
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new NewsFragment();
        } else if(position == 1) {
            return new FoodFragment();
        } else if (position == 2) {
            return new LocationsFragment();
        } else {
            return new HotelsFragment();
        }
    }

    //Fragments Quantity
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return mContext.getString(R.string.news);
        } else if(position == 1) {
            return mContext.getString(R.string.food);
        } else if (position == 2) {
            return mContext.getString(R.string.locations);
        } else {
            return mContext.getString(R.string.hotels);
        }
    }
}
