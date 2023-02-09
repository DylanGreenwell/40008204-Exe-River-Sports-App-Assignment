package com.example.a40008204exeriversportsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutUsActivity extends AppCompatActivity {

    Button btnToHome1; //create button variable

    @Override
    protected void onCreate(Bundle savedInstanceState) { //on creation
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        btnToHome1 = (Button) findViewById(R.id.btnToHome1); //link button variable to button in xml file

        btnToHome1.setOnClickListener(new View.OnClickListener(){ //button click listener

            @Override
            public void onClick(View view) { //when button is clicked
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class); //creates an intent to take user to home page
                startActivity(intent); //run the intent code
            }
        });
    }
}