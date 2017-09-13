package team.chronus.amona.data.model.distance;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by ahmed on 8/21/17.
 */
@AutoValue
public abstract class OverviewPolyline {
    public abstract String points();

    public static Builder build(){
        return new AutoValue_OverviewPolyline.Builder();
    }

    public static TypeAdapter<OverviewPolyline> typeAdapter(Gson gson){
        return new AutoValue_OverviewPolyline.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public static abstract class Builder{
        public abstract Builder points(String points);

        public abstract OverviewPolyline build();
    }
}
