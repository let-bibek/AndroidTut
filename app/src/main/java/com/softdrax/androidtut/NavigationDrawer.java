package com.softdrax.androidtut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class NavigationDrawer extends AppCompatActivity {
    DrawerLayout dlNavDrawer;
    NavigationView nvNavDrawer;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        dlNavDrawer = findViewById(R.id.dlNavDrawer);
        nvNavDrawer = findViewById(R.id.nvNavDrawer);
        toolbar = findViewById(R.id.tbNavDrawer);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                NavigationDrawer.this, dlNavDrawer, toolbar,
                R.string.openDrawer, R.string.closeDrawer);
        dlNavDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        nvNavDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();
                if(id==R.id.ndItemChats){
                    Fragment fragment=new BottomNavAFragment();
                    loadFragment(fragment,1);
                }else if(id==R.id.ndItemMarketplace){
                    Fragment fragment=new ExampleThreeFragment();
                    loadFragment(fragment,0);
                }else if(id==R.id.ndItemMessageReq){
                    Fragment fragment=new TopTurnoverFragment();
                    loadFragment(fragment,0);
                }else if(id==R.id.ndItemArchives){
                    Fragment fragment=new TopGainerFragment();
                    loadFragment(fragment,0);
                }else if(id==R.id.ndItemSettings){
                    Fragment fragment=new TopLoserFragment();
                    loadFragment(fragment,0);
                }else{
                        finish();
                }
                dlNavDrawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(dlNavDrawer.isDrawerOpen(GravityCompat.START)){
            dlNavDrawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment, int flag) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
       if(flag==1){
           ft.add(R.id.flMainContainer,fragment);
       }else{

        ft.replace(R.id.flMainContainer,fragment);
       }
       ft.commit();
    }
}