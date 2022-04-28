package com.example.recify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.recify.adapters.SearchAdapter;
import com.example.recify.entities.SearchRecipes;
import com.example.recify.network.RecipeApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        EditText search = findViewById(R.id.activity_search_query);

        Call<SearchRecipes> searchRecipesCall = RecipeApi.service.getSearchRecipes(search.getText().toString());

        RecyclerView list = findViewById(R.id.activity_search_searchResult);
        list.setHasFixedSize(false);
        list.setLayoutManager(new LinearLayoutManager(this));

        SearchAdapter searchAdapter = new SearchAdapter();
        list.setAdapter(searchAdapter);

        findViewById(R.id.activity_searchButton).setOnClickListener(view -> {
            searchRecipesCall.enqueue(new Callback<SearchRecipes>() {
                @Override
                public void onResponse(Call<SearchRecipes> call, Response<SearchRecipes> response) {
                    searchAdapter.replace(response.body().getResults());
                }

                @Override
                public void onFailure(Call<SearchRecipes> call, Throwable t) {
                    Log.e("TAG", t.toString());
                }
            });
        });

    }
}