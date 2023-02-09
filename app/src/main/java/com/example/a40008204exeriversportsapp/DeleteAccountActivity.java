package com.example.a40008204exeriversportsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteAccountActivity extends AppCompatActivity {

    EditText username3, password3, repassword3;
    Button btnDelete, btnToAccount2; //defining variables
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);

        username3 = (EditText) findViewById(R.id.username3);
        password3 = (EditText) findViewById(R.id.password3);
        repassword3 = (EditText) findViewById(R.id.repassword3); //linking variables to xml features
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnToAccount2 = (Button) findViewById(R.id.btnToAccount2);
        DB = new DBHelper(this);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //when delete button pressed

                String user2 = username3.getText().toString();
                String pass2 = password3.getText().toString(); //converting user inputs to strings
                String repass2 = repassword3.getText().toString();

                if(user2.equals("")||pass2.equals("")) //if not all fields are filled in
                    Toast.makeText(DeleteAccountActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                else{
                    if(pass2.equals(repass2)) { //if password and repassword are the same
                        Boolean checkAccountDelete = DB.deleteData(user2, pass2); //delete account
                        if (checkAccountDelete == true) { //if account was deleted
                            Toast.makeText(DeleteAccountActivity.this, "Account Deleted. Redirecting...", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class); //show success message and take user to login page
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(DeleteAccountActivity.this, "Error. Please try again.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), DeleteAccountActivity.class); //if account is not deleted
                            startActivity(intent);
                        }
                    }
                    else{
                        Toast.makeText(DeleteAccountActivity.this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show(); //if error occurs
                    }
                }

            }
        });

        btnToAccount2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AccountActivity.class); //take user back to account page
                startActivity(intent);
            }
        });

    }
}