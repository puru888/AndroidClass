package com.example.practicalexam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Switch;

import com.google.android.material.snackbar.Snackbar;

public class SnackbarActivity extends AppCompatActivity {

    public static String EXTRA_SNACKBAR_CREATION_COUNT = "snackbarCreationCount";
    int snackBarCreationCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

        EditText snackbarMsg = findViewById(R.id.snackbar_activity_snackbar_msg);
        Switch snackbarSwitch = findViewById(R.id.snackbar_activity_switch);

        snackbarSwitch.setOnClickListener(view -> {
            if (snackbarSwitch.isChecked()) {
                snackbarSwitch.setText("Long");
            } else {
                snackbarSwitch.setText("Short");
            }
        });

        findViewById(R.id.snackbar_activity_create_snackbar).setOnClickListener(view -> {
            snackBarCreationCount++;
            int snackbarLength = 0;
            if (snackbarSwitch.isChecked()) {
                snackbarLength = Snackbar.LENGTH_LONG;

            } else {
                snackbarLength = Snackbar.LENGTH_SHORT;
            }
            Snackbar snackbar = Snackbar.make(view, snackbarMsg.getText().toString(), snackbarLength);
            snackbar.setAction("Cancel", view1 -> {
                snackBarCreationCount = 0;
                Intent intent = new Intent();
                intent.putExtra(EXTRA_SNACKBAR_CREATION_COUNT, snackBarCreationCount);
                setResult(RESULT_OK, intent);
                snackbar.dismiss();
            });
            snackbar.show();

            Intent intent = new Intent();
            intent.putExtra(EXTRA_SNACKBAR_CREATION_COUNT, snackBarCreationCount);
            setResult(RESULT_OK, intent);
        });
    }
}