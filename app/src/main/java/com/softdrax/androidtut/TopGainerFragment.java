package com.softdrax.androidtut;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TopGainerFragment extends Fragment {

    private static final String ARG1 = "fragment1String";
    private static final String ARG2 = "fragment2Integer";

    public TopGainerFragment() {
        // Required empty public constructor
    }

    //    to get fragment data
    public static TopGainerFragment getInstance(String Stringvalue, int Intvalue) {
        TopGainerFragment topGainerFragment = new TopGainerFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG1, Stringvalue);
        bundle.putInt(ARG2, Intvalue);
        topGainerFragment.setArguments(bundle);
        return topGainerFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (getArguments() != null) {
            String statement = getArguments().getString(ARG1);
            int arg1 = getArguments().getInt(ARG2);

//            Log.d("Values from Act", "Fragment is : " + statement + "Value is : " + arg1);
        }
        return inflater.inflate(R.layout.fragment_top_gainer, container, false);
    }
}