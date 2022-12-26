package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
        LinearLayout lLout;

        etWeight=findViewById(R.id.etWeight);
        etHeightFt=findViewById(R.id.etHeightFt);
        etHeightIn=findViewById(R.id.etHeightIn);
        btnCalc=findViewById(R.id.btnCalculate);
        tvRes=findViewById(R.id.tvResultBmi);
        lLout=findViewById(R.id.lLout);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
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
                   tvRes.setText("You are over weight");
                   lLout.setBackgroundColor(getColor(R.color.danger));
               }
               else if(BMI<15){
                   tvRes.setText("You are under weight");
                   lLout.setBackgroundColor(getColor(R.color.warning));

               }
               else{
                   tvRes.setText("You seem to be healthy");
                   lLout.setBackgroundColor(getColor(R.color.success));

               }
            }
        });
        getSupportActionBar().setTitle("BMI calculator");

    }

}