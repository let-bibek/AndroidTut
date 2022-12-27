package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class LottieAnim extends AppCompatActivity {
    LottieAnimationView laView;
    Button btnPlayLottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_anim);
        laView = findViewById(R.id.laView);
        btnPlayLottie = findViewById(R.id.btnPlayLottie);
        btnPlayLottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                laView.setAnimation(R.raw.lottie);
                laView.playAnimation();
            }
        });
    }
}