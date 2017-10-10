package com.example.penn.attemptone;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateEmployeeScreen extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_employee_screen);

        //CREATE EMPLOYEE ACTION
        final Button ce_button = (Button) findViewById(R.id.ce_create_button);
        ce_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String fname = ((EditText)findViewById(R.id.ce_fname_input)).getText().toString();
                String lname = ((EditText)findViewById(R.id.ce_lname_input)).getText().toString();
                String password = ((EditText)findViewById(R.id.ce_password_input)).getText().toString();
                Employee e = Client.Create(v,CreateEmployeeScreen.this,fname,lname,password,Employee.RANK.NONE);
                if(!e.equals(null))
                    Client.Login(v,CreateEmployeeScreen.this,e.getUsername(),password);
            }
        });

        //CANCEL ACTION
        final Button c_button = (Button) findViewById(R.id.ce_cancel_button);
        c_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(CreateEmployeeScreen.this, LoginScreen.class);
                startActivity(intent);
            }
        });

    }
}
