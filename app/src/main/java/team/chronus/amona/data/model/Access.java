package team.chronus.amona.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

@AutoValue
public abstract class Access {

    public abstract String access_token();
    public abstract String token_type();
    public abstract Long expires_in();
    public abstract String refresh_token();

    public static Builder builder() {
        return new AutoValue_Access.Builder();
    }

    public static TypeAdapter<Access> typeAdapter(Gson gson) {
        return new AutoValue_Access.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder access_token(String access_token);
        public abstract Builder token_type(String token_type);
        public abstract Builder expires_in(Long expires_in);
        public abstract Builder refresh_token(String refresh_token);

        public abstract Access build();
    }



//    @SerializedName("access_token")
//    @Expose
//    private String accessToken;
//    @SerializedName("token_type")
//    @Expose
//    private String tokenType;
//    @SerializedName("expires_in")
//    @Expose
//    private Long expiresIn;
//    @SerializedName("refresh_token")
//    @Expose
//    private String refreshToken;
//
//    public String getAccessToken() {
//        return accessToken;
//    }
//
//    public void setAccessToken(String accessToken) {
//        this.accessToken = accessToken;
//    }
//
//    public String getTokenType() {
//        return tokenType;
//    }
//
//    public void setTokenType(String tokenType) {
//        this.tokenType = tokenType;
//    }
//
//    public Long getExpiresIn() {
//        return expiresIn;
//    }
//
//    public void setExpiresIn(Long expiresIn) {
//        this.expiresIn = expiresIn;
//    }
//
//    public String getRefreshToken() {
//        return refreshToken;
//    }
//
//    public void setRefreshToken(String refreshToken) {
//        this.refreshToken = refreshToken;
//    }

}

