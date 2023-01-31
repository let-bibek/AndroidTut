package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SharedPreference extends AppCompatActivity {
Button btnSharedPreference,butSharedLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        btnSharedPreference=findViewById(R.id.btnSharedPreference);
        butSharedLogout=findViewById(R.id.butSharedLogout);
        btnSharedPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("progPass",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putBoolean("flag",true);
                editor.apply();
                Intent intent=new Intent(SharedPreference.this,intent_passing.class);
                startActivity(intent);
            }
        });
        butSharedLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("progPass",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putBoolean("flag",false);
                editor.apply();
                Intent intent=new Intent(SharedPreference.this,SplashActivity.class);
                startActivity(intent);
            }
        });

    }
}