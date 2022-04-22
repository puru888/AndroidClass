package com.example.day03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class ReceivingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiving);
        Intent intent = getIntent();
        if (intent.hasExtra(MainActivity.EXTRA_NAME)){
            String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
            Log.e("name", name );
        }else {
            int iq = intent.getIntExtra(MainActivity.EXTRA_IQ, -1);
            Log.e("iq", String.valueOf(iq));
        }

    }
}