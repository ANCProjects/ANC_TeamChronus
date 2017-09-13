package team.chronus.amona.data.model.distance;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

/**
 * Created by ahmed on 8/21/17.
 */
@AutoValue
public abstract class Route {
    public abstract Bounds bounds();
    public abstract String copyrights();
    public abstract List<Leg> legs();
    public abstract OverviewPolyline overviewPolyline();
    public abstract String summary();
    public abstract List<Object> warnings();
    public abstract List<Object> waypointOrder();

    public static Builder build(){
        return new AutoValue_Route.Builder();
    }

    public static TypeAdapter<Route> typeAdapter(Gson gson){
        return new AutoValue_Route.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder{
        public abstract Builder bounds(Bounds bounds);
        public abstract Builder copyrights(String copyrights);
        public abstract Builder legs(List<Leg> legs);
        public abstract Builder overviewPolyline(OverviewPolyline overviewPolyline);
        public abstract Builder summary(String summary);
        public abstract Builder warnings(List<Object> warnings);
        public abstract Builder waypointOrder(List<Object> waypointOrder);

        public abstract Route build();
    }
}
