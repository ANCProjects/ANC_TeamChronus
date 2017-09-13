package team.chronus.amona.data.model.distance;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;


/**
 * Created by ahmed on 8/21/17.
 */
@AutoValue
public abstract class Distance {
    public abstract String text();
    public abstract Long value();

    public static Builder build(){
        return new AutoValue_Distance.Builder();
    }

    public static TypeAdapter<Distance> typeAdapter(Gson gson){
        return new AutoValue_Distance.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder{
        public abstract Builder text(String text);
        public abstract Builder value(Long value);

        public abstract Distance build();
    }
}
