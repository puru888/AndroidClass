package com.example.backandforthdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    public static final String EXTRA_USERNAME = "username";
    public static final String EXTRA_PASSWORD = "password";
    public static final String EXTRA_FIRST_NAME = "firstName";
    public static final String EXTRA_LAST_NAME = "lastName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText username = findViewById(R.id.register_username);
        EditText password = findViewById(R.id.register_password);
        EditText repeatPassword = findViewById(R.id.register_repeatPassword);
        EditText firstName = findViewById(R.id.register_firstName);
        EditText lastName = findViewById(R.id.register_lastName);


        findViewById(R.id.register_submit).setOnClickListener(view -> {

            String usernameString = username.getText().toString();
            String passwordString = password.getText().toString();
            String repeatPasswordString = repeatPassword.getText().toString();
            String firstNameString = firstName.getText().toString();
            String lastNameString = lastName.getText().toString();
            boolean isAnyFieldEmpty = usernameString.length() == 0 || passwordString.length() == 0
                    || repeatPasswordString.length() == 0 || firstNameString.length() == 0 || lastNameString.length() == 0;

            if (isAnyFieldEmpty) {
                Toast.makeText(this, "Any field can not be empty", Toast.LENGTH_SHORT).show();
            } else if (!passwordString.equals(repeatPasswordString)) {
                Toast.makeText(this, "password does not match!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intentToSendBack = new Intent();
                intentToSendBack.putExtra(EXTRA_USERNAME, usernameString);
                intentToSendBack.putExtra(EXTRA_PASSWORD, passwordString);
                intentToSendBack.putExtra(EXTRA_FIRST_NAME, firstNameString);
                intentToSendBack.putExtra(EXTRA_LAST_NAME, lastNameString);
                setResult(RESULT_OK, intentToSendBack);
            }
        });

    }
}