package com.example.databasecurd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.databasecurd.db.AppDatabase;
import com.example.databasecurd.db.Dao.RegisterDao;
import com.example.databasecurd.db.Entities.Register;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private int id = -1;
    private String firstName = null;
    private String lastName = null;
    private String phone = null;
    private String address = null;
    private String city = null;
    private String state = null;
    private String zip = null;
    private String email = null;
    private String password = null;
    Register register = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final AppDatabase appDatabase = AppDatabase.getDatabaseInstance(this);
        final RegisterDao registerDao = appDatabase.registerDao();

        TextInputLayout firstNameText = findViewById(R.id.register_firstName);
        TextInputLayout lastNameText = findViewById(R.id.register_lastName);
        TextInputLayout phoneText = findViewById(R.id.register_phone);
        TextInputLayout addressText = findViewById(R.id.register_address);
        TextInputLayout cityText = findViewById(R.id.register_city);
        TextInputLayout stateText = findViewById(R.id.register_state);
        TextInputLayout zipText = findViewById(R.id.register_zip);
        TextInputLayout emailText = findViewById(R.id.register_email);
        TextInputLayout passwordText = findViewById(R.id.register_password);

        Intent getIntent = getIntent();
        if (getIntent.hasExtra(LoginActivity.EXTRA_ID)) {

            Button registerBtn = findViewById(R.id.register_registerBtn);
            registerBtn.setText("Update");

            id = getIntent.getIntExtra(LoginActivity.EXTRA_ID, -1);
            firstName = getIntent.getStringExtra(LoginActivity.EXTRA_FIRST_NAME);
            lastName = getIntent.getStringExtra(LoginActivity.EXTRA_LAST_NAME);
            phone = getIntent.getStringExtra(LoginActivity.EXTRA_PHONE);
            address = getIntent.getStringExtra(LoginActivity.EXTRA_ADDRESS);
            city = getIntent.getStringExtra(LoginActivity.EXTRA_CITY);
            state = getIntent.getStringExtra(LoginActivity.EXTRA_STATE);
            zip = getIntent.getStringExtra(LoginActivity.EXTRA_ZIP);
            email = getIntent.getStringExtra(LoginActivity.EXTRA_EMAIL);
            password = getIntent.getStringExtra(LoginActivity.EXTRA_PASSWORD);

            firstNameText.getEditText().setText(firstName);
            lastNameText.getEditText().setText(lastName);
            phoneText.getEditText().setText(phone);
            addressText.getEditText().setText(address);
            cityText.getEditText().setText(city);
            stateText.getEditText().setText(state);
            zipText.getEditText().setText(zip);
            emailText.getEditText().setText(email);
            passwordText.getEditText().setText(password);

        }

        findViewById(R.id.register_registerBtn).setOnClickListener(view -> {

            firstName = firstNameText.getEditText().getText().toString();
            lastName = lastNameText.getEditText().getText().toString();
            phone = phoneText.getEditText().getText().toString();
            address = addressText.getEditText().getText().toString();
            city = cityText.getEditText().getText().toString();
            state = stateText.getEditText().getText().toString();
            zip = zipText.getEditText().getText().toString();
            email = emailText.getEditText().getText().toString();
            password = passwordText.getEditText().getText().toString();

            if (id != -1)
                register = new Register(id,firstName, lastName, phone, address, city, state, zip, email, password);
            else
                register = new Register(firstName, lastName, phone, address, city, state, zip, email, password);


            AppDatabase.databaseWriteExecutor.execute(() -> {
                if (id != -1) registerDao.update(register);
                else registerDao.insert(register);
            });
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

    }
}