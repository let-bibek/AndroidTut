package com.softdrax.androidtut.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="UsersDb";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="userinfo";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PHONE="phone";
    public DbHelper( Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//      CREATE TABLE userinfo(id INT PRIMARY KEY AUTOINCREMENT,name VARCHAR(50) NOT NULL,email VARCHAR, phone VARCHAR
        db.execSQL("CREATE TABLE "+TABLE_NAME+
                "(" +KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+KEY_NAME+" VARCHAR(50) NOT NULL ,"+KEY_EMAIL+" TEXT,"+KEY_PHONE+" TEXT"+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }

//    insert into database

    public void addUsers(String name,String email, String phone){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY_NAME,name);
        contentValues.put(KEY_EMAIL,email);
        contentValues.put(KEY_PHONE,phone);
        db.insert(TABLE_NAME,null,contentValues);
    }

//    fetch from database
}
