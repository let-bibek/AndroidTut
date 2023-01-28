package com.softdrax.androidtut;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerTopStocksAdapter extends FragmentPagerAdapter {


    public ViewPagerTopStocksAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new TopGainerFragment();
        }else if(position==1){
            return new TopLoserFragment();
        }else{
            return new TopTurnoverFragment();
        }
    }

    @Override
    public int getCount() {
        return 3; // number of tabs
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Top Gainers";
        }else if(position==1){
            return "Top Losers";
        }else{
            return "Top Turnovers";
        }
    }
}
