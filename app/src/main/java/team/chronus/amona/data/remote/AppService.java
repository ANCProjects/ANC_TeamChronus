package team.chronus.amona.data.remote;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

public interface AppService {

    @GET("/topher/2017/May/59121517_baking/baking.json")
    Observable<List<Recipe>> loadRecipesFromServer();
}