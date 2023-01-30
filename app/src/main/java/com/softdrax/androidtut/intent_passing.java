package com.softdrax.androidtut;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class intent_passing extends AppCompatActivity {
    Button btnToTtt, btnToBmi, btnToViews, btnBundlePassing, btnAnimation, btnAnimationLottie, btnListView, btnCardView;
    Button btnRecyclerView, btnToolbar, btnCusDialog, btnToNotification, btnToCusNotification;
    Button btnToImplicitIntent, btnToFragmentEx, btnToTabLayout, btnToBottomNavigation, btnToNavigationDrawer;
    Button btnToGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_passing);
        nextIntent();
    }

    private void nextIntent() {
        btnToTtt = findViewById(R.id.btnToTtt);
        btnToBmi = findViewById(R.id.btnToBmi);
        btnToViews = findViewById(R.id.btnToViews);
        btnBundlePassing = findViewById(R.id.btnBundlePassing);
        btnAnimation = findViewById(R.id.btnAnimation);
        btnAnimationLottie = findViewById(R.id.btnAnimationLottie);
        btnListView = findViewById(R.id.btnListView);
        btnCardView = findViewById(R.id.btnCardView);
        btnRecyclerView = findViewById(R.id.btnRecyclerView);
//        executes on clicking button btnNextIntent
        btnToTtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                intent constructor accepts the current activity class(intent_passing) and the next activity class(tiktactoe) where you want to navigate to
                Intent nextIntent = new Intent(intent_passing.this, tiktactoe.class);

                startActivity(nextIntent);
            }
        });

//        bmi
        btnToBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bmiIntent = new Intent(intent_passing.this, BMICalculator.class);
                startActivity(bmiIntent);
            }
        });

//        views
        btnToViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnToViews = new Intent(intent_passing.this, Views_tut.class);
                startActivity(btnToViews);
            }
        });

//        bundle passing
        btnBundlePassing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bundleIntent = new Intent(intent_passing.this, BundlePassing.class);
                bundleIntent.putExtra("Title", "Student Details");
                bundleIntent.putExtra("Roll", 82);
                bundleIntent.putExtra("StudentName", "ibek");
                startActivity(bundleIntent);

            }
        });

//        animation

        btnAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent animationSamp = new Intent(intent_passing.this, AnimationSamp.class);
                startActivity(animationSamp);

            }
        });

//        Lottie animation

        btnAnimationLottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lottie = new Intent(intent_passing.this, LottieAnim.class);
                startActivity(lottie);

            }
        });

//        list view
        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listView = new Intent(getApplicationContext(), ListViewEx.class);
                startActivity(listView);

            }
        });

//        card view
        btnCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cvIntent = new Intent(intent_passing.this, CardViewCla.class);
                startActivity(cvIntent);
            }
        });

//        recycler view
        btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnRecyclerView = new Intent(intent_passing.this, RecyclerViewCla.class);
                startActivity((btnRecyclerView));
            }
        });

//        toolbar

        btnToolbar = findViewById(R.id.btnToolbar);

        btnToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToolbar = new Intent(intent_passing.this, toolbar.class);
                startActivity(intentToolbar);
            }
        });


//        custom toast

        Button btnCusToast = findViewById(R.id.btnToast);

        btnCusToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cusIntent = new Intent(intent_passing.this, custom_toast.class);

                startActivity(cusIntent);
            }
        });

        btnCusToast.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(intent_passing.this)
                        .setTitle("Enter")
                        .setMessage("Are you sure?")
                        .setIcon(R.drawable.ic_baseline_warning_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent cusIntent = new Intent(intent_passing.this, custom_toast.class);

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
                Log.d("Tag:", "Message");
                return true;
            }
        });

//        Custom dialog box
        btnCusDialog = findViewById(R.id.btnCusDialog);


        btnCusDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Dialog cusDialog = new Dialog(intent_passing.this);
                cusDialog.setContentView(R.layout.custom_dialog);

                Button dialEnter, btnDialogCancel;


                dialEnter = cusDialog.findViewById(R.id.btnDialog);
                btnDialogCancel = cusDialog.findViewById(R.id.btnDialogCancel);

                btnDialogCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cusDialog.dismiss();
                    }
                });
                dialEnter.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View v) {


                        EditText dialPass;
                        String etDialPass;
                        dialPass = (EditText) cusDialog.findViewById(R.id.etDialogPass);
                        etDialPass = dialPass.getText().toString();


                        if (etDialPass.equals("password")) {

                            Intent btnCusDialogIntent = new Intent(intent_passing.this, CustomDialog.class);
                            startActivity(btnCusDialogIntent);

                        } else {
                            Toast alertToast = new Toast(intent_passing.this);

                            View alertView = getLayoutInflater()
                                    .inflate(R.layout.password_error, (ViewGroup) findViewById(R.id.passwordWarningViewGroup));

                            alertToast.setView(alertView);

                            alertToast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP, 0, 0);
                            alertToast.show();
                        }
                    }
                });
                cusDialog.setCancelable(false);
                cusDialog.show();

            }
        });


//        Notification

        btnToNotification = findViewById(R.id.btnToNotification);

        btnToNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnToNotificationIntent = new Intent(intent_passing.this, NotificationClass.class);
                startActivity(btnToNotificationIntent);
            }
        });


//        custom notification


        btnToCusNotification = findViewById(R.id.btnToCusNotification);

        btnToCusNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnToCusNotificationIntent = new Intent(intent_passing.this, CustomNotification.class);
                startActivity(btnToCusNotificationIntent);
            }
        });


//        implicit intent passing
        btnToImplicitIntent = findViewById(R.id.btnToImplicitIntent);
        btnToImplicitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent implicitIntent = new Intent(intent_passing.this, ImplicitIntentPassing.class);
                startActivity(implicitIntent);
            }
        });


//        fragment

        btnToFragmentEx = findViewById(R.id.btnToFragmentEx);

        btnToFragmentEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fragmentIntent = new Intent(intent_passing.this, FragmentEx.class);
                startActivity(fragmentIntent);
            }
        });

//        Tab Layout

        btnToTabLayout = findViewById(R.id.btnToTabLayout);

        btnToTabLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tabIntent = new Intent(intent_passing.this, TabActivity.class);
                startActivity(tabIntent);
            }
        });

//        bottom navigation

        btnToBottomNavigation = findViewById(R.id.btnToBottomNavigation);
        btnToBottomNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bottomNav = new Intent(intent_passing.this, BottomNavigationActivity.class);
                startActivity(bottomNav);
            }
        });


//        navigation drawer

        btnToNavigationDrawer = findViewById(R.id.btnToNavigationDrawer);
        btnToNavigationDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navDrawerIntent = new Intent(intent_passing.this, NavigationDrawer.class);
                startActivity(navDrawerIntent);
            }
        });

//        Google map
        btnToGoogleMap=findViewById(R.id.btnToGoogleMap);
        btnToGoogleMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gMapIntent=new Intent(intent_passing.this,MapsActivity.class);
                startActivity(gMapIntent);
            }
        });


    }
}