package com.example.backandforthdata;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final String EXTRA_FIRST_NAME = "firstname";
    public static final String EXTRA_LAST_NAME = "lastname";

    private String registeredUserName = null;
    private String registeredPassword = null;
    private String registeredFirstName = null;
    private String registeredLastName = null;

    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent intent = result.getData();
                    boolean intentHasExtras = intent.hasExtra(RegisterActivity.EXTRA_USERNAME) && intent.hasExtra(RegisterActivity.EXTRA_PASSWORD);
                    if (intent != null && intentHasExtras) {
                        registeredUserName = intent.getStringExtra(RegisterActivity.EXTRA_USERNAME);
                        registeredPassword = intent.getStringExtra(RegisterActivity.EXTRA_PASSWORD);
                        registeredFirstName = intent.getStringExtra(RegisterActivity.EXTRA_FIRST_NAME);
                        registeredLastName = intent.getStringExtra(RegisterActivity.EXTRA_LAST_NAME);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText loginUsername = findViewById(R.id.login_username);
        EditText loginPassword = findViewById(R.id.login_password);

        findViewById(R.id.login_login).setOnClickListener(view -> {
            String username = loginUsername.getText().toString();
            String password = loginPassword.getText().toString();
            Toast.makeText(this,"hello",Toast.LENGTH_SHORT);
            if (username.length() == 0 && password.length() == 0){ ;
                Toast.makeText(this, "Username or Password can not be empty", Toast.LENGTH_SHORT).show();
            }else if (!username.equalsIgnoreCase(registeredUserName) || !password.equals(registeredPassword)){
                Toast.makeText(this, "Username or Password dose not exist!", Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(this, LoggedInActivity.class)
                        .putExtra(EXTRA_FIRST_NAME,registeredFirstName)
                        .putExtra(EXTRA_LAST_NAME,registeredLastName);
                startActivity(intent);
            }
        });

        findViewById(R.id.login_register).setOnClickListener(view -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            launcher.launch(intent);
        });

    }
}