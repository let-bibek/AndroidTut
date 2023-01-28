package com.softdrax.androidtut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationActivity extends AppCompatActivity {
BottomNavigationView bnBottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        bnBottomNavigation=findViewById(R.id.bnBottomNavigation);
       bnBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               int id=item.getItemId();

               if(id==R.id.menuItemHome){
                   Fragment fragment=new BottomNavAFragment();
                   loadFragment(fragment,0);
               } else if (id == R.id.menuItemAccount) {
                   Fragment fragment=new TopLoserFragment();
                   loadFragment(fragment,1);

               }else if(id==R.id.menuItemMenu){
                   Fragment fragment=new TopTurnoverFragment();
                   loadFragment(fragment,1);
               }else{
                   Fragment fragment=new ExampleThreeFragment();
                   loadFragment(fragment,1);

               }
               return true;
           }
       });
    }

    private void loadFragment(Fragment fragment,int flag) {

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag==0){
            ft.add(R.id.flBottomNav,fragment);

        }
        else
            ft.replace(R.id.flBottomNav,fragment);

        ft.commit();
    }
}