package com.example.recify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.recify.entities.RandomFoodTrivia;
import com.example.recify.network.RecipeApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WebView myWebView = (WebView) findViewById(R.id.webview);
        int id = 1;
        myWebView.loadUrl("https://api.spoonacular.com/recipes/"+id+"/nutritionWidget?apiKey=8ec169c009654ccba8e2b35f98d2079b");

    }
}