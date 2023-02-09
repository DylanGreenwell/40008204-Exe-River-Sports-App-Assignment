package com.example.a40008204exeriversportsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper { //create class using SQLiteOpenHelper

    public static final String DBNAME = "Login.db"; //create database

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) { //on database creation
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)"); //create users table
        MyDB.execSQL("create Table ticketsreceipts(id INTEGER primary key AUTOINCREMENT, adult TEXT, member TEXT, child TEXT)"); //create ticketsreceipts table
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users"); //do not make another database if one already exists
        MyDB.execSQL("drop Table if exists ticketsreceipts"); //do not make another database if one already exists
    }

    public Boolean insertData(String username, String password){ //method for inserting data
        SQLiteDatabase MyDB = this.getWritableDatabase(); //database connection
        ContentValues contentValues = new ContentValues(); //open content values to allow data to be inserted
        contentValues.put("username", username); //insert username variable in username column
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues); //sql insert statement
        if(result==-1) return false; //if error occurs
        else
            return true;
    }

    public Boolean updateData(String username, String password){ //updating data in database
        SQLiteDatabase MyDB = this.getWritableDatabase(); //connection to database
        ContentValues contentValues = new ContentValues(); //content values opened to allow data to be inserted
        contentValues.put("password", password); //put password variable in password column
        long result = MyDB.update("users", contentValues, "username = ?", new String[] {username}); //sql update statement
        if(result==-1) return false; //if error occurs
        else
            return true;
    }

    public Boolean deleteData(String username, String password){ //function to delete data from database
        SQLiteDatabase MyDB = this.getWritableDatabase(); //connection to database
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username}); //cursor with sql query
        if(cursor.getCount() > 0) { //if data exists in database with same name as variables
            long result = MyDB.delete("users", "username = ?", new String[]{username}); //delete the data from db
            if (result == -1) { //if error occurs
                return false;
            } else {
                return true;
            }
        }
        else{
            return false;
            }
    }

    public Boolean checkUsername(String username){ //check username to see if it already exists
        SQLiteDatabase MyDB = this.getWritableDatabase(); //database connection
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username}); //cursor with sql query to select the username
        if(cursor.getCount() > 0) //if a username already exists with the same name as the variable
            return true;
        else
            return false;
    }

    public Boolean checkUsernamePassword(String username, String password){ //check username and password to see if they are on the same account
        SQLiteDatabase MyDB = this.getWritableDatabase(); //database connection
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password}); //cursor created with sql query
        if(cursor.getCount()>0) //cursor will be >0 if a username and password exist
            return true;
        else
            return false;
    }

    //public Boolean insertTicket(String adult, String member, String child){ //this code did not work so i comment it out so the receipt page will load
        //SQLiteDatabase MyDB = this.getWritableDatabase();  //database connection
        //ContentValues contentValues = new ContentValues(); //open a content value to allow data to be put into the database table
        //contentValues.put("adult", adult); //fill in the adult tab with the variable adult
        //contentValues.put("member", member);
        //contentValues.put("child", child);
        //long result = MyDB.insert("ticketsreceipts", null, contentValues); //insert data into database
        //if(result==-1) return false; //if ticket is not inserted return false
        //else
            //return true; if ticket was inserted then return true
    //}

    //public Boolean readTicket(){       code to try and read a receipt but the sql statement would not work
        //SQLiteDatabase MyDB = this.getWritableDatabase();     connect to database
        //Cursor cursor = MyDB.rawQuery("Select * from ticketsreceipts where id=(select max(id) from ticketsreceipts",); create cursor and sql statement
        //return true; placeholder as i could not get the sql statement to work
    //}
}

