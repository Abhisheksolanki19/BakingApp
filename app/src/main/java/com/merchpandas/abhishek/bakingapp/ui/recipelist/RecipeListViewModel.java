package com.merchpandas.abhishek.bakingapp.ui.recipelist;

import com.merchpandas.abhishek.bakingapp.data.RecipeRepository;
import com.merchpandas.abhishek.bakingapp.data.local.model.Recipe;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


public class RecipeListViewModel extends ViewModel {

    private LiveData<List<Recipe>> listLiveData;

    public RecipeListViewModel(RecipeRepository repository) {
        listLiveData = repository.loadAllRecipes();
    }

    public LiveData<List<Recipe>> getListLiveData() {
        return listLiveData;
    }
}
