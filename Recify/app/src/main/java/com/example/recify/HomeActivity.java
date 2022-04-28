package com.example.recify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.recify.adapters.HomeCardImageAdapter;
import com.example.recify.entities.SearchAllFood;
import com.example.recify.network.RecipeApi;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    public static String EXTRA_HOME_LOGIN_ID = "homeLoginId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Call<SearchAllFood> search = RecipeApi.service.getSearchResult();
        NavigationBarView bottomNavigationView = findViewById(R.id.bottom_navigation);


        RecyclerView foodList = findViewById(R.id.home_activity_recycler_view);
        foodList.setHasFixedSize(false);
        foodList.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        Intent getIntent = getIntent();
        HomeCardImageAdapter homeCardImageAdapter = new HomeCardImageAdapter(getIntent.getIntExtra(LoginActivity.EXTRA_LOGIN_ID, -1));
        foodList.setAdapter(homeCardImageAdapter);


        search.enqueue(new Callback<SearchAllFood>() {
            @Override
            public void onResponse(Call<SearchAllFood> call, Response<SearchAllFood> response) {
                homeCardImageAdapter.replace(response.body().getSearchResults().get(0).getResults());
            }

            @Override
            public void onFailure(Call<SearchAllFood> call, Throwable t) {
                Log.e("TAG", t.toString());
            }
        });

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Intent intent = null;
            switch (item.getItemId()) {
                case R.id.menu_home:
                    intent = new Intent(this, HomeActivity.class);
                    startActivity(intent);
                    break;
                case R.id.menu_search:
                    intent = new Intent(this, SearchActivity.class);
                    startActivity(intent);
                    break;
                case R.id.menu_favourite:
                    intent = new Intent(this, FavoriteActivity.class);
                    intent.putExtra(EXTRA_HOME_LOGIN_ID,getIntent.getIntExtra(LoginActivity.EXTRA_LOGIN_ID,-1));
                    startActivity(intent);
                    break;
            }
            return true;
        });

    }
}