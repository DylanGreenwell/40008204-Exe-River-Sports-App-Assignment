package com.example.a40008204exeriversportsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity {

    Button btnAbout, btnTickets, btnAccount, btnLogOut; //define variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnAbout = (Button) findViewById(R.id.btnAbout);
        btnTickets = (Button) findViewById(R.id.btnTickets); //link buttons to xml buttons
        btnAccount = (Button) findViewById(R.id.btnAccount);
        btnLogOut = (Button) findViewById(R.id.btnLogOut);

        btnAbout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AboutUsActivity.class);
                startActivity(intent); //take user to about us page on press of about button
            }
        });

        btnTickets.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TicketsActivity.class);
                startActivity(intent); //take user to tickets page on ticket button press
            }
        });

        btnAccount.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
                startActivity(intent); //take user to account page on account button press
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class); //send user to login page when they click log out
                startActivity(intent);
                Toast.makeText(HomeActivity.this, "You have been logged out. Redirecting...", Toast.LENGTH_SHORT).show(); //display notification saying the user has been logged out
            }
        });
    }
}