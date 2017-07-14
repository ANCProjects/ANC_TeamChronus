package team.chronus.amona.data;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import team.chronus.amona.di.ApplicationContext;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

@Singleton
public class AppRepository implements AppDataSource {


    private final Context mContext;
    private final AppDataSource mAppRemoteDataSource;
    private final AppDataSource mAppLocalDataSource;
    private final PreferencesHelper mPreferencesHelper;


    @Inject
    public RecipeRepository(
            @ApplicationContext Context context,
            @Remote RecipeDataSource recipeRemoteDataSource,
            @Local RecipeDataSource recipeLocalDataSource,
            PreferencesHelper preferencesHelper) {

        this.context = context;
        this.recipeRemoteDataSource = recipeRemoteDataSource;
        this.recipeLocalDataSource = recipeLocalDataSource;
        this.preferencesHelper = preferencesHelper;
    }

    @Override
    public Observable<List<Recipe>> getRecipes() {

        if (!preferencesHelper.isRecipeListSynced()) {
            return recipeRemoteDataSource
                    .getRecipes()
                    .compose(RxUtils.applySchedulers())
                    .doOnNext(recipeList -> {
                        recipeLocalDataSource.saveRecipes(recipeList);
                        preferencesHelper.saveRecipeNamesList(recipeList);
                    });
        } else {
            return recipeLocalDataSource
                    .getRecipes()
                    .compose(RxUtils.applySchedulers());
        }
    }

    @Override
    public Observable<List<Ingredient>> getRecipeIngredients(int recipeId) {
        return recipeLocalDataSource
                .getRecipeIngredients(recipeId)
                .compose(RxUtils.applySchedulers());
    }

    @Override
    public Observable<List<Ingredient>> getRecipeIngredients(String recipeName) {
        return recipeLocalDataSource
                .getRecipeIngredients(recipeName)
                .compose(RxUtils.applySchedulers());
    }

    @Override
    public Observable<List<Step>> getRecipeSteps(int recipeId) {
        return recipeLocalDataSource
                .getRecipeSteps(recipeId)
                .compose(RxUtils.applySchedulers());
    }

    @Override
    public void saveRecipes(List<Recipe> recipes) {
        recipeLocalDataSource.saveRecipes(recipes);
    }

    public void markRepoAsSynced(boolean synced) {
        preferencesHelper.setRecipeListSynced(synced);
    }

    public PreferencesHelper getPreferencesHelper() {
        return preferencesHelper;
    }
}
