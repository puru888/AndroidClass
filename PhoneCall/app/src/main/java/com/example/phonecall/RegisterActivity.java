package com.example.phonecall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_PHONE = "phone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextInputEditText name = findViewById(R.id.registerActivity_name);
        TextInputEditText phone = findViewById(R.id.registerActivity_number);

        findViewById(R.id.registerActivity_register).setOnClickListener(view -> {
            Intent intentToSendBack = new Intent();
            intentToSendBack.putExtra(EXTRA_NAME, name.getText().toString());
            intentToSendBack.putExtra(EXTRA_PHONE, phone.getText().toString());
            setResult(RESULT_OK, intentToSendBack);
        });
    }
}