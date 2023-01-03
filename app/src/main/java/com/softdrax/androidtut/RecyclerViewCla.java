package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewCla extends AppCompatActivity {
    RecyclerView rvPlaces;
    ArrayList<PlaceModel> arrPlaceModel = new ArrayList<>();

    Button btnAddList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_cla);

        getSupportActionBar().setTitle("Recycler View");

        rvPlaces = findViewById(R.id.rvPlaces);

//        StaggeredGridLayoutManager rvLayout=new StaggeredGridLayoutManager(2,1);

//        rvPlaces.setLayoutManager(rvLayout);
        rvPlaces.setLayoutManager(new LinearLayoutManager(this));

        arrPlaceModel.add(new PlaceModel(R.drawable.code, "Ghandruk", "Kaski, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.ic_baseline_place_24, "Dhampus", "Kaski, 1 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.ic_launcher_background, "Mustang", "Mustang, 5 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.ic_launcher_foreground, "Ghandruk", "Kaski, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.ic_baseline_send_24, "Kathmandu", "Kathmandu, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code, "Dhading", "Dhading, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code, "Lumbini", "Lumbini, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code, "Ilam", "Ilam, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code, "Godainkunda", "Rasuwa, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code, "Nuwakot", "Nuwakot, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code, "Ghandruk", "Kaski, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code, "Dharke", "Kaski, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code, "Ghandruk", "Kaski, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code, "Phyakse", "Kaski, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code, "Ghandruk", "Kaski, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code, "Khalte", "Kaski, 2 days trip"));
        arrPlaceModel.add(new PlaceModel(R.drawable.code, "Shyaldadan", "Kaski, 2 days trip"));

        RecyclerPlaceAdapter adapter = new RecyclerPlaceAdapter(this, arrPlaceModel);
        rvPlaces.setAdapter(adapter);

//CRUD
        btnAddList = findViewById(R.id.btnAddList);

        btnAddList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(RecyclerViewCla.this);
                dialog.setContentView(R.layout.add_update);

                EditText etEditAddPlace, etEditAddLocation, etEditAddDesc;
                Button btnAddUpdate;

                etEditAddPlace = dialog.findViewById(R.id.etEditAddPlace);
                etEditAddLocation = dialog.findViewById(R.id.etEditAddLocation);
                etEditAddDesc = dialog.findViewById(R.id.etEditAddDesc);
                btnAddUpdate = dialog.findViewById(R.id.btnAddUpdate);

                btnAddUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String place = "", location = "", description = "";
                        if (!etEditAddPlace.getText().toString().equals("")) {

                            place = etEditAddPlace.getText().toString();
                        }else {
                            Toast.makeText(RecyclerViewCla.this, "Add place name", Toast.LENGTH_SHORT).show();
                        }
                        if (!etEditAddLocation.getText().toString().equals("")) {
                            location = etEditAddLocation.getText().toString();

                        }else {
                            Toast.makeText(RecyclerViewCla.this, "Add location", Toast.LENGTH_SHORT).show();
                        }
                        if (!etEditAddDesc.getText().toString().equals("")) {
                            description = etEditAddDesc.getText().toString();

                        } else {
                            Toast.makeText(RecyclerViewCla.this, "Add Description", Toast.LENGTH_SHORT).show();
                        }

                        if(!(place.equals("")||location.equals(""))){
                            arrPlaceModel.add(new PlaceModel(R.drawable.ic_baseline_send_24,place, location, description));
//                        array position
                            int position = arrPlaceModel.size() - 1;

                            adapter.notifyItemInserted(position);

                            rvPlaces.scrollToPosition(position);

                            dialog.dismiss();
                        }
                    }

                });
                dialog.show();
            }
        });
    }
}