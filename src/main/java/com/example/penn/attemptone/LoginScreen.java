package com.example.penn.attemptone;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.Parcel;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {
    public static final String LOGIN_BUTTON_ALERT = "Thank's for trying, but this doesn't work.";

    public void gotoCEScreen(View view) {
        Intent intent = new Intent(this, CreateEmployeeScreen.class);
        startActivity(intent);
    }

    public void gotoHomeScreen(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //LOGIN BUTTON ACTION
        final Button l_button = (Button) findViewById(R.id.login_button);
        l_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String u = ((EditText)findViewById(R.id.employeeID_input)).getText().toString();
                String p = ((EditText)findViewById(R.id.password_input)).getText().toString();
                Client.Login(v,LoginScreen.this,u,p);
                gotoHomeScreen(v);
            }
        });

        //NEW EMPLOYEE ACTION
        final Button ne_button = (Button) findViewById(R.id.new_employee_button);
        ne_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoCEScreen(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
