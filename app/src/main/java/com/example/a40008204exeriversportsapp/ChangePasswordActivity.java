package com.example.a40008204exeriversportsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.PreparedStatement;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText username2, password2, repassword2; //create text box variables
    Button btnReset, btnToAccount;
    DBHelper DB; //create database helper variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        username2 = (EditText) findViewById(R.id.username2); //link variables to xml features
        password2 = (EditText) findViewById(R.id.password2);
        repassword2 = (EditText) findViewById(R.id.repassword2);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnToAccount = (Button) findViewById(R.id.btnToAccount);
        DB = new DBHelper(this); //link database to this file

        btnReset.setOnClickListener(new View.OnClickListener(){ //reset button click listener

            @Override
            public void onClick(View view) {
                String user1 = username2.getText().toString(); //take user inputs and save them as strings
                String pass1 = password2.getText().toString();
                String repass1 = repassword2.getText().toString();

                if(user1.equals("")||pass1.equals("")||repass1.equals("")) //if username, password and repassword boxes are empty
                    Toast.makeText(ChangePasswordActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show(); //notification to tell user to fill in boxes
                else{
                    if(pass1.equals(repass1)) { //if passwords are the same
                        //Boolean checkuserpass1 = DB.checkUsername(user1); //code i used when testing
                        Boolean checkPasswordUpdate = DB.updateData(user1, pass1); //update the password in database
                        if (checkPasswordUpdate == true) { //if password was updated

                            Toast.makeText(ChangePasswordActivity.this, "Password reset successful. Redirecting...", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class); //displays success message and takes user to login page
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(ChangePasswordActivity.this, "Error. Please try again.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), ChangePasswordActivity.class); //shows error message then takes the user back to change password page
                            startActivity(intent);
                        }
                    }
                    else{
                        Toast.makeText(ChangePasswordActivity.this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show(); //if an error occurs
                    }
                }
            }
        });

        btnToAccount.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AccountActivity.class); //if account button clicked, take user back to account page
                startActivity(intent);
            }
        });

    }
}