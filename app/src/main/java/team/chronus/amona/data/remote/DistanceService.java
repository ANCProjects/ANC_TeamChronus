package team.chronus.amona.data.remote;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import team.chronus.amona.data.model.distance.MeetUpDistance;

/**
 * Created by ahmed on 8/21/17.
 */

public interface DistanceService {
    @GET("directions/json")
    Observable<MeetUpDistance> getDistance(@Query("origin") String origin,
                                           @Query("destination") String destination,
                                           @Query("key") String key);
}
