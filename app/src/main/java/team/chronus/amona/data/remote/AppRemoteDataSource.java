package team.chronus.amona.data.remote;

import javax.inject.Inject;

import team.chronus.amona.data.AppDataSource;
import team.chronus.amona.utils.AppLogger;
import team.chronus.amona.utils.RxUtils;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

public class AppRemoteDataSource implements AppDataSource {

    private final AppService mService;

    @Inject
    public AppRemoteDataSource(AppService service) {
        mService = service;
    }

    @Override
    public Observable<List<Recipe>> getRecipes() {
        return service
                .loadRecipesFromServer()
                .compose(RxUtils.applySchedulers())
                .doOnSubscribe(disposable -> AppLogger.d("Sync started..."))
                .doOnError(throwable -> AppLogger.d("Sync failed!"))
                .doOnComplete(() -> AppLogger.d("Sync completed."));
    }

    @Override
    public Observable<List<Ingredient>> getRecipeIngredients(int recipeId) {
        throw new UnsupportedOperationException("getRecipeIngredients in RemoteDataSource is not implemented!");
    }

    @Override
    public Observable<List<Ingredient>> getRecipeIngredients(String recipeName) {
        throw new UnsupportedOperationException("getRecipeIngredients in RemoteDataSource is not implemented!");
    }

    @Override
    public Observable<List<Step>> getRecipeSteps(int recipeId) {
        throw new UnsupportedOperationException("getRecipeSteps in RemoteDataSource is not implemented!");
    }

    @Override
    public void saveRecipes(List<Recipe> recipes) {
        throw new UnsupportedOperationException("saveRecipes in RemoteDataSource is not implemented!");
    }


}
