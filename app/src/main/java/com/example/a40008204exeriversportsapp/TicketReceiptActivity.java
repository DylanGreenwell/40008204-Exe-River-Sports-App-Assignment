package com.example.a40008204exeriversportsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TicketReceiptActivity extends AppCompatActivity {

    Button btnToHome4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_receipt);

        Button btnToHome4 = (Button) findViewById(R.id.btnToHome4); //get id and link button java variable to xml button

        btnToHome4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent); //take user to home page
            }
        });
    }
}