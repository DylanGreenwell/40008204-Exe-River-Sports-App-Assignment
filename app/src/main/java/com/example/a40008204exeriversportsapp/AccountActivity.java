package com.example.a40008204exeriversportsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccountActivity extends AppCompatActivity {

    Button btnChangePass, btnDeleteAcc, btnToHome2; //create button variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        btnChangePass = (Button) findViewById(R.id.btnChangePass); //link button variable to xml button
        btnDeleteAcc= (Button) findViewById(R.id.btnDeleteAcc);
        btnToHome2 = (Button) findViewById(R.id.btnToHome2);

        btnChangePass.setOnClickListener(new View.OnClickListener(){ //create click listener

            @Override
            public void onClick(View view) { //on button click
                Intent intent = new Intent(getApplicationContext(), ChangePasswordActivity.class); //take user to change password page
                startActivity(intent);
            }
        });

        btnDeleteAcc.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DeleteAccountActivity.class); //take user to delete account page
                startActivity(intent);
            }
        });

        btnToHome2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class); //take user back to home page
                startActivity(intent);
            }
        });

    }
}