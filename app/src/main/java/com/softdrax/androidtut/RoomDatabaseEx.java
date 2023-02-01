package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.softdrax.androidtut.database.DbHelperExpense;
import com.softdrax.androidtut.database.Expense;

import java.util.List;

public class RoomDatabaseEx extends AppCompatActivity {
    EditText etExpenseTitle, etExpenseAmount;
    Button btnExpenseSave, btnShowExpense;
    TextView tvListOfExpenses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_database_ex);
        etExpenseTitle = findViewById(R.id.etExpenseTitle);
        etExpenseAmount = findViewById(R.id.etExpenseAmount);
        btnExpenseSave = findViewById(R.id.btnExpenseSave);
        btnShowExpense = findViewById(R.id.btnShowExpense);
        tvListOfExpenses = findViewById(R.id.tvListOfExpenses);


        DbHelperExpense dbHelperExpense = DbHelperExpense.getDb(RoomDatabaseEx.this);


        btnExpenseSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            insert into database
                String title = etExpenseTitle.getText().toString();
                String amount = etExpenseAmount.getText().toString();
                dbHelperExpense.expenseDao().addExpense(new Expense(title, amount));


            }


        });

        btnShowExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //     fetch data from database

                tvListOfExpenses.setVisibility(View.VISIBLE);
                tvListOfExpenses.setText("");
                List<Expense> dbList = dbHelperExpense.expenseDao().getExpenses();

                for (int i = 0; i < dbList.size(); i++) {
//                    Log.d("EXPENSES", "Id: " + dbList.get(i).getId() + "\n"
//                            + "Title: " + dbList.get(i).getTitle() + "\n"
//                            + "Amount: " + dbList.get(i).getAmount() + "\n");

                    tvListOfExpenses.append("S.N. " + i+1 + "\n"
                            + "Title: " + dbList.get(i).getTitle() + "\n"
                            + "Amount: " + dbList.get(i).getAmount() + "\n\n");


                }
            }
        });


    }
}