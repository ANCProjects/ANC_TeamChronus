package team.chronus.amona.data.model.distance;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

/**
 * Created by ahmed on 8/21/17.
 */
@AutoValue
public abstract class Leg {
    public abstract Distance distance();
    public abstract Duration duration();
    public abstract String endAddress();
    public abstract EndLocation endLocation();
    public abstract String startAddress();
    public abstract StartLocation startLocation();
    public abstract List<Steps> steps();
    public abstract List<Object> trafficSpeedEntry();
    public abstract List<Object> viaWaypoint();

    public static Builder build(){
        return new AutoValue_Leg.Builder();
    }

    public static TypeAdapter<Leg> typeAdapter(Gson gson){
        return new AutoValue_Leg.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder{
        public abstract Builder distance(Distance distance);
        public abstract Builder duration(Duration duration);
        public abstract Builder endAddress(String endAddress);
        public abstract Builder endLocation(EndLocation endLocation);
        public abstract Builder startAddress(String startAddress);
        public abstract Builder startLocation(StartLocation startLocation);
        public abstract Builder steps(List<Steps> steps);
        public abstract Builder trafficSpeedEntry(List<Object> trafficSpeedEntry);
        public abstract Builder viaWaypoint(List<Object> viaWaypoint);

        public abstract Leg build();
    }
}
