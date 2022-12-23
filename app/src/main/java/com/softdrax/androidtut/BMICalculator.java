package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class BMICalculator extends AppCompatActivity {
private int weight,heightFt,heightIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);

        EditText etWeight,etHeightFt,etHeightIn;
        Button btnCalc;
        TextView tvRes;

        etWeight=findViewById(R.id.etWeight);
        etHeightFt=findViewById(R.id.etHeightFt);
        etHeightIn=findViewById(R.id.etHeightIn);
        btnCalc=findViewById(R.id.btnCalculate);
        tvRes=findViewById(R.id.tvResultBmi);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               weight= Integer.parseInt( etWeight.getText().toString());
               heightFt=Integer.parseInt(etHeightFt.getText().toString());
               heightIn=Integer.parseInt(etHeightIn.getText().toString());

               int totalIn=heightFt*12+heightIn;
               double heightCm=totalIn*2.53;
               double totalHeightM=heightCm/100;
               double BMI=weight/(Math.pow(totalHeightM,2));
               if(BMI>25){
                   tvRes.setText("You are over weight.");
               }
               else{
                   tvRes.setText("You seem to be healthy.");
               }
            }
        });
    }

}