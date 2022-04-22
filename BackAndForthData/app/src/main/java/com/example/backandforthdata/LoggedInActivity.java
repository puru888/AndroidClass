package com.example.backandforthdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LoggedInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        Intent intent = getIntent();
        boolean intentHasExtras = intent.hasExtra(LoginActivity.EXTRA_FIRST_NAME) && intent.hasExtra(LoginActivity.EXTRA_LAST_NAME);
        TextView helloMsg = findViewById(R.id.loggedIn_hello);
        if (intentHasExtras) {
            String firstName = intent.getStringExtra(LoginActivity.EXTRA_FIRST_NAME);
            String lastName = intent.getStringExtra(LoginActivity.EXTRA_LAST_NAME);
            helloMsg.setText("Hello "+firstName+" "+lastName);
        }
        else {
            Toast.makeText(this, "Intent not exist for this activity", Toast.LENGTH_SHORT).show();
        }
    }
}