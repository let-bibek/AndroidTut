package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
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
        Animation loaderOne= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.loader_one);

        Animation loaderTwo= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.loader_two);

        Animation loaderThree= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.loader_three);

        lod1.startAnimation(loader);
        lod2.startAnimation(loaderOne);
        lod3.startAnimation(loaderTwo);
        lod4.startAnimation(loaderThree);
        Intent iHome=new Intent(SplashActivity.this,intent_passing.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(iHome);

                finish();
            }
        },3000);

    }
}