package com.example.practicalexam1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int snackbarCount = 0;
    private int toastCount = 0;
    private TextView snackbarCountTextView;
    private TextView toastCountTextView;

    private ActivityResultLauncher<Intent> snackbarLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent intent = result.getData();
                    boolean doIntentHasExtras = intent.hasExtra(SnackbarActivity.EXTRA_SNACKBAR_CREATION_COUNT);
                    if (intent != null && doIntentHasExtras) {
                        snackbarCount += intent.getIntExtra(SnackbarActivity.EXTRA_SNACKBAR_CREATION_COUNT, -1);
                        snackbarCountTextView.setText(String.valueOf(snackbarCount));
                    }
                }
            }
    );
    private ActivityResultLauncher<Intent> toastLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent intent = result.getData();
                    boolean doIntentHasExtras = intent.hasExtra(ToastActivity.EXTRA_TOAST_CREATION_COUNT);
                    if (intent != null && doIntentHasExtras) {
                        toastCount += intent.getIntExtra(ToastActivity.EXTRA_TOAST_CREATION_COUNT, -1);
                        toastCountTextView.setText(String.valueOf(toastCount));
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        snackbarCountTextView = findViewById(R.id.main_activity_snackbar_count);
        toastCountTextView = findViewById(R.id.main_activity_toast_count);

        findViewById(R.id.main_activity_toast_btn).setOnClickListener(view -> {
            Intent toastIntent = new Intent(this, ToastActivity.class);
            toastLauncher.launch(toastIntent);
        });
        findViewById(R.id.main_activity_snackbar_btn).setOnClickListener(view -> {
            Intent snackbarIntent = new Intent(this, SnackbarActivity.class);
            snackbarLauncher.launch(snackbarIntent);
        });
    }
}