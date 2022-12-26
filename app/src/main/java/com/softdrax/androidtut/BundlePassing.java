package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class BundlePassing extends AppCompatActivity {
EditText etBundleTitle,etBundleName,etBundleRoll;
TextView tvBundleData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle_passing);

        Intent getBundleFromIntentPassing=getIntent();

        String title=getBundleFromIntentPassing.getStringExtra("Title");
        String name=getBundleFromIntentPassing.getStringExtra("StudentName");
        int roll=getBundleFromIntentPassing.getIntExtra("Roll",0);

        etBundleTitle=findViewById(R.id.etBundleTitle);
        etBundleName=findViewById(R.id.etBundleName);
        etBundleRoll=findViewById(R.id.etBundleRoll);

        tvBundleData=findViewById(R.id.tvBundleData);

        etBundleTitle.setText("title");
        etBundleName.setText("name");
        etBundleRoll.setText("roll");
        tvBundleData.setText("Student roll number is "+roll+". The name of student is "+name);
        getSupportActionBar().setTitle(title);


    }


}