package com.softdrax.androidtut.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.softdrax.androidtut.database.Expense;

import java.util.List;

@Dao
public interface ExpenseDao {

    @Query("SELECT * FROM expenses")
    List<Expense> getExpenses();

    @Insert
    void addExpense(Expense expense);

    @Update
    void updateExpense(Expense expense);

    @Delete
    void deleteExpense(Expense expense);
}
