package com.example.day4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class AppBARActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_baractivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater()
                .inflate(R.menu.random_appbar_menu,menu);
        return true; // shows true shows menu
    }
// Selection events for menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.appBarMenu_android:
                Toast.makeText(this, "Android", Toast.LENGTH_SHORT).show();
                break;
            case R.id.appBarMenu_A:
                Toast.makeText(this, "A", Toast.LENGTH_SHORT).show();
                break;
            case R.id.appBarMenu_B:
                Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
                break;
            case R.id.appBarMenu_B1:
                Toast.makeText(this, "B1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.appBarMenu_B2:
                Toast.makeText(this, "B2", Toast.LENGTH_SHORT).show();
                break;
            default:
                throw new UnsupportedOperationException("New menu item not implemented");
        }
        return true;
    }
}