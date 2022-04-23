package com.example.databasecurd.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.databasecurd.db.Dao.ChatDao;
import com.example.databasecurd.db.Dao.MessageDao;
import com.example.databasecurd.db.Dao.RegisterDao;
import com.example.databasecurd.db.Entities.ChatList;
import com.example.databasecurd.db.Entities.Message;
import com.example.databasecurd.db.Entities.Register;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//todo : Add your entities and change version when DB structure changes
@Database(entities = {Register.class, Message.class, ChatList.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    //todo: Add all your DAO here..
    public abstract RegisterDao registerDao();
    public abstract ChatDao chatDao();
    public abstract MessageDao messageDao();
    private static final int NUMBER_OF_THREADS = 2;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    //singleton

    private static volatile AppDatabase instance;

    public static AppDatabase getDatabaseInstance(final Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "app_database") //Name of Databse in sql
                            .fallbackToDestructiveMigration() //If version changes destroy everything and re-create
                            .build();
                }
            }
        }
        return instance;
    }

}
