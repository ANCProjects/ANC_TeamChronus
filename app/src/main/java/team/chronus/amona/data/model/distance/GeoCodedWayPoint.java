package team.chronus.amona.data.model.distance;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

/**
 * Created by ahmed on 8/21/17.
 */
@AutoValue
public abstract class GeoCodedWayPoint {
    public abstract String geocoderStatus();
    public abstract String placeId();
    public abstract List<String> types();

    public static Builder build(){
        return new AutoValue_GeoCodedWayPoint.Builder();
    }

    public static TypeAdapter<GeoCodedWayPoint> typeAdapter(Gson gson){
        return new AutoValue_GeoCodedWayPoint.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder{
        public abstract Builder geocoderStatus(String geocoderStatus);
        public abstract Builder placeId(String placeId);
        public abstract Builder types(List<String> types);

        public abstract GeoCodedWayPoint build();
    }
}
