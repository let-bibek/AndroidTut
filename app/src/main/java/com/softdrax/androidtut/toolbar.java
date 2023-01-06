package com.softdrax.androidtut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class toolbar extends AppCompatActivity {
Toolbar tbToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);


//        step one
        tbToolbar=findViewById(R.id.tbApp);
        setSupportActionBar(tbToolbar);

//        step two

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }


//        tbToolbar.setSubtitle("Home");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId=item.getItemId();
        if(itemId==R.id.menu_add_new){
            Toast.makeText(this, "Create new item", Toast.LENGTH_SHORT).show();
        }else if(itemId==R.id.menu_open){
            Toast.makeText(this, "Open item", Toast.LENGTH_SHORT).show();
        }else if(itemId==R.id.menu_save){
            Toast.makeText(this, "Save item", Toast.LENGTH_SHORT).show();
        }else if(itemId==android.R.id.home){
            super.onBackPressed();
        }else{
            Toast.makeText(this, "Closed", Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);

    }
}