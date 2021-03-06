package com.merchpandas.abhishek.bakingapp.data.local.dao;

import com.merchpandas.abhishek.bakingapp.data.local.model.Recipe;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;


@Dao
public interface RecipesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertRecipe(Recipe recipe);

}
