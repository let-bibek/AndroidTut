package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewEx extends AppCompatActivity {
ListView lvListView;
Spinner spinnerLv;
AutoCompleteTextView actLv;
ArrayList<String> arrElectronics=new ArrayList<>();
ArrayList<String> arrId=new ArrayList<>();
ArrayList<String> arrName=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_viewex);
        getSupportActionBar().setTitle("List View");

//        lvListView=findViewById(R.id.lvListView);
        spinnerLv=findViewById(R.id.spinnerLv);
        actLv=findViewById(R.id.actLv);

        arrElectronics.add("Realme 9");
        arrElectronics.add("Redmi note 11s");
        arrElectronics.add("Samsung SM-J20F");
        arrElectronics.add("iPhone 14 pro max");
        arrElectronics.add("Toshiba satellite l805");
        arrElectronics.add("Fantech mouse 8");
        arrElectronics.add("Realme 9");
        arrElectronics.add("Redmi note 11s");
        arrElectronics.add("Samsung SM-J20F");
        arrElectronics.add("iPhone 14 pro max");
        arrElectronics.add("Toshiba satellite l805");
        arrElectronics.add("Fantech mouse 8");
        arrElectronics.add("Realme 9");
        arrElectronics.add("Redmi note 11s");
        arrElectronics.add("Samsung SM-J20F");
        arrElectronics.add("iPhone 14 pro max");
        arrElectronics.add("Toshiba satellite l805");
        arrElectronics.add("Fantech mouse 8");

//        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrElectronics);
//
//        lvListView.setAdapter(adapter);
//
//
//        lvListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position==1){
//                    Toast.makeText(ListViewEx.this, "Clicked on "+position+" item", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });


//  spinner
        arrId.add("Sm-12");
        arrId.add("Rm-8");
        arrId.add("ip-01");
        arrId.add("n-7");
        arrId.add("Sm-12");
        arrId.add("Sm-12");
        arrId.add("Sm-12");
        arrId.add("Sm-12");
        arrId.add("Sm-12");
        arrId.add("Sm-12");
        ArrayAdapter<String> adapterSpiner=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,arrId);
       spinnerLv.setAdapter(adapterSpiner);


//    auto complete
        arrName.add("Realme 9");
        arrName.add("Redmi note 11s");
        arrName.add("Samsung SM-J20F");
        arrName.add("iPhone 14 pro max");
        arrName.add("Toshiba satellite l805");
        arrName.add("Fantech mouse 8");
        arrName.add("Realme 9");
        arrName.add("Redmi note 11s");
        arrName.add("Samsung SM-J20F");
        arrName.add("iPhone 14 pro max");
        arrName.add("Toshiba satellite l805");
        arrName.add("Fantech mouse 8");
        arrName.add("Realme 9");
        arrName.add("Redmi note 11s");
        arrName.add("Samsung SM-J20F");
        arrName.add("iPhone 14 pro max");
        arrName.add("Toshiba satellite l805");
        arrName.add("Fantech mouse 8");
        ArrayAdapter<String> adapterPrice=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrName);
        actLv.setAdapter(adapterPrice);
        actLv.setThreshold(1);

    }



}





