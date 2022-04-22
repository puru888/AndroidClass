package com.example.day07restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day07restapi.entities.Search;
import com.example.day07restapi.entities.User;
import com.example.day07restapi.network.GithubApiService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView avatar = findViewById(R.id.profile_avatar);
        TextView login = findViewById(R.id.profile_login);
        TextView name = findViewById(R.id.profile_name);
        TextView description = findViewById(R.id.profile_description);

        Call<User> callUser = GithubApiService.service.getUser("puru888");
        callUser.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(ProfileActivity.this, "YA", Toast.LENGTH_SHORT).show();
                User user = response.body();
                login.setText(user.getLogin());
                name.setText(user.getName());
                description.setText(user.getBio());
                Picasso.get()
                        .load(user.getAvatarUrl())
                        .into(avatar);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("ProfileActivity_callUser", "Call failed" + t.getMessage());
            }
        });


        Call<Search> searchCall = GithubApiService.service.searchIssues("windows+label:bug+language:python+state:open",
                "created", "asc");

        searchCall.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                Toast.makeText(ProfileActivity.this, "Hey", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {

            }
        });
    }
}