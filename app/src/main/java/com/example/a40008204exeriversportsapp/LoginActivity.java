package com.example.a40008204exeriversportsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin, btnToSignUp; //define variables
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnLogin = (Button) findViewById(R.id.btnLogin); //link buttons and edit text boxes to xml features
        btnToSignUp = (Button) findViewById(R.id.btnToSignUp);
        DB = new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String user = username.getText().toString(); //make user inputs as strings
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals("")) //if one field has not been filled in
                    Toast.makeText(LoginActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkUsernamePassword(user, pass); //check username and password from database
                    if(checkuserpass == true){ //on successful login
                        Toast.makeText(LoginActivity.this, "Login Successful. Redirecting...", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class); //take user to home page on successful login
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Invalid login credentials. Please try again.", Toast.LENGTH_SHORT).show(); //if error occurs
                    }
                }
            }
        });


        btnToSignUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent); //take user to sign up page
            }
        });
    }
}