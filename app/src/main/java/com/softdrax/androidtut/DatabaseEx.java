package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.softdrax.androidtut.database.DbHelper;

public class DatabaseEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_ex);
        DbHelper dbHelper=new DbHelper(this);
        dbHelper.addUsers("Bibek","kumarbibek094@gmail.com","987005600");
        dbHelper.addUsers("Sushil","Sushil@gmail.com","987005600");
        dbHelper.addUsers("Riya","Riya@gmail.com","987005600");
        dbHelper.addUsers("Aashish","Aashish@gmail.com","987005600");



    }
}