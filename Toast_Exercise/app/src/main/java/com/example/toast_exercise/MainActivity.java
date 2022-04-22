package com.example.toast_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText toastMsg = findViewById(R.id.toast_msg);
        CheckBox checkBox = findViewById(R.id.long_toast);
        TextView toastDescription = findViewById(R.id.toast_description);

        findViewById(R.id.create_toast).setOnClickListener(view -> {
            if (checkBox.isChecked()) {
                checkBox.setText("Uncheck for Short Toast");
                toastDescription.setText("Long Toast");
                Toast.makeText(this, toastMsg.getText().toString(), Toast.LENGTH_LONG).show();

            } else {
                checkBox.setText("Check for Long Toast");
                toastDescription.setText("Short Toast");
                Toast.makeText(this, toastMsg.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}