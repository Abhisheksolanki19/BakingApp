package com.merchpandas.abhishek.bakingapp.utils;

import android.content.Context;

import com.merchpandas.abhishek.bakingapp.data.RecipeRepository;
import com.merchpandas.abhishek.bakingapp.data.local.RecipesDatabase;
import com.merchpandas.abhishek.bakingapp.data.remote.ApiClient;
import com.merchpandas.abhishek.bakingapp.data.remote.RecipeService;


public class Injection {
    public static ViewModelFactory provideViewModelFactory(Context context) {
        RecipeRepository repository = provideRecipeRepository(context);
        return ViewModelFactory.getInstance(repository);
    }

    public static RecipeRepository provideRecipeRepository(Context context) {
        RecipeService apiService = ApiClient.getInstance();
        AppExecutors executors = AppExecutors.getInstance();
        RecipesDatabase database = RecipesDatabase.getInstance(context.getApplicationContext());
        return RecipeRepository.getInstance(
                executors,
                apiService,
                database);
    }
}
