package com.example.day4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Locale;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        Button a = findViewById(R.id.dialogActivity_A);
        Button b = findViewById(R.id.dialogActivity_B);
        Button c = findViewById(R.id.dialogActivity_C);
        ConstraintLayout layout = findViewById(R.id.dialogActivity_viewGroup);

        a.setOnClickListener(v -> {
            new MaterialAlertDialogBuilder(this)
                    .setMessage("Hello ??")
                    .setTitle("asking you a question")
                    .setPositiveButton("Ok", (DialogInterface dialog, int which) -> {
                        Toast.makeText(this, "OK PRESSED", Toast.LENGTH_SHORT).show();
                    })
                    .setNeutralButton("Cancle", (DialogInterface dialog, int which) -> {
                        Toast.makeText(this, "CANCEL PRESSED", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Bad", (DialogInterface dialog, int which) -> {
                        Toast.makeText(this, "BAD PRESSED", Toast.LENGTH_SHORT).show();
                    })
                    .show();
        });

        b.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select a color");
//                    .setMessage("Pick any color");
            builder.setItems(R.array.colors, (DialogInterface dialog, int which) -> {
                String message = getResources().getStringArray(R.array.colors)[which];
                switch (message.toLowerCase()) {
                    case "red":
                        layout.setBackgroundColor(Color.RED);
                        break;
                    case "green":
                        layout.setBackgroundColor(Color.GREEN);
                        break;
                    case "blue":
                        layout.setBackgroundColor(Color.BLUE);
                        break;
                }
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            });
            builder.create().show();
        });

        c.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View customLayout = getLayoutInflater().inflate(R.layout.custom_dialog_credentials, null);
            Button login = customLayout.findViewById(R.id.custom_dialog_credentials_login);
            Button cancel = customLayout.findViewById(R.id.custom_dialog_credentials_cancel);
            builder.setView(customLayout);

            AlertDialog dialog = builder.create();
            login.setOnClickListener(view -> {
                EditText username = customLayout.findViewById(R.id.custom_dialog_credentials_username);
                EditText password = customLayout.findViewById(R.id.custom_dialog_credentials_password);
                String toastMsg = "username: " + username.getText() + " & " + "password: " + password.getText();
                Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });
            cancel.setOnClickListener(view -> {
                dialog.cancel();
            });
            dialog.show();
        });

    }
}