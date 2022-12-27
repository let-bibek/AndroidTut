package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class AnimationSamp extends AppCompatActivity {
    TextView tvAnimation;
    Button btnAnimTrans,btnAnimAlpha,btnAnimRot,btnAnimScale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animationsamp);
        tvAnimation=findViewById(R.id.tvAnimation);
        btnAnimTrans=findViewById(R.id.btnAnimTrans);
        btnAnimAlpha=findViewById(R.id.btnAnimAlpha);
        btnAnimRot=findViewById(R.id.btnAnimRot);
        btnAnimScale=findViewById(R.id.btnAnimScale);

        btnAnimTrans.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Animation move= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
               tvAnimation.startAnimation(move);
           }
       });

        btnAnimAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation alpha=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
                tvAnimation.startAnimation(alpha);
            }
        });

        btnAnimRot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation rotation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotation);
                tvAnimation.startAnimation(rotation);
            }
        });

        btnAnimScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation scale=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
                tvAnimation.startAnimation(scale);
            }
        });
    }
}