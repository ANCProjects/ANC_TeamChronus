package team.chronus.amona.data.model.distance;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

/**
 * Created by ahmed on 8/21/17.
 */
@AutoValue
public abstract class MeetUpDistance {
    public abstract List<GeoCodedWayPoint> geocodedWaypoints();
    public abstract List<Route> routes();
    public abstract String status();

    public static Builder build(){
        return new AutoValue_MeetUpDistance.Builder();
    }

    public static TypeAdapter<MeetUpDistance> typeAdapter(Gson gson){
        return new AutoValue_MeetUpDistance.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder{
        public abstract Builder geocodedWaypoints(List<GeoCodedWayPoint> geocodedWaypoints);
        public abstract Builder routes(List<Route> routes);
        public abstract Builder status(String status);

        public abstract MeetUpDistance build();
    }
}
