package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class intent_passing extends AppCompatActivity {
Button btnToTtt,btnToBmi,btnToViews, btnBundlePassing,btnAnimation,btnAnimationLottie,btnListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_passing);
        nextIntent();
    }

    private void nextIntent() {
        btnToTtt=findViewById(R.id.btnToTtt);
        btnToBmi=findViewById(R.id.btnToBmi);
        btnToViews=findViewById(R.id.btnToViews);
        btnBundlePassing=findViewById(R.id.btnBundlePassing);
        btnAnimation=findViewById(R.id.btnAnimation);
        btnAnimationLottie=findViewById(R.id.btnAnimationLottie);
        btnListView=findViewById(R.id.btnListView);
//        executes on clicking button btnNextIntent
        btnToTtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                intent constructor accepts the current activity class(intent_passing) and the next activity class(tiktactoe) where you want to navigate to
                Intent nextIntent=new Intent(intent_passing.this,tiktactoe.class);

                startActivity(nextIntent);
            }
        });

//        bmi
        btnToBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bmiIntent=new Intent(intent_passing.this,BMICalculator.class);
                startActivity(bmiIntent);
            }
        });

//        views
        btnToViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnToViews=new Intent(intent_passing.this,Views_tut.class);
                startActivity(btnToViews);
            }
        });

//        bundle passing
        btnBundlePassing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bundleIntent=new Intent(intent_passing.this,BundlePassing.class);
                bundleIntent.putExtra("Title","Student Details");
                bundleIntent.putExtra("Roll",82);
                bundleIntent.putExtra("StudentName","ibek");
                startActivity(bundleIntent);

            }
        });

//        animation

        btnAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent animationSamp=new Intent(intent_passing.this,AnimationSamp.class);
                startActivity(animationSamp);

            }
        });

//        Lottie animation

        btnAnimationLottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lottie=new Intent(intent_passing.this,LottieAnim.class);
                startActivity(lottie);

            }
        });

//        list view
        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listView=new Intent(getApplicationContext(),ListViewEx.class);
                startActivity(listView);

            }
        });

    }
}