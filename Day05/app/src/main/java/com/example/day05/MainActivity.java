package com.example.day05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.day05.db.AppDatabase;
import com.example.day05.db.dao.StudentDao;
import com.example.day05.db.entity.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AppDatabase database = AppDatabase.getDatabaseInstance(this);
        final StudentDao studentDao = database.studentDao();

        TextView hello = findViewById(R.id.main_hello);

        AppDatabase.databaseWriteExecutor.execute(()->{
            String firstName = studentDao.getFirstName(1);
            hello.setText(firstName);
        });

//        Student atul = new Student("Banana","Atul",100);
//        Student eby = new Student("Apple","Eby",99);
//        AppDatabase.databaseWriteExecutor.execute(() ->{
//            studentDao.insert(atul,eby);
//        });
    }
}