package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ParseJsonResponse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_json_response);

        String url="https://jsonplaceholder.typicode.com/users";//GET
        AndroidNetworking.initialize()
    }
}