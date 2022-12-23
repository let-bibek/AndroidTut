package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Views_tut extends AppCompatActivity {
private String name;
private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views_tut);
    }
}