package com.example.databasecurd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.databasecurd.db.AppDatabase;
import com.example.databasecurd.db.Dao.ChatDao;
import com.example.databasecurd.db.Dao.RegisterDao;
import com.example.databasecurd.db.Entities.ChatList;
import com.example.databasecurd.db.Entities.Register;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private int id = -1;
    Register register = null;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final AppDatabase appDatabase = AppDatabase.getDatabaseInstance(this);
        final RegisterDao registerDao = appDatabase.registerDao();
        final ChatDao chatDao = appDatabase.chatDao();

        TextInputLayout firstName = findViewById(R.id.register_firstName);
        TextInputLayout lastName = findViewById(R.id.register_lastName);
        TextInputLayout phone = findViewById(R.id.register_phone);
        TextInputLayout address = findViewById(R.id.register_address);
        TextInputLayout city = findViewById(R.id.register_city);
        TextInputLayout state = findViewById(R.id.register_state);
        TextInputLayout zip = findViewById(R.id.register_zip);
        TextInputLayout email = findViewById(R.id.register_email);
        TextInputLayout password = findViewById(R.id.register_password);

        resources = getResources();

        Intent getIntent = getIntent();
        if (getIntent.hasExtra(LoginActivity.EXTRA_ID)) {

            Button registerBtn = findViewById(R.id.register_registerBtn);
            registerBtn.setText("Update");

            id = getIntent.getIntExtra(LoginActivity.EXTRA_ID, -1);
            setValue(firstName, getValue(firstName));
            setValue(lastName, getValue(lastName));
            setValue(phone, getValue(phone));
            setValue(address, getValue(address));
            setValue(city, getValue(city));
            setValue(state, getValue(state));
            setValue(zip, getValue(zip));
            setValue(email, getValue(email));
            setValue(password, getValue(password));

        }

        findViewById(R.id.register_registerBtn).setOnClickListener(view -> {

            if (isEmpty(firstName, lastName, phone, address, city, state, zip, email, password)) {
                return;
            }

            if (id != -1)
                register = new Register(id, getValue(firstName), getValue(lastName), getValue(phone), getValue(address),
                        getValue(city), getValue(state), getValue(zip), getValue(email), getValue(password));
            else
                register = new Register(getValue(firstName), getValue(lastName), getValue(phone), getValue(address),
                        getValue(city), getValue(state), getValue(zip), getValue(email), getValue(password));


            AppDatabase.databaseWriteExecutor.execute(() -> {
                if (id != -1) registerDao.update(register);
                else {
                    registerDao.insert(register);
                    chatDao.insertChat(new ChatList(getValue(firstName)));
                }
            });
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

    }

    private String getValue(@NonNull TextInputLayout view) {
        return view.getEditText().getText().toString();
    }

    private void setValue(@NonNull TextInputLayout view, String value) {
        view.getEditText().setText(value);
    }

    private boolean isEmpty(TextInputLayout... views) {
        boolean foundError = false;

        for (TextInputLayout view : views) {
            String value = view.getEditText().getText().toString();
            if (value.isEmpty()) {
                view.setError(resources.getString(R.string.register_emptyError));
                view.setErrorEnabled(true);
                foundError = true;
            } else {
                view.setErrorEnabled(false);
            }

        }
        return foundError;
    }
}