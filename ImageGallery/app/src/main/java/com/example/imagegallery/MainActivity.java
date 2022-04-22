package com.example.imagegallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView main_bgImage = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_bgImage = findViewById(R.id.main_bgImage);
        ImageView dog1 = findViewById(R.id.img_dog1);
        ImageView dog2 = findViewById(R.id.img_dog2);
        ImageView dog3 = findViewById(R.id.img_dog3);
        ImageView dog4 = findViewById(R.id.img_dog4);
        ImageView dog5 = findViewById(R.id.img_dog5);

        dog1.setOnClickListener(this::onClick);
        dog2.setOnClickListener(this::onClick);
        dog3.setOnClickListener(this::onClick);
        dog4.setOnClickListener(this::onClick);
        dog5.setOnClickListener(this::onClick);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_dog1:
            case R.id.img_dog5:
                main_bgImage.setImageResource(R.drawable.dog2);
                break;
            case R.id.img_dog2:
                main_bgImage.setImageResource(R.drawable.dog3);
                break;
            case R.id.img_dog3:
                main_bgImage.setImageResource(R.drawable.dog4);
                break;
            case R.id.img_dog4:
                main_bgImage.setImageResource(R.drawable.dog1);
                break;
        }

    }
}