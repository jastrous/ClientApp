package com.example.penn.attemptone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    public void logout(View view) {
        Client.Logout(view,HomeScreen.this);
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        // Get the Intent that holds the employee
        Intent emp_int = getIntent();
        //String message = emp_int.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //CREATE EMPLOYEE ACTION
        final Button lo_button = (Button) findViewById(R.id.hs_logout_button);
        lo_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                logout(v);
            }
        });
    }
}
