package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ImplicitIntentPassing extends AppCompatActivity {
Button btnButtonDial,btnButtonMsg,btnButtonEmail,btnButtonShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent_passing);

        btnButtonDial=findViewById(R.id.btnButtonDial);
        btnButtonMsg=findViewById(R.id.btnButtonMsg);
        btnButtonEmail=findViewById(R.id.btnButtonEmail);
        btnButtonShare=findViewById(R.id.btnButtonShare);

        btnButtonDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialIntent=new Intent(Intent.ACTION_DIAL);
                dialIntent.setData();
            }
        });



    }
}