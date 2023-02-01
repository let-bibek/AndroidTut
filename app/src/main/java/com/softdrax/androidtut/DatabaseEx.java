package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.softdrax.androidtut.database.DbHelper;
import com.softdrax.androidtut.model.UsersModel;

import java.util.ArrayList;

public class DatabaseEx extends AppCompatActivity {
    TextView tvDatabaseSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_ex);
        tvDatabaseSample = findViewById(R.id.tvDatabaseSample);
        tvDatabaseSample.setText("");

        DbHelper dbHelper = new DbHelper(this);
//        insert into database
//        dbHelper.addUsers("Bibek","kumarbibek094@gmail.com","987005600");
//        dbHelper.addUsers("Sushil","Sushil@gmail.com","987005600");
//        dbHelper.addUsers("Riya","Riya@gmail.com","987005600");
//        dbHelper.addUsers("Aashish","Aashish@gmail.com","987005600");


//        fetch data from database
        ArrayList<UsersModel> usersModels = dbHelper.fetchUsers();

        for (int i = 0; i < usersModels.size(); i++) {
            tvDatabaseSample.append("Id: " + usersModels.get(i).getId() + "\n"
                    + "Name: " + usersModels.get(i).getName() + "\n"
                    + "Email: " + usersModels.get(i).getEmail() + "\n"
                    + "Phone: " + usersModels.get(i).getPhone() + "\n\n\n\n");


            Log.d("USER_INFO", "Id: " + usersModels.get(i).getId() + "\n" + "Name: " + usersModels.get(i).getName() + "\n\n");
        }

//        update

        UsersModel usersModel = new UsersModel();
        usersModel.setId(5);
        usersModel.setName("Baby Shrestha");
        dbHelper.updateUsers(usersModel);


//        delete
        dbHelper.deleteUsers(2);


    }
}