package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_EMAIL_TO = "email_to";
    public static final String EXTRA_EMAIL_SUBJECT = "email_subject";
    public static final String EXTRA_EMAIL_BODY = "email_body";

    Button send = null;
    private EditText email_to = null;
    private EditText email_subject = null;
    private EditText email_body = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = findViewById(R.id.email_send);
        email_to = findViewById(R.id.email_to);
        email_subject = findViewById(R.id.email_subject);
        email_body = findViewById(R.id.email_body);
        send.setOnClickListener(this::sendEmail);
    }

    private void sendEmail(View view) {
        Intent intent = new Intent(this,ReceivingEmailActivity.class)
                .putExtra(EXTRA_EMAIL_TO, email_to.getText().toString())
                .putExtra(EXTRA_EMAIL_SUBJECT,email_subject.getText().toString())
                .putExtra(EXTRA_EMAIL_BODY,email_body.getText().toString());
        startActivity(intent);
    }
}