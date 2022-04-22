package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ReceivingEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiving_email);

        Intent receivedIntent = getIntent();
        boolean intentHasExtra = receivedIntent.hasExtra(MainActivity.EXTRA_EMAIL_TO) &&
                receivedIntent.hasExtra(MainActivity.EXTRA_EMAIL_SUBJECT) &&
                receivedIntent.hasExtra(MainActivity.EXTRA_EMAIL_BODY);
        TextView received_to = findViewById(R.id.received_to);
        TextView received_subject = findViewById(R.id.received_subject);
        TextView received_body = findViewById(R.id.received_body);

        if (intentHasExtra){
            received_to.setText(receivedIntent.getStringExtra(MainActivity.EXTRA_EMAIL_TO));
            received_subject.setText(receivedIntent.getStringExtra(MainActivity.EXTRA_EMAIL_SUBJECT));
            received_body.setText(receivedIntent.getStringExtra(MainActivity.EXTRA_EMAIL_BODY));
        }

    }
}