package com.example.recify.db.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.recify.entities.Recipe;

import java.util.List;

@Dao
public interface RecipeDao {

    @Query("Select * from Recipe")
    LiveData<List<Recipe>> getAllRecipes();

    @Insert
    void insert(Recipe... recipes);
    @Delete
    void delete(Recipe...recipes);
}
