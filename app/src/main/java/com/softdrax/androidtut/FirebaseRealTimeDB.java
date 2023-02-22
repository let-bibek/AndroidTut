package com.softdrax.androidtut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.softdrax.androidtut.model.FirebaseContactModel;

public class FirebaseRealTimeDB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_real_time_db);

//        sending data to firebase database

//        single node data
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Copyright");
        databaseReference.setValue("Bibek Shrestha, All right reserved.");

//       multiple nested child data
        DatabaseReference contactRef = FirebaseDatabase.getInstance().getReference("Contact");
        String contactID = contactRef.push().getKey();
        FirebaseContactModel firebaseContactModel = new FirebaseContactModel("Shushil Shrestha", "981047852");
        contactRef.child(contactID).setValue(firebaseContactModel);

//    receiving data

        contactRef.child(contactID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String dbFetchModel=snapshot.getValue(String.class);
//
//                Log.d("FIREBASE_DATA", "Name: "+dbFetchModel);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("ERROR","Database Error!!");
            }
        });



    }




}