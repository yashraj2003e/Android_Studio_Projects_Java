package com.example.beautyparlour;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table parlour2(name varchar(50),phoneNum varchar(50),services varchar(50),time time,date date)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(String name,String phoneNumber,String services,String time,String date) {

        String[] data = {name,phoneNumber,services,time,date};

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("insert into parlour2 values(?,?,?,?,?)",data);
        db.close();
    }

    public String getParticularDay(String selectedDate) {
        String tableData = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from parlour2 where date = ?",new String[]{selectedDate});

        while(cursor.moveToNext()) {
            String name = cursor.getString(0);
            String phone = cursor.getString(1);
            String services = cursor.getString(2);
            String time = cursor.getString(3);
            String date = cursor.getString(4);

            tableData +=  "Name - " + name + " Phone Number - "+phone+" Services Opted - "+services + "time - " + time + " date - "+date + "\n";


        }
        db.close();
        return tableData;
    }

    public String display() {
        String tableData = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from parlour2",null);

        while(cursor.moveToNext()) {
            String name = cursor.getString(0);
            String phone = cursor.getString(1);
            String services = cursor.getString(2);
            String time = cursor.getString(3);
            String date = cursor.getString(4);

            tableData +=  "Name - " + name + " Phone Number - "+phone+" Services Opted - "+services + "time - " + time + " date - "+date + "\n";


        }
        db.close();
        return tableData;
    }

}
