package team.chronus.amona.data.model.distance;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by ahmed on 8/21/17.
 */
@AutoValue
public abstract class Steps {
    public abstract Distance distance();
    public abstract Duration duration();
    public abstract EndLocation endLocation();
    public abstract String htmlInstructions();
    public abstract Polyline polyline();
    public abstract StartLocation startLocation();
    public abstract String travelMode();
    public abstract String maneuver();

    public static Builder build(){
        return new AutoValue_Steps.Builder();
    }

    public static TypeAdapter<Steps> typeAdapter(Gson gson){
        return new AutoValue_Steps.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder{
        public abstract Builder distance(Distance distance);
        public abstract Builder duration(Duration duration);
        public abstract Builder endLocation(EndLocation endLocation);
        public abstract Builder htmlInstructions(String htmlInstructions);
        public abstract Builder polyline(Polyline polyline);
        public abstract Builder startLocation(StartLocation startLocation);
        public abstract Builder travelMode(String travelMode);
        public abstract Builder maneuver(String maneuver);

        public abstract Steps build();
    }

}
