package com.example.day4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.imageView).setOnLongClickListener(view -> {
            Toast.makeText(this, "Image", Toast.LENGTH_SHORT).show();
            return true;
        });
        findViewById(R.id.include).setOnClickListener(view -> {
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        });
    }
}