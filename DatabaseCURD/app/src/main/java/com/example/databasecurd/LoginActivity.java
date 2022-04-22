package com.example.databasecurd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.databasecurd.db.AppDatabase;
import com.example.databasecurd.db.Dao.RegisterDao;
import com.example.databasecurd.db.Entities.Register;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "id";
    public static final String EXTRA_FIRST_NAME = "firstName";
    public static final String EXTRA_LAST_NAME = "lastName";
    public static final String EXTRA_PHONE = "phone";
    public static final String EXTRA_ADDRESS = "address";
    public static final String EXTRA_CITY = "city";
    public static final String EXTRA_STATE = "state";
    public static final String EXTRA_ZIP = "zip";
    public static final String EXTRA_EMAIL = "email";
    public static final String EXTRA_PASSWORD = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final AppDatabase appDatabase = AppDatabase.getDatabaseInstance(this);
        final RegisterDao registerDao = appDatabase.registerDao();

        EditText loginEmail = findViewById(R.id.login_email);
        EditText loginPassword = findViewById(R.id.login_password);


        findViewById(R.id.login_loginBtn).setOnClickListener(view -> {
            String email = loginEmail.getText().toString();
            String password = loginPassword.getText().toString();
            appDatabase.getQueryExecutor().execute(()->{
                List<Register> resultData = registerDao.getData(email,password);
                if (!resultData.isEmpty()){
                    Intent intent = new Intent(this,ChatListActivity.class);
//                            .putExtra(EXTRA_ID,resultData.get(0).getId())
//                            .putExtra(EXTRA_FIRST_NAME,resultData.get(0).getFirstName())
//                            .putExtra(EXTRA_LAST_NAME,resultData.get(0).getLastName())
//                            .putExtra(EXTRA_PHONE,resultData.get(0).getPhone())
//                            .putExtra(EXTRA_ADDRESS,resultData.get(0).getAddress())
//                            .putExtra(EXTRA_CITY,resultData.get(0).getCity())
//                            .putExtra(EXTRA_STATE,resultData.get(0).getState())
//                            .putExtra(EXTRA_ZIP,resultData.get(0).getZip())
//                            .putExtra(EXTRA_EMAIL,resultData.get(0).getEmail())
//                            .putExtra(EXTRA_PASSWORD,resultData.get(0).getPassword());
                    startActivity(intent);
                }else{
                   runOnUiThread(()->{
                       Toast.makeText(this,"Invalid Constraint",Toast.LENGTH_SHORT).show();
                   });
                }
            });
        });

        findViewById(R.id.login_RegisterBtn).setOnClickListener(view -> {
            Intent intent = new Intent(this,RegisterActivity.class);
            startActivity(intent);
        });
    }
}