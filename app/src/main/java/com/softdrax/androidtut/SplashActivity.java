package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
TextView lod1,lod2,lod3,lod4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        lod1=findViewById(R.id.lod1);
        lod2=findViewById(R.id.lod2);
        lod3=findViewById(R.id.lod3);
        lod4=findViewById(R.id.lod4);

        Animation loader= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.loader);
        lod1.startAnimation(loader);
        lod2.startAnimation(loader);
        lod3.startAnimation(loader);
        lod4.startAnimation(loader);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences=getSharedPreferences("progPass",MODE_PRIVATE);
                Boolean cond=sharedPreferences.getBoolean("flag",false);
                Intent intentHome;
                if(cond){// user is logged in
                    intentHome=new Intent(SplashActivity.this,intent_passing.class);
                }else{ // either first time or user is logged out
                    intentHome=new Intent(SplashActivity.this,SharedPreference.class);
                }
                startActivity(intentHome);


                finish();
            }
        },2000);

    }
}