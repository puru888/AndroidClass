package com.example.recify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recify.adapters.FavoriteAdapter;

public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        RecyclerView list = findViewById(R.id.activity_favorite_recycler_view);
        list.setHasFixedSize(false);
        list.setLayoutManager(new LinearLayoutManager(this));

        FavoriteAdapter adapter = new FavoriteAdapter(this);
        list.setAdapter(adapter);
    }
}