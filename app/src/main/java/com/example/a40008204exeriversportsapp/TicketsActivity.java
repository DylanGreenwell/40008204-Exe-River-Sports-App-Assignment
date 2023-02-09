package com.example.a40008204exeriversportsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class TicketsActivity extends AppCompatActivity {

    Button btnPrint, btnToHome3; //defining variables
    Spinner numAdult, numMember, numChild, numPieAdult, numPieMember, numPieChild, numPintAdult, numPintMember, numTourAdult, numTourMember, numTourChild, numFrontAdult, numFrontMember, numFrontChild;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        Spinner numAdult=findViewById(R.id.numberAdult);
        Spinner numMember=findViewById(R.id.numberMember);
        Spinner numChild=findViewById(R.id.numberChild);
        Spinner numPieAdult=findViewById(R.id.numberPieAdult);
        Spinner numPieMember=findViewById(R.id.numberPieMember);
        Spinner numPieChild=findViewById(R.id.numberPieChild);
        Spinner numPintAdult=findViewById(R.id.numberPintAdult); //linking spinner variables to xml spinners
        Spinner numPintMember=findViewById(R.id.numberPintMember);
        Spinner numTourAdult=findViewById(R.id.numberTourAdult);
        Spinner numTourMember=findViewById(R.id.numberTourMember);
        Spinner numTourChild=findViewById(R.id.numberTourChild);
        Spinner numFrontAdult=findViewById(R.id.numberFrontAdult);
        Spinner numFrontMember=findViewById(R.id.numberFrontMember);
        Spinner numFrontChild=findViewById(R.id.numberFrontChild);

        Button btnPrint = (Button) findViewById(R.id.btnPrint);
        Button btnToHome3 = (Button) findViewById(R.id.btnToHome3);

        DB = new DBHelper(this); //database helper created

        ArrayAdapter<CharSequence>adapter1=ArrayAdapter.createFromResource(this, R.array.TicketPiePintNumbersArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item); //array adapter linking drop down boxes to the ticket array

        numAdult.setAdapter(adapter1);
        numMember.setAdapter(adapter1);
        numChild.setAdapter(adapter1);
        numPieAdult.setAdapter(adapter1);
        numPieMember.setAdapter(adapter1);
        numPieChild.setAdapter(adapter1);
        numPintAdult.setAdapter(adapter1); //setting each drop down box up to display the numbers 0-5
        numPintMember.setAdapter(adapter1);
        numTourAdult.setAdapter(adapter1);
        numTourMember.setAdapter(adapter1);
        numTourChild.setAdapter(adapter1);
        numFrontAdult.setAdapter(adapter1);
        numFrontMember.setAdapter(adapter1);
        numFrontChild.setAdapter(adapter1);

        btnPrint.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String adultTickets = numAdult.getSelectedItem().toString();
                int adultTicketsInt = Integer.parseInt(adultTickets);
                String memberTickets = numMember.getSelectedItem().toString(); //turn the 'spinner' (drop down box) values into strings then into integers
                int memberTicketsInt = Integer.parseInt(memberTickets);
                String childTickets = numChild.getSelectedItem().toString();
                int childTicketsInt = Integer.parseInt(childTickets);
                if(adultTicketsInt == 0 && memberTicketsInt == 0 && childTicketsInt == 0){
                    Toast.makeText(TicketsActivity.this, "No tickets have been selected. Please select at least 1 ticket.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), TicketsActivity.class); //if no tickets have been selected
                    startActivity(intent);
                }
                else{
                    //Boolean insert_ticket = DB.insertTicket(adultTickets, memberTickets, childTickets); //this was for inserting tickets to database
                    //if(insert_ticket == true){ //this was originally to insert ticket into a database
                        Toast.makeText(TicketsActivity.this, "Thank you for your purchase! Loading receipt...", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), TicketReceiptActivity.class); //takes user to receipt page
                        startActivity(intent);
                    }
                    //else{
                        //Toast.makeText(TicketsActivity.this, "There was an error with your ticket being purchased. Please try again...", Toast.LENGTH_SHORT).show();
                        //Intent intent = new Intent(getApplicationContext(), TicketsActivity.class); //if there was an error saving the ticket to database
                        //startActivity(intent);
                    //}
                //}
            }
        });

        btnToHome3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent); //take user to home page
            }
        });
    }
}