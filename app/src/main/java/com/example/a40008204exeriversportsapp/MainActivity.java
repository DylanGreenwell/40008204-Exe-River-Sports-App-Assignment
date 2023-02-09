package com.example.a40008204exeriversportsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup, signin; //define variables
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword); //link variables to xml features
        signup = (Button) findViewById(R.id.btnSignUp);
        signin = (Button) findViewById(R.id.btnSignIn);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String user = username.getText().toString();
                String pass = password.getText().toString(); //collect user inputs and save as strings
                String repass = repassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals("")) { //if any input box is empty
                    Toast.makeText(MainActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show(); //tells user to fill in all fields
                }
                else {
                    if (pass.equals(repass)) { //if password equals repassword
                        Boolean checkuser = DB.checkUsername(user); //checks username exists in database
                        if (checkuser == false) { //if username doesnt exist
                            Boolean insert = DB.insertData(user, pass); //inserts username and password into database
                            if (insert == true) { //if insert was successful
                                Toast.makeText(MainActivity.this, "You have successfully signed up. Redirecting...", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class); //take user to login page on successful signup
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Registration failed. Please try again.", Toast.LENGTH_SHORT).show(); //if error occurs
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Username already exists. Please try a new one or login.", Toast.LENGTH_SHORT).show(); //if username already exists
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Passwords do not match. Please try again.", Toast.LENGTH_SHORT).show(); //if password and repassword do not match
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent); //take user to login page on login button click
            }
        });
    }
}