package com.example.day07restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day07restapi.entities.User;
import com.example.day07restapi.network.GithubApiService;

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
                Toast.makeText(ProfileActivity.this,"YA",Toast.LENGTH_SHORT).show();
                User user = response.body();
                login.setText(user.getLogin());
                name.setText(user.getName());
                description.setText(user.getBio());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("ProfileActivity_callUser", "Call failed" + t.getMessage());
            }
        });
    }
}