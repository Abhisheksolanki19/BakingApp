package com.merchpandas.abhishek.bakingapp.data.remote;

import com.merchpandas.abhishek.bakingapp.data.local.model.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RecipeService {

    @GET("baking.json")
    Call<List<Recipe>> getAllRecipes();
}
