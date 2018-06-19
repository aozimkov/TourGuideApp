package com.example.android.tourguideapp;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity{

    private static final int TYPE_LIST = 1;
    private static final int TYPE_GRID = 2;

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
