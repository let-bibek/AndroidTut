package com.softdrax.androidtut;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class intent_passing extends AppCompatActivity {
Button btnToTtt,btnToBmi,btnToViews, btnBundlePassing,btnAnimation,btnAnimationLottie,btnListView,btnCardView;
Button btnRecyclerView,btnToolbar;
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
        btnCardView=findViewById(R.id.btnCardView);
        btnRecyclerView=findViewById(R.id.btnRecyclerView);
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

//        card view
        btnCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cvIntent=new Intent(intent_passing.this,CardViewCla.class);
                startActivity(cvIntent);
            }
        });

//        recycler view
        btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnRecyclerView=new Intent(intent_passing.this,RecyclerViewCla.class);
                startActivity((btnRecyclerView));
            }
        });

//        toolbar

        btnToolbar=findViewById(R.id.btnToolbar);

        btnToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToolbar=new Intent(intent_passing.this,toolbar.class);
                startActivity(intentToolbar);
            }
        });


//        custom toast

        Button btnCusToast=findViewById(R.id.btnToast);

        btnCusToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cusIntent=new Intent(intent_passing.this,custom_toast.class);

                startActivity(cusIntent);
            }
        });

        btnCusToast.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(intent_passing.this)
                        .setTitle("Enter")
                        .setMessage("Are you sure?")
                        .setIcon(R.drawable.ic_baseline_warning_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent cusIntent=new Intent(intent_passing.this,custom_toast.class);

                                startActivity(cusIntent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(intent_passing.this, "Cancelled", Toast.LENGTH_SHORT).show();
                            }
                        });
                alertDialog.show();
                Log.d("Tag:","Message");
                return true;
            }
        });


    }
}