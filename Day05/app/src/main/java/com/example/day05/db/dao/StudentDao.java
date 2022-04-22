package com.example.day05.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.day05.db.entity.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("Select * from Student")
    List<Student> getAllStudents();

    @Query("Select fist_name from Student where id= :id")
    String getFirstName(int id);

    @Insert
    void insert(Student... student); //spread :- many student insert
    @Update
    void update(Student student);
    @Delete
    void delete(Student student);

}
