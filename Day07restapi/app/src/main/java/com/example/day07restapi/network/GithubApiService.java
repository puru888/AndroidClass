package com.example.day07restapi.network;

import com.example.day07restapi.entities.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

//Implemented by retro fit
//Defining how Retrofit talks to the web server using HTTP requests
public interface GithubApiService {
    //Base = https://api.github.com/users/puru888
    //Request: users/puru888

    String BASE_URL = "https://api.github.com/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    GithubApiService service = retrofit.create(GithubApiService.class);

    @GET("users/{username}")
    Call<User> getUser(@Path("username") String userName);
}
