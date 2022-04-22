package com.example.day03;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_IQ = "iq";
    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent intent = result.getData();

                    if (intent != null && intent.hasExtra(SendDataBackActivity.EXTRA_MESSAGE)) {
                        String message = intent.getStringExtra(SendDataBackActivity.EXTRA_MESSAGE);
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );    //registers call back

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button activityChangeBtn = findViewById(R.id.main_changeActivity);
        activityChangeBtn.setOnClickListener(this::changeActivity);

        findViewById(R.id.main_implicitIntent).setOnClickListener(view -> {
            Intent implicitIntent = new Intent()
                    .setAction(Intent.ACTION_SEND)
                    .putExtra(Intent.EXTRA_TEXT, "Hello World!")
                    .setType("text/plain");
            try {
                startActivity(implicitIntent);
            } catch (ActivityNotFoundException e) {
                //No activities can handle this request
            }
        });

        findViewById(R.id.main_getData).setOnClickListener(v -> {
            Intent intent = new Intent(this, SendDataBackActivity.class);
            launcher.launch(intent);

        });

    }

    private void changeActivity(View view) {
        Intent intent = new Intent(this, ReceivingActivity.class);
        intent.putExtra(EXTRA_NAME, "Purav");
        intent.putExtra(EXTRA_IQ, 1000);
        startActivity(intent);
        finish();
    }
}