package com.example.android.tourguideapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define Tabs and pager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

        // Setup ViewPager
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this,
                getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        // Setup Tabs
        tabLayout.setupWithViewPager(viewPager);

    }
}
