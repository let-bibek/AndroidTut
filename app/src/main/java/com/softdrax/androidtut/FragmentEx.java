package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class FragmentEx extends AppCompatActivity {
    private static final String ROOT_FRAGMENT_TAG = "root_fragment";
    Button btnFragA, btnFragB, btnFragC;
    FrameLayout flFragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_ex);

        btnFragA = findViewById(R.id.btnFragA);
        btnFragB = findViewById(R.id.btnFragB);
        btnFragC = findViewById(R.id.btnFragC);
        flFragmentContainer = findViewById(R.id.flFragmentContainer);
        loadFragment(TopGainerFragment.getInstance("This is TopGainer Fragment", 58), 0);
        btnFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                this one is a default fragment because we have given 0 flag for this one and other have 1 flag

                //        data passing in fragment
                loadFragment(TopGainerFragment.getInstance("This is TopGainer Fragment", 58), 0);
            }
        });

        btnFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ExampleTwoFragment();
                loadFragment(fragment, 1);
            }
        });

        btnFragC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ExampleThreeFragment();
                loadFragment(fragment, 1);
            }
        });
    }

    private void loadFragment(Fragment fragment, int flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

//        data passing in fragment

//        Bundle bundle=new Bundle();
//        bundle.putString("fragment","This is data passed using fragment");
//        bundle.putInt("arg1",52);
//        fragment.setArguments(bundle);
        if (flag == 0) {
            ft.add(R.id.flFragmentContainer, fragment);
            fm.popBackStack(ROOT_FRAGMENT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack(ROOT_FRAGMENT_TAG);

        } else {
            ft.replace(R.id.flFragmentContainer, fragment);
            ft.addToBackStack(null);
        }

        ft.commit();
    }
}