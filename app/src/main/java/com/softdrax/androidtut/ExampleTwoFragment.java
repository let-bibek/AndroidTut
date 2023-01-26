package com.softdrax.androidtut;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ExampleTwoFragment extends Fragment {



    public ExampleTwoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_example_two, container, false);
        TextView textView=view.findViewById(R.id.tvFragmentExTwo);
        return view;
    }
}