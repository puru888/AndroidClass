package com.example.recify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.recify.adapters.HomeCardImageAdapter;
import com.example.recify.entities.SearchAllFood;
import com.example.recify.network.RecipeApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Call<SearchAllFood> search = RecipeApi.service.getSearchResult();


        RecyclerView foodList = findViewById(R.id.home_activity_recycler_view);
        foodList.setHasFixedSize(false);
        foodList.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        HomeCardImageAdapter homeCardImageAdapter = new HomeCardImageAdapter();
        foodList.setAdapter(homeCardImageAdapter);


        search.enqueue(new Callback<SearchAllFood>() {
            @Override
            public void onResponse(Call<SearchAllFood> call, Response<SearchAllFood> response) {
                homeCardImageAdapter.replace(response.body().getSearchResults().get(0).getResults());
            }

            @Override
            public void onFailure(Call<SearchAllFood> call, Throwable t) {
                Log.e("TAG",t.toString() );
            }
        });
    }
}