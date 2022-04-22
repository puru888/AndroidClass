package com.example.day03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class SendDataBackActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data_back);

        EditText message = findViewById(R.id.sendDataBack_message);
        findViewById(R.id.sendDataBack_apply).setOnClickListener(view->{
            Intent intentToSendBack = new Intent();
            intentToSendBack.putExtra(EXTRA_MESSAGE,message.getText().toString());
            setResult(RESULT_OK,intentToSendBack);
        });
    }
}