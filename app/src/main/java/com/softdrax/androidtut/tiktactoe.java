package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tiktactoe extends AppCompatActivity {
Button ttcBtn1,ttcBtn2,ttcBtn3,ttcBtn4,ttcBtn5,ttcBtn6,ttcBtn7,ttcBtn8,ttcBtn9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiktactoe);
        init();


    }
    private void init(){
        ttcBtn1=findViewById(R.id.tttBtn1);
        ttcBtn3=findViewById(R.id.tttBtn2);
        ttcBtn3=findViewById(R.id.tttBtn3);
        ttcBtn4=findViewById(R.id.tttBtn4);
        ttcBtn5=findViewById(R.id.tttBtn5);
        ttcBtn6=findViewById(R.id.tttBtn6);
        ttcBtn7=findViewById(R.id.tttBtn7);
        ttcBtn8=findViewById(R.id.tttBtn8);
        ttcBtn9=findViewById(R.id.tttBtn9);
    }
    public void check(View view){

    }
}