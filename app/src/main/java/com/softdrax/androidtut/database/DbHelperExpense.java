package com.softdrax.androidtut.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.softdrax.androidtut.database.dao.ExpenseDao;

@Database(entities = Expense.class,exportSchema = false,version = 1)
public abstract class DbHelperExpense extends RoomDatabase {
    private static final String DATABASE_NAME="expenses";
    private static DbHelperExpense instance;

    public static synchronized DbHelperExpense getDb(Context context){

        if (instance==null){
            instance= Room.databaseBuilder(context,DbHelperExpense.class,DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

    public abstract ExpenseDao expenseDao();
}
