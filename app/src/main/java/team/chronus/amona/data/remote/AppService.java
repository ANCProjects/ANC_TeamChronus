package team.chronus.amona.data.remote;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import team.chronus.amona.data.model.Event;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

public interface AppService {

    @GET("/recommended/events")
    Observable<List<Event>> loadRecommendedEventsFromServer(@Query("access_token") String accessToken);

    @GET("/self/events")
    Observable<List<Event>> loadSelfEventsFromServer(@Query("access_token") String accessToken);
}