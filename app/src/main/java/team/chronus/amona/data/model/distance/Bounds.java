package team.chronus.amona.data.model.distance;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by ahmed on 8/21/17.
 */
@AutoValue
public abstract class Bounds {
    public abstract Northeast northeast();
    public abstract Southwest southwest();

    public static Builder build(){
        return new AutoValue_Bounds.Builder();
    }

    public static TypeAdapter<Bounds> typeAdapter(Gson gson){
        return new AutoValue_Bounds.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder{
        public abstract Builder northeast(Northeast northeast);
        public abstract Builder southwest(Southwest southwest);

        public abstract Bounds build();
    }
}
