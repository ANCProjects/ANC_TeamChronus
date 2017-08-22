package team.chronus.amona.data.model.distance;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by ahmed on 8/21/17.
 */

@AutoValue
public abstract class EndLocation {
    public abstract Float lat();
    public abstract Float lng();

    public static Builder build(){
        return new AutoValue_EndLocation.Builder();
    }

    public static TypeAdapter<EndLocation> typeAdapter(Gson gson){
        return new AutoValue_EndLocation.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder{
        public abstract Builder lat(Float lat);
        public abstract Builder lng(Float lng);

        public abstract EndLocation build();
    }
}
