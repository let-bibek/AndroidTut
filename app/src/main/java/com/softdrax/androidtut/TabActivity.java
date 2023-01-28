package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {
TabLayout tlTabLayoutEx;
ViewPager vpTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);


        tlTabLayoutEx=findViewById(R.id.tlTabLayoutEx);
        vpTabLayout=findViewById(R.id.vpTabLayoutEx);

        ViewPagerTopStocksAdapter viewPagerTopStocksAdapter=new ViewPagerTopStocksAdapter(getSupportFragmentManager());

        vpTabLayout.setAdapter(viewPagerTopStocksAdapter);
        tlTabLayoutEx.setupWithViewPager(vpTabLayout);
    }
}