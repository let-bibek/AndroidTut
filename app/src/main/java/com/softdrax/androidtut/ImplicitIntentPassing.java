package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ImplicitIntentPassing extends AppCompatActivity {
    Button btnButtonDial, btnButtonMsg, btnButtonEmail, btnButtonShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent_passing);

        btnButtonDial = findViewById(R.id.btnButtonDial);
        btnButtonMsg = findViewById(R.id.btnButtonMsg);
        btnButtonEmail = findViewById(R.id.btnButtonEmail);
        btnButtonShare = findViewById(R.id.btnButtonShare);

//        call
        btnButtonDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:+9779810040057"));
                startActivity(dialIntent);
            }
        });

//        message

        btnButtonMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msgIntent = new Intent(Intent.ACTION_SENDTO);
                msgIntent.setData(Uri.parse("smsto:" + Uri.encode("+9779810040057")));
                msgIntent.putExtra("sms_body", "I love you so much babe.\uD83D\uDE0D");
                startActivity(msgIntent);
            }
        });

//        email

        btnButtonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"kumarbiek094@gmail.com", "refund@naasasecurities.com.np"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Refund");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Please refund my money as soon as possible.");
                startActivity(Intent.createChooser(emailIntent, "Email via"));
            }
        });

//        share
        btnButtonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent=new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT,"Download this amazing application for free, Link: https://www.bibekshrestha.info.np");
                startActivity(Intent.createChooser(shareIntent,"Share via"));
            }
        });


    }
}