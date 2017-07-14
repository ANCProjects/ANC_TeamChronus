package team.chronus.amona.data;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

public interface AppDataSource {

    Observable<List<Recipe>> getRecipes();

    Observable<List<Ingredient>> getRecipeIngredients(int recipeId);

    Observable<List<Ingredient>> getRecipeIngredients(String recipeName);

    Observable<List<Step>> getRecipeSteps(int recipeId);

    void saveRecipes(List<Recipe> recipes);
}
