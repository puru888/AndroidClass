package com.example.databasecurd.db.Dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.databasecurd.db.Entities.Register;

import java.util.List;

@Dao
public interface RegisterDao {

    @Insert
    void insert(Register register);
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Register register);

    @Query("select * from Register where email= :email and password= :password")
    Register getData(String email, String password);
    @Query("select * from Register where id= :id")
    Register getData(int id);
}
