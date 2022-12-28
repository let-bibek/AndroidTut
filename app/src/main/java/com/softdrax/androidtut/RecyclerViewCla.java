package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class RecyclerViewCla extends AppCompatActivity {
RecyclerView rvPlaces;
ArrayList<PlaceModel> arrPlaceModel=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_cla);
        getSupportActionBar().setTitle("Recycler View");
        rvPlaces=findViewById(R.id.rvPlaces);

//        StaggeredGridLayoutManager rvLayout=new StaggeredGridLayoutManager(2,1);

//        rvPlaces.setLayoutManager(rvLayout);
rvPlaces.setLayoutManager(new LinearLayoutManager(this));
        arrPlaceModel.add(new PlaceModel(R.drawable.code,"Ghandruk","Kaski, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.ic_baseline_place_24,"Dhampus","Kaski, 1 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.ic_launcher_background,"Mustang","Mustang, 5 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.ic_launcher_foreground,"Ghandruk","Kaski, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.ic_baseline_send_24,"Kathmandu","Kathmandu, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code,"Dhading","Dhading, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code,"Lumbini","Lumbini, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code,"Ilam","Ilam, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code,"Godainkunda","Rasuwa, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code,"Nuwakot","Nuwakot, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code,"Ghandruk","Kaski, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code,"Dharke","Kaski, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code,"Ghandruk","Kaski, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code,"Phyakse","Kaski, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code,"Ghandruk","Kaski, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code,"Khalte","Kaski, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code,"Shyaldadan","Kaski, 2 days trip"));

        RecyclerPlaceAdapter adapter=new RecyclerPlaceAdapter(getApplicationContext(),arrPlaceModel);
        rvPlaces.setAdapter(adapter);

    }
}