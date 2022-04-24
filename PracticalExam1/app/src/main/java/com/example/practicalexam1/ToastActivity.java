package com.example.practicalexam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    public static String EXTRA_TOAST_CREATION_COUNT = "toastCreationCount";
    private int toastCreationCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        EditText toastMsg = findViewById(R.id.toast_activity_toast_msg);
        Switch toastSwitch = findViewById(R.id.toast_activity_switch);

        toastSwitch.setOnClickListener(view -> {
            if (toastSwitch.isChecked()) {
                toastSwitch.setText("Long");
            } else {
                toastSwitch.setText("Short");
            }
        });

        findViewById(R.id.toast_activity_create_toast).setOnClickListener(view -> {
            toastCreationCount++;
            int toastLength = -1;
            if (toastSwitch.isChecked()) {
                toastLength = Toast.LENGTH_LONG;
            } else {
                toastLength = Toast.LENGTH_SHORT;
            }
            Toast.makeText(this, toastMsg.getText().toString(), toastLength).show();
            Intent intent = new Intent();
            intent.putExtra(EXTRA_TOAST_CREATION_COUNT, toastCreationCount);
            setResult(RESULT_OK, intent);
        });
    }
}