package com.example.day4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContextMenuActivity extends AppCompatActivity {

    private View viewWithContextMenuInit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        Button a = findViewById(R.id.contextMenu_A);
        Button b = findViewById(R.id.contextMenu_B);
        Button c = findViewById(R.id.contextMenu_C);

        ConstraintLayout cl = findViewById(R.id.contextMenu);

        registerForContextMenu(a);
        registerForContextMenu(c);
     //   registerForContextMenu(cl);

        a.setOnContextClickListener(new View.OnContextClickListener() {
            @Override
            public boolean onContextClick(View v) {
                return false;
            }
        });


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater()
                .inflate(R.menu.random_context_menu, menu);
        viewWithContextMenuInit = v;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.random_contextMenu_edit:
            case R.id.random_contextMenu_hide:
                if (viewWithContextMenuInit instanceof Button){
                    Button btn = (Button) viewWithContextMenuInit;
                    Toast.makeText(this, btn.getText(), Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                throw new UnsupportedOperationException("Not Implemented Context menu");
        }
        return true;
    }


}