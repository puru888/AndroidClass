package com.example.phonecall;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private String name = "";
    private String hello = "Hello ";
    private String phoneNumber = "";
    private TextView titleHeader = null;

    private Button register = null;
    private Button logout = null;
    private Button call = null;
    private Button reset = null;
    private int index = 0;

    private int colorArray[] = {Color.WHITE, Color.BLUE, Color.BLACK};
    private ConstraintLayout mainActivityConstraint = null;
    private ConstraintLayout registerActivityConstraint = null;

    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent intent = result.getData();
                    boolean intentHasExtras = intent.hasExtra(RegisterActivity.EXTRA_NAME) && intent.hasExtra(RegisterActivity.EXTRA_PHONE);
                    if (intent != null && intentHasExtras) {
                        name = intent.getStringExtra(RegisterActivity.EXTRA_NAME);
                        phoneNumber = intent.getStringExtra(RegisterActivity.EXTRA_PHONE);
                        if (!call.isEnabled())
                            call.setEnabled(true);
                        titleHeader.setText(hello + name);
                        logout.setVisibility(View.VISIBLE);
                        register.setVisibility(View.INVISIBLE);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleHeader = findViewById(R.id.mainActivity_header_title);
        register = findViewById(R.id.mainActivity_register);
        logout = findViewById(R.id.mainActivity_logout);
        call = findViewById(R.id.mainActivity_call);
        reset = findViewById(R.id.mainActivity_reset);
        mainActivityConstraint = findViewById(R.id.mainActivity_constraint);

        onClickLogout();
        onClickRegister();
        onCallClick();
        onResetClick();
        editDialog();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        setButtonColor();

        switch (item.getItemId()) {
            case R.id.appBarMenu_white:
                mainActivityConstraint.setBackgroundColor(Color.WHITE);
                titleHeader.setTextColor(Color.BLACK);
                break;
            case R.id.appBarMenu_lightBlue:
                mainActivityConstraint.setBackgroundColor(Color.BLUE);
                titleHeader.setTextColor(Color.WHITE);
                break;
            case R.id.appBarMenu_black:
                mainActivityConstraint.setBackgroundColor(Color.BLACK);
                titleHeader.setTextColor(Color.WHITE);
                break;
            case R.id.appbarMenu_item:
                index = (index + 1) % 3;
                if (index == 0) titleHeader.setTextColor(Color.BLACK);
                else if (index == 1 || index == 2) titleHeader.setTextColor(Color.WHITE);
                mainActivityConstraint.setBackgroundColor(colorArray[index]);
                break;
            default:
                throw new UnsupportedOperationException("Operation not created");
        }
        return true;
    }

    private void onClickRegister() {
        register.setOnClickListener(view -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            launcher.launch(intent);
        });
    }
    private void onCallClick() {
        call.setOnClickListener(view -> {
            if (name.length() == 0) {
               Snackbar snackbar =  Snackbar.make(view, "Please register first", Snackbar.LENGTH_LONG);
               snackbar.setAction("Dismiss",(snackView)->{
                        snackbar.dismiss();
               });
               snackbar.show();
                call.setEnabled(false);
            } else {
                Intent implicitIntent = new Intent()
                        .setAction(Intent.ACTION_DIAL)
                        .setData(Uri.parse("tel:" + phoneNumber));
                try {
                    startActivity(implicitIntent);
                } catch (ActivityNotFoundException exception) {
                    Log.e("exception", exception.toString());
                }

            }
        });
    }
    private void onResetClick() {
        reset.setOnClickListener(view -> {
            register.setVisibility(View.VISIBLE);
            logout.setVisibility(View.INVISIBLE);
            name = "";
            phoneNumber = "";
            titleHeader.setText("Please Register");
            titleHeader.setTextColor(Color.BLACK);
            mainActivityConstraint.setBackgroundColor(Color.WHITE);
        });
    }
    private void onClickLogout() {
        logout.setOnClickListener(view -> {
            register.setVisibility(View.VISIBLE);
            logout.setVisibility(View.INVISIBLE);
            name = "";
            phoneNumber = "";
            titleHeader.setText("Please Register");
        });
    }
    private void editDialog() {
        titleHeader.setOnLongClickListener(view -> {
            if (name.length() != 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View customEdit = getLayoutInflater().inflate(R.layout.custom_dialog_edit, null);
                builder.setView(customEdit);
                AlertDialog dialog = builder.create();
                Log.e("TAG", phoneNumber + " " + name);
                customEdit.findViewById(R.id.custom_dialog_edit_apply).setOnClickListener(editView -> {
                    EditText editName = customEdit.findViewById(R.id.custom_dialog_edit_name);
                    EditText editPhone = customEdit.findViewById(R.id.custom_dialog_edit_phone);
                    name = editName.getText().toString();
                    titleHeader.setText(hello + name);
                    phoneNumber = editPhone.getText().toString();
                    dialog.dismiss();
                });
                customEdit.findViewById(R.id.custom_dialog_edit_cancel).setOnClickListener(editView -> {
                    dialog.cancel();
                });
                dialog.show();
            }
            return true;
        });
    }
    private void setButtonColor() {
        register.setBackgroundColor(Color.WHITE);
        call.setBackgroundColor(Color.WHITE);
        logout.setBackgroundColor(Color.WHITE);
        reset.setBackgroundColor(Color.WHITE);
    }
}