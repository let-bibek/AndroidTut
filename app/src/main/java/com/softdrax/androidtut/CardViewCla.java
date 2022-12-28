package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class CardViewCla extends AppCompatActivity {
CardView cvExz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_cla);

        getSupportActionBar().setTitle("Card View");


        cvExz=findViewById(R.id.cvExz);

        cvExz.setRadius(7);
        cvExz.setElevation(7);
        cvExz.setUseCompatPadding(true);
    }
}