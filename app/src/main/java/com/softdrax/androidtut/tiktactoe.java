package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tiktactoe extends AppCompatActivity {
Button ttcBtn1,ttcBtn2,ttcBtn3,ttcBtn4,ttcBtn5,ttcBtn6,ttcBtn7,ttcBtn8,ttcBtn9;
String btnVAl1,btnVAl2,btnVAl3,btnVAl4,btnVAl5,btnVAl6,btnVAl7,btnVAl8,btnVAl9;
TextView tvStatus;
int flag=0;
int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiktactoe);
        init();


    }
    private void init(){
        ttcBtn1=findViewById(R.id.tttBtn1);
        ttcBtn2=findViewById(R.id.tttBtn2);
        ttcBtn3=findViewById(R.id.tttBtn3);
        ttcBtn4=findViewById(R.id.tttBtn4);
        ttcBtn5=findViewById(R.id.tttBtn5);
        ttcBtn6=findViewById(R.id.tttBtn6);
        ttcBtn7=findViewById(R.id.tttBtn7);
        ttcBtn8=findViewById(R.id.tttBtn8);
        ttcBtn9=findViewById(R.id.tttBtn9);
    }
    public void check(View view){
        Button btnCurrent=(Button)view;
        count++;
        if(flag==0){
            btnCurrent.setText("o");
            flag=1;
        }else{
            btnCurrent.setText("x");
            flag=0;
        }

        if(count>4){
           btnVAl1=ttcBtn1.getText().toString();
            btnVAl2=ttcBtn2.getText().toString();
            btnVAl3=ttcBtn3.getText().toString();
            btnVAl3=ttcBtn3.getText().toString();
            btnVAl4=ttcBtn4.getText().toString();
            btnVAl5=ttcBtn5.getText().toString();
            btnVAl6=ttcBtn6.getText().toString();
            btnVAl7=ttcBtn7.getText().toString();
            btnVAl8=ttcBtn8.getText().toString();
            btnVAl9=ttcBtn9.getText().toString();


            if(btnVAl1.equals(btnVAl2)){
                if(btnVAl1.equals(btnVAl3)){
                    tvStatus.setText("Winner is: x");
                }

            }

        }
    }
}