package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalculator extends AppCompatActivity {
private int weight,heightFt,heightIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);

        TextView tvResult;
        EditText etWeight,etHeightFt,etHeightIn;
        Button btnCalc;

        etWeight=findViewById(R.id.etWeight);
    }
}