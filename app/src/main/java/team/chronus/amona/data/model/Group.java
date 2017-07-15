package team.chronus.amona.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

@AutoValue
public abstract class Group {

    public abstract Long created();
    public abstract Integer id();
    public abstract String name();
    public abstract String join_mode();
    public abstract Double lat();
    public abstract Double lon();
    public abstract String urlname();
    public abstract String who();
    public abstract String localized_location();
    public abstract String region();


    public static Builder builder() {
        return new AutoValue_Group.Builder();
    }

    public static TypeAdapter<Group> typeAdapter(Gson gson) {
        return new AutoValue_Group.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder created(Long created);
        public abstract Builder id(Integer id);
        public abstract Builder name(String name);
        public abstract Builder join_mode(String join_mode);
        public abstract Builder lat(Double lat);
        public abstract Builder lon(Double lon);
        public abstract Builder urlname(String urlname);
        public abstract Builder who(String who);
        public abstract Builder localized_location(String localized_location);
        public abstract Builder region(String region);


        public abstract Group build();
    }


//    @SerializedName("created")
//    @Expose
//    private Integer created;
//    @SerializedName("name")
//    @Expose
//    private String name;
//    @SerializedName("id")
//    @Expose
//    private Integer id;
//    @SerializedName("join_mode")
//    @Expose
//    private String joinMode;
//    @SerializedName("lat")
//    @Expose
//    private Double lat;
//    @SerializedName("lon")
//    @Expose
//    private Double lon;
//    @SerializedName("urlname")
//    @Expose
//    private String urlname;
//    @SerializedName("who")
//    @Expose
//    private String who;
//    @SerializedName("localized_location")
//    @Expose
//    private String localizedLocation;
//    @SerializedName("region")
//    @Expose
//    private String region;
//
//    public Integer getCreated() {
//        return created;
//    }
//
//    public void setCreated(Integer created) {
//        this.created = created;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getJoinMode() {
//        return joinMode;
//    }
//
//    public void setJoinMode(String joinMode) {
//        this.joinMode = joinMode;
//    }
//
//    public Double getLat() {
//        return lat;
//    }
//
//    public void setLat(Double lat) {
//        this.lat = lat;
//    }
//
//    public Double getLon() {
//        return lon;
//    }
//
//    public void setLon(Double lon) {
//        this.lon = lon;
//    }
//
//    public String getUrlname() {
//        return urlname;
//    }
//
//    public void setUrlname(String urlname) {
//        this.urlname = urlname;
//    }
//
//    public String getWho() {
//        return who;
//    }
//
//    public void setWho(String who) {
//        this.who = who;
//    }
//
//    public String getLocalizedLocation() {
//        return localizedLocation;
//    }
//
//    public void setLocalizedLocation(String localizedLocation) {
//        this.localizedLocation = localizedLocation;
//    }
//
//    public String getRegion() {
//        return region;
//    }
//
//    public void setRegion(String region) {
//        this.region = region;
//    }
}
